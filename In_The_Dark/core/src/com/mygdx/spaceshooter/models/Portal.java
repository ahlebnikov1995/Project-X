package com.mygdx.spaceshooter.models;

import com.mygdx.spaceshooter.screens.GameScreen;

public class Portal extends GameObject {
    public Portal() {
        super(GameScreen.SCR_WIDTH - GameScreen.SCR_WIDTH/6f,
                GameScreen.SCR_HEIGHT / 5f,
                GameScreen.SCR_WIDTH/20f,
                GameScreen.SCR_WIDTH/14f,
                false,
                0,
                0);
    }
}
