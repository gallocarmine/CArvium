package model.modelloAuto;

import model.ConPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModelloAutoDAO {

    public List<ModelloAuto> doRetrieveAll(){

        List<ModelloAuto> models = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM ModelloAuto";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int id = rs.getInt("ID");
                int idMarcaAuto = rs.getInt("ID_MarcaAuto");
                String nome = rs.getString("Nome");
                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                String descrizione = rs.getString("Descrizione");
                LocalDateTime anno = rs.getTimestamp("Anno").toLocalDateTime();
                String pathname = rs.getString("Pathname");

                ModelloAuto model = new ModelloAuto(id, idMarcaAuto, nome, prezzo, categoria, descrizione, anno, pathname);
                models.add(model);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return models;
    }
}
