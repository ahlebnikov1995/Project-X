package com.mygdx.spaceshooter.gameui.MenuButtons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.GameScreen;

public class ButtonNewGame extends Actor {
    Texture imgButtonNG;
    Texture imgButtonNG2;
    Boolean isPressed = false;

    public ButtonNewGame(Texture imgButtonNG, Texture imgButtonNG2, InTheDark game) {
        this.imgButtonNG = imgButtonNG;
        this.imgButtonNG2 = imgButtonNG2;
        setDefaultWH();
        setDefaultXY();

        addListener(new ButtonNewGameListener(game,this));
    }
    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/4f);
        setHeight(GameScreen.SCR_HEIGHT/10f);

    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/2f - this.getWidth()/2f);
        setY(GameScreen.SCR_HEIGHT/2f - this.getHeight()/2f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(!isPressed) {
            batch.draw(imgButtonNG, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }else{
            batch.draw(imgButtonNG2, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    public void setPressed(Boolean pressed) {
        isPressed = pressed;
    }
}
