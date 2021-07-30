package com.mygdx.spaceshooter.models.enemys;

import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.models.MyTree;
import com.mygdx.spaceshooter.models.Player;

public class Samurai extends Boss1 {
    int dmg;
    int dmgShoot;
    int exp;
    public Samurai( Array<MyTree> trees, Player player, Animation animAttack, Animation animAttack2, Animation animMove, Animation animMove2, Animation animShoot, Animation animShoot2) {
        super(((int)(5*(0.9f*Progress.lvlPlayer))), trees, player, animAttack, animAttack2, animMove, animMove2, animShoot, animShoot2);

        dmg = (int)(Progress.lvlPlayer*10/5);
        dmgShoot = (int)(Progress.lvlPlayer*10/7);
        int e;
        if(Progress.lvlPlayer < 19) {
            e = (int) (3000 - (3000 * 0.05f * Progress.lvlPlayer));
        }else{
            e = 200;
        }
        this.exp = e;

        this.setHeight(this.getHeight()/2f * 1.5f * 1.25f);
        this.setWidth(this.getHeight() * 1.25f);
    }

    public int getDmg() {
        return dmg;
    }
    public int getDmgShoot() {
        return dmg;
    }

    public int getExp() {
        return exp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    public void setDmgShoot(int dmg) {
        this.dmg = dmg;
    }

}
