package com.mygdx.spaceshooter.models.enemys;


import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.models.MyTree;

public class EnemyArcher extends Enemy {
    long lastShootTime;
    Animation animation1;
    Animation animation2;
    int dmg;
    int exp;
    public EnemyArcher(Animation animation1, Animation animation2, Array<MyTree> trees){
        super((int)(5*(0.9f*Progress.lvlPlayer)), GameScreen.SCR_WIDTH/20f, GameScreen.SCR_HEIGHT/10f, trees);
        this.animation1 = animation1;
        this.animation2 = animation2;
        this.dmg = (int)(Progress.lvlPlayer*10/10);
        int e;
        if(Progress.lvlPlayer < 19) {
            e = (int) (2000 - (2000 * 0.05f * Progress.lvlPlayer));
        }else{
            e = 150;
        }
        this.exp = e;
    }
    public EnemyArcher(){
        super((int)(5*(0.9f*Progress.lvlPlayer)), GameScreen.SCR_WIDTH/80f, GameScreen.SCR_HEIGHT/40f);
        this.dmg = (int)(Progress.lvlPlayer*10/10);
    }

    public long getLastShootTime() {
        return lastShootTime;
    }

    public void setLastShootTime(long lastShootTime) {
        this.lastShootTime = lastShootTime;
    }

    public Animation getAnimation1() {
        return animation1;
    }

    public Animation getAnimation2() {
        return animation2;
    }

    public int getDmg() {
        return dmg;
    }
    public int getExp(){
        return exp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }


}
