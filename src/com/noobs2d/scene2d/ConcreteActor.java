package com.noobs2d.scene2d;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class ConcreteActor extends Actor {

    private Registration registration = Registration.CENTER_CENTER;

    /** @return {@link Registration} instance. */
    public Registration getRegistration() {
	return registration;
    }

    /*
     * (non-Javadoc)
     * @see com.badlogic.gdx.scenes.scene2d.Actor#hit(float, float, boolean)
     */
    @Override
    public Actor hit(float x, float y, boolean touchable) {
	if (touchable && getTouchable() != Touchable.enabled)
	    return null;
	float boundsX = getX(), boundsY = getY();
	switch (getRegistration()) {
	    case BOTTOM_LEFT:
		// default
		break;
	    case BOTTOM_CENTER:
		boundsX = getX() - getWidth() * getScaleX() / 2;
		break;
	    case BOTTOM_RIGHT:
		boundsX = getX() - getWidth() * getScaleX();
		break;
	    case CENTER_CENTER:
		boundsX = getX() - getWidth() * getScaleX() / 2;
		boundsY = getY() - getHeight() * getScaleY() / 2;
		break;
	    case LEFT_CENTER:
		boundsX = getX() - getWidth() * getScaleX();
		boundsY = getY() - getHeight() * getScaleY() / 2;
		break;
	    case TOP_CENTER:
		boundsX = getX() - getWidth() * getScaleX() / 2;
		boundsY = getY() - getHeight() * getScaleY();
		break;
	    case TOP_LEFT:
		boundsX = getX() - getWidth() * getScaleX();
		boundsY = getY() - getHeight() * getScaleY();
		break;
	    case TOP_RIGHT:
		boundsY = getY() - getHeight() * getScaleY();
		break;
	}
	System.out.println(getX() + "\t" + getY() + "\t" + getWidth() * getScaleX() + "\t" + getHeight() * getScaleY());
	return x >= boundsX && x < boundsX + getWidth() * getScaleX() && y >= boundsY && y < boundsY + getHeight() * getScaleY() ? this : null;
    }

    /** @param registration {@link Registration} instance. */
    public void setRegistration(Registration registration) {
	this.registration = registration;
    }
}
