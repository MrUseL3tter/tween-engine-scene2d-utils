import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.GL10;

public class Main extends Game {

    public static void main(String[] args) {
	new LwjglApplication(new Main(), "tween-engine-scene2d-utils test", 800, 600, false);
    }

    @Override
    public void create() {
	setScreen(new AnimationScreen(this));
    }

    @Override
    public void render() {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	super.render();
    }

}
