import layouts.LayoutBase;
import layouts.Telas;
import layouts.Entrada;
import layouts.relatorios.Relatorio;
import layouts.Saida;

import javax.swing.*;

import static java.lang.Thread.sleep;

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
                        entrada.Entrada(0);
                        resultado_escolha = TelaDeEscolha(entrada);
                        if (resultado_escolha > 4){
                            JOptionPane.showMessageDialog(null, "Opcao Invalida");
                            break;
                        }else if (resultado_escolha == 0){
                            break;
                        }
                        entrada.Entrada(resultado_escolha);
                        TelaSecundaria(entrada);
                        break;
                    case 2:
                        Saida saida = new Saida();
                        saida.Saida(0);
                        resultado_escolha = TelaDeEscolha(saida);
                        if (resultado_escolha > 4){
                            JOptionPane.showMessageDialog(null, "Opcao Invalida");
                            break;
                        }else if (resultado_escolha == 0){
                            break;
                        }
                        saida.Saida(resultado_escolha);
                        TelaSecundaria(saida);
                        break;
                    case 3:
                        Relatorio relatorio = new Relatorio();
                        relatorio.ConfiguraTela();
                        resultado_escolha = TelaDeEscolha(relatorio);
                        if (resultado_escolha > 4){
                            JOptionPane.showMessageDialog(null, "Opcao Invalida");
                            break;
                        }else if (resultado_escolha == 0){
                            break;
                        }
                        break;
                    case 0:
                        processo = 0;
                        System.out.println("Finalizando Programa");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcao Invalida");
                        break;
                }
            } catch (Exception e){
                System.out.println("Error " + e);

            }finally {

            }
        }

    }

    private int TelaDeEscolha(LayoutBase object) {
        Telas telas = new Telas();
        int escolha = telas.TelaDeEscolha(object);
        System.out.println("Voltou"); //TODO APAGAR
        return escolha;
    }

    private void TelaSecundaria(LayoutBase object){ ;
        Telas telas = new Telas();
        telas.TelaComCampos(object);
        while (telas.getEspera() == 1){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Esperando");
        }
        int a = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
        if (a != 0 ){
            processo = 0;
            System.out.println("Finalizando Programa");
        }
    }
}