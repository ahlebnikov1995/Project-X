package com.mygdx.spaceshooter.models.shoots;

import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.models.GameObject;

public class Fireball extends Shoot {
    private Animation anim;
    private Boolean isCausedDamage;
    private long lastCausedDamage;

    public Fireball(GameObject Player, float dx, float dy, float starsVX, float starsVY, float z, Animation anim) {
        super(Player, dx, dy, starsVX, starsVY, z, GameScreen.SCR_WIDTH/40f, GameScreen.SCR_WIDTH/20f);
        this.anim = anim;
        isCausedDamage = false;
        this.anim.setFrame(0);
    }

    public Animation getAnim() {
        return anim;
    }

    public Boolean getCausedDamage() {
        return isCausedDamage;
    }

    public void setCausedDamage(Boolean causedDamage) {
        isCausedDamage = causedDamage;
    }

    public long getLastCausedDamage() {
        return lastCausedDamage;
    }

    public void setLastCausedDamage(long lastCausedDamage) {
        this.lastCausedDamage = lastCausedDamage;
    }
}
