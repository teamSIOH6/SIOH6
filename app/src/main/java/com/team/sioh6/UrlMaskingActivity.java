package com.team.sioh6;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UrlMaskingActivity extends AppCompatActivity {
    ProgressDialog dialog;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_masking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        dialog=new ProgressDialog(this);


        String name=getIntent().getStringExtra("name");
        String link=getIntent().getStringExtra("link");

        getSupportActionBar().setTitle(name);

        dialog.setMessage("Processing...");
        dialog.show();
        WebView myWebView =findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //webSettings.setPluginState(WebSettings.PluginState.ON);
        //webSettings.setAllowFileAccess(true);

//        WebViewClient myWebviewclient=new WebViewClient();

        myWebView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
            }
        });
        myWebView.setWebChromeClient(new WebChromeClient(){
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        myWebView.getSettings().setGeolocationDatabasePath( getFilesDir().getPath() );
        myWebView.loadUrl(link);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
