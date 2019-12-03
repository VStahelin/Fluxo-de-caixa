package model.dao;

import connection.ConnectionFactory;
import model.beans.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDao {

    public double getSaldoAnterior(){
        int saldoEntrada = 0;
        int saldoSaida = 0;
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT valor from entrada where dataInclusao < (SELECT CURRENT_DATE FROM DUAL)");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                saldoEntrada = saldoEntrada + resultSet.getInt("valor");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.prepareStatement("SELECT valor from saida where dataInclusao < (SELECT CURRENT_DATE FROM DUAL)");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                saldoSaida = saldoSaida + resultSet.getInt("valor");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saldoEntrada - saldoSaida;
    }
    public List<Produto> getEntradaDia(){
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            statement = connection.prepareStatement("SELECT * from entrada where dataInclusao = ?");
            statement.setDate(1, date);
            resultSet = statement.executeQuery();

            while (resultSet.next()){

                Produto produto = new Produto();
                produto.setDocumento(resultSet.getInt("documento"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setDataInclusao(resultSet.getDate("dataInclusao"));
                produto.setValor(resultSet.getDouble("valor"));
                produtos.add(produto);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return produtos;
    }
    public List<Produto> getSaidaDia(){
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            statement = connection.prepareStatement("SELECT * from saida where dataInclusao = ?");
            statement.setDate(1, date);
            resultSet = statement.executeQuery();

            while (resultSet.next()){

                Produto produto = new Produto();
                produto.setDocumento(resultSet.getInt("documento"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setDataInclusao(resultSet.getDate("dataInclusao"));
                produto.setValor(resultSet.getDouble("valor"));
                produtos.add(produto);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return produtos;
    }

    public List<Produto> getEntradaDias(String dataInicio, String dataFim){
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            statement = connection.prepareStatement("SELECT * from saida where(dataInclusao BETWEEN ? AND ?)");
            statement.setDate(1, Date.valueOf(dataInicio));
            statement.setDate(2, Date.valueOf(dataFim));
            resultSet = statement.executeQuery();

        while (resultSet.next()){

            Produto produto = new Produto();
            produto.setDocumento(resultSet.getInt("documento"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setDataInclusao(resultSet.getDate("dataInclusao"));
            produto.setValor(resultSet.getDouble("valor"));
            produtos.add(produto);
        }

        }catch (Exception e){
            System.out.println(e);
        }
        return produtos;
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
