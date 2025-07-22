package controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.modelloAuto.ModelloAuto;
import model.modelloAuto.ModelloAutoDAO;
import model.ordine.Ordine;
import model.salvare.Salvare;
import model.salvare.SalvareDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "WishlistServlet", value = "/user/WishlistServlet")
public class WishlistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String modelId = request.getParameter("model");
        String brandId = request.getParameter("brand");
        String action = request.getParameter("action");
        int userId = (int) request.getSession().getAttribute("user");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();

        if (action.equals("add")) {

            Salvare save = new Salvare(modelId, brandId, userId);
            int result = new SalvareDAO().doSave(save);

            if (result == 1) {

                ModelloAuto model = new ModelloAutoDAO().doRetrieveById(modelId, brandId);

                if (model != null) {

                    ObjectNode info = mapper.createObjectNode();

                    info.set("model", mapper.valueToTree(model));
                    out.write(mapper.writeValueAsString(info));
                } else {

                    ObjectNode error = mapper.createObjectNode();
                    error.put("error", "model info not found");
                    out.write(mapper.writeValueAsString(error));
                }
            }
        } else {

            if (action.equals("remove")) {

                int result = new SalvareDAO().doRemoveById(modelId, brandId, userId);

                if (result == 1) {

                    ObjectNode info = mapper.createObjectNode();
                    info.set("result", mapper.valueToTree(true));
                    out.write(mapper.writeValueAsString(info));
                } else {

                    ObjectNode info = mapper.createObjectNode();
                    info.set("result", mapper.valueToTree(false));
                    out.write(mapper.writeValueAsString(info));
                }

            } else {

                if (action.equals("info")) {

                    Salvare save = new SalvareDAO().doRetrieveById(modelId, brandId, userId);

                    if (save != null) {

                        ObjectNode info = mapper.createObjectNode();

                        info.set("result", mapper.valueToTree(true));
                        out.write(mapper.writeValueAsString(info));
                    } else {

                        ObjectNode info = mapper.createObjectNode();

                        info.set("result", mapper.valueToTree(false));
                        out.write(mapper.writeValueAsString(info));
                    }

                } else {

                    List<Salvare> saves = new SalvareDAO().doRetrieveAllById(userId);
                    List<ModelloAuto> models = new ArrayList<>();

                    for (Salvare save : saves) {

                        ModelloAuto model = new ModelloAutoDAO().doRetrieveById(save.getIDModelloAuto(), save.getIDMarcaAuto());
                        models.add(model);
                    }

                    if (models != null) {

                        ObjectNode info = mapper.createObjectNode();

                        info.set("models", mapper.valueToTree(models));
                        out.write(mapper.writeValueAsString(info));
                    } else {

                        ObjectNode error = mapper.createObjectNode();
                        error.put("error", "models info not found");
                        out.write(mapper.writeValueAsString(error));
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