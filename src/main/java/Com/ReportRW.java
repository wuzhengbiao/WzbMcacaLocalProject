package Com;

import java.io.*;

public class ReportRW {
    /**
     * 读取文件内容
     **/
    public String ReportReadModify(String filePath) {
        BufferedReader br = null;
        String line = null;
        StringBuffer buf = new StringBuffer();
        try {
            // 根据文件路径创建缓冲输入流
            br = new BufferedReader(new FileReader(filePath));
            // 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
            while ((line = br.readLine()) != null) {
                // 此处根据实际需要修改某些行的内容
                if (line.contains("&lt;")) {
                    line = line.replace("&lt;", "<");
                }
                if (line.contains("&quot;")) {
                    line = line.replace("&quot;", "\"");
                }
                if (line.contains("&nbsp;")) {
                    line = line.replace("&nbsp;", " ");
                }
                if (line.contains("&gt;")) {
                    line = line.replace("&gt;", ">");
                }
                if (line.contains("PHOTO")) {
                    line = line.replace("PHOTO", "<img width=\"600\" height=\"400\" src=\"");
                }
                if (line.contains("jpg")) {
                        line = line.replace("jpg", "jpg\">");
                }

                // 如果不用修改, 则按原来的内容回写
                buf.append(line);
                buf.append(System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                }
            }
        }
        return buf.toString();
    }

    public void ReportWrite(String filePath, String content) {
        BufferedWriter bw = null;
        try {
            // 根据文件路径创建缓冲输出流
            bw = new BufferedWriter(new FileWriter(filePath));
            // 将内容写入文件中
            bw.write(content);
            System.out.println("写入的内容：" + content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    bw = null;
                }
            }
        }
    }
}
