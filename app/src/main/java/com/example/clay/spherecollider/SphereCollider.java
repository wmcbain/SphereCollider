package com.example.clay.spherecollider;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.HashMap;


public class SphereCollider extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere_collider);
        initSplashButtons();
    }


    /**
     * sets up listeners for splash buttons
     */
    public void initSplashButtons(){

        // push to levels activity
        findViewById(R.id.btnViewLevels).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showLevels();
            }

        });

        // about button
        findViewById(R.id.btnViewAbout).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                HashMap<String, String> options = new HashMap<String, String>();
                // options:
                options.put("modal_title", "About This App");
                options.put("modal_content", getString(R.string.about_info) );
                CustomModal cm = new CustomModal(SphereCollider.this, "info", options);
            }

        });
    }

    public void showLevels(){
        // create and Intent to launch the ViewContact Activity
        Intent viewLevels = new Intent(SphereCollider.this, LevelView.class);
        startActivity(viewLevels);
    }
}
