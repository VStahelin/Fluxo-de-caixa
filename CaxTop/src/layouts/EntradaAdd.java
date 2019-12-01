package layouts;

import javax.swing.*;

public class EntradaAdd extends JFrame {
    JFrame f;
    public EntradaAdd(){


        JTextField t1;
        t1 = new JTextField("Welcome to Javatpoint.");
        t1.setBounds(10,10, 200,30);
        add(t1);

        JButton b=new JButton("click");//create button
        b.setBounds(130,100,100, 40);

        add(b);//adding button on frame
        setSize(400,500);
        setLayout(null);
        setVisible(true);
    }
}
