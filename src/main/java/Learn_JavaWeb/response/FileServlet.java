package Learn_JavaWeb.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取下载文件的路径
        String realPath = "/Users/sugar/Documents/GitHub/JavaPractice/src/main/resources/image.png";
        System.out.println("下载文件的路径：" + realPath);
        // 2. 确定下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
        // 3. 设置让浏览器支持（Content-Disposition）下载的东西的格式。中文文件名让URLEncoder.encode编码，否则会乱码。
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 4. 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        // 5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 6. 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        // 7. 将FileOutputStream流写入到buffer缓冲区
        while ((len=in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();

        // 8. 使用OutputStream将缓冲区中的数据输出到客户端
    }
}
