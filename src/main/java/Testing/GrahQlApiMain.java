package Testing;
import CollectionOfFunctionalMethods.HttpAndHttpsProtocol.HttpRequestMethod;
import CollectionOfFunctionalMethods.HttpAndHttpsProtocol.HttpsRequest;
import org.apache.http.NameValuePair;

import java.util.List;

public class GrahQlApiMain {
    public static void main(String[] args) throws Exception{
        String url = "https://scjt.test1.59iedu.com:8443/web/login/login/getLoginParameters.action?_q=1583831629238";
        Object [] params = new Object[]{"",""};
        Object [] values = new Object[]{"",""};
        List<NameValuePair> paramsList = HttpRequestMethod.GetParams(params,values);
        //Object result = HttpRequestMethod.SendPost(url,paramsList,"application/x-www-form-urlencoded");
        //   Object result2 = HttpsRequest.SendPosts(url,"{\"oldPassword\":\"a000000\",\"newPassword\":\"a000000\"}","application/json");
        HttpsRequest.SendGetS(url,paramsList,"application/x-www-form-urlencoded");

    }
}
