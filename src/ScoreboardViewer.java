import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardViewer extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    private Connection conn;

    public ScoreboardViewer() {
        // Заголовок окна
        super("Scoreboard");

        // Настройка JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Создание таблицы для отображения данных
        String[] columns = {"ID", "User", "Score"};
        Object[][] data = getScoreboardData();

        table = new JTable(data, columns);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    private Object[][] getScoreboardData() {
        List<Object[]> dataList = new ArrayList<>();

        try {
            // Подключение к базе данных SQLite
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");

            // Выполнение запроса
            String sql = "SELECT * FROM scoreboard";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Обработка всех строк ResultSet
            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getInt("id");
                row[1] = rs.getString("user");
                row[2] = rs.getInt("score");
                dataList.add(row);
            }

            // Закрытие ресурсов
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Преобразование списка в массив для JTable
        return dataList.toArray(new Object[0][3]);
    }

    public void addRecord(String name, int score) {
        try {
            // Подключаемся к базе данных
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");

            // Создаем SQL-запрос на добавление записи
            String sql = "INSERT INTO scoreboard (name, score) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, score);

            // Выполняем запрос
            pstmt.executeUpdate();

            // Закрываем соединение
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
