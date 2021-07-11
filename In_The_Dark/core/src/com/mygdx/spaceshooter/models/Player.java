package com.mygdx.spaceshooter.models;

import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.screens.GameScreen;

 public class Player extends GameObject {
    private int hp;
    private int dmg;
    private boolean inblink;
    private long lastinblink;
    private long lastStar;
    private long lastShield;
    private boolean inShield;
    private boolean collidedOnTheRight;
    private boolean collidedOnTheLeft;
    private boolean collidedOnTheFront;
    private boolean collidedOnTheBack;
    private int k;


   public Player(){
       super(GameScreen.SCR_WIDTH / 2f - GameScreen.SCR_WIDTH/20f / 2f,
               GameScreen.SCR_HEIGHT / 2f - GameScreen.SCR_WIDTH/14f / 2f,
               GameScreen.SCR_WIDTH/20f,
               GameScreen.SCR_WIDTH/14f,
               true,
               0,
               0);
        hp = (int)((Progress.lvlPlayer * 10 + (Progress.lvlPlayer * 10 * 0.1f * Progress.Talent.encHP))*(1+Progress.Talent.doubleHP_DMG));
        dmg = (int)((Progress.lvlPlayer * 2 + (Progress.lvlPlayer * 2 * 0.1f * Progress.Talent.encDMG))*(1+Progress.Talent.doubleHP_DMG));

        k = 0;
        inblink = false;


    }



     public void setCollidedOnTheRight(boolean collidedOnTheRight) {
         this.collidedOnTheRight = collidedOnTheRight;
     }

     public void setCollidedOnTheLeft(boolean collidedOnTheLeft) {
         this.collidedOnTheLeft = collidedOnTheLeft;
     }

     public void setCollidedOnTheFront(boolean collidedOnTheFront) {
         this.collidedOnTheFront = collidedOnTheFront;
     }

     public void setCollidedOnTheBack(boolean collidedOnTheBack) {
         this.collidedOnTheBack = collidedOnTheBack;
     }

     public boolean isCollidedOnTheRight() {
         return collidedOnTheRight;
     }

     public boolean isCollidedOnTheLeft() {
         return collidedOnTheLeft;
     }

     public boolean isCollidedOnTheFront() {
         return collidedOnTheFront;
     }

     public boolean isCollidedOnTheBack() {
         return collidedOnTheBack;
     }

     public int getHp() {
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }

     public boolean isInblink() {
         return inblink;
     }

     public long getLastinblink() {
         return lastinblink;
     }

     public void setInblink(boolean inblink) {
         this.inblink = inblink;
     }

     public void setLastinblink(long lastinblink) {
         this.lastinblink = lastinblink;
     }

     public long getLastStar() {
         return lastStar;
     }

     public void setLastStar(long lastStar) {
         this.lastStar = lastStar;
     }

     public long getLastShield() {
         return lastShield;
     }

     public void setLastShield(long lastShield) {
         this.lastShield = lastShield;
     }

     public boolean isInShield() {
         return inShield;
     }

     public void setInShield(boolean inShield) {
         this.inShield = inShield;
     }

     public int getK() {
         return k;
     }

     public void setK(int k) {
         this.k = k;
     }

     public int getDmg() {
         return dmg;
     }

     public void setDmg(int dmg) {
         this.dmg = dmg;
     }

     @Override
     public boolean overlaps(GameObject o) {
         return (this.getX()  > o.getX() && this.getX() - this.getWidth()/2f < o.getX() + o.getWidth() || o.getX() > this.getX() && o.getX() < this.getX() + this.getWidth() + this.getWidth()/2f) &&
                 (this.getY() > o.getY() && this.getY() < o.getY() + o.getHeight() || o.getY() > this.getY() && o.getY() < this.getY() + this.getHeight());
     }
 }
