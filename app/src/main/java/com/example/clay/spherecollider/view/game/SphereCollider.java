package com.example.clay.spherecollider.view.game;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.clay.spherecollider.database.DatabaseConnector;
import com.example.clay.spherecollider.view.dialogs.CustomModal;
import com.example.clay.spherecollider.view.game.management.GameMediator;
import com.example.clay.spherecollider.view.game.sensors.SensorHandler;
import com.example.clay.spherecollider.view.game.view.GameSurface;
import com.example.clay.spherecollider.view.level.CurrentLevel;
import com.example.clay.spherecollider.view.util.AudioPlayer;

import java.util.ArrayList;
import java.util.HashMap;


public class SphereCollider extends Activity {
    private GameSurface gameSurface;
    private SensorHandler sensorHandler;

    /**
     * Executes when the activity is created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set to fullscreen and landscape
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        sensorHandler = new SensorHandler(this);
        GameMediator mediator = GameMediator.getInstance();
        mediator.setContext(this);
        mediator.setSensorHandler(sensorHandler);

        gameSurface = new GameSurface(this);
        setContentView(gameSurface);
    }

    /**
     * Activity override
     * Called when the activity resumes
     */
    @Override
    protected void onResume()
    {
        super.onResume();
        sensorHandler.startSensorListener();
    }

    /**
     * Activity override
     * Called when the game stops
     */
    @Override
    protected void onStop()
    {
        // Unregister the listener
        sensorHandler.stopSensorListener();
        super.onStop();
    }

    /**
     * Activity override
     * Called when the configuration changes
     *
     * @param newConfig the new configuration
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
