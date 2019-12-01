package layouts;

import javax.swing.*;

public class TelaSecundaria extends JFrame {
    JFrame f;
    public TelaSecundaria(LayoutBase object){
        int lastNullOptions =  object.getGetLastNullOptions();

        JLabel menu_name;
        JTextField item_1,item_2,item_3,item_4,item_5;
        JButton back_option_value;

        menu_name = new JLabel(object.getMenu_name());
        menu_name.setBounds(10,0, 200,30);

        item_1 = new JTextField(object.getItem_1());
        item_1.setBounds(10,30, 200,30);

        item_2 = new JTextField(object.getItem_2());
        item_2.setBounds(10,60, 200,30);

        item_3 = new JTextField(object.getItem_3());
        item_3.setBounds(10,90, 200,30);

        item_4 = new JTextField(object.getItem_4());
        item_4.setBounds(10,120, 200,30);

        item_5 = new JTextField(object.getItem_5());
        item_5.setBounds(10,150, 200,30);

        back_option_value = new JButton(object.getButton_value());//create button
        back_option_value.setBounds(55,160,100, 40);

        switch (lastNullOptions){
            case 4:
                add(menu_name);add(back_option_value);add(item_1);
                break;
            case 3:
                add(menu_name);add(back_option_value);add(item_1);add(item_2);
                break;
            case 2:
                add(menu_name);add(back_option_value);add(item_1);add(item_2);add(item_3);
                break;
            case 1:
                add(menu_name);add(back_option_value);add(item_1);add(item_2);add(item_3);add(item_4);
                break;
            case 0:
                add(menu_name);add(back_option_value);add(item_1);add(item_2);add(item_3);add(item_4);add(item_5);
                break;

        }

        setSize(230,250);
        setLayout(null);
        setVisible(true);
    }
}
