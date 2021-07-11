package com.mygdx.spaceshooter.gameui.treeButtons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.screens.GameScreen;

public class Button5 extends Actor {
    Texture imgBut;
    Texture imgBut2;
    Texture curTexture;

    public Button5(Texture imgBut, Texture imgBut2) {
        this.imgBut = imgBut;
        this.imgBut2 = imgBut2;
        this.curTexture = imgBut;
        setDefaultWH();
        setDefaultXY();
        addListener(new Button5Listener(imgBut,imgBut2,this));
    }
    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/6f);
        setHeight((GameScreen.SCR_WIDTH/12f)/6f*8);
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/8f + GameScreen.SCR_WIDTH/24f);
        setY(GameScreen.SCR_HEIGHT - GameScreen.SCR_HEIGHT/3f - GameScreen.SCR_WIDTH/12f - this.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(curTexture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

}
