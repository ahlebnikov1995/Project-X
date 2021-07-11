package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class ButtonBack2 extends Actor {
    private float rad;

    private Texture circle;

    public ButtonBack2(Texture circle, InTheDark game, MainMenuScreen menu) {
        this.circle = circle;
        setDefaultWH();
        setDefaultXY();
        addListener( new ButtonBack2Listener(game, menu));
    }
    public ButtonBack2(Texture circle, InTheDark game) {
        this.circle = circle;
        setDefaultWH();
        setDefaultXY();
        addListener( new ButtonBack2Listener(game));
    }

    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/12f);
        setHeight(GameScreen.SCR_WIDTH/12f);
        rad = (GameScreen.SCR_WIDTH/12f) / 2f;
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH - this.getWidth() - GameScreen.SCR_WIDTH/30f);
        setY(GameScreen.SCR_HEIGHT - this.getHeight() - GameScreen.SCR_WIDTH/30f);
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

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(circle, this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
