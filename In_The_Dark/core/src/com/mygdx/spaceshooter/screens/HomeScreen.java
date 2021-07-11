package com.mygdx.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.gameui.ButtonBack2;
import com.mygdx.spaceshooter.gameui.ButtonInfo;
import com.mygdx.spaceshooter.gameui.Joystick;
import com.mygdx.spaceshooter.models.GameObject;
import com.mygdx.spaceshooter.models.Home;
import com.mygdx.spaceshooter.models.MyTree;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.models.Portal;


public class HomeScreen implements Screen {


    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;
    BitmapFont font;
    Player player;
    Portal portal;
    Home home;
    Joystick joystick;
    ButtonBack2 buttonBack2;
    ButtonInfo buttonInfo;
    Stage stage;
    GameObject stone1;
    GameObject stone2;
    GameObject stone3;
    GameObject stone4;
    GameObject stone5;
    GameObject girlsHouse;
    MyTree tree1;
    MyTree tree2;
    MyTree tree3;
    MyTree tree4;
    MyTree tree5;

    Array<GameObject> gameObjects;
    Texture buttonToMenu;
    Texture circle;
    Texture curJoystick;
    Texture bg;
    Texture imgHome;
    Texture imgAnimPortal;
    Texture portalFloor;
    Texture imgAnimMove;
    Texture imgAnimMove2;
    Texture imgAnimIdle;
    Texture imgAnimIdle2;
    Texture imgBG;
    Texture imgStone1;
    Texture imgStone2;
    Texture imgStone3;
    Texture imgStone4;
    Texture imgStone5;
    Texture imgGirlsHouse;
    Texture imgGirlsHouse1;
    Texture imgGirlsHouse2;
    Texture imgGirlsHouse3;
    Texture imgTree1;
    Texture imgTree2;
    Texture imgInfoBut;
    Texture imgAnimFire;
    Texture imgAnimWitch;


    TextureRegion trAnimPortal;
    TextureRegion trAnimMove;
    TextureRegion trAnimMove2;
    TextureRegion trAnimIdle;
    TextureRegion trAnimIdle2;
    TextureRegion trAnimFire;
    TextureRegion trAnimWitch;

    Animation animPortal;
    Animation animMove;
    Animation animMove2;
    Animation animIdle;
    Animation animIdle2;
    Animation animFire;
    Animation animWitch;
    Animation animWitch2;



    public HomeScreen(InTheDark game) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Progress.write();
            }
        });

        myThread.start();

        this.game = game;
        camera = new OrthographicCamera(GameScreen.SCR_WIDTH/2f,GameScreen.SCR_HEIGHT/2f);
        camera.setToOrtho(false, GameScreen.SCR_WIDTH/2f,GameScreen.SCR_HEIGHT/2f);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        font = new BitmapFont();
        font.setColor(1,0,0,1);
        font.getData().scale(GameScreen.SCR_WIDTH/3000f);
        circle = new Texture("circletest (2).png");
        buttonToMenu = new Texture("circletest (8).png");
        curJoystick = new Texture("png_cursor.png");
        bg = new Texture("HomeBG.png");
        imgHome = new Texture("Home.png");
        portalFloor = new Texture("portalFloor.png");
        imgAnimPortal = new Texture("portalAnim.png");
        imgAnimMove = new Texture("moveAnim.png");
        imgAnimMove2 = new Texture("moveAnim2.png");
        imgAnimIdle = new Texture("idleAnim.png");
        imgAnimIdle2 = new Texture("idleAnim2.png");
        imgBG = new Texture("BackGround.png");
        imgStone1 = new Texture("stone1.png");
        imgStone2 = new Texture("stone2.png");
        imgStone3 = new Texture("stone3.png");
        imgStone4 = new Texture("stone4.png");
        imgStone5 = new Texture("stone5.png");
        imgGirlsHouse = new Texture("GirlHouse.png");
        imgGirlsHouse1 = new Texture("GirlHouse1.png");
        imgGirlsHouse2 = new Texture("GirlHouse2.png");
        imgGirlsHouse3 = new Texture("GirlHouse3.png");
        imgTree1 = new Texture("tree.png");
        imgTree2 = new Texture("tree2.png");
        imgInfoBut = new Texture("circletest (5).png");
        imgAnimFire = new Texture("animFire2.png");
        imgAnimWitch = new Texture("animWitch.png");




        trAnimPortal = new TextureRegion(imgAnimPortal);
        trAnimMove = new TextureRegion(imgAnimMove);
        trAnimMove2 = new TextureRegion(imgAnimMove2);
        trAnimIdle = new TextureRegion(imgAnimIdle);
        trAnimIdle2 = new TextureRegion(imgAnimIdle2);
        trAnimFire = new TextureRegion(imgAnimFire);
        trAnimWitch = new TextureRegion(imgAnimWitch);

        animPortal = new Animation(trAnimPortal,8,2);
        animMove = new Animation(trAnimMove,4,1);
        animMove2 = new Animation(trAnimMove2,4,1);
        animIdle = new Animation(trAnimIdle,4,1);
        animIdle2 = new Animation(trAnimIdle2,4,1);
        animFire = new Animation(trAnimFire,4,1);
        animWitch = new Animation(trAnimWitch,6,1);
        animWitch2 = new Animation(trAnimWitch,6,1);

        animWitch2.setFrame(3);
        animWitch2.setCurrentFrameTime(500);

        player = new Player();
        player.setHeight(player.getHeight()/2f);
        player.setWidth(player.getWidth()/2f);
        portal = new Portal();
        home = new Home();
        stone1 = new GameObject(GameScreen.SCR_WIDTH * 0.03f, GameScreen.SCR_HEIGHT*0.06f,GameScreen.SCR_WIDTH*0.2f,GameScreen.SCR_HEIGHT*0.2f,false,0,0);
        stone2 = new GameObject(GameScreen.SCR_WIDTH/16f, GameScreen.SCR_HEIGHT - GameScreen.SCR_HEIGHT*0.25f,GameScreen.SCR_WIDTH*0.2f,GameScreen.SCR_HEIGHT*0.2f,false,0,0);
        stone3 = new GameObject(portal.getX(), portal.getY() + portal.getHeight()/4f,GameScreen.SCR_WIDTH/8f,GameScreen.SCR_HEIGHT*0.2f,false,0,0);
        stone4 = new GameObject(portal.getX(), portal.getY()-GameScreen.SCR_HEIGHT*0.15f,GameScreen.SCR_WIDTH/8f,GameScreen.SCR_HEIGHT*0.2f,false,0,0);
        stone5 = new GameObject(GameScreen.SCR_WIDTH * 0.6f, GameScreen.SCR_HEIGHT - GameScreen.SCR_HEIGHT*0.15f,GameScreen.SCR_WIDTH/16f,GameScreen.SCR_HEIGHT/8f,false,0,0);
        girlsHouse = new GameObject(GameScreen.SCR_WIDTH * 0.7875f, GameScreen.SCR_HEIGHT*0.6875f, GameScreen.SCR_WIDTH*0.1875f,GameScreen.SCR_HEIGHT*0.2375f,false,0,0);
       // tree1 = new MyTree(GameScreen.SCR_WIDTH*0.4f,GameScreen.SCR_HEIGHT*0.625f,GameScreen.SCR_WIDTH/40f,GameScreen.SCR_WIDTH/40f);
        tree2 = new MyTree(GameScreen.SCR_WIDTH*0.4f,GameScreen.SCR_HEIGHT*0.075f,GameScreen.SCR_WIDTH/40f,GameScreen.SCR_WIDTH/40f);

        tree3 = new MyTree(GameScreen.SCR_WIDTH*0.75f - GameScreen.SCR_WIDTH/60f,girlsHouse.getY()+girlsHouse.getHeight()/3f,GameScreen.SCR_WIDTH/30f,GameScreen.SCR_WIDTH/30f);
        tree4 = new MyTree(GameScreen.SCR_WIDTH*0.75f,stone3.getY()+stone3.getHeight(),GameScreen.SCR_WIDTH/30f,GameScreen.SCR_WIDTH/30f);
        tree5 = new MyTree(GameScreen.SCR_WIDTH*0.7f,stone4.getY(),GameScreen.SCR_WIDTH/30f,GameScreen.SCR_WIDTH/30f);

        gameObjects = new Array<>();

        gameObjects.add(stone1);
        gameObjects.add(stone2);
        gameObjects.add(stone3);
        gameObjects.add(stone4);
        gameObjects.add(stone5);
        gameObjects.add(girlsHouse);
        gameObjects.add(home);
       // gameObjects.add(tree1);
        gameObjects.add(tree2);
        gameObjects.add(tree3);
        gameObjects.add(tree4);
        gameObjects.add(tree5);

        joystick = new Joystick(circle,curJoystick,player,true);
        joystick.setWidth(joystick.getWidth()/2f);
        buttonBack2 = new ButtonBack2(buttonToMenu,game);
        buttonBack2.setWidth(buttonBack2.getWidth()/2f);
        buttonBack2.setHeight(buttonBack2.getHeight()/2f);
        buttonInfo = new ButtonInfo(imgInfoBut,game,buttonBack2);
        buttonInfo.setHeight(buttonInfo.getHeight()/2f);
        buttonInfo.setWidth(buttonInfo.getWidth()/2f);
        stage = new Stage();
        stage.addActor(joystick);
        stage.addActor(buttonBack2);
        stage.addActor(buttonInfo);

        stage.getViewport().setCamera(camera);
        stage.getViewport().setWorldHeight(GameScreen.SCR_HEIGHT/2f);
        stage.getViewport().setWorldWidth(GameScreen.SCR_WIDTH/2f);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        player.move(gameObjects,player);
        if(player.getY()+player.getHeight()>GameScreen.SCR_HEIGHT) player.setCollidedOnTheFront(true);
        if(player.getY()-player.getHeight()/2f < 0)player.setCollidedOnTheBack(true);
        if(player.getX()+player.getWidth()*2 > GameScreen.SCR_WIDTH)player.setCollidedOnTheRight(true);
        joystick.setX(player.getX()  - GameScreen.SCR_WIDTH/4f + joystick.getWidth()/1.5f);
        joystick.setY(player.getY() - joystick.getHeight());
        buttonBack2.setX(player.getX()  - GameScreen.SCR_WIDTH/5f);
        buttonBack2.setY(player.getY() + GameScreen.SCR_HEIGHT/6f);
        buttonInfo.setX(player.getX() + GameScreen.SCR_WIDTH/5f - buttonInfo.getWidth()/3f);
        buttonInfo.setY(player.getY() + GameScreen.SCR_HEIGHT/6f);

        stage.getViewport().update(GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT,false);
        stage.getViewport().getCamera().position.set(new Vector3(player.getX()+player.getWidth()/2f,player.getY()+player.getHeight()/2f,0));

        stage.getViewport().getCamera().update();
        batch.setProjectionMatrix(camera.combined);

        animPortal.update(delta);
        animMove.update(delta);
        animMove2.update(delta);
        animIdle.update(delta);
        animIdle2.update(delta);
        animFire.update(delta);
        animWitch2.update(delta);
        animWitch.update(delta);


        if(player.overlaps(portal)){
            game.setScreen(new MissionsScreen(game,true));
        }
        if(player.overlaps(girlsHouse)){
            if(!Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin) game.setScreen(new MissionsScreen(game,false));
            if(Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin) game.setScreen(new MissionsScreen(game,false));
            if(Progress.is1lvlWin && Progress.is2lvlWin && !Progress.is3lvlWin) game.setScreen(new MissionsScreen(game,false));
        }

        if(player.overlaps(home)){
            game.setScreen(new SkillTreeScreen(game));
        }

        batch.begin();
        batch.draw(imgBG,-GameScreen.SCR_WIDTH*2f,-GameScreen.SCR_HEIGHT*2f,GameScreen.SCR_WIDTH*5f,GameScreen.SCR_HEIGHT*5f);
        batch.draw(bg,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);
        batch.draw(portalFloor,portal.getX(),portal.getY()-portal.getWidth()/2f,portal.getWidth(),portal.getWidth());

        batch.draw(imgStone1,stone1.getX(),stone1.getY(),stone1.getWidth(),stone1.getHeight());
        batch.draw(imgStone2,stone2.getX(),stone2.getY(),stone2.getWidth(),stone2.getHeight());
        batch.draw(imgStone3,stone3.getX(),stone3.getY(),stone3.getWidth(),stone3.getHeight());
        batch.draw(imgStone4,stone4.getX(),stone4.getY(),stone4.getWidth(),stone4.getHeight());
        batch.draw(imgStone5,stone5.getX(),stone5.getY(),stone5.getWidth(),stone5.getHeight());

        if(!Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin) batch.draw(imgGirlsHouse1,girlsHouse.getX(),girlsHouse.getY(),girlsHouse.getWidth(),girlsHouse.getHeight());
        if(Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin) batch.draw(imgGirlsHouse2,girlsHouse.getX(),girlsHouse.getY(),girlsHouse.getWidth(),girlsHouse.getHeight());
        if(Progress.is1lvlWin && Progress.is2lvlWin && !Progress.is3lvlWin) batch.draw(imgGirlsHouse3,girlsHouse.getX(),girlsHouse.getY(),girlsHouse.getWidth(),girlsHouse.getHeight());
        if(Progress.is1lvlWin && Progress.is2lvlWin && Progress.is3lvlWin)  batch.draw(imgGirlsHouse,girlsHouse.getX(),girlsHouse.getY(),girlsHouse.getWidth(),girlsHouse.getHeight());

        batch.draw(animWitch.getFrame(),girlsHouse.getX(),girlsHouse.getY() + girlsHouse.getHeight()/2f - girlsHouse.getHeight()/15f,girlsHouse.getWidth()/7.5f,girlsHouse.getHeight()/2.5f);
        batch.draw(animWitch2.getFrame(),girlsHouse.getX() + girlsHouse.getWidth()/3f,girlsHouse.getY() + girlsHouse.getHeight()/2f - girlsHouse.getHeight()/15f,girlsHouse.getWidth()/7.5f,girlsHouse.getHeight()/2.5f);
        batch.draw(animWitch.getFrame(),girlsHouse.getX() + girlsHouse.getWidth()/2f,girlsHouse.getY() + girlsHouse.getHeight()/15f,girlsHouse.getWidth()/7.5f,girlsHouse.getHeight()/2.5f);
        batch.draw(animFire.getFrame(),girlsHouse.getX() + girlsHouse.getWidth()/5f, girlsHouse.getY() + girlsHouse.getHeight()/5f, girlsHouse.getWidth()/5f, girlsHouse.getHeight()/3f);

        batch.draw(imgHome,home.getX(),home.getY(),home.getWidth(),home.getHeight());

        batch.draw(animPortal.getFrame(),portal.getX(),portal.getY(),portal.getWidth(),portal.getHeight());

        if (player.getVx() == 0 && player.getVy() == 0) {
            if ((player.getRotation() > 0 && player.getRotation() <= 180))
                batch.draw(animIdle2.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
            if ((player.getRotation() > -180 && player.getRotation() <= 0))
                batch.draw(animIdle.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }else{
            if ((player.getRotation() > 0 && player.getRotation() <= 180))
                batch.draw(animMove2.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
            if ((player.getRotation() > -180 && player.getRotation() <= 0))
                batch.draw(animMove.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }




       // batch.draw(imgTree1,tree1.getX() - tree1.getWidth(),tree1.getY(),tree1.getWidth()*3,tree1.getHeight()*5);
        batch.draw(imgTree1,tree2.getX() - tree2.getWidth(),tree2.getY(),tree2.getWidth()*3,tree2.getHeight()*5);
        batch.draw(imgTree2,tree3.getX() - tree3.getWidth(),tree3.getY(),tree3.getWidth()*3,tree3.getHeight()*3);
        batch.draw(imgTree2,tree4.getX() - tree4.getWidth(),tree4.getY(),tree4.getWidth()*3,tree4.getHeight()*3);
        batch.draw(imgTree2,tree5.getX() - tree5.getWidth(),tree5.getY(),tree5.getWidth()*3,tree5.getHeight()*3);

        font.draw(batch, "LVL: " + Progress.lvlPlayer, player.getX(), player.getY() + player.getHeight() + 10);
        batch.end();

        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());
    }



    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        buttonToMenu.dispose();
        imgAnimPortal.dispose();
        imgAnimMove.dispose();
        imgAnimMove2.dispose();
        imgAnimIdle.dispose();
        imgAnimIdle2.dispose();
        imgStone1.dispose();
        imgStone2.dispose();
        imgStone3.dispose();
        imgStone4.dispose();
        imgStone5.dispose();
        imgGirlsHouse.dispose();
        imgTree1.dispose();
        imgTree2.dispose();
        bg.dispose();
        imgHome.dispose();
        circle.dispose();
        curJoystick.dispose();
        imgInfoBut.dispose();
        imgAnimFire.dispose();
        imgAnimWitch.dispose();
    }
}
