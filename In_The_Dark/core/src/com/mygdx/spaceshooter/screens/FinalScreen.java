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
import com.mygdx.spaceshooter.gameui.ButtonToNextInfo;
import com.mygdx.spaceshooter.gameui.ButtonToPreInfo;

public class FinalScreen implements Screen {
    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Integer count;

    Texture bg;
    Texture imgButton;
    Texture imgAnimFire;
    Texture imgAnimHero;
    Texture imgAnimShield;

    TextureRegion trAnimFire;
    TextureRegion trAnimHero;
    TextureRegion trAnimShield;

    Animation animFire;
    Animation animHero;
    Animation animShield;

    ButtonBack buttonBack;

    Stage stage;

    public FinalScreen(InTheDark game) {

        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        stage = new Stage();
        camera.setToOrtho(false, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);
        count = 1;



        bg = new Texture("FinalScreen.png");
        imgButton = new Texture("circletest (6).png");
        imgAnimFire = new Texture("fireAnim.png");
        imgAnimHero = new Texture("idleAnim.png");
        imgAnimShield = new Texture("AnimShield.png");

        trAnimFire = new TextureRegion(imgAnimFire);
        trAnimHero = new TextureRegion(imgAnimHero);
        trAnimShield = new TextureRegion(imgAnimShield);

        animFire = new Animation(trAnimFire,4,1);
        animHero = new Animation(trAnimHero,4,1);
        animShield = new Animation(trAnimShield,5,1);

        buttonBack = new ButtonBack(imgButton,game);
        buttonBack.setY(buttonBack.getY() - buttonBack.getHeight()/4f);
        buttonBack.setX(buttonBack.getX() + buttonBack.getWidth()/4f);



        stage.addActor(buttonBack);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        camera.update();
        animShield.update(delta);
        animHero.update(delta);
        animFire.update(delta);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(bg,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);

        batch.draw(animFire.getFrame(), GameScreen.SCR_WIDTH/20f, GameScreen.SCR_WIDTH/20f, GameScreen.SCR_WIDTH/20f,  GameScreen.SCR_WIDTH/20f*1.5f);
        batch.draw(animFire.getFrame(), GameScreen.SCR_WIDTH - GameScreen.SCR_WIDTH/10f, GameScreen.SCR_WIDTH/20f, GameScreen.SCR_WIDTH/20f,  GameScreen.SCR_WIDTH/20f*1.5f);

        batch.draw(animHero.getFrame(),GameScreen.SCR_WIDTH/2f - GameScreen.SCR_WIDTH/14f, GameScreen.SCR_HEIGHT/2f, GameScreen.SCR_WIDTH/7f, GameScreen.SCR_HEIGHT/3f);
        batch.draw(animShield.getFrame(), GameScreen.SCR_WIDTH/2f - GameScreen.SCR_WIDTH/6.25f,  GameScreen.SCR_HEIGHT/2f - GameScreen.SCR_HEIGHT/5.5f, GameScreen.SCR_WIDTH/3f,GameScreen.SCR_WIDTH/3f);
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
        bg.dispose();
        imgButton.dispose();
        imgAnimShield.dispose();
        imgAnimHero.dispose();
        imgAnimFire.dispose();
    }
}
