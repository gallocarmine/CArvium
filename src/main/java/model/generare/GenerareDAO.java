package model.generare;

import model.ConPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenerareDAO {

    public List<Generare> doRetrieveAll(){

        List<Generare> generates = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Generare ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int idOrdine = rs.getInt("ID_Ordine");
                int idCarrello = rs.getInt("ID_Carrello");
                LocalDateTime data = rs.getTimestamp("Data").toLocalDateTime();

                Generare generate = new Generare(idOrdine, idCarrello, data);
                generates.add(generate);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return generates;
    }

    public int doSave(Generare generate){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Generare (ID_Ordine, ID_Carrello, Data) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, generate.getIDOrdine());
            ps.setInt(2, generate.getIDCarrello());
            ps.setTimestamp(1, Timestamp.valueOf(generate.getData()));

            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
