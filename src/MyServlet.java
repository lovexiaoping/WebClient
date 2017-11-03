
/**
 * Created by dinglp on 2017/10/24.
 */



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {


    private static  final long serialVersionUID = 1L;

    public MyServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);  不支持get

//        resp.setContentType("text/html;charset=UTF-8");
//
//        PrintWriter out = resp.getWriter();
//
//        String title = "使用 GET 方法读取表单数据";

//        注意：如果表单提交的数据中有中文数据则需要转码：
//        String name = new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
//
//        String docType = "<!DOCTYPE html> \n";
//
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<ul>\n" +
//                "  <li><b>站点名</b>："
//                + name + "\n" +
//                "  <li><b>网址</b>："
//                + req.getParameter("url") + "\n" +
//                "</ul>\n" +
//                "</body></html>");
//





        //返回 json 数据

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        String jsonStr = "{\"name\":\"fly\",\"type\":\"虫子\"}";
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            out.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
