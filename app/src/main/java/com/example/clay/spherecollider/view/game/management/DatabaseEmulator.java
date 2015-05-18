package com.example.clay.spherecollider.view.game.management;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.clay.spherecollider.R;
import com.example.clay.spherecollider.view.game.models.Background;
import com.example.clay.spherecollider.view.game.models.Ball;
import com.example.clay.spherecollider.view.game.models.Inflater;
import com.example.clay.spherecollider.view.game.models.Point;
import com.example.clay.spherecollider.view.game.models.Reducer;
import com.example.clay.spherecollider.view.game.models.Score;
import com.example.clay.spherecollider.view.game.util.RandomUtility;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Stub class to emulate getting objects from the database
 */
public class DatabaseEmulator {
    private Context context;
    private GameMediator gameMediator;
    private ConcurrentLinkedQueue models;
    private int xMax, yMax;
    private int maxPoints;

    /**
     * Default constructor
     *
     */
    public DatabaseEmulator() {
        gameMediator = GameMediator.getInstance();
        this.models = gameMediator.getModels();
        this.context = gameMediator.getContext();
        this.xMax = gameMediator.getXMax();
        this.yMax = gameMediator.getYMax();
    }

    public void getLevelObjects() {
        Random random = new Random();
        int numberOfIncreasers = 5;
        int numberOfDecreasers = 5;
        int numberOfPoints = 20;
        models.add(new Background(getBitmap(R.drawable.level1)));

        int ballStartingSize = Math.round((float) yMax * 0.05f);

        while (numberOfPoints != 0) {
            int value = RandomUtility.randIntInRange(10, 30);
            int size = value + ballStartingSize;
            Point point = new Point(size, value, "#ffd600");
            point = (Point)RandomUtility.randomizeLocation(point);
            models.add(point);
            numberOfPoints--;
        }

        while (numberOfIncreasers != 0) {
            int inflateValue = RandomUtility.randIntInRange(40, 80);
            int maxValue = inflateValue * 3;
            int size = inflateValue + ballStartingSize;
            Inflater inflater = new Inflater(size, maxValue, inflateValue, "#fc8d4d");
            inflater = (Inflater)RandomUtility.randomizeLocation(inflater);
            models.add(inflater);
            numberOfIncreasers--;
        }
        while (numberOfDecreasers != 0) {
            int reduceValue = RandomUtility.randIntInRange(10, 20);
            int maxValue = reduceValue * 3;
            int size = reduceValue + ballStartingSize;
            Reducer reducer = new Reducer(size, maxValue, reduceValue, "#fc8d4d");
            reducer = (Reducer)RandomUtility.randomizeLocation(reducer);
            models.add(reducer);
            numberOfDecreasers--;
        }
        models.add(new Ball(ballStartingSize, "#fc8d4d"));
        models.add(new Score());
    }

    private int getXFromPercent(float percent) {
        return Math.round(percent * xMax);
    }

    private int getYFromPercent(float percent) {
        return Math.round(percent * yMax);
    }

    private Bitmap getBitmap(int id) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), id, options);
        return Bitmap.createBitmap(image);
    }

}
