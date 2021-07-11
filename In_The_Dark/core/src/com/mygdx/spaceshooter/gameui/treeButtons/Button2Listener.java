package com.mygdx.spaceshooter.gameui.treeButtons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.Progress;

public class Button2Listener extends InputListener {
    Texture but1;
    Texture but2;
    Button2 button1;

    public Button2Listener(Texture but1, Texture but2, Button2 button1) {
        this.but1 = but1;
        this.but2 = but2;
        this.button1 = button1;
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(Progress.talentPoints > 0 && Progress.Talent.encDMG < 13)
            button1.curTexture = but2;
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        if(Progress.talentPoints > 0 && Progress.Talent.encDMG < 13) {
            button1.curTexture = but1;
            Progress.Talent.encDMG++;
            Progress.talentPoints--;
        }
    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}

