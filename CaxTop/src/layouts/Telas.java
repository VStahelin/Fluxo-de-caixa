package layouts;

import model.dao.EntradaDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;

public class Telas extends JFrame {
    EntradaDao entradaDao = new EntradaDao();
    private int espera = 1;
    private boolean validate = false;

    private JLabel menu_name,title, item_1_title, item_2_title, item_3_title, item_4_title, item_5_title;
    private JTextField item_1,item_2,item_3,item_4,item_5;
    private JButton back_option_value;
    private ArrayList valores_campos = new ArrayList();
    //Facilitador de alinhamento
    int yAxis = 15;
    int xAxis = 130;


    public void TelaComCampos(LayoutBase object){
        //Display Setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,260);

        title = new JLabel("XYZ COMERCIO DE PRODUTOS LTDA");
        title.setBounds(80 ,0 , 300,30);
        add(title);

        menu_name = new JLabel(object.getMenu_name());
        menu_name.setBounds(15 + xAxis,0 + yAxis, 200,30);
        add(menu_name);

        back_option_value = new JButton(object.getButton_value());//create button
        back_option_value.setBounds(55 + xAxis,160 + yAxis,100, 40);
        add(back_option_value);

        item_1_title  = new JLabel(object.getItem_1());
        item_1 = new JTextField();
        item_1_title.setBounds(15,30 + yAxis, 200,30);
        item_1.setBounds(10 + xAxis,30 + yAxis, 200,30);

        item_2_title = new JLabel(object.getItem_2());
        item_2 = new JTextField();
        item_2_title.setBounds(15,60 + yAxis, 200,30);
        item_2.setBounds(10 + xAxis,60 + yAxis, 200,30);

        item_3_title = new JLabel(object.getItem_3());
        item_3 = new JTextField();
        item_3_title.setBounds(15,90 + yAxis, 200,30);
        item_3.setBounds(10 + xAxis,90 + yAxis, 200,30);

        item_4_title = new JLabel(object.getItem_4());
        item_4 = new JTextField();
        item_4_title.setBounds(15,120 + yAxis, 200,30);
        item_4.setBounds(10 + xAxis,120 + yAxis, 200,30);

        int lastNullOptions =  object.getGetLastNullOptions();
        switch (lastNullOptions){
            case 4:
                add(item_1);
                add(item_1_title);
                break;
            case 3:
                add(item_1);add(item_2);
                add(item_1_title);add(item_2_title);
                break;
            case 2:
                add(item_1);add(item_2);add(item_3);
                add(item_1_title);add(item_2_title);add(item_3_title);
                break;
            case 1:
                add(item_1);add(item_2);add(item_3);add(item_4);
                add(item_1_title);add(item_2_title);add(item_3_title);add(item_4_title);
                break;
            case 0:
                break;

        }

        setLayout(null);
        setVisible(true);

            back_option_value.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    switch (object.getOperation_id()){
                        case 11:
                            try{
                                entradaDao.insert(Integer.parseInt(item_1.getText()),
                                        item_2.getText(),
                                        Date.valueOf(item_3.getText()),
                                        Double.parseDouble(item_4.getText()));
                                validate = true;
                            }catch (Exception e){
                                JOptionPane.showMessageDialog(null, "Dados Invalidos");
                            }
                            break;
                        case 12:
                            try{
                                entradaDao.update(Integer.parseInt(item_1.getText()),
                                        item_2.getText(),
                                        Date.valueOf(item_3.getText()),
                                        Double.parseDouble(item_4.getText()));
                                validate = true;
                            }catch (Exception e){
                                JOptionPane.showMessageDialog(null, "Dados Invalidos");
                            }
                            break;

                    }
                    if (validate == true){
                        setVisible(false);
                        espera = 0;
                    }
                }
            });

    }
    public int TelaDeEscolha(LayoutBase object){
        String mensagem = "XYZ COMERCIO DE PRODUTOS LTDA\n" + object.getMenu_name() + "\n";
        int lastNullOptions =  object.getGetLastNullOptions();

        switch (lastNullOptions){
            case 4:
                mensagem = mensagem + "1- " + object.getItem_1() + "\n";
                break;
            case 3:
                mensagem = mensagem + "1- " + object.getItem_1() + "\n";
                mensagem = mensagem + "2- " + object.getItem_2() + "\n";
                break;
            case 2:
                mensagem = mensagem + "1- " + object.getItem_1() + "\n";
                mensagem = mensagem + "2- " + object.getItem_2() + "\n";
                mensagem = mensagem + "3- " + object.getItem_3() + "\n";
                break;
            case 1:
                mensagem = mensagem + "1- " + object.getItem_1() + "\n";
                mensagem = mensagem + "2- " + object.getItem_2() + "\n";
                mensagem = mensagem + "3- " + object.getItem_3() + "\n";
                mensagem = mensagem + "4- " + object.getItem_4() + "\n";
                break;
            case 0:
                mensagem = mensagem + "1- " + object.getItem_1() + "\n";
                mensagem = mensagem + "2- " + object.getItem_2() + "\n";
                mensagem = mensagem + "3- " + object.getItem_3() + "\n";
                mensagem = mensagem + "4- " + object.getItem_4() + "\n";
                mensagem = mensagem + "5- " + object.getItem_5() + "\n";
                break;
        }

        mensagem = mensagem + "0 - Voltar";
        int escolha_tela = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem,"",1));

        return escolha_tela;
    }

    public int getEspera() {
        return espera;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }
}
