package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(request.getParameterMap().isEmpty()){

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/login.jsp");
            dispatcher.forward(request, response);
        }
        else{

            String email = request.getParameter("email");
            String password = request.getParameter("pass");

            if(email != null && password != null) {

                Utente user = new UtenteDAO().doRetrieveByEmailPassword(email, password);

                if(user != null) {

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                }
                else{

                    request.setAttribute("error", "Email or password incorrect");
                    request.getRequestDispatcher("/WEB-INF/results/login.jsp").forward(request, response);
                }
            }

            String url = "/WEB-INF/results/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}