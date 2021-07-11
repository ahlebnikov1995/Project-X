package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.InfoScreen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class ButtonInfoListener extends InputListener {
    private InTheDark game;
    private MainMenuScreen menu;


    public ButtonInfoListener(InTheDark game) {
        this.game = game;


    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        game.setScreen(new InfoScreen(game));
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
