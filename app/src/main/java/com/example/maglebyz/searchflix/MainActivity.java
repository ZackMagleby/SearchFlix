package com.example.maglebyz.searchflix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText searchWord;
    String currentSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchWord = (EditText) findViewById(R.id.searchName);
        searchWord.setOnFocusChangeListener(new EditText.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
            /* When focus is lost check that the text field
            * has valid values.
            */
            //hasFocus = false;
                if (!hasFocus) {
                    currentSearch = searchWord.getText().toString();
                    //validateInput(v);
                }
            }
        });
        searchWord.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Clear focus here from edittext
                    searchWord.clearFocus();
                }
                return false;
            }
        });
    }
}
