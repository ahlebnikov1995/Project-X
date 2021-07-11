package com.mygdx.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.spaceshooter.Progress;
import com.mygdx.spaceshooter.InTheDark;
import com.mygdx.spaceshooter.gameui.ButtonBack;
import com.mygdx.spaceshooter.gameui.treeButtons.Button1;
import com.mygdx.spaceshooter.gameui.treeButtons.Button2;
import com.mygdx.spaceshooter.gameui.treeButtons.Button3;
import com.mygdx.spaceshooter.gameui.treeButtons.Button4;
import com.mygdx.spaceshooter.gameui.treeButtons.Button5;

public class SkillTreeScreen implements Screen {
    InTheDark game;
    OrthographicCamera camera;
    SpriteBatch batch;
    BitmapFont font;
    Texture imgButton1;
    Texture imgButton1p;
    Texture imgButton2;
    Texture imgButton2p;
    Texture imgButton3;
    Texture imgButton3p;
    Texture imgButton4;
    Texture imgButton4p;
    Texture imgButton5;
    Texture imgButton5p;
    Texture imgButtonBack;
    Texture imgBG;

    Button1 button1;
    Button2 button2;
    Button3 button3;
    Button4 button4;
    Button5 button5;
    ButtonBack buttonBack;

    boolean sh;
    boolean st;
    boolean doub;


    Stage stage;

    public SkillTreeScreen(InTheDark game) {

        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(1,0,0,1);
        font.getData().scale(GameScreen.SCR_WIDTH/1000f);
        camera.setToOrtho(false, com.mygdx.spaceshooter.screens.GameScreen.SCR_WIDTH, com.mygdx.spaceshooter.screens.GameScreen.SCR_HEIGHT);

        

        imgBG = new Texture("ScreenTreeSkillsBG.png");
        imgButton1 = new Texture("ButtonSkill1.png");
        imgButton1p = new Texture("ButtonSkill1Pressed.png");
        imgButton2 = new Texture("ButtonSkill2.png");
        imgButton2p = new Texture("ButtonSkill2Pressed.png");
        imgButton3 = new Texture("ButtonSkill3.png");
        imgButton3p = new Texture("ButtonSkill3Pressed.png");
        imgButton4 = new Texture("ButtonSkill4.png");
        imgButton4p = new Texture("ButtonSkill4Pressed.png");
        imgButton5 = new Texture("ButtonSkill5.png");
        imgButton5p = new Texture("ButtonSkill5Pressed.png");
        imgButtonBack = new Texture("circletest (6).png");


        button1 = new Button1(imgButton1,imgButton1p);
        button2 = new Button2(imgButton2,imgButton2p);
        button3 = new Button3(imgButton3,imgButton3p);
        button4 = new Button4(imgButton4,imgButton4p);
        button5 = new Button5(imgButton5,imgButton5p);
        buttonBack = new ButtonBack(imgButtonBack,game);
        buttonBack.setX(buttonBack.getWidth()*0.25f);
        buttonBack.setY(GameScreen.SCR_HEIGHT - buttonBack.getHeight() - buttonBack.getWidth()*0.25f);


        stage = new Stage();

        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(buttonBack);


        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
            if(!sh && Progress.Talent.encHP >= 10){
                sh = true;
                stage.addActor(button3);
            }
            if(!st && Progress.Talent.encDMG >= 10){
                st = true;
                stage.addActor(button4);
            }
            if(!doub && Progress.Talent.isStar && Progress.Talent.isShield && Progress.lvlPlayer == 30){
                doub = true;
                stage.addActor(button5);
            }





            camera.update();
            batch.setProjectionMatrix(camera.combined);
            batch.begin();
            batch.draw(imgBG,0,0,GameScreen.SCR_WIDTH,GameScreen.SCR_HEIGHT);
            stage.draw();
            font.draw(batch, "Points: " + Progress.talentPoints,  button1.getX() + button1.getWidth(), GameScreen.SCR_HEIGHT - GameScreen.SCR_HEIGHT/12f);
            stage.draw();

            if(Progress.Talent.encHP != 0) {
                font.draw(batch, "" + Progress.Talent.encHP, button1.getX(), button1.getY() + button1.getHeight());
            }
           if(Progress.Talent.encDMG != 0) {
                font.draw(batch, "" + Progress.Talent.encDMG, button2.getX(), button2.getY() + button1.getHeight());
           }
            if(Progress.Talent.isShield){
                font.draw(batch, "1", button3.getX(), button3.getY() + button1.getHeight());
            }
            if(Progress.Talent.isStar){
                font.draw(batch, "1", button4.getX(), button4.getY() + button1.getHeight());
            }
            if(Progress.Talent.doubleHP_DMG != 0) {
                font.draw(batch, "" + Progress.Talent.doubleHP_DMG, button5.getX() + button5.getWidth() / 2f, button5.getY() + button1.getHeight());
            }


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
        imgButton1.dispose();
        imgButton1p.dispose();
        imgButton2.dispose();
        imgButton2p.dispose();
        imgButton3.dispose();
        imgButton3p.dispose();
        imgButton4.dispose();
        imgButton4p.dispose();
        imgButton5.dispose();
        imgButton5p.dispose();
        imgButtonBack.dispose();
        imgBG.dispose();
    }
}
