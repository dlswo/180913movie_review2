package org.injae.web;


import org.injae.dao.MovieDAO;
import org.injae.domain.MovieVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/read")
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MovieDAO dao = new MovieDAO();
        int mno = Integer.parseInt(req.getParameter("mno"));
        MovieVO vo = dao.getReview(mno);

        HttpSession session = req.getSession();

        session.setAttribute("read", vo);
        session.setAttribute("mno", mno);



        req.getRequestDispatcher("/WEB-INF/read.jsp").forward(req, resp);

    }
}
