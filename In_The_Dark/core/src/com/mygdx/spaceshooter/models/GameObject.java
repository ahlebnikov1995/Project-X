package com.mygdx.spaceshooter.models;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.gameui.Joystick;
import com.mygdx.spaceshooter.screens.GameScreen;

public class GameObject extends Actor {
   private float x, y;
   private float width, height;
   private boolean isAlive;
   private float vx,vy;

    public GameObject(float x, float y, float width, float height, boolean isAlive, float vx, float vy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = isAlive;
        this.vx = vx;
        this.vy = vy;
    }

    public void move(){
        x += vx;
        y += vy;

        if (x < -GameScreen.SCR_WIDTH - width || x > 2*GameScreen.SCR_WIDTH || y < -GameScreen.SCR_HEIGHT - height || y > 2*GameScreen.SCR_HEIGHT)
            isAlive = false;
    }

    public void move(Array<GameObject> gameObjects, Player player) {
        x += vx;
        y += vy;

        if (x < -GameScreen.SCR_WIDTH - width || x > 2 * GameScreen.SCR_WIDTH || y < -GameScreen.SCR_HEIGHT - height || y > 2 * GameScreen.SCR_HEIGHT)
            isAlive = false;

        player.setCollidedOnTheBack(false);
        player.setCollidedOnTheFront(false);
        player.setCollidedOnTheLeft(false);
        player.setCollidedOnTheRight(false);

        for (int i = 0; i < gameObjects.size; i++) {

            if (player.overlaps(gameObjects.get(i))) {

                if (player.getX() > gameObjects.get(i).getX() &&
                        gameObjects.get(i).getX() > player.getX() - gameObjects.get(i).getWidth() - player.getWidth() / 2f &&
                        gameObjects.get(i).getX() < player.getX() - gameObjects.get(i).getWidth()) {
                    player.setCollidedOnTheLeft(true);
                } else {
                    if (player.getX() < gameObjects.get(i).getX() &&
                            gameObjects.get(i).getX() > player.getX() + player.getWidth() &&
                            gameObjects.get(i).getX() < player.getX() + player.getWidth() + player.getWidth() / 2f) {
                        player.setCollidedOnTheRight(true);
                    } else {
                        if (player.getY() < gameObjects.get(i).getY()) {
                            player.setCollidedOnTheFront(true);
                        }
                        if (player.getY() > gameObjects.get(i).getY()) {
                            player.setCollidedOnTheBack(true);
                        }
                    }
                }
            }
        }
    }



   public boolean overlaps (GameObject o){
        return (x > o.x && x < o.x + o.width || o.x > x && o.x < x + width) &&
                (y > o.y && y < o.y + o.height || o.y > y && o.y < y + height);
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public void setHeight(float height) {
        this.height = height;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setVx(float vx){
        this.vx = vx;
    }

    public void setVy( float vy){
        this.vy = vy;
    }




    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public float getVx() {
        return vx;
    }

    public float getVy() {
        return vy;
    }
}


