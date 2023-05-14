package com.example.cisc_aac;

import android.annotation.SuppressLint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Locale;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
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
    private MyList myList;
    TextToSpeech tts;

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
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
            TextInputEditText textView = findViewById(R.id.text_input_edit_text);
            textView.setText(myList.getString());
        }
    };

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onPause(){
        if(tts !=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        //get current myList status - words in top
        myList = MyList.getInstance();
        TextInputEditText textView = findViewById(R.id.text_input_edit_text);
        String allValues = String.join(" ", myList.getItems());
        textView.setText(allValues);

//        mControlsView = findViewById(R.id.fullscreen_content_controls);
//        mContentView = findViewById(R.id.fullscreen_content);

        /*
        defines each button on the home page
         */
        Button home_button = findViewById(R.id.home_button);
        Button backspace = findViewById(R.id.backspace);
        Button speak_button = findViewById(R.id.speak_button);
        Button recent1 = findViewById(R.id.button_1);
        Button recent2 = findViewById(R.id.button_2);
        Button recent3 = findViewById(R.id.button_3);
        Button recent4 = findViewById(R.id.button_4);
        Button recent5 = findViewById(R.id.button_5);
        Button tone = findViewById(R.id.button_6);
        Button emotions = findViewById(R.id.button_7);
        Button people = findViewById(R.id.button_8);
        Button places = findViewById(R.id.button_9);
        Button food = findViewById(R.id.button_10);
        Button time = findViewById(R.id.button_11);
        Button myself = findViewById(R.id.button_12);
        Button greetings = findViewById(R.id.button_13);
        Button personal = findViewById(R.id.button_14);
        Button things = findViewById(R.id.button_15);
        Button leisure = findViewById(R.id.button_16);
        Button little_words = findViewById(R.id.button_17);
        Button new_word = findViewById(R.id.button_18);


        /*
        defines each button listener on the home page
         */
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(myList.getString());
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TODO: delete most recent word added to list
                  myList.removeItem();
                  textView.setText(myList.getString());
            }
        });

        speak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: read list in order using text-to-speech and clear list
                String words = myList.getString();
                tts = new TextToSpeech(getApplicationContext(), status -> {
                    if (status == TextToSpeech.SUCCESS) {
                        // Set language for text-to-speech
                        int result = tts.setLanguage(Locale.US);
                        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Log.e("TTS", "Language not supported");
                        } else {
                            // Speak the string
                            tts.speak(words, TextToSpeech.QUEUE_FLUSH, null,null);
                        }
                    } else {
                        Log.e("TTS", "Initialization failed");
                    }

                });
                myList.clear();
                textView.setText(myList.getString());
            }
        });

        recent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Label button first word on stack
                //myList.addItem("good?");
                textView.setText(myList.getString());

            }
        });

        recent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Label button second word on stack
            }
        });

        recent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Label button third word on stack
            }
        });

        recent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Label button fourth word on stack
            }
        });

        recent5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Label button fifth word on stack
            }
        });

        tone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Add popup with tone selection options and append to end of list
            }
        });

        emotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FullscreenActivity.this, emotions.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, people.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, places_fullscreen.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, food.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, time.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        myself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, myself.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        greetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, greetings.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, personal.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        things.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, things.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        leisure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, leisure.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        little_words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FullscreenActivity.this, little.class);
                startActivity(intent);
                textView.setText(myList.getString());
            }
        });

        new_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Add popup that asks what category for new word to go in, adds new word to that category
//                if max words reached, ask which word to delete
            }
        });








        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
//        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }




}