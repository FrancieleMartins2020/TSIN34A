//Classe Filosofo herda de Thread
public class Filosofo extends Thread 
{
	// contador de refeições
    private int qtdRefeicoes = 0;  
    private static final int MAX_REFEICOES = 1;

	//Identificador único do filosofo que serão 5 então vai 0 até 4
	private int filosofo;
	//Referência do objeto principal jantar
	private Jantar jantarFilosofos;
    private volatile boolean continuar = true;
	
	//Construtor da classe que recebe o identificador do filosofo e e a referencia a classe princial Jantar
	public Filosofo(int numeroFilosofo, Jantar jantar)
	{
		this.filosofo = numeroFilosofo;
		this.jantarFilosofos = jantar;
	}

    // Método para obter a quantidade de refeições feitas
    public int getQtdRefeicoes() {
        return qtdRefeicoes;
    }
    
	//Retorna o identificador do filosofo
	public int getFilosofo()
	{
		return filosofo;
	}
	
	//Realiza a atualização do status do filosofo e da imagem apresentada na aplicação
	public void setStatus(int statusFilosofo)
	{
		switch (statusFilosofo) 
		{
			case 0:
				//Pensando
				jantarFilosofos.SetInfo(filosofo, 0);
				break;
			case 1:
				//Comendo
				jantarFilosofos.SetInfo(filosofo, 1);
				break;
			case 2:
				//Esperando
				jantarFilosofos.SetInfo(filosofo, 2);
				break;
		}
	}
	
	//Este método é executado quando start() é chamado
	//O filosofo pode variar entre pensar,pegar garfo,comer e liberar o garfo sem definição prévia
	private void pensando()
	{ 
		try
		{
			//Tempo pré-defino para pensar
			Thread.sleep(2000);
		} catch (Exception e)
		{
		}
	}
	
	//Este método é executado quando start() é chamado
	private void comendo()
	{
		try
		{
			//Tempo pré-defino para comer
			Thread.sleep(2500);
		} catch (Exception e)
		{
		}
	}

    public void parar() {
        continuar = false;
        this.interrupt();
    }
    
	//Este método é executado quando start() é chamado
	public void run()
	{
        while (continuar && qtdRefeicoes < MAX_REFEICOES)
		{
			//Define o status como pensando
			setStatus(0);
			//Chama o método pensando
			pensando();
			//Tenta pegar os dois garfos
			jantarFilosofos.garfos.pegar(this);
			//Chama o método comendo
			comendo();
			// incrementa após comer
            qtdRefeicoes++;  
			//Libera os dois garfos após comer
			jantarFilosofos.garfos.liberar(this);			
		}
        setStatus(0); // Finaliza pensando (parado)
        
	}
}