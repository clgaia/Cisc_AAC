package com.example.cisc_aac;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class leisure extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (AUTO_HIDE) {
                        delayedHide(AUTO_HIDE_DELAY_MILLIS);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    view.performClick();
                    break;
                default:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_leisure);

        mVisible = true;


        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        /*
        defines each button on the home page
         */
        Button home_button = findViewById(R.id.home_button);
        Button backspace = findViewById(R.id.backspace);
        Button speak_button = findViewById(R.id.speak_button);
        Button word1 = findViewById(R.id.leisure_1);
        Button word2 = findViewById(R.id.leisure_2);
        Button word3 = findViewById(R.id.leisure_3);
        Button word4 = findViewById(R.id.leisure_4);
        Button word5 = findViewById(R.id.leisure_5);
        Button tone = findViewById(R.id.leisure_6);
        Button word7 = findViewById(R.id.leisure_7);
        Button word8 = findViewById(R.id.leisure_8);
        Button word9 = findViewById(R.id.leisure_9);
        Button word10 = findViewById(R.id.leisure_10);
        Button word11 = findViewById(R.id.leisure_11);
        Button word12 = findViewById(R.id.leisure_12);
        Button word13 = findViewById(R.id.leisure_13);
        Button word14 = findViewById(R.id.leisure_14);
        Button word15 = findViewById(R.id.leisure_15);
        Button word16 = findViewById(R.id.leisure_16);
        Button word17 = findViewById(R.id.leisure_17);
        Button word18 = findViewById(R.id.leisure_18);

        /*
        defines each button listener on the home page
         */
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_fullscreen);
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TODO: delete most recent word added to list
            }
        });

        speak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: read list in order using text-to-speech and clear list
            }
        });

        word1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "Home"
            }
        });

        word2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "school"
            }
        });

        word3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "grocery store"
            }
        });

        word4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "movies"
            }
        });

        word5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "park"
            }
        });

        tone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Add popup with tone selection options and append to end of list
            }
        });

        word7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "work"
            }
        });

        word8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "bar"
            }
        });

        word9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "mall"
            }
        });

        word10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "gym"
            }
        });

        word11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "doctor"
            }
        });

        word12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "restaurant"
            }
        });

        word13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
            }
        });

        word14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
            }
        });

        word15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
            }
        });

        word16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
            }
        });

        word17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
            }
        });

        word18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}