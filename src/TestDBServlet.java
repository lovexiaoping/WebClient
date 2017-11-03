import DB.HandleDB;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dinglp on 2017/10/25.
 */
@WebServlet("/TestDBServlet")

public class TestDBServlet extends HttpServlet {


    private static  final long serialVersionUID = 1L;




    public TestDBServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
        req.setCharacterEncoding("UTF-8");

        String username = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String address = new String(req.getParameter("address").getBytes("iso-8859-1"), "utf-8");
        System.out.println("---------------------");

        System.out.println(username);

        //布尔值
        Boolean sex_bool = sex.equals("true")?true:false;


       boolean a = new HandleDB().InsertServletParmData(username,sex_bool, birthday,address);
       if (a){

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");


//        String jsonStr = "{\"status\":\"success\",\"code\":\"200\",\"message\":\"猪八戒\"}}";


        Children children = new Children();
           children.setName(username);
           children.setSex(0);
           children.setBirthday(birthday);
           children.setAddress(address);

           List<Children> N = new ArrayList<Children>(0);
           N.add(children);
           N.add(children);
           N.add(children);
           N.add(children);
           N.add(children);


        UerInfo Info1 = new UerInfo();
        Info1.setName(username);
        Info1.setSex(0);
        Info1.setBirthday(birthday);
        Info1.setAddress(address);
        Info1.setChildren(N);

           Gson gson = new Gson();
           String jsonStr = gson.toJson(Info1);
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

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }}



