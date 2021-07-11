package com.mygdx.spaceshooter.gameui.MenuButtons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.HomeScreen;

public class ButtonContinueListener extends InputListener {
   private InTheDark game;
   private ButtonContinue but;

    public ButtonContinueListener(InTheDark game, ButtonContinue but) {
        this.game = game;
        this.but = but;
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        but.setPressed(true);
        return true;
    }

    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        game.setScreen(new HomeScreen(game));

    }
}
