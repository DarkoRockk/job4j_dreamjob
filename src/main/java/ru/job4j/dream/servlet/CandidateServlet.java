package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if ("delete".equals(req.getParameter("method"))) {
            PsqlStore.instOf().removeCandidate(Integer.parseInt(req.getParameter("id")));
            File file = new File("/Users/darkorockk/IdeaProjects/job4j_dreamjob/images/" + req.getParameter("id") + ".png");
            if (file.exists()) {
                Files.delete(file.toPath());
            }
            resp.sendRedirect(req.getContextPath() + "/candidates.do");
        } else {
            PsqlStore.instOf().addCandidate(new Candidate(Integer.parseInt(req.getParameter("id")),
                    req.getParameter("name")));
            resp.sendRedirect(req.getContextPath() + "/candidates.do");
        }
    }
}
