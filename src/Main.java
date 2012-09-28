import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.noobs2d.scene2d.AnimationActor;
import com.noobs2d.scene2d.SpriteActor;
import com.noobs2d.tween.TweenableObject;

public class Main extends Game {

    Stage stage;
    TweenableObject<Actor> tweenableActor;

    public static void main(String[] args) {
	new LwjglApplication(new Main(), "tween-engine-scene2d-utils test", 800, 600, false);
    }

    @Override
    public void create() {
	stage = new Stage();
	Gdx.input.setInputProcessor(stage);
	final TextureRegion region = new TextureRegion(new Texture("data/badlogic.jpg"));
	final Actor actor = new SpriteActor(region, 0, 0);
	//		actor.setBounds(15, 15, 100, 100);
	tweenableActor = new TweenableObject<Actor>(actor);
	actor.addListener(new InputListener() {

	    @Override
	    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		System.out.println("down");
		return true;
	    }

	    @Override
	    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		System.out.println("up " + event.getTarget());
	    }
	});
	//	stage.addActor(actor);

	// tween this shit
	//	tweenableActor.interpolateXY((float) Math.random() * 800, (float) Math.random() * 600, 1000, false).repeatYoyo(Tween.INFINITY, 0).start(tweenableActor.tweenManager);
	//	tweenableActor.interpolateRotation(360, 1000, false).repeat(Tween.INFINITY, 0).start(tweenableActor.tweenManager);

	Texture animationTexture = new Texture(Gdx.files.internal("data/animation.png"));
	AnimationActor animationActor = new AnimationActor(animationTexture, 0, 0, 32, 45, 4, 4, 0.15f);
	animationActor.setPosition(400, 300);
	animationActor.setScale(5f, 5f);
	animationActor.addListener(new InputListener() {

	    @Override
	    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		return true;
	    }

	    @Override
	    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		System.out.println("animationActor up");
	    }
	});
	stage.addActor(animationActor);
    }

    @Override
    public void render() {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	stage.draw();
	stage.act();
	tweenableActor.updateTween();
    }

}
