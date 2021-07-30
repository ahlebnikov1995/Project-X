package com.mygdx.spaceshooter.models.shoots;

import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.models.GameObject;

public class Shoot extends GameObject {
    private float dvx;
    private float dvy;
    private Animation anim;

   public Shoot(GameObject Player, float dx, float dy, float grassVX, float grassVY, float z, float width, float height){
       super(Player.getX() + Player.getWidth()/2f - width/2f,
               Player.getY() + Player.getHeight()/2f - height/2f,
               width,
               height,
               true,
               0,
               0);



       if (dx == 0 && dy == 0){
           this.dvx = 0;
           this.dvy = z;
           this.setRotation(0);
       }

       try {
           float tg = dy / dx;
           float ctg = dx / dy;

           if (tg <= 1 && tg >= -1) {
               if (dx > 0) {
                   this.dvx = z;
                   this.dvy = z * tg;
                   this.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
               }
               if (dx < 0) {
                   this.dvx = -z;
                   this.dvy = -z * tg;
                   this.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
               }
           } else {
               if (dy > 0) {
                   this.dvx = z * ctg;
                   this.dvy = z;
                   if (dx > 0)
                       this.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                   if (dx < 0)
                       this.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
               }
               if (dy < 0) {
                   this.dvx = -z * ctg;
                   this.dvy = -z;
                   if (dx > 0)
                       this.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                   if (dx < 0)
                       this.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
               }
           }


       } catch (ArithmeticException e) {
           if (dx == 0) {
               if (dy > 0) {
                   this.dvx = 0;
                   this.dvy = z;
                   this.setRotation(0);
               }
               if (dy < 0) {
                   this.dvx = 0;
                   this.dvy = -z;
                   this.setRotation(180);
               }

           }
           if (dy == 0) {
               if (dx > 0) {
                   this.dvx = z;
                   this.dvy = 0;
                   this.setRotation(-90);
               }
               if (dx < 0) {
                   this.dvx = -z;
                   this.dvy = 0;
                   this.setRotation(90);
               }
           }
       }

    }

    public Shoot(GameObject Player, float dx, float dy, float z, float width, float height){
        super(Player.getX() + Player.getWidth()/2f - width/2f,
                Player.getY() + Player.getHeight()/2f,
                width,
                height,
                true,
                0,
                0);



        if (dx == 0 && dy == 0){
            this.dvx = 0;
            this.dvy = z;
            this.setRotation(0);
        }

        try {
            float tg = dy / dx;
            float ctg = dx / dy;

            if (tg <= 1 && tg >= -1) {
                if (dx > 0) {
                    this.dvx = z;
                    this.dvy = z * tg;
                    this.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                }
                if (dx < 0) {
                    this.dvx = -z;
                    this.dvy = -z * tg;
                    this.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
                }
            } else {
                if (dy > 0) {
                    this.dvx = z * ctg;
                    this.dvy = z;
                    if (dx > 0)
                        this.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                    if (dx < 0)
                        this.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
                }
                if (dy < 0) {
                    this.dvx = -z * ctg;
                    this.dvy = -z;
                    if (dx > 0)
                        this.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                    if (dx < 0)
                        this.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
                }
            }


        } catch (ArithmeticException e) {
            if (dx == 0) {
                if (dy > 0) {
                    this.dvx = 0;
                    this.dvy = z;
                    this.setRotation(0);
                }
                if (dy < 0) {
                    this.dvx = 0;
                    this.dvy = -z;
                    this.setRotation(180);
                }

            }
            if (dy == 0) {
                if (dx > 0) {
                    this.dvx = z;
                    this.dvy = 0;
                    this.setRotation(-90);
                }
                if (dx < 0) {
                    this.dvx = -z;
                    this.dvy = 0;
                    this.setRotation(90);
                }
            }
        }

        this.setVx(dvx);
        this.setVy(dvy);

    }

    @Override
    public void move() {
        super.move();

        if (this.getX() < -GameScreen.SCR_WIDTH - this.getWidth() || this.getX() > GameScreen.SCR_WIDTH*2 || this.getY() < -GameScreen.SCR_WIDTH - this.getHeight() || this.getY() > GameScreen.SCR_HEIGHT*2)
            this.setAlive(false);
    }

    public float getDvx() {
        return dvx;
    }

    public float getDvy() {
        return dvy;
    }

    public void setDvx(float dvx) {
        this.dvx = dvx;
    }

    public void setDvy(float dvy) {
        this.dvy = dvy;
    }

    public Animation getAnim() {
        return anim;
    }

    public void setAnim(Animation anim) {
        this.anim = anim;
    }
}
