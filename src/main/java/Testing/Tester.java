package Testing;

import CollectionOfFunctionalMethods.BasicMethods.*;
import CollectionOfFunctionalMethods.BasicMethods.AbnormalScreenshot;
import CollectionOfFunctionalMethods.UseCaseReRunCorrelation.ReTryTimes;
import Com.*;
import CollectionOfFunctionalMethods.DatabaseRelatedMethods.DataBase;
import CollectionOfFunctionalMethods.DatabaseRelatedMethods.DatabaseDataOperation;
import Init.InitDriver;
import macaca.client.MacacaClient;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/10/27.
 */
public class Tester {
    //    static int N;
    //设置一个延迟时长从testng.xml文件中读取的变量
    public int Time;
    public String ProgramPath;

    @Parameters({"TestFilePath", "PlatformName", "TIME", "TestName", "Platform", "ApkName"})
    @Test
    public void tester(String TestFilePath, String PlatformName, int TIME, String TestName, String Platform, String ApkName) throws Exception {

        InitDriver Init = new InitDriver();
        MacacaClient driver = Init.MacacaInit( Platform );//macaca初始化对象,并上传平台名称和
        Execute Execute = new Execute();
        AbnormalScreenshot Abnormal = new AbnormalScreenshot();
        DataBase data = new DataBase();
        DatabaseDataOperation Operation = new DatabaseDataOperation();
        int QueryCount = 0;//统计没有找到元素的次数
        int ElementCount = 1;//代替excle文本序列号
        int RerunTimes ;//重跑次数
        String TestNameToEnglish = null;
        String DosCommand = "taskkill /f /im chrome.exe";//关闭谷歌浏览器进程
        Map <Integer, Integer> MapListCase = new HashMap <Integer, Integer>();//储存没找到元素的序号
        // String FileName= GetLocalConfig.ReadConfigFile();//调用读取配置文件类
        //List<String> KillhromeProcessPidS=new ArrayList<String>();//收集有效pid值
        /*if(FileName.length()!=0)//如果配置文件没有文件名称,则默认testng.xml的Parameters
        {
            TestFilePath="/TestList/"+FileName.trim();//获取配置文件的文件名称
        }*/
        //  GetLocalConfig.clearInfoForFile();
        Time = TIME;
        ProgramPath = URLDecoder.decode( Tester.class.getResource( "" ).toString(), "UTF-8" );//读取类的路径指定编码，防止中文报错
        System.out.println( "TestFilePath全部路劲:" + ProgramPath );
        ProgramPath = StringUtils.substringBefore( ProgramPath, "/target" );
        System.out.println( "TestFilePath前:" + ProgramPath );
        ProgramPath = StringUtils.substringAfter( ProgramPath, "file:/" );
        System.out.println( "TestFilePath后:" + ProgramPath + TestFilePath );//文件读取excel存放的路径
        ReadExcel reade = new ReadExcel();
        List <TestingCase> list = reade.readXlsx( ProgramPath + TestFilePath );
        TestNameToEnglish = ChineseToEnglish.getUpEname( TestName );
        if (!Platform.equals( "Android" ) && !Platform.equals( "wx" )) {
            driver.maximize();
        }
        if (list != null) {
            for (TestingCase testCase : list) {
                //输出读取对应的用例正行内容
                System.out.println( "No." + testCase.getId() + " 操作说明 " + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",获取元素路径:" + testCase.getModePath() + ",文本内容:" + testCase.getText() + "\n" );
                //String Loginstruction = "No." + testCase.getId() + " 操作说明" + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",文本内容:" + testCase.getText() + "\n操作时间: " + GetSystemTime.GetCurrentTime();
               // Reporter.log( Loginstruction );//写入报告步骤说明
                //整行表格数据传入，并对获取的内容进行实质性执行用例
                int ResultNum = Execute.execute( driver, testCase, TIME );//返回元素查找结果
                System.out.println( "元素查找返回结果: " + ResultNum + "\n" );
                String img = ".\\" + TestNameToEnglish + testCase.getDescription() + "jpg";
                String reportimg = "PHOTO" + "..\\..\\" + TestNameToEnglish + testCase.getDescription() + "jpg";//报告内容
                if (ResultNum == 1)//判断元素
                {
                    String Loginstruction = "No." + testCase.getId() + " 操作说明" + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",文本内容:" + testCase.getText() + "\n操作时间: " + GetSystemTime.GetCurrentTime();
                     Reporter.log( Loginstruction );//写入报告步骤说明
                    driver.sleep( 2000 );
                    driver.saveScreenshot( img );
                } else {
                    if (ResultNum == 0) {//元素没有找到,进入判断
                        MapListCase.put( 0, -1 );//设置初始值，不然下面相减会报错
                        QueryCount++;
                        MapListCase.put( QueryCount, ElementCount );//存储没有找到元素的列表信息
                       /* if (list.get( ElementCount - 2 ).getModel().contains( "访问" )) {
                            System.out.println( "我进入了！" );
                            EventListenerMonitoring.Listenerflag = 2;
                        }*/
                      if(MapListCase.get(QueryCount)-MapListCase.get(QueryCount-1)==1)//判断是不是连续操作2次都报错
                        {
                            String Loginstruction = "<p  style=\"font-weight: 900;color:red;font-size:15px\">"+"No." + testCase.getId() + " 操作说明" + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",文本内容:" + testCase.getText() + "\n操作时间: " + GetSystemTime.GetCurrentTime()+"</p>";
                            Reporter.log( Loginstruction );//写入报告步骤说明
                            driver.saveScreenshot(img);
                            Reporter.log(reportimg);//写入报告图片地址
                            //连续2次步骤都报错,会进行断言,并停止程序执行
                            MailDelivery.TCTestCaseMailSending(0);
                            for( RerunTimes=0;RerunTimes < list.size(); RerunTimes++)
                            {
                                if(list.get( RerunTimes ).getText().equals( "重跑" )&list.get( RerunTimes ).getDescription().equalsIgnoreCase( "login" ))
                                {
                                    ReTryTimes.maxReTryNum = ReTryTimes.maxReTryNum+1;
                                    System.out.print( " ReTryTimes.maxReTryNum  = "+  ReTryTimes.maxReTryNum+"\n");
                                    break;
                                }
                            }
                            EventListenerMonitoring.Listenerflag = 2;
                            Runtime.getRuntime().exec("taskkill /f /im chrome.exe");//调用dos命令杀死谷歌进程
                            Assert.assertEquals(ResultNum, 1, "序号 No." + list.get(MapListCase.get(QueryCount-1)).getId() + ", 操作说明：" + list.get(MapListCase.get(QueryCount-1)).getDescription() + "   原因： 连续2个操作找不到元素，有可能是定位错了，或者是流程出现未知的情况！！");
                        }
                        Reporter.log( "<p  style=\"font-weight: 900;color:DarkOrange;font-size:15px\">"+"No." + testCase.getId() + "操作说明" + testCase.getDescription()+"\n操作时间: "+ GetSystemTime.GetCurrentTime()+"</p>");
                        EventListenerMonitoring.Listenerflag = 3;
                        MyAssertion.verifyEquals( ResultNum, 1, "No." + testCase.getId() + " 操作说明：" + testCase.getDescription() + "  没有找到元素！！" + "\n操作时间: " + GetSystemTime.GetCurrentTime() );//捕获assert断言
                        driver.saveScreenshot( img );
                    }
                        else if (ResultNum == 3)//针对数据报表过长,需要增加等待时长,否则截图没有数据
                        {
                            String Loginstruction = "No." + testCase.getId() + " 操作说明" + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",文本内容:" + testCase.getText() + "\n操作时间: " + GetSystemTime.GetCurrentTime();
                            Reporter.log( Loginstruction );//写入报告步骤说明
                            driver.saveScreenshot( img );//结果截图
                            String insertexception3 = Operation.DataToInsert( 0, 0, list.get( 0 ).getModePath(), PlatformName, Integer.parseInt( Execute.Returnbody ), GetSystemTime.GetCurrentTime(), "订单数量统计 !!" );
                            data.InsertDatabaseSql( insertexception3 );
                        } else if (ResultNum == 5)//针对连接超时异常，跳过执行
                        {
                            String Loginstruction = "<p  style=\"color:Yellow\">"+"No." + testCase.getId() + " 操作说明" + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",文本内容:" + testCase.getText() + "\n操作时间: " + GetSystemTime.GetCurrentTime()+"</p>";
                            Reporter.log( Loginstruction );//写入报告步骤说明
                            String insertexception3 = Operation.DataToInsert( 3, 1, list.get( 0 ).getModePath(), PlatformName, 0, GetSystemTime.GetCurrentTime(), "连接超时异常！！" );
                            data.InsertDatabaseSql( insertexception3 );
                            continue;
                        } else {
                        String Loginstruction = "No." + testCase.getId() + " 操作说明" + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",文本内容:" + testCase.getText() + "\n操作时间: " + GetSystemTime.GetCurrentTime();
                        Reporter.log( Loginstruction );//写入报告步骤说明
                            driver.sleep( 2000 );
                            driver.saveScreenshot( img );//结果截图
                        }
                        // Abnormal.WhetherCatchAbnormal(driver,img);//查找异常
                        System.out.println( "图片路基:" + img );
                        int AbnormalStatus = Abnormal.WhetherCatchAbnormal( driver, img );//查找异常
                        if (AbnormalStatus == 1) {
                            String Loginstruction = "<p  style=\"font-weight: 900;color:DarkOrange;font-size:15px \">"+"No." + testCase.getId() + " 操作说明" + testCase.getDescription() + ",操作方法:" + testCase.getModel() + ",获取元素方法:" + testCase.getMode() + ",文本内容:" + testCase.getText() + "\n操作时间: " + GetSystemTime.GetCurrentTime()+"</p>";
                            Reporter.log( Loginstruction );//写入报告步骤说明
                            Reporter.log( reportimg );
                            String insertexception2 = Operation.DataToInsert( 2, 1, list.get( 0 ).getModePath(), PlatformName, 0, GetSystemTime.GetCurrentTime(), "macaca检测平台有异常,联系对应项目经理!!!" );
                            data.InsertDatabaseSql( insertexception2 );
                            EventListenerMonitoring.Listenerflag = 2;
                            Assert.assertEquals( " do abnormal", "no abnormal ", "macaca检测平台有异常,联系对应项目经理!!!" + "\n" );
                        }
                    }
                    Reporter.log( reportimg );//写入报告图片地址
                    ElementCount++;
                }
            }
            System.out.println( "我想要退出！" );
            //  System.out.println("删除?"+KillhromeProcessPidS.get(0)+"\n");
            // Runtime.getRuntime().exec("taskkill /f /im  "+Init.ChromeProcessPidS.get(0));//调用dos命令杀死谷歌进程
            //Runtime.getRuntime().exec("taskkill /f /im chromedriver2.33.exe");//调用dos命令杀死谷歌driver进程

        }
    }
