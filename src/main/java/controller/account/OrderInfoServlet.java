package controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ordine.Ordine;
import model.ordine.OrdineDAO;
import model.utente.UtenteDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OrderInfoServlet", value = "/user/OrderInfoServlet")
public class OrderInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int idUser = (int) session.getAttribute("user");
        int idCart = new UtenteDAO().doRetrieveByID(idUser).getIDCarrello();

        List<Ordine> orders = new OrdineDAO().doRetrieveByIDCart(idCart);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        if (orders != null) {

            ObjectNode info = mapper.createObjectNode();
            info.set("ordersInfo", mapper.valueToTree(orders));
            out.write(mapper.writeValueAsString(info));
        }
        else {

            ObjectNode error = mapper.createObjectNode();
            error.put("error", "orders info not found");
            out.write(mapper.writeValueAsString(error));
        }

        out.flush();
        out.close();
    }


}