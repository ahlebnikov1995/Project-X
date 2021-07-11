package com.mygdx.spaceshooter.gameui.MenuButtons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.MainMenuScreen;
import com.mygdx.spaceshooter.screens.SettingsScreen;

public class ButtonCustomizationListener extends InputListener {

    private InTheDark game;
    private MainMenuScreen menu;
    private ButtonCustomization buttonCustomization;


    public ButtonCustomizationListener(InTheDark game,MainMenuScreen menu,ButtonCustomization buttonCustomization) {
        this.game = game;
        this.menu = menu;
        this.buttonCustomization = buttonCustomization;

    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        buttonCustomization.setPressed(true);
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        buttonCustomization.setPressed(false);
        game.setScreen(new SettingsScreen(game,menu));
    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
