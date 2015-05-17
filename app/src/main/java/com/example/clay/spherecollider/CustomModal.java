package com.example.clay.spherecollider;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Clay on 4/25/2015.
 */
public class CustomModal {

    public final Dialog d;
    private Context context;

    public CustomModal(final Context context, String type, HashMap<String, String> options){
        this.context = context;
        d = new Dialog(context,R.style.CustomDialogTheme);

        // set properties that are the same for all instances of this modal
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d.setCanceledOnTouchOutside(false); // cancel any outside touches
        d.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.modal_bg));

        // call launchModal here based on type
        switch(type){
            case "level_complete":
                setUpLevelCompleteModal(context, options);
                break;
            case "info":
                setUpInfoModal(context, options);
                break;
            case "alert":
                break;
        }

        Button close_btn = (Button) d.findViewById(R.id.btnClose);
        close_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                d.dismiss();
                // will probably later want to make navigation back to main View (HOME)
                Intent mainScreen = new Intent(context, SphereCollider.class);
                context.startActivity(mainScreen);
            }
        });
        d.show(); //show modal
    }


    public void setUpLevelCompleteModal(final Context context, HashMap<String, String> options){
        d.setContentView(R.layout.level_complete_modal_content);

        ((TextView)d.findViewById(R.id.txtViewScore)).setText(String.format(context.getResources().getString(R.string.level_score), options.get("score")));
        ((TextView)d.findViewById(R.id.textViewModalTitle)).setText( options.get("title") );
//        ((TextView)d.findViewById(R.id.txtViewTime)).setText(String.format(context.getResources().getString(R.string.level_time_completed), options.get("time")));

        ((ProgressBar)d.findViewById(R.id.progressBarPoints)).setProgress(Integer.parseInt( options.get("scoreProgressVal") ));

        Button btnShowLevels = (Button)d.findViewById(R.id.btnShowLevels);
        btnShowLevels.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // launch levelView
                Intent viewLevels = new Intent(context, LevelView.class);
                context.startActivity(viewLevels);
                d.dismiss();
            }
        });
        Button btnNextLevel = (Button)d.findViewById(R.id.btnNextLevel);
        btnNextLevel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // need to figure out how to pass in function here

                // clear current game - Wyatt probably has a reset method or something to go here

                // get next level info
//                System.out.println("getCurrentLevelID:::" + ((BallGame)context).getCurrentLevelId() + 1);
//                ((BallGame)context).setCurrentLevelId(((BallGame) context).getCurrentLevelId() + 1);

                CurrentLevel currentLevel = CurrentLevel.getInstance(context);
                currentLevel.setLevelId(currentLevel.getLevelId() + 1);

                Intent startBallGame = new Intent(context, BallGame.class);
                context.startActivity(startBallGame);

                d.dismiss();
            }
        });
    }


    public void setUpInfoModal(Context context, HashMap<String, String> options){
        d.setContentView(R.layout.info_modal_content);
        TextView modalTitle = (TextView) d.findViewById(R.id.txtModalTitle);
        modalTitle.setText(options.get("modal_title").toString());
        TextView modalContent = (TextView)d.findViewById(R.id.txtModalContent);
        modalContent.setText(options.get("modal_content").toString());
    }
}
