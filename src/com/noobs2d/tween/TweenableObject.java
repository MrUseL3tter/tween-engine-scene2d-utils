package com.noobs2d.tween;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenEquation;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Holds any Actor instance and interpolates it.
 * 
 * @author MrUseL3tter
 */
public class TweenableObject<T> implements TweenAccessor<TweenableObject<Actor>> {

    static final int POSITION_X = 0x01;
    static final int POSITION_Y = 0x02;
    static final int POSITION_XY = 0x03;
    static final int SCALE_X = 0x04;
    static final int SCALE_Y = 0x05;
    static final int SCALE_XY = 0x06;
    static final int ROTATION = 0x07;
    static final int COLOR_R = 0x08;
    static final int COLOR_G = 0x09;
    static final int COLOR_B = 0xA;
    static final int COLOR_A = 0xB;
    static final int COLOR_RGB = 0xC;
    static final int COLOR_RGBA = 0xD;

    public T instance;

    public Tween tween;
    public TweenManager tweenManager = new TweenManager();
    public long tweenDeltaTime = System.currentTimeMillis();
    public float tweenSpeed = 1f;

    /** Register this accessor. Invoke once. */
    public static void register() {
	Tween.registerAccessor(TweenableObject.class, new TweenableObject<Actor>());
    }

    /** Default */
    public TweenableObject(T type) {
	instance = type;
    }

    /** Must not be able to create an empty instance. */
    protected TweenableObject() {

    }

    /*
     * (non-Javadoc)
     * @see aurelienribon.tweenengine.TweenAccessor#getValues(java.lang.Object, int, float[])
     */
    @Override
    public int getValues(TweenableObject<Actor> target, int tweenType, float[] returnValues) {
	switch (tweenType) {
	    case POSITION_X:
		returnValues[0] = target.instance.getX();
		return 1;
	    case POSITION_Y:
		returnValues[0] = target.instance.getY();
		return 1;
	    case POSITION_XY:
		returnValues[0] = target.instance.getX();
		returnValues[1] = target.instance.getY();
		return 2;
	    case SCALE_X:
		returnValues[0] = target.instance.getScaleX();
		return 1;
	    case SCALE_Y:
		returnValues[0] = target.instance.getScaleY();
		return 1;
	    case SCALE_XY:
		returnValues[0] = target.instance.getScaleX();
		returnValues[1] = target.instance.getScaleY();
		return 2;
	    case ROTATION:
		returnValues[0] = target.instance.getRotation();
		return 1;
	    case COLOR_R:
		returnValues[0] = target.instance.getColor().r;
		return 1;
	    case COLOR_G:
		returnValues[0] = target.instance.getColor().g;
		return 1;
	    case COLOR_B:
		returnValues[0] = target.instance.getColor().b;
		return 1;
	    case COLOR_A:
		returnValues[0] = target.instance.getColor().a;
		return 1;
	    case COLOR_RGB:
		returnValues[0] = target.instance.getColor().r;
		returnValues[1] = target.instance.getColor().g;
		returnValues[2] = target.instance.getColor().b;
		return 3;
	    case COLOR_RGBA:
		returnValues[0] = target.instance.getColor().r;
		returnValues[0] = target.instance.getColor().g;
		returnValues[0] = target.instance.getColor().b;
		returnValues[0] = target.instance.getColor().a;
		return 4;
	    default:
		assert false;
		return -1;
	}
    }

    /**
     * Tween the A-region of the color.
     * 
     * @param targetAlpha Target A-region of the color.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateAlpha(float targetAlpha, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_A, duration).target(targetAlpha);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the A-region of the color with easing {@link TweenEquation}.
     * 
     * @param targetAlpha Target A-region of the color.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateAlpha(float targetAlpha, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_A, duration).target(targetAlpha).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the B-region of the color.
     * 
     * @param targetB Target R-region of the color.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorB(float targetB, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_B, duration).target(targetB);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the B-region of the color with easing {@link TweenEquation}.
     * 
     * @param targetB Target R-region of the color.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorB(float targetB, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_B, duration).target(targetB).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the G-region of the color.
     * 
     * @param targetG Target R-region of the color.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorG(float targetG, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_G, duration).target(targetG);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the G-region of the color with easing {@link TweenEquation}.
     * 
     * @param targetG Target R-region of the color.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorG(float targetG, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_G, duration).target(targetG).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the R-region of the color.
     * 
     * @param targetR Target R-region of the color.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorR(float targetR, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_R, duration).target(targetR);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the R-region of the color with easing {@link TweenEquation}.
     * 
     * @param targetR Target R-region of the color.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorR(float targetR, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_R, duration).target(targetR).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the RGB-region of the color.
     * 
     * @param targetR Target R-region of the color.
     * @param targetG Target G-region of the color.
     * @param targetB Target B-region of the color.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorRGB(float targetR, float targetG, float targetB, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_RGB, duration).target(targetR, targetG, targetB);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the RGB-region of the color with easing {@link TweenEquation}.
     * 
     * @param targetR Target R-region of the color.
     * @param targetG Target G-region of the color.
     * @param targetB Target B-region of the color.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorRGB(float targetR, float targetG, float targetB, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_RGB, duration).target(targetR, targetG, targetB).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the RGBA-region of the color.
     * 
     * @param targetR Target R-region of the color.
     * @param targetG Target G-region of the color.
     * @param targetB Target B-region of the color.
     * @param targetA Target A-region of the color.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorRGBA(float targetR, float targetG, float targetB, float targetA, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_RGBA, duration).target(targetR, targetG, targetB, targetA);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the RGBA-region of the color with easing {@link TweenEquation}.
     * 
     * @param targetR Target R-region of the color.
     * @param targetG Target G-region of the color.
     * @param targetB Target B-region of the color.
     * @param targetA Target A-region of the color.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateColorRGBA(float targetR, float targetG, float targetB, float targetA, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, COLOR_RGBA, duration).target(targetR, targetG, targetB, targetA).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the rotation.
     * 
     * @param targetRotation Target rotation.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateRotation(float targetRotation, int duration, boolean autoStart) {
	tween = Tween.to(this, ROTATION, duration).target(targetRotation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the rotation with easing {@link TweenEquation}.
     * 
     * @param targetRotation Target rotation.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateRotation(float targetRotation, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, ROTATION, duration).target(targetRotation).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x scale.
     * 
     * @param targetScaleX Target x scale.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateScaleX(float targetScaleX, int duration, boolean autoStart) {
	tween = Tween.to(this, SCALE_X, duration).target(targetScaleX);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x scale with easing {@link TweenEquation}.
     * 
     * @param targetScaleX Target x scale.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateScaleX(float targetScaleX, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, SCALE_X, duration).target(targetScaleX).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x and y scale.
     * 
     * @param targetScaleX Target x scale.
     * @param targetScaleY Target y scale.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateScaleXY(float targetScaleX, float targetScaleY, int duration, boolean autoStart) {
	tween = Tween.to(this, SCALE_XY, duration).target(targetScaleX, targetScaleY);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x and y scale with easing {@link TweenEquation}.
     * 
     * @param targetScaleX Target x scale.
     * @param targetScaleY Target y scale.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateScaleXY(float targetScaleX, float targetScaleY, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, SCALE_XY, duration).target(targetScaleX, targetScaleY).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the y scale.
     * 
     * @param targetScaleY Target y scale.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateScaleY(float targetScaleY, int duration, boolean autoStart) {
	tween = Tween.to(this, SCALE_Y, duration).target(targetScaleY);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the y scale with easing {@link TweenEquation}.
     * 
     * @param targetScaleY Target y scale.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateScaleY(float targetScaleY, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, SCALE_Y, duration).target(targetScaleY).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x position.
     * 
     * @param targetX Target x position.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateX(float targetX, int duration, boolean autoStart) {
	tween = Tween.to(this, POSITION_X, duration).target(targetX);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x position with easing {@link TweenEquation}.
     * 
     * @param targetX Target x position.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateX(float targetX, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, POSITION_X, duration).target(targetX).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x and y position.
     * 
     * @param targetX Target x position.
     * @param targetY Target y position.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateXY(float targetX, float targetY, int duration, boolean autoStart) {
	tween = Tween.to(this, POSITION_XY, duration).target(targetX, targetY);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the x and y position with easing {@link TweenEquation}.
     * 
     * @param targetX Target x position.
     * @param targetY Target y position.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateXY(float targetX, float targetY, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, POSITION_XY, duration).target(targetX, targetY).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the y position.
     * 
     * @param targetY Target y position.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateY(float targetY, int duration, boolean autoStart) {
	tween = Tween.to(this, POSITION_Y, duration).target(targetY);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /**
     * Tween the y position with easing {@link TweenEquation}.
     * 
     * @param targetY Target y position.
     * @param equation {@link TweenEquation} easing to use.
     * @param duration Duration in milliseconds.
     * @param autoStart Set to false to allow {@link Tween#repeat(int, float)}.
     * @return Tween {@link Tween} instance for chaining.
     */
    public Tween interpolateY(float targetY, TweenEquation equation, int duration, boolean autoStart) {
	tween = Tween.to(this, POSITION_Y, duration).target(targetY).ease(equation);
	tweenDeltaTime = System.currentTimeMillis();
	if (autoStart)
	    tween.start(tweenManager);
	return tween;
    }

    /*
     * (non-Javadoc)
     * @see aurelienribon.tweenengine.TweenAccessor#setValues(java.lang.Object, int, float[])
     */
    @Override
    public void setValues(TweenableObject<Actor> target, int tweenType, float[] newValues) {
	switch (tweenType) {
	    case POSITION_X:
		target.instance.setX(newValues[0]);
		break;
	    case POSITION_Y:
		target.instance.setY(newValues[0]);
		break;
	    case POSITION_XY:
		target.instance.setX(newValues[0]);
		target.instance.setY(newValues[1]);
		break;
	    case SCALE_X:
		target.instance.setScaleX(newValues[0]);
		break;
	    case SCALE_Y:
		target.instance.setScaleY(newValues[0]);
		break;
	    case SCALE_XY:
		target.instance.setScaleX(newValues[0]);
		target.instance.setScaleY(newValues[1]);
		break;
	    case ROTATION:
		target.instance.setRotation(newValues[0]);
		break;
	    case COLOR_R:
		target.instance.setColor(newValues[0], target.instance.getColor().g, target.instance.getColor().b, target.instance.getColor().a);
		break;
	    case COLOR_G:
		target.instance.setColor(target.instance.getColor().r, newValues[0], target.instance.getColor().b, target.instance.getColor().a);
		break;
	    case COLOR_B:
		target.instance.setColor(target.instance.getColor().r, target.instance.getColor().g, newValues[0], target.instance.getColor().a);
		break;
	    case COLOR_A:
		target.instance.setColor(target.instance.getColor().r, target.instance.getColor().g, target.instance.getColor().b, newValues[0]);
		break;
	    case COLOR_RGB:
		target.instance.setColor(newValues[0], newValues[1], newValues[2], target.instance.getColor().a);
		break;
	    case COLOR_RGBA:
		target.instance.setColor(newValues[0], newValues[1], newValues[2], newValues[3]);
		break;
	    default:
		assert false;
	}

    }

    /** If not called, the tween won't work. */
    public void updateTween() {
	tweenManager.update((int) (System.currentTimeMillis() - tweenDeltaTime) * tweenSpeed);
	tweenDeltaTime = System.currentTimeMillis();
    }

}
