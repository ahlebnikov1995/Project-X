package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.Progress;

public class ButtonHardModeListener extends InputListener {
    public ButtonHardModeListener() {

    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(Progress.isHardMode){
            Progress.isHardMode = false;
        }else{
            Progress.isHardMode = true;
        }

        return true;
    }

    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {


    }
}
