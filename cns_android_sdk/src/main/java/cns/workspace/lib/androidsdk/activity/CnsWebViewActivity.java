package cns.workspace.lib.androidsdk.activity;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cns.workspace.lib.androidsdk.R;
import cns.workspace.lib.androidsdk.utils.CnsCommonUtil;
import cns.workspace.lib.androidsdk.utils.statusbar.StatusBarFontColorControler;

/**
 * 作者：李宇昊
 * 作为转跳界面使用
 */
public class CnsWebViewActivity extends AppCompatActivity {
    private RelativeLayout copy,close;
    private String url;
    private WebView webView;
    private TextView title_tv;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //初始化布局
        setTranslucent();
        StatusBarFontColorControler.setStatusBarMode(this,true);
        View status_bar = findViewById(R.id.status_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, CnsCommonUtil.getStatusBarHeight(this));
        status_bar.setLayoutParams(layoutParams);
        //注册控件
        close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        copy = findViewById(R.id.copy);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(url)){
                    //有链接
                    ClipboardManager cmb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData data = ClipData.newPlainText("url",webView.getUrl());
                    cmb.setPrimaryClip(data);
                    showToast("已复制到剪贴板");
                }else {
                    showToast("没有链接数据");
                }
            }
        });
        title_tv = findViewById(R.id.title);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        //处理数据
        url = getIntent().getStringExtra("url");
        initWebview();
        setWebviewClient();
        setWebChromeClient();



        //加载网页
        if (!TextUtils.isEmpty(url)){
            if (url.startsWith("http")){
                webView.loadUrl(url);
            }else {
                showToast("无效网页链接");
            }
        }else {
            showToast("网页链接为空");
        }
    }


    private void initWebview(){
        webView = findViewById(R.id.web);
        WebSettings webSettings = webView.getSettings();
        //webSettings.setBlockNetworkImage(true);
        // 不支持缩放
        webSettings.setSupportZoom(false);

        // 自适应屏幕大小
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        //使用缓存
        webSettings.setAppCacheEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDatabaseEnabled(true);

        //DOM Storage
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        //启动对js的支持
        webSettings.setJavaScriptEnabled(true);
        //启动Autoplay
        //webSettings.setMediaPlaybackRequiresUserGesture(false);
        //对图片大小适配
        webSettings.setUseWideViewPort(true);
        //对文字大小适配
        webSettings.setLoadWithOverviewMode(true);
        // 判断系统版本是不是5.0或之上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //让系统不屏蔽混合内容和第三方Cookie
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            webSettings.setMixedContentMode(0);//永远允许
        }
    }

    private void setWebviewClient(){
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http")){
                    return super.shouldOverrideUrlLoading(view, url);
                }else {
                    //拦截
                    return true;
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                /*webView.getSettings().setBlockNetworkImage(false);
                if (!webView.getSettings().getLoadsImagesAutomatically()) {

                    webView.getSettings().setLoadsImagesAutomatically(true);
                }*/
            }
        });
    }

    private void setWebChromeClient(){
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (!TextUtils.isEmpty(title)){
                    title_tv.setText(title);
                }
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100){
                    progressBar.setProgress(newProgress);
                    progressBar.setVisibility(View.GONE);//加载完网页进度条消失
                }
                else{
                    progressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    progressBar.setProgress(newProgress);//设置进度值
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }

    /**
     * 非纯色状态栏，比如用图片进入状态栏位置，使用这个方法。如果纯色状态栏使用这个方法，效果与上面一致，但是不再
     * 兼容换肤框架，状态栏颜色需要手动控制。
     */
    private void setTranslucent(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            setSystemUiVisibility(window.getDecorView(),View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 设置显示的样式
     * @param decorView
     * @param visibility
     */
    private void setSystemUiVisibility(View decorView,int visibility){
        setSystemUiVisibility(decorView,visibility,true);
    }

    /**
     * 设置显示的样式
     * @param decorView
     * @param visibility
     */
    private void setSystemUiVisibility(View decorView,int visibility,boolean isAddVisibility){
        int oldVis = decorView.getSystemUiVisibility();
        int newVis = oldVis;
        if (isAddVisibility){
            newVis |= visibility;
        }else {
            newVis &= ~visibility;
        }
        if (newVis != oldVis) {
            decorView.setSystemUiVisibility(newVis);
        }
    }

    private void showToast(String content){
        try{
            Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
