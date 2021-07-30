package com.mygdx.spaceshooter.models.enemys;

import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.models.MyTree;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.screens.GameScreen;

import static com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH;

public class Boss1 extends Enemy {
    long lastDamageTime;
    long lastShootTime;
    Player player;
    Animation animAttack;
    Animation animAttack2;
    Animation animMove;
    Animation animMove2;
    Animation animShoot;
    Animation animShoot2;
    boolean inAttack = false;
    boolean inShoot = false;

    public Boss1(Integer hp, Array<MyTree> trees,Player player,Animation animAttack, Animation animAttack2, Animation animMove,Animation animMove2,Animation animShoot, Animation animShoot2) {
        super(hp,
                GameScreen.SCR_WIDTH/20f,
                GameScreen.SCR_WIDTH/10f,
                trees);
        this.player = player;
        this.animAttack = animAttack;
        this.animAttack2 = animAttack2;
        this.animMove = animMove;
        this.animMove2 = animMove2;
        this.animShoot = animShoot;
        this.animShoot2 = animShoot2;
    }
    public Boss1(Player player,Animation animAttack, Animation animAttack2, Animation animMove,Animation animMove2,Animation animShoot, Animation animShoot2) {
        super(2000,
                GameScreen.SCR_WIDTH/20f,
                GameScreen.SCR_WIDTH/10f);
        this.player = player;
        this.animAttack = animAttack;
        this.animAttack2 = animAttack2;
        this.animMove = animMove;
        this.animMove2 = animMove2;
        this.animShoot = animShoot;
        this.animShoot2 = animShoot2;
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
        if(this.isInShoot()){
            this.setVx(grassVX);
            this.setVy(grassVY);
        }
        super.move();
    }
    public void move(float grassVX, float grassVY) {
        float dx = player.getX() - this.getX();
        float dy = player.getY() - this.getY();

        float z = SCR_WIDTH/600f;

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

        if(this.isInShoot()){
            this.setVx(grassVX);
            this.setVy(grassVY);
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

    public long getLastShootTime() {
        return lastShootTime;
    }

    public void setLastShootTime(long lastShootTime) {
        this.lastShootTime = lastShootTime;
    }

    public boolean isInShoot() {
        return inShoot;
    }

    public void setInShoot(boolean inShoot) {
        this.inShoot = inShoot;
    }

    public Animation getAnimShoot() {
        return animShoot;
    }

    public void setAnimShoot(Animation animShoot) {
        this.animShoot = animShoot;
    }

    public Animation getAnimShoot2() {
        return animShoot2;
    }

    public void setAnimShoot2(Animation animShoot2) {
        this.animShoot2 = animShoot2;
    }
}


