package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.screens.HomeScreen;
import com.mygdx.spaceshooter.screens.InfoScreen;

public class ButtonToPreInfoListener extends InputListener {
    private Integer count;
    private Stage stage;
    private ButtonToNextInfo but2;
    private InfoScreen sc;



    public ButtonToPreInfoListener(Integer count, Stage stage, ButtonToNextInfo but2, InfoScreen sc) {
        this.count = count;
        this.stage = stage;
        this.but2 = but2;
        this.sc = sc;

    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {


        if(sc.getCount() == 2){
            sc.delBut();
        }
        sc.decCount();
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
