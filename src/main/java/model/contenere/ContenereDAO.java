package model.contenere;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContenereDAO {

    public List<Contenere> doRetrieveAll(){

        List<Contenere> contains = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Contenere";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int idOrdine = rs.getInt("ID_Ordine");
                int idRicambi = rs.getInt("ID_Ricambi");
                int quantita= rs.getInt("Quantità");
                double prezzoUnitario = rs.getDouble("PrezzoUnitario");

                Contenere contain = new Contenere(idOrdine, idRicambi, quantita, prezzoUnitario);
                contains.add(contain);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return contains;
    }

    public int doSave(Contenere contain){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Contenere (ID_Ordine, ID_Ricambi, Quantità, PrezzoUnitario) VALUES (?,?,?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, contain.getIDOrdine());
            ps.setInt(2, contain.getIDRicambi());
            ps.setDouble(3, contain.getQuantita());
            ps.setDouble(4, contain.getPrezzoUnitario());
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
