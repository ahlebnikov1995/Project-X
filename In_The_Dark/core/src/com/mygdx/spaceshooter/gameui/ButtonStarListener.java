package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.screens.FinalBossScreen;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.screens.Lvl1Screen;
import com.mygdx.spaceshooter.screens.Lvl2Screen;
import com.mygdx.spaceshooter.screens.Lvl3Boss1Screen;
import com.mygdx.spaceshooter.screens.Lvl3Boss2Screen;

public class ButtonStarListener extends InputListener {
    private GameScreen screen;
    private Lvl1Screen screen1;
    private Lvl2Screen screen2;
    private FinalBossScreen screen3;
    private Lvl3Boss1Screen screen31;
    private Lvl3Boss2Screen screen32;
    private Player player;
    private boolean lvl1IsStart = false;
    private boolean lvl2IsStart = false;
    private boolean lvl3IsStart = false;
    private boolean lvl31IsStart = false;
    private boolean lvl32IsStart = false;

    public ButtonStarListener(GameScreen screen, Player player) {
        this.screen = screen;
        this.player = player;
    }

    public ButtonStarListener(Lvl1Screen screen, Player player) {
        this.screen1 = screen;
        this.player = player;
        lvl1IsStart = true;
    }
    public ButtonStarListener(Lvl2Screen screen, Player player) {
        this.screen2 = screen;
        this.player = player;
        lvl2IsStart = true;
    }
    public ButtonStarListener(FinalBossScreen screen, Player player) {
        this.screen3 = screen;
        this.player = player;
        lvl3IsStart = true;
    }
    public ButtonStarListener(Lvl3Boss1Screen screen, Player player) {
        this.screen31 = screen;
        this.player = player;
        lvl31IsStart = true;
    }
    public ButtonStarListener(Lvl3Boss2Screen screen, Player player) {
        this.screen32 = screen;
        this.player = player;
        lvl32IsStart = true;
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if(TimeUtils.millis() - player.getLastStar() > 10000) {
            if (!lvl1IsStart && !lvl2IsStart && !lvl3IsStart && !lvl31IsStart && !lvl32IsStart)
                screen.spawnShoots();
            if (lvl1IsStart) screen1.spawnShoots();
            if (lvl2IsStart) screen2.spawnShoots();
            if (lvl3IsStart) screen3.spawnShoots();
            if (lvl31IsStart) screen31.spawnShoots();
            if (lvl32IsStart) screen32.spawnShoots();
        }
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {


    }
}
