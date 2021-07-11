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
import com.mygdx.spaceshooter.models.enemys.Boss3;
import com.mygdx.spaceshooter.models.shoots.Fireball;
import com.mygdx.spaceshooter.models.shoots.Shoot;
import com.mygdx.spaceshooter.models.shoots.Tornado;

public class FinalBossScreen implements Screen {
    InTheDark game;

    long lastShootTime;
    long shootInterval = 500;
    long defeatTime;
    long defeatInterval = 1000;


    Texture bg;
    Texture blackFone;
    Texture circle;
    Texture circleStar;
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
    Texture imgBossAnimAttack11;
    Texture imgBossAnimAttack12;
    Texture imgBossAnimAttack2;
    Texture imgBossAnimAttack31;
    Texture imgBossAnimAttack32;
    Texture imgBossAnimTP;
    Texture imgBossAnimResist;
    Texture imgBossIdle;
    Texture imgBossIdle2;
    Texture imgBossAttack2;
    Texture imgBossAttack31;
    Texture imgBossAttack32;
    Texture imgBossResist;
    Texture imgTornado;
    Texture imgBossShell;
    Texture imgLaserShell;
    Texture imgAnimShield;



    TextureRegion trAnimAttack;
    TextureRegion trAnimAttack2;
    TextureRegion trAnimIdle;
    TextureRegion trAnimIdle2;
    TextureRegion trAnimMove;
    TextureRegion trAnimMove2;
    TextureRegion trAnimDeath;
    TextureRegion trAnimDeath2;
    TextureRegion trAnimFB;
    TextureRegion trBossAnimAttack11;
    TextureRegion trBossAnimAttack12;
    TextureRegion trBossAnimAttack2;
    TextureRegion trBossAnimAttack31;
    TextureRegion trBossAnimAttack32;
    TextureRegion trBossAnimTP;
    TextureRegion trBossAnimResist;
    TextureRegion trTornado;
    TextureRegion trBossShell;
    TextureRegion trLaserShell;
    TextureRegion trAnimShield;


    Animation animAttack;
    Animation animAttack2;
    Animation animIdle;
    Animation animIdle2;
    Animation animMove;
    Animation animMove2;
    Animation animDeath;
    Animation animDeath2;
    Animation bossAnimAttack11;
    Animation bossAnimAttack12;
    Animation bossAnimAttack2;
    Animation bossAnimAttack31;
    Animation bossAnimAttack32;
    Animation bossAnimTP;
    Animation bossAnimResist;
    Animation animTornado;
    Animation animShield;



    SpriteBatch batch;
    BitmapFont font;
    BitmapFont fontB;
    OrthographicCamera camera;
    Joystick joystick;
    JoystickAttack joystickAttack;
    ButtonStar buttonStar;
    ButtonShield buttonShield;
    Stage stage;
    Player player;
    Boss3 boss;
    GameObject stone1;
    GameObject stone2;
    GameObject stone3;
    GameObject stone4;
    Array<GameObject> gameObjects;
    Array<Fireball> shoots;
    Array<Shoot> bossShoots;
    Array<Shoot> laserShoots;
    Array<Tornado> tornadoes;

    boolean isgame;
    int hpP = (int)((Progress.lvlPlayer * 10 + (Progress.lvlPlayer * 10 * 0.1f * Progress.Talent.encHP))*(1+Progress.Talent.doubleHP_DMG));

    public FinalBossScreen(InTheDark game) {
        this.game = game;
        isgame = true;
        bg = new Texture("Last_boss_location.png");
        blackFone = new Texture("BackGround.png");
        circle = new Texture("circletest (2).png");
        circleStar = new Texture("circletest (3).png");
        circleShield = new Texture("circletest (4).png");
        curJoystick = new Texture("png_cursor.png");
        imgAnimMove = new Texture("moveAnim.png");
        imgAnimMove2 = new Texture("moveAnim2.png");
        imgAnimIdle = new Texture("idleAnim.png");
        imgAnimIdle2 = new Texture("idleAnim2.png");
        imgAnimAttack = new Texture("AttackAnimation.png");
        imgAnimAttack2 = new Texture("AttackAnimation2.png");
        imgAnimFB = new Texture("AnimationFB.png");
        imgBossAnimAttack11 = new Texture("AnimAttack1_2___Boss3.png");
        imgBossAnimAttack12 = new Texture("2AnimAttack1_2___Boss3.png");
        imgBossAnimAttack2 = new Texture("AnimAttack3_Boss3.png");
        imgBossAnimAttack31 = new Texture("AnimAttack4_Boss3.png");
        imgBossAnimAttack32 = new Texture("2AnimAttack4_Boss3.png");
        imgBossAnimTP = new Texture("AnimTP_Boss3.png");
        imgBossAnimResist = new Texture("AnimResist.png");
        imgBossIdle = new Texture("imgIdleBoss3.png");
        imgBossIdle2 = new Texture("2imgIdleBoss3.png");
        imgBossAttack2 = new Texture("imgAttack3_Boss3.png");
        imgBossAttack31 = new Texture("imgAttack4.png");
        imgBossAttack32 = new Texture("imgAttack4 (2).png");
        imgBossResist = new Texture("imgResist.png");
        imgTornado = new Texture("Tornado.png");
        imgBossShell = new Texture("Boss3Shell.png");
        imgLaserShell = new Texture("laserBoss3Shell.png");
        imgAnimDeath = new Texture("AnimationDeath.png");
        imgAnimDeath2 = new Texture("AnimationDeath2.png");
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
        trBossAnimAttack11 = new TextureRegion(imgBossAnimAttack11);
        trBossAnimAttack12 = new TextureRegion(imgBossAnimAttack12);
        trBossAnimAttack2 = new TextureRegion(imgBossAnimAttack2);
        trBossAnimAttack31 = new TextureRegion(imgBossAnimAttack31);
        trBossAnimAttack32 = new TextureRegion(imgBossAnimAttack32);
        trBossAnimTP = new TextureRegion(imgBossAnimTP);
        trBossAnimResist = new TextureRegion(imgBossAnimResist);
        trTornado = new TextureRegion(imgTornado);
        trBossShell = new TextureRegion(imgBossShell);
        trLaserShell = new TextureRegion(imgLaserShell);
        trAnimShield = new TextureRegion(imgAnimShield);


        animMove = new Animation(trAnimMove,4,1);
        animMove2 = new Animation(trAnimMove2,4,1);
        animIdle = new Animation(trAnimIdle,4,1);
        animIdle2 = new Animation(trAnimIdle2,4,1);
        animAttack = new Animation(trAnimAttack,3, 0.7f);
        animAttack2 = new Animation(trAnimAttack2,3,0.7f);
        animDeath = new Animation(trAnimDeath, 4,1.3f);
        animDeath2 = new Animation(trAnimDeath2, 4,1.3f);
        bossAnimAttack11 = new Animation(trBossAnimAttack11,9,1);
        bossAnimAttack12 = new Animation(trBossAnimAttack12, 9 ,1);
        bossAnimAttack2 = new Animation(trBossAnimAttack2,4,1);
        bossAnimAttack31 = new Animation(trBossAnimAttack31,6,1);
        bossAnimAttack32 = new Animation(trBossAnimAttack32,6,1);
        bossAnimTP = new Animation(trBossAnimTP,5,1);
        bossAnimResist = new Animation(trBossAnimResist,8,1);
        animTornado = new Animation(trTornado,5,1);
        animShield = new Animation(trAnimShield,5,1);


        batch = new SpriteBatch();
        font = new BitmapFont();
        fontB = new BitmapFont();
        font.setColor(1,0,0,1);
        font.getData().scale(GameScreen.SCR_WIDTH/3000f);
        fontB.setColor(0,0,0,1);
        fontB.getData().scale(GameScreen.SCR_WIDTH/1500f);

        player = new Player();
        player.setHeight(player.getHeight()/2f);
        player.setWidth(player.getWidth()/2f);
        player.setX(GameScreen.SCR_WIDTH/2f - player.getWidth()/2f);
        player.setY(GameScreen.SCR_HEIGHT - player.getHeight()*3);
        shoots = new Array<>();
        bossShoots = new Array<>();
        laserShoots = new Array<>();
        tornadoes = new Array<>();
        boss = new Boss3(player,bossAnimAttack11,bossAnimAttack12,bossAnimAttack2,bossAnimAttack31,bossAnimAttack32,bossAnimTP,bossAnimResist, bossShoots, laserShoots, tornadoes);

        joystick = new Joystick(circle,curJoystick,player,true);
        joystickAttack = new JoystickAttack(this,circle,curJoystick,player);
        buttonStar = new ButtonStar(this,circleStar,player);
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

        stone1 = new GameObject(0,0,GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/8f,false,0,0);
        stone2 = new GameObject(0,GameScreen.SCR_HEIGHT-stone1.getHeight(),GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/10f,false,0,0);
        stone3 = new GameObject(GameScreen.SCR_WIDTH - stone1.getWidth(),GameScreen.SCR_HEIGHT-stone1.getHeight(),GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/10f,false,0,0);
        stone4 = new GameObject(GameScreen.SCR_WIDTH - stone1.getWidth(),0,GameScreen.SCR_WIDTH/10f,GameScreen.SCR_WIDTH/10f,false,0,0);
        gameObjects = new Array<>();

        gameObjects.add(stone1);
        gameObjects.add(stone2);
        gameObjects.add(stone3);
        gameObjects.add(stone4);
    }

    @Override
    public void show() {

    }

    public void spawnShoot(float dx, float dy) {
        if (player.isAlive() && TimeUtils.millis() - lastShootTime > shootInterval) {
            //Array<EnemyWarrior> array = new Array<>();

            animAttack.setFrame(1);
            animAttack.setCurrentFrameTime(0);
            animAttack2.setFrame(1);
            animAttack2.setCurrentFrameTime(0);

            if (dx < 0) {
                animAttack2.setStart(true);
            } else {
                animAttack.setStart(true);
            }

            Fireball newShoot = new Fireball(player, dx, dy, 0, 0, GameScreen.SCR_WIDTH / 90f, new Animation(trAnimFB, 4, 0.5f)); // подаются главный герой, последние ненулевые значения положения джойстика, скорости по х и у заднего фона и относительная скорость полета снаряда
            newShoot.setWidth(newShoot.getWidth() /2f);
            newShoot.setHeight(newShoot.getHeight() /2f);
            newShoot.setY(newShoot.getY() + newShoot.getWidth());
            shoots.add(newShoot);
            lastShootTime = TimeUtils.millis();
        }
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

    @Override
    public void render(float delta) {
        player.move(gameObjects, player);
        if(boss != null) {
            boss.update(delta);
        }

        if(player.getHp() <= 0 && player.isAlive()) gameOver();

        if (player.getY() + player.getHeight() * 2 > GameScreen.SCR_HEIGHT)
            player.setCollidedOnTheFront(true);
        if (player.getY() - player.getHeight() * 1.1f < 0)
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
                    if (!boss.isResist()) boss.setHp(boss.getHp() - player.getDmg());
                    shoots.get(i).setCausedDamage(true);
                    shoots.get(i).setDvx(0);
                    shoots.get(i).setDvy(0);
                    shoots.get(i).setLastCausedDamage(TimeUtils.millis());
                }
            }

            if (shoots.get(i).getY() + player.getHeight() * 2 > GameScreen.SCR_HEIGHT && !shoots.get(i).getCausedDamage()) {
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
            }

            if (shoots.get(i).getY() - player.getHeight() * 1.1f < 0 && !shoots.get(i).getCausedDamage()) {
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
            }

            if (shoots.get(i).getX() + player.getWidth() * 2 + player.getWidth() > GameScreen.SCR_WIDTH && !shoots.get(i).getCausedDamage()) {
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
            }

            if (shoots.get(i).getX() - player.getWidth() * 2 < 0 && !shoots.get(i).getCausedDamage()) {
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
            bossShoots.get(i).setVx(bossShoots.get(i).getDvx());
            bossShoots.get(i).setVy(bossShoots.get(i).getDvy());
            bossShoots.get(i).move();

            if (bossShoots.get(i).overlaps(player)) {
                if (player.isInShield()) {
                    player.setK(player.getK() + 1);
                    bossShoots.get(i).setAlive(false);
                } else {
                    player.setHp(player.getHp() - 100);
                    bossShoots.get(i).setAlive(false);

                }
            }

                if (bossShoots.get(i).getY() + player.getHeight() * 2 > GameScreen.SCR_HEIGHT) {
                    bossShoots.get(i).setAlive(false);
                }

                if (bossShoots.get(i).getY() - player.getHeight() * 1.1f < 0) {
                    bossShoots.get(i).setAlive(false);

                }

                if (bossShoots.get(i).getX() + player.getWidth() * 2 + player.getWidth() > GameScreen.SCR_WIDTH) {
                    bossShoots.get(i).setAlive(false);

                }

                if (bossShoots.get(i).getX() - player.getWidth() * 2 < 0) {
                    bossShoots.get(i).setAlive(false);

                }


                if (!bossShoots.get(i).isAlive()) bossShoots.removeIndex(i);


            }


        for (int i = 0; i < laserShoots.size; i++) {
            laserShoots.get(i).move();

            if (laserShoots.get(i).overlaps(player)) {
                if (player.isInShield()) {
                    player.setK(player.getK() + 1);
                    laserShoots.get(i).setAlive(false);
                } else {
                    player.setHp(player.getHp() - 10);
                    laserShoots.get(i).setAlive(false);

                }
            }

            if (laserShoots.get(i).getY() + player.getHeight() * 2 > GameScreen.SCR_HEIGHT) {
                laserShoots.get(i).setAlive(false);
            }

            if (laserShoots.get(i).getY() - player.getHeight() * 1.1f < 0) {
                laserShoots.get(i).setAlive(false);

            }

            if (laserShoots.get(i).getX() + player.getWidth()*2 + player.getWidth() > GameScreen.SCR_WIDTH) {
                laserShoots.get(i).setAlive(false);

            }

            if (laserShoots.get(i).getX() - player.getWidth()*2 < 0) {
                laserShoots.get(i).setAlive(false);

            }


            if (!laserShoots.get(i).isAlive()) laserShoots.removeIndex(i);
        }

        for (int i = 0; i < tornadoes.size; i++) {
            tornadoes.get(i).move();
            if (tornadoes.get(i).overlaps(player) && !tornadoes.get(i).isCausedDamage()) {
                if (player.isInShield()) {
                    player.setK(player.getK() + 1);
                    tornadoes.get(i).setAlive(false);
                } else {
                    player.setHp(player.getHp() - 200);
                    tornadoes.get(i).setCausedDamage(true);

                }
            }

            if (tornadoes.get(i).getY() + player.getHeight() * 2 > GameScreen.SCR_HEIGHT) {
                tornadoes.get(i).setAlive(false);
            }

            if (tornadoes.get(i).getY() - player.getHeight() * 1.1f < 0) {
                tornadoes.get(i).setAlive(false);

            }

            if (tornadoes.get(i).getX() + player.getWidth()*2 + player.getWidth() > GameScreen.SCR_WIDTH) {
                tornadoes.get(i).setAlive(false);

            }

            if (tornadoes.get(i).getX() - player.getWidth()*2 < 0) {
                tornadoes.get(i).setAlive(false);

            }

            if (!tornadoes.get(i).isAlive()) tornadoes.removeIndex(i);
        }

        if(player.getK() >= 3){
            player.setInShield(false);
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

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(blackFone,-GameScreen.SCR_WIDTH*2f,-GameScreen.SCR_HEIGHT*2f,GameScreen.SCR_WIDTH*5f,GameScreen.SCR_HEIGHT*5f);
        batch.draw(bg,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);



        if(boss != null) {
            font.draw(batch, "" + boss.getHp() + "/35000", boss.getX(), boss.getY() + boss.getHeight() + 10);
        }
        if(player.getHp() >= 0 ) {
            font.draw(batch, "" + player.getHp() + "/" + hpP, player.getX(), player.getY() + player.getHeight() + 10);
        }else{
            font.draw(batch, "0/" + hpP, player.getX(), player.getY() + player.getHeight() + 10);
        }


        if(player.isAlive()){

                if(!animAttack.isStart() && !animAttack2.isStart()) {
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

                }
                if (animAttack.isStart() || animAttack2.isStart()) {
                    if ((player.getRotation() > 0 && player.getRotation() <= 180 || animAttack2.isStart()) && !animAttack.isStart())
                        batch.draw(animAttack2.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                    if ((player.getRotation() > -180 && player.getRotation() <= 0 || animAttack.isStart()) && !animAttack2.isStart())
                        batch.draw(animAttack.getFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
                }
            }else {
                if((player.getRotation() > 0 && player.getRotation() <= 180))
                    batch.draw(animDeath2.getFrame(), player.getX(), player.getY(),   player.getWidth(), player.getHeight());
                if((player.getRotation() > -180 && player.getRotation() <= 0 ))
                    batch.draw(animDeath.getFrame(), player.getX(), player.getY(),   player.getWidth(), player.getHeight());
            }

        if(player.isInShield()){
            batch.draw(animShield.getFrame(),player.getX()-player.getWidth(),player.getY() - player.getHeight()/2f,player.getWidth()*3,player.getWidth()*3);
        }


            if(boss != null){

                if(boss.isAttack1InCast()){
                    if(player.getX() >= boss.getX()){
                        batch.draw(boss.getAnimAttack11().getFrame(),boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }else{
                        batch.draw(boss.getAnimAttack12().getFrame(),boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }
                }
                if(boss.isAttack2InCast()){
                    batch.draw(boss.getAnimAttack2().getFrame(),boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());

                }
                if(boss.isAttack2()){
                    batch.draw(imgBossAttack2,boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                }
                if(boss.isAttack3InCast()){
                    if(player.getX() >= boss.getX()){
                        batch.draw(boss.getAnimAttack31().getFrame(),boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }else{
                        batch.draw(boss.getAnimAttack32().getFrame(),boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }
                }
                if(boss.isAttack3()){
                    if(player.getX() >= boss.getX()){
                        batch.draw(imgBossAttack31,boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }else{
                        batch.draw(imgBossAttack32,boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }
                }
                if(boss.isTpInCast()) {
                    batch.draw(boss.getAnimTp().getFrame(), boss.getX() - boss.getWidth() / 2f, boss.getY(), boss.getWidth() * 2, boss.getHeight());
                }
                if(boss.isResistInCast()){
                    batch.draw(boss.getAnimResist().getFrame(), boss.getX() - boss.getWidth() / 2f, boss.getY(), boss.getWidth() * 2, boss.getHeight());
                }
                if(boss.isResist()){
                    batch.draw(imgBossResist, boss.getX() - boss.getWidth() / 2f, boss.getY(), boss.getWidth() * 2, boss.getHeight());
                }
                if(!boss.isInSpell()){
                    if(player.getX() >= boss.getX()){
                        batch.draw(imgBossIdle,boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }else{
                        batch.draw(imgBossIdle2,boss.getX()-boss.getWidth()/2f,boss.getY(),boss.getWidth()*2,boss.getHeight());
                    }
                }

            }


        for (int i = 0; i < shoots.size; i++) {
            batch.draw(shoots.get(i).getAnim().getFrame(), shoots.get(i).getX(), shoots.get(i).getY(), shoots.get(i).getWidth() / 2, shoots.get(i).getHeight() / 2, shoots.get(i).getWidth(), shoots.get(i).getHeight(), 1, 1, shoots.get(i).getRotation());
        }

        for (int i = 0; i < tornadoes.size; i++) {
            batch.draw(animTornado.getFrame(),tornadoes.get(i).getX(),tornadoes.get(i).getY(),tornadoes.get(i).getWidth(),tornadoes.get(i).getHeight());
        }

        for (int i = 0; i < bossShoots.size; i++) {
            batch.draw(trBossShell, bossShoots.get(i).getX(), bossShoots.get(i).getY(), bossShoots.get(i).getWidth() / 2, bossShoots.get(i).getHeight() / 2, bossShoots.get(i).getWidth(), bossShoots.get(i).getHeight(), 1, 1, bossShoots.get(i).getRotation());
        }

        for (int i = 0; i < laserShoots.size; i++) {
            batch.draw(trLaserShell, laserShoots.get(i).getX(), laserShoots.get(i).getY(), laserShoots.get(i).getWidth() / 2, laserShoots.get(i).getHeight() / 2, laserShoots.get(i).getWidth(), laserShoots.get(i).getHeight(), 1, 1, laserShoots.get(i).getRotation());
        }

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
                game.setScreen(new FinalScreen(game));
                Progress.is3lvlWin = true;
            }
        }
        if(boss != null) {
            if (boss.getHp() <= 0) {
                defeatTime = TimeUtils.millis();
                stage.clear();
                boss = null;
                isgame = false;

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



        for (int i = 0; i < shoots.size ; i++) {
            if(shoots.get(i).getLastCausedDamage() + 500 - TimeUtils.millis() > 0){
                shoots.get(i).getAnim().update(delta);
            }

        }

        if(TimeUtils.millis() - lastShootTime > shootInterval) {
            animAttack.setStart(false);
            animAttack2.setStart(false);
        }

        if(lastShootTime + shootInterval - TimeUtils.millis() > 0){
            animAttack.update(delta);
            animAttack2.update(delta);
        }

        if(defeatTime + defeatInterval - TimeUtils.millis() > 0){
            animDeath.update(delta);
            animDeath2.update(delta);
        }

        animIdle.update(delta);
        animIdle2.update(delta);
        animMove.update(delta);
        animMove2.update(delta);
        animShield.update(delta);

        animTornado.update(delta);



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
        circleStar.dispose();
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
        imgBossAnimAttack11.dispose();
        imgBossAnimAttack12.dispose();
        imgBossAnimAttack2.dispose();
        imgBossAnimAttack31.dispose();
        imgBossAnimAttack32.dispose();
        imgBossAnimTP.dispose();
        imgBossAnimResist.dispose();
        imgBossIdle.dispose();
        imgBossIdle2.dispose();
        imgBossAttack2.dispose();
        imgBossAttack31.dispose();
        imgBossAttack32.dispose();
        imgBossResist.dispose();
        imgTornado.dispose();
        imgBossShell.dispose();
        imgLaserShell.dispose();
        imgAnimShield.dispose();


    }

    private void gameOver(){
        player.setAlive(false);
        defeatTime = TimeUtils.millis();
        isgame = false;
        stage.clear();
        animDeath.setFrame(0);
        animDeath2.setFrame(0);

        if(Progress.isHardMode) {
            Progress.deleteProgress();
        }

    }
}
