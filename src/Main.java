import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.noobs2d.scene2d.DynamicAnimation;
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

	Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
	Label label = new Label("TEST LABEL", new LabelStyle(new BitmapFont(Gdx.files.internal("data/GOODGIRL_32.fnt"), false), Color.GREEN));
	label.setPosition(400, 300);
	stage.addActor(label);

	Texture animationTexture = new Texture(Gdx.files.internal("data/animation.png"));
	DynamicAnimation animationActor = new DynamicAnimation(animationTexture, 0, 0, 32, 45, 4, 4, 0.15f);
	animationActor.setPosition(400, 300);
	animationActor.setScale(5f, 5f);
	stage.addActor(animationActor);
    }

    @Override
    public void render() {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	stage.draw();
	stage.act();
    }

}
