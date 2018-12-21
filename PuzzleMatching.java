import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PuzzleMatching extends JFrame implements ActionListener{
    JPanel panel, extraPanel;
    JLabel scoreJLabel, questionJLabel;
    int score = 500, indexI, indexJ,count = 0;
    JButton cardButton[][], yesButton, noButton;
    String text = null;
    public PuzzleMatching(){
        super("Puzzle Game");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 102));
        panel.setLayout(null);

        extraPanel = new JPanel();
        extraPanel.setLayout(null);

        questionJLabel = new JLabel("Do you want to Play Agin?");
        questionJLabel.setBounds(300, 100, 200, 30);
        extraPanel.add(questionJLabel);

        yesButton = new JButton("Yes");
        yesButton.setBounds(300, 200, 70, 30);
        yesButton.addActionListener(this);
        extraPanel.add(yesButton);

        noButton = new JButton("No");
        noButton.setBounds(390, 200, 70, 30);
        noButton.addActionListener(this);
        extraPanel.add(noButton);

        scoreJLabel = new JLabel("Score: " + score);
        scoreJLabel.setBounds(10, 10, 100, 30);
        panel.add(scoreJLabel);

        cardButton = new JButton[5][2];

        for(int i=0;i<5;i++){
            for(int j=0;j<2;j++){
                cardButton[i][j] = new JButton(String.valueOf(i+1));
                if((j&1) == 0){
                    cardButton[i][j].setBackground(new Color(0, 204, 102));
                    cardButton[i][j].setForeground(new Color(0, 204, 102));
                }
                else{
                    cardButton[i][j].setBackground(new Color(0, 255, 255));
                    cardButton[i][j].setForeground(new Color(0, 255, 255));
                }
                cardButton[i][j].setBounds(returnX(), returnY(), 60, 70);
                cardButton[i][j].addActionListener(this);
                panel.add(cardButton[i][j]);
            }
        }

        this.add(panel);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == noButton){
            System.exit(0);
        }
        else if(e.getSource() == yesButton){
            new PuzzleMatching();
            this.dispose();
        }
        boolean check = true;
        for(int i=0;i<5 && check;i++){
            for(int j=0;j<2 && check;j++){
                if(e.getSource() == cardButton[i][j]){
                    cardButton[i][j].setForeground(Color.black);
                    if(text == null){
                        text = cardButton[i][j].getText();
                        indexI = i;
                        indexJ = j;
                    }
                    else if(text.equals(cardButton[i][j].getText()) && j!=indexJ){
                        text = null;
                        cardButton[i][0].setVisible(false);
                        cardButton[i][1].setVisible(false);
                        score+=50;
                        scoreJLabel.setText("Score: " + score);
                        count++;
                        if(count == 5){
                            this.remove(panel);
                            this.add(extraPanel);
                            this.setTitle("Play Agin");
                        }
                    }
                    else{
                        text = null;
                        cardButton[i][j].setForeground(cardButton[i][j].getBackground());
                        cardButton[indexI][indexJ].setForeground(cardButton[indexI][indexJ].getBackground());
                        score-=50;
                        scoreJLabel.setText("Score: " + score);
                    }
                    check = false;
                }
            }

        }
    }

    int returnX(){
        Random r = new Random();
        return r.nextInt(700);
    }
    int returnY(){
        Random r = new Random();
        return r.nextInt(400);
    }

    public static void main(String[] args) {
        new PuzzleMatching();
    }
}