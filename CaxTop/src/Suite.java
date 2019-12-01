import layouts.TesteInput;
import layouts.entrada.Entrada;
import layouts.LayoutBase;
import layouts.Telas;
import layouts.entrada.Inclusao;

import javax.swing.*;
import java.util.ArrayList;

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
                    TelaDeEscolha(entrada);
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
            System.out.println(e);
        }
        return escolha_tela;
    }

    private int TelaDeEscolha(LayoutBase object) {
        Telas telas = new Telas();
        int escolha = telas.TelaDeEscolha(object);
        System.out.println("Voltou"); //TODO APAGAR
        return escolha;
    }

    public ArrayList TelaSecundaria(LayoutBase object){
        ArrayList aa = new ArrayList();
        Telas telas = new Telas();
        telas.TelaComCampos(object);
        System.out.println("Voltou"); //TODO Apagar
        return aa;
    }
}