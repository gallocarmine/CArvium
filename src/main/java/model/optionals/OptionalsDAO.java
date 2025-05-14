package model.optionals;

import model.ConPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OptionalsDAO {

    public List<Optionals> doRetrieveAll() {

        List<Optionals> optionals = new ArrayList<>();

        try (Connection con = new ConPool().getConnection()) {

            String sql = "SELECT * FROM Optionals";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int ID = rs.getInt("ID");
                String name = rs.getString("Nome");
                double prezzo = rs.getDouble("Prezzo");
                String descrizione = rs.getString("Descrizione");
                int IDModelloAuto = rs.getInt("ID_ModelloAuto");
                int IDMarcaAuto = rs.getInt("ID_ MarcaAuto");

                Optionals optional = new Optionals(ID, name, prezzo, descrizione, IDModelloAuto, IDMarcaAuto);
                optionals.add(optional);
            }

            rs.close();

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return optionals;
    }
}
