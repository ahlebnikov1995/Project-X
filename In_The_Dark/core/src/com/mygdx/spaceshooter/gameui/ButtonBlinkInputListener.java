package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.Lvl1Screen;

public class ButtonBlinkInputListener extends InputListener {

    private ButtonBlink buttonBlink;
    private GameScreen screen;
    private Lvl1Screen screen1;
    private boolean lvl1IsStart = false;

    public ButtonBlinkInputListener(ButtonBlink buttonBlink, GameScreen screen) {
        this.buttonBlink = buttonBlink;
        this.screen = screen;
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(!lvl1IsStart)screen.blink();
        if(lvl1IsStart)screen1.blink();
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
