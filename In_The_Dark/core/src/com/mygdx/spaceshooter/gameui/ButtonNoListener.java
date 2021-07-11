package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.HomeScreen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class ButtonNoListener extends InputListener {
    private InTheDark game;
    private MainMenuScreen menu;
    private Boolean inMenu;


    public ButtonNoListener(InTheDark game,MainMenuScreen menu) {
        this.game = game;
        this.menu = menu;
        inMenu = true;

    }
    public ButtonNoListener(InTheDark game) {
        this.game = game;
        inMenu = false;



    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(inMenu) {
            game.setScreen(menu);
        }else{
            game.setScreen(new HomeScreen(game));
        }
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
