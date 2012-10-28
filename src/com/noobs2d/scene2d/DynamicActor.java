package com.noobs2d.scene2d;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class DynamicActor extends Actor {

    private DynamicRegistration registration = DynamicRegistration.CENTER_CENTER;

    /** @return {@link DynamicRegistration} instance. */
    public DynamicRegistration getRegistration() {
	return registration;
    }

    public Actor hit(Actor actor) {
	return new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight()).overlaps(new Rectangle(getX(), getY(), getWidth(), getHeight())) ? this : null;
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
	if (touchable && getTouchable() != Touchable.enabled)
	    return null;
	float boundsX = 0, boundsY = 0;
	switch (getRegistration()) {
	    case BOTTOM_LEFT:
		// default
		break;
	    case BOTTOM_CENTER:
		boundsX = 0 - getWidth() * getScaleX() / 2;
		break;
	    case BOTTOM_RIGHT:
		boundsX = 0 - getWidth() * getScaleX();
		break;
	    case CENTER_CENTER:
		boundsX = 0 - getWidth() * getScaleX() / 2;
		boundsY = 0 - getHeight() * getScaleY() / 2;
		break;
	    case LEFT_CENTER:
		boundsX = 0 - getWidth() * getScaleX();
		boundsY = 0 - getHeight() * getScaleY() / 2;
		break;
	    case TOP_CENTER:
		boundsX = 0 - getWidth() * getScaleX() / 2;
		boundsY = 0 - getHeight() * getScaleY();
		break;
	    case TOP_LEFT:
		boundsX = 0 - getWidth() * getScaleX();
		boundsY = 0 - getHeight() * getScaleY();
		break;
	    case TOP_RIGHT:
		boundsY = getY() - getHeight() * getScaleY();
		break;
	}
	return x >= boundsX && x < boundsX + getWidth() * getScaleX() && y >= boundsY && y < boundsY + getHeight() * getScaleY() ? this : null;
    }

    /** @param registration {@link DynamicRegistration} instance. */
    public void setRegistration(DynamicRegistration registration) {
	this.registration = registration;
    }
}
