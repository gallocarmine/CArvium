package controller.account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/user/AccountServlet")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameterMap().isEmpty()){

            HttpSession session = request.getSession();
            Integer userID = (Integer) session.getAttribute("user");

            Utente user = new UtenteDAO().doRetrieveByID(userID);
            request.setAttribute("userInfo", user);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/account.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}