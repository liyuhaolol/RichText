package cns.workspace.lib.androidsdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liyuhao on 2017/6/7.
 */

public class CnsCommonUtil {
    /**
     * dp转px
     * @param context 上下文
     * @param dpValue dp值
     * @return px值
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale);
    }

    /**
     * px转dp
     * @param context 上下文
     * @param pxValue px值
     * @return dp值
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale);
    }

    /**
     * 禁止EditText输入空格
     * @param editText
     */
    public static void setEditTextInhibitInputSpace(EditText editText){
        InputFilter filter=new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if(source.equals(" ")){
                    return "";
                }
                else{
                    return null;
                }
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    /**
     * 禁止EditText输入特殊字符
     * @param editText
     */
    public static void setEditTextInhibitInputSpeChat(EditText editText){

        InputFilter filter=new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                String speChat="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
                Pattern pattern = Pattern.compile(speChat);
                Matcher matcher = pattern.matcher(source.toString());
                if(matcher.find())return "";
                else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }


    /**
     * 判断当前应用是否是debug状态
     */
     public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            } catch (Exception e) {
            return false;
            }
        }

    /**
     * * 用于获取状态栏的高度。 使用Resource对象获取
     *
     * @param context 上下文
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * * 用于获取状态栏的高度。 使用Resource对象获取
     *
     * @param context 上下文
     * @return 返回状态栏高度的像素值。
     */
    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    /**
     * 判断手机是否存在导航栏
     * @param context
     * @return
     */
    public static boolean checkDeviceHasNavigationBar(Context context) {
       /* //通过判断设备是否有返回键、菜单键(不是虚拟键,是手机屏幕外的按键)来确定是否有navigation bar
        boolean hasMenuKey = ViewConfiguration.get(context)
                .hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap
                .deviceHasKey(KeyEvent.KEYCODE_BACK);

        if (!hasMenuKey && !hasBackKey) {
            // 做任何你需要做的,这个设备有一个导航栏
            return true;
        }
        return false;*/
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }

    /** 读取Assets文件夹中的图片资源
     * @param context
     * @param fileName 图片名称
     * @return
      */
    public static Bitmap getImageFromAssetsFile(Context context, String fileName) {
        Bitmap image = null;
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * 检查网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context
                .getApplicationContext().getSystemService(
                        Context.CONNECTIVITY_SERVICE);

        if (manager == null) {
            return false;
        }

        NetworkInfo networkinfo = manager.getActiveNetworkInfo();

        if (networkinfo == null || !networkinfo.isAvailable()) {
            return false;
        }

        return true;
    }

    /**
     * 打开软键盘
     * @param mContext
     */
    public static void openKeybord(Activity mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mContext.getWindow().getDecorView(), InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mContext 上下文
     */
    public static void closeKeybord(Activity mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mContext.getWindow().getDecorView().getWindowToken(), 0);
    }


    /**
     * float转int四舍五入
     * @param f
     * @return
     */
    public static int floatToInt(float f){
        int i = 0;
        if(f > 0){
            //正数
            i = (int) ((f*10 + 5)/10);
        } else if(f < 0){
            //负数
            i = (int) ((f*10 - 5)/10);
        }
        return i;
    }

    /**
     * 停止gif播放
     * @param imageView
     */
    public static void stopGIF(ImageView imageView){
        if (imageView != null){
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
        }
    }


    /**
     * 开始gif播放
     * @param imageView
     */
    public static void startGIF(ImageView imageView){
        if (imageView != null){
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
    }

    /**
     * list去重
     * @param list
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
