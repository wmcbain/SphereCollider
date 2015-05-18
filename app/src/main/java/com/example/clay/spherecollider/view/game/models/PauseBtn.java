package com.example.clay.spherecollider.view.game.models;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;


import com.example.clay.spherecollider.view.game.management.GameMediator;
import com.example.clay.spherecollider.view.game.util.PaintUtility;


/**
 * Class for pause button drawn on canvas on surface view
 */
public class PauseBtn implements GameModel {
    private GameMediator gameMediator;
    private Paint backgroundPaint, textPaint;
    private ModelType type;

    private int xMax, yMax;
    private Rect bounds;

    public PauseBtn() {
        type = ModelType.PAUSE_BTN;
        gameMediator = GameMediator.getInstance();
        xMax = gameMediator.getXMax();
        yMax = gameMediator.getYMax();
        this.initializePaint();
        this.initializeRect();
    }

    @Override
    public void render(Canvas canvas) {
        canvas.drawRect(bounds, backgroundPaint);
        canvas.drawText("l l", xMax - 120, 30, textPaint); // "l l" => looks like pause button sort of.
                                                           // IDK you can think of a better idea if you want
    }

    @Override
    public Rect getBounds() {
        return bounds;
    }

    @Override
    public ModelType getType() {
        return type;
    }

    // i want this to be on the other side of the screen (top left corner)
    // OR OTHER OPTION : put score on top left and this pause button on the top right corner
    // ( Doing so will conform to other Games standards
    private void initializeRect() {
        bounds = new Rect(xMax - 140, 0, xMax, 50);
    }

    private void initializePaint() {
        backgroundPaint = PaintUtility.configurePaintWithAlpha("#333333", 0.8f);
        textPaint = PaintUtility.configurePaintForText("#ffffff", 18);
        Typeface typeface = Typeface.create("Helvetica", Typeface.BOLD);
        textPaint.setTypeface(typeface);
    }

    /*

    CODE FOR CALLING PAUSE BUTTON MODAL




     */

}