import layouts.Entrada;
import layouts.LayoutBase;
import layouts.Layouts;

import javax.swing.*;
public class Suite {

    public int escolha_tela(){
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
                    entrada.ConfiguraTela();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:

                    break;
                default:

            }
        } catch (Exception e){

        }
        return escolha_tela;
    }

}