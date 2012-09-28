package com.noobs2d.scene2d;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Drawable actor with a bounding box equal to its visible region.
 * 
 * @author MrUseL3tter
 */
public class SpriteActor extends ConcreteActor {

    private TextureRegion region;

    /** Default constructor */
    public SpriteActor(TextureRegion region, float x, float y) {
	this.region = region;
	setPosition(x, y);
	setWidth(region.getRegionWidth());
	setHeight(region.getRegionHeight());
	setOrigin(region.getRegionWidth() / 2, region.getRegionHeight() / 2);
    }

    /*
     * (non-Javadoc)
     * @see com.badlogic.gdx.scenes.scene2d.Actor#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch,
     * float)
     */
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
	float x = getX(), y = getY();
	batch.setColor(getColor().r, getColor().g, getColor().b, parentAlpha);
	switch (getRegistration()) {
	    case BOTTOM_CENTER:
		setOrigin(getWidth() / 2, 0);
		x = getX() - getWidth() / 2;
		break;
	    case BOTTOM_LEFT:
		setOrigin(0, 0);
		break;
	    case BOTTOM_RIGHT:
		setOrigin(getWidth(), 0);
		x = getX() - getWidth();
		break;
	    case CENTER_CENTER:
		setOrigin(getWidth() / 2, getHeight() / 2);
		x = getX() - getWidth() / 2;
		y = getY() - getHeight() / 2;
		break;
	    case RIGHT_CENTER:
		setOrigin(getWidth(), getHeight() / 2);
		x = getX() - getWidth();
		y = getY() - getHeight() / 2;
		break;
	    case LEFT_CENTER:
		setOrigin(0, getHeight() / 2);
		y = getY() - getHeight() / 2;
		break;
	    case TOP_CENTER:
		setOrigin(getWidth() / 2, getHeight());
		x = getX() - getWidth() / 2;
		y = getY() - getHeight();
		break;
	    case TOP_LEFT:
		setOrigin(0, getHeight());
		y = getY() - getHeight();
		break;
	    case TOP_RIGHT:
		setOrigin(getWidth(), getHeight());
		x = getX() - getWidth();
		y = getY() - getHeight();
		break;
	}
	batch.draw(region, x, y, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
