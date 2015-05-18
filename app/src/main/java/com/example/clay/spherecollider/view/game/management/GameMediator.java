package com.example.clay.spherecollider.view.game.management;

import android.content.Context;
import android.util.DisplayMetrics;


import com.example.clay.spherecollider.view.game.models.Ball;
import com.example.clay.spherecollider.view.game.models.Score;
import com.example.clay.spherecollider.view.game.sensors.SensorHandler;
import com.example.clay.spherecollider.view.game.view.GameSurface;

import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Responsible for getting frame information
 */
public class GameMediator {
    private Context context;
    private SensorHandler sensorHandler;
    private GameSurface surface;
    private int xMax, yMax;
    private static GameMediator instance;
    private ConcurrentLinkedQueue models;
    private Ball gameBall;
    private Score gameScore;

    /**
     * Default constructor
     *
     */
    private GameMediator() {}

    /**
     * Gets the instance of the FrameInfo class
     * @return the FrameInfo class
     */
    public static GameMediator getInstance() {
        if (instance == null) {
            instance = new GameMediator();
        }
        return instance;
    }

    /**
     * Gets the frame bounds
     */
    private void getFrameBounds() {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        yMax = Math.round(displayMetrics.heightPixels);
        xMax = Math.round(displayMetrics.widthPixels);
    }

    /**
     * Sets the sensor handler for the activity
     *
     * @param sensorHandler
     */
    public void setSensorHandler(SensorHandler sensorHandler) {
        this.sensorHandler = sensorHandler;
    }

    /**
     * Gets the sensor handler for the actibity
     *
     * @return
     */
    public SensorHandler getSensorHandler() {
        return sensorHandler;
    }

    /**
     * Sets the context of the activity
     *
     * @param context the activity context
     */
    public void setContext(Context context) {
        this.context = context;
        instance.getFrameBounds();
    }

    /**
     * Gets the current activity context
     *
     * @return the current context of the activity
     */
    public Context getContext() {
        return context;
    }

    /**
     * Gets the xMax of the frame
     *
     * @return the x bounds
     */
    public int getXMax() {
        return xMax;
    }

    /**
     * Gets the yMax of the frame
     *
     * @return the y bounds
     */
    public int getYMax() {
        return yMax;
    }

    public ConcurrentLinkedQueue getModels() {
        return models;
    }

    public void setModels(ConcurrentLinkedQueue models) {
        this.models = models;
    }

    public Ball getGameBall() {
        return gameBall;
    }

    public void setGameBall(Ball gameBall) {
        this.gameBall = gameBall;
    }

    public Score getGameScore() {
        return gameScore;
    }

    public void setGameScore(Score gameScore) {
        this.gameScore = gameScore;
    }

    public GameSurface getSurface() {
        return surface;
    }

    public void setSurface(GameSurface surface) {
        this.surface = surface;
    }
}
