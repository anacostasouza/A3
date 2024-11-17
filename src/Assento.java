import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Assento extends JFrame {
    private int id;
    private Voo voo;
    private boolean ocupado;
    // ... outros atributos e métodos

    public Assento() {
        setTitle("Nova Página");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JLabel label = new JLabel("Bem-vindo à Nova Página!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);

    }
}
    private static void reservarAssento(Scanner scanner) {
    System.out.println("\n--- Reservar Assento ---");
    System.out.print("Informe o ID do voo: ");
    int idVoo = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer
    System.out.print("Informe o número do assento: ");
    String numeroAssento = scanner.nextLine();

    // Exemplo: Interagir com as classes Reserva e Assento
    boolean sucesso = Reserva.reservarAssento(idVoo, numeroAssento);
    if (sucesso) {
        System.out.println("Reserva realizada com sucesso!");
    } else {
        System.out.println("Falha ao realizar a reserva. Verifique as informações e tente novamente.");
    }
}
