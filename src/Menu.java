import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Menu extends JFrame {
    boolean musicOn = true;
    JTextField input = new JTextField("", 5);
    JLabel label = new JLabel("Your Name:");
    public Menu(){
        super("GameMenu");
        this.setBounds(650, 400, 250, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8,1,1,1));

        container.add(label);
        container.add(input);
        JButton buttonStart = new JButton("Start game");
        buttonStart.addActionListener(new StartGame());
        container.add(buttonStart);
        JButton buttonScore = new JButton("Scoreboard");
        container.add(buttonScore);
        JButton buttonAbout = new JButton("About");
        buttonAbout.addActionListener(new About());
        container.add(buttonAbout);
        JButton buttonMusicOff = new JButton("Music Off");
        buttonMusicOff.addActionListener(new MusicOff());
        container.add(buttonMusicOff);
        JButton buttonMusicOn = new JButton("Music On");
        buttonMusicOn.addActionListener(new MusicOn());
        container.add(buttonMusicOn);
        JButton buttonExit = new JButton("Exit");
        buttonExit.addActionListener(new ExitGame());
        container.add(buttonExit);
    }
    class About implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String message = "Author: Aleksey Samarin\n" +
                    "Group: Б1-ИВЧТз-32\n" +
                    "\n" +
                    "The game Brave Dove was created for SSTU\n" +
                    "Discipline: Educational technological (design and technological) practice\n" +
                    "Teacher: Lieberman Elena Ivanovna";
            JOptionPane.showMessageDialog(null, message, "About", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ExitGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            System.exit(0);
        }
    }

    class MusicOff implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            musicOn = false;
            MusicPlayer.stopMusic();
            String messageMusicOff = "Music is OFF";
            JOptionPane.showMessageDialog(null, messageMusicOff, "Music Alert", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class MusicOn implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (musicOn) {
                String messagePlaying = "Music is playing";
                JOptionPane.showMessageDialog(null, messagePlaying, "Error turn on", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                musicOn = true;
                MusicPlayer.playMusic();
                String messageMusicOn = "Music is ON";
                JOptionPane.showMessageDialog(null, messageMusicOn, "Music Alert", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class StartGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String name = input.getText();
            if(name.trim().isEmpty()) {
                String messageError = "Your name is not provided. Please enter your name and then try again!";
                JOptionPane.showMessageDialog(null, messageError, "Error Name", JOptionPane.PLAIN_MESSAGE);
            }
            else {
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
}
