package controller.car;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.modelloAuto.ModelloAuto;
import model.modelloAuto.ModelloAutoDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CarFilterServlet", value = "/common/CarFilterServlet")
public class CarFilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("selectedBrand", request.getParameter("brand"));
        request.setAttribute("selectedCategory", request.getParameter("category"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/common/car/showroom-car.jsp");
        dispatcher.forward(request, response);
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

            List<ModelloAuto> models = new ModelloAutoDAO().doRetrieveByFilter(brand, category, year, minPrice, maxPrice);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            ObjectMapper mapper = new ObjectMapper();

            if (models != null) {

                ObjectNode info = mapper.createObjectNode();

                List<String> brands = models.stream().map(ModelloAuto::getIDMarcaAuto).distinct().collect(Collectors.toList());
                List<String> categories = models.stream().map(ModelloAuto::getCategoria).distinct().collect(Collectors.toList());
                List<Integer> years = models.stream().map(ModelloAuto::getAnno).distinct().collect(Collectors.toList());
                double min = models.stream().map(ModelloAuto::getPrezzo).reduce(Double::min).get();
                double max = models.stream().map(ModelloAuto::getPrezzo).reduce(Double::max).get();

                info.set("carsInfo", mapper.valueToTree(models));
                info.set("brand", mapper.valueToTree(brands));
                info.set("categories", mapper.valueToTree(categories));
                info.set("years", mapper.valueToTree(years));
                info.set("minPrice", mapper.valueToTree(min));
                info.set("maxPrice", mapper.valueToTree(max));

                out.write(mapper.writeValueAsString(info));
            }
            else {

                ObjectNode error = mapper.createObjectNode();
                error.put("error", "models info not found");
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