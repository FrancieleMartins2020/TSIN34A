# 🧠🍝 Jantar dos Filósofos - Programação Concorrente

![image](https://github.com/user-attachments/assets/52871cf5-e547-4a03-8063-d714b3be071b)



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
java Jantar
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
Filosófo 0 Garfo esquerda:  0 Garfo direita: 1
Filosófo 2 Garfo esquerda:  2 Garfo direita: 3
Filosofo 0 liberou os garfos: 0 e 1
Filosófo 4 Garfo esquerda:  4 Garfo direita: 0
Filosofo 2 liberou os garfos: 2 e 3
Filosófo 1 Garfo esquerda:  1 Garfo direita: 2
Filosofo 4 liberou os garfos: 4 e 0
Filosófo 3 Garfo esquerda:  3 Garfo direita: 4
Filosofo 1 liberou os garfos: 1 e 2
Filosofo 3 liberou os garfos: 3 e 4
Todos os filósofos comeram pelo menos 1 vezes. Parando todos...

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
│   ├── Jantar.java         // Classe principal e interface
│   ├── Filosofo.java       // Classe que representa cada filósofo (thread)
│   ├── Garfos.java          // Classe para controle dos garfos (recursos) - Gerencia os filósofos, garfos 
├── Imagens/                // Recursos gráficos
├── README.md               // Documentação
```

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se livre para abrir issues e pull requests.

A referência para criar essa solução foi: https://github.com/daniel-2010/jantar-dos-filosofos
