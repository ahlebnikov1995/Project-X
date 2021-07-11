package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.HomeScreen;
import com.mygdx.spaceshooter.screens.InfoScreen;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class ButtonToNextInfoListener extends InputListener {
    private InTheDark game;
    private Integer count;
    private Stage stage;
    private ButtonToPreInfo but;
    private InfoScreen sc;



    public ButtonToNextInfoListener(InTheDark game, Integer count, Stage stage, ButtonToPreInfo but, InfoScreen sc) {
        this.game = game;
        this.but = but;
        this.count = count;
        this.stage = stage;
        this.sc = sc;



    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

        if(sc.getCount() == 3){
            sc.toHS();
        }
        if(sc.getCount() == 1){
            sc.addBut();
        }
        sc.incCount();
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
