package com.mygdx.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.gameui.ButtonBack;
import com.mygdx.spaceshooter.gameui.ButtonBack2;
import com.mygdx.spaceshooter.gameui.ButtonHardMode;
import com.mygdx.spaceshooter.gameui.ButtonMusic;
import com.mygdx.spaceshooter.gameui.MenuButtons.ButtonContinue;
import com.mygdx.spaceshooter.gameui.MenuButtons.ButtonCustomization;
import com.mygdx.spaceshooter.gameui.MenuButtons.ButtonNewGame;

public class SettingsScreen implements Screen {

    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;
    ButtonMusic buttonMusic;
    ButtonHardMode buttonHardMode;
    ButtonBack2 buttonBack2;


    Texture imgMenu;
    Texture imgButMusicOff;
    Texture imgButMusicOn;
    Texture imgHardModeOff;
    Texture imgHardModeOn;
    Texture imgButBack;
    Stage stage;

    public SettingsScreen(InTheDark game, MainMenuScreen menu) {


        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);
        imgMenu = new Texture("Menu.png");
        imgButMusicOff = new Texture("MusicButton(off).png");
        imgButMusicOn = new Texture("MusicButton(on).png");
        imgHardModeOff = new Texture("HardModeButton(off).png");
        imgHardModeOn = new Texture("HardModeButton(on).png");
        imgButBack = new Texture("circletest (7_2).png");
        buttonMusic = new ButtonMusic(imgButMusicOff,imgButMusicOn);
        buttonHardMode = new ButtonHardMode(imgHardModeOff,imgHardModeOn);
        buttonBack2 = new ButtonBack2(imgButBack,game, menu);
        buttonBack2.setHeight(buttonBack2.getHeight()/2f);

        buttonBack2.setX(buttonBack2.getWidth()/3f);
        buttonBack2.setY(buttonBack2.getHeight()/1.5f);


        buttonMusic.setY(GameScreen.SCR_HEIGHT/3f*2 - buttonMusic.getHeight()/2f);
        buttonHardMode.setY(GameScreen.SCR_HEIGHT/3f + buttonHardMode.getHeight()/2f);

        buttonMusic.setHeight(buttonMusic.getHeight()/1.5f);
        buttonHardMode.setHeight(buttonHardMode.getHeight()/0.75f);


        stage = new Stage();

        stage.addActor(buttonMusic);
        stage.addActor(buttonHardMode);
        stage.addActor(buttonBack2);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgMenu,0,0, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);

        batch.end();

        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        imgMenu.dispose();
        imgButMusicOff.dispose();
        imgButMusicOn.dispose();
        imgHardModeOff.dispose();
        imgHardModeOn.dispose();
        imgButBack.dispose();

    }
}
