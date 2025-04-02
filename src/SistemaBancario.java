import java.util.Scanner;

public class SistemaBancario {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("\n---- Sistema Bancário ----");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Corrente Premium");
            System.out.println("3. Conta Empresarial");
            System.out.println("4. Conta Poupança");
            System.out.println("5. Conta Poupança Estudantil");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    menuContaCorrente();
                    break;
                case 2:
                    menuContaCorrentePremium();
                    break;
                case 3:
                    menuContaEmpresarial();
                    break;
                case 4:
                    menuContaPoupanca();
                    break;
                case 5:
                    menuContaPoupancaEstudantil();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return; // Finaliza o programa
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaCorrente() {
        ContaCo conta = new ContaCo("Beltrano", 500, 1000);
        while (true) {
            System.out.println(conta.exibeSaldo());
            System.out.println("\n1. Depositar\n2. Sacar\n3. Exibir Saldo\n4. Exibir Limite Cheque Especial\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (!conta.sacar(valorSaque))
                        System.out.println("Saldo + limite cheque especial insuficiente!");
                    break;
                case 3:
                    System.out.println(conta.exibeSaldo());
                    break;
                case 4:
                    System.out.println(conta.exibeLimiteChequeEspecial());
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaCorrentePremium() {
        ContaCoPremium conta = new ContaCoPremium("Carlos", 1000, 1500, 5);
        while (true) {
            System.out.println(conta.exibeSaldo());

            System.out.println("\n1. Depositar\n2. Sacar\n3. Exibir Benefício Premium\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (!conta.sacar(valorSaque)) {
                        System.out.println("Saque não realizado.");
                    }
                    break;
                case 3:
                    System.out.println(conta.exibeBeneficioPremium());
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaEmpresarial() {
        ContaCoEmpresarial conta = new ContaCoEmpresarial("Empresa XYZ", 2000, 5000, 2);
        while (true) {
            System.out.println(conta.exibeSaldo());

            System.out.println("\n1. Depositar\n2. Sacar\n3. Solicitar Empréstimo\n4. Exibir Saldo\n5. Exibir Cheque Especial\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (!conta.sacar(valorSaque)) {
                        System.out.println("Saque não realizado.");
                    }
                    break;
                case 3:
                    System.out.print("Valor do empréstimo: ");
                    double valorEmprestimo = scanner.nextDouble();
                    if (!conta.solicitaEmprestimo(valorEmprestimo)) {
                        System.out.println("Empréstimo negado!");
                    }
                    break;
                case 4:
                    System.out.println(conta.exibeSaldo());
                    break;
                case 5:
                    System.out.println(conta.exibeLimiteChequeEspecial());
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaPoupanca() {
        ContaPo conta = new ContaPo("Ana", 3000, 3);
        while (true) {
            System.out.println(conta.exibeSaldo());

            System.out.println("\n1. Depositar\n2. Sacar\n3. Aplicar Rendimento\n4. Exibir Saldo\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (!conta.sacar(valorSaque)) {
                        System.out.println("Saque não realizado.");
                    }
                    break;
                case 3:
                    conta.aplicarRendimento();
                    System.out.println("Rendimento aplicado!");
                    break;
                case 4:
                    System.out.println(conta.exibeSaldo());
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaPoupancaEstudantil() {
        ContaPoEstudantil conta = new ContaPoEstudantil("João", 1500, 2, 500);
        while (true) {
            System.out.println(conta.exibeSaldo());

            System.out.println("\n1. Depositar\n2. Sacar\n3. Exibir Limite de Isenção\n4. Exibir Saldo\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (!conta.sacar(valorSaque)) {
                        System.out.println("Saque não realizado.");
                    }
                    break;
                case 3:
                    System.out.println(conta.exibeLimiteIsencao());
                    break;
                case 4:
                    System.out.println(conta.exibeSaldo());
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
