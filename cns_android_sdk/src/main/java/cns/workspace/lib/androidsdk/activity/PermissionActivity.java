package cns.workspace.lib.androidsdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by liyuhao on 2017/6/5.
 * 使用事项，权限是按照权限组来授权的，所以申请权限时，尽量不要同时申请同一权限组的权限，比如
 * WRITE_EXTERNAL_STORAGE和READ_EXTERNAL_STORAGE，只要申请其中一个权限，整个group.STORAGE都会被赋予权限
 * <p>
 * 不同权限需求种类，不要在同一个权限组里发起申请，因为code你一次只能传1种，4种需求种类对应4种应用场景，所以
 * 不要尝试使用一套逻辑来同时兼容4种模式，应该是不现实的。
 * <p>
 * 不要去判断hasPermission()为false的情况，因为会自动申请权限，false的返回是没有意义的
 */

public class PermissionActivity extends AppCompatActivity {
    //必须被允许，且自动执行授权后方法
    public static final int REQUIRED_LOAD_METHOD = 1;
    //必须被允许，只进行申请权限，不自动执行授权后方法
    public static final int REQUIRED_ONLY_REQUEST = 2;
    //可以被禁止，且自动执行授权后方法
    public static final int NOT_REQUIRED_LOAD_METHOD = 3;
    //可以被禁止，只进行申请权限，不自动执行授权后方法
    public static final int NOT_REQUIRED_ONLY_REQUEST = 4;

    private static final String PACKAGE_URL_SCHEME = "package:";

    //被永久拒绝之后显示的dialog
    private AlertDialog.Builder builder;

    private boolean loadMethodFlag;//是否自动加载方法

    private static HashMap<String,String> permissionList;

    static {
        permissionList = new HashMap<>();
        permissionList.put("android.permission.READ_CALENDAR","日历");
        permissionList.put("android.permission.WRITE_CALENDAR","日历");
        permissionList.put("android.permission.CAMERA","相机");
        permissionList.put("android.permission.READ_CONTACTS","联系人");
        permissionList.put("android.permission.WRITE_CONTACTS","联系人");
        permissionList.put("android.permission.GET_ACCOUNTS","联系人");
        permissionList.put("android.permission.ACCESS_FINE_LOCATION","定位");
        permissionList.put("android.permission.ACCESS_COARSE_LOCATION","定位");
        permissionList.put("android.permission.RECORD_AUDIO","录音");
        permissionList.put("android.permission.READ_PHONE_STATE","手机状态");
        permissionList.put("android.permission.CALL_PHONE","手机状态");
        permissionList.put("android.permission.READ_CALL_LOG","手机状态");
        permissionList.put("android.permission.WRITE_CALL_LOG","手机状态");
        permissionList.put("android.permission.ADD_VOICEMAIL","手机状态");
        permissionList.put("android.permission.USE_SIP","手机状态");
        permissionList.put("android.permission.PROCESS_OUTGOING_CALLS","手机状态");
        permissionList.put("android.permission.BODY_SENSORS","传感器");
        permissionList.put("android.permission.SEND_SMS","短信");
        permissionList.put("android.permission.RECEIVE_SMS","短信");
        permissionList.put("android.permission.READ_SMS","短信");
        permissionList.put("android.permission.RECEIVE_WAP_PUSH","短信");
        permissionList.put("android.permission.RECEIVE_MMS","短信");
        permissionList.put("android.permission.READ_EXTERNAL_STORAGE","存储读写");
        permissionList.put("android.permission.WRITE_EXTERNAL_STORAGE","存储读写");

    }


    /**
     * 判断是否拥有权限
     * 有权限返回true，没有权限返回false并自动申请权限
     *
     * @param permissions 不定长数组
     * @return 是否有权限，一般调用不判断返回否的操作
     */
    public boolean hasPermission(int code, String... permissions) {
        List<String> realMissPermission = new ArrayList<>();
        boolean flag = true;
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                realMissPermission.add(permission);
                flag = false;
            }
        }
        if (realMissPermission.size() > 0) {
            String[] missPermissions = realMissPermission.toArray(new String[realMissPermission.size()]);
            requestPermission(code, missPermissions);
        }
        return flag;
    }

    /**
     * 请求权限
     *
     * @param code        请求码
     * @param permissions 权限列表
     */
    private void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean permissionFlag = true;//权限是否全部通过
        boolean dialogFlag = false;//是否显示设置dialog
        boolean requiredFlag = false;//是否为项目必须的权限
        ArrayList<String> per = new ArrayList<>();//保存被拒绝的权限列表
        initMissingPermissionDialog();
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                //存在被拒绝的权限
                per.add(permissions[i]);
                permissionFlag = false;
            }
        }
        switch (requestCode) {
            case REQUIRED_LOAD_METHOD:
                loadMethodFlag = true;
                requiredFlag = true;
                break;
            case REQUIRED_ONLY_REQUEST:
                loadMethodFlag = false;
                requiredFlag = true;
                break;
            case NOT_REQUIRED_LOAD_METHOD:
                loadMethodFlag = true;
                requiredFlag = false;
                break;
            case NOT_REQUIRED_ONLY_REQUEST:
                loadMethodFlag = false;
                requiredFlag = false;
                break;
        }
        List<String> names = selectGroup(per);//判断被拒绝的权限组名称

        if (permissionFlag) {
            //通过了申请的权限
            if (loadMethodFlag){
                doAfterPermission();//权限通过，执行对应方法
            }
        }else {
            if (requiredFlag) {
                if (per.size() > 0) {//严谨判断大于0
                    for (String permission : per) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                            //当前权限被设置了"不在询问",永远不会弹出进入这里，将dialog显示标志设为true
                            dialogFlag = true;
                        }
                    }
                    if (dialogFlag) {
                        //显示缺少权限，并解释为何需要这个权限
                        showMissingPermissionDialog(names);
                    }else {
                        if (loadMethodFlag){
                            rejectAfterPermission();
                        }
                    }
                }
            }else {
                Log.e("Permission:","Permission had been rejected");
                if (loadMethodFlag){
                    rejectAfterPermission();
                }
            }
        }
    }

    /**
     * 给子类提供重写的成功接口
     */
    public void doAfterPermission() {
    }

    /**
     * 给子类提供重写的失败接口
     */
    public void rejectAfterPermission() {
    }


    private void initMissingPermissionDialog() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("帮助");

        // 拒绝, 退出应用
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (loadMethodFlag){
                    rejectAfterPermission();
                }
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (loadMethodFlag){
                    rejectAfterPermission();
                }
            }
        });

        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //跳转到，设置的对应界面
                startAppSettings();
            }
        });

    }

    /**
     * 显示解释设置dialog
     *
     * @param names 权限组名
     */
    private void showMissingPermissionDialog(List<String> names) {
        String content = "";
        //将权限组名字转换为字符串
        if (names.size() > 0) {
            for (String name : names) {
                content = content + name + "\n";
            }
        }
        builder.setMessage("当前应用缺少必要权限:\n" + content + "请点击\"设置\"-\"权限\"-打开所需权限。");
        builder.show();
    }

    /**
     * 启动应用的设置
     */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + getPackageName()));
        startActivity(intent);
    }

    /**
     * 将权限，对应到权限组名，并去重
     *
     * @param permissions 权限名
     * @return 权限组名
     */
    private List<String> selectGroup(List<String> permissions) {
        List<String> group = new ArrayList<>();
        //匹配权限表
        /*for (String permission : permissions) {
            if (permission.equals(Manifest.permission.READ_CALENDAR) ||
                    permission.equals(Manifest.permission.WRITE_CALENDAR)) {
                group.add("日历");
            } else if (permission.equals(Manifest.permission.CAMERA)) {
                group.add("相机");
            } else if (permission.equals(Manifest.permission.READ_CONTACTS) ||
                    permission.equals(Manifest.permission.WRITE_CONTACTS) ||
                    permission.equals(Manifest.permission.GET_ACCOUNTS)) {
                group.add("联系人");
            } else if (permission.equals(Manifest.permission.ACCESS_FINE_LOCATION) ||
                    permission.equals(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                group.add("定位");
            } else if (permission.equals(Manifest.permission.RECORD_AUDIO)) {
                group.add("录音");
            } else if (permission.equals(Manifest.permission.READ_PHONE_STATE) ||
                    permission.equals(Manifest.permission.CALL_PHONE) ||
                    permission.equals(Manifest.permission.READ_CALL_LOG) ||
                    permission.equals(Manifest.permission.WRITE_CALL_LOG) ||
                    permission.equals(Manifest.permission.ADD_VOICEMAIL) ||
                    permission.equals(Manifest.permission.USE_SIP) ||
                    permission.equals(Manifest.permission.PROCESS_OUTGOING_CALLS)) {
                group.add("手机状态");
            } else if (permission.equals(Manifest.permission.BODY_SENSORS)) {
                group.add("传感器");
            } else if (permission.equals(Manifest.permission.SEND_SMS) ||
                    permission.equals(Manifest.permission.RECEIVE_SMS) ||
                    permission.equals(Manifest.permission.READ_SMS) ||
                    permission.equals(Manifest.permission.RECEIVE_WAP_PUSH) ||
                    permission.equals(Manifest.permission.RECEIVE_MMS)) {
                group.add("短信");
            } else if (permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE) ||
                    permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                group.add("存储读写");
            }
        }*/
        for (String permission : permissions) {
            if (permissionList != null){
                group.add(permissionList.get(permission));
            }
        }



        //去重
        group = new ArrayList<>(new HashSet<>(group));
        return group;
    }
}