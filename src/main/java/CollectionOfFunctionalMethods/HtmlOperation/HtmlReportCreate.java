package CollectionOfFunctionalMethods.HtmlOperation;

import org.testng.Reporter;

public class HtmlReportCreate {
    public static void HtmlInterfaceReport(String url, Object response, String parameter) throws Exception {
        Reporter.log( url );
        Reporter.log( parameter );
        Reporter.log( response.toString() );
    }
}