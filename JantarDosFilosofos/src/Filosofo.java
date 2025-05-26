
//Classe Filosofo herda de Thread
public class Filosofo extends Thread 
{
	//Identificador único do filosofo que serão 5 então vai 0 até 4
	private int filosofo;
	//Apresenta o stus atual de cada filosófo ( 0 = pensando, 1 = comendo, 2 = esperando)
	private int status;
	//Referência do objeto principal jantar
	private Jantar jantarFilosofos;
	
	//Construtor da classe que recebe o identificador do filosofo e e a referencia a classe princial Jantar
	public Filosofo(int numeroFilosofo, Jantar jantar)
	{
		this.filosofo = numeroFilosofo;
		this.jantarFilosofos = jantar;
	}
	
	//Retorna o identificador do filosofo
	public int getFilosofo()
	{
		return filosofo;
	}
	
	//Realiza a atualização do status do filosofo e da imagem apresentada na aplicação
	public void setStatus(int statusFilosofo)
	{
		status = statusFilosofo;
		switch (statusFilosofo) 
		{
		case 0:
			//Pensar
			jantarFilosofos.SetInfo(filosofo, 0);
			break;
		case 1:
			//Comer
			jantarFilosofos.SetInfo(filosofo, 1);
			break;
		case 2:
			//Esperar
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
	
	//Este método é executado quando start() é chamado
	public void run()
	{
		//realiza um ciclo infinito
		while (true)
		{
			//Define o status como pensando
			setStatus(0);
			//Chama o método pesando
			pensando();
			//Tenta pegar os dois garfos
			jantarFilosofos.garfos.pegar(this);
			//Chama o método comendo
			comendo();
			//Libera os dois garfos após comer
			jantarFilosofos.garfos.liberar(this);
		}
	}
}