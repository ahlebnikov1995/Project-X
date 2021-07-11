package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.screens.GameScreen;

public class ButtonShieldListener extends InputListener {
    Player player;
    public ButtonShieldListener(Player player) {
        this.player = player;

    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(TimeUtils.millis() - player.getLastShield() > 10000){
            player.setInShield(true);
            player.setLastShield(TimeUtils.millis());
            player.setK(0);
        }

        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {

    }
}
