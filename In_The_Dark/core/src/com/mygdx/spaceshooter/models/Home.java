package com.mygdx.spaceshooter.models;

import com.mygdx.spaceshooter.screens.GameScreen;

public class Home extends GameObject {
    public Home() {
        super( GameScreen.SCR_WIDTH/10f, GameScreen.SCR_HEIGHT/2f-GameScreen.SCR_HEIGHT/4f, GameScreen.SCR_HEIGHT/2f, GameScreen.SCR_HEIGHT/2f, false, 0, 0);
    }
}
