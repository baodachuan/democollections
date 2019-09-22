package com.bdc.lib_common.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bdc.lib_common.Constants;
import com.bdc.lib_common.R;

@Route(path = Constants.MODULE_COMMON_WEBVIEW)
public class CommonWebViewActivity extends AppCompatActivity {
    ProgressBar progressBar;
    private WebView webView;
    private String content;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_brower);
        toolbar = findViewById(R.id.tool_bar);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        webView = (WebView) findViewById(R.id.web_view);
        String title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");

        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(false);
//        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAppCacheEnabled(true);
//        settings.setLoadWithOverviewMode(true);


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }

        });
        webView.loadDataWithBaseURL(null, "<style>img{display: inline; height: auto; max-width: 100%;} " +

                "</style>\n" + "<style>iframe{ height: auto; width: auto;}" + "</style>\n" + content, null, "utf-8", null);


    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
