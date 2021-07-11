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
import com.mygdx.spaceshooter.models.Grass;
import com.mygdx.spaceshooter.models.MyTree;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.models.enemys.Boss1;
import com.mygdx.spaceshooter.models.enemys.EnemyArcher;
import com.mygdx.spaceshooter.models.enemys.EnemyWarrior;
import com.mygdx.spaceshooter.models.enemys.Ninja;
import com.mygdx.spaceshooter.models.shoots.EnemyShoot;
import com.mygdx.spaceshooter.models.shoots.Fireball;
import com.mygdx.spaceshooter.models.shoots.Shoot;

import java.util.Comparator;
import java.util.logging.Logger;



public class Lvl1Screen implements Screen {
    InTheDark game;

    public static final int SCR_WIDTH = Gdx.graphics.getWidth(), SCR_HEIGHT = Gdx.graphics.getHeight();
    long lastEnemyWarriorSpawnTime;
    long enemyWarriorSpawnInterval = 1000;
    long lastEnemyArcherSpawnTime;
    long enemyArcherSpawnInterval = 2000;
    long lastenemyNinjaSpawnTime;
    long enemyNinjaSpawnInteval = 3000;
    long lastTreeSpawn;
    long treeSpawnInterval = 2000;
    //long lastEnemyShootTime;
    long enemyShootInterval = 3000;
    long bossShootInterval = 6000;
    long lastShootTime;
    long shootInterval = 500;
    long lastBlinkTime;
    long blinkInterval = 3000;
    //long lastDamageTime;
    long damageInterval = 500;
    long defeatTime;
    long defeatInterval = 1000;


    SpriteBatch batch;
    BitmapFont font;
    BitmapFont fontB;
    OrthographicCamera camera;
    Vector3 touch;
    Stage stage;
    //Viewport viewport;

    Texture imgNinja;
    Texture imgGrass;
    Texture imgTree;
    Texture imgFireball;
    Texture imgArrow;
    Texture circleStar;
    Texture circle;
    Texture circleShield;
    Texture cursor;
    Texture imgAnimAttack;
    Texture imgAnimAttack2;
    Texture imgAnimSlime;
    Texture imgAnimArcher1;
    Texture imgAnimArcher2;
    Texture imgAnimBlink;
    Texture imgAnimBlink2;
    Texture imgAnimDeath;
    Texture imgAnimDeath2;
    Texture imgAnimFB;
    Texture imgAnimIdle;
    Texture imgAnimIdle2;
    Texture imgAnimMove;
    Texture imgAnimMove2;
    Texture imgAnimMoveN;
    Texture imgAnimMoveN2;
    Texture imgAnimAttackN;
    Texture imgAnimAttackN2;
    Texture imgBossAnimMove;
    Texture imgBossAnimMove2;
    Texture imgBossAnimAttack;
    Texture imgBossAnimAttack2;
    Texture bg1;
    Texture bg2;
    Texture bg3;
    Texture imgBossShell;
    Texture imgBossAnimShoot;
    Texture imgBossAnimShoot2;
    Texture imgAnimShield;
    //TextureRegion trShip;
    TextureRegion trFireball;
    TextureRegion trArrow;
    TextureRegion trAnimAttack;
    TextureRegion trAnimAttack2;
    TextureRegion trAnimSlime;
    TextureRegion trAnimArcher1;
    TextureRegion trAnimArcher2;
    TextureRegion trAnimBlink;
    TextureRegion trAnimBlink2;
    TextureRegion trAnimDeath;
    TextureRegion trAnimDeath2;
    TextureRegion trAnimFB;
    TextureRegion trAnimIdle;
    TextureRegion trAnimIdle2;
    TextureRegion trAnimMove;
    TextureRegion trAnimMove2;
    TextureRegion trAnimMoveN;
    TextureRegion trAnimMoveN2;
    TextureRegion trAnimAttackN;
    TextureRegion trAnimAttackN2;
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
    Animation animationBlink;
    Animation animationBlink2;
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




    Array<Grass> grassArray = new Array<>();
    Player player;
    Boss1 boss;
    Joystick joystick;
    JoystickAttack joystickAttack;
    ButtonStar buttonStar;
    ButtonShield buttonShield;
    Array<MyTree> trees = new Array<>();
    Array<EnemyWarrior> enemyWarriors = new Array<>();
    Array<EnemyArcher> enemyArchers = new Array<>();
    Array<Ninja> ninjas = new Array<>();
    Array<EnemyShoot> enemyShoots = new Array<>();
    Array<Fireball> shoots = new Array<>();
    Array<Shoot> bossShoots = new Array<>();
    int score;
    boolean bossInGame = false;
    boolean isgame = true;
    float dx;
    float dy;


    int dmgW;
    boolean isDmgW;
    int hpP = (int)((Progress.lvlPlayer * 10 + (Progress.lvlPlayer * 10 * 0.1f * Progress.Talent.encHP))*(1+Progress.Talent.doubleHP_DMG));
    int hpW = (int)(10*(0.9f*Progress.lvlPlayer));


    private static Logger log = Logger.getLogger(GameScreen.class.getName());




    public Lvl1Screen (InTheDark gam) {

        log.info("ширина " + SCR_WIDTH);
        this.game = gam;
        batch = new SpriteBatch();
        font = new BitmapFont();
        fontB = new BitmapFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();
        //viewport = new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

        stage = new Stage(/*viewport*/);

        score = 0;

        loadResources();
        grassArray.add(new Grass(0,0,bg1,bg2,bg3));
        grassArray.add(new Grass(SCR_HEIGHT,0,bg1,bg2,bg3));
        grassArray.add(new Grass(-SCR_HEIGHT,0,bg1,bg2,bg3));
        grassArray.add(new Grass(0,-SCR_WIDTH,bg1,bg2,bg3));
        grassArray.add(new Grass(SCR_HEIGHT,-SCR_WIDTH,bg1,bg2,bg3));
        grassArray.add(new Grass(-SCR_HEIGHT,-SCR_WIDTH,bg1,bg2,bg3));
        grassArray.add(new Grass(0,SCR_WIDTH,bg1,bg2,bg3));
        grassArray.add(new Grass(SCR_HEIGHT,SCR_WIDTH,bg1,bg2,bg3));
        grassArray.add(new Grass(-SCR_HEIGHT,SCR_WIDTH,bg1,bg2,bg3));

        player = new Player();

        //trShip = new TextureRegion(imgShip);
        trFireball = new TextureRegion(imgFireball);
        trArrow = new TextureRegion(imgArrow);
        trAnimAttack = new TextureRegion(imgAnimAttack);
        trAnimAttack2 = new TextureRegion(imgAnimAttack2);
        trAnimSlime = new TextureRegion(imgAnimSlime);
        trAnimArcher1 = new TextureRegion(imgAnimArcher1);
        trAnimArcher2 = new TextureRegion(imgAnimArcher2);
        trAnimBlink = new TextureRegion(imgAnimBlink);
        trAnimBlink2 = new TextureRegion(imgAnimBlink2);
        trAnimDeath = new TextureRegion(imgAnimDeath);
        trAnimDeath2 = new TextureRegion(imgAnimDeath2);
        trAnimFB = new TextureRegion(imgAnimFB);
        trAnimIdle = new TextureRegion(imgAnimIdle);
        trAnimIdle2 = new TextureRegion(imgAnimIdle2);
        trAnimMove = new TextureRegion(imgAnimMove);
        trAnimMove2 = new TextureRegion(imgAnimMove2);
        trAnimMoveN = new TextureRegion(imgAnimMoveN);
        trAnimMoveN2 = new TextureRegion(imgAnimMoveN2);
        trAnimAttackN = new TextureRegion(imgAnimAttackN);
        trAnimAttackN2 = new TextureRegion(imgAnimAttackN2);
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
        animationBlink = new Animation(trAnimBlink,4,0.2f);
        animationBlink2 = new Animation(trAnimBlink2,4,0.2f);
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



        joystick = new Joystick(circle, cursor, player, grassArray,false);
        joystickAttack = new JoystickAttack(this, circle, cursor, player);
        buttonStar = new ButtonStar(this,circleStar,player);
        buttonShield = new ButtonShield(circleShield,player);
        stage.addActor(joystick);
        stage.addActor(joystickAttack);
        if(Progress.Talent.isStar) stage.addActor(buttonStar);
        if(Progress.Talent.isShield) stage.addActor(buttonShield);
        stage.addActor(player);
        Gdx.input.setInputProcessor(stage);

        font.setColor(1,0,0,1);
        //font.getData().setScale(3);
        font.getData().scale(GameScreen.SCR_WIDTH/1000f);
        fontB.setColor(0,0,0,1);
        //font.getData().setScale(3);
        fontB.getData().scale(GameScreen.SCR_WIDTH/500f);

    }

    private void actions() {

        float d_x = 0;
        float d_y = 0;
        if (joystick.getDx() != 0 || joystick.getDy() != 0) {
            d_x = joystick.getDx();
            d_y = joystick.getDy();
        }
        dx = d_x;
        dy = d_y;

        if (TimeUtils.millis() - player.getLastinblink() > 200) {
            player.setInblink(false);
        }

        for (int i = 0; i < grassArray.size; i++) grassArray.get(i).move();

		/*if (Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(),0);
			camera.unproject(touch);
			ship.x += (touch.x - (ship.x + ship.width / 2)) / 5;
		}*/


        //if(ship.isAlive && TimeUtils.millis() - lastShootTime > shootInterval) spawnShoot();
        for (int i = 0; i < shoots.size; i++) {

            shoots.get(i).setVx(shoots.get(i).getDvx() + grassArray.get(1).getVx());
            shoots.get(i).setVy(shoots.get(i).getDvy() + grassArray.get(1).getVy());
            shoots.get(i).move();

            for (int j = 0; j < trees.size; j++) {

                if (shoots.get(i).overlaps(trees.get(j)) && !shoots.get(i).getCausedDamage()) {
                    shoots.get(i).setCausedDamage(true);
                    shoots.get(i).setDvx(0);
                    shoots.get(i).setDvy(0);
                    shoots.get(i).setLastCausedDamage(TimeUtils.millis());


                }

            }

            for (int j = 0; j < ninjas.size; j++) {

                if (shoots.get(i).overlaps(ninjas.get(j)) && !shoots.get(i).getCausedDamage()) {
                    shoots.get(i).setCausedDamage(true);
                    shoots.get(i).setDvx(0);
                    shoots.get(i).setDvy(0);
                    shoots.get(i).setLastCausedDamage(TimeUtils.millis());
                    ninjas.get(j).setHp(ninjas.get(j).getHp() - player.getDmg());

                }
            }

            for (int j = 0; j < enemyWarriors.size; j++) {

                if (shoots.get(i).overlaps(enemyWarriors.get(j)) && !shoots.get(i).getCausedDamage()) {
                    shoots.get(i).setCausedDamage(true);
                    shoots.get(i).setDvx(0);
                    shoots.get(i).setDvy(0);
                    shoots.get(i).setLastCausedDamage(TimeUtils.millis());
                    enemyWarriors.get(j).setHp(enemyWarriors.get(j).getHp() - player.getDmg());

                }

            }

            for (int j = 0; j < enemyArchers.size; j++) {

                if (shoots.get(i).overlaps(enemyArchers.get(j)) && !shoots.get(i).getCausedDamage()) {
                    shoots.get(i).setCausedDamage(true);
                    shoots.get(i).setDvx(0);
                    shoots.get(i).setDvy(0);
                    shoots.get(i).setLastCausedDamage(TimeUtils.millis());
                    enemyArchers.get(j).setHp(enemyArchers.get(j).getHp() - player.getDmg());

                }
            }

            if(boss != null && (shoots.get(i).overlaps(boss) && !shoots.get(i).getCausedDamage())){
                shoots.get(i).setCausedDamage(true);
                shoots.get(i).setDvx(0);
                shoots.get(i).setDvy(0);
                shoots.get(i).setLastCausedDamage(TimeUtils.millis());
                boss.setHp(boss.getHp() - player.getDmg());

            }

            if (TimeUtils.millis() - shoots.get(i).getLastCausedDamage() > 500 && shoots.get(i).getCausedDamage()) {
                shoots.get(i).setAlive(false);
            }

            if (!shoots.get(i).isAlive()) shoots.removeIndex(i);
        }

       // if (TimeUtils.millis() - lastenemyNinjaSpawnTime > enemyNinjaSpawnInteval && ninjas.size < 3 && !bossInGame)
         //   spawnNinja();

        if (TimeUtils.millis() - lastEnemyWarriorSpawnTime > enemyWarriorSpawnInterval && enemyWarriors.size < 10 && !bossInGame)
            spawnEnemyWarrior();

      //  if (TimeUtils.millis() - lastEnemyArcherSpawnTime > enemyArcherSpawnInterval && enemyArchers.size < 10 && !bossInGame)
         //   spawnEnemyArcher();

        if (TimeUtils.millis() - lastTreeSpawn > treeSpawnInterval && trees.size < 15)
            spawnMyTree();

        if(boss != null &&
          (TimeUtils.millis() - boss.getLastShootTime() > bossShootInterval) &&
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





        player.setCollidedOnTheBack(false);
        player.setCollidedOnTheFront(false);
        player.setCollidedOnTheLeft(false);
        player.setCollidedOnTheRight(false);


        for (int i = 0; i < trees.size; i++) {
            trees.get(i).setVy(grassArray.get(1).getVy());
            trees.get(i).setVx(grassArray.get(1).getVx());
            trees.get(i).move();

            if (trees.get(i).overlaps(player)) {

				/*for (int j = 0; j < grassArray.size; j++) {
					grassArray.get(j).setVy(0);
					grassArray.get(j).setVx(0);
				}
				for (int j = 0; j < enemyArchers.size ; j++) {
					enemyArchers.get(j).setVx(0);
					enemyArchers.get(j).setVy(0);
				}
				for (int j = 0; j < enemyWarriors.size; j++) {
					enemyWarriors.get(j).setVx(0);
					enemyWarriors.get(j).setVy(0);
				}
				for (int j = 0; j < trees.size; j++) {
					trees.get(j).setVx(0);
					trees.get(j).setVy(0);
				}
				for (int j = 0; j < shoots.size; j++) {
					shoots.get(j).setVx(0);
					shoots.get(j).setVy(0);
				}
				for (int j = 0; j < enemyShoots.size ; j++) {
					enemyShoots.get(j).setVx(0);
					enemyShoots.get(j).setVy(0);
				}*/


                if (player.getX() > trees.get(i).getX() &&
                        trees.get(i).getX() > player.getX() - trees.get(i).getWidth() - trees.get(i).getWidth() / 2f &&
                        trees.get(i).getX() < player.getX() - trees.get(i).getWidth()) {
                    player.setCollidedOnTheLeft(true);
                } else {
                    if (player.getX() < trees.get(i).getX() &&
                            trees.get(i).getX() > player.getX() + player.getWidth() &&
                            trees.get(i).getX() < player.getX() + player.getWidth() + trees.get(i).getWidth() / 2f) {
                        player.setCollidedOnTheRight(true);
                    } else {
                        if (player.getY() < trees.get(i).getY()) {
                            player.setCollidedOnTheFront(true);
                        }
                        if (player.getY() > trees.get(i).getY()) {
                            player.setCollidedOnTheBack(true);
                        }
                    }
                }

            }


            if (!trees.get(i).isAlive()) {
                trees.removeIndex(i);
            }

        }

        trees.sort(new Comparator<MyTree>() {
            @Override
            public int compare(MyTree myTree, MyTree t1) {            //сортировка для корректной отрисовки
                return (int) (t1.getY() - myTree.getY());
            }
        });

        for (int i = 0; i < ninjas.size; i++) {

            if (!ninjas.get(i).overlaps(player) || (grassArray.get(0).getVx() != 0 || grassArray.get(0).getVy() != 0))
                ninjas.get(i).move(grassArray.get(0).getVx(), grassArray.get(0).getVy(), trees);
            if (TimeUtils.millis() - ninjas.get(i).getLastDamageTime() > damageInterval && player.overlaps(ninjas.get(i))) {
                if(player.isInShield()){
                    player.setK(player.getK()+1);
                }else {
                    player.setHp(player.getHp() - 5);
                }
                ninjas.get(i).setLastDamageTime(TimeUtils.millis());
                ninjas.get(i).setInAttack(true);
                ninjas.get(i).getAnimAttack().setFrame(0);
                ninjas.get(i).getAnimAttack().setCurrentFrameTime(0);
                ninjas.get(i).getAnimAttack2().setFrame(0);
                ninjas.get(i).getAnimAttack2().setCurrentFrameTime(0);
            }
            if (ninjas.get(i).getHp() <= 0) {
                ninjas.get(i).setAlive(false);
                score = score + 5;

            }

            if (!ninjas.get(i).isAlive()) ninjas.removeIndex(i);
        }

        for (int i = 0; i < enemyWarriors.size; i++) {
            enemyWarriors.get(i).setVy(grassArray.get(1).getVy());
            enemyWarriors.get(i).setVx(grassArray.get(1).getVx());
            enemyWarriors.get(i).move();
            if (TimeUtils.millis() - enemyWarriors.get(i).getLastDamageTime() > damageInterval && player.overlaps(enemyWarriors.get(i))) {
                if(player.isInShield()){
                    player.setK(player.getK()+1);
                }else {
                    player.setHp(player.getHp() - dmgW);
                }
                enemyWarriors.get(i).setLastDamageTime(TimeUtils.millis());
                enemyWarriors.get(i).getAnimation().setFrame(0);
                enemyWarriors.get(i).getAnimation().setCurrentFrameTime(0);
            }

            if (enemyWarriors.get(i).getHp() <= 0) {
                enemyWarriors.get(i).setAlive(false);
                score = score + 5;

            }

            if (!enemyWarriors.get(i).isAlive()) enemyWarriors.removeIndex(i);
        }


        for (int i = 0; i < enemyArchers.size; i++) {
            enemyArchers.get(i).setVy(grassArray.get(1).getVy());
            enemyArchers.get(i).setVx(grassArray.get(1).getVx());
            enemyArchers.get(i).move();

            float dx = player.getX() - enemyArchers.get(i).getX();
            float dy = player.getY() - enemyArchers.get(i).getY();
            //спавн выстрелов врага;
            if (player.isAlive() &&
                    TimeUtils.millis() - enemyArchers.get(i).getLastShootTime() > enemyShootInterval &&
                    enemyArchers.get(i).getX() > 0 - enemyArchers.get(i).getWidth() && enemyArchers.get(i).getX() < GameScreen.SCR_WIDTH && enemyArchers.get(i).getY() > 0 - enemyArchers.get(i).getHeight() && enemyArchers.get(i).getY() < GameScreen.SCR_HEIGHT) {
                spawnEnemyShoot(enemyArchers.get(i), dx, dy);  // подаётся лучник и координаты главного героя если считать лучника центром коорд. плоскости
            }

            if (enemyArchers.get(i).getHp() <= 0) {
                enemyArchers.get(i).setAlive(false);
                score = score + 5;

            }

            if (!enemyArchers.get(i).isAlive()) enemyArchers.removeIndex(i);
        }


        for (int i = 0; i < enemyShoots.size; i++) {
            if (enemyShoots.get(i).overlaps(player)) {
                if(player.isInShield()){
                    player.setK(player.getK()+1);
                    enemyShoots.get(i).setAlive(false);
                }else {
                    player.setHp(player.getHp() - 5);
                    enemyShoots.get(i).setAlive(false);
                }
            }
            for (int j = 0; j < trees.size; j++) {
                if (enemyShoots.get(i).overlaps(trees.get(j))) enemyShoots.get(i).setAlive(false);
            }
            enemyShoots.get(i).setVx(enemyShoots.get(i).getDvx() + grassArray.get(1).getVx());
            enemyShoots.get(i).setVy(enemyShoots.get(i).getDvy() + grassArray.get(1).getVy());
            enemyShoots.get(i).move();

            if (!enemyShoots.get(i).isAlive() || !player.isAlive()) enemyShoots.removeIndex(i);
        }

        if (player.getHp() <= 0 && player.isAlive()) gameOver();


        for (int i = 0; i < bossShoots.size; i++) {
            if (bossShoots.get(i).overlaps(player)) {
                if(player.isInShield()){
                    player.setK(player.getK()+1);
                    bossShoots.get(i).setAlive(false);
                }else {
                    player.setHp(player.getHp() - 50);
                    bossShoots.get(i).setAlive(false);
                }
            }

            for (int j = 0; j < trees.size; j++) {
                if (bossShoots.get(i).overlaps(trees.get(j))) bossShoots.get(i).setAlive(false);
            }

            bossShoots.get(i).setVx(bossShoots.get(i).getDvx() + grassArray.get(1).getVx());
            bossShoots.get(i).setVy(bossShoots.get(i).getDvy() + grassArray.get(1).getVy());
            bossShoots.get(i).move();

            if (!bossShoots.get(i).isAlive() || !player.isAlive()) bossShoots.removeIndex(i);
        }


        if (score >= 50 && !bossInGame) {
            ninjas.clear();
            enemyArchers.clear();
            enemyWarriors.clear();
            boss = new Boss1(trees,player,animationBossAttack,animationBossAttack2,animationBossMove,animationBossMove2,animationBossShoot,animationBossShoot2);
            bossInGame = true;
        }
        if (boss != null && (!boss.overlaps(player) || (grassArray.get(0).getVx() != 0 || grassArray.get(0).getVy() != 0))) {
            boss.move(grassArray.get(0).getVx(), grassArray.get(0).getVy(), trees);
        }
        if (boss != null && (TimeUtils.millis() - boss.getLastDamageTime() > damageInterval && boss.overlaps(player))) {
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
            if(TimeUtils.millis() - boss.getLastDamageTime() > damageInterval)
                boss.setInAttack(false);
        }


        if (boss != null && boss.getHp() <= 0 ){
             isgame = false;
             defeatTime = TimeUtils.millis();
             stage.clear();
             boss = null;
            // game.setScreen(new HomeScreen(game));

        }

        if(player.getK() >= 3){
            player.setInShield(false);
        }

    }

    public void spawnShoots(){
        player.setLastStar(TimeUtils.millis());
        shoots.add(new Fireball(player, -1, 1, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
        shoots.add(new Fireball(player, 0, 1, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
        shoots.add(new Fireball(player, 1, 1, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
        shoots.add(new Fireball(player, -1, 0, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
        shoots.add(new Fireball(player, 1, 0, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
        shoots.add(new Fireball(player, -1, -1, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
        shoots.add(new Fireball(player, 0, -1, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
        shoots.add(new Fireball(player, 1, -1, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)));
    }

    public void spawnShoot(float dx, float dy){
        if(player.isAlive() && TimeUtils.millis() - lastShootTime > shootInterval) {
            //Array<EnemyWarrior> array = new Array<>();

            animationAttack.setFrame(1);
            animationAttack.setCurrentFrameTime(0);
            animationAttack2.setFrame(1);
            animationAttack2.setCurrentFrameTime(0);

            if(dx < 0){
                animationAttack2.setStart(true);
            }else{
                animationAttack.setStart(true);
            }

            Fireball newShoot = new Fireball(player, dx, dy, grassArray.get(0).getVx(), grassArray.get(0).getVy(), GameScreen.SCR_WIDTH/90f, new Animation(trAnimFB,4,0.5f)); // подаются главный герой, последние ненулевые значения положения джойстика, скорости по х и у заднего фона и относительная скорость полета снаряда
            shoots.add(newShoot);
            lastShootTime = TimeUtils.millis();



			/*for (int i = 0; i < shipEnemies.size ; i++) {
				if (shipEnemies.get(i).x > 0 - shipEnemies.get(i).width && shipEnemies.get(i).x < GameScreen.SCR_WIDTH && shipEnemies.get(i).y > 0 - shipEnemies.get(i).height && shipEnemies.get(i).y < GameScreen.SCR_HEIGHT){
					array.add(shipEnemies.get(i));
					shoots.add(newShoot);
					lastShootTime = TimeUtils.millis();
				}
			}
			for (int i = 0; i < array.size ; i++) {
				 dx = array.get(i).x - ship.x;
				 dy = array.get(i).y - ship.y;
				array.get(i).setDistance((float) (Math.sqrt(dx*dx+dy*dy)));
			}
			array.sort(new Comparator<ShipEnemy>() {
				@Override
				public int compare(ShipEnemy t0, ShipEnemy t1) {
					return (int) (t0.getDistance() - t1.getDistance());
				}
			});

			int z = 15;
			if (array.size != 0) {
				dx = array.get(0).x - ship.x;
				dy = array.get(0).y - ship.y;*/
			/*int z = 35;

			if (dx == 0 && dy == 0){
				newShoot.setDvx(0);
				newShoot.setDvy(z);
				newShoot.setRotation(0);
			}

				try {
					float tg = dy / dx;
					float ctg = dx / dy;

					if (tg <= 1 && tg >= -1) {
						if (dx > 0) {
							newShoot.setDvx(z + stars.get(0).getVx());
							newShoot.setDvy(z * tg + stars.get(0).getVy());
							newShoot.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
						}
						if (dx < 0) {
							newShoot.setDvx(-z + stars.get(0).getVx());
							newShoot.setDvy(-z * tg + stars.get(0).getVy());
							newShoot.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
						}
					} else {
						if (dy > 0) {
							newShoot.setDvx(z * ctg + stars.get(0).getVx());
							newShoot.setDvy(z + stars.get(0).getVy());
							if (dx > 0)
								newShoot.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
							if (dx < 0)
								newShoot.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
						}
						if (dy < 0) {
							newShoot.setDvx(-z * ctg +stars.get(0).getVx());
							newShoot.setDvy(-z + stars.get(0).getVy());
							if (dx > 0)
								newShoot.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
							if (dx < 0)
								newShoot.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
						}
					}


				} catch (ArithmeticException e) {
					if (dx == 0) {
						if (dy > 0) {
							newShoot.setDvx(0);
							newShoot.setDvy(z + stars.get(0).getVy());
							newShoot.setRotation(0);
						}
						if (dy < 0) {
							newShoot.setDvx(0);
							newShoot.setDvy(-z + stars.get(0).getVy());
							newShoot.setRotation(180);
						}

					}
					if (dy == 0) {
						if (dx > 0) {
							newShoot.setDvx(z + stars.get(0).getVx());
							newShoot.setDvy(0);
							newShoot.setRotation(-90);
						}
						if (dx < 0) {
							newShoot.setDvx(-z + stars.get(0).getVx());
							newShoot.setDvy(0);
							newShoot.setRotation(90);
						}
					}
				}*/
        }

    }

    void spawnEnemyShoot(EnemyArcher enemyArcher, float dx, float dy) {
        enemyShoots.add(new EnemyShoot(enemyArcher, dx, dy, GameScreen.SCR_WIDTH/150f));
        enemyArcher.setLastShootTime(TimeUtils.millis());
        enemyArcher.getAnimation1().setFrame(0);
        enemyArcher.getAnimation1().setCurrentFrameTime(0);
        enemyArcher.getAnimation2().setFrame(0);
        enemyArcher.getAnimation2().setCurrentFrameTime(0);

    }
    void spawnBossShoot(Boss1 boss, float dx,float dy){
        bossShoots.add(new Shoot(boss, dx,dy,grassArray.get(0).getVx(),grassArray.get(0).getVy(),GameScreen.SCR_WIDTH/150f, GameScreen.SCR_WIDTH/20f, GameScreen.SCR_WIDTH/10f));

    }

    void spawnNinja(){
        if(isgame){
            ninjas.add(new Ninja(trees,
                    player,
                    new Animation(trAnimAttackN,5,0.5f),
                    new Animation(trAnimAttackN2, 5, 0.5f),
                    new Animation(trAnimMoveN,6,1),
                    new Animation(trAnimMoveN2,6,1)));
            lastenemyNinjaSpawnTime = TimeUtils.millis();
        }
    }

    void spawnEnemyWarrior() {
        if (isgame) {
            enemyWarriors.add(new EnemyWarrior(new Animation(trAnimSlime,6,0.5f),trees));
            lastEnemyWarriorSpawnTime = TimeUtils.millis();
            if(!isDmgW){
                dmgW = enemyWarriors.get(0).getDmg();
                isDmgW = true;
            }
        }
    }
    void spawnEnemyArcher() {
        if (isgame) {
            enemyArchers.add(new EnemyArcher(new Animation(trAnimArcher1,6,0.5f), new Animation(trAnimArcher2,6,0.5f),trees));
            lastEnemyArcherSpawnTime = TimeUtils.millis();
        }
    }
    void spawnMyTree(){
        if(isgame){
            trees.add(new MyTree(enemyArchers, enemyWarriors));
            lastTreeSpawn = TimeUtils.millis();
        }
    }
    public void blink() {
        if (player.isAlive() && TimeUtils.millis() - lastBlinkTime > blinkInterval) {
            lastBlinkTime = TimeUtils.millis();
            float z = SCR_WIDTH/4f;
            float blix = 0;
            float bliy = 0;

            if (dx == 0 && dy == 0) {
                blix = 0;
                bliy = z;
            }

            try {
                float tg = dy / dx;
                float ctg = dx / dy;

                if (tg <= 1 && tg >= -1) {
                    if (dx > 0) {
                        blix = z;
                        bliy = z * tg;
                    }
                    if (dx < 0) {
                        blix = -z;
                        bliy = -z * tg;
                    }
                } else {
                    if (dy > 0) {
                        blix = z * ctg;
                        bliy = z;

                    }
                    if (dy < 0) {
                        blix = -z * ctg;
                        bliy = -z;

                    }
                }


            } catch (ArithmeticException e) {
                if (dx == 0) {
                    if (dy > 0) {
                        blix = 0;
                        bliy = z;

                    }
                    if (dy < 0) {
                        blix = 0;
                        bliy = -z;

                    }

                }
                if (dy == 0) {
                    if (dx > 0) {
                        blix = z;
                        bliy = 0;

                    }
                    if (dx < 0) {
                        blix = -z;
                        bliy = 0;

                    }
                }
            }

            for (int i = 0; i < grassArray.size; i++) {
                grassArray.get(i).setX(grassArray.get(i).getX() - blix);
                grassArray.get(i).setY(grassArray.get(i).getY() - bliy);
            }
            for (int i = 0; i < shoots.size; i++) {
                shoots.get(i).setX(shoots.get(i).getX() - blix);
                shoots.get(i).setY(shoots.get(i).getY() - bliy);
            }
            for (int i = 0; i < enemyShoots.size; i++) {
                enemyShoots.get(i).setX(enemyShoots.get(i).getX() - blix);
                enemyShoots.get(i).setY(enemyShoots.get(i).getY() - bliy);
            }
            for (int i = 0; i < ninjas.size; i++) {
                ninjas.get(i).setX(ninjas.get(i).getX() - blix);
                ninjas.get(i).setY(ninjas.get(i).getY() - bliy);
            }
            for (int i = 0; i < enemyWarriors.size; i++) {
                enemyWarriors.get(i).setX(enemyWarriors.get(i).getX() - blix);
                enemyWarriors.get(i).setY(enemyWarriors.get(i).getY() - bliy);
            }
            for (int i = 0; i < enemyArchers.size; i++) {
                enemyArchers.get(i).setX(enemyArchers.get(i).getX() - blix);
                enemyArchers.get(i).setY(enemyArchers.get(i).getY() - bliy);
            }
            for (int i = 0; i < trees.size; i++) {
                trees.get(i).setX(trees.get(i).getX() - blix);
                trees.get(i).setY(trees.get(i).getY() - bliy);
            }

            player.setInblink(true);
            player.setLastinblink(TimeUtils.millis());
            animationBlink.setFrame(0);
            animationBlink2.setFrame(0);

        }
    }



    private void gameOver(){
        player.setAlive(false);
        isgame = false;
        defeatTime = TimeUtils.millis();
        stage.clear();
        animationDeath.setFrame(0);
        animationDeath2.setFrame(0);

        enemyWarriors.clear();
        ninjas.clear();
        enemyArchers.clear();
        trees.clear();

        if(Progress.isHardMode) {
            Progress.deleteProgress();
        }
    }

    private void loadResources(){
        circle = new Texture("circletest (2).png");
        circleStar = new Texture("circletest (3).png");
        circleShield = new Texture("circletest (4).png");
        cursor = new Texture("png_cursor.png");
        imgFireball = new Texture("FB002.png");
        imgArrow = new Texture("Arrow.png");
        imgGrass = new Texture("grass.png");
        imgTree = new Texture("tree.png");
        imgAnimAttack = new Texture("AttackAnimation.png");
        imgAnimAttack2 = new Texture("AttackAnimation2.png");
        imgAnimSlime = new Texture("SlimeAnimation.png");
        imgAnimArcher1 = new Texture("ArcherAnimation1.png");
        imgAnimArcher2 = new Texture("ArcherAnimation2.png");
        imgAnimBlink = new Texture("AnimationBlink.png");
        imgAnimBlink2 = new Texture("AnimationBlink2.png");
        imgAnimDeath = new Texture("AnimationDeath.png");
        imgAnimDeath2 = new Texture("AnimationDeath2.png");
        imgAnimFB = new Texture("AnimationFB.png");
        imgAnimIdle = new Texture("idleAnim.png");
        imgAnimIdle2 = new Texture("idleAnim2.png");
        imgAnimMove = new Texture("moveAnim.png");
        imgAnimMove2 = new Texture("moveAnim2.png");
        imgAnimMoveN = new Texture("AnimationMoveNinja.png");
        imgAnimMoveN2 = new Texture("AnimationMoveNinja2.png");
        imgAnimAttackN = new Texture("AnimationAttackNinja.png");
        imgAnimAttackN2 = new Texture("AnimationAttackNinja2.png");
        imgBossAnimMove = new Texture("Boss1Run.png");
        imgBossAnimMove2 = new Texture("Boss1Run2.png");
        imgBossAnimAttack = new Texture("Boss1Attack.png");
        imgBossAnimAttack2 = new Texture("Boss1Attack2.png");
        bg1 = new Texture("PaternForLvl1_1_v1.png");
        bg2 = new Texture("PaternForLvl1_2_v1.png");
        bg3 = new Texture("PaternForLvl1_3_v1.png");
        imgBossShell = new Texture("Attack1(shell).png");
        imgBossAnimShoot = new Texture("Boss1Shoot.png");
        imgBossAnimShoot2 = new Texture("Boss1Shoot2.png");
        imgAnimShield = new Texture("AnimShield.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        actions();

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for (int i = 0; i < grassArray.size; i++)
            batch.draw(grassArray.get(i).getCurTexture(), grassArray.get(i).getX(), grassArray.get(i).getY(), grassArray.get(i).getWidth(), grassArray.get(i).getHeight());

        if(score <= 100) {
            font.draw(batch, score + "/50", SCR_WIDTH / 12f, SCR_HEIGHT - 10);
        }else{
            font.draw(batch,  "50/50", SCR_WIDTH / 12f, SCR_HEIGHT - 10);
        }

        if(boss != null)
        font.draw(batch,boss.getHp() + "/1000",boss.getX() - boss.getWidth()/2f,boss.getY() + boss.getHeight() + 10);

        for (int i = 0; i < ninjas.size ; i++) {
            font.draw(batch,ninjas.get(i).getHp() + "/50", ninjas.get(i).getX() - GameScreen.SCR_WIDTH/100f,ninjas.get(i).getY() + ninjas.get(i).getHeight() + 10);
        }

        for (int i = 0; i < enemyWarriors.size ; i++) {
            font.draw(batch,enemyWarriors.get(i).getHp() + "/" + hpW, enemyWarriors.get(i).getX() - GameScreen.SCR_WIDTH/100f,enemyWarriors.get(i).getY() + enemyWarriors.get(i).getHeight() + 10);
            if(enemyWarriors.get(i).getLastDamageTime() + damageInterval - TimeUtils.millis() > 0){
                enemyWarriors.get(i).getAnimation().update(delta);
            }
        }

        for (int i = 0; i < enemyArchers.size ; i++) {
            font.draw(batch,enemyArchers.get(i).getHp() + "/50", enemyArchers.get(i).getX(),enemyArchers.get(i).getY() + enemyArchers.get(i).getHeight() + 10);
            if (enemyArchers.get(i).getLastShootTime() + enemyShootInterval - TimeUtils.millis() > 2500){
                enemyArchers.get(i).getAnimation1().update(delta);
                enemyArchers.get(i).getAnimation2().update(delta);
            }
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

        if(player.isInblink()){
            if((player.getRotation() > 0 && player.getRotation() <= 180))
                batch.draw(animationBlink2.getFrame(), player.getX(), player.getY(),   player.getWidth(), player.getHeight());
            if((player.getRotation() > -180 && player.getRotation() <= 0 ))
                batch.draw(animationBlink.getFrame(), player.getX(), player.getY(),   player.getWidth(), player.getHeight());
        }else {
            if(player.isAlive()){

                if(!animationAttack.isStart() && !animationAttack2.isStart()) {
                    if (grassArray.get(0).getVx() == 0 && grassArray.get(0).getVy() == 0) {
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
        }

        if(player.isInShield()){
            batch.draw(animationShield.getFrame(),player.getX()-player.getWidth(),player.getY() - player.getHeight()/2f,player.getWidth()*3,player.getWidth()*3);
        }

        for (int i = 0; i < shoots.size; i++) {
            batch.draw(shoots.get(i).getAnim().getFrame(), shoots.get(i).getX(), shoots.get(i).getY(), shoots.get(i).getWidth() / 2, shoots.get(i).getHeight() / 2, shoots.get(i).getWidth(), shoots.get(i).getHeight(), 1, 1, shoots.get(i).getRotation());
        }

        for (int i = 0; i < enemyShoots.size; i++) {
            batch.draw(trArrow, enemyShoots.get(i).getX(), enemyShoots.get(i).getY(), enemyShoots.get(i).getWidth() / 2, enemyShoots.get(i).getHeight() / 2, enemyShoots.get(i).getWidth(), enemyShoots.get(i).getHeight(), 1, 1, enemyShoots.get(i).getRotation());
        }

        for (int i = 0; i < bossShoots.size; i++) {
            batch.draw(trBossShell, bossShoots.get(i).getX(), bossShoots.get(i).getY(), bossShoots.get(i).getWidth() / 2, bossShoots.get(i).getHeight() / 2, bossShoots.get(i).getWidth(), bossShoots.get(i).getHeight(), 1, 1, bossShoots.get(i).getRotation());
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
                        batch.draw(boss.getAnimMove().getFrame(), boss.getX(), boss.getY(), boss.getWidth()*1.5f, boss.getHeight());
                    } else {
                        batch.draw(boss.getAnimMove2().getFrame(), boss.getX(), boss.getY(), boss.getWidth()*1.5f, boss.getHeight());
                    }
                }
            }
        }


        for (int i = 0; i < ninjas.size; i++) {

            if(ninjas.get(i).isInAttack()){
                if(player.getX() >= ninjas.get(i).getX()){
                    batch.draw(ninjas.get(i).getAnimAttack().getFrame(), ninjas.get(i).getX(), ninjas.get(i).getY(),ninjas.get(i).getWidth(),ninjas.get(i).getHeight());
                }else{
                    batch.draw(ninjas.get(i).getAnimAttack2().getFrame(), ninjas.get(i).getX(), ninjas.get(i).getY(),ninjas.get(i).getWidth(),ninjas.get(i).getHeight());
                }
            }else{
                if(player.getX() >= ninjas.get(i).getX()){
                    batch.draw(ninjas.get(i).getAnimMove().getFrame(), ninjas.get(i).getX(), ninjas.get(i).getY(),ninjas.get(i).getWidth(),ninjas.get(i).getHeight());
                }else{
                    batch.draw(ninjas.get(i).getAnimMove2().getFrame(), ninjas.get(i).getX(), ninjas.get(i).getY(),ninjas.get(i).getWidth(),ninjas.get(i).getHeight());
                }
            }
        }


        for (int i = 0; i < enemyWarriors.size; i++) {
            batch.draw(enemyWarriors.get(i).getAnimation().getFrame(), enemyWarriors.get(i).getX(), enemyWarriors.get(i).getY(), enemyWarriors.get(i).getWidth(), enemyWarriors.get(i).getHeight());
        }

        for (int i = 0; i < enemyArchers.size; i++) {
            if(player.getX() - enemyArchers.get(i).getX() >= 0)
                batch.draw(enemyArchers.get(i).getAnimation1().getFrame(), enemyArchers.get(i).getX(), enemyArchers.get(i).getY(), enemyArchers.get(i).getWidth(), enemyArchers.get(i).getHeight());
            else
                batch.draw(enemyArchers.get(i).getAnimation2().getFrame(), enemyArchers.get(i).getX(), enemyArchers.get(i).getY(), enemyArchers.get(i).getWidth(), enemyArchers.get(i).getHeight());

        }

        for (int i = 0; i < trees.size; i++) {
            batch.draw(imgTree, trees.get(i).getX() - trees.get(i).getWidth(), trees.get(i).getY(),  trees.get(i).getWidth() * 3, trees.get(i).getHeight() * 10);
        }

        if(player.getLastinblink() + 200 - TimeUtils.millis() > 0){
            animationBlink.update(delta);
            animationBlink2.update(delta);
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

        for (int i = 0; i < ninjas.size; i++) {
            ninjas.get(i).getAnimMove().update(delta);
            ninjas.get(i).getAnimMove2().update(delta);
            ninjas.get(i).getAnimAttack().update(delta);
            ninjas.get(i).getAnimAttack2().update(delta);


            if(TimeUtils.millis() - ninjas.get(i).getLastDamageTime() > damageInterval){
                ninjas.get(i).setInAttack(false);
            }

        }
        if(player.getHp() >= 0 ) {
            font.draw(batch, player.getHp() + "/" + hpP, player.getX(), player.getY()+player.getHeight()+10);
        }else{
            font.draw(batch, "0/" + hpP, player.getX(), player.getY()+player.getHeight()+10);
        }

        if(!isgame){
            if(!player.isAlive()) {
                font.draw(batch, "DEFEAT! TAP TO GO HOME", SCR_WIDTH / 2f - 85, SCR_HEIGHT / 2f - 5);
            }else{
                font.draw(batch, "VICTORY! TAP TO CONTINUE", SCR_WIDTH / 2f - 85, SCR_HEIGHT / 2f - 5);
            }
        }

        if(TimeUtils.millis()-defeatTime > defeatInterval && !isgame && Gdx.input.isTouched()){
            game.setScreen(new HomeScreen(game));
            if(player.isAlive()) {
                Progress.is1lvlWin = true;
                Progress.exp = Progress.exp + Progress.expToNextLvl;
                Progress.lvlPlayer = 1 + (Progress.exp/Progress.expToNextLvl);
                Progress.talentPoints++;
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
    public void dispose () {
        batch.dispose();
        imgGrass.dispose();
        imgFireball.dispose();
        imgArrow.dispose();
        cursor.dispose();
        circle.dispose();
        circleStar.dispose();
        circleShield.dispose();
        imgTree.dispose();
        imgAnimAttack.dispose();
        imgAnimAttack2.dispose();
        imgAnimSlime.dispose();
        imgAnimArcher1.dispose();
        imgAnimArcher2.dispose();
        imgAnimDeath.dispose();
        imgAnimDeath2.dispose();
        imgAnimBlink.dispose();
        imgAnimBlink2.dispose();
        imgAnimIdle.dispose();
        imgAnimIdle2.dispose();
        imgAnimMove.dispose();
        imgAnimMove2.dispose();
        imgAnimAttackN.dispose();
        imgAnimAttackN2.dispose();
        imgAnimMoveN.dispose();
        imgAnimMoveN2.dispose();
        imgAnimFB.dispose();
        imgBossAnimMove.dispose();
        imgBossAnimMove2.dispose();
        imgBossAnimAttack.dispose();
        imgBossAnimAttack2.dispose();
        bg1.dispose();
        bg2.dispose();
        bg3.dispose();
        imgBossShell.dispose();
        imgBossAnimShoot.dispose();
        imgBossAnimShoot2.dispose();
        imgAnimShield.dispose();


    }

}

