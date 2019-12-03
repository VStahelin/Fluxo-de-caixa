package model.dao;

import connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EntradaDao {

    public void insert(int documento, String descricao, Date dataInclusao, Double valor){
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
            JOptionPane.showMessageDialog(null, "Erro em inserir: " + e);
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
    public void update(int documento, String descricao, Date dataInclusao, Double valor){
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        String a = "UPDATE entrada SET descricao='?', dataInclusao='?', valor =? WHERE documento = ?";
        try {
            stmt = connection.prepareStatement("UPDATE entrada SET descricao = ?, dataInclusao = ?, valor = ? WHERE documento = ?");
            stmt.setString(1,descricao);
            stmt.setDate(2, dataInclusao);
            stmt.setDouble(3, valor); //Resquisito casting
            stmt.setInt(4,documento);

            stmt.executeLargeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro em Alterar:  " + e);
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
