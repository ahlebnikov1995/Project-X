package com.mygdx.spaceshooter.models.enemys;

import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.models.MyTree;

public class EnemyWarrior extends Enemy {
    private long lastDamageTime;
    private Animation animation;
    private int dmg;
    private int exp;

   public EnemyWarrior(Animation animation, Array<MyTree> trees){
        super(((int)(10*(0.9f*Progress.lvlPlayer))), GameScreen.SCR_WIDTH/20f, GameScreen.SCR_WIDTH/20f, trees);
        this.animation = animation;
        this.dmg = (int)(Progress.lvlPlayer*10/4);
       int e;
       if(Progress.lvlPlayer < 19) {
           e = (int) (1000 - (1000 * 0.05f * Progress.lvlPlayer));
       }else{
           e = 100;
       }
       this.exp = e;


    }

    public long getLastDamageTime() {
        return lastDamageTime;
    }

    public void setLastDamageTime(long lastDamageTime) {
        this.lastDamageTime = lastDamageTime;
    }

    public Animation getAnimation() {
        return animation;
    }

    public int getDmg() {
        return dmg;
    }

    public int getExp() {
        return exp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
