package com.mygdx.spaceshooter.gameui.MenuButtons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.NewGameScreen;

public class ButtonNewGameListener extends InputListener {
    private InTheDark game;
    private ButtonNewGame but;


    public ButtonNewGameListener(InTheDark game, ButtonNewGame but) {
        this.game = game;
        this.but = but;
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        but.setPressed(true);
        return true;
    }

    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        game.setScreen(new NewGameScreen(game));
    }
}

