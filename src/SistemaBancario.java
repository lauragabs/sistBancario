import java.util.Scanner;

public class SistemaBancario {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("\n---- Sistema Bancário ----");
            System.out.println("1. Conta Bancária");
            System.out.println("2. Conta Corrente");
            System.out.println("3. Conta Corrente Premium");
            System.out.println("4. Conta Empresarial");
            System.out.println("5. Conta Poupança");
            System.out.println("6. Conta Poupança Estudantil");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> menuContaBancaria();
                case 2 -> menuContaCorrente();
                case 3 -> menuContaCorrentePremium();
                case 4 -> menuContaEmpresarial();
                case 5 -> menuContaPoupanca();
                case 6 -> menuContaPoupancaEstudantil();
                case 0 -> {
                System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaBancaria() {
        ContaBancaria conta = new ContaBancaria("Fulano", 1000);
        while (true) {
            System.out.println("\n1. Depositar\n2. Sacar\n3. Exibir Saldo\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do depósito: ");
                    double valor = scanner.nextDouble();
                    conta.depositar(valor);
                }
                case 2 -> {
                    System.out.print("Valor do saque: ");
                    double valor = scanner.nextDouble();
                    try {
                        if (!conta.sacar(valor))
                        throw new MinhasExcecoes("Saldo insuficiente para saque!");
                    } catch (MinhasExcecoes e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> System.out.println(conta.exibeSaldo());
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaCorrente() {
        ContaCo conta = new ContaCo("Beltrano", 500, 1000);
        while (true) {
            System.out.println("\n1. Sacar\n2. Exibir Saldo\n3. Exibir Limite Cheque Especial\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do saque: ");
                    double valor = scanner.nextDouble();
                    try {
                        if (!conta.sacar(valor))
                        throw new MinhasExcecoes("Saldo + limite cheque especial insuficiente!");
                    } catch (MinhasExcecoes e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> System.out.println(conta.exibeSaldo());
                case 3 -> System.out.println(conta.exibeLimiteChequeEspecial());
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaCorrentePremium() {
        ContaCoPremium conta = new ContaCoPremium("Carlos", 1000, 1500, 5);
        while (true) {
            System.out.println("\n1. Sacar\n2. Exibir Benefício\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do saque: ");
                    double valor = scanner.nextDouble();
                    if (!conta.sacar(valor)) {
                        System.out.println("Saque não realizado.");
                    }
                }
                case 2 -> System.out.println(conta.exibeBeneficioPremium());
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaEmpresarial() {
        ContaCoEmpresarial conta = new ContaCoEmpresarial("Empresa XYZ", 2000, 5000, 2);
        while (true) {
            System.out.println("\n1. Solicitar Empréstimo\n2. Exibir Saldo\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do empréstimo: ");
                    double valor = scanner.nextDouble();
                    if (!conta.solicitaEmprestimo(valor)) {
                        System.out.println("Empréstimo negado!");
                    }
                }
                case 2 -> System.out.println(conta.exibeSaldo());
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaPoupanca() {
        ContaPo conta = new ContaPo("Ana", 3000, 3);
        while (true) {
            System.out.println("\n1. Aplicar Rendimento\n2. Exibir Saldo\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;
            switch (opcao) {
                case 1 -> {
                    conta.aplicarRendimento();
                    System.out.println("Rendimento aplicado!");
                }
                case 2 -> System.out.println(conta.exibeSaldo());
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuContaPoupancaEstudantil() {
        ContaPoEstudantil conta = new ContaPoEstudantil("João", 1500, 2, 500);
        while (true) {
            System.out.println("\n1. Sacar\n2. Exibir Limite de Isenção\n3. Exibir Saldo\n0. Voltar");
            int opcao = scanner.nextInt();
            if (opcao == 0) break;
            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do saque: ");
                    double valor = scanner.nextDouble();
                    try {
                        if (!conta.sacar(valor))
                            throw new MinhasExcecoes("Saldo insuficiente para saque!");
                    } catch (MinhasExcecoes e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> System.out.println(conta.exibeLimiteIsencao());
                case 3 -> System.out.println(conta.exibeSaldo());
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
