package com.mygdx.spaceshooter.gameui.treeButtons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.screens.GameScreen;

public class Button1 extends Actor {
    Texture imgBut;
    Texture imgBut2;
    Texture curTexture;

    public Button1(Texture imgBut, Texture imgBut2) {
        this.imgBut = imgBut;
        this.imgBut2 = imgBut2;
        this.curTexture = imgBut;
        setDefaultWH();
        setDefaultXY();
        addListener(new Button1Listener(imgBut,imgBut2,this));
    }
    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/12f);
        setHeight((GameScreen.SCR_WIDTH/12f)/6f*7);
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/8f);
        setY(GameScreen.SCR_HEIGHT - GameScreen.SCR_HEIGHT/3f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(curTexture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

}
