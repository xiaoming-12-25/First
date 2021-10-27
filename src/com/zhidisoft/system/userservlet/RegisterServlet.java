package com.zhidisoft.system.userservlet;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 *    登录验证
 */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        UserDao userDao =new UserDao();
        PrintWriter out = resp.getWriter();
        Map<String,Object> map=new HashMap<>();
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String che = req.getParameter("che");
        String code= req.getParameter("code");
        //获取session中存的验证码
        String proof =(String) session.getAttribute("code");
        //删除session中存的验证码
        session.removeAttribute("code");
        User user= userDao.SelectUser(username);
        String ch =(String) session.getAttribute("ch");
        // 判断上次是否记住了密码
        if (ch!=null){
            //如果记住切用户名一致直接登录不用密码验证码
            if (ch.equals(username)){
                map.put("state",true);
                map.put("errmessage","√");
            }else {
                map.put("state",false);
                map.put("errmessage","*用户名或密码错误");
            }
        }else {
            //先判断验证码是否正确
            if (code!=null && code.equals(proof)){
                //判断用户名和密码是否正确
                if (username != null && password != null && username.equals(user.getUsername()) && password.equals(user.getPassword())){
                    //判断是否记住密码，如果选中在session存一个值，下次登录实现免密登录
                    if (che!=null){
                        session.setAttribute("ch",username);
                    }
                    req.getSession().setAttribute("user",user);
                    map.put("state",true);
                    map.put("errmessage","√");
                }else {
                    map.put("state",false);
                    map.put("errmessage","*用户名或密码错误");
                }
            }else {
                map.put("state",false);
                map.put("errmessage","*验证码错误");
            }
        }
        //将map转成json格式输出到前端页面
        out.write(JSONObject.fromObject(map).toString());
        out.flush();
        out.close();
    }
}
