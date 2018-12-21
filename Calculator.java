import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Calculator extends JFrame implements ActionListener, MouseListener{
    JPanel panel;
    JTextArea textArea;
    JButton numButton[], plusButton, minusButton, multiplyButton, divideButton, equalButton, clearBtn, backspaceBtn, pointBtn, offBtn;
    String val =  null,sign=null, equalSign = null;
    double value = 0, equalValue = 0;
    boolean checkPoint = true;
    boolean checkEqual = true;
    public Calculator(){
        super("Calculator");
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(50, 30, 250, 70);
        textArea.setEditable(false);
        panel.add(textArea);

        numButton = new JButton[10];

        clearBtn = new JButton("C");
        clearBtn.setBounds(50, 120, 50, 50);
        clearBtn.addActionListener(this);
        clearBtn.addMouseListener(this);
        panel.add(clearBtn);

        divideButton = new JButton("/");
        divideButton.setBounds(110, 120, 50, 50);;
        divideButton.addActionListener(this);
        divideButton.addMouseListener(this);
        panel.add(divideButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(170, 120, 50, 50);;
        multiplyButton.addActionListener(this);
        multiplyButton.addMouseListener(this);
        panel.add(multiplyButton);

        backspaceBtn = new JButton("<<");
        backspaceBtn.setBounds(230, 120, 50, 50);
        backspaceBtn.addActionListener(this);
        backspaceBtn.addMouseListener(this);
        panel.add(backspaceBtn);
        
        numButton[7] = new JButton("7");
        numButton[7].setBounds(50, 190, 50, 50);
        numButton[7].addActionListener(this);
        numButton[7].addMouseListener(this);
        panel.add(numButton[7]);

        numButton[8] = new JButton("8");
        numButton[8].setBounds(110, 190, 50, 50);
        numButton[8].addActionListener(this);
        numButton[8].addMouseListener(this);
        panel.add(numButton[8]);

        numButton[9] = new JButton("9");
        numButton[9].setBounds(170, 190, 50, 50);
        numButton[9].addActionListener(this);
        numButton[9].addMouseListener(this);
        panel.add(numButton[9]);

        plusButton = new JButton("+");
        plusButton.setBounds(230, 190, 50, 50);;
        plusButton.addActionListener(this);
        plusButton.addMouseListener(this);
        panel.add(plusButton);


        numButton[4] = new JButton("4");
        numButton[4].setBounds(50, 260, 50, 50);
        numButton[4].addActionListener(this);
        numButton[4].addMouseListener(this);
        panel.add(numButton[4]);

        numButton[5] = new JButton("5");
        numButton[5].setBounds(110, 260, 50, 50);
        numButton[5].addActionListener(this);
        numButton[5].addMouseListener(this);
        panel.add(numButton[5]);

        numButton[6] = new JButton("6");
        numButton[6].setBounds(170, 260, 50, 50);
        numButton[6].addActionListener(this);
        numButton[6].addMouseListener(this);
        panel.add(numButton[6]);

        minusButton = new JButton("-");
        minusButton.setBounds(230, 260, 50, 50);
        minusButton.addActionListener(this);
        minusButton.addMouseListener(this);
        panel.add(minusButton);

        numButton[1] = new JButton("1");
        numButton[1].setBounds(50, 330, 50, 50);
        numButton[1].addActionListener(this);
        numButton[1].addMouseListener(this);
        panel.add(numButton[1]);

        numButton[2] = new JButton("2");
        numButton[2].setBounds(110, 330, 50, 50);
        numButton[2].addActionListener(this);
        numButton[2].addMouseListener(this);
        panel.add(numButton[2]);

        numButton[3] = new JButton("3");
        numButton[3].setBounds(170, 330, 50, 50);
        numButton[3].addActionListener(this);
        numButton[3].addMouseListener(this);
        panel.add(numButton[3]);

        equalButton = new JButton("=");
        equalButton.setBounds(230, 330, 50, 120);
        equalButton.addActionListener(this);
        equalButton.addMouseListener(this);
        panel.add(equalButton);

        offBtn = new JButton("OFF");
        offBtn.setBounds(40, 400, 60, 50);
        offBtn.addActionListener(this);
        offBtn.addMouseListener(this);
        panel.add(offBtn);

        numButton[0] = new JButton("0");
        numButton[0].setBounds(110, 400, 50, 50);
        numButton[0].addActionListener(this);
        numButton[0].addMouseListener(this);
        panel.add(numButton[0]);

        pointBtn = new JButton(".");
        pointBtn.setBounds(170, 400, 50, 50);
        pointBtn.addActionListener(this);
        pointBtn.addMouseListener(this);
        panel.add(pointBtn);

        this.add(panel);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == offBtn){
            System.exit(0);
        }
        else if(e.getSource()==clearBtn){
            value = 0;
            val = null;
            sign = null;
            checkEqual = true;
            equalSign = null;
            equalValue = 0;
            textArea.setText("");
        }
        else if(e.getSource()==equalButton){
            if(checkEqual){
                if(sign == null){
                    evaluate();
                }
                else{
                    executeSign();
                    equalSign = sign;
                    sign = null;
                }
                checkEqual = false;
            }
            else{
                executeEqualSign();
            }
            textArea.setText(String.valueOf(value) + "\n                    "+String.valueOf(value));
        }
        else if(e.getSource()==plusButton){
            if(sign == null){
                evaluate();
            }
            else{
                this.executeSign();
            }
            checkEqual = true;
            sign = "+";
            textArea.setText("\n                    "+String.valueOf(value));
        }
        else if(e.getSource()==minusButton){
            if(sign == null){
                evaluate();
            }
            else{
                this.executeSign();
            }
            checkEqual = true;
            sign = "-";
            textArea.setText("\n                    "+String.valueOf(value));
        }
        else if(e.getSource()==divideButton){
            if(sign == null){
                evaluate();
            }
            else{
                this.executeSign();;
            }
            checkEqual = true;
            sign = "/";
            textArea.setText("\n                    "+String.valueOf(value));
        }
        else if(e.getSource()==multiplyButton){
            if(sign == null){
               evaluate();
            }
            else{
                this.executeSign();;
            }
            checkEqual = true;
            sign = "*";
            textArea.setText("\n                    "+String.valueOf(value));
        }
        else if(e.getSource()==pointBtn){
            if(checkPoint){
                if(val == null)
                    val = ".";
                else
                    val+=".";
                textArea.setText(val + "\n                    " + String.valueOf(value));
                checkPoint = false;
            }
        }
        else if(e.getSource()==backspaceBtn){
            if(val!=null){
                val = val.substring(0, val.length()-1);
                textArea.setText(val + "\n                    " + String.valueOf(value));
            }
        }
        else{
            for(int i=0;i<numButton.length;i++){
                if(e.getSource()==numButton[i]){
                    if(val == null)
                        val = numButton[i].getText();
                    else
                        val+=numButton[i].getText();
                    equalValue = Double.parseDouble(val);
                    textArea.setText(val + "\n                    " + String.valueOf(value));
    
                    break;
                }
            }  
        }  
    }

    private void evaluate(){
        if(val!=null)
            value=Double.parseDouble(val);
        val = null;
        checkPoint = true;
    }

    private void executeSign(){
        if(val != null){
            if(sign=="+"){
                value+=Double.parseDouble(val);
            }
            else if(sign=="-"){
                value-=Double.parseDouble(val);
            }
            else if(sign=="*"){
                value*=Double.parseDouble(val);
            }
            else if(sign=="/"){
                value/=Double.parseDouble(val);
            }
            val = null;
            checkPoint = true;
        }
    }

    private void executeEqualSign(){
        if(equalSign=="+"){
            value+=equalValue;
        }
        else if(equalSign=="-"){
            value-=equalValue;
        }
        else if(equalSign=="*"){
            value*=equalValue;
        }
        else if(equalSign=="/"){
            value/=equalValue;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    public static void main(String[] args) {
        new Calculator();
    }
}