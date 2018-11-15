/**
 * name: IP Address Finder simple Java GUI Application
 * author: Roslin Mahmud Joy
 * date: 16-Nov-18
 */
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;

public class IPAddressFinder implements ActionListener{
    JLabel prompt, ipAddress;
    JFrame f;
    JTextField tf, tfIP;
    JButton b;
    JLabel l;
    public IPAddressFinder(){
        f = new JFrame("IP Address Finder");

        l = new JLabel("Enter the URL of the Host");
        l.setBounds(100, 50, 300, 30);

        tf = new JTextField();
        tf.setBounds(50, 80, 300, 40);

        tfIP = new JTextField();
        tfIP.setBounds(20, 130, 360, 50);
        tfIP.setEditable(false);

        b = new JButton("Find IP");
        b.setBounds(150, 200, 100, 50);
        b.addActionListener(this);

        f.add(l);
        f.add(tf);
        f.add(tfIP);
        f.add(b);

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String host = tf.getText();
        try{
            String ip = InetAddress.getByName(host).getHostAddress();
            tfIP.setText("IP Address of " + host + " is: " + ip);
        }catch(UnknownHostException uh){
            tfIP.setText(uh.getMessage());
        }
    }
    public static void main(String args[]){
        new IPAddressFinder();
    }
}