package com.mygdx.spaceshooter.models.shoots;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.spaceshooter.models.GameObject;
import com.mygdx.spaceshooter.screens.GameScreen;

public class Tornado extends GameObject {
    boolean isCausedDamage;
    long lastSpawnTime;
    float dvx;
    float dvy;
    public Tornado() {
        super(0, 0, GameScreen.SCR_WIDTH/20f, GameScreen.SCR_WIDTH/20f, true, 0, 0);
        setRandomXY_And_V();
        isCausedDamage = false;
        lastSpawnTime = TimeUtils.millis();

    }


   public void setRandomXY_And_V(){
        int random = (int) Math.floor(Math.random()*4);

        if(random == 0){
            this.setX(MathUtils.random(this.getWidth()*2,GameScreen.SCR_WIDTH - this.getWidth()*3));
            this.setY(GameScreen.SCR_HEIGHT-this.getHeight()*3);
            this.setDvy(-GameScreen.SCR_WIDTH/150f);
        }
        if(random == 1){
            this.setX(MathUtils.random(this.getWidth()*2,GameScreen.SCR_WIDTH - this.getWidth()*3));
            this.setY(this.getHeight()*2);
            this.setDvy(GameScreen.SCR_WIDTH/150f);
        }
        if(random == 2){
            this.setX(this.getWidth()*2);
            this.setY(MathUtils.random(this.getHeight()*2, GameScreen.SCR_HEIGHT - this.getHeight()*3));
            this.setDvx(GameScreen.SCR_WIDTH/150f);
        }
        if(random == 3){
            this.setX(GameScreen.SCR_WIDTH - this.getWidth()*3f);
            this.setY(MathUtils.random(this.getHeight()*2, GameScreen.SCR_HEIGHT - this.getHeight()*3));
            this.setDvx(-GameScreen.SCR_WIDTH/150f);
        }
   }

    @Override
    public void move() {
        if(TimeUtils.millis() - lastSpawnTime > 1000){
            this.setVy(dvy);
            this.setVx(dvx);
        }
        super.move();
    }

    public boolean isCausedDamage() {
        return isCausedDamage;
    }

    public void setCausedDamage(boolean causedDamage) {
        isCausedDamage = causedDamage;
    }

    public long getLastSpawnTime() {
        return lastSpawnTime;
    }

    public void setLastSpawnTime(long lastSpawnTime) {
        this.lastSpawnTime = lastSpawnTime;
    }

    public float getDvx() {
        return dvx;
    }

    public void setDvx(float dvx) {
        this.dvx = dvx;
    }

    public float getDvy() {
        return dvy;
    }

    public void setDvy(float dvy) {
        this.dvy = dvy;
    }
}
