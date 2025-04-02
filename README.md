# Sistema Bancário 

Este projeto implementa um sistema bancário em Java com diferentes tipos de contas. Cada conta possui funcionalidades específicas, como saques, depósitos, exibição de saldo e outros recursos exclusivos.

- Desenvolvido para fins educativos como exemplo de herança e sobrescrita em Java.

## **Principais Funcionalidades**

- Depósito em diferentes tipos de contas.

- Saques com validação de saldo e regras específicas por tipo de conta.

- Aplicação de rendimento em contas poupança.

- Cashback em contas premium.

- Empréstimos em contas empresariais.

- Tratamento de exceções personalizadas com a classe MinhasExcecoes.

## Estrutura do Projeto

1. **ContaBancaria**: Classe base que representa uma conta genérica.
    - Atributos: titular (String), saldo (double).
    - Métodos: depositar(double), sacar(double), exibeSaldo().

2. **ContaCo**: Conta corrente com limite de cheque especial.
    - Atributos: limiteChequeEspecial (double).
    - Métodos: sacar(double) (considera o limite), exibeLimiteChequeEspecial().

3. **ContaPo**: Conta poupança com rendimento.
    - Atributos: taxaRendimento (double).
    - Métodos: aplicarRendimento(), exibeSaldo() (sobrescrito).

4. **ContaCoPremium**: Conta corrente premium com cashback em saques.
    - Atributos: cashBackPercentual (double).
    - Métodos: sacar(double) (com cashback), exibeBeneficioPremium().

5. **ContaCoEmpresarial**: Conta corrente empresarial com opção de empréstimos.
    - Atributos: taxaJurosEmprestimo (double).
    - Métodos: solicitaEmprestimo(double), exibeSaldo() (sobrescrito).

6. **ContaPoEstudantil**: Conta poupança estudantil com isenção de taxas.
    - Atributos: limiteIsencaoTaxa (double).
    - Métodos: sacar(double) (com isenção), exibeLimiteIsencao().

7. **SistemaBancario**: Classe principal que gerencia o sistema e exibe menus de interação.
    - Métodos: main(), menu(), menus específicos para cada tipo de conta (ex: `menuContaEmpresarial()`).

8. **MinhasExcecoes**: Classe de exceção personalizada para tratar operações inválidas.

