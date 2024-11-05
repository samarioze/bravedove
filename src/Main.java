import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        int boardWidth = 1000;
        int boardHeight = 562;

        JFrame frame = new JFrame("Brave Dove");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BraveDove braveDove = new BraveDove();
        frame.add(braveDove);
        frame.pack();
        braveDove.requestFocus();
        frame.setVisible(true);
        Sound.playSound("C:\\Users\\matebook\\IdeaProjects\\bravedove\\src\\soundtrack.wav").join();//Music
        }
    }