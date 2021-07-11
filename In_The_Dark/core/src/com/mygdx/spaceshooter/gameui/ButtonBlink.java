package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.Lvl1Screen;

public class ButtonBlink extends Actor {
    private float rad;

    private Texture circle;

    public ButtonBlink(GameScreen screen, Texture circle) {
        this.circle = circle;
        setDefaultWH();
        setDefaultXY();
        addListener( new ButtonBlinkInputListener(this, screen));
    }


    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/12f);
        setHeight(GameScreen.SCR_WIDTH/12f);
        rad = (GameScreen.SCR_WIDTH/12f) / 2f;
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH - this.getWidth() - GameScreen.SCR_WIDTH/13f );
        setY(GameScreen.SCR_WIDTH/10f + this.getHeight()*2);
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

