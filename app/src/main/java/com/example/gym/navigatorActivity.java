package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class navigatorActivity extends AppCompatActivity {
    private static final String TAG = "navigatorActivity";
    private WebView goTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        overridePendingTransition(R.anim.in,R.anim.out);

        String url = "";
        try {
            url = getIntent().getStringExtra("url");
        }catch (NullPointerException e){
            Log.d(TAG, "onCreate: Empty url");
        }

        goTo = findViewById(R.id.web);
        goTo.setWebViewClient(new WebViewClient());
        goTo.getSettings().getJavaScriptEnabled();
        goTo.loadUrl(url);

    }

    @Override
    public void onBackPressed() {
        if(goTo.canGoBack()){
            goTo.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }
}