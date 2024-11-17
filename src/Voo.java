import java.sql.Time;
import java.util.Date;

public class Voo {
    private int id;
    private String origem;
    private String destino;
    private Date data;
    private Time horario;
    private String companhiaAerea;
    // ... outros atributos e métodos
}
private static void listarVoos() {
    System.out.println("\n--- Voos Disponíveis ---");
    // Exemplo: Listar voos da classe Voo, assumindo que você tenha um método para isso
    Voo.listarVoosDisponiveis(); // Método que interage com o BD para listar os voos
}