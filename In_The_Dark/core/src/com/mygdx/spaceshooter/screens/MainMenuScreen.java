package com.mygdx.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.animations.Animation;
import com.mygdx.spaceshooter.gameui.MenuButtons.ButtonContinue;
import com.mygdx.spaceshooter.gameui.MenuButtons.ButtonCustomization;
import com.mygdx.spaceshooter.gameui.MenuButtons.ButtonNewGame;

public class MainMenuScreen implements Screen {

    final InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;
    ButtonNewGame buttonNewGame;
    ButtonCustomization buttonCustomization;
    ButtonContinue buttonContinue;
    Texture imgButtonCon;
    Texture imgButtonCon2;
    Texture imgButtonNG;
    Texture imgButtonNG2;
    Texture imgButtonCost;
    Texture imgButtonCost2;
    Texture imgAnimHero;
    Texture imgAnimWizard;
    Texture imgMenu;
    TextureRegion trAnimHero;
    TextureRegion trAnimWizard;
    Animation animHero;
    Animation animWizard;

    Stage stage;

    public MainMenuScreen(InTheDark game) {




        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);
        imgButtonCon = new Texture("ButtonContinue.png");
        imgButtonCon2 = new Texture("ButtonContinue2.png");
        imgButtonCost = new Texture("ButtonCustomization.png");
        imgButtonCost2 = new Texture("ButtonCustomization2.png");
        imgButtonNG = new Texture("ButtonNewGame.png");
        imgButtonNG2 = new Texture("ButtonNewGame2.png");
        imgAnimHero = new Texture("idleAnim.png");
        imgAnimWizard = new Texture("AnimBadWizard.png");
        imgMenu = new Texture("Menu.png");
        trAnimHero = new TextureRegion(imgAnimHero);
        trAnimWizard = new TextureRegion(imgAnimWizard);
        animHero = new Animation(trAnimHero,4,1);
        animWizard = new Animation(trAnimWizard,4,1);
        buttonNewGame = new ButtonNewGame(imgButtonNG,imgButtonNG2,game);
        if(!Progress.isStartGame) buttonNewGame.setY(GameScreen.SCR_HEIGHT/3f*2 - buttonNewGame.getHeight()/2f - buttonNewGame.getHeight()/4f);
        buttonContinue = new ButtonContinue(imgButtonCon,imgButtonCon2,buttonNewGame,game);
        buttonCustomization = new ButtonCustomization(imgButtonCost,imgButtonCost2,buttonNewGame,game,this);
        if(!Progress.isStartGame) buttonCustomization.setY(GameScreen.SCR_HEIGHT/3f + buttonCustomization.getHeight()/4f);

        stage = new Stage();

        if(Progress.isStartGame) {
            stage.addActor(buttonContinue);
        }
        stage.addActor(buttonNewGame);
        stage.addActor(buttonCustomization);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        camera.update();
        animHero.update(delta);
        animWizard.update(delta);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgMenu,0,0, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);

        batch.draw(animHero.getFrame(), com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH/8f, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT/3f, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH/8f, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT/3f);
        batch.draw(animWizard.getFrame(), com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH- com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH/3f+ com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH/20f, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT/3f, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH/6f, GameScreen.SCR_HEIGHT/2f);

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
        imgAnimHero.dispose();
        imgAnimWizard.dispose();
        imgButtonNG.dispose();
        imgButtonNG2.dispose();
        imgButtonCost.dispose();
        imgButtonCost2.dispose();
        imgButtonCon.dispose();
        imgButtonCon2.dispose();
    }
}
