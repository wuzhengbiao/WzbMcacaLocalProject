package CollectionOfFunctionalMethods.BasicMethods;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import macaca.client.MacacaClient;
import java.io.File;
import java.io.IOException;
import java.util.List;
import macaca.client.commands.Element;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;

public class AndroidMethod {
    public void scrollTableView(MacacaClient Driver,String MovingDirection) throws Exception {

        if(MovingDirection.equals("下拉"))
        {
            Driver.drag(200, 200, 200, 600, 0.05);
        }
        else if(MovingDirection.equals("上拉"))
        {
            Driver.drag(200, 600, 200, 200, 0.05);
        }
        else if(MovingDirection.equals("左移"))
        {
            Driver.drag(400, 200, 100, 200, 0.05);
        }
        else
            {
                Driver.drag(100, 200, 400, 200, 0.05);
        }

        Driver.sleep(500);
    }
    // switch to the context of the last pushed webview
    public MacacaClient switchToWebView(MacacaClient Driver) throws Exception {
        JSONArray contexts = Driver.contexts();
        return Driver.context(contexts.get(contexts.size() - 1).toString());
    }

    // switch to the context of native
    public MacacaClient switchToNative(MacacaClient Driver) throws Exception {
        JSONArray contexts = Driver.contexts();
        return Driver.context(contexts.get(0).toString());
    }
    // switch to the context of current
    public MacacaClient switchToCurrentContext(MacacaClient Driver) throws Exception {
        JSONArray contexts = Driver.contexts();
        return Driver.context(Driver.currentContext());
    }
}
