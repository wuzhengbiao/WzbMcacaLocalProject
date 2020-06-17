package Testing;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import macaca.client.MacacaClient;
import java.io.File;
import java.io.IOException;
import java.util.List;
import macaca.client.commands.Element;
import static org.hamcrest.CoreMatchers.containsString;
public class AndroidSampleTest {
    MacacaClient driver = new MacacaClient();
    // set screenshot save path
    File directory = new File("");
    public String courseFile = directory.getCanonicalPath();

    public AndroidSampleTest() throws IOException {
    }
    @Before
    public void setUp() throws Exception {
        // platform: android or ios
        String platform = "Android";
        JSONObject porps = new JSONObject();
        porps.put("platformName", platform);
        porps.put("app", "D:\\android_app_bootstrap-debug.apk");
        porps.put("reuse", 1);
        // device id
        porps.put("deviceName","127.0.0.1:62001");
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", porps);
        driver.initDriver(desiredCapabilities);
    }
    @Test
    public void testCaseOne() throws Exception {

        System.out.println("------------#1 login test-------------------");
        loginTest();

        System.out.println("------------#2 scroll tableview test-------------------");
        scrollTableViewTest();

        System.out.println("------------#3 webview test-------------------");
        webViewTest();

        System.out.println("------------#4 baidu web test-------------------");
        baiduWebTest();

        System.out.println("------------#5 logout test-------------------");
        logoutTest();
    }
    public void loginTest() throws Exception {
        driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.EditText[1]")
                .sendKeys("中文+Test+12345678");
        driver.elementById("com.github.android_app_bootstrap:id/codeEditText")
                .sendKeys("111111");
        driver.elementByXPath("\n" +
                "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[1]").click();
        driver.sleep(1000);
    }

    public void scrollTableViewTest() throws Exception {
        driver.elementByName("HOME").click();
        driver.elementByName("list").click();
        driver.sleep(1000);
        driver.drag(200, 420, 200, 10, 0.05);
        driver.sleep(5000);

        // 拖拽一个元素或者在多个坐标之间移动,实现tableview滚动操作
        driver.drag(200, 420, 200, 20, 0.05);
        driver.sleep(1000);
        driver.back();
        driver.sleep(1000);
    }

    public void webViewTest() throws Exception {
        driver.elementByName("Webview").click();
        driver.sleep(3000);
        // save screen shot
        driver.saveScreenshot(courseFile + "/webView.png");

        switchToWebView(driver).elementByXPath("\n" +
                "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[3]/android.widget.Button[1]").click();
        driver.sleep(5000);

        switchToWebView(driver).elementByXPath("\n" +
                "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[4]/android.widget.Button[1]").click();
        driver.sleep(5000);
    }

    public void baiduWebTest() throws Exception {
        switchToNative(driver).elementByName("Baidu").click();
        driver.sleep(5000);
        driver.saveScreenshot(courseFile + "/baidu.png");

//        switchToWebView(driver).elementById("index-kw").sendKeys("中文+TesterHome");

        Element input = switchToWebView(driver).elementById("index-kw");
        input.sendKeys("中文+TesterHome");
        driver.sleep(1000);

        // 测试清理API
        input.clearText();
        driver.sleep(1000);

        // 重新输入
        input.sendKeys("中文+TesterHome");
        driver.sleep(1000);

        driver.elementById("index-bn").click();
        driver.sleep(5000);
        String source = driver.source();
        Assert.assertThat(source, containsString("TesterHome"));
    }
    public void logoutTest() throws  Exception {
        switchToNative(driver).elementByName("PERSONAL").click();
        driver.sleep(1000).elementByName("Logout").click();
        driver.sleep(1000);
    }
    // switch to the context of the last pushed webview
    public MacacaClient switchToWebView(MacacaClient driver) throws Exception {
        JSONArray contexts = driver.contexts();
        return driver.context(contexts.get(contexts.size() - 1).toString());
    }
    // switch to the context of native
    public MacacaClient switchToNative(MacacaClient driver) throws Exception {
        JSONArray contexts = driver.contexts();
        return driver.context(contexts.get(0).toString());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

