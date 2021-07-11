package com.mygdx.spaceshooter.gameui.MenuButtons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class ButtonCustomization extends Actor {
    Texture imgButtonCost;
    Texture imgButtonCost2;
    ButtonNewGame buttonNewGame;
    private boolean isPressed = false;

    public ButtonCustomization(Texture imgButtonCon, Texture imgButtonCon2, ButtonNewGame buttonNewGame, InTheDark game,MainMenuScreen menu) {
        this.imgButtonCost = imgButtonCon;
        this.imgButtonCost2 = imgButtonCon2;
        this.buttonNewGame = buttonNewGame;
        setDefaultWH();
        setDefaultXY();
        addListener(new ButtonCustomizationListener(game,menu,this));
    }
    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/4f);
        setHeight(GameScreen.SCR_HEIGHT/10f);

    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/2f - this.getWidth()/2f);
        setY(buttonNewGame.getY() - this.getHeight() - GameScreen.SCR_HEIGHT/10f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(!isPressed) {
            batch.draw(imgButtonCost, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }else{
            batch.draw(imgButtonCost2, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}
