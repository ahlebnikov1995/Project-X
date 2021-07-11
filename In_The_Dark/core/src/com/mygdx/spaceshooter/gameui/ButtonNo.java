package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class ButtonNo extends Actor {
    private float rad;

    private Texture circle;
    private Boolean inPortal;

    public ButtonNo(Texture circle, InTheDark game) {
        this.circle = circle;
        setDefaultWH();
        setDefaultXY();
        addListener( new ButtonNoListener(game));
    }
    public ButtonNo(Texture circle, InTheDark game, MainMenuScreen menu) {
        this.circle = circle;
        setDefaultWH();
        setDefaultXY();
        addListener( new ButtonNoListener(game, menu));
    }

    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/20f);
        setHeight(GameScreen.SCR_WIDTH/20f);
        rad = (GameScreen.SCR_WIDTH/20f) / 2f;
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH/20f);
        setY(GameScreen.SCR_WIDTH/20f);
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
