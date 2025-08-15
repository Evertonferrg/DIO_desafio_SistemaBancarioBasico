# 💰 Java Bank

**Java Bank** é uma aplicação em Java que simula operações bancárias e de investimentos, permitindo a criação e gerenciamento de contas, depósitos, transferências, e cálculo de rendimentos.  
O projeto foi desenvolvido com foco em **boas práticas de programação orientada a objetos**, uso de **Streams** e **estruturas de dados**, além de **tratamento de exceções** personalizadas.

---

## 📋 Funcionalidades

- Criar contas com chaves Pix.
- Depositar e sacar valores.
- Transferir valores entre contas.
- Registrar histórico de transações (`MoneyAudit`).
- Criar e gerenciar carteiras de investimento.
- Calcular rendimentos sobre investimentos.
- Listagem e consulta de contas e investimentos.
- Tratamento de exceções personalizadas:
    - `AccountNotFoundException`
    - `NotFundsEnoughException`

---

## 🛠️ Tecnologias Utilizadas

- **Java 21+**
- **Paradigma Orientado a Objetos**
- **Java Streams API**
- **List, ArrayList e Collections API**
- **Tratamento de Exceções**
- **Pacotes e Organização Modular**
- **UUID** para identificação única de transações
- **OffsetDateTime** para marcação temporal

---

## 📂 Estrutura do Projeto

java-bank/
├── README.md
├── pom.xml (se for Maven) ou build.gradle (se for Gradle)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/dio/java_bank/
│   │   │       ├── model/            # Classes de domínio
│   │   │       │   ├── AccountWallet.java
│   │   │       │   ├── InvestimentWallet.java
│   │   │       │   ├── Investment.java
│   │   │       │   ├── Money.java
│   │   │       │   ├── MoneyAudit.java
│   │   │       │   └── Wallet.java
│   │   │       │
│   │   │       ├── repository/       # Classes de persistência / gerenciamento de coleções
│   │   │       │   ├── AccountRepository.java
│   │   │       │   ├── InvestmentRepository.java
│   │   │       │   └── CommonsRepository.java
│   │   │       │
│   │   │       ├── exception/        # Exceções customizadas
│   │   │       │   ├── AccountNotFoundException.java
│   │   │       │   ├── NotFundsEnoughException.java
│   │   │       │   └── WalletNotFoundException.java
│   │   │       │
│   │   │       ├── Main.java         # Classe principal (console)
│   │   │       └── JavaBankApplication.java (se for Spring Boot)
│   │   │
│   │   └── resources/                # Configurações e arquivos de recursos
│   │       └── application.properties (se for Spring Boot)
│   │
│   └── test/
│       └── java/
│           └── br/com/dio/java_bank/
│               ├── model/            # Testes unitários de modelos
│               ├── repository/       # Testes unitários de repositórios
│               └── MainTest.java     # Testes gerais
└── target/ (ou build/)                # Gerado pelo Maven/Gradle



---

## 🚀 Como Executar

### Pré-requisitos
- **Java 21** ou superior instalado.
- **Maven** instalado (para build e execução).

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/java-bank.git
   cd java-bank
Informe as chaves pix (separadas por ','):
123,456,789
Informe o valor inicial de deposito:
1500
Conta criada: Wallet{service=ACCOUNT, money= R$15,00}
Selecione a operação desejada:
1 - Depositar
2 - Sacar
3 - Transferir
4 - Investir
5 - Consultar saldo


📈 O que foi feito no projeto

Implementação de modelos de domínio para contas, investimentos e histórico.

Uso de UUID para rastreamento único de transações.

Criação de exceções customizadas para cenários específicos.

Utilização de Streams API para manipulação de coleções de forma funcional.

Organização modular do código por pacotes.

Criação de método updateAmount para cálculo de rendimentos.

Estruturação para futura integração com persistência de dados.
