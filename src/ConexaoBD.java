import java.sql.*;
import java.util.ArrayList;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ArrayList<String> buscar(String sql) {
        ArrayList<String> resultados = new ArrayList<>();
        try (Connection connection = connection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                resultados.add(resultSet.getString("nome")); // Exemplo: ajuste conforme necessário
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar dados: " + e.getMessage());
        }
        return resultados;
    }

    public static boolean salvar(String sql, String valor) {
        try (Connection connection = connection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, valor);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
            return false;
        }
    }

    public static boolean atualizar(String sql) {
        return salvar(sql, null); // Exemplo, ajuste conforme necessário
    }

    public static boolean deletar(String sql) {
        return salvar(sql, null); // Exemplo, ajuste conforme necessário
    }
}
