package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.modelloAuto.ModelloAuto;
import model.modelloAuto.ModelloAutoDAO;
import model.ricambi.Ricambi;
import model.ricambi.RicambiDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ShopFilterServlet", value = "/common/ShopFilterServlet")
public class ShopFilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String brand = request.getParameter("brand");
        String category = request.getParameter("category");
        String y = request.getParameter("year");
        String minP = request.getParameter("min-price");
        String maxP = request.getParameter("max-price");

        if (isValid(brand) && isValid(category)) {

            int year = 0;
            int minPrice = 0;
            int maxPrice = 0;

            if (isValid(y)) { year = Integer.parseInt(y); }

            if (isValid(minP) && isValid(maxP)) {

                minPrice = Integer.parseInt(minP);
                maxPrice = Integer.parseInt(maxP);
            }

            List<Ricambi> spares = new RicambiDAO().doRetrieveByFilter(brand, category, year, minPrice, maxPrice);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            ObjectMapper mapper = new ObjectMapper();

            if (spares != null) {

                ObjectNode info = mapper.createObjectNode();

                List<String> brands = spares.stream().map(Ricambi::getIDMarcaAuto).distinct().collect(Collectors.toList());
                List<String> categories = spares.stream().map(Ricambi::getCategoria).distinct().collect(Collectors.toList());
                List<Integer> years = spares.stream().map(Ricambi::getAnno).distinct().collect(Collectors.toList());
                double min = spares.stream().map(Ricambi::getPrezzo).reduce(Double::min).get();
                double max = spares.stream().map(Ricambi::getPrezzo).reduce(Double::max).get();

                info.set("sparesInfo", mapper.valueToTree(spares));
                info.set("brand", mapper.valueToTree(brands));
                info.set("categories", mapper.valueToTree(categories));
                info.set("years", mapper.valueToTree(years));
                info.set("minPrice", mapper.valueToTree(min));
                info.set("maxPrice", mapper.valueToTree(max));

                out.write(mapper.writeValueAsString(info));
            }
            else {

                ObjectNode error = mapper.createObjectNode();
                error.put("error", "spares info not found");
                out.write(mapper.writeValueAsString(error));
            }

            out.flush();
            out.close();
        }
    }

    private boolean isValid(String parameter) {

        return parameter != null && !parameter.trim().isEmpty();
    }
}