package com.mygdx.spaceshooter.models;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.models.enemys.EnemyArcher;
import com.mygdx.spaceshooter.models.enemys.EnemyWarrior;

public class MyTree extends GameObject {
    public MyTree(Array<EnemyArcher> archers, Array<EnemyWarrior> slimes) {
        super(MathUtils.random(-GameScreen.SCR_WIDTH, 2*GameScreen.SCR_WIDTH - GameScreen.SCR_WIDTH/10f),
                MathUtils.random(-GameScreen.SCR_HEIGHT, 2*GameScreen.SCR_HEIGHT -GameScreen.SCR_WIDTH/10f),
                GameScreen.SCR_WIDTH/20f,
                GameScreen.SCR_WIDTH/40f,
                true,
                0,
                0);

        if (this.getX() > 0 - this.getWidth()*3 && this.getX() < GameScreen.SCR_WIDTH && this.getY() > 0 - this.getHeight()*10 && this.getY() < GameScreen.SCR_HEIGHT){
            if(this.getX() > GameScreen.SCR_WIDTH/2f){
                this.setX(this.getX() + GameScreen.SCR_WIDTH);
            }else{
                this.setX(this.getX() - GameScreen.SCR_WIDTH);
            }
        }
        for (int i = 0; i < archers.size ; i++) {
           if (archers.get(i).overlaps(this)){
                this.setX(this.getX() + archers.get(i).getWidth() * 2.5f);
            }
            for (int j = 0; j < slimes.size ; j++) {
                if (slimes.get(j).overlaps(this)){
                    this.setX(this.getX() + slimes.get(j).getWidth() * 2.5f);
                }
            }
        }

    }

    public MyTree(float x, float y, float width, float height) {
        super(x, y, width, height, false,0,0);
    }

    @Override
    public boolean overlaps(GameObject o) {

            return (this.getX()  > o.getX() && this.getX() - this.getWidth()/2f < o.getX() + o.getWidth() || o.getX() > this.getX() && o.getX() < this.getX() + this.getWidth() + this.getWidth()/2f) &&
                    (this.getY() > o.getY() && this.getY() < o.getY() + o.getHeight() || o.getY() > this.getY() && o.getY() < this.getY() + this.getHeight()*2f);
    }
}
