import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MusicPlayer.playMusic();
        Menu app = new Menu();
        app.setVisible(true);
        app.setResizable(false);
        }
    }