package org.injae.web;


import org.injae.domain.MovieVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MovieVO vo = new MovieVO();

        int mno = Integer.parseInt(req.getParameter("mno"));
        String mtitle = req.getParameter("mtitle");
        String cmt = req.getParameter("cmt");
        String mimg = req.getParameter("mimg");



        HttpSession session = req.getSession();
        session.setAttribute("write", vo);

        req.getRequestDispatcher("/WEB-INF/write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("/list");


    }
}
