package controller.account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/auth/LoginServlet")

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean invalid = true;

        if(request.getParameterMap().isEmpty()){

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
            dispatcher.forward(request, response);
        }
        else{

            String email = request.getParameter("email");
            String password = request.getParameter("pass");

            if(validateEmail(email) && validatePassword(password)) {

                Utente user = new UtenteDAO().doRetrieveByEmailPassword(email, password);

                if(user != null) {

                    invalid = false;

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                }
            }

            if(invalid){

                request.setAttribute("error", "Email or password incorrect");
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            }

            String url = "/WEB-INF/view/common/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }

    private boolean validateEmail(String email){

        return email.matches("^[\\w.!#$%&'*+/=?^`{|}~-]+@[a-z\\d-]+(?:\\.[a-z\\d-]+)*$");
    }


    private boolean validatePassword(String password){

        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}