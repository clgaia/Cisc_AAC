package com.example.cisc_aac;

import android.annotation.SuppressLint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class emotions extends AppCompatActivity {
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


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_emotions);



        //get current myList status - words in top
        myList = MyList.getInstance();
        TextInputEditText textView = findViewById(R.id.text_input_edit_text);
        String allValues = String.join(" ", myList.getItems());
        textView.setText(allValues);


        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.

                /*
        defines each button on the home page
         */
        Button home_button = findViewById(R.id.home_button);
        Button backspace = findViewById(R.id.backspace);
        Button speak_button = findViewById(R.id.speak_button);
        Button word1 = findViewById(R.id.emotions_1);
        Button word2 = findViewById(R.id.emotions_2);
        Button word3 = findViewById(R.id.emotions_3);
        Button word4 = findViewById(R.id.emotions_4);
        Button word5 = findViewById(R.id.emotions_5);
        Button tone = findViewById(R.id.emotions_6);
        Button word7 = findViewById(R.id.emotions_7);
        Button word8 = findViewById(R.id.emotions_8);
        Button word9 = findViewById(R.id.emotions_9);
        Button word10 = findViewById(R.id.emotions_10);
        Button word11 = findViewById(R.id.emotions_11);
        Button word12 = findViewById(R.id.emotions_12);
        Button word13 = findViewById(R.id.emotions_13);
        Button word14 = findViewById(R.id.emotions_14);
        Button word15 = findViewById(R.id.emotions_15);
        Button word16 = findViewById(R.id.emotions_16);
        Button word17 = findViewById(R.id.emotions_17);
        Button word18 = findViewById(R.id.emotions_18);

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

        word1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "Home"
                myList.addItem(word1.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "school"
                myList.addItem(word2.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "grocery store"
                myList.addItem(word3.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "movies"
                myList.addItem(word4.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "park"
                myList.addItem(word5.getText().toString());
                textView.setText(myList.getString());
            }
        });

        tone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: Add popup with tone selection options and append to end of list

                textView.setText(myList.getString());
            }
        });

        word7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "work"
                myList.addItem(word7.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "bar"
                myList.addItem(word8.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "mall"
                myList.addItem(word9.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "gym"
                myList.addItem(word10.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "doctor"
                myList.addItem(word11.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add "restaurant"
                myList.addItem(word12.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
                myList.addItem(word13.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
                myList.addItem(word14.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
                myList.addItem(word15.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
                myList.addItem(word16.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
                myList.addItem(word17.getText().toString());
                textView.setText(myList.getString());
            }
        });

        word18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              TODO: add text box popup
                myList.addItem(word18.getText().toString());
                textView.setText(myList.getString());
            }
        });
    }

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

}