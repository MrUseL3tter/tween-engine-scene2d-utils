package com.noobs2d.scene2d;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class DynamicScreen extends InputAdapter implements Screen {

    protected Game game;
    protected Stage stage;

    public DynamicScreen(Game game) {
	this.game = game;
	stage = new Stage();
	Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose() {
	stage.dispose();
    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub
    }

    @Override
    public boolean keyDown(int keycode) {
	return stage.keyDown(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
	return stage.keyTyped(character);
    }

    @Override
    public boolean keyUp(int keycode) {
	return stage.keyUp(keycode);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
	return stage.mouseMoved(screenX, screenY);
    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    @Override
    public void render(float delta) {
	stage.act(delta);
	stage.draw();
    }

    @Override
    public void resize(int width, int height) {
	stage.setViewport(width, height, true);
	System.out.println("[DynamicScreen] resize(int,int)");
    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean scrolled(int amount) {
	return stage.scrolled(amount);
    }

    @Override
    public void show() {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	return stage.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
	return stage.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	return stage.touchUp(screenX, screenY, pointer, button);
    }

}
