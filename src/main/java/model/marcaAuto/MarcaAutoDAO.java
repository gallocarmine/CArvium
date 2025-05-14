package model.marcaAuto;

import model.ConPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarcaAutoDAO {

    public List<MarcaAuto> doRetrieveAll(){

        List<MarcaAuto> brands = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM MarcaAuto";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                String pathname = rs.getString("Pathname");

                MarcaAuto brand = new MarcaAuto(id, nome, pathname);
                brands.add(brand);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return brands;
    }
}
