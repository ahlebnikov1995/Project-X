package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.gameui.MenuButtons.ButtonContinue;
import com.mygdx.spaceshooter.screens.HomeScreen;

public class ButtonMusicListener extends InputListener {


    public ButtonMusicListener() {

    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(Progress.isMusic){
            Progress.isMusic = false;
            InTheDark.music.pause();
        }else{
            Progress.isMusic = true;
            InTheDark.music.play();
        }

        return true;
    }

    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {


    }
}
