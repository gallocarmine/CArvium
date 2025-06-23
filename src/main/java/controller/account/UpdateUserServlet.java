package controller.account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/user/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean invalid = true;

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        String c = request.getParameter("civic");
        String C = request.getParameter("cap");

         if (isValid(firstName) && isValid(lastName)
                 && validateEmail(email) && validatePasswords(newPass, confirmPass)
                 && isValid(street) && isValid(country)
                 && isValid(c) && isValid(C)) {

                int civic = Integer.parseInt(c);
                int CAP = Integer.parseInt(C);

                invalid = false;

                HttpSession session = request.getSession();
                Utente user = (Utente) session.getAttribute("user");

                user.setNome(firstName);
                user.setCognome(lastName);
                user.setEmail(email);
                user.setPassword(confirmPass);
                user.setNazione(country);
                user.setVia(street);
                user.setCAP(CAP);
                user.setCivico(civic);

                //verify if the user has been updated
                if (new UtenteDAO().doUpdate(user) == 0) {

                    request.setAttribute("error", "No changes made");
                }
            }

            if (invalid) {

                request.setAttribute("error", "Some fields are invalid or empty");
            }

            String url = "/WEB-INF/view/user/account.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }

    private boolean isValid(String parameter){

        return parameter != null && !parameter.trim().isEmpty();
    }

    private boolean validateEmail(String email){

        return email.matches("^[\\w.!#$%&'*+/=?^`{|}~-]+@[a-z\\d-]+(?:\\.[a-z\\d-]+)*$");
    }

    private boolean validatePasswords(String newPass, String confirmPass){

        if(newPass.equals(confirmPass)){

            return confirmPass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}