package com.mygdx.spaceshooter.models.enemys;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.mygdx.spaceshooter.screens.GameScreen;
import com.mygdx.spaceshooter.models.GameObject;
import com.mygdx.spaceshooter.models.MyTree;

public class Enemy extends GameObject {
  //  private Float distance;
    private int hp;
    public Enemy(int hp, float width, float height, Array<MyTree> trees){
        super(MathUtils.random(-GameScreen.SCR_WIDTH, 2*GameScreen.SCR_WIDTH - GameScreen.SCR_WIDTH/10f),
                MathUtils.random(-GameScreen.SCR_HEIGHT, 2*GameScreen.SCR_HEIGHT -GameScreen.SCR_WIDTH/10f),
                width,
                height,
                true,
                0,
                0);

        this.hp = hp;

        if (this.getX() > 0 - this.getWidth() && this.getX() < GameScreen.SCR_WIDTH && this.getY() > 0 - this.getHeight() && this.getY() < GameScreen.SCR_HEIGHT){
            if(this.getX() > GameScreen.SCR_WIDTH/2f){
                this.setX(this.getX() + GameScreen.SCR_WIDTH);
            }else{
                this.setX(this.getX() - GameScreen.SCR_WIDTH);
            }
        }
        for (int i = 0; i < trees.size ; i++) {
            if(this.overlaps(trees.get(i))){
                this.setX(this.getX() + trees.get(i).getWidth() * 2.5f);
            }
        }


    }
    public Enemy(int hp, float width, float height){
        super(MathUtils.random(-GameScreen.SCR_WIDTH, 2*GameScreen.SCR_WIDTH - GameScreen.SCR_WIDTH/10f),
                MathUtils.random(-GameScreen.SCR_HEIGHT, 2*GameScreen.SCR_HEIGHT -GameScreen.SCR_WIDTH/10f),
                width,
                height,
                true,
                0,
                0);

        this.hp = hp;

        if (this.getX() > 0 - this.getWidth() && this.getX() < GameScreen.SCR_WIDTH && this.getY() > 0 - this.getHeight() && this.getY() < GameScreen.SCR_HEIGHT){
            if(this.getX() > GameScreen.SCR_WIDTH/2f){
                this.setX(this.getX() + GameScreen.SCR_WIDTH);
            }else{
                this.setX(this.getX() - GameScreen.SCR_WIDTH);
            }
        }



        }




    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    /* public float getDistance(){
        return distance;
    }

    public void setDistance(float distance){
        this.distance = distance;
    }*/

}
