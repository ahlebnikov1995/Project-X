package com.mygdx.spaceshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.spaceshooter.screens.MainMenuScreen;

public class InTheDark extends Game {

    SpriteBatch batch;
    BitmapFont font;
    public static Music music;


    @Override
    public void create() {

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Progress.read();
            }
        });

        myThread.start();


        batch = new SpriteBatch();
        font = new BitmapFont();
        music = Gdx.audio.newMusic(Gdx.files.internal("schematist-san.mp3"));
        music.setLooping(true);
        music.setVolume(0.2f);
        if(Progress.isMusic) {
            music.play();
        }
        this.setScreen(new MainMenuScreen(this));

    }

    @Override
    public void render() {
        super.render();

    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        font.dispose();
        music.dispose();

    }
}
