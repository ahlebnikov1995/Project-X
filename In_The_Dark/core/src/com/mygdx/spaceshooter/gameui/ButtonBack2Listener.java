package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.screens.HomeScreen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class ButtonBack2Listener extends InputListener {

        private InTheDark game;
        private MainMenuScreen menu;


        public ButtonBack2Listener(InTheDark game,MainMenuScreen menu) {
                this.game = game;
                this.menu = menu;

        }
        public ButtonBack2Listener(InTheDark game) {
                this.game = game;
                this.menu = new MainMenuScreen(game);

        }

        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(menu);
                return true;
        }


        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

        }


        public void touchDragged (InputEvent event, float x, float y, int pointer) {

        }
}
