package controller.auth;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.aggiungere.Aggiungere;
import model.aggiungere.AggiungereDAO;
import model.carrello.Carrello;
import model.carrello.CarrelloDAO;
import model.ricambi.RicambiDAO;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SigninServlet", value = "/auth/SigninServlet")
public class SigninServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean invalid = true;

        if(request.getParameterMap().isEmpty()){

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/common/signin.jsp");
            dispatcher.forward(request, response);
        }
        else {

            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            String country = request.getParameter("country");
            String street = request.getParameter("street");
            String c = request.getParameter("civic");
            String C = request.getParameter("cap");


            if (isValid(firstName) && isValid(lastName)
                    && validateEmail(email) && validatePassword(password)
                    && isValid(street) && isValid(country)
                    && isValid(c) && isValid(C)){

                int civic = Integer.parseInt(c);
                int CAP = Integer.parseInt(C);

                invalid = false;

                Utente user = new Utente();
                user.setNome(firstName);
                user.setCognome(lastName);
                user.setEmail(email);
                user.setPasswordSHA(password);
                user.setNazione(country);
                user.setVia(street);
                user.setCAP(CAP);
                user.setCivico(civic);
                user.setAdmin(false);


                Carrello cart = new Carrello();
                cart.setCostoTotale(0);
                cart.setQuantita(0);
                new CarrelloDAO().doSave(cart);


                int idCart = new CarrelloDAO().doRetrieveLastID();
                user.setIDCarrello(idCart);

                //verify if user is already registered
                if(new UtenteDAO().doSave(user) != 1) {

                    new CarrelloDAO().doDeleteByID(idCart);
                    invalid = true;
                }
            }
        }

        if(invalid){

            request.setAttribute("error", "Some fields are invalid or empty");
            request.getRequestDispatcher("/WEB-INF/view/common/signin.jsp").forward(request, response);
        }

        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/auth/LoginServlet");
    }


    private boolean isValid(String parameter){

        return parameter != null && !parameter.trim().isEmpty();
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