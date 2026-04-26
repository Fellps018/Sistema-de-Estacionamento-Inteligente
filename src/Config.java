import java.util.InputMismatchException;
import java.util.Scanner;
import Local.Estacionamento;

public class Config {

    Scanner input = new Scanner(System.in);
    Estacionamento estacionamento = new Estacionamento();

    public void start() {
        while (true) {
            System.out.println("|===================================|");
            System.out.println("|=============Bem-Vindo=============|");
            System.out.println("|+++++++++++++++++++++++++++++++++++|");
            System.out.println("|++ O Que Gostaria?               ++|");
            System.out.println("|+++++++++++++++++++++++++++++++++++|");
            System.out.println("|1 - Estacionar                     |");
            System.out.println("|2 - Retirar                        |");
            System.out.println("|+++++++++++++++++++++++++++++++++++|");
            System.out.println("|===================================|");

            int opcao;
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção Inválida. Por favor, insira 1 ou 2.");
                input.next(); 
                continue;
            }

            switch (opcao) {
                case 1:
                    estacionarCarro();
                    break;
                case 2:
                    retirarCarro();
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        }
    }

    public void estacionarCarro() {
        System.out.print("Adicione a placa do seu Veiculo: ");
        String placa = input.next();
        System.out.print("O seu veiculo é um carro, caminhão ou moto? ");
        String type = input.next();
        estacionamento.entrada(placa, type);
    }

    public void retirarCarro() {
        System.out.print("Qual a placa do seu veiculo? ");
        String placa = input.next();
        estacionamento.saida(placa);
    }
}