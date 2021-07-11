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
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.gameui.ButtonShield;
import com.mygdx.spaceshooter.gameui.ButtonStar;
import com.mygdx.spaceshooter.gameui.Joystick;
import com.mygdx.spaceshooter.gameui.JoystickAttack;
import com.mygdx.spaceshooter.models.GameObject;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.models.enemys.Boss1;
import com.mygdx.spaceshooter.models.shoots.Fireball;
import com.mygdx.spaceshooter.models.shoots.Shoot;

import static com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT;
import static com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH;

public class Lvl3Boss1Screen implements Screen {

    InTheDark game;
    Lvl3Screen screen;

    long lastShootTime;
    long shootInterval = 500;
    long defeatTime;
    long defeatInterval = 1000;

    SpriteBatch batch;
    BitmapFont font;
    BitmapFont fontB;
    OrthographicCamera camera;
    Stage stage;

    Texture bg;
    Texture blackFone;
    Texture circle;
    Texture circleStars;
    Texture circleShield;
    Texture curJoystick;
    Texture imgAnimIdle;
    Texture imgAnimIdle2;
    Texture imgAnimMove;
    Texture imgAnimMove2;
    Texture imgAnimAttack;
    Texture imgAnimAttack2;
    Texture imgAnimDeath;
    Texture imgAnimDeath2;
    Texture imgAnimFB;
    Texture imgBossAnimMove;
    Texture imgBossAnimMove2;
    Texture imgBossAnimAttack;
    Texture imgBossAnimAttack2;
    Texture imgBossShell;
    Texture imgBossAnimShoot;
    Texture imgBossAnimShoot2;
    Texture imgAnimShield;

    TextureRegion trAnimAttack;
    TextureRegion trAnimAttack2;
    TextureRegion trAnimDeath;
    TextureRegion trAnimDeath2;
    TextureRegion trAnimFB;
    TextureRegion trAnimIdle;
    TextureRegion trAnimIdle2;
    TextureRegion trAnimMove;
    TextureRegion trAnimMove2;
    TextureRegion trBossAnimMove;
    TextureRegion trBossAnimMove2;
    TextureRegion trBossAnimAttack;
    TextureRegion trBossAnimAttack2;
    TextureRegion trBossShell;
    TextureRegion trBossAnimShoot;
    TextureRegion trBossAnimShoot2;
    TextureRegion trAnimShield;

    Animation animationAttack;
    Animation animationAttack2;
    Animation animationDeath;
    Animation animationDeath2;
    Animation animationIdle;
    Animation animationIdle2;
    Animation animationMove;
    Animation animationMove2;
    Animation animationBossMove;
    Animation animationBossMove2;
    Animation animationBossAttack;
    Animation animationBossAttack2;
    Animation animationBossShoot;
    Animation animationBossShoot2;
    Animation animationShield;


    Player player;
    Boss1 boss;
    Joystick joystick;
    JoystickAttack joystickAttack;
    ButtonStar buttonStar;
    ButtonShield buttonShield;
    GameObject stone1;
    GameObject stone2;
    GameObject stone3;
    GameObject stone4;
    Array<GameObject> gameObjects;
    Array<Fireball> shoots = new Array<>();
    Array<Shoot> bossShoots = new Array<>();

    int hpP = (int)((Progress.lvlPlayer * 10 + (Progress.lvlPlayer * 10 * 0.1f * Progress.Talent.encHP))*(1+Progress.Talent.doubleHP_DMG));
    boolean isgame;


    public Lvl3Boss1Screen(InTheDark game, Lvl3Screen screen) {
        this.game = game;
        this.screen = screen;
        screen.setBoss1IsDefeated(true);
        isgame = true;

        batch = new SpriteBatch();
        font = new BitmapFont();
        fontB = new BitmapFont();
        font.setColor(1,0,0,1);
        font.getData().scale(GameScreen.SCR_WIDTH/3000f);
        fontB.setColor(0,0,0,1);
        fontB.getData().scale(GameScreen.SCR_WIDTH/1500f);



        bg = new Texture("lvl3_boss1.png");
        blackFone = new Texture("BackGround.png");
        circle = new Texture("circletest (2).png");
        circleStars = new Texture("circletest (3).png");
        circleShield = new Texture("circletest (4).png");
        curJoystick = new Texture("png_cursor.png");
        imgAnimMove = new Texture("moveAnim.png");
        imgAnimMove2 = new Texture("moveAnim2.png");
        imgAnimIdle = new Texture("idleAnim.png");
        imgAnimIdle2 = new Texture("idleAnim2.png");
        imgAnimAttack = new Texture("AttackAnimation.png");
        imgAnimAttack2 = new Texture("AttackAnimation2.png");
        imgAnimDeath = new Texture("AnimationDeath.png");
        imgAnimDeath2 = new Texture("AnimationDeath2.png");
        imgAnimFB = new Texture("AnimationFB.png");
        imgBossAnimMove = new Texture("Boss1Run.png");
        imgBossAnimMove2 = new Texture("Boss1Run2.png");
        imgBossAnimAttack = new Texture("Boss1Attack.png");
        imgBossAnimAttack2 = new Texture("Boss1Attack2.png");
        imgBossShell = new Texture("Attack1(shell).png");
        imgBossAnimShoot = new Texture("Boss1Shoot.png");
        imgBossAnimShoot2 = new Texture("Boss1Shoot2.png");
        imgAnimShield = new Texture("AnimShield.png");

        trAnimMove = new TextureRegion(imgAnimMove);
        trAnimMove2 = new TextureRegion(imgAnimMove2);
        trAnimIdle = new TextureRegion(imgAnimIdle);
        trAnimIdle2 = new TextureRegion(imgAnimIdle2);
        trAnimAttack = new TextureRegion(imgAnimAttack);
        trAnimAttack2 = new TextureRegion(imgAnimAttack2);
        trAnimDeath = new TextureRegion(imgAnimDeath);
        trAnimDeath2 = new TextureRegion(imgAnimDeath2);
        trAnimFB = new TextureRegion(imgAnimFB);
        trBossAnimMove = new TextureRegion(imgBossAnimMove);
        trBossAnimMove2 = new TextureRegion(imgBossAnimMove2);
        trBossAnimAttack = new TextureRegion(imgBossAnimAttack);
        trBossAnimAttack2 = new TextureRegion(imgBossAnimAttack2);
        trBossShell = new TextureRegion(imgBossShell);
        trBossAnimShoot = new TextureRegion(imgBossAnimShoot);
        trBossAnimShoot2 = new TextureRegion(imgBossAnimShoot2);
        trAnimShield = new TextureRegion(imgAnimShield);

        animationAttack = new Animation(trAnimAttack,3, 0.7f);
        animationAttack2 = new Animation(trAnimAttack2,3,0.7f);
        animationDeath = new Animation(trAnimDeath, 4,1.3f);
        animationDeath2 = new Animation(trAnimDeath2, 4,1.3f);
        animationIdle = new Animation(trAnimIdle,4,1);
        animationIdle2 = new Animation(trAnimIdle2,4,1);
        animationMove = new Animation(trAnimMove,4,1);
        animationMove2 = new Animation(trAnimMove2,4,1);

        animationBossMove = new Animation(trBossAnimMove,8,2);
        animationBossMove2 = new Animation(trBossAnimMove2,8,2);
        animationBossAttack = new Animation(trBossAnimAttack,8,0.5f);
        animationBossAttack2 = new Animation(trBossAnimAttack2,8,0.5f);
        animationBossShoot = new Animation(trBossAnimShoot,5,1);
        animationBossShoot2 = new Animation(trBossAnimShoot2,5,1);
        animationShield = new Animation(trAnimShield,5,1);

        player = new Player();
        player.setHeight(player.getHeight()/2f);
        player.setWidth(player.getWidth()/2f);
        player.setX(GameScreen.SCR_WIDTH/2f - player.getWidth()/2f);
        player.setY(GameScreen.SCR_HEIGHT - player.getHeight()*3);
        boss = new Boss1(player,animationBossAttack,animationBossAttack2,animationBossMove,animationBossMove2,animationBossShoot,animationBossShoot2);
        boss.setHeight(boss.getHeight()/2f);
        boss.setWidth(boss.getWidth()/2f);
        boss.setX(GameScreen.SCR_WIDTH/2f - boss.getWidth()/2f);
        boss.setY(player.getHeight()*3);
        joystick = new Joystick(circle,curJoystick,player,true);
        joystickAttack = new JoystickAttack(this,circle,curJoystick,player);
        buttonStar = new ButtonStar(this,circleStars,player);
        buttonShield = new ButtonShield(circleShield,player);
        joystick.setWidth(joystick.getWidth()/2f);
        joystickAttack.setWidth(joystickAttack.getWidth()/2f);
        buttonStar.setWidth(buttonStar.getWidth()/2f);
        buttonShield.setWidth(buttonShield.getWidth()/2f);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,GameScreen.SCR_WIDTH/2f,GameScreen.SCR_HEIGHT/2f);
        stage = new Stage();
        stage.addActor(joystick);
        stage.addActor(joystickAttack);
        if(Progress.Talent.isStar) stage.addActor(buttonStar);
        if(Progress.Talent.isShield) stage.addActor(buttonShield);

        stage.getViewport().setCamera(camera);
        stage.getViewport().setWorldHeight(GameScreen.SCR_HEIGHT/2f);
        stage.getViewport().setWorldWidth(GameScreen.SCR_WIDTH/2f);

        Gdx.input.setInputProcessor(stage);

        stone1 = new GameObject(0,-GameScreen.SCR_HEIGHT,GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/8f,false,0,0);
        stone2 = new GameObject(0,GameScreen.SCR_HEIGHT-stone1.getHeight(),GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/10f,false,0,0);
        stone3 = new GameObject(GameScreen.SCR_WIDTH - stone1.getWidth(),GameScreen.SCR_HEIGHT-stone1.getHeight(),GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/10f,false,0,0);
        stone4 = new GameObject(GameScreen.SCR_WIDTH - stone1.getWidth(),-GameScreen.SCR_HEIGHT,GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/10f,false,0,0);
        gameObjects = new Array<>();

        gameObjects.add(stone1);
        gameObjects.add(stone2);
        gameObjects.add(stone3);
        gameObjects.add(stone4);

    }

    @Override
    public void show() {

    }

    public void spawnShoots(){
        player.setLastStar(TimeUtils.millis());
        Fireball fb1 = new Fireball(player, -1, 1, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        Fireball fb2 = new Fireball(player, 0, 1, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        Fireball fb3 = new Fireball(player, 1, 1, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        Fireball fb4 = new Fireball(player, -1, 0, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        Fireball fb5 = new Fireball(player, 1, 0, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        Fireball fb6 = new Fireball(player, -1, -1, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        Fireball fb7 = new Fireball(player, 0, -1, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        Fireball fb8 = new Fireball(player, 1, -1, 0, 0, GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f));
        fb1.setWidth(fb1.getWidth() /2f);
        fb1.setHeight(fb1.getHeight() /2f);

        fb2.setWidth(fb2.getWidth() /2f);
        fb2.setHeight(fb2.getHeight() /2f);

        fb3.setWidth(fb3.getWidth() /2f);
        fb3.setHeight(fb3.getHeight() /2f);

        fb4.setWidth(fb4.getWidth() /2f);
        fb4.setHeight(fb4.getHeight() /2f);

        fb5.setWidth(fb5.getWidth() /2f);
        fb5.setHeight(fb5.getHeight() /2f);

        fb6.setWidth(fb6.getWidth() /2f);
        fb6.setHeight(fb6.getHeight() /2f);

        fb7.setWidth(fb7.getWidth() /2f);
        fb7.setHeight(fb7.getHeight() /2f);

        fb8.setWidth(fb8.getWidth() /2f);
        fb8.setHeight(fb8.getHeight() /2f);

        shoots.add(fb1);
        shoots.add(fb2);
        shoots.add(fb3);
        shoots.add(fb4);
        shoots.add(fb5);
        shoots.add(fb6);
        shoots.add(fb7);
        shoots.add(fb8);


    }

    public void spawnShoot(float dx, float dy) {
        if (player.isAlive() && TimeUtils.millis() - lastShootTime > shootInterval) {
            //Array<EnemyWarrior> array = new Array<>();

            animationAttack.setFrame(1);
            animationAttack.setCurrentFrameTime(0);
            animationAttack2.setFrame(1);
            animationAttack2.setCurrentFrameTime(0);

            if (dx < 0) {
                animationAttack2.setStart(true);
            } else {
                animationAttack.setStart(true);
            }

            Fireball newShoot = new Fireball(player, dx, dy, 0, 0, GameScreen.SCR_WIDTH / 90f, new Animation(trAnimFB, 4, 0.5f)); // подаются главный герой, последние ненулевые значения положения джойстика, скорости по х и у заднего фона и относительная скорость полета снаряда
            newShoot.setWidth(newShoot.getWidth() /2f);
            newShoot.setHeight(newShoot.getHeight() /2f);
            newShoot.setY(newShoot.getY() + newShoot.getWidth());
            shoots.add(newShoot);
            lastShootTime = TimeUtils.millis();
        }
    }

    void spawnBossShoot(Boss1 boss, float dx,float dy){
        bossShoots.add(new Shoot(boss, dx,dy,0,0,GameScreen.SCR_WIDTH/150f, GameScreen.SCR_WIDTH/40f, GameScreen.SCR_WIDTH/20f));


    }

    @Override
    public void render(float delta) {
        player.move(gameObjects, player);


        if(player.getHp() <= 0 && player.isAlive()) gameOver();

        if (player.getY() + player.getHeight() * 2 > GameScreen.SCR_HEIGHT)
            player.setCollidedOnTheFront(true);
        if (player.getY() - player.getHeight() * 1.1f < -GameScreen.SCR_HEIGHT)
            player.setCollidedOnTheBack(true);
        if (player.getX() + player.getWidth() * 2 + player.getWidth() > GameScreen.SCR_WIDTH)
            player.setCollidedOnTheRight(true);
        if (player.getX() - player.getWidth() * 2 < 0)
            player.setCollidedOnTheLeft(true);


        for (int i = 0; i < shoots.size; i++) {
            shoots.get(i).setVx(shoots.get(i).getDvx()/2f);
            shoots.get(i).setVy(shoots.get(i).getDvy()/2f);
            shoots.get(i).move();

            if(boss != null) {
                if (shoots.get(i).overlaps(boss) && !shoots.get(i).getCausedDamage()) {
                    boss.setHp(boss.getHp() - player.getDmg());
                    shoots.get(i).setCausedDamage(true);
                    shoots.get(i).setDvx(0);
                    shoots.get(i).setDvy(0);
                    shoots.get(i).setLastCausedDamage(TimeUtils.millis());
                }
            }

            if (shoots.get(i).getY() + player.getHeight() > GameScreen.SCR_HEIGHT && !shoots.get(i).getCausedDamage()) {
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
            }

            if (shoots.get(i).getY() - player.getHeight() / 2f < -GameScreen.SCR_HEIGHT && !shoots.get(i).getCausedDamage()) {
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
            }

            if (shoots.get(i).getX() + player.getWidth() + player.getWidth() / 2f > GameScreen.SCR_WIDTH && !shoots.get(i).getCausedDamage()) {
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
            }

            if (shoots.get(i).getX() - player.getWidth() / 2f < 0 && !shoots.get(i).getCausedDamage()) {
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
            }

            if (TimeUtils.millis() - shoots.get(i).getLastCausedDamage() > 500 && shoots.get(i).getCausedDamage()) {
                shoots.get(i).setAlive(false);
            }

            if (!shoots.get(i).isAlive()) shoots.removeIndex(i);
        }
        for (int i = 0; i < bossShoots.size; i++) {
            bossShoots.get(i).setVx(bossShoots.get(i).getDvx()/2f);
            bossShoots.get(i).setVy(bossShoots.get(i).getDvy()/2f);
            bossShoots.get(i).move();

            if (bossShoots.get(i).overlaps(player)) {
                if(player.isInShield()){
                    player.setK(player.getK()+1);
                    bossShoots.get(i).setAlive(false);
                }else {
                    player.setHp(player.getHp() - 50);
                    bossShoots.get(i).setAlive(false);
                }
            }

            if (bossShoots.get(i).getY() + player.getHeight() > GameScreen.SCR_HEIGHT) {
                bossShoots.get(i).setAlive(false);
            }

            if (bossShoots.get(i).getY() - player.getHeight() / 2f < -GameScreen.SCR_HEIGHT) {
                bossShoots.get(i).setAlive(false);
            }

            if (bossShoots.get(i).getX() + player.getWidth() + player.getWidth() / 2f > GameScreen.SCR_WIDTH) {
                bossShoots.get(i).setAlive(false);
            }

            if (bossShoots.get(i).getX() - player.getWidth() / 2f < 0) {
                bossShoots.get(i).setAlive(false);
            }


            if (!bossShoots.get(i).isAlive()) bossShoots.removeIndex(i);
        }




        joystick.setX(player.getX()  - GameScreen.SCR_WIDTH/4f + joystick.getWidth()/1.5f);
        joystick.setY(player.getY() - joystick.getHeight());
        joystickAttack.setX(player.getX() + player.getWidth() + (player.getX() - (joystick.getX() + joystick.getWidth())) + joystick.getWidth()/7f);
        joystickAttack.setY(player.getY() - joystickAttack.getHeight() );
        buttonStar.setX(joystickAttack.getX() - GameScreen.SCR_WIDTH/20f);
        buttonStar.setY(joystickAttack.getY());
        buttonShield.setX(buttonStar.getX() + buttonStar.getWidth()/2f);
        buttonShield.setY(joystickAttack.getY() + joystickAttack.getHeight() - buttonShield.getWidth()/6f);
            stage.getViewport().update(GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT,false);
            stage.getViewport().getCamera().position.set(new Vector3(player.getX()+player.getWidth()/2f,player.getY()+player.getHeight()/2f,0));

            stage.getViewport().getCamera().update();



            if(boss != null &&
                    (TimeUtils.millis() - boss.getLastShootTime() > 6000) &&
                    (boss.getX() > 0 - boss.getWidth() && boss.getX() < GameScreen.SCR_WIDTH && boss.getY() > 0 - boss.getHeight() && boss.getY() < GameScreen.SCR_HEIGHT) &&
                    !boss.isInAttack()) {
                boss.setInShoot(true);
                boss.setLastShootTime(TimeUtils.millis());
                boss.getAnimShoot().setCurrentFrameTime(0);
                boss.getAnimShoot().setFrame(0);
                boss.getAnimShoot2().setCurrentFrameTime(0);
                boss.getAnimShoot2().setFrame(0);


            }

            if (boss != null && TimeUtils.millis() - boss.getLastShootTime() > 1000 && boss.isInShoot()) {
                boss.setInShoot(false);
                spawnBossShoot(boss, player.getX() - boss.getX(), player.getY() - boss.getY());

            }

            if (boss != null && (!boss.overlaps(player))) {
                boss.move(0, 0);
            }
            if (boss != null && (TimeUtils.millis() - boss.getLastDamageTime() > 500 && boss.overlaps(player))) {
                if(player.isInShield()){
                    player.setK(player.getK()+1);
                }else {
                    player.setHp(player.getHp() - 30);
                }
                boss.setLastDamageTime(TimeUtils.millis());
                boss.setInAttack(true);
                boss.getAnimAttack().setFrame(0);
                boss.getAnimAttack().setCurrentFrameTime(0);
                boss.getAnimAttack2().setFrame(0);
                boss.getAnimAttack2().setCurrentFrameTime(0);
            }

            if(boss != null){
                if(TimeUtils.millis() - boss.getLastDamageTime() > 500)
                    boss.setInAttack(false);
            }


            if (boss != null && boss.getHp() <= 0 ) {
                    //screen.getPlayer().setX(GameScreen.SCR_WIDTH / 2f - player.getWidth() / 2f);
                    //screen.getPlayer().setY(GameScreen.SCR_HEIGHT / 2f - player.getHeight() / 2f);
                    //game.setScreen(screen);
                isgame = false;
                defeatTime = TimeUtils.millis();
                stage.clear();
                boss = null;

            }

        if(player.getK() >= 3){
            player.setInShield(false);
        }


        batch.setProjectionMatrix(camera.combined);
        batch.begin();




        batch.draw(blackFone,-GameScreen.SCR_WIDTH*2f,-GameScreen.SCR_HEIGHT*4f,GameScreen.SCR_WIDTH*5f,GameScreen.SCR_HEIGHT*10f);
        batch.draw(bg,0,-GameScreen.SCR_HEIGHT,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT*2);


        if(boss != null) {
            font.draw(batch, "" + boss.getHp() + "/2000", boss.getX(), boss.getY() + boss.getHeight() + 10);
        }
        if(player.getHp() >= 0 ) {
            font.draw(batch, "" + player.getHp() + "/" + hpP, player.getX(), player.getY() + player.getHeight() + 10);
        }else{
            font.draw(batch, "0/" + hpP, player.getX(), player.getY() + player.getHeight() + 10);
        }

            if(player.isAlive()){

                if(!animationAttack.isStart() && !animationAttack2.isStart()) {
                    if (player.getVx() == 0 && player.getVy() == 0) {
                        if ((player.getRotation() > 0 && player.getRotation() <= 180))
                            batch.draw(animationIdle2.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                        if ((player.getRotation() > -180 && player.getRotation() <= 0))
                            batch.draw(animationIdle.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                    }else{
                        if ((player.getRotation() > 0 && player.getRotation() <= 180))
                            batch.draw(animationMove2.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                        if ((player.getRotation() > -180 && player.getRotation() <= 0))
                            batch.draw(animationMove.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                    }

                }
                if (animationAttack.isStart() || animationAttack2.isStart()) {
                    if ((player.getRotation() > 0 && player.getRotation() <= 180 || animationAttack2.isStart()) && !animationAttack.isStart())
                        batch.draw(animationAttack2.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                    if ((player.getRotation() > -180 && player.getRotation() <= 0 || animationAttack.isStart()) && !animationAttack2.isStart())
                        batch.draw(animationAttack.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                }

            }else {
                if((player.getRotation() > 0 && player.getRotation() <= 180))
                    batch.draw(animationDeath2.getFrame(), player.getX(), player.getY(),   player.getWidth(), player.getHeight());
                if((player.getRotation() > -180 && player.getRotation() <= 0 ))
                    batch.draw(animationDeath.getFrame(), player.getX(), player.getY(),   player.getWidth(), player.getHeight());
            }

        if(player.isInShield()){
            batch.draw(animationShield.getFrame(),player.getX()-player.getWidth(),player.getY() - player.getHeight()/2f,player.getWidth()*3,player.getWidth()*3);
        }

        if(boss != null) {
            if (boss.isInAttack()) {
                if (player.getX() >= boss.getX()) {
                    batch.draw(boss.getAnimAttack().getFrame(), boss.getX() - boss.getWidth(), boss.getY(), boss.getWidth() * 3, boss.getHeight() * 2);
                } else {
                    batch.draw(boss.getAnimAttack2().getFrame(), boss.getX() - boss.getWidth(), boss.getY(), boss.getWidth() * 3, boss.getHeight() * 2);
                }
            } else {
                if (boss.isInShoot()) {
                    if (player.getX() >= boss.getX()) {
                        batch.draw(boss.getAnimShoot().getFrame(), boss.getX(), boss.getY(), boss.getWidth() * 3, boss.getHeight() * 3);
                    } else {
                        batch.draw(boss.getAnimShoot2().getFrame(), boss.getX(), boss.getY(), boss.getWidth() * 3, boss.getHeight() * 3);
                    }
                } else {
                    if (player.getX() >= boss.getX()) {
                        batch.draw(boss.getAnimMove().getFrame(), boss.getX(), boss.getY(), boss.getWidth() * 1.5f, boss.getHeight());
                    } else {
                        batch.draw(boss.getAnimMove2().getFrame(), boss.getX(), boss.getY(), boss.getWidth() * 1.5f, boss.getHeight());
                    }
                }
            }
        }

        for (int i = 0; i < shoots.size; i++) {
            batch.draw(shoots.get(i).getAnim().getFrame(), shoots.get(i).getX(), shoots.get(i).getY(), shoots.get(i).getWidth() / 2, shoots.get(i).getHeight() / 2, shoots.get(i).getWidth(), shoots.get(i).getHeight(), 1, 1, shoots.get(i).getRotation());
        }


        for (int i = 0; i < bossShoots.size; i++) {
            batch.draw(trBossShell, bossShoots.get(i).getX(), bossShoots.get(i).getY(), bossShoots.get(i).getWidth() / 2, bossShoots.get(i).getHeight() / 2, bossShoots.get(i).getWidth(), bossShoots.get(i).getHeight(), 1, 1, bossShoots.get(i).getRotation());
        }
        for (int i = 0; i < shoots.size ; i++) {
            if(shoots.get(i).getLastCausedDamage() + 500 - TimeUtils.millis() > 0){
                shoots.get(i).getAnim().update(delta);
            }

        }

        if(TimeUtils.millis() - lastShootTime > shootInterval) {
            animationAttack.setStart(false);
            animationAttack2.setStart(false);
        }

        if(lastShootTime + shootInterval - TimeUtils.millis() > 0){
            animationAttack.update(delta);
            animationAttack2.update(delta);
        }

        if(defeatTime + defeatInterval - TimeUtils.millis() > 0){
            animationDeath.update(delta);
            animationDeath2.update(delta);
        }

        animationIdle.update(delta);
        animationIdle2.update(delta);
        animationMove.update(delta);
        animationMove2.update(delta);
        animationShield.update(delta);

        animationBossMove.update(delta);
        animationBossMove2.update(delta);
        animationBossAttack.update(delta);
        animationBossAttack2.update(delta);
        animationBossShoot.update(delta);
        animationBossShoot2.update(delta);


        if(!isgame){
            if(!player.isAlive()) {
                font.draw(batch, "DEFEAT! TAP TO GO HOME", player.getX() - player.getWidth() * 2, player.getY() + player.getHeight() / 2f);
            }else{
                font.draw(batch, "VICTORY! TAP TO CONTINUE", player.getX() - player.getWidth() * 2, player.getY() + player.getHeight() / 2f);

            }
        }

        if(TimeUtils.millis()-defeatTime > defeatInterval && !isgame && Gdx.input.isTouched()){
            if(!player.isAlive()) {
                game.setScreen(new HomeScreen(game));
            }else{
                screen.getPlayer().setX(SCR_WIDTH / 2f - player.getWidth() / 2f);
                screen.getPlayer().setY(SCR_HEIGHT / 2f - player.getHeight() / 2f);
                game.setScreen(screen);
            }
        }

        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());

        if (isgame) {
            if (10000 - (TimeUtils.millis() - player.getLastStar()) > 0 && player.isAlive())
                fontB.draw(batch, "" + Math.round((10000 - (TimeUtils.millis() - player.getLastStar())) / 1000f), buttonStar.getX() + buttonStar.getWidth() / 2.5f, buttonStar.getY() + buttonStar.getHeight() / 4f * 3);
            if (10000 - (TimeUtils.millis() - player.getLastShield()) > 0 && player.isAlive())
                fontB.draw(batch, "" + Math.round((10000 - (TimeUtils.millis() - player.getLastShield())) / 1000f), buttonShield.getX() + buttonShield.getWidth() / 2.5f, buttonShield.getY() + buttonShield.getHeight() / 4f * 3);
        }

        batch.end();
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
        bg.dispose();
        blackFone.dispose();
        circle.dispose();
        circleStars.dispose();
        circleShield.dispose();
        curJoystick.dispose();
        imgAnimIdle.dispose();
        imgAnimIdle2.dispose();
        imgAnimMove.dispose();
        imgAnimMove2.dispose();
        imgAnimAttack.dispose();
        imgAnimAttack2.dispose();
        imgAnimDeath.dispose();
        imgAnimDeath2.dispose();
        imgAnimFB.dispose();
        imgBossAnimMove.dispose();
        imgBossAnimMove2.dispose();
        imgBossAnimAttack.dispose();
        imgBossAnimAttack2.dispose();
        imgBossShell.dispose();
        imgBossAnimShoot.dispose();
        imgBossAnimShoot2.dispose();
        imgAnimShield.dispose();


    }
    private void gameOver(){
        player.setAlive(false);
        defeatTime = TimeUtils.millis();
        isgame = false;
        stage.clear();
        animationDeath.setFrame(0);
        animationDeath2.setFrame(0);

        if(Progress.isHardMode) {
            Progress.deleteProgress();
        }

    }
}
