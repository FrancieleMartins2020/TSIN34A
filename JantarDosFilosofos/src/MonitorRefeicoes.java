public class MonitorRefeicoes extends Thread { 
    private Filosofo[] filosofos;
    private static final int MAX_REFEICOES = 1;

    public MonitorRefeicoes(Filosofo[] filosofos) {
        this.filosofos = filosofos;
    }

    @Override
    public void run() {
        boolean todosComeram = false;

        while (!todosComeram) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }

            todosComeram = true; // presumimos que todos já comeram

            for (Filosofo f : filosofos) {
                //System.out.println("Filosofo " + f.getFilosofo() + " refeicoes: " + f.getQtdRefeicoes());
                if (f.getQtdRefeicoes() < MAX_REFEICOES) {
                    todosComeram = false; // algum ainda não comeu o suficiente
                    break;
                }
            }
        }

        System.out.println("Todos os filósofos comeram pelo menos " + MAX_REFEICOES + " vezes. Parando todos...");

        for (Filosofo f : filosofos) {
            f.parar();
        }
    }
}