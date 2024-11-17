import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Scanner;

public  class Reserva extends JFrame  {
    private int id;
    private Usuario usuario;
    private Voo voo;
    private Date dataReserva;
    private String status;

    public Reserva() {
        setTitle("Reservas");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Realizar reserva");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);


    }

}
   private static void consultarReserva(Scanner scanner) {
    System.out.println("\n--- Consultar Reserva ---");
    System.out.print("Informe o código da reserva: ");
    String codigoReserva = scanner.nextLine();

    // Exemplo: Buscar a reserva pela classe Reserva
    Reserva reserva = Reserva.consultarReserva(codigoReserva);
    if (reserva != null) {
        System.out.println("Detalhes da reserva:");
        System.out.println(reserva);
    } else {
        System.out.println("Reserva não encontrada.");
    }
}

    private static void cancelarReserva(Scanner scanner) {
    System.out.println("\n--- Cancelar Reserva ---");
    System.out.print("Informe o código da reserva: ");
    String codigoReserva = scanner.nextLine();

    // Exemplo: Cancelar reserva pela classe Reserva
    boolean sucesso = Reserva.cancelarReserva(codigoReserva);
    if (sucesso) {
        System.out.println("Reserva cancelada com sucesso!");
    } else {
        System.out.println("Falha ao cancelar a reserva. Verifique as informações e tente novamente.");
    }
}
}