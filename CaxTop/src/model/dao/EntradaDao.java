package model.dao;

import connection.ConnectionFactory;
import layouts.Entrada;
import model.beans.Produto;

import javax.swing.*;
import java.sql.*;

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
    public Produto selectDocumento(int documento){
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Produto produto = new Produto();

        try {

            stmt = connection.prepareStatement("SELECT * FROM entrada WHERE documento ="+ documento);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){

                produto.setDocumento(resultSet.getInt("documento"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setDataInclusao(resultSet.getDate("dataInclusao"));
                produto.setValor(resultSet.getDouble("valor"));
            }

            System.out.println(produto.getDocumento());
            System.out.println(produto.getDescricao());
            System.out.println(produto.getDataInclusao());
            System.out.println(produto.getValor());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

}
