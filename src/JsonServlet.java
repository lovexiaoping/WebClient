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


@WebServlet("/DB.HandleDB.JsonServlet")

public  class JsonServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("name");
        String password = req.getParameter("password");



        String page = req.getParameter("page");//获取填写的编号，userid是文本框的名字，<input type="text" name="userid">




        News new1 = new News(110,username,"日本福田发生了7级地震","http://world.huanqiu.com/exclusive/2016-05/8974294.html");
        News new2 = new News(111, username, "近日库克第八次访华，与滴滴高层会谈",
                "http://mobile.163.com/16/0523/09/BNO7SG2B001168BQ.html");
        News new3 = new News(113, password, "Google开发者大会即将举办，是否推出Android7.0?",
                "http://www.ithome.com/html/android/227647.htm");
        News new4 = new News(114, password, "格里营收下滑400亿，董明珠说我活得好的很",
                "http://news.mydrivers.com/1/484/484072.htm");
        News new5 = new News(115, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new6 = new News(116, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new7 = new News(117, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new8 = new News(118, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new9 = new News(119, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new10 = new News(120, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");


        News new11 = new News(121, username, "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new12 = new News(122, username, "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new13 = new News(123, "获取新数据！！！！！！", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new14 = new News(124, "获取新数据！！！！！！", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new15 = new News(125, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new16 = new News(126, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new17 = new News(127, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new18 = new News(128, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new19 = new News(129, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");
        News new20 = new News(130, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很",  "www.baidu.com");


        List<News> newslist = new ArrayList<News>();
        if (page==null ||
                page.equals("0"))
        {
            newslist.add(new1);
            newslist.add(new2);
            newslist.add(new3);
            newslist.add(new4);
            newslist.add(new5);
            newslist.add(new6);
            newslist.add(new7);
            newslist.add(new8);
            newslist.add(new9);
            newslist.add(new10);

        } else {
            newslist.add(new11);
            newslist.add(new12);
            newslist.add(new13);
            newslist.add(new14);
            newslist.add(new15);
            newslist.add(new16);
            newslist.add(new17);
            newslist.add(new18);
            newslist.add(new19);
            newslist.add(new20);
        }
        // 将数据封装到新闻总计类



        NewTotal nt = new NewTotal(newslist.size(),newslist);
        // 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
        Gson gson = new Gson();
        String json = gson.toJson(nt);

        //        json = "{\"name\":\"fly\",\"type\":\"虫子\"}";




        // 输出到界面
        //        System.out.println(json);
        //        resp.setContentType("text/plain");
        //        resp.setCharacterEncoding("gb2312");
        //        PrintWriter out = new PrintWriter(resp.getOutputStream());
        //        out.print(json);
        //        out.flush();

        // response 返回数据


        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out1 = resp.getWriter();
        try {
            out1 = resp.getWriter();
            out1.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out1 != null) {
                out1.close();
            }
        }

        // response 返回数据 2


        //        resp.setCharacterEncoding("UTF-8");
        //        resp.setContentType("application/json; charset=utf-8");
        //        PrintWriter out = resp.getWriter();
        //        JSONArray array = new JSONArray();
        //
        //        for (int i = 0; i <5 ; i++) {
        //            JSONObject OBJ = new JSONObject();
        //            OBJ.put("id",i);
        //            OBJ.put("name","xiaoping");
        //            OBJ.put("sex","xiaoping");
        //
        //            array.add(OBJ);
        //        }
        //
        //        out.write(array.toString());
        //        out.flush();
        //        out.close();




    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}