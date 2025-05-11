package model.configurazione;

import model.ConPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConfigurazioneDAO {

    public List<Configurazione> doRetrieveAll(){

        List<Configurazione> configs = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Configurazione";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int id = rs.getInt("ID");
                LocalDateTime data = rs.getTimestamp("DataC").toLocalDateTime();
                int idModelloAuto = rs.getInt("ID_ModelloAuto");
                int idMarcaAuto = rs.getInt("ID_MarcaAuto");
                int idUtente = rs.getInt("ID_Utente");

                Configurazione config = new Configurazione(id, data, idModelloAuto, idMarcaAuto, idUtente);
                configs.add(config);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return configs;
    }


    public int doSave(Configurazione config){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Configurazione (DataC, ID_ModelloAuto, ID_MarcaAuto, ID_Utente) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(config.getData()));
            ps.setInt(2, config.getIDModelloAuto());
            ps.setInt(3, config.getIDMarcaAuto());
            ps.setInt(4, config.getIDUtente());

            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
