package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.screens.GameScreen;

public class ButtonShield extends Actor {
    private float rad;

    private Texture circle;

    public ButtonShield(Texture circle, Player player) {
        this.circle = circle;
        setDefaultWH();
        setDefaultXY();
        addListener( new ButtonShieldListener(player));
    }


    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/12f);
        setHeight(GameScreen.SCR_WIDTH/12f);
        rad = (GameScreen.SCR_WIDTH/12f) / 2f;
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH - GameScreen.SCR_WIDTH/6f - GameScreen.SCR_WIDTH/10f - rad);
        setY(GameScreen.SCR_WIDTH/10f + this.getHeight() + rad);
    }

    public void setWidth(float w){
        super.setWidth(w);
        super.setHeight(w);
        rad = w/2;
    }

    public void setHeight(float h){
        super.setHeight(h);
        super.setWidth(h);
        rad = h/2;
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
