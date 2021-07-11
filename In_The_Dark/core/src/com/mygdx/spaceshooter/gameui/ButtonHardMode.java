package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.screens.GameScreen;

public class ButtonHardMode extends Actor {
    private Texture imgButtonCon;
    private Texture imgButtonCon2;



    public ButtonHardMode(Texture imgButtonCon, Texture imgButtonCon2) {
        this.imgButtonCon = imgButtonCon;
        this.imgButtonCon2 = imgButtonCon2;
        setDefaultWH();
        setDefaultXY();
        addListener(new ButtonHardModeListener());
    }


    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/4f);
        setHeight(GameScreen.SCR_HEIGHT/10f);

    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/2f - this.getWidth()/2f);
        setY(GameScreen.SCR_HEIGHT/2f - this.getHeight()/2f - this.getHeight() - GameScreen.SCR_HEIGHT/10f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(!Progress.isHardMode) {
            batch.draw(imgButtonCon, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }else{
            batch.draw(imgButtonCon2, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }
}
