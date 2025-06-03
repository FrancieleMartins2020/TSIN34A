public class MonitorRefeicoes implements Runnable {
    private volatile int qtdRefeicoes = 0;
    private boolean running = true;

    public void setQtdRefeicoes(int qtd) {
        this.qtdRefeicoes = qtd;
    }

    @Override
    public void run() {
        while (running) {
            if (qtdRefeicoes >= 5) {
                System.out.println("qtdRefeicoes chegou a 5! Encerrando...");
                // Executa ação, por exemplo:
                System.exit(0);
                running = false; // para o loop, opcional após exit
            }
            try {
                Thread.sleep(100);  // espera 100ms antes de checar de novo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
