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

![Menu Inicial](https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/menu%20inicial.png)

### Menu 1 - Criar Conta

<img src="https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/1%20-%20criar%20conta.png" alt="CriarConta" width="700"/>

### Menu 2 - Criar Investimento
<img src="https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/2%20criar%20um%20investimento.png" alt="CrairInvestimento" width="700"/>

### Menu 4 - Deposito
<img src="https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/4-deposito.png" alt="CrairInvestimento" width="700"/>

### Menu 9 - Listar Contas
<img src="https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/9%20listar%20contas.png" alt="CrairInvestimento" width="700"/>

### Menu 11 - Listar Carteiras de Investimento
<img src="https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/11%20listar%20carteira%20de%20investimento.png" alt="CrairInvestimento" width="700"/>

### Menu 13 - Historico da Conta
<img src="https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/13%20historico%20da%20conta.png" alt="CrairInvestimento" width="700"/>



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

![Estrutura do Projeto](https://github.com/Evertonferrg/DIO_desafio_SistemaBancarioBasico/blob/main/src/img/estruturado%20projeto.png))



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
