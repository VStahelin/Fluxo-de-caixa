package model.dao;

import connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EntradaDao {

    public String insert(int documento, String descricao, Date dataInclusao, Double valor){
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO entrada (documento, descricao, dataInclusao, valor) VALUES(?,?,?,?)");
            stmt.setInt(1,documento);
            stmt.setString(2,descricao);
            stmt.setDate(3, dataInclusao);
            stmt.setDouble(4, valor); //Resquisito casting

            stmt.executeLargeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Inserido" + e);
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(connection, stmt);
            return "Finalizado";
        }
    }
}
