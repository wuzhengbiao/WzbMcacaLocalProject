package Testing;

import CollectionOfFunctionalMethods.BasicMethods.ChineseToEnglish;
import CollectionOfFunctionalMethods.BasicMethods.GetRandom;
import CollectionOfFunctionalMethods.BasicMethods.SpecifyLengthWrap;
import CollectionOfFunctionalMethods.HtmlOperation.GenerateHtml;
import CollectionOfFunctionalMethods.HttpAndHttpsProtocol.HttpRequestMethod;

import CollectionOfFunctionalMethods.DatabaseRelatedMethods.DataBase;
import CollectionOfFunctionalMethods.DatabaseRelatedMethods.DatabaseDataOperation;
import CollectionOfFunctionalMethods.HttpAndHttpsProtocol.HttpsRequest;
import CollectionOfFunctionalMethods.ReportDataStatistics.ColumnChartStatistics;
import CollectionOfFunctionalMethods.ReportDataStatistics.LimeSeriesChartStatistics;
import CollectionOfFunctionalMethods.ReportDataStatistics.PieChartStatistics;
import Com.ReportRW;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testmian {
    public static void main(String[] args) throws Exception{
     //   String code=SessionListener.HttpGet("http://hbpxgl.59iedu.com/web/openapi/skill/getCode?usrId=2c9080986aec8fff016af316b36e459e");
     //   String appadncode=SessionListener.HttpGet("http://hbpxgl.59iedu.com/web/openapi/access_token?appid=hq4u7HzDIqjn7JA&secret=An3Z79nn1Y8ky08mZvF4RmtXE5ug&code="+code+"&grant_type=authorization_code");
      //  StringSubByContent.ReplaceByContentLBorRB("http://hbpxgl.59iedu.com/web/openapi/zkzj/findUserInfo?access_token=yyiAI7ordsWEVEhDxPHpYiXrq69n1A&openid=IkDjpuIwUZMKSZuMt17c1lDfmwG1MVN7空","&openid=","空","*************",1);
    //    String openid=StringSubByContent.SubByContentLBorRB("{\"message\":\"success\",\"data\":{\"openid\":\"IkDjpuIwUZMKSZuMt17c1lDfmwG1MVN7\",\"refresh_token\":\"w6U57FNzd1wY2wc1n92CqmquWT4ePm\",\"expires_in\":7199,\"access_token\":\"bFQTXXDVGogGQiCubQBGLq8ItuJtQS\"},\"code\":2000}","\"openid\":\"","\",\"refresh_token\":\"",1);
    //    String access_token=StringSubByContent.SubByContentLBorRB(appadncode,"\"access_token\":\"","\"},\"code\":",1);
     //   String num=SessionListener.HttpGet("http://hbpxgl.59iedu.com/web/openapi/zkzj/findUserInfo?access_token="+access_token+"&openid="+openid);

        //   QueryProcessID.GetChromeProcessPID();

      /*  DosCommand dos=new DosCommand();
        String name =ChineseToEnglish.getUpEname("酒泉周口.xlsx");
        System.out.println("中文:"+name+"\n");
        String filename = GetLocalConfig.ReadConfigFile();
        String[] Contentx=GetLocalConfig.GetBySemicolonFromConfigFile(filename);
        for(int i=0;i<Contentx.length;i++)
        {
            System.out.println("获取内容:"+Contentx[i].trim()+"\n");
        }
       // RewriteXml.CreateTestngXml(Contentx); // java修改xml
        GetLocalConfig.clearInfoForFile();
       QueryMacacaSeverPort.GetMacacaServerPort();
       MailDelivery.TCTestCaseMailSending(1);
        System.out.println("获取当地时间值:"+GetSystemTime.GetCurrentTime()+"\n");
        System.out.println(dos.RunDosCommand("adb devices"));
        AssertionListener listen=new AssertionListener();
        LookForphoto photo=new LookForphoto();
        String ProgramPath;
        ProgramPath = System.getProperty("user.dir");//获取用户的当前工作目录
        String filepath=ProgramPath+"\\Upfile";
        String []geshi={".png",".jpg",".img",".jpeg"};
        String []exe={".exe"};
        MyAssertion.verifyEquals(4, 3, "比较两个数是否相等：");*/
      /*  List<String> list=photo.getPictures(filepath,geshi);
        List<String>  programpath=photo.getPictures(filepath,exe);*/
               // System.out.println("图片地址:" + list.get(0)+"\n"+list.get(1));
               // System.out.println("exe地址:" + programpath.get(0));
               // String[] cmd={programpath.get(0),list.get(0)};
    /*    DataBase data=new DataBase();
        List mylist = new ArrayList();
        mylist=data.QueryDatabaseSql( "select CREATEIME from platform_exception_informatin_table WHERE PLATFORM_EXCEPTION_INFORMATIN like \"%订单%\"" );
     */ /*  for(int i=0;i<mylist.size();i++)
        {
            System.out.println("获取内容:"+mylist.get( i )+"\n");
        }*/
     //      JFrame frame=new JFrame("数据统计图");
    //    frame.setLayout(new GridLayout(1,1,20,2));
      // frame.add(new ColumnChartStatistics("柱形图","日期2020年","订单数量").getChartPanel());           //添加柱形图
      //  frame.add(new PieChartStatistics().getChartPanel());//添加饼图
    //   frame.add(new LimeSeriesChartStatistics().getChartPanel());//添加折线图
   //     frame.setBounds(50, 50, 1800, 800);
   //     frame.setVisible(true);
     /*   mylist= GetRandom.randomArr("10");
        for(int i=0;i<10;i++)
        {
            System.out.print( "随机数= "+ mylist.get( i )+"\n");
        }
        DatabaseDataOperation Operation=new DatabaseDataOperation();*/
     /*   String url = "http://authv1.test1.59iedu.com:1457/web/captcha/sc/validate/hyCGxcHsGQhUAEqRugiLtUYUhqOzhzKv/bdyu";
        String url2 = "http://authv1.test1.59iedu.com:1457/web/captcha/sc/apply";
        String  file="suite1_test2_results.html";
        Object [] params = new Object[]{"",""};
        Object [] values = new Object[]{"",""};
        HttpRequestMethod  http=new  HttpRequestMethod();
        List <org.apache.http.NameValuePair> paramsList = HttpRequestMethod.GetParams(params,values);*/
        //Object result = http.SendGetNullBody(url2,"Basic eyJhcHBFbmQiOiJXZWIiLCJhcHBJZCI6InRlbXBfYXBwX2lkIiwicGxhdGZvcm1JZCI6IjA3NTQwZDc3Y3AyMTQ2M2I5NDk4MmM4NDU2anNrcTAyIiwicGxhdGZvcm1WZXJzaW9uSWQiOiJjcDk1YmM0NzIxNDc0MTAwODA4YmNhNTg4Mmpza3EwMiIsInByb2plY3RJZCI6IjQwMjg5Njc4NmU0NDlmMzkwMTZlNDQ5ZjIwMjAwMjA2Iiwic3ViUHJvamVjdElkIjoiNDAyODk2Nzg2ZTQ0OWYzOTAxNmU0NDlmMjAyMDBzdWIifQ==","application/json");
     //   Object result1 = http.SendGet(url,paramsList,"application/json","Basic eyJhcHBFbmQiOiJXZWIiLCJhcHBJZCI6InRlbXBfYXBwX2lkIiwicGxhdGZvcm1JZCI6IjA3NTQwZDc3Y3AyMTQ2M2I5NDk4MmM4NDU2anNrcTAyIiwicGxhdGZvcm1WZXJzaW9uSWQiOiJjcDk1YmM0NzIxNDc0MTAwODA4YmNhNTg4Mmpza3EwMiIsInByb2plY3RJZCI6IjQwMjg5Njc4NmU0NDlmMzkwMTZlNDQ5ZjIwMjAwMjA2Iiwic3ViUHJvamVjdElkIjoiNDAyODk2Nzg2ZTQ0OWYzOTAxNmU0NDlmMjAyMDBzdWIifQ==");
       // Object result13 = http.SendGet(url,paramsList,"application/json","Basic eyJhcHBFbmQiOiJXZWIiLCJhcHBJZCI6InRlbXBfYXBwX2lkIiwicGxhdGZvcm1JZCI6IjA3NTQwZDc3Y3AyMTQ2M2I5NDk4MmM4NDU2anNrcTAyIiwicGxhdGZvcm1WZXJzaW9uSWQiOiJjcDk1YmM0NzIxNDc0MTAwODA4YmNhNTg4Mmpza3EwMiIsInByb2plY3RJZCI6IjQwMjg5Njc4NmU0NDlmMzkwMTZlNDQ5ZjIwMjAwMjA2Iiwic3ViUHJvamVjdElkIjoiNDAyODk2Nzg2ZTQ0OWYzOTAxNmU0NDlmMjAyMDBzdWIifQ==");

        //      Object result = HttpRequestMethod.SendPostString(url,"{\"query\":\"query getNamespaceProperties {\\n\\tingress: getNamespaceProperties(namespace: \\\"ingress\\\") {\\n\\t\\t_ALL_\\n\\t}\\n\\tapplication: getNamespaceProperties(namespace: \\\"application\\\") {\\n\\t\\t_ALL_\\n\\t}\\n}\\n\"}","Basic eyJhcHBFbmQiOiJXZWIiLCJhcHBJZCI6InRlbXBfYXBwX2lkIiwicGxhdGZvcm1JZCI6IjA3NTQwZDc3Y3AyMTQ2M2I5NDk4MmM4NDU2anNrcTAyIiwicGxhdGZvcm1WZXJzaW9uSWQiOiJjcDk1YmM0NzIxNDc0MTAwODA4YmNhNTg4Mmpza3EwMiIsInByb2plY3RJZCI6IjQwMjg5Njc4NmU0NDlmMzkwMTZlNDQ5ZjIwMjAwMjA2Iiwic3ViUHJvamVjdElkIjoiNDAyODk2Nzg2ZTQ0OWYzOTAxNmU0NDlmMjAyMDBzdWIifQ==","application/json");
   //     GenerateHtml.HtmlSuiteTest(url,result,"D:\\macaca\\AutoTest6.0SYS\\test-output\\html\\"+file);
   //     GenerateHtml.HtmlSuites( file,"D:\\macaca\\AutoTest6.0SYS\\test-output\\html\\suitesnew.html" );
      //  Object result = HttpRequestMethod.SendPostJosn(url,paramsList,"application/x-www-form-urlencoded");
      //  Object result = HttpRequestMethod.SendPostJosn(url,paramsList,"application/x-www-form-urlencoded");
    //    Object result = HttpRequestMethod.SendPostString(url,"{\"query\":\"query getNamespaceProperties {\\n\\tingress: getNamespaceProperties(namespace: \\\"ingress\\\") {\\n\\t\\t_ALL_\\n\\t}\\n\\tapplication: getNamespaceProperties(namespace: \\\"application\\\") {\\n\\t\\t_ALL_\\n\\t}\\n}\\n\"}","Basic eyJhcHBFbmQiOiJXZWIiLCJhcHBJZCI6InRlbXBfYXBwX2lkIiwicGxhdGZvcm1JZCI6IjA3NTQwZDc3Y3AyMTQ2M2I5NDk4MmM4NDU2anNrcTAyIiwicGxhdGZvcm1WZXJzaW9uSWQiOiJjcDk1YmM0NzIxNDc0MTAwODA4YmNhNTg4Mmpza3EwMiIsInByb2plY3RJZCI6IjQwMjg5Njc4NmU0NDlmMzkwMTZlNDQ5ZjIwMjAwMjA2Iiwic3ViUHJvamVjdElkIjoiNDAyODk2Nzg2ZTQ0OWYzOTAxNmU0NDlmMjAyMDBzdWIifQ==","application/json");
       // Object result = HttpRequestMethod.SendGet(  )
        //   Object result2 = HttpsRequest.SendPosts(url,"{\"oldPassword\":\"a000000\",\"newPassword\":\"a000000\"}","application/json");
   //     HttpsRequest.SendGetS(url,paramsList,"application/x-www-form-urlencoded");
  //      Map<String,String> body = new HashMap();
    //    Map<String,String> head = new HashMap();
   //    head.put("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
      //  head.put("Cookie","UM_distinctid=1709a47f53025-0e0becc134062c-7d7f582e-1aeaa0-1709a47f5340; _365groups_ClientID=303e107d-c9c8-4ead-9ac2-ea1758043295; JSESSIONID=3B47ECF17F3E295FE0D9E0E63EC7F029; CNZZDATA1277847727=1665138348-1583137760-%7C1583205146; CNZZDATA1277798915=1225623638-1583137760-%7C1583205146; CNZZDATA1277770963=593321419-1583137760-%7C1583204718; CNZZDATA5050436=cnzz_eid%3D1780039011-1583137765-%26ntime%3D1583203896; CNZZDATA1275252214=1658703381-1583137761-%7C1583204718; CNZZDATA1278633549=328330417-1583137761-%7C1583204719; CNZZDATA1275252232=884317419-1583137761-%7C1583204719; CNZZDATA1277630991=409553754-1583137761-%7C1583204719; CNZZDATA1277728465=60047543-1583137761-%7C1583204723; CNZZDATA1277927541=465735897-1583137766-%7C1583204724; CNZZDATA1278071052=1861440965-1583137766-%7C1583204724; CNZZDATA1278093475=1203266117-1583137766-%7C1583204772; CNZZDATA1278115773=396157994-1583137767-%7C1583204772; CNZZDATA1278115792=1921177604-1583137762-%7C1583205135; CNZZDATA1277703440=997813448-1583137762-%7C1583205147; CNZZDATA1278560370=293141770-1583137762-%7C1583205147; CNZZDATA1278560381=1862106588-1583137762-%7C1583205147; CNZZDATA1278560397=1402237445-1583137767-%7C1583205147; CNZZDATA1278585135=921151821-1583137766-%7C1583205147");
       // head.put("Accept","application/json, text/plain, */*");
       /* body.put("oldPassword","a000000");
        body.put("newPassword","a000000");*/

    //  HttpRequestPost.HttpPostMap(url,head,body);
    //     SessionListener session=new SessionListener();
    String str="";
      String str3="";
        ReportRW RW=new ReportRW();
        //session.httpTimeout("http://scjsnewtest1.fjchjlan.59iedu.com:1457/web/login/login/getLoginParameters.action?_q=1516609437040","GET");
        str=RW.ReportReadModify("D:/macaca/AutoTest6.0SYS/test-output/html/suite1_test1_results.html");
        RW.ReportWrite("D:/macaca/AutoTest6.0SYS/test-output/html/suite1_test1_results.html",str);
       String str2=RW.ReportReadModify("D:/质控部macaca/test-output/html/suite1_test1_results.html");
        RW.ReportWrite("D:/质控部macaca/test-output/html/suite1_test1_results.html",str2);
        str3=RW.ReportReadModify("D:/macaca/AutoTest6.0SYS/test-output/html/suite1_test1_results.html");
        RW.ReportWrite("D:/macaca/AutoTest6.0SYS/test-output/html/suite1_test1_results.html",str3);
        String str4=RW.ReportReadModify("D:/质控部macaca/test-output/html/suite1_test1_results.html");
        RW.ReportWrite("D:/质控部macaca/test-output/html/suite1_test1_results.html",str4);
    /* String   string =SpecifyLengthWrap.getStringByEnter(100,"{\"code\":200,\"data\":{\"ingress\":[{\"key\":\"ingress.sso\",\"value\":\"http://ssov1.test1.59iedu.com:1457\"},{\"key\":\"ingress.bill\",\"value\":\"http://billv1.test1.59iedu.com:1457\"},{\"key\":\"ingress.appsso\",\"value\":\"http://ssov1.test1.59iedu.com:1457\"},{\"key\":\"ingress.anticheat\",\"value\":\"http://anticheatv1.test1.59iedu.com:1457\"},{\"key\":\"ingress.study\",\"value\":\"http://studyv2.test1.59iedu.com:1457\"},{\"key\":\"ingress.auth\",\"value\":\"http://authv1.test1.59iedu.com:1457\"},{\"key\":\"ingress.exam\",\"value\":\"http://examv1.test1.59iedu.com:1457\"},{\"key\":\"ingress.cert\",\"value\":\"http://certv1.test1.59iedu.com:1457\"},{\"key\":\"ingress.payment\",\"value\":\"http://paymentv1.test1.59iedu.com:1457\"},{\"key\":\"ingress.oprman\",\"value\":\"http://oprmanv2.test1.59iedu.com:1457\"},{\"key\":\"ingress.resource\",\"value\":\"http://resourcev1.test1.59iedu.com:1457\"}],\"application\":[{\"key\":\"applicationDiff.BasicData.tempCollectiveAdminRoleId\",\"value\":\"\"},{\"key\":\"application.CommoditySku.categoryId\",\"value\":\"ea1dea9f62ae11ea980314187732ebee\"},{\"key\":\"applicationDiff.BasicData.tempTeacherRoleId\",\"value\":\"\"},{\"key\":\"applicationDiff.CourseLearning.listenTime\",\"value\":\"300\"},{\"key\":\"application.userJob.schedulerName\",\"value\":\"fjhb.jskqcp-userJob-scheduler\"},{\"key\":\"applicationDiff.Course.restAsPeriod\",\"value\":\"10\"},{\"key\":\"applicationDiff.Bill.isProvideInvoice\",\"value\":\"0\"},{\"key\":\"applicationDiff.BasicData.normalStudentRoleId\",\"value\":\"40289979626a29751233021fc8490909\"},{\"key\":\"applicationDiff.ConfigCenter.regexWhites\",\"value\":\"\"},{\"key\":\"hikari.proxy.poolName\",\"value\":\"proxysql\"},{\"key\":\"applicationDiff.Course.onePeriodRequireMinutes\",\"value\":\"45\"},{\"key\":\"application.resourcesPrefix\",\"value\":\"/mfs\"},{\"key\":\" applicationDiff.Bill.autoBillingAfterDayNumber\",\"value\":\"7\"},{\"key\":\"applicationDiff.Bill.billingFormType\",\"value\":\"2\"},{\"key\":\"application.quartz.database\",\"value\":\"platform_jskqcp\"},{\"key\":\"applicationDiff.Course.remainderAsOnePeriodMinutes\",\"value\":\"30\"},{\"key\":\"mongodb.database\",\"value\":\"platform_jskqcp\"},{\"key\":\"applicationDiff.Bill.autoBillingAfterDayNumber\",\"value\":\"7\"},{\"key\":\"applicationDiff.BasicData.normalTeacherRoleId\",\"value\":\"\"},{\"key\":\"mysql.proxy.database\",\"value\":\"platform_jskqcp\"},{\"key\":\"applicationDiff.CourseLearning.mode\",\"value\":\"1\"},{\"key\":\"application.platformId\",\"value\":\"07540d77cp21463b94982c8456jskq02\"},{\"key\":\"application.Order.autoCloseTime\",\"value\":\"2880\"},{\"key\":\"applicationDiff.CourseLearning.hwyAudioHost\",\"value\":\"https://defhwvod.59iedu.com\"},{\"key\":\"applicationDiff.Bill.provideInvoiceType\",\"value\":\"0\"},{\"key\":\"applicationDiff.Course.timePointInterval\",\"value\":\"5\"},{\"key\":\"applicationDiff.CourseLearning.hwyStreamHost\",\"value\":\"https://defhwvod.59iedu.com\"},{\"key\":\"application.platformVersionId\",\"value\":\"cp95bc4721474100808bca5882jskq02\"},{\"key\":\"application.mq.producerName\",\"value\":\"platform_jskqcp_producer\"},{\"key\":\"applicationDiff.Bill.billRangeType\",\"value\":\"0\"},{\"key\":\"mq.learningSchemeSystemId\",\"value\":\"2c9180e55e0cebd9015e1889cedf0725\"},{\"key\":\"applicationDiff.BasicData.normalCollectiveAdminRoleId\",\"value\":\"\"},{\"key\":\"application.provinceId\",\"value\":\"510000\"},{\"key\":\"applicationDiff.BasicData.normalTeachAdminRoleId\",\"value\":\"\"},{\"key\":\"application.PreExamLS.lsCustomerTypeId\",\"value\":\"61ee965b62ab11ea980314187732ebee\"},{\"key\":\"applicationDiff.BasicData.tempStudentRoleId\",\"value\":\"\"},{\"key\":\"application.mfsHost\",\"value\":\"/mnt/mfs\"},{\"key\":\"application.quartz.schedulerName\",\"value\":\"fjhb.jskqcp-quartz-scheduler\"},{\"key\":\"applicationDiff.CourseLearning.videoStreamHost\",\"value\":\"\"},{\"key\":\"application.systemId\",\"value\":\"cp95bc4721474100808bca5882jskq02\"},{\"key\":\"applicationDiff.BasicData.tempTeachAdminRoleId\",\"value\":\"\"},{\"key\":\"applicationDiff.ConfigCenter.openFilter\",\"value\":\"false\"},{\"key\":\"applicationDiff.Bill.autoBillingPolicy\",\"value\":\"0\"},{\"key\":\"applicationDiff.CourseLearning.defaultPlayType\",\"value\":\"player_hwCloud\"}]},\"errors\":null}\n" +
                "\n" +
                "\n");*/
     //   System.out.print( "content100 = "+ string);
    }

}
