import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicial extends JFrame implements ActionListener {
    private JButton jButton;

    public PaginaInicial() {
        setTitle("Entrar");

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        jButton = new JButton("Entrar");
        jButton.setBounds(350, 400, 100, 20);
        jButton.setFont(new Font("Arial", Font.BOLD, 15));
        jButton.setForeground(new Color(255, 255, 255));
        jButton.setBackground(new Color(11, 59, 130));

        add(jButton);

        // Adiciona o ActionListener ao botão
        jButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {
            // Cria e exibe a nova janela
            new Reserva();
            dispose(); // Fecha a janela atual, se desejado
        }
    }

    public static void main(String[] args) {
        new PaginaInicial();
    }
}