package controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();

        if (userInfo != null) {

            ObjectNode info = mapper.createObjectNode();
            info.set("userInfo", mapper.valueToTree(userInfo));
            out.write(mapper.writeValueAsString(info));
        }
        else {

            ObjectNode error = mapper.createObjectNode();
            error.put("error", "user info not found");
            out.write(mapper.writeValueAsString(error));
        }

        out.flush();
        out.close();
    }
}