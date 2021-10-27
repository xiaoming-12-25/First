package com.zhidisoft.system.userservlet;

import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.entity.UserComplete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/usercomplete.do")
public class UserCompleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 查看登录用户的详细信息
 *
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        int id = user.getId();
        UserDao userDao=new UserDao();
        UserComplete userComplete = userDao.SelectUserComplete(id);
        session.setAttribute("taxer",userComplete);
        resp.sendRedirect("/manage/jsp/userInfo.jsp");
    }
}
