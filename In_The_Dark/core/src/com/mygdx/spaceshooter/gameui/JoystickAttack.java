package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.spaceshooter.screens.FinalBossScreen;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.screens.Lvl1Screen;
import com.mygdx.spaceshooter.screens.Lvl2Screen;
import com.mygdx.spaceshooter.screens.Lvl3Boss1Screen;
import com.mygdx.spaceshooter.screens.Lvl3Boss2Screen;

public class JoystickAttack extends Actor {

    private float rad;
    private Texture circle;
    private Texture curJoystick;
    private boolean isJoystickDown = false;

    private float cur_radius;
    private float dx;
    private float dy;

    private float curX = 0;
    private float curY = 0;


    public JoystickAttack(GameScreen screen, Texture circle, Texture curJoystick, Player player) {
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener( new JoystickAttackInputListener(this, screen, player));
    }
    public JoystickAttack(Lvl1Screen screen, Texture circle, Texture curJoystick, Player player) {
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener( new JoystickAttackInputListener(this, screen, player));
    }
    public JoystickAttack(Lvl2Screen screen, Texture circle, Texture curJoystick, Player player) {
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener( new JoystickAttackInputListener(this, screen, player));
    }
    public JoystickAttack(FinalBossScreen screen, Texture circle, Texture curJoystick, Player player) {
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener( new JoystickAttackInputListener(this, screen, player));
    }
    public JoystickAttack(Lvl3Boss1Screen screen, Texture circle, Texture curJoystick, Player player) {
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener( new JoystickAttackInputListener(this, screen, player));
    }
    public JoystickAttack(Lvl3Boss2Screen screen, Texture circle, Texture curJoystick, Player player) {
        this.circle = circle;
        this.curJoystick = curJoystick;
        setDefaultWH();
        setDefaultXY();
        addListener( new JoystickAttackInputListener(this, screen, player));
    }

    public void setDefaultWH(){
        setWidth(GameScreen.SCR_WIDTH/6f);
        setHeight(GameScreen.SCR_WIDTH/6f);
        rad = (GameScreen.SCR_WIDTH/6f) / 2f;
    }

    public void setDefaultXY(){
        setX(GameScreen.SCR_WIDTH - this.getWidth() - GameScreen.SCR_WIDTH/13f);
        setY(GameScreen.SCR_WIDTH/13f);
    }

    public float getDx() {
        return dx;
    }

    public float getDy() {
        return dy;
    }

    public void setTouched(){
        isJoystickDown = true;
    }

    public void setUnTouched(){
        isJoystickDown = false;

        }


    public void resetCur(){
        curX = 0;
        curY = 0;
    }

    public void changeCursor(float x, float y) {
        this.dx = x - rad;
        this.dy = y - rad;
        float length = (float) Math.sqrt(dx * dx + dy * dy);
        if (length <= rad) {
            this.curX = dx;
            this.curY = dy;
        } else {
            float k = rad / length;
            this.curX = dx * k;
            this.curY = dy * k;
        }
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

    public void setWidth(float w){
        super.setWidth(w);
        super.setHeight(w);
        rad = w/2;
        cur_radius = rad/3;
    }

    public void setHeight(float h){
        super.setHeight(h);
        super.setWidth(h);
        rad = h/2;
        cur_radius = rad/3;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(circle, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if(isJoystickDown){
            batch.draw(curJoystick,
                    this.getX()+rad - cur_radius + curX,
                    this.getY()+rad - cur_radius + curY,
                    2*cur_radius,
                    2*cur_radius);
        }
        else{
            batch.draw(curJoystick,
                    this.getX()+rad - cur_radius,
                    this.getY()+rad - cur_radius,
                    2*cur_radius,
                    2*cur_radius);
        }
    }
}
