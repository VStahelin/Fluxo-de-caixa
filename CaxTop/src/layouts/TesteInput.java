package layouts;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TesteInput extends JFrame{
    private JPanel pa;
    private JTextField txConfianca;
    private JTextField txSuporte;
    private JButton botao;
    private Regra regra = new Regra();

    public TesteInput(){
        super("Teste");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pa = new JPanel();
        txConfianca = new JTextField(20);
        txSuporte = new JTextField(20);

        botao = new JButton("Fazer alguma coisa");

        pa.add(new JLabel("Confianca: "));
        pa.add(txConfianca);
        pa.add(new JLabel("Suporte: "));
        pa.add(txSuporte);
        pa.add(botao);

        getContentPane().add(pa);

        pack();

        botao.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                // verifica se os jtextfields estão preenchidos
                if ( (!txConfianca.getText().equals("")) && (!txSuporte.getText().equals("")) ){
                    regra.setConfianca(Double.parseDouble(txConfianca.getText()));
                    regra.setSuporte(Double.parseDouble(txSuporte.getText()));
                    regra.fazAlgumaCoisa();
                }else {
                    // se os jtextfields não estão preenchidos, exibe mensagem
                    JOptionPane.showMessageDialog(null, "JTextFields nao estao preenchidos");
                }
            }
        });
        setLayout(null);
        setVisible(true);
    }

    public static void main() {
        new TesteInput();

    }

    class Regra{
        private double suporte;
        private double confianca;

        public void setSuporte(double d){
            this.suporte = d;
        }

        public void setConfianca(double d){
            this.confianca = d;
        }

        public void fazAlgumaCoisa(){
            // faz uma coisa qualquer. No caso, uma soma de suporte e confianca
            JOptionPane.showMessageDialog(null, "Soma: " + (suporte + confianca));
        }
    }

    public static void main(String args[]){
        // quando trabalhar com Swing, é recomendável utilizar a thread do Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new TesteInput().setVisible(true);
            }
        });
    }
}