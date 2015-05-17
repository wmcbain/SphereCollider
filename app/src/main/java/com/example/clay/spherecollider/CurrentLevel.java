package com.example.clay.spherecollider;

import android.content.Context;

/**
 * Created by Clay on 5/12/2015.
 */
public class CurrentLevel {
    private static CurrentLevel ourInstance;
    private static Context mContext;

    private static String levelName;
    private static long levelId;
    private static String levelBgImgsrc;
    private static String levelCompleted;

    private static String ballColor;
    private static String inflaterColor;
    private static String deflaterColor;

    private static int maxPoints;
    private static int oneStarPoints;
    private static int twoStarPoints;
    private static int threeStarPoints;

    private static int numLives;
    private static int numDeflaters;
    private static int numInflaters;
    private static int inflaterMaxVelocity;
    private static int inflaterMinVelocity;

    public static CurrentLevel getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new CurrentLevel(context);
        }
        return ourInstance;
    }

    private CurrentLevel(Context context) {
        mContext = context;
    }

    public static String getLevelName() {
        return levelName;
    }

    public static void setLevelName(String levelName) {
        CurrentLevel.levelName = levelName;
    }

    public static String getLevelBgImgsrc() {
        return levelBgImgsrc;
    }

    public static void setLevelBgImgsrc(String levelBgImgsrc) {
        CurrentLevel.levelBgImgsrc = levelBgImgsrc;
    }

    public static String getLevelCompleted() {
        return levelCompleted;
    }

    public static void setLevelCompleted(String levelCompleted) {
        CurrentLevel.levelCompleted = levelCompleted;
    }

    public static int getMaxPoints() {
        return maxPoints;
    }

    public static void setMaxPoints(int maxPoints) {
        CurrentLevel.maxPoints = maxPoints;
    }

    public static int getOneStarPoints() {
        return oneStarPoints;
    }

    public static void setOneStarPoints(int oneStarPoints) {
        CurrentLevel.oneStarPoints = oneStarPoints;
    }

    public static int getTwoStarPoints() {
        return twoStarPoints;
    }

    public static void setTwoStarPoints(int twoStarPoints) {
        CurrentLevel.twoStarPoints = twoStarPoints;
    }

    public static int getThreeStarPoints() {
        return threeStarPoints;
    }

    public static void setThreeStarPoints(int threeStarPoints) {
        CurrentLevel.threeStarPoints = threeStarPoints;
    }

    public static long getLevelId() {
        return levelId;
    }

    public static void setLevelId(long levelId) {
        CurrentLevel.levelId = levelId;
    }

    public static String getBallColor() {
        return ballColor;
    }

    public static void setBallColor(String ballColor) {
        CurrentLevel.ballColor = ballColor;
    }

    public static String getInflaterColor() {
        return inflaterColor;
    }

    public static void setInflaterColor(String inflaterColor) {
        CurrentLevel.inflaterColor = inflaterColor;
    }

    public static String getDeflaterColor() {
        return deflaterColor;
    }

    public static void setDeflaterColor(String deflaterColor) {
        CurrentLevel.deflaterColor = deflaterColor;
    }

    public static int getNumLives() {
        return numLives;
    }

    public static void setNumLives(int numLives) {
        CurrentLevel.numLives = numLives;
    }

    public static int getNumDeflaters() {
        return numDeflaters;
    }

    public static void setNumDeflaters(int numDeflaters) {
        CurrentLevel.numDeflaters = numDeflaters;
    }

    public static int getNumInflaters() {
        return numInflaters;
    }

    public static void setNumInflaters(int numInflaters) {
        CurrentLevel.numInflaters = numInflaters;
    }

    public static int getInflaterMaxVelocity() {
        return inflaterMaxVelocity;
    }

    public static void setInflaterMaxVelocity(int inflaterMaxVelocity) {
        CurrentLevel.inflaterMaxVelocity = inflaterMaxVelocity;
    }

    public static int getInflaterMinVelocity() {
        return inflaterMinVelocity;
    }

    public static void setInflaterMinVelocity(int inflaterMinVelocity) {
        CurrentLevel.inflaterMinVelocity = inflaterMinVelocity;
    }
}
