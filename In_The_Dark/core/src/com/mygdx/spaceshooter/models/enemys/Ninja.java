package com.mygdx.spaceshooter.models.enemys;

import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.models.MyTree;
import com.mygdx.spaceshooter.models.Player;

import static com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH;

public class Ninja extends Enemy {
    long lastDamageTime;
    Player player;
    Animation animAttack;
    Animation animAttack2;
    Animation animMove;
    Animation animMove2;
    boolean inAttack = false;
    int dmg;
    int exp;

    public Ninja(Array<MyTree> trees, Player player, Animation animAttack, Animation animAttack2, Animation animMove, Animation animMove2) {
        super((int)(5*(0.9f*Progress.lvlPlayer)), SCR_WIDTH/10f, GameScreen.SCR_HEIGHT/10f, trees);
        this.player = player;
        this.animAttack = animAttack;
        this.animAttack2 = animAttack2;

        this.animMove = animMove;
        this.animMove2 = animMove2;

        dmg = (int)(Progress.lvlPlayer*10/5);
        int e;
        if(Progress.lvlPlayer < 19) {
            e = (int) (3000 - (3000 * 0.05f * Progress.lvlPlayer));
        }else{
            e = 200;
        }
        this.exp = e;
    }

    public long getLastDamageTime() {
        return lastDamageTime;
    }

    public void setLastDamageTime(long lastDamageTime) {
        this.lastDamageTime = lastDamageTime;
    }



    public void move(float grassVX, float grassVY, Array<MyTree> trees) {
        float dx = player.getX() - this.getX();
        float dy = player.getY() - this.getY();

        float z = SCR_WIDTH/300f;

        if (dx == 0 && dy == 0){
            this.setVx(0);
            this.setVy(0);

        }

        try {
            float tg = dy / dx;
            float ctg = dx / dy;

            if (tg <= 1 && tg >= -1) {
                if (dx > 0) {
                    this.setVx(z + grassVX);
                    this.setVy(z * tg + grassVY);

                }
                if (dx < 0) {
                    this.setVx(-z + grassVX);
                    this.setVy(-z * tg + grassVY);

                }
            } else {
                if (dy > 0) {
                    this.setVx(z * ctg + grassVX);
                    this.setVy(z + grassVY);

                }
                if (dy < 0) {
                    this.setVx(-z * ctg + grassVX);
                    this.setVy(-z + grassVY);

                }
            }


        } catch (ArithmeticException e) {
            if (dx == 0) {
                if (dy > 0) {
                    this.setVx(0);
                    this.setVy(z + grassVY);

                }
                if (dy < 0) {
                    this.setVx(0);
                    this.setVy(-z + grassVY);

                }

            }
            if (dy == 0) {
                if (dx > 0) {
                    this.setVx(z + grassVX);
                    this.setVy(0);

                }
                if (dx < 0) {
                    this.setVx(-z + grassVX);
                    this.setVy(0);

                }
            }
        }


        for (int i = 0; i < trees.size; i++) {


            if(trees.get(i).overlaps(this)) {


                if (this.getX() > trees.get(i).getX() && trees.get(i).getX() > this.getX() - trees.get(i).getWidth() - trees.get(i).getWidth() / 2f && trees.get(i).getX() < this.getX()  - trees.get(i).getWidth()) {
                    if(this.getX() > player.getX()) this.setVx(grassVX);
                } else {
                    if (this.getX() < trees.get(i).getX() && trees.get(i).getX() > this.getX() + this.getWidth()/2f && trees.get(i).getX() < this.getX() + this.getWidth()/2f + trees.get(i).getWidth() / 2f) {
                        if(this.getX() < player.getX())this.setVx(grassVX);
                    }else {
                        if(this.getY() > trees.get(i).getY() && player.getY()<this.getY()) this.setVy(grassVY);
                        if(this.getY() < trees.get(i).getY() && player.getY() > this.getY()) this.setVy(grassVY);

                    }
                }
            }
        }
        super.move();
    }

    public Animation getAnimAttack() {
        return animAttack;
    }

    public Animation getAnimAttack2() {
        return animAttack2;
    }

    public Animation getAnimMove() {
        return animMove;
    }

    public Animation getAnimMove2() {
        return animMove2;
    }

    public boolean isInAttack() {
        return inAttack;
    }

    public void setInAttack(boolean inAttack) {
        this.inAttack = inAttack;
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

