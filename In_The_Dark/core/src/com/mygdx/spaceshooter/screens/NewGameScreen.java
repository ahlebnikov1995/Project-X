package com.mygdx.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.gameui.ButtonBack;
import com.mygdx.spaceshooter.gameui.ButtonNo;
import com.mygdx.spaceshooter.gameui.ButtonYes;

public class NewGameScreen implements Screen {
    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;


    Texture imgBG;
    Texture imgYes;
    Texture imgNo;

    Texture imgAnimFire;

    TextureRegion trAnimFire;

    Animation animFire;

    ButtonYes buttonYes;
    ButtonNo buttonNo;




    Stage stage;

    public NewGameScreen(InTheDark game) {

        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);



        imgBG = new Texture("NewGameScreen.png");
        imgYes = new Texture("ButtonYes.png");
        imgNo = new Texture("ButtonNo.png");
        imgAnimFire = new Texture("fireAnim.png");

        trAnimFire = new TextureRegion(imgAnimFire);

        animFire = new Animation(trAnimFire, 4, 1);

        buttonYes = new ButtonYes(imgYes,game,new MainMenuScreen(game));
        buttonNo = new ButtonNo(imgNo,game,new MainMenuScreen(game));




        stage = new Stage();
        stage.addActor(buttonYes);
        stage.addActor(buttonNo);





        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        camera.update();
        animFire.update(delta);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgBG,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);

        batch.draw(imgYes,buttonYes.getX(),buttonYes.getY(),buttonYes.getWidth(),buttonYes.getHeight());
        batch.draw(imgNo,buttonNo.getX(),buttonNo.getY(),buttonNo.getWidth(),buttonNo.getHeight());

        batch.draw(animFire.getFrame(),buttonYes.getX(),buttonYes.getY() + buttonYes.getHeight(),buttonYes.getWidth(),buttonYes.getHeight()*1.5f);
        batch.draw(animFire.getFrame(),buttonNo.getX(),buttonNo.getY() + buttonYes.getHeight(),buttonNo.getWidth(),buttonNo.getHeight()*1.5f);


        batch.end();


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
        imgNo.dispose();
        imgYes.dispose();
        imgBG.dispose();
        imgAnimFire.dispose();

    }
}
