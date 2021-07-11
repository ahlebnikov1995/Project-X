package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.models.Grass;
import com.mygdx.spaceshooter.models.Player;

public class Joystick extends Actor {

    private Player player;
    private Array<Grass> grassArray = new Array<>();

    private Texture circle;
    private Texture curJoystick;
    private boolean isJoystickDown = false;
    private boolean isPlayerMove;
    private float rad;
    private float cur_radius;
    private float dx;
    private float dy;

    private float curX = 0;
    private float curY = 0;


    public Joystick(Texture circle, Texture curJoystick, Player player, Array<Grass> grassArray, boolean isPlayerMove) {
        this.grassArray = grassArray;
        this.player = player;
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener(new JoystickInputListener(this));
        this.isPlayerMove = isPlayerMove;

    }

    public Joystick(Texture circle, Texture curJoystick, Player player, boolean isPlayerMove) {
        grassArray.add(new Grass(0,0,circle,circle,circle)); // обман системы
        this.player = player;
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener(new JoystickInputListener(this));
        this.isPlayerMove = isPlayerMove;

    }

    public float getDx() {
        return dx;
    }

    public float getDy() {
        return dy;
    }

    public void setTouched(){
        isJoystickDown = true;
    }

    public void setUnTouched(){
        isJoystickDown = false;
        for (int i = 0; i < grassArray.size; i++) {
            grassArray.get(i).setVx(0);
            grassArray.get(i).setVy(0);
            player.setVx(0);
            player.setVy(0);
        }
    }

    public void resetCur(){
        curX = 0;
        curY = 0;
    }

    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/6f);
        setHeight(GameScreen.SCR_WIDTH/6f);
        rad = (GameScreen.SCR_WIDTH/6f) / 2f;
    }
    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/13f);
        setY(GameScreen.SCR_WIDTH/13f);
    }

    public void changeCursor(float x, float y){
         this.dx = x - rad;
         this.dy = y - rad;
        float length = (float) Math.sqrt(dx*dx + dy*dy);
        if(length <= rad) {
            this.curX = dx;
            this.curY = dy;
        }else{
           float k = rad / length;
            this.curX = dx * k;
            this.curY = dy * k;
        }

        for (int i = 0; i < grassArray.size ; i++) {


            if (dx == 0 && dy == 0) {
                grassArray.get(i).setVx(0);
                grassArray.get(i).setVy(0);
                player.setRotation(0);
            } else {
                float z = GameScreen.SCR_WIDTH/255f;
                try {
                    float tg = dy / dx;
                    float ctg = dx / dy;

                    if (tg <= 1 && tg >= -1) {
                        if (dx > 0/* && !player.isCollidedOnTheRight()*/) {
                            grassArray.get(i).setVx(-z);
                            grassArray.get(i).setVy(-z * tg);
                            player.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                        }
                        if (dx < 0 /*&& !player.isCollidedOnTheLeft()*/) {
                            grassArray.get(i).setVx(z);
                            grassArray.get(i).setVy(z * tg);
                            player.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
                        }
                    } else {
                        if (dy > 0 /*&& !player.isCollidedOnTheFront()*/) {
                            grassArray.get(i).setVx(-z * ctg);
                            grassArray.get(i).setVy(-z);
                            if (dx > 0)
                                player.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                            if (dx < 0)
                                player.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
                        }
                        if (dy < 0 /*&& !player.isCollidedOnTheBack()*/) {
                            grassArray.get(i).setVx(z * ctg);
                            grassArray.get(i).setVy(z);
                            if (dx > 0)
                                player.setRotation((float) (-90 + Math.toDegrees(Math.atan((double) tg))));
                            if (dx < 0)
                                player.setRotation((float) (90 + Math.toDegrees(Math.atan((double) tg))));
                        }
                    }


                } catch (ArithmeticException e) {
                    if (dx == 0) {
                        if (dy > 0 /*&& !player.isCollidedOnTheFront()*/) {
                            grassArray.get(i).setVx(0);
                            grassArray.get(i).setVy(-z);
                           // if (stars.get(i).getY() <= -GameScreen.SCR_HEIGHT) stars.get(i).setY(GameScreen.SCR_HEIGHT);  // звёзды вниз
                            player.setRotation(0);
                        }
                        if (dy < 0 /*&& !player.isCollidedOnTheBack()*/) {
                            grassArray.get(i).setVx(0);
                            grassArray.get(i).setVy(z);
                           // if (stars.get(i).getY() >= GameScreen.SCR_HEIGHT) stars.get(i).setY(-GameScreen.SCR_HEIGHT); // звезды вверх
                            player.setRotation(180);
                        }
                    }
                    if (dy == 0) {
                        if (dx > 0 /*&& !player.isCollidedOnTheRight()*/) {
                            grassArray.get(i).setVx(-z);
                            grassArray.get(i).setVy(0);
                           // if (stars.get(i).getX() <= -GameScreen.SCR_WIDTH) stars.get(i).setX(GameScreen.SCR_WIDTH); // звезды влево
                            player.setRotation(-90);
                        }
                        if (dx < 0 /*&& !player.isCollidedOnTheLeft()*/) {
                            grassArray.get(i).setVx(z);
                            grassArray.get(i).setVy(0);
                          //if (stars.get(i).getX() >= GameScreen.SCR_WIDTH) stars.get(i).setX(-GameScreen.SCR_WIDTH); // звёзды вправо
                            player.setRotation(90);
                        }
                    }
                }
            }

            if(player.isCollidedOnTheBack() && dy < 0){
                grassArray.get(i).setVy(0);
            }
            if(player.isCollidedOnTheFront() && dy > 0){
                grassArray.get(i).setVy(0);
            }
            if(player.isCollidedOnTheRight() && dx > 0){
                grassArray.get(i).setVx(0);
            }
            if(player.isCollidedOnTheLeft() && dx < 0){
                grassArray.get(i).setVx(0);
            }

            if(isPlayerMove){
                player.setVx(-grassArray.get(i).getVx()/2f);
                player.setVy(-grassArray.get(i).getVy()/2f);
                grassArray.get(i).setVx(0);
                grassArray.get(i).setVy(0);
            }



/*
            if (dx > 0 && dy > 0){
                if (stars.get(i).getY() <= -GameScreen.SCR_HEIGHT) stars.get(i).setY(GameScreen.SCR_HEIGHT);  // звёзды вниз
                if (stars.get(i).getX() <= -GameScreen.SCR_WIDTH) stars.get(i).setX(GameScreen.SCR_WIDTH); // звезды влево
            }

            if (dx > 0 && dy < 0){
                if (stars.get(i).getX() <= - GameScreen.SCR_WIDTH) stars.get(i).setX(GameScreen.SCR_WIDTH); // звезды влево
                if (stars.get(i).getY() >= GameScreen.SCR_HEIGHT) stars.get(i).setY(-GameScreen.SCR_HEIGHT); // звезды вверх
            }

            if (dx < 0 && dy > 0){
                if (stars.get(i).getY() <= -GameScreen.SCR_HEIGHT) stars.get(i).setY(GameScreen.SCR_HEIGHT); // звёзды вниз
                if (stars.get(i).getX() >= GameScreen.SCR_WIDTH) stars.get(i).setX(-GameScreen.SCR_WIDTH); // звёзды вправо
            }

            if (dx < 0 && dy < 0){
                if (stars.get(i).getY() >= GameScreen.SCR_HEIGHT){
                    stars.get(i).setY(-GameScreen.SCR_HEIGHT); // звезды вверх
                }
                if (stars.get(i).getX() >= GameScreen.SCR_WIDTH){
                    stars.get(i).setX(-GameScreen.SCR_WIDTH); // звёзды вправо
                }
            }*/

           /* if (dy > 0){
                if (stars.get(i).gety() <= -GameScreen.SCR_HEIGHT) stars.get(i).sety(GameScreen.SCR_HEIGHT);  // звёзды вниз
            }

            if (dy < 0){
                if (stars.get(i).gety() >= GameScreen.SCR_HEIGHT) stars.get(i).sety(-GameScreen.SCR_HEIGHT); // звезды вверх
            }

            if (dx > 0){
                if (stars.get(i).getx() <= - GameScreen.SCR_WIDTH) stars.get(i).setx(GameScreen.SCR_WIDTH); // звезды влево
            }

            if (dx < 0){
                if (stars.get(i).getx() >= GameScreen.SCR_WIDTH) stars.get(i).setx(-GameScreen.SCR_WIDTH); // звёзды вправо
            }*/


        }

    }

    @Override
    public Actor hit (float x, float y, boolean touchable){
       Actor actor = super.hit(x, y, true);
        if (actor == null) return null;
         else {
            float dx = x - rad;
            float dy = y - rad;
            return  (dx * dx + dy*dy <= rad * rad)? this : null;


        }
    }

    public void setWidth(float w){
        super.setWidth(w);
        super.setHeight(w);
        rad = w/2;
        cur_radius = rad/3;
    }

    public void setHeight(float h){
        super.setHeight(h);
        super.setWidth(h);
        rad = h/2;
        cur_radius = rad/3;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(circle, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if(isJoystickDown){
            batch.draw(curJoystick,
                    this.getX()+rad - cur_radius + curX,
                    this.getY()+rad - cur_radius + curY,
                    2*cur_radius,
                    2*cur_radius);
        }
        else{
            batch.draw(curJoystick,
                    this.getX()+rad - cur_radius,
                    this.getY()+rad - cur_radius,
                    2*cur_radius,
                    2*cur_radius);
        }

    }
}
