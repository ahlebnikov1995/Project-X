package com.mygdx.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Progress {
    public static Preferences progress = Gdx.app.getPreferences("progress");

    public static boolean isMusic = true;
    public static boolean isHardMode = false;
    public static boolean isStartGame = false;


    public static boolean is1lvlWin = false;
    public static boolean is2lvlWin = false;
    public static boolean is3lvlWin = false;
    public static int talentPoints;
    public static int lvlPlayer = 1;
    public static int exp;
    public static int expToNextLvl = 4000;

    public static class Talent{
        public static int encHP;
        public static int encDMG;
        public static boolean isStar;
        public static boolean isShield;
        public static int doubleHP_DMG;
    }
    public static void write(){
        progress.putBoolean("isStartGame",isStartGame);
        progress.flush();
        progress.putBoolean("isHardMode",isHardMode);
        progress.flush();
        progress.putBoolean("isMusic",isMusic);
        progress.flush();
        progress.putBoolean("is1lvlWin",is1lvlWin);
        progress.flush();
        progress.putBoolean("is2lvlWin",is2lvlWin);
        progress.flush();
        progress.putBoolean("is3lvlWin",is3lvlWin);
        progress.flush();
        progress.putInteger("talentPoints",talentPoints);
        progress.flush();
        progress.putInteger("lvlPlayer",lvlPlayer);
        progress.flush();
        progress.putInteger("exp",exp);
        progress.flush();
        progress.putInteger("encHP", Talent.encHP);
        progress.flush();
        progress.putInteger("encDMG",Talent.encDMG);
        progress.flush();
        progress.putBoolean("isStar", Talent.isStar);
        progress.flush();
        progress.putBoolean("isShield", Talent.isShield);
        progress.flush();
        progress.putInteger("doubleHP_DMG", Talent.doubleHP_DMG);
        progress.flush();


    }

    public static void read(){
        isStartGame = progress.getBoolean("isStartGame", false);
        isHardMode = progress.getBoolean("isHardMode", false);
        isMusic = progress.getBoolean("isMusic",true);
        is1lvlWin = progress.getBoolean("is1lvlWin",false);
        is2lvlWin = progress.getBoolean("is2lvlWin",false);
        is3lvlWin = progress.getBoolean("is3lvlWin",false);
        talentPoints = progress.getInteger("talentPoints",0);
        lvlPlayer = progress.getInteger("lvlPlayer",1);
        exp = progress.getInteger("exp",0);
        Talent.encHP = progress.getInteger("encHP",0);
        Talent.encDMG = progress.getInteger("encDMG",0);
        Talent.isStar = progress.getBoolean("isStar",false);
        Talent.isShield = progress.getBoolean("isShield",false);
        Talent.doubleHP_DMG = progress.getInteger("doubleHP_DMG",0);


    }

    public static void deleteProgress() {
        is1lvlWin = false;
        is2lvlWin = false;
        is3lvlWin = false;
        lvlPlayer = 1;
        exp = 0;
        talentPoints = 0;
        Talent.encDMG = 0;
        Talent.encHP = 0;
        Talent.doubleHP_DMG = 0;
        Talent.isShield = false;
        Talent.isStar = false;
    }

}
