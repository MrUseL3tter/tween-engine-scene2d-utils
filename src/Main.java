import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.noobs2d.TweenableObject;

public class Main extends Game {

    Stage stage;
    TweenableObject<Actor> tweenableActor;

    public static void main(String[] args) {
	new LwjglApplication(new Main(), "tween-engine-scene2d-utils test", 800, 600, false);
    }

    @Override
    public void create() {
	stage = new Stage();
	final TextureRegion region = new TextureRegion(new Texture("data/badlogic.jpg"));
	final Actor actor = new Actor() {

	    @Override
	    public void draw(SpriteBatch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, parentAlpha);
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	    }
	};
	actor.setBounds(15, 15, 100, 100);
	tweenableActor = new TweenableObject<Actor>(actor);
	stage.addActor(actor);

	// tween this shit
	tweenableActor.interpolateXY((float) Math.random() * 800, (float) Math.random() * 600, 1000, false).repeatYoyo(Tween.INFINITY, 0).start(tweenableActor.tweenManager);
	tweenableActor.interpolateRotation(360, 1000, false).repeat(Tween.INFINITY, 0).start(tweenableActor.tweenManager);
    }

    @Override
    public void render() {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	stage.draw();
	tweenableActor.updateTween();
    }

}
