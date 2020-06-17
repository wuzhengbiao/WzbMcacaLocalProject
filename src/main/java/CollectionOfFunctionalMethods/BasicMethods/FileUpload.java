package CollectionOfFunctionalMethods.BasicMethods;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.File;

public class FileUpload {
    /**
     * 启动应用程序
     *
     */
    public  void startProgram(String programPath) throws Exception {
        System.out.println("启动应用程序：" + programPath);
        if (StringUtils.isNotBlank(programPath)) {
            try {
                Desktop.getDesktop().open(new File(programPath));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("应用程序：" + programPath + "不存在！");
            }
        }
    }

}
