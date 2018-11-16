/**
 * name: Simple login page
 * author: Roslin Mahmud Joy
 * date: 16-Nov-18
 */
import javax.swing.*;
import java.awt.event.*;
public class Login{
    JFrame f;
    JLabel un, pd, data;
    JTextField tf;
    JPasswordField pf;
    JButton b;
    public Login(){
        f = new JFrame("Login");

        un = new JLabel("Username:");
        un.setBounds(20, 20, 80, 30);
        pd = new JLabel("Password:");
        pd.setBounds(20, 70, 80, 30);

        tf = new JTextField();
        tf.setBounds(100, 20, 200, 30);
        pf = new JPasswordField();
        pf.setBounds(100, 70, 200, 30);

        data = new JLabel();
        data.setBounds(20, 150, 360, 30);

        b = new JButton("Login");
        b.setBounds(100, 110, 80, 30);
        b.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String show = "Username " + tf.getText();
                show += ", Password: " + new String(pf.getPassword());
                data.setText(show);
            }
        });

        f.add(tf);
        f.add(pf);
        f.add(b);
        f.add(data);
        f.add(pd);
        f.add(un);

        f.setSize(400, 300);
        f.setLayout(null);
        
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
}