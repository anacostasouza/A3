  import java.sql.*;
        import java.util.Scanner;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    // Construtor
    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    // Método para cadastrar um novo usuário
    public static boolean cadastrarUsuario(String nome, String email, String telefone, String senha) {
        String sql = "INSERT INTO usuarios (nome, email, telefone, senha) VALUES (?, ?, ?, ?)";
        String senhaHash = HashUtils.hashPassword(senha); // Hash da senha antes de salvar

        try (Connection connection = ConexaoBD.connection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.setString(4, senhaHash);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    // Método para realizar login
    public static boolean realizarLogin(String email, String senha) {
        String sql = "SELECT senha FROM usuarios WHERE email = ?";

        try (Connection connection = ConexaoBD.connection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String senhaHash = resultSet.getString("senha");
                return HashUtils.verifyPassword(senha, senhaHash); // Verifica a senha
            } else {
                System.out.println("E-mail não encontrado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar login: " + e.getMessage());
            return false;
        }
    }

    // Método para recuperar senha
    public static boolean recuperarSenha(String email, String novaSenha) {
        String sql = "UPDATE usuarios SET senha = ? WHERE email = ?";
        String senhaHash = HashUtils.hashPassword(novaSenha); // Hash da nova senha

        try (Connection connection = ConexaoBD.connection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, senhaHash);
            stmt.setString(2, email);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar senha: " + e.getMessage());
            return false;
        }
    }

    // Método auxiliar para verificar se o e-mail já está cadastrado
    public static boolean emailJaCadastrado(String email) {
        String sql = "SELECT id FROM usuarios WHERE email = ?";

        try (Connection connection = ConexaoBD.connection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next(); // Retorna true se o e-mail já existir
        } catch (SQLException e) {
            System.out.println("Erro ao verificar e-mail: " + e.getMessage());
            return false;
        }
    }
}
