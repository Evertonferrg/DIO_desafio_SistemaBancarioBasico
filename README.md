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
## Imagens do Projeto

![Menu Inicial](https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/menu%20inicial.png))

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
