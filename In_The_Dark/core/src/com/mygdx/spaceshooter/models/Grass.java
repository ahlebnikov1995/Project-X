package com.mygdx.spaceshooter.models;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.spaceshooter.screens.GameScreen;

public class Grass extends GameObject {
    Texture v1;
    Texture v2;
    Texture v3;
    Texture curTexture;
   public Grass(float y, float x, Texture v1, Texture v2, Texture v3){
       super(x,y,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT,true,0,0);
       this.v1 = v1;
       this.v2 = v2;
       this.v3 = v3;
       this.setRandomCurTexture();
    }

  public void setRandomCurTexture(){
       int x = (int) Math.floor(Math.random()*3);
       if(x == 0) this.curTexture = v1;
       if(x == 1) this.curTexture = v2;
       if(x == 2) this.curTexture = v3;
    }

    @Override
   public void move() {
        super.move();

        if (this.getX() < - this.getWidth() || this.getX() > GameScreen.SCR_WIDTH || this.getY() < - this.getHeight() || this.getY() > GameScreen.SCR_HEIGHT)
            this.setAlive(false);

        if(this.getVy() <= 0) {
            if (this.getY() <= - this.getHeight()){
                this.setY (this.getY() + 2f * this.getHeight());//- this.getHeight()/30f); // звёзды вниз
                this.setRandomCurTexture();
            }
        }

        if(this.getVx() <= 0) {
            if (this.getX() <= - this.getWidth()) {
                this.setX( this.getX() + 2f * this.getWidth()); //- this.getWidth()/30f); // звезды влево
                this.setRandomCurTexture();
            }
        }

        if(this.getVy() >= 0) {
            if (this.getY() >= this.getHeight()){
                this.setY( this.getY() - 2f * this.getHeight()); // + this.getHeight()/30f); // звезды вверх
                this.setRandomCurTexture();
            }
        }

        if(this.getVx() >= 0) {
            if (this.getX() >= this.getWidth()) {
                this.setX(this.getX() - 2f * this.getWidth()); // + this.getWidth()/30f); // звёзды вправо
                this.setRandomCurTexture();
            }
        }

    }

    public Texture getCurTexture() {
        return curTexture;
    }

}
