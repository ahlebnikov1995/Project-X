package com.mygdx.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.gameui.Joystick;
import com.mygdx.spaceshooter.models.GameObject;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.models.Portal;

public class Lvl3Screen implements Screen {



    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Player player;
    Portal portal;
    Portal portal2;
    Joystick joystick;
    Stage stage;
    GameObject stone5;
    GameObject stone6;
    GameObject den;
    GameObject stone1;
    GameObject stone2;
    GameObject stone3;
    GameObject stone4;


    Array<GameObject> gameObjects;
    Texture circle;
    Texture curJoystick;
    Texture blackFone;
    Texture bg;
    Texture imgDen;
    Texture imgDen2;
    Texture imgTree;
    Texture imgTree2;
    Texture imgTree3;
    Texture imgAnimPortal;
    Texture imgAnimPortal2;
    Texture imgAnimMove;
    Texture imgAnimMove2;
    Texture imgAnimIdle;
    Texture imgAnimIdle2;
    Texture imgStone1;
    Texture imgStone2;

    TextureRegion trAnimPortal;
    TextureRegion trAnimPortal2;
    TextureRegion trAnimMove;
    TextureRegion trAnimMove2;
    TextureRegion trAnimIdle;
    TextureRegion trAnimIdle2;

    Animation animPortal;
    Animation animPortal2;
    Animation animMove;
    Animation animMove2;
    Animation animIdle;
    Animation animIdle2;

    boolean boss1IsDefeated;
    boolean boss2IsDefeated;


    public Lvl3Screen(InTheDark game) {
        this.game = game;
        boss1IsDefeated = false;
        boss2IsDefeated = false;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameScreen.SCR_WIDTH/2f,GameScreen.SCR_HEIGHT/2f);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        stage = new Stage();
        stage.getViewport().setCamera(camera);
        stage.getViewport().setWorldHeight(GameScreen.SCR_HEIGHT/2f);
        stage.getViewport().setWorldWidth(GameScreen.SCR_WIDTH/2f);

        circle = new Texture("circletest (2).png");
        curJoystick = new Texture("png_cursor.png");
        bg = new Texture("Lvl3BG.png");
        blackFone = new Texture("BackGround.png");
        imgDen = new Texture("den.png");
        imgDen2 = new Texture("den2.png");
        imgTree = new Texture("tree4.png");
        imgTree2 = new Texture("tree5.png");
        imgTree3 = new Texture("tree3.png");
        imgAnimPortal = new Texture("portalAnim.png");
        imgAnimPortal2 = new Texture("portalAnim2.png");
        imgAnimMove = new Texture("moveAnim.png");
        imgAnimMove2 = new Texture("moveAnim2.png");
        imgAnimIdle = new Texture("idleAnim.png");
        imgAnimIdle2 = new Texture("idleAnim2.png");
        imgStone1 = new Texture("Lvl3Stone1.png");
        imgStone2 = new Texture("Lvl3Stone2.png");


        trAnimPortal = new TextureRegion(imgAnimPortal);
        trAnimPortal2 = new TextureRegion(imgAnimPortal2);
        trAnimMove = new TextureRegion(imgAnimMove);
        trAnimMove2 = new TextureRegion(imgAnimMove2);
        trAnimIdle = new TextureRegion(imgAnimIdle);
        trAnimIdle2 = new TextureRegion(imgAnimIdle2);

        animPortal = new Animation(trAnimPortal,8,2);
        animPortal2 = new Animation(trAnimPortal2,8,2);
        animMove = new Animation(trAnimMove,4,1);
        animMove2 = new Animation(trAnimMove2,4,1);
        animIdle = new Animation(trAnimIdle,4,1);
        animIdle2 = new Animation(trAnimIdle2,4,1);



        player = new Player();
        player.setHeight(player.getHeight()/2f);
        player.setWidth(player.getWidth()/2f);

        stone5 = new GameObject(GameScreen.SCR_WIDTH - GameScreen.SCR_WIDTH*0.15f,GameScreen.SCR_HEIGHT*0.2f,GameScreen.SCR_WIDTH*0.15f,GameScreen.SCR_HEIGHT*0.375f,false,0,0);
        stone6 = new GameObject(0,GameScreen.SCR_HEIGHT*0.3125f,GameScreen.SCR_WIDTH*0.15f,GameScreen.SCR_HEIGHT*0.375f,false,0,0);


        portal = new Portal();
        portal.setY(stone5.getY() + stone5.getHeight()/2f - portal.getHeight()/2f);
        portal.setX(stone5.getX() - portal.getWidth());

        portal2 = new Portal();
        portal2.setY(stone6.getY() + stone6.getHeight()/2f - portal2.getHeight()/2f);
        portal2.setX(stone6.getX() + stone6.getWidth() - portal2.getWidth()/2f);

        joystick = new Joystick(circle,curJoystick,player,true);
        joystick.setWidth(joystick.getWidth()/2f);
        den = new GameObject(GameScreen.SCR_WIDTH/2f - GameScreen.SCR_WIDTH*0.375f/2f, GameScreen.SCR_HEIGHT - GameScreen.SCR_HEIGHT/3f, GameScreen.SCR_WIDTH*0.375f, GameScreen.SCR_HEIGHT/3f,false,0,0);

        stage.addActor(joystick);
        Gdx.input.setInputProcessor(stage);

        gameObjects = new Array<>();

        gameObjects.add(stone5);
        gameObjects.add(stone6);
        gameObjects.add(den);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.input.setInputProcessor(stage);
        player.move(gameObjects,player);

        if(player.getY()+player.getHeight()>GameScreen.SCR_HEIGHT) player.setCollidedOnTheFront(true);
        if(player.getY()-player.getHeight()/2f < 0)player.setCollidedOnTheBack(true);
        if(player.getX()+player.getWidth()+player.getWidth()/2f > GameScreen.SCR_WIDTH)player.setCollidedOnTheRight(true);
        if(player.getX()-player.getWidth()/2f < 0) player.setCollidedOnTheLeft(true);

        if(portal.overlaps(player)) game.setScreen(new Lvl3Boss1Screen(game,this));
        if(portal2.overlaps(player)) game.setScreen(new Lvl3Boss2Screen(game,this));
        if(boss1IsDefeated && boss2IsDefeated && den.overlaps(player)) game.setScreen(new FinalBossScreen(game));

        joystick.setX(player.getX()  - GameScreen.SCR_WIDTH/4f + joystick.getWidth()/1.5f);
        joystick.setY(player.getY() - joystick.getHeight());
        stage.getViewport().update(GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT,false);
        stage.getViewport().getCamera().position.set(new Vector3(player.getX()+player.getWidth()/2f,player.getY()+player.getHeight()/2f,0));

        stage.getViewport().getCamera().update();


        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(blackFone,-GameScreen.SCR_WIDTH*2f,-GameScreen.SCR_HEIGHT*2f,GameScreen.SCR_WIDTH*5f,GameScreen.SCR_HEIGHT*5f);
        batch.draw(bg,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);

        if(boss1IsDefeated && boss2IsDefeated){
            batch.draw(imgDen,den.getX(),den.getY(),den.getWidth(),den.getHeight());
        }else {
            batch.draw(imgDen2, den.getX(), den.getY(), den.getWidth(), den.getHeight());
        }
        batch.draw(imgStone1, stone5.getX(), stone5.getY(),stone5.getWidth(),stone5.getHeight());
        batch.draw(imgStone2, stone6.getX(), stone6.getY(), stone6.getWidth(), stone6.getHeight());
        batch.draw(animPortal.getFrame(),portal.getX(),portal.getY(),portal.getWidth(),portal.getHeight());
        batch.draw(animPortal2.getFrame(),portal2.getX(),portal2.getY(),portal2.getWidth(),portal2.getHeight());



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




        batch.end();

        stage.draw();

        animPortal.update(delta);
        animPortal2.update(delta);
        animIdle.update(delta);
        animIdle2.update(delta);
        animMove.update(delta);
        animMove2.update(delta);


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
        circle.dispose();
        curJoystick.dispose();
        bg.dispose();
        imgDen.dispose();
        imgDen2.dispose();
        imgTree.dispose();
        imgTree2.dispose();
        imgTree3.dispose();
        imgAnimPortal.dispose();
        imgAnimPortal2.dispose();
        imgAnimIdle.dispose();
        imgAnimIdle2.dispose();
        imgAnimMove.dispose();
        imgAnimMove2.dispose();
    }

    public boolean isBoss1IsDefeated() {
        return boss1IsDefeated;
    }

    public void setBoss1IsDefeated(boolean boss1IsDefeated) {
        this.boss1IsDefeated = boss1IsDefeated;
    }

    public boolean isBoss2IsDefeated() {
        return boss2IsDefeated;
    }

    public void setBoss2IsDefeated(boolean boss2IsDefeated) {
        this.boss2IsDefeated = boss2IsDefeated;
    }

    public Player getPlayer() {
        return player;
    }
}
