package controller.account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Aggiunta.Aggiunta;
import model.Aggiunta.AggiuntaDAO;
import model.carrello.Carrello;
import model.carrello.CarrelloDAO;
import model.ricambi.Ricambi;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SigninServlet", value = "/SigninServlet")
public class SigninServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean invalid = true;

        if(request.getParameterMap().isEmpty()){

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/signin.jsp");
            dispatcher.forward(request, response);
        }
        else {

            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            String street = request.getParameter("street");
            String c = request.getParameter("civic");
            String C = request.getParameter("cap");


            if (isValid(firstName) && isValid(lastName)
                    && isValid(email) && isValid(password)
                    && isValid(street) && isValid(c) && isValid(C)){

                int civic = Integer.parseInt(c);
                int CAP = Integer.parseInt(C);

                invalid = false;

                Utente user = new Utente();
                user.setNome(firstName);
                user.setCognome(lastName);
                user.setEmail(email);
                user.setPassword(password);
                user.setVia(street);
                user.setCAP(CAP);
                user.setCivico(civic);
                user.setAdmin(false);

                int idCart = new CarrelloDAO().doRetrieveLastID() + 1;
                user.setIDCarrello(idCart);

                HttpSession session = request.getSession();
                List<Ricambi> spares = (List<Ricambi>) session.getAttribute("spares");

                if(spares != null){

                    Carrello cart = new Carrello();
                    cart.setQuantita(spares.size());
                    double totalPrice = spares.stream().map(s -> s.getPrezzo()).reduce(Double::sum).get();
                    cart.setCostoTotale(totalPrice);


                    AggiuntaDAO addDAO = new AggiuntaDAO();
                    for(Ricambi s : spares){

                        Aggiunta add = new Aggiunta(idCart, s.getID());
                        addDAO.doSave(add);
                    }

                    new CarrelloDAO().doSave(cart);
                }
                else{

                    Carrello cart = new Carrello();
                    cart.setCostoTotale(0);
                    cart.setQuantita(0);
                    new CarrelloDAO().doSave(cart);
                }

                //verify if user is already registered
                if(new UtenteDAO().doSave(user) != 1) {
                    invalid = true;
                }
            }
        }

        if(invalid){

            request.setAttribute("error", "Some fields are invalid or empty");
            request.getRequestDispatcher("/WEB-INF/results/signin.jsp").forward(request, response);
        }

        String url = "/WEB-INF/results/login.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    private boolean isValid(String parameter){

        return parameter != null && !parameter.trim().isEmpty();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}