import javax.swing.*;
import java.awt.event.*;

public class MiniCalculator implements ActionListener{
    JFrame f;
    JTextField tf1, tf2;
    JLabel l;
    JButton b1, b2;
    public Main(){
        f = new JFrame("Mini Calculator");

        tf1 = new JTextField();
        tf1.setBounds(100, 50, 200, 40);

        tf2 = new JTextField();
        tf2.setBounds(100, 100, 200, 40);

        l = new JLabel("0.00");
        l.setBounds(100, 150, 200, 40);


        b1 = new JButton("+");
        b1.setBounds(100, 200, 100, 50);
        b1.addActionListener(this);
        
        b2 = new JButton("-");
        b2.setBounds(200, 200, 100, 50);
        b2.addActionListener(this);

        f.add(tf1);f.add(tf2);f.add(l);f.add(b1);f.add(b2);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        double c = 0;
        double a = Double.parseDouble(tf1.getText());
        double b = Double.parseDouble(tf2.getText());
        if(e.getSource() == b1){
            c = a + b;
        }
        else if(e.getSource() == b2){
            c = a - b;
        }
        l.setText(String.valueOf(c));
    }
    public static void main(String args[]){
        new MiniCalculator();
    }
}