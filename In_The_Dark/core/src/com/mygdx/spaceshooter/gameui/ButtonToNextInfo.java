package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.InfoScreen;

public class ButtonToNextInfo extends Actor {

    private Texture circle;

    public ButtonToNextInfo(Texture circle, Integer count, Stage stage, ButtonToPreInfo but, InTheDark game, InfoScreen sc) {
        this.circle = circle;
        setDefaultWH();
        setDefaultXY();
        addListener(new ButtonToNextInfoListener(game, count, stage, but, sc));
    }

    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/12f);
        setHeight(GameScreen.SCR_WIDTH/24f);
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH - this.getWidth() - GameScreen.SCR_WIDTH/30f);
        setY(GameScreen.SCR_WIDTH/30f);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(circle, this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
