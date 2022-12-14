package com.example.wordle_helper.Activities;

import android.widget.TextView;

import com.example.wordle_helper.R;

/**
 * Generates and inserts the text that should be placed into the main edit text of the
 * Word Display Activity.
 */
public class SetupWordDisplayThread extends Thread {
    private final WordDisplayActivity activity;
    private final TextView targetSection;

    public SetupWordDisplayThread(WordDisplayActivity activity) {
        this.activity = activity;
        this.targetSection = activity.findViewById(R.id.all_words);
    }

    @Override
    public void run(){
        StringBuilder text = new StringBuilder(MainActivity.mModel.getNumWords() * 5);
        java.util.List<String> words = MainActivity.mModel.getRemainingWords();
        for(String current : words){
            text.append(current);
            text.append("\t\t");
        }


        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // Actual UI updates
                targetSection.setText(text.toString());
            }
        });

    }
}
