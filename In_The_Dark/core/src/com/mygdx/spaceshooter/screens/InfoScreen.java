package com.mygdx.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.gameui.ButtonNo;
import com.mygdx.spaceshooter.gameui.ButtonToNextInfo;
import com.mygdx.spaceshooter.gameui.ButtonToPreInfo;
import com.mygdx.spaceshooter.gameui.ButtonYes;

public class InfoScreen implements Screen {
    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Integer count;


    Texture bg1;
    Texture bg2;
    Texture bg3;
    Texture imgNext;
    Texture imgBack;

    ButtonToNextInfo buttonToNextInfo;
    ButtonToPreInfo buttonToPreInfo;




    Stage stage;

    public InfoScreen(InTheDark game) {

        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        stage = new Stage();
        camera.setToOrtho(false, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);
        count = 1;



        bg1 = new Texture("Inctruction1.png");
        bg2 = new Texture("Inctruction2.png");
        bg3 = new Texture("Inctruction3.png");
        imgNext = new Texture("circletest (7).png");
        imgBack = new Texture("circletest (7_2).png");

        buttonToPreInfo = new ButtonToPreInfo(imgBack,count,stage,buttonToNextInfo,this);
        buttonToNextInfo = new ButtonToNextInfo(imgNext,count,stage,buttonToPreInfo,game,this);





        stage.addActor(buttonToNextInfo);






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

        if(count == 1)
        batch.draw(bg1,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);

        if(count == 2)
        batch.draw(bg2,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);

        if(count == 3)
        batch.draw(bg3,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);






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
        bg1.dispose();
        bg2.dispose();
        bg3.dispose();
        imgBack.dispose();
        imgNext.dispose();

    }
    public void incCount(){
        count++;
    }
    public void decCount(){
        count--;
    }
    public void addBut(){
        stage.addActor(buttonToPreInfo);
    }
    public void delBut(){
        stage.clear();
        stage.addActor(buttonToNextInfo);
    }
    public void toHS(){
        game.setScreen(new HomeScreen(game));
    }

    public Integer getCount() {
        return count;
    }
}
