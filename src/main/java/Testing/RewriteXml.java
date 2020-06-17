package Testing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import CollectionOfFunctionalMethods.BasicMethods.GetLocalConfig;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.testng.TestNG;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RewriteXml {
    @BeforeTest
    public  void CreateTestngXml() throws IOException{
           String[] XmlContext= null;
           String config=GetLocalConfig.ReadConfigFile();
           XmlContext= GetLocalConfig.GetBySemicolonFromConfigFile(config);
            //创建Document实例  
            Document document = DocumentHelper.createDocument();
            //记录要保存的xml文件位置  
            String xmlfilepath=System.getProperty("user.dir")+"\\testng_StoreTestXml.xml";
            //创建根节点suite，并设置name属性为xmlsuitename  
            Element root = document.addElement( "suite" ).addAttribute("name", "Suite");
            //创建监听值
             Element listeners = root.addElement( "listeners" );
            listeners.addElement( "listener" ).addAttribute("class-name","org.uncommons.reportng.HTMLReporter");
            listeners.addElement( "listener" ).addAttribute("class-name","org.uncommons.reportng.JUnitXMLReporter");
            listeners.addElement( "listener" ).addAttribute("class-name","CollectionOfFunctionalMethods.BasicMethods.AssertionListener");
            listeners.addElement( "listener" ).addAttribute("class-name","CollectionOfFunctionalMethods.UseCaseReRunCorrelation.OverrideIAnnotationTransformer");
           for(int testnum=0;testnum<=XmlContext.length-1; testnum++)
            {
                System.out.print("get file name ="+XmlContext[testnum]+"\n");
            //创建节点test，并设置name、属性  
            Element test = root.addElement( "test" ).addAttribute("name", "test"+testnum);
            //创建xml的参数值
            Element parameter= test.addElement( "parameter" );
            parameter.addAttribute("name", "TestFilePath");
            parameter.addAttribute("value", "/TestList/"+XmlContext[testnum]);
             Element parameter6= test.addElement( "parameter" );
             parameter6.addAttribute("name", "PlatformName");
             parameter6.addAttribute("value", "动态TMP用例-"+XmlContext[testnum].trim());
            Element parameter2= test.addElement( "parameter" );
            parameter2.addAttribute("name", "TIME");
            parameter2.addAttribute("value", "20");
            Element parameter3= test.addElement( "parameter" );
            parameter3.addAttribute("name", "TestName");
            parameter3.addAttribute("value", XmlContext[testnum]);
            Element parameter4= test.addElement( "parameter" );
            parameter4.addAttribute("name", "Platform");
            parameter4.addAttribute("value", "");
            Element parameter5= test.addElement( "parameter" );
            parameter5.addAttribute("name", "ApkName");
            parameter5.addAttribute("value", "");
            //创建节点classes，无属性  
            Element classes = test.addElement( "classes" );
            //创建节点classs，并设置name属性  
            Element classs= classes.addElement( "class" ).addAttribute("name","Testing.Tester");
            }
            //第一个参数：名称    
            //第二个参数：PUBLIC URI  //第三个参数：SYSTEM URI  
            document.addDocType("suite", null,"http://testng.org/testng-1.0.dtd");
            //输出格式设置  
            OutputFormat format = OutputFormat.createPrettyPrint();
            format = OutputFormat.createCompactFormat();
            //设置输出编码  
            format.setEncoding("UTF-8");
            //创建XML文件  
            XMLWriter writer= new XMLWriter(new OutputStreamWriter(new FileOutputStream(xmlfilepath),format.getEncoding()),format);
            writer.write( document );
             writer.close();
            document=null;
    }

}
