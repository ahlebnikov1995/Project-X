package com.mygdx.spaceshooter.gameui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.spaceshooter.screens.FinalBossScreen;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.models.Player;
import com.mygdx.spaceshooter.screens.Lvl1Screen;
import com.mygdx.spaceshooter.screens.Lvl2Screen;
import com.mygdx.spaceshooter.screens.Lvl3Boss1Screen;
import com.mygdx.spaceshooter.screens.Lvl3Boss2Screen;

public class JoystickAttackInputListener extends InputListener {

    private JoystickAttack joystickAttack;
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

    public JoystickAttackInputListener(JoystickAttack joystickAttack, GameScreen screen, Player player) {
        this.joystickAttack = joystickAttack;
        this.screen = screen;
        this.player = player;
    }

    public JoystickAttackInputListener(JoystickAttack joystickAttack, Lvl1Screen screen, Player player) {
        this.joystickAttack = joystickAttack;
        this.screen1 = screen;
        this.player = player;
        lvl1IsStart = true;
    }
    public JoystickAttackInputListener(JoystickAttack joystickAttack, Lvl2Screen screen, Player player) {
        this.joystickAttack = joystickAttack;
        this.screen2 = screen;
        this.player = player;
        lvl2IsStart = true;
    }
    public JoystickAttackInputListener(JoystickAttack joystickAttack, FinalBossScreen screen, Player player) {
        this.joystickAttack = joystickAttack;
        this.screen3 = screen;
        this.player = player;
        lvl3IsStart = true;
    }
    public JoystickAttackInputListener(JoystickAttack joystickAttack, Lvl3Boss1Screen screen, Player player) {
        this.joystickAttack = joystickAttack;
        this.screen31 = screen;
        this.player = player;
        lvl31IsStart = true;
    }
    public JoystickAttackInputListener(JoystickAttack joystickAttack, Lvl3Boss2Screen screen, Player player) {
        this.joystickAttack = joystickAttack;
        this.screen32 = screen;
        this.player = player;
        lvl32IsStart = true;
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        joystickAttack.changeCursor(x, y);
        joystickAttack.setTouched();
        return true;
    }


    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        joystickAttack.setUnTouched();
        if(!lvl1IsStart && !lvl2IsStart && !lvl3IsStart && !lvl31IsStart && !lvl32IsStart) screen.spawnShoot(joystickAttack.getDx(),joystickAttack.getDy());
        if(lvl1IsStart) screen1.spawnShoot(joystickAttack.getDx(),joystickAttack.getDy());
        if(lvl2IsStart) screen2.spawnShoot(joystickAttack.getDx(),joystickAttack.getDy());
        if(lvl3IsStart) screen3.spawnShoot(joystickAttack.getDx(),joystickAttack.getDy());
        if(lvl31IsStart) screen31.spawnShoot(joystickAttack.getDx(),joystickAttack.getDy());
        if(lvl32IsStart) screen32.spawnShoot(joystickAttack.getDx(),joystickAttack.getDy());
    }


    public void touchDragged (InputEvent event, float x, float y, int pointer) {
        joystickAttack.changeCursor(x, y);

    }
}
