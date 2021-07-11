package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.InfoScreen;
import com.mygdx.spaceshooter.screens.Lvl1Screen;
import com.mygdx.spaceshooter.screens.Lvl2Screen;
import com.mygdx.spaceshooter.screens.Lvl3Screen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

import javax.swing.text.StyledEditorKit;

public class ButtonYesListener extends InputListener {
    private InTheDark game;
    private MainMenuScreen menu;
    private Boolean inMenu;
    private Boolean inPortal;


    public ButtonYesListener(InTheDark game,MainMenuScreen menu) {
        this.game = game;
        this.menu = menu;
        inMenu = true;
        inPortal = false;

    }
    public ButtonYesListener(InTheDark game, Boolean inPortal) {
        this.game = game;
        this.inPortal = inPortal;
        inMenu = false;



    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(inMenu) {
            if(!Progress.isStartGame) {
                Progress.isStartGame = true;
            }
            Progress.deleteProgress();
            game.setScreen(new InfoScreen(game));
        }else{
            if(inPortal) {
                game.setScreen(new GameScreen(game));
            }else {
                if (!Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin)
                    game.setScreen(new Lvl1Screen(game));
                if (Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin)
                    game.setScreen(new Lvl2Screen(game));
                if (Progress.is1lvlWin && Progress.is2lvlWin && !Progress.is3lvlWin)
                    game.setScreen(new Lvl3Screen(game));
            }
        }
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
