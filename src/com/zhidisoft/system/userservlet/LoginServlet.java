package com.zhidisoft.system.userservlet;

import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 *     Ajax用户名认证
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        UserDao userDao =new UserDao();
        Map<String,Object> map=new HashMap<>();
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        User user= userDao.SelectUser(username);
        if (user.getUsername()==null){
            map.put("msg","*用户名错误");
            map.put("err",false);
        }else {
            map.put("err",true);
            map.put("msg","√");
        }
        //将map转成json格式输出到前端页面
        out.write(JSONObject.fromObject(map).toString());
        out.flush();
        out.close();
    }
}

