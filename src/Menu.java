import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame {
    JTextField input = new JTextField("", 5);
    JLabel label = new JLabel("Your Name:");
    public Menu(){
        super("GameMenu");
        this.setBounds(650, 400, 250, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,1,1,1));

        container.add(label);
        container.add(input);
        JButton buttonStart = new JButton("Start game");
        buttonStart.addActionListener(new StartGame());
        container.add(buttonStart);
        JButton buttonScore = new JButton("Scoreboard");
        container.add(buttonScore);
        JButton buttonAbout = new JButton("About");
        container.add(buttonScore);
        JButton buttonExit = new JButton("Exit");
        buttonExit.addActionListener(new ExitGame());
        container.add(buttonExit);
    }

    class ExitGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            System.exit(0);
        }
    }

    class StartGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {

            int boardWidth = 1000;
            int boardHeight = 562;

            JFrame frame = new JFrame("Brave Dove");

            frame.setSize(boardWidth, boardHeight);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            BraveDove braveDove = new BraveDove();
            frame.add(braveDove);
            frame.pack();
            braveDove.requestFocus();
            frame.setVisible(true);
        }
    }
}
