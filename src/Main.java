import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Bem-vindo ao Modo Aviao, vamos voar? ===");
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Usuario");
            System.out.println("2. Listar voos disponíveis");
            System.out.println("3. Reservar assento");
            System.out.println("4. Consultar reserva");
            System.out.println("5. Cancelar reserva");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("1 - Cadastrar Usuario");
                    System.out.println("2 - Login");
                    System.out.println("3 - Esqueci a senha");
                    System.out.println("4 - Sair");
                    int opcaoUsuario = 0;
                    opcaoUsuario = Scanner.nextInt();
                     switch (opcaoUsuario){
                         case 1:
                             Usuario.cadastrarUsuario();
                             Usuario.emailJaCadastrado();
                             break;
                         case 2:
                             Usuario.realizarLogin();
                             break;
                         case 3:
                             Usuario.recuperarSenha();
                             break;
                         case 4:
                             System.out.println("Saindo...");
                             break;
                         default:
                             System.out.println("Opcao Invalida!");
                             break;
                     }
                     break;
                case 2:
                    Voo.listarVoos();
                    break;
                case 3:
                    Reserva.reservarAssento(scanner);
                    break;
                case 4:
                    Reserva.consultarReserva(scanner);
                    break;
                case 5:
                    Reserva.cancelarReserva(scanner);
                    break;
                case 6:
                    System.out.println("Encerrando o sistema. Obrigado por usar o sistema de reservas do Modo Aviao!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }








