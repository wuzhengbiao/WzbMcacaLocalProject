package CollectionOfFunctionalMethods.HtmlOperation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GenerateHtml {
    public static  void HtmlSuiteTest(String url,Object response,String path) throws Exception {
        //用于存储html字符串
        StringBuilder stringHtml = new StringBuilder();
        //打开文件
        PrintStream printStream = new PrintStream( new FileOutputStream( path ) );
        //输入HTML文件内容
        stringHtml.append( "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"+"\r\n");
        stringHtml.append( "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
                "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" +"\r\n");
        stringHtml.append( "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"\" lang=\"\">"+"\r\n" );
        stringHtml.append( "<html><head>" +"\r\n");
        stringHtml.append( "<title>Test Results Report - Test1</title>"+"\r\n" );
        stringHtml.append( "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />"+"\r\n" );
        stringHtml.append( "<meta name=\"description\" content=\"TestNG unit test results.\" />" +"\r\n");
        stringHtml.append( "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" +"\r\n");
        stringHtml.append( "<link href=\"reportng.css\" rel=\"stylesheet\" type=\"text/css\" />"+"\r\n" );
        stringHtml.append( "    <script type=\"text/javascript\" src=\"reportng.js\"></script>"+"\r\n" );
        stringHtml.append( "</head>" +"\r\n");
        stringHtml.append( "<body>"+"\r\n"  );
        stringHtml.append( "<h1>接口测试请求的报告</h1>" +"\r\n" );
        stringHtml.append( "<p>" +"\r\n");
        stringHtml.append( "GrahQl 的请求过程，如下：" +"\r\n" );
        stringHtml.append( "</p>" +"\r\n");
        stringHtml.append( "<div id=\"log\">" +"\r\n" );
        stringHtml.append( "请求的url: "+"     "+url+"<br/>"+"\r\n" );
        stringHtml.append( "响应的结果："+"      "+response+"<br />" +"\r\n" );
        stringHtml.append( "</body>" +"\r\n" );
        stringHtml.append( "</html>" +"\r\n" );
        try {
     //将HTML文件内容写入文件中
            printStream.println( stringHtml.toString() );
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public static  void HtmlSuites(String suitefile,String path) throws Exception {
        //用于存储html字符串
        StringBuilder stringHtml = new StringBuilder();
        //打开文件
        PrintStream printStream = new PrintStream( new FileOutputStream( path ) );
        //输入HTML文件内容
        stringHtml.append( "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"+"\r\n");
        stringHtml.append( "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" +"\r\n");
        stringHtml.append( "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"\" lang=\"\">"+"\r\n" );
        stringHtml.append( "<head>" +"\r\n");
        stringHtml.append( "<title>Test Results Report - Suites</title>"+"\r\n" );
        stringHtml.append( "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />"+"\r\n" );
        stringHtml.append( "<meta name=\"description\" content=\"TestNG unit test results.\" />" +"\r\n");
        stringHtml.append( "<link href=\"reportng.css\" rel=\"stylesheet\" type=\"text/css\" />" +"\r\n");
        stringHtml.append( "<script type=\"text/javascript\" src=\"reportng.js\"></script>"+"\r\n" );
        stringHtml.append( "</head>"+"\r\n" );
        stringHtml.append( "<body style=\"margin-top: 0;\">" +"\r\n");
        stringHtml.append( "<div id=\"sidebarHeader\">"+"\r\n"  );
        stringHtml.append( "<h2>Test Results Report</h2>" +"\r\n" );
        stringHtml.append( "<p>" +"\r\n");
        stringHtml.append( "<a href=\"overview - test.html\" target=\"main\">Overview</a>" +"\r\n" );
        stringHtml.append( "</p>" );
        stringHtml.append( "</div>" +"\r\n" );
        stringHtml.append( "<table id=\"suites\">"+"\r\n" );
        stringHtml.append( "<thead>"+"\r\n" );
        stringHtml.append( "<tr>" +"\r\n" );
        stringHtml.append( "<th class=\"header suite\" onclick=\"toggleElement('tests-1', 'table-row-group'); toggle('toggle-1')\">" +"\r\n" );
        stringHtml.append( "<span id=\"toggle-1\" class=\"toggle\">&#x25bc;</span>Suite" +"\r\n" );
        stringHtml.append( "</th>" +"\r\n" );
        stringHtml.append( "</tr>" +"\r\n" );
        stringHtml.append( "</thead>" +"\r\n" );
        stringHtml.append( "<tbody id=\"tests-1\" class=\"tests\">" +"\r\n" );
        stringHtml.append( "<tr>" +"\r\n" );
        stringHtml.append( "<td class=\"test\">" +"\r\n" );
        stringHtml.append( "<span class=\"successIndicator\" title=\"All tests passed.\">&#x2714;</span>" +"\r\n" );
        stringHtml.append( "<a href="+suitefile+" target=\"main\">Test2</a>" +"\r\n" );
        stringHtml.append( "</td>\n" +
                "    </tr>\n" +
                "          </tbody>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>" +"\r\n" );
        try {
            //将HTML文件内容写入文件中
            printStream.println( stringHtml.toString() );
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
