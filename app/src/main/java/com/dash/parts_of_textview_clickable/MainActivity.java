package com.dash.parts_of_textview_clickable;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.textView);
        String text="This and It are Clickable.";
        SpannableString spannableString= new SpannableString(text);

        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick( @NonNull View widget) {
                Toast.makeText(MainActivity.this,"This is clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        ClickableSpan clickableSpan2=new ClickableSpan() {
            @Override
            public void onClick( @NonNull View widget) {
                Toast.makeText(MainActivity.this,"It is clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);            //change color
                ds.setUnderlineText(false);        // underline text
            }
        };
        spannableString.setSpan(clickableSpan1,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //which indexed texts are to be clicked
        spannableString.setSpan(clickableSpan2,8,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
