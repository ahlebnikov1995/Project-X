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
import com.mygdx.spaceshooter.gameui.ButtonNo;
import com.mygdx.spaceshooter.gameui.ButtonYes;

public class MissionsScreen implements Screen {
    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;


    Texture imgBG1;
    Texture imgBG2;
    Texture imgBG3;
    Texture imgBGPortal;
    Texture imgYes;
    Texture imgNo;

    ButtonYes buttonYes;
    ButtonNo buttonNo;

    Texture imgAnimFire;

    TextureRegion trAnimFire;

    Animation animFire;


    Stage stage;

    Boolean inPortal;

    public MissionsScreen(InTheDark game, Boolean inPortal) {
        this.inPortal = inPortal;

        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);



        imgBG1 = new Texture("MissionsScreen(1).png");
        imgBG2 = new Texture("MissionsScreen(2).png");
        imgBG3 = new Texture("MissionsScreen(3).png");
        imgBGPortal = new Texture("MissionsScreen(Portal).png");
        imgYes = new Texture("ButtonYes.png");
        imgNo = new Texture("ButtonNo.png");
        imgAnimFire = new Texture("fireAnim.png");

        trAnimFire = new TextureRegion(imgAnimFire);

        animFire = new Animation(trAnimFire, 4, 1);

        buttonYes = new ButtonYes(imgYes,game,inPortal);
        buttonNo = new ButtonNo(imgNo,game);




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
        if(inPortal) {
            batch.draw(imgBGPortal, 0, 0, GameScreen.SCR_WIDTH, GameScreen.SCR_HEIGHT);
        }else{
            if(!Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin) batch.draw(imgBG1, 0, 0, GameScreen.SCR_WIDTH, GameScreen.SCR_HEIGHT);
            if(Progress.is1lvlWin && !Progress.is2lvlWin && !Progress.is3lvlWin) batch.draw(imgBG2, 0, 0, GameScreen.SCR_WIDTH, GameScreen.SCR_HEIGHT);
            if(Progress.is1lvlWin && Progress.is2lvlWin && !Progress.is3lvlWin) batch.draw(imgBG3, 0, 0, GameScreen.SCR_WIDTH, GameScreen.SCR_HEIGHT);
        }
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
        imgBG1.dispose();
        imgBG2.dispose();
        imgBG3.dispose();
        imgBGPortal.dispose();
        imgAnimFire.dispose();

    }
}
