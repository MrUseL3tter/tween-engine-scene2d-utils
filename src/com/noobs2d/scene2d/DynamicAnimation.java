package com.noobs2d.scene2d;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * NOTE: The actor's dimension is overriden by the animation's current keyframe dimension.
 * 
 * @author MrUseL3tter
 */
public class DynamicAnimation extends DynamicActor {

    public final TextureRegion[] keyFrames;

    public float frameDuration;
    public int frameIndex;
    public int frameCount;
    public boolean isPlaying = true;
    public boolean isRepeating = true;
    public float timeElapsed = 0;
    public float stateTime = 0;

    public DynamicAnimation(DynamicAnimation clone) {
	keyFrames = clone.keyFrames;
	frameDuration = clone.frameDuration;
	frameIndex = clone.frameIndex;
	frameCount = clone.frameCount;
	setWidth(getKeyFrame().getRegionWidth());
	setHeight(getKeyFrame().getRegionHeight());
    }

    public DynamicAnimation(float frameDuration, List<TextureRegion> keyFrames) {
	this.keyFrames = new TextureRegion[keyFrames.size()];
	this.frameDuration = frameDuration;

	for (int index = 0; index < keyFrames.size(); index++)
	    this.keyFrames[index] = keyFrames.get(index);
	setWidth(getKeyFrame().getRegionWidth());
	setHeight(getKeyFrame().getRegionHeight());
    }

    public DynamicAnimation(float frameDuration, TextureRegion... keyFrames) {
	this.keyFrames = keyFrames;
	this.frameDuration = frameDuration;
	frameCount = keyFrames.length;
	setWidth(getKeyFrame().getRegionWidth());
	setHeight(getKeyFrame().getRegionHeight());
    }

    public DynamicAnimation(Texture texture, int offsetX, int offsetY, int frameWidth, int frameHeight, int framesPerRow, int frameCount, float frameDuration) {
	keyFrames = new TextureRegion[frameCount];
	this.frameDuration = frameDuration;
	this.frameCount = frameCount;

	int textureIndex = 0, x = offsetX, y = offsetY;
	int numRows = frameCount % framesPerRow == 0 ? frameCount / framesPerRow : frameCount / framesPerRow + 1;
	for (int rows = 1; rows <= numRows; rows++) {
	    for (int columns = 1; columns <= framesPerRow; columns++)
		if (textureIndex == frameCount)
		    columns = framesPerRow + 1;
		else {
		    keyFrames[textureIndex] = new TextureRegion(texture, x, y, frameWidth, frameHeight);
		    x += frameWidth;
		    textureIndex++;
		}

	    x = offsetX;
	    y += frameHeight;
	}
	setWidth(getKeyFrame().getRegionWidth());
	setHeight(getKeyFrame().getRegionHeight());
    }

    @Override
    public void act(float delta) {
	super.act(delta);
	timeElapsed += delta;
	if (isPlaying) {
	    stateTime += delta;
	    frameIndex = (int) (stateTime / frameDuration);
	    if (!isRepeating)
		frameIndex = Math.min(keyFrames.length - 1, frameIndex);
	    else
		frameIndex = frameIndex % keyFrames.length;
	}
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
	batch.setColor(getColor());
	float x = getX(), y = getY();
	float width = getWidth(), height = getHeight();
	switch (getRegistration()) {
	    case BOTTOM_CENTER:
		setOrigin(width / 2, 0);
		x = getX() - width / 2;
		break;
	    case BOTTOM_LEFT:
		setOrigin(0, 0);
		break;
	    case BOTTOM_RIGHT:
		setOrigin(width, 0);
		x = getX() - width;
		break;
	    case CENTER_CENTER:
		setOrigin(width / 2, height / 2);
		x = getX() - width / 2;
		y = getY() - height / 2;
		break;
	    case RIGHT_CENTER:
		setOrigin(width, height / 2);
		x = getX() - width;
		y = getY() - height / 2;
		break;
	    case LEFT_CENTER:
		setOrigin(0, height / 2);
		y = getY() - height / 2;
		break;
	    case TOP_CENTER:
		setOrigin(width / 2, height);
		x = getX() - width / 2;
		y = getY() - height;
		break;
	    case TOP_LEFT:
		setOrigin(0, height);
		y = getY() - height;
		break;
	    case TOP_RIGHT:
		setOrigin(width, height);
		x = getX() - width;
		y = getY() - height;
		break;
	}
	batch.draw(getKeyFrame(), x, y, getOriginX(), getOriginY(), width, height, getScaleX(), getScaleY(), getRotation());

    }

    public TextureRegion getKeyFrame() {
	return keyFrames[frameIndex];
    }
}
