
package uasprakpbo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TodoDAO {
    private Connection connection;

    public TodoDAO() { 
        String url = "jdbc:mysql://localhost:3306/uasprakpbo";
        String username = "root"; 
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTodo(Todo todo) {
        String query = "INSERT INTO todos (todo, kategori, tanggal_selesai, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, todo.getTodo());
            statement.setString(2, todo.getKategori());
            statement.setString(3, todo.getTanggalSelesai());
            statement.setString(4, todo.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();

        String query = "SELECT * FROM todos";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTodo(resultSet.getString("todo"));
                todo.setKategori(resultSet.getString("kategori"));
                todo.setTanggalSelesai(resultSet.getString("tanggal_selesai"));
                todo.setStatus(resultSet.getString("status"));

                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todos;
    }

    public void updateTodo(Todo todo) {
        String query = "UPDATE todos SET todo=?, kategori=?, tanggal_selesai=?, status=? WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, todo.getTodo());
            statement.setString(2, todo.getKategori());
            statement.setString(3, todo.getTanggalSelesai());
            statement.setString(4, todo.getStatus());
            statement.setInt(5, todo.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTodo(int id) {

        String query = "DELETE FROM todos WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
