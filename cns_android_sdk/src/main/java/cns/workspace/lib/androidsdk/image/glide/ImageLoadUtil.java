package cns.workspace.lib.androidsdk.image.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.signature.EmptySignature;

/**
 * Created by liyuhao on 2017/6/7.
 * 图片加载工具
 */

public class ImageLoadUtil {
    private static final int UNSET = -1;


    private static RequestOptions options;

    static {
        options = new RequestOptions()
                .sizeMultiplier(1f)
                .useUnlimitedSourceGeneratorsPool(false)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .priority(Priority.NORMAL)
                .error(null)
                .placeholder(null)
                .skipMemoryCache(false)
                .override(UNSET,UNSET)
                .signature(EmptySignature.obtain())
                .fallback(null)
                .theme(null)
                //.transform()
                .onlyRetrieveFromCache(false);
                //.format(DecodeFormat.PREFER_ARGB_8888);

    }

    public static void displayImage(Context context, Object res, ImageView target) {
        if (context != null){
            if (options != null) {
                Glide.with(context)
                        .asDrawable()
                        .apply(options)
                        .load(res)
                        .into(target);
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

    public static void displayImage(Activity activity, Object res, ImageView target) {
        if (activity != null && !activity.isDestroyed()){
            if (options != null) {
                Glide.with(activity)
                        .asDrawable()
                        .apply(options)
                        .load(res)
                        .into(target);
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

    public static void displayImage(Fragment fragment, Object res, ImageView target) {
        if (fragment != null && fragment.getActivity() != null && !fragment.getActivity().isDestroyed()){
            if (options != null) {
                Glide.with(fragment)
                        .asDrawable()
                        .apply(options)
                        .load(res)
                        .into(target);
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

/*    public static void displayImage(android.support.v4.app.Fragment fragment, Object res, ImageView target) {
        if (fragment != null && fragment.getActivity() != null && !fragment.getActivity().isDestroyed()){
            if (options != null) {
                Glide.with(fragment)
                        .asDrawable()
                        .apply(options)
                        .load(res)
                        .into(target);
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }*/

    public static void displayImage(Context context, Object res, ImageView target, RequestOptions option) {
        if (context != null){
            RequestBuilder<Drawable> builder;
            if (options != null) {

                builder = Glide.with(context)
                        .asDrawable()
                        .apply(options);

                if (option != null) {

                    builder.apply(option)
                            .load(res)
                            .into(target);
                } else {
                    Log.e("ImageLoadUtil", "option为空,加载默认options");

                    builder.load(res)
                            .into(target);
                }
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

    public static void displayImage(Activity activity, Object res, ImageView target, RequestOptions option) {
        if (activity != null && !activity.isDestroyed()){
            RequestBuilder<Drawable> builder;
            if (options != null) {

                builder = Glide.with(activity)
                        .asDrawable()
                        .apply(options);

                if (option != null) {

                    builder.apply(option)
                            .load(res)
                            .into(target);
                } else {
                    Log.e("ImageLoadUtil", "option为空,加载默认options");

                    builder.load(res)
                            .into(target);
                }
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

    public static void displayImage(Fragment fragment, Object res, ImageView target, RequestOptions option) {
        if (fragment != null && fragment.getActivity() != null && !fragment.getActivity().isDestroyed()){
            RequestBuilder<Drawable> builder;
            if (options != null) {

                builder = Glide.with(fragment)
                        .asDrawable()
                        .apply(options);

                if (option != null) {

                    builder.apply(option)
                            .load(res)
                            .into(target);
                } else {
                    Log.e("ImageLoadUtil", "option为空,加载默认options");

                    builder.load(res)
                            .into(target);
                }
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

/*    public static void displayImage(android.support.v4.app.Fragment fragment, Object res, ImageView target, RequestOptions option) {
        if (fragment != null && fragment.getActivity() != null && !fragment.getActivity().isDestroyed()){
            RequestBuilder<Drawable> builder;
            if (options != null) {

                builder = Glide.with(fragment)
                        .asDrawable()
                        .apply(options);
                //.apply(RequestOptions.bitmapTransform(new ColorFilterTransformation(Color.argb(0,255,0,0))));

                if (option != null) {

                    builder.apply(option)
                            .load(res)
                            .into(target);
                } else {
                    Log.e("ImageLoadUtil", "option为空,加载默认options");

                    builder.load(res)
                            .into(target);
                }
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }*/

    /**
     * 显示头像
     * @param activity
     * @param res
     * @param option
     * @param target
     */
    public static void displayHead(Activity activity, Object res, RequestOptions option, SimpleTarget<Bitmap> target){
        if (activity != null && !activity.isDestroyed()){
            RequestBuilder<Bitmap> builder;
            if (options != null) {

                builder = Glide.with(activity)
                        .asBitmap()
                        .apply(options);

                if (option != null) {

                    builder.apply(option)
                            .load(res)
                            .into(target);
                } else {
                    Log.e("ImageLoadUtil", "option为空,加载默认options");
                    builder.load(res)
                            .into(target);
                }
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

    /**
     * 显示头像
     * @param context
     * @param res
     * @param option
     * @param target
     */
    public static void displayHead(Context context, Object res, RequestOptions option, SimpleTarget<Bitmap> target){
        if (context != null){
            RequestBuilder<Bitmap> builder;
            if (options != null) {

                builder = Glide.with(context)
                        .asBitmap()
                        .apply(options);

                if (option != null) {

                    builder.apply(option)
                            .load(res)
                            .into(target);
                } else {
                    Log.e("ImageLoadUtil", "option为空,加载默认options");
                    builder.load(res)
                            .into(target);
                }
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }

    /**
     * 显示头像
     * @param fragment
     * @param res
     * @param option
     * @param target
     */
/*    public static void displayHead(android.support.v4.app.Fragment fragment, Object res, RequestOptions option, SimpleTarget<Bitmap> target){
        if (fragment != null){
            RequestBuilder<Bitmap> builder;
            if (options != null) {

                builder = Glide.with(fragment)
                        .asBitmap()
                        .apply(options);

                if (option != null) {

                    builder.apply(option)
                            .load(res)
                            .into(target);
                } else {
                    Log.e("ImageLoadUtil", "option为空,加载默认options");
                    builder.load(res)
                            .into(target);
                }
            } else {
                Log.e("ImageLoadUtil", "无法加载Glide的默认options,options为空");
            }
        }
    }*/

}
