import layouts.LayoutBase;
import layouts.Telas;
import layouts.Entrada;
import layouts.relatorios.Relatorio;
import layouts.Saida;
import model.beans.Produto;
import model.dao.EntradaDao;

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
                        entrada.entrada(0);
                        resultado_escolha = telaDeEscolha(entrada);
                        switch (resultado_escolha){
                            case 0:
                                break;
                            case 1:
                                entrada.entrada(1);
                                telaDeCampos(entrada);
                                break;
                            case 2:
                                try {
                                    int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o N. do Aquivo"));
                                    EntradaDao entradaDao = new EntradaDao();
                                    entrada.entrada(resultado_escolha);
                                    telaDeCampos(entrada,entradaDao.selectDocumento(documento));
                                }catch (Exception e){
                                    JOptionPane.showMessageDialog(null, "Aquivo invalido");
                                }
                                break;
                            case 3:
                                try {
                                    int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o N. do Aquivo"));
                                    EntradaDao entradaDao = new EntradaDao();
                                    entrada.entrada(resultado_escolha);
                                    telaDeEscolha(entrada,entradaDao.selectDocumento(documento));
                                }catch (Exception e){
                                    JOptionPane.showMessageDialog(null, "Aquivo invalido");
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcao Invalida");
                                break;
                        }
                        break;
                    case 2:
                        Saida saida = new Saida();
                        saida.Saida(0);
                        resultado_escolha = telaDeEscolha(saida);
                        if (resultado_escolha > 4){
                            JOptionPane.showMessageDialog(null, "Opcao Invalida");
                            break;
                        }else if (resultado_escolha == 0){
                            break;
                        }
                        saida.Saida(resultado_escolha);
                        telaDeCampos(saida);
                        break;
                    case 3:
                        Relatorio relatorio = new Relatorio();
                        relatorio.ConfiguraTela();
                        resultado_escolha = telaDeEscolha(relatorio);
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

    private int telaDeEscolha(LayoutBase object) {
        Telas telas = new Telas();
        int escolha = telas.telaDeEscolha(object);
        System.out.println("Voltou"); //TODO APAGAR
        return escolha;
    }

    private void telaDeEscolha(LayoutBase object,Produto produto) {
        Telas telas = new Telas();
        telas.telaDeEscolha(object,produto);
        System.out.println("Voltou"); //TODO APAGAR
    }

    private void telaDeCampos(LayoutBase object){
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
    private void telaDeCampos(LayoutBase object, Produto produto){
        Telas telas = new Telas();
        telas.TelaComCampos(object,produto);
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