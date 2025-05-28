package controller.account;

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

        boolean invalid = true;

        if(request.getParameterMap().isEmpty()){

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/login.jsp");
            dispatcher.forward(request, response);
        }
        else{

            String email = request.getParameter("email");
            String password = request.getParameter("pass");

            if(isValid(email) && isValid(password)) {

                Utente user = new UtenteDAO().doRetrieveByEmailPassword(email, password);

                if(user != null) {

                    invalid = false;

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                }
            }

            if(invalid){

                request.setAttribute("error", "Email or password incorrect");
                request.getRequestDispatcher("/WEB-INF/results/login.jsp").forward(request, response);
            }

            String url = "/WEB-INF/results/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }

    private boolean isValid(String parameter){

        return parameter != null && !parameter.trim().isEmpty();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}