package com.mygdx.spaceshooter.gameui.MenuButtons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.InTheDark;

public class ButtonContinue extends Actor {
    private Texture imgButtonCon;
    private Texture imgButtonCon2;
    private ButtonNewGame buttonNewGame;
    private boolean isPressed = false;

    public ButtonContinue(Texture imgButtonCon, Texture imgButtonCon2, ButtonNewGame buttonNewGame, InTheDark game) {
        this.imgButtonCon = imgButtonCon;
        this.imgButtonCon2 = imgButtonCon2;
        this.buttonNewGame = buttonNewGame;
        setDefaultWH();
        setDefaultXY();
        addListener(new ButtonContinueListener(game,this));
    }


    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/4f);
        setHeight(GameScreen.SCR_HEIGHT/10f);

    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/2f - this.getWidth()/2f);
        setY(buttonNewGame.getY() + buttonNewGame.getHeight() + GameScreen.SCR_HEIGHT/10f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(!isPressed) {
            batch.draw(imgButtonCon, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }else{
            batch.draw(imgButtonCon2, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}
