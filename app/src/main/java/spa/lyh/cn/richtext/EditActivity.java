package spa.lyh.cn.richtext;

import android.os.Build;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
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

        webView.loadData(EditWeb.webString, "text/html", "UTF-8");
        //webView.loadDataWithBaseURL("about：blank",StaticWeb.webString, "text/html", "UTF-8","");
    }
}
