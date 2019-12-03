import layouts.LayoutBase;
import layouts.GerenciadorAcaoTelas;
import layouts.Entrada;
import layouts.Relatorio;
import layouts.Saida;
import layouts.relatorio.RelatorioDoDia;
import model.beans.Produto;
import model.dao.EntradaDao;
import model.dao.SaidaDao;

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
                            case 4:
                                try {
                                    int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o N. do Aquivo"));
                                    EntradaDao entradaDao = new EntradaDao();
                                    int confirmacao = JOptionPane.showConfirmDialog(null, "Confirmar exclusao do documento: " + documento);
                                    if (confirmacao == 0 ){
                                        entradaDao.delete(documento);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Operacao abortada");
                                    }
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
                        saida.saida(0);
                        resultado_escolha = telaDeEscolha(saida);
                        switch (resultado_escolha){
                            case 0:
                                break;
                            case 1:
                                saida.saida(1);
                                telaDeCampos(saida);
                                break;
                            case 2:
                                try {
                                    int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o N. do Aquivo"));
                                    SaidaDao saidaDao = new SaidaDao();
                                    saida.saida(resultado_escolha);
                                    telaDeCampos(saida,saidaDao.selectDocumento(documento));
                                }catch (Exception e){
                                    JOptionPane.showMessageDialog(null, "Aquivo invalido");
                                }
                                break;
                            case 3:
                                try {
                                    int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o N. do Aquivo"));
                                    SaidaDao saidaDao = new SaidaDao();
                                    saida.saida(resultado_escolha);
                                    telaDeEscolha(saida,saidaDao.selectDocumento(documento));
                                }catch (Exception e){
                                    JOptionPane.showMessageDialog(null, "Aquivo invalido");
                                }
                                break;
                            case 4:
                                try {
                                    int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o N. do Aquivo"));
                                    SaidaDao saidaDao = new SaidaDao();
                                    int confirmacao = JOptionPane.showConfirmDialog(null, "Confirmar exclusao do documento: " + documento);
                                    if (confirmacao == 0 ){
                                        saidaDao.delete(documento);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Operacao abortada");
                                    }
                                }catch (Exception e){
                                    JOptionPane.showMessageDialog(null, "Aquivo invalido");
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcao Invalida");
                                break;
                        }
                        break;
                    case 3:
                        Relatorio relatorio = new Relatorio();
                        relatorio.relatorio(0);
                        resultado_escolha = telaDeEscolha(relatorio);
                        switch (resultado_escolha){
                            case 1:
                                RelatorioDoDia relatorioDoDia = new RelatorioDoDia();
                                JOptionPane.showMessageDialog(null,relatorioDoDia.gerarRelatorioDoDia());
                                break;
                            case 2:
                                try {
                                    relatorio.relatorio(2);
                                    telaDeCampos(relatorio);
                                }catch (Exception e){
                                    System.out.println(e);
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcao Invalida");
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
        GerenciadorAcaoTelas gerenciadorAcaoTelas = new GerenciadorAcaoTelas();
        int escolha = gerenciadorAcaoTelas.telaDeEscolha(object);
        System.out.println("Voltou"); //TODO APAGAR
        return escolha;
    }

    private void telaDeEscolha(LayoutBase object,Produto produto) {
        GerenciadorAcaoTelas gerenciadorAcaoTelas = new GerenciadorAcaoTelas();
        gerenciadorAcaoTelas.telaDeEscolha(object,produto);
        System.out.println("Voltou"); //TODO APAGAR
    }

    private void telaDeCampos(LayoutBase object){
        GerenciadorAcaoTelas gerenciadorAcaoTelas = new GerenciadorAcaoTelas();
        gerenciadorAcaoTelas.TelaComCampos(object);
        while (gerenciadorAcaoTelas.getEspera() == 1){
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
        GerenciadorAcaoTelas gerenciadorAcaoTelas = new GerenciadorAcaoTelas();
        gerenciadorAcaoTelas.TelaComCampos(object,produto);
        while (gerenciadorAcaoTelas.getEspera() == 1){
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