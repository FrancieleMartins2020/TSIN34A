# 🧠🍝 Jantar dos Filósofos - Programação Concorrente

![image](https://github.com/user-attachments/assets/2f7e653b-fc42-482e-9474-52f7815c2957)


## 📜 Descrição

Este projeto implementa a clássica **solução do problema do Jantar dos Filósofos**, um dos problemas mais conhecidos da **Programação Concorrente**. O programa foi desenvolvido na linguagem **Java**, utilizando **threads** e **sincronização** para resolver os desafios de deadlock, starvation e concorrência.

Incluí também uma **interface gráfica intuitiva** para acompanhar visualmente o estado dos filósofos e dos garfos, além de uma saída no **console** que detalha as transições de estado em tempo real.

## 🎯 Objetivos do Projeto

* Demonstrar conceitos de **threads**, **locks** e **sincronização**.
* Resolver os problemas de concorrência como **deadlock**, **starvation** e **race conditions**.
* Fornecer uma ferramenta visual e textual para análise e compreensão do comportamento do problema.

## 🚀 Tecnologias Utilizadas

* ☕ **Java**
* 🧵 **Programação concorrente (threads)**
* 🖼️ **Interface Gráfica com Java Swing**
* 📜 **Saída no Console para acompanhamento textual**

## 🔧 Como Executar

1. Clone este repositório:

```bash
git clone https://github.com/FrancieleMartins2020/TSIN34A.git
```

2. Compile o projeto:

```bash
javac *.java
```

3. Execute o programa:

```bash
java Main
```

## 🎨 Interface Gráfica

A interface exibe:

* Uma mesa redonda com 5 filósofos.
* Pratos representando os recursos compartilhados (os garfos estão entre os pratos).
* Filósofos alternando entre os estados:

  * **Pensando** 💭
  * **Com Fome** 🍴
  * **Comendo** 🍝

Além da interface gráfica, o console mostra mensagens como:

```
Filósofo 1 está pensando.
Filósofo 1 está com fome.
Filósofo 1 começou a comer.
Filósofo 1 terminou de comer e voltou a pensar.
```

## 🏛️ Sobre o Problema do Jantar dos Filósofos

O problema descreve cinco filósofos que estão sentados ao redor de uma mesa, intercalados por garfos. Para comer, um filósofo precisa segurar **dois garfos** (o da sua esquerda e o da sua direita). O problema é uma metáfora para recursos compartilhados em sistemas concorrentes.

Desafios solucionados:

* 🛑 **Deadlock:** Todos pegam um garfo e ficam esperando indefinidamente.
* ⏳ **Starvation:** Alguns filósofos comem enquanto outros nunca conseguem os garfos.
* ⚙️ **Race Conditions:** Acesso concorrente aos garfos de maneira segura.

## 📚 Estrutura do Projeto

```
├── src/
│   ├── Main.java           // Classe principal
│   ├── Filosofo.java       // Classe que representa cada filósofo (thread)
│   ├── Garfo.java          // Classe para controle dos garfos (recursos)
│   └── Mesa.java           // Gerencia os filósofos, garfos e interface
├── imagens/                // Recursos gráficos
├── README.md               // Documentação
```

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se livre para abrir issues e pull requests.

Se quiser, posso gerar o arquivo `README.md` pronto para você. Deseja?
