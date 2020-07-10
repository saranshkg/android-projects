package com.gtest.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gtest.game.camera.AndroidCamera;

public class SplashScreen implements Screen {

    private Texture splashtexture;
    private Image splashimage;
    private Stage splashstage;
    private float WIDTH,HEIGHT;

    public SplashScreen() {

    }

    @Override
    public void show() {

        WIDTH = 1280;
        HEIGHT = 720;

        splashtexture = new Texture(Gdx.files.internal("splashScreen.png"));
        splashtexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        splashimage = new Image(splashtexture);
        splashimage.setSize(1280,720);

        splashstage = new Stage(new FitViewport(WIDTH,HEIGHT, new AndroidCamera(WIDTH,HEIGHT)));
        splashstage.addActor(splashimage);

        splashimage.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(1.25F),Actions.delay(1F), Actions.fadeOut(0.75F)));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        splashstage.act();
        splashstage.draw();
    }

    @Override
    public void resize(int width, int height) {
        splashstage.getViewport().update(width,height,true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        splashtexture.dispose();
        splashstage.dispose();
    }
}