package model.dao;

import connection.ConnectionFactory;
import model.beans.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDao {

    public double getSaldoEntradaDia(){
        double saldoEntrada = 0;
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT valor from entrada where dataInclusao = (SELECT CURRENT_DATE FROM DUAL)");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                saldoEntrada = saldoEntrada + resultSet.getInt("valor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saldoEntrada;
    }

    public double getSaldoSaidaDia(){
        double saldoSaida = 0;
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT valor from saida where dataInclusao = (SELECT CURRENT_DATE FROM DUAL)");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                saldoSaida = saldoSaida + resultSet.getInt("valor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saldoSaida;
    }

    public double getSaldoAnterior(){
        double saldoEntrada = 0;
        double saldoSaida = 0;
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

    public List<Produto> getJaneiro(int ano){
        String dataInicio = ano+"-01-01";
        String dataFim = ano+"-01-31";
        Connection connection = ConnectionFactory.getConnction();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            statement = connection.prepareStatement("SELECT * from saida where(dataInclusao BETWEEN "+ dataInicio+" AND"+dataFim+" )");
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
}
