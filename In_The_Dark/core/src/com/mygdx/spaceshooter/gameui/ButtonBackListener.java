package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.HomeScreen;

public class ButtonBackListener extends InputListener {

    private InTheDark game;


    private boolean lvl1IsStart = false;

    public ButtonBackListener(InTheDark game) {
        this.game = game;

    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        game.setScreen(new HomeScreen(game));
        if(Progress.lvlPlayer < 30) {
            Progress.lvlPlayer = 1 + (Progress.exp / Progress.expToNextLvl);
        }

        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}