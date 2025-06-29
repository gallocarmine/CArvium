package controller.account;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserInfoServlet", value = "/user/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("user");
        Utente userInfo = new UtenteDAO().doRetrieveByID(id);

        PrintWriter out = response.getWriter();

        if (userInfo != null) {

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            JsonObject info = new JsonObject();
            info.add("userInfo", new Gson().toJsonTree(userInfo));
            out.write(info.toString());
        }
        else {

            JsonObject error = new JsonObject();
            error.addProperty("error", "user info not found");
            out.write(error.toString());
        }

        out.flush();
    }
}