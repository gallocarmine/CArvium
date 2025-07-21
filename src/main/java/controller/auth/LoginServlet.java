package controller.auth;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.aggiungere.Aggiungere;
import model.aggiungere.AggiungereDAO;
import model.carrello.Carrello;
import model.carrello.CarrelloDAO;
import model.ricambi.Ricambi;
import model.ricambi.RicambiDAO;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/auth/LoginServlet")

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean invalid = true;

        if(request.getParameterMap().isEmpty()){

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/common/login.jsp");
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
                    session.setAttribute("user", user.getID());
                    session.setAttribute("idCart", user.getIDCarrello());
                    if(user.getAdmin()){ session.setAttribute("admin", user.getAdmin()); }

                    //transfer (if exists) the products from sessionCart to userCart
                    sessionCartToUser(session);
                }
            }

            if(invalid){

                request.setAttribute("error", "Email or password incorrect");
                request.getRequestDispatcher("/WEB-INF/view/common/login.jsp").forward(request, response);
            }

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/common/StartServlet");
        }
    }

    private boolean validateEmail(String email){

        return email.matches("^[\\w.!#$%&'*+/=?^`{|}~-]+@[a-z\\d-]+(?:\\.[a-z\\d-]+)*$");
    }

    private boolean validatePassword(String password){

        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }


    private void sessionCartToUser(HttpSession session){

        List<Aggiungere> adds = (List<Aggiungere>) session.getAttribute("adds");

        if(adds != null) {

            int idCart = (int) session.getAttribute("idCart");

            AggiungereDAO addDAO = new AggiungereDAO();
            for (Aggiungere add : adds) {

                Carrello cart = new CarrelloDAO().doRetrieveById(idCart);
                Aggiungere verify = addDAO.doRetrieveByCartSpare(idCart, add.getIDRicambio());
                Ricambi spare = new RicambiDAO().doRetrieveById(add.getIDRicambio());

                int limitQuantity = spare.getQuantita();

                if(verify != null) {

                    if(verify.getQuantita() + add.getQuantita() <= limitQuantity) {

                        addDAO.doUpdateQuantity(idCart, add.getIDRicambio(), add.getQuantita() + verify.getQuantita());

                        Carrello updateCart = new Carrello(idCart,
                                cart.getCostoTotale() + (add.getQuantita() * spare.getPrezzo()), cart.getQuantita() + add.getQuantita());
                        new CarrelloDAO().doUpdateByID(updateCart);
                    }
                }
                else{

                    if(add.getQuantita() <= limitQuantity){

                        Aggiungere newAdd = new Aggiungere(idCart, add.getIDRicambio(), add.getQuantita());
                        new AggiungereDAO().doSave(newAdd);

                        Carrello updateCart = new Carrello(idCart,
                                cart.getCostoTotale() + (newAdd.getQuantita() * spare.getPrezzo()), cart.getQuantita() + newAdd.getQuantita());
                        new CarrelloDAO().doUpdateByID(updateCart);
                    }
                }
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}