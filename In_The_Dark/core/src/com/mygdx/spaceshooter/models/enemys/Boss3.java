package com.mygdx.spaceshooter.models.enemys;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.models.GameObject;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.models.shoots.Shoot;
import com.mygdx.spaceshooter.models.shoots.Tornado;
import com.mygdx.spaceshooter.screens.GameScreen;

public class Boss3 extends GameObject {

    Player player;
    int hp;
    Array<Shoot> shoots;
    Array<Shoot> laserShoots;
    Array<Tornado> tornadoes;
    Animation animAttack11;
    Animation animAttack12;
    Animation animAttack2;
    Animation animAttack31;
    Animation animAttack32;
    Animation animTp;
    Animation animResist;
    boolean attack1InCast;
    boolean attack2InCast;
    boolean attack3InCast;
    boolean tpInCast;
    boolean resistInCast;
    boolean attack2;
    boolean attack3;
    boolean resist;
    boolean inSpell;
    long lastStartCastAttack1;
    long lastStartCastAttack2;
    long lastStartCastAttack3;

    long lastStartCastTp;
    long lastStartCastResist;
    long lastFinishSpell;



    public Boss3(Player player, Animation animAttack11, Animation animAttack12, Animation animAttack2, Animation animAttack31, Animation animAttack32, Animation animTp, Animation animResist, Array<Shoot> shoots, Array<Shoot> laserShoots, Array<Tornado> tornadoes) {
        super(GameScreen.SCR_WIDTH/2f - player.getWidth()*2f/2f, GameScreen.SCR_HEIGHT/2f - player.getWidth()*2f/2f, player.getWidth()*2f, player.getWidth()*2f, true, 0,0);
        this.player = player;
        this.hp = 35000;
        this.animAttack11 = animAttack11;
        this.animAttack12 = animAttack12;
        this.animAttack2 = animAttack2;
        this.animAttack31 = animAttack31;
        this.animAttack32 = animAttack32;
        this.animTp = animTp;
        this.animResist = animResist;
        this.shoots = shoots;
        this.laserShoots = laserShoots;
        this.tornadoes = tornadoes;
    }

    public void update(float delta){
        if(TimeUtils.millis() - lastFinishSpell > 1000 && !inSpell){
            startCastRandomSpell();
        }
        if(attack1InCast && TimeUtils.millis() - lastStartCastAttack1 > 1000){
            shoots.add(new Shoot(this,(player.getX() + player.getWidth()/2f) - (this.getX()+this.getWidth()/2f),(player.getY() + player.getHeight()/2f) - (this.getY() + this.getHeight()/2f), 0,0, GameScreen.SCR_WIDTH/150f, GameScreen.SCR_WIDTH/40f, GameScreen.SCR_WIDTH/20f));
            lastFinishSpell = TimeUtils.millis();
            attack1InCast = false;
            inSpell = false;
        }
        if(attack2InCast && TimeUtils.millis() - lastStartCastAttack2 > 1000){
            attack2InCast = false;
            attack2 = true;
            tornadoes.add(new Tornado());
            tornadoes.add(new Tornado());
            tornadoes.add(new Tornado());
            tornadoes.add(new Tornado());
            tornadoes.add(new Tornado());

        }
        if(attack2 && TimeUtils.millis() - lastStartCastAttack2 > 2000){
            lastFinishSpell = TimeUtils.millis();
            attack2 = false;
            inSpell = false;
        }

        if(attack3InCast && TimeUtils.millis() - lastStartCastAttack3 > 1000){
            attack3InCast = false;
            attack3 = true;
        }

        if(attack3){
            laserShoots.add(new Shoot(this,(player.getX() + player.getWidth()/2f) - (this.getX()+this.getWidth()/2f),(player.getY() + player.getHeight()/2f) - (this.getY() + this.getHeight()), GameScreen.SCR_WIDTH/150f,GameScreen.SCR_WIDTH/80f, GameScreen.SCR_WIDTH/20f));
            if(TimeUtils.millis() - lastStartCastAttack3 > 2000){
                lastFinishSpell = TimeUtils.millis();
                attack3 = false;
                inSpell = false;

            }
        }

        if(tpInCast && TimeUtils.millis() - lastStartCastTp > 1000){
            tpRandomPos(this.getX(),this.getY());
            lastFinishSpell = TimeUtils.millis();
            tpInCast = false;
            inSpell = false;
        }

        if (resistInCast && TimeUtils.millis() - lastStartCastResist > 1000){
            resistInCast = false;
            resist = true;
        }
        if (resist && TimeUtils.millis() - lastStartCastResist > 3000){
            lastFinishSpell = TimeUtils.millis();
            resist = false;
            inSpell = false;
        }

        animAttack11.update(delta);
        animAttack12.update(delta);
        animAttack2.update(delta);
        animAttack31.update(delta);
        animAttack32.update(delta);
        animResist.update(delta);
        animTp.update(delta);


    }

    public void startCastAttack1(){
        attack1InCast = true;
        lastStartCastAttack1 = TimeUtils.millis();
        animAttack11.setFrame(0);
        animAttack11.setCurrentFrameTime(0);
        animAttack12.setFrame(0);
        animAttack12.setCurrentFrameTime(0);
    }

    public void startCastAttack2(){
        attack2InCast = true;
        lastStartCastAttack2 = TimeUtils.millis();
        animAttack2.setFrame(0);
        animAttack2.setCurrentFrameTime(0);
    }
    public void startCastAttack3(){
        attack3InCast = true;
        lastStartCastAttack3 = TimeUtils.millis();
        animAttack31.setFrame(0);
        animAttack31.setCurrentFrameTime(0);
        animAttack32.setFrame(0);
        animAttack32.setCurrentFrameTime(0);
    }
    public void startCastTp(){
        tpInCast = true;
        lastStartCastTp = TimeUtils.millis();
        animTp.setFrame(0);
        animTp.setCurrentFrameTime(0);
    }
    public void startCastResist(){
        resistInCast = true;
        lastStartCastResist = TimeUtils.millis();
        animResist.setFrame(0);
        animResist.setCurrentFrameTime(0);
    }

    public void startCastRandomSpell(){
        int random = (int) Math.floor(Math.random()*10);
        if(random == 0) startCastAttack1();//1
        if(random == 1) startCastAttack1();//1
        if(random == 2) startCastAttack1();//1
        if(random == 3) startCastAttack2();
        if(random == 4) startCastAttack3();
        if(random == 5) startCastTp();
        if(random == 6) startCastTp();
        if(random == 7) startCastTp();
        if(random == 8) startCastResist();
        if(random == 9) startCastResist();
        inSpell = true;



        }

        public void tpRandomPos(float x, float y){
            int random = (int) Math.floor(Math.random()*5);
            if(random == 0){
                this.setX(GameScreen.SCR_WIDTH/2f - player.getWidth()*2f/2f);
                this.setY(GameScreen.SCR_HEIGHT/2f - player.getWidth()*2f/2f);

            }
            if(random == 1){
                this.setX(GameScreen.SCR_WIDTH/2f - player.getWidth()*2f/2f + GameScreen.SCR_WIDTH/4f);
                this.setY(GameScreen.SCR_HEIGHT/2f - player.getWidth()*2f/2f + GameScreen.SCR_HEIGHT/4f);

            }
            if(random == 2){
                this.setX(GameScreen.SCR_WIDTH/2f - player.getWidth()*2f/2f + GameScreen.SCR_WIDTH/4f);
                this.setY(GameScreen.SCR_HEIGHT/2f - player.getWidth()*2f/2f - GameScreen.SCR_HEIGHT/4f);

            }
            if(random == 3){
                this.setX(GameScreen.SCR_WIDTH/2f - player.getWidth()*2f/2f - GameScreen.SCR_WIDTH/4f);
                this.setY(GameScreen.SCR_HEIGHT/2f - player.getWidth()*2f/2f + GameScreen.SCR_HEIGHT/4f);

            }
            if(random == 4){
                this.setX(GameScreen.SCR_WIDTH/2f - player.getWidth()*2f/2f  - GameScreen.SCR_WIDTH/4f);
                this.setY(GameScreen.SCR_HEIGHT/2f - player.getWidth()*2f/2f - GameScreen.SCR_HEIGHT/4f);

            }

            if(this.getX() == x && this.getY() == y){
               tpRandomPos(x, y);
            }
        }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAttack1InCast() {
        return attack1InCast;
    }

    public boolean isAttack2InCast() {
        return attack2InCast;
    }

    public boolean isAttack3InCast() {
        return attack3InCast;
    }

    public boolean isAttack2() {
        return attack2;
    }

    public boolean isAttack3() {
        return attack3;
    }

    public boolean isInSpell() {
        return inSpell;
    }

    public boolean isResistInCast() {
        return resistInCast;
    }

    public boolean isResist() {
        return resist;
    }

    public boolean isTpInCast() {
        return tpInCast;
    }


    public Animation getAnimAttack11() {
        return animAttack11;
    }

    public Animation getAnimAttack12() {
        return animAttack12;
    }

    public Animation getAnimAttack2() {
        return animAttack2;
    }

    public Animation getAnimAttack31() {
        return animAttack31;
    }

    public Animation getAnimAttack32() {
        return animAttack32;
    }

    public Animation getAnimTp() {
        return animTp;
    }

    public Animation getAnimResist() {
        return animResist;
    }
}


