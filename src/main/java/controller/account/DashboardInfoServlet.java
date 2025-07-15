package controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ordine.Ordine;
import model.ordine.OrdineDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DashboardInfoServlet", value = "/admin/DashboardInfoServlet")
public class DashboardInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Ordine> orders = new OrdineDAO().doRetrieveAll();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        if (orders != null) {

            double grossRevenues = orders.stream().map(Ordine::getCostoTotale).reduce(Double::sum).get();
            int sparesSold = orders.stream().map(Ordine::getQuantita).reduce(Integer::sum).get();

            ObjectNode info = mapper.createObjectNode();

            info.set("ordersInfo", mapper.valueToTree(orders));
            info.set("grossRevenues", mapper.valueToTree(grossRevenues));
            info.set("totalOrders", mapper.valueToTree(orders.size()));
            info.set("sparesSold", mapper.valueToTree(sparesSold));
            info.set("averageRevenue", mapper.valueToTree(grossRevenues/orders.size()));

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