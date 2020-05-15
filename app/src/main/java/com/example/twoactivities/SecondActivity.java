package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        //get the text as string


        //gets the intent that activated this activity
        Intent intent = getIntent();
        //get the extra string message from the intent with the key
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //find the text view
        TextView textView = findViewById(R.id.text_message);
        //set the text gotten from the intent to it
        textView.setText(message);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        //reply intent
        Intent replyIntent = new Intent();

        replyIntent.putExtra(EXTRA_REPLY, reply);
        //set the result status
        setResult(RESULT_OK, replyIntent);
        //close the activity
        finish();

    }
}
