package Init;
import CollectionOfFunctionalMethods.BasicMethods.AssertionListener;
import CollectionOfFunctionalMethods.BasicMethods.DosCommand;
import com.alibaba.fastjson.JSONObject;
import macaca.client.MacacaClient;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/10/27.
 */
public class InitDriver {
    public List<String> ChromeProcessPidS=new ArrayList<String>();
    //处理来自testng.xml的文件夹路径(testExcelPath)参数，并传入文件
    protected MacacaClient driver ;
    public  String  KillhromeProcessPidS;
    public  String  udid="127.0.0.1:62001";
    public  InitDriver()
    {
        driver=new MacacaClient();
    }
    public MacacaClient MacacaInit(String Platform,String ApkName) throws Exception {//有上传apk名称的代码
        JSONObject jsono = new JSONObject();
        String apkpath = System.getProperty("user.dir")+"\\Upfile\\"+ApkName;//获取apk存放地址
        System.out.print("apk地址:"+apkpath+"\n");
        if(Platform.equals("Android")||Platform.equals("wx")) {//判断是否是安卓app还是微信
            DosCommand adbdevicecheck=new DosCommand();
            String  adbresult=adbdevicecheck.RunDosCommand("adb devices").toString();//查找设备号
            if (Platform.equals("Android")) {
                jsono.put("platformName", "Android");
                jsono.put("app", apkpath);
                jsono.put("reuse", 2);//0: 启动并安装 app。{1 (默认): 卸载并重装 app。 2: 仅重装 app。3: 在测试结束后保持 app 状态。}
                jsono.put("udid", udid);//设备号
                jsono.put("deviceName", "夜神");
                jsono.put("activity", ".ui.LauncherUI");//Activity name for the Android activity you want to launch from your package.
                // jsono.put("androidProcess", "com.tencent.mm:appbrand0");//被测小程序所在第几个-1
                if (!adbresult.contains(udid))//判断是否开启夜神模拟器,没有就断言
                {
                    Assert.assertEquals(adbresult, udid, "未找到模拟器设备号： " + udid + " ,请确认是否已经开启！");
                }
            }
            else if (Platform.equals("wx")) {
                    jsono.put("autoDismissAlerts ", true);//自动接受所有的系统弹窗信息。默认是 false :只支持ios
                    jsono.put("deviceName", "夜神");
                    jsono.put("udid", udid);
                    jsono.put("platformName", "android");
                    jsono.put("reuse", 2);//0: 启动并安装 app。{1 (默认): 卸载并重装 app。 2: 仅重装 app。3: 在测试结束后保持 app 状态。}
                    jsono.put("package", "com.tencent.mm");
                    //jsono.put("androidProcess", "com.tencent.mm:tools");//使用 chromedriver 测试 webview 时需要的自定义的进程名。
                    jsono.put("activity", ".ui.LauncherUI");//Activity name for the Android activity you want to launch from your package.
                    jsono.put("isWaitActivity",true);
                }
            }
		else{
            jsono.put("browserName", "chrome");
            jsono.put("platformName", "desktop");
			jsono.put("port",Integer.parseInt(AssertionListener.port));
        }
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", jsono);
        driver.initDriver(desiredCapabilities);
        return driver;
    }
    public MacacaClient MacacaInit(String Platform) throws Exception {//不传apk名称的代码
        JSONObject jsono = new JSONObject();
        if(Platform.equals("wx")) {//判断是否是安卓app还是微信
            DosCommand adbdevicecheck=new DosCommand();
            String  adbresult=adbdevicecheck.RunDosCommand("adb devices").toString();//查找设备号
            if (!adbresult.contains(udid))//判断是否开启夜神模拟器,没有就断言
                {
                    Assert.assertEquals(adbresult, udid, "未找到模拟器设备号： " + udid + " ,请确认是否已经开启！");
                }
                //jsono.put("autoDismissAlerts ", true);//自动接受所有的系统弹窗信息。默认是 false :只支持ios
                jsono.put("deviceName", "夜神");
                jsono.put("udid", udid);
                jsono.put("platformName", "android");
                jsono.put("reuse", 2);//0: 启动并安装 app。{1 (默认): 卸载并重装 app。 2: 仅重装 app。3: 在测试结束后保持 app 状态。}
                jsono.put("package", "com.tencent.mm");
                jsono.put("isWaitActivity",true);//Wait the app's main acitivity. Default is true
                jsono.put("androidProcess", "com.tencent.mm:tools");//Process name for the chromedriver binding when test webview
                jsono.put("activity", ".ui.LauncherUI");//Activity name for the Android activity you want to launch from your package.
                //jsono.put("androidProcess", "com.tencent.mm:tools");//被测小程序所在第几个
        }
        else{
            jsono.put("browserName", "chrome");
            jsono.put("platformName", "desktop");
			jsono.put("port",Integer.parseInt(AssertionListener.port));
        }
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", jsono);
        driver.initDriver(desiredCapabilities);
        //ChromeProcessPidS=QueryProcessID.GetChromeProcessPID();
        return driver;
    }

}
