package controller.account;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.aggiungere.Aggiungere;
import model.aggiungere.AggiungereDAO;
import model.carrello.Carrello;
import model.carrello.CarrelloDAO;
import model.contenere.Contenere;
import model.contenere.ContenereDAO;
import model.ordine.Ordine;
import model.ordine.OrdineDAO;
import model.ricambi.Ricambi;
import model.ricambi.RicambiDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/user/OrderServlet")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode info = mapper.createObjectNode();

        HttpSession session = request.getSession();
        int idCart = (int) session.getAttribute("idCart");

        Carrello cart = new CarrelloDAO().doRetrieveById(idCart);

        int quantity = cart.getQuantita();
        double totalCost = cart.getCostoTotale();

        int result = 0;
        if(quantity != 0){

            Ordine order = new Ordine(quantity, totalCost, LocalDateTime.now(), idCart);
            result = new OrdineDAO().doSave(order);
        }

        if(result == 1){

            int idOrder = new OrdineDAO().doRetrieveLastId();
            List<Aggiungere> adds = new AggiungereDAO().doRetrieveById(idCart);

            RicambiDAO spareDAO = new RicambiDAO();
            for(Aggiungere add : adds) {

                Ricambi spare = spareDAO.doRetrieveById(add.getIDRicambio());
                Contenere spareContained = new Contenere(idOrder, add.getIDRicambio(), add.getQuantita(), spare.getPrezzo());
                new ContenereDAO().doSave(spareContained);

                spareDAO.doUpdateQuantityById(add.getIDRicambio(), spare.getQuantita() - add.getQuantita());
            }

            Carrello cleanCart = new Carrello(idCart, 0, 0);
            new CarrelloDAO().doUpdateByID(cleanCart);
            new AggiungereDAO().doRemoveByID(idCart);

            info.set("result", mapper.valueToTree("accepted"));
            out.write(mapper.writeValueAsString(info));
        }
        else{

            info.set("result", mapper.valueToTree("declined"));
            out.write(mapper.writeValueAsString(info));
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}