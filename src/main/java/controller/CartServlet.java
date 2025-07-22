package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.aggiungere.Aggiungere;
import model.aggiungere.AggiungereDAO;
import model.carrello.Carrello;
import model.carrello.CarrelloDAO;
import model.ricambi.Ricambi;
import model.ricambi.RicambiDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "CartServlet", value = "/common/CartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String spareId = request.getParameter("spare");
        String q = request.getParameter("quantity");
        String action = request.getParameter("action");

        int quantity = (q != null) ? Integer.parseInt(q) : 0;


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();

        Integer user = (Integer) request.getSession().getAttribute("user");
        Integer idCart = (Integer) request.getSession().getAttribute("idCart");


        if (user != null) {

            //DB Cart Management
            if (action.equals("add")) {

                Aggiungere add = new AggiungereDAO().doRetrieveByCartSpare(idCart, spareId);
                Ricambi spare = new RicambiDAO().doRetrieveById(spareId);

                int result = 0;

                if (add != null) {

                    if (add.getQuantita() + quantity <= spare.getQuantita()) {

                        result = new AggiungereDAO().doUpdateQuantity(idCart, spareId, add.getQuantita() + quantity);
                    }
                    else {

                        ObjectNode error = mapper.createObjectNode();
                        error.put("overflow", "overflow");
                        out.write(mapper.writeValueAsString(error));
                    }
                }
                else {

                    if (quantity <= spare.getQuantita()) {

                        Aggiungere newAdd = new Aggiungere(idCart, spareId, quantity);
                        result = new AggiungereDAO().doSave(newAdd);
                    }
                    else {

                        ObjectNode error = mapper.createObjectNode();
                        error.put("overflow", "overflow");
                        out.write(mapper.writeValueAsString(error));
                    }
                }

                if (result == 1) {

                    if (spare != null) {

                        ObjectNode info = mapper.createObjectNode();

                        info.set("spare", mapper.valueToTree(spare));
                        out.write(mapper.writeValueAsString(info));

                    }
                    else {

                        ObjectNode error = mapper.createObjectNode();
                        error.put("error", "spare info not found");
                        out.write(mapper.writeValueAsString(error));
                    }
                }
            }
            else {

                if (action.equals("remove")) {

                    int result = new AggiungereDAO().doRemoveByCartSpare(idCart, spareId);

                    if (result == 1) {

                        ObjectNode info = mapper.createObjectNode();
                        info.set("result", mapper.valueToTree(true));
                        out.write(mapper.writeValueAsString(info));
                    }
                    else {

                        ObjectNode info = mapper.createObjectNode();
                        info.set("result", mapper.valueToTree(false));
                        out.write(mapper.writeValueAsString(info));
                    }
                }
                else {

                    List<Aggiungere> adds = new AggiungereDAO().doRetrieveById(idCart);

                    List<Ricambi> spares = new ArrayList<>();

                    for (Aggiungere add : adds) {

                        Ricambi spare = new RicambiDAO().doRetrieveById(add.getIDRicambio());
                        if(spare.getQuantita() != 0){

                            if(spare.getQuantita() < add.getQuantita()){

                                int pastQuantity = add.getQuantita();
                                double pastCost = add.getQuantita() * spare.getPrezzo();
                                add.setQuantita(spare.getQuantita());
                                double currentCost = add.getQuantita() * spare.getPrezzo();

                                new AggiungereDAO().doUpdateQuantity(idCart, add.getIDRicambio(), add.getQuantita());

                                Carrello cart = new CarrelloDAO().doRetrieveById(idCart);
                                Carrello newCart = new Carrello(idCart,
                                        cart.getCostoTotale() - (pastCost - currentCost),
                                        cart.getQuantita() - (pastQuantity - add.getQuantita()));

                                new CarrelloDAO().doUpdateByID(newCart);
                            }
                        }
                        else{

                            new AggiungereDAO().doRemoveByCartSpare(idCart, add.getIDRicambio());
                            Carrello cart = new CarrelloDAO().doRetrieveById(idCart);
                            Carrello newCart = new Carrello(idCart,
                                    cart.getCostoTotale() - (add.getQuantita() * spare.getPrezzo()),
                                    cart.getQuantita() - add.getQuantita());

                            new CarrelloDAO().doUpdateByID(newCart);
                        }
                        spares.add(spare);
                    }

                    int totalQuantity = 0;
                    double totalCost = 0;
                    adds = new AggiungereDAO().doRetrieveById(idCart);

                    for(Aggiungere add : adds){

                        Ricambi spare = new RicambiDAO().doRetrieveById(add.getIDRicambio());

                        totalCost += add.getQuantita() * spare.getPrezzo();
                        totalQuantity += add.getQuantita();
                    }

                    Carrello updateCart = new Carrello(idCart, totalCost, totalQuantity);
                    new CarrelloDAO().doUpdateByID(updateCart);

                    List<Integer> addQuantity = adds.stream().map(Aggiungere::getQuantita).collect(Collectors.toList());


                    if (spares != null) {

                        ObjectNode info = mapper.createObjectNode();

                        info.set("result", mapper.valueToTree(true));
                        info.set("spares", mapper.valueToTree(spares));
                        info.set("totalCost", mapper.valueToTree(totalCost));
                        info.set("totalQuantity", mapper.valueToTree(totalQuantity));
                        info.set("addQuantity", mapper.valueToTree(addQuantity));
                        out.write(mapper.writeValueAsString(info));
                    }
                    else {

                        ObjectNode error = mapper.createObjectNode();
                        error.put("error", "spares info not found");
                        out.write(mapper.writeValueAsString(error));
                    }
                }
            }
        } else {

            //Session Cart Management
            HttpSession session = request.getSession();

            if (action.equals("add")) {

                List<Aggiungere> adds = (List<Aggiungere>) session.getAttribute("adds");
                Ricambi spare = new RicambiDAO().doRetrieveById(spareId);

                ObjectNode error = mapper.createObjectNode();

                int result = 0;

                if (adds != null) {

                    Optional<Aggiungere> optionalAdd = adds.stream()
                            .filter(a -> a.getIDCarrello() == 0 && a.getIDRicambio().equals(spareId))
                            .findFirst();

                    if (optionalAdd.isPresent()) {

                        Aggiungere add = optionalAdd.get();
                        if (add.getQuantita() + quantity <= spare.getQuantita()) {

                            add.setQuantita(add.getQuantita() + quantity);
                            result = 1;
                        }
                        else {
                            error.put("overflow", "overflow");
                            out.write(mapper.writeValueAsString(error));
                        }
                    }
                    else {
                        if (quantity <= spare.getQuantita()) {
                            Aggiungere newAdd = new Aggiungere(0, spareId, quantity);
                            adds.add(newAdd);
                            result = 1;
                        }
                        else {
                            error.put("overflow", "overflow");
                            out.write(mapper.writeValueAsString(error));
                        }
                    }
                }
                else {

                    adds = new ArrayList<>();
                    session.setAttribute("adds", adds);

                    if (quantity <= spare.getQuantita()) {

                        Aggiungere newAdd = new Aggiungere(0, spareId, quantity);
                        adds.add(newAdd);
                        result = 1;
                    }
                    else {

                        error.put("overflow", "overflow");
                        out.write(mapper.writeValueAsString(error));
                    }
                }

                if (result == 1) {

                    ObjectNode info = mapper.createObjectNode();

                    info.set("spare", mapper.valueToTree(spare));
                    out.write(mapper.writeValueAsString(info));
                }
            }
            else {

                if (action.equals("remove")) {

                    List<Aggiungere> adds = (List<Aggiungere>) session.getAttribute("adds");

                    Optional<Aggiungere> optionalAdd = adds.stream()
                            .filter(a -> a.getIDCarrello() == 0 && a.getIDRicambio().equals(spareId))
                            .findFirst();

                    if (optionalAdd.isPresent()) {

                        adds.remove(optionalAdd.get());

                        ObjectNode info = mapper.createObjectNode();
                        info.set("result", mapper.valueToTree(true));
                        out.write(mapper.writeValueAsString(info));

                    }
                    else {

                        ObjectNode info = mapper.createObjectNode();
                        info.set("result", mapper.valueToTree(false));
                        out.write(mapper.writeValueAsString(info));
                    }
                }
                else {

                    List<Aggiungere> adds = (List<Aggiungere>) session.getAttribute("adds");

                    if (adds != null) {

                        List<Integer> addQuantity = adds.stream().map(Aggiungere::getQuantita).collect(Collectors.toList());

                        List<Ricambi> spares = new ArrayList<>();

                        double totalCost = 0;
                        for (Aggiungere add : adds) {

                            Ricambi spare = new RicambiDAO().doRetrieveById(add.getIDRicambio());
                            if(spare.getQuantita() != add.getQuantita()) {

                                add.setQuantita(spare.getQuantita());
                            }

                            totalCost += add.getQuantita() * spare.getPrezzo();
                            spares.add(spare);
                        }

                        addQuantity = adds.stream().map(Aggiungere::getQuantita).collect(Collectors.toList());
                        int totalQuantity = addQuantity.stream().reduce(0, Integer::sum);

                        if (spares != null) {

                            ObjectNode info = mapper.createObjectNode();

                            info.set("result", mapper.valueToTree(true));
                            info.set("spares", mapper.valueToTree(spares));
                            info.set("totalCost", mapper.valueToTree(totalCost));
                            info.set("totalQuantity", mapper.valueToTree(totalQuantity));
                            info.set("addQuantity", mapper.valueToTree(addQuantity));
                            out.write(mapper.writeValueAsString(info));
                        }
                        else {

                            ObjectNode error = mapper.createObjectNode();
                            error.put("error", "spares info not found");
                            out.write(mapper.writeValueAsString(error));
                        }
                    }
                    else {

                        ObjectNode info = mapper.createObjectNode();

                        info.set("result", mapper.valueToTree(false));
                        info.set("totalCost", mapper.valueToTree(0));
                        info.set("totalQuantity", mapper.valueToTree(0));
                        out.write(mapper.writeValueAsString(info));
                    }
                }
            }
        }

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}