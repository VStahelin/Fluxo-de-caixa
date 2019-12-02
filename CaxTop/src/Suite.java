import layouts.LayoutBase;
import layouts.Telas;
import layouts.entrada.Entrada;
import layouts.relatorios.Relatorio;
import layouts.saida.Saida;

import javax.swing.*;

public class Suite {
    private int resultado_escolha;
    private int processo = 1;
    public void escolha_tela(){
        while (processo == 1){
            int escolha_tela = Integer.parseInt(JOptionPane.showInputDialog(null,
                    " XYZ COMERCIO DE PRODUTOS LTDA.\n" +
                            "Sistema de Fluxo de Caixa\n" +
                            "Menu Principal\n" +
                            "1- Entrada\n" +
                            "2- Saida\n" +
                            "3- Relatorios\n" +
                            "0- Finalizar"));
            try {
                switch (escolha_tela){
                    case 1:
                        Entrada entrada = new Entrada();
                        entrada.ConfiguraTela(0);
                        resultado_escolha = TelaDeEscolha(entrada);
                        entrada.Entrada(resultado_escolha);
                        TelaSecundaria(entrada);
                        break;
                    case 2:
                        Saida saida = new Saida();
                        saida.ConfiguraTela(0);
                        resultado_escolha = TelaDeEscolha(saida);
                        saida.Entrada(resultado_escolha);
                        TelaSecundaria(saida);
                        break;
                    case 3:
                        Relatorio relatorio = new Relatorio();
                        relatorio.ConfiguraTela();
                        resultado_escolha = TelaDeEscolha(relatorio);
                        break;
                    case 0:
                        message(1);
                        break;
                }
            } catch (Exception e){
                System.out.println(e);
            }finally {
                if (escolha_tela == 0){
                    processo = 0;
                }
            }
        }

    }

    private int TelaDeEscolha(LayoutBase object) {
        Telas telas = new Telas();
        int escolha = telas.TelaDeEscolha(object);
        System.out.println("Voltou"); //TODO APAGAR
        return escolha;
    }

    public void TelaSecundaria(LayoutBase object){ ;
        Telas telas = new Telas();
        telas.TelaComCampos(object);
        while (telas.getEspera() == 1){
            System.out.println("Esperando");
        }
        int a = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
        if (a != 0 ){
            processo = 0;
            message(1);
        }
    }

    public void message(int message){
        switch (message){
            case 1:
                System.out.println("Finalizando Programa");
        }
    }
}