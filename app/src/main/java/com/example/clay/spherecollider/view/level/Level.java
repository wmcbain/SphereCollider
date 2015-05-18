package com.example.clay.spherecollider.view.level;

/**
 * Created by Clay on 4/11/2015.
 */
public class Level {
    // level props
    private String levelName;
    private String levelBgImgsrc;
    private String levelCompleted;
    // colors
    private String ballColor;
    private String inflaterColor;
    private String deflaterColor;

    private int maxPoints;
    private int oneStarPoints;
    private int twoStarPoints;
    private int threeStarPoints;

    private int numLives;
    private int numDeflaters;
    private int numInflaters;
    private int inflaterMaxVelocity;
    private int inflaterMinVelocity;

    // later will want to probably pass in the levelId from database results and get the levels coins
    public Level(
            String levelName,
            String levelBgImgsrc,
            String levelCompleted,
            String ballColor,
            String inflaterColor,
            String deflaterColor,
            int maxPoints,
            int oneStarPoints,
            int twoStarPoints,
            int threeStarPoints,
            int numLives,
            int numDeflaters,
            int numInflaters,
            int inflaterMaxVelocity,
            int inflaterMinVelocity
    ){
        this.levelName = levelName;
        this.levelBgImgsrc = levelBgImgsrc;
        this.levelCompleted = levelCompleted;
        this.ballColor = ballColor;
        this.inflaterColor = inflaterColor;
        this.deflaterColor = deflaterColor;
        this.maxPoints = maxPoints;
        this.oneStarPoints = oneStarPoints;
        this.twoStarPoints = twoStarPoints;
        this.threeStarPoints = threeStarPoints;
        this.numLives = numLives;
        this.numDeflaters = numDeflaters;
        this.numInflaters = numInflaters;
        this.inflaterMaxVelocity = inflaterMaxVelocity;
        this.inflaterMinVelocity = inflaterMinVelocity;

    }


    public String getLevelBgImgsrc() {
        return levelBgImgsrc;
    }

    public void setLevelBgImgsrc(String levelBgImgsrc) {
        this.levelBgImgsrc = levelBgImgsrc;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelCompleted() {
        return levelCompleted;
    }

    public void setLevelCompleted(String levelCompleted) {
        this.levelCompleted = levelCompleted;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getOneStarPoints() {
        return oneStarPoints;
    }

    public void setOneStarPoints(int oneStarPoints) {
        this.oneStarPoints = oneStarPoints;
    }

    public int getTwoStarPoints() {
        return twoStarPoints;
    }

    public void setTwoStarPoints(int twoStarPoints) {
        this.twoStarPoints = twoStarPoints;
    }

    public int getThreeStarPoints() {
        return threeStarPoints;
    }

    public void setThreeStarPoints(int threeStarPoints) {
        this.threeStarPoints = threeStarPoints;
    }

    public String getBallColor() {
        return ballColor;
    }

    public void setBallColor(String ballColor) {
        this.ballColor = ballColor;
    }

    public String getInflaterColor() {
        return inflaterColor;
    }

    public void setInflaterColor(String inflaterColor) {
        this.inflaterColor = inflaterColor;
    }

    public String getDeflaterColor() {
        return deflaterColor;
    }

    public void setDeflaterColor(String deflaterColor) {
        this.deflaterColor = deflaterColor;
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public int getNumDeflaters() {
        return numDeflaters;
    }

    public void setNumDeflaters(int numDeflaters) {
        this.numDeflaters = numDeflaters;
    }

    public int getNumInflaters() {
        return numInflaters;
    }

    public void setNumInflaters(int numInflaters) {
        this.numInflaters = numInflaters;
    }

    public int getInflaterMaxVelocity() {
        return inflaterMaxVelocity;
    }

    public void setInflaterMaxVelocity(int inflaterMaxVelocity) {
        this.inflaterMaxVelocity = inflaterMaxVelocity;
    }

    public int getInflaterMinVelocity() {
        return inflaterMinVelocity;
    }

    public void setInflaterMinVelocity(int inflaterMinVelocity) {
        this.inflaterMinVelocity = inflaterMinVelocity;
    }
}
