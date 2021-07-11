package com.mygdx.spaceshooter.models.shoots;

import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.models.enemys.EnemyArcher;

public class EnemyShoot extends Shoot {
    public EnemyShoot(EnemyArcher enemyArcher, float dx, float dy, float z) {
            super(enemyArcher, dx, dy, 0, 0, z, GameScreen.SCR_WIDTH/80f, GameScreen.SCR_WIDTH/20f);

    }
}
