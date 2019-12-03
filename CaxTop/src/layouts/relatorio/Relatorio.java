package layouts.relatorio;

import model.beans.Produto;
import model.dao.RelatorioDao;

import javax.swing.*;
import java.util.List;

public class Relatorio {
    Dates dates = new Dates();
    RelatorioDao relatorioDao = new RelatorioDao();

    public String gerarRelatorioDoDia(){
        String relatorio = null;
        try{
            relatorio = "XYZ COMERCIO DE PRODUTOS LTDA\n" +
                "SISTEMA DE FLUXO DE CAIXA " + dates.getDataAtual() + "\n" +
                "FECHAMENTO DO CAIXA PG 009 \n" +
                    "------------------------------------------------------------\n";

            relatorio = relatorio + "                    Entradas\n" +
                    " DOCUMENTO  DESCRICAO  VALOR \n ------------------------------------------------------------\n";
            List<Produto> produtos = relatorioDao.getEntradaDia();
            int a = produtos.size();
            for (int b = 0; b < a; b++){
                relatorio = relatorio + " " + String.valueOf(produtos.get(b).getDocumento()) + "   " + String.valueOf(produtos.get(b).getDescricao()) + "   " + String.valueOf(produtos.get(b).getValor()) + "\n";
            }
            relatorio = relatorio + "------------------------------------------------------------\n";

            relatorio = relatorio + "                     Saida\n" +
                    " DOCUMENTO  DESCRICAO  VALOR \n" +
                    "------------------------------------------------------------\n";
            produtos = relatorioDao.getSaidaDia();
            a = produtos.size();
            for (int b = 0; b < a; b++){
                relatorio = relatorio + " " + String.valueOf(produtos.get(b).getDocumento()) + "   " + String.valueOf(produtos.get(b).getDescricao()) + "   " + String.valueOf(produtos.get(b).getValor()) + "\n";
            }
            relatorio = relatorio + "------------------------------------------------------------\n";
            relatorio = relatorio + "                     POSICAO DO DIA\n" +
                    "------------------------------------------------------------\n";
            relatorio = relatorio + "Saldo Inicial: " + relatorioDao.getSaldoAnterior() +"\n";
            relatorio = relatorio + "Entradas: " + relatorioDao.getSaldoEntradaDia() +"\n";
            relatorio = relatorio + "Saidas:  " + relatorioDao.getSaldoSaidaDia() +"\n";
            double aux = (relatorioDao.getSaldoEntradaDia()) - (relatorioDao.getSaldoSaidaDia()) + (relatorioDao.getSaldoAnterior());
            relatorio = relatorio + "Total:  " + aux +"\n";

            System.out.println(relatorio);
            JOptionPane.showMessageDialog(null,relatorio);
        }catch (Exception e){
            System.out.println(e);
        }
        return relatorio;
    }

}
