import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.noobs2d.scene2d.DynamicAnimation;
import com.noobs2d.scene2d.DynamicScreen;

public class AnimationScreen extends DynamicScreen {

    public AnimationScreen(Game game) {
	super(game);
	Texture animationTexture = new Texture(Gdx.files.internal("data/animation.png"));
	DynamicAnimation animationActor = new DynamicAnimation(animationTexture, 0, 0, 32, 45, 4, 4, 0.15f);
	animationActor.setPosition(400, 300);
	animationActor.setScale(5f, 5f);
	stage.addActor(animationActor);
	stage.getCamera().update();
	stage.getCamera().position.y += 250;
	stage.addListener(new InputListener() {

	    @Override
	    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		System.out.println(x + "\t" + y);
		return true;
	    }

	    @Override
	    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		//		System.out.println("up " + event.getTarget());
	    }
	});
    }

    @Override
    public void render(float delta) {
	super.render(delta);
	//	System.out.println(stage.getCamera().position);
    }
}
