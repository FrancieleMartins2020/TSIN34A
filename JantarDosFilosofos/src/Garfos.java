
public class Garfos 
{
	//Esse array representa que temos uma quantidade total de 6 garfos. 
	//Esta identificando a posição do garfo em uso como TRUE  e livre como FALSE.
	private boolean[] vet_garfos = new boolean[5]; 

	public Garfos() 
	{
	}
	
	//Método sincronizado: garante que somente um filósofo por vez execute a verificação e alteração do estado dos garfos.
	public synchronized void pegar(Filosofo filosofo) 
	{
		//variavel que define se o filosofo esta com garfo = Está (true)
		boolean estaComGarfo = true;
		//busca o filosofo e insere ele na variavel local;
		int numeroFilosofo;
		numeroFilosofo = filosofo.getFilosofo();
		
		//essa condição define que se pelo menos um dos garfos estiver ocupado, o filosofo não pode comer
		//vet_garfos[numeroFilosofo] - verifica se o garfo da esquerda está ocupado
		//vet_garfos[((numeroFilosofo + 1) % 5)]) - verifica se o garfo da direita está ocupado
		//Filósofo	Garfo à esquerda	Garfo à direita (com % 5)
		//0					0				(0 + 1) % 5 = 1
		//1					1				(1 + 1) % 5 = 2
		//2					2				(2 + 1) % 5 = 3
		//3					3				(3 + 1) % 5 = 4
		//4					4				(4 + 1) % 5 = 0 
		while (vet_garfos[numeroFilosofo] || vet_garfos[((numeroFilosofo + 1) % 5)]) 
		{
			//Seta o estatus como Esperar
			filosofo.setStatus(2);
			try 
			{
				//Espera até que os dois garfos estejam livres
				wait();
			}
			catch (Exception e) 
			{
			}
		}

		//Metodo responsável por utilizar o  garfo na posição da direita e esquerda.
		setVetorGarfos(vet_garfos, estaComGarfo, numeroFilosofo);
		
		System.out.println("Garfo1:  "+ numeroFilosofo +" Garfo2: "+((numeroFilosofo + 1) % 5) +"");
		//Seta o estatus Comer
		filosofo.setStatus(1); 
	}

	public synchronized void liberar(Filosofo filosofo) 
	{
		//variavel que define se o filosofo esta com garfo = Não está (false)
		boolean estaComGarfo = false;
		//busca o filosofo e insere ele na variavel local;
		int numeroFilosofo;
		numeroFilosofo = filosofo.getFilosofo();
		
		//Metodo responsável por liberar o  garfo na posição da direita e esquerda.
		setVetorGarfos(vet_garfos, estaComGarfo, numeroFilosofo);
		
		try 
		{
			//notifyAll() - faz com que todas as threads que estavam esperando em wait() (no método pegar())
			//sejam acordadas e possam tentar novamente pegar os garfos.
			//Mas por que notifyAll() e não notify()?
			//notify() acorda apenas uma thread aleatória que esteja esperando no monitor.
			//Nesse nosso problema do jantar dos filósofos, várias threads podem estar esperando por diferentes pares de garfos.
			notifyAll();
		}
		catch (Exception e) 
		{
		}
	}
	
	public void setVetorGarfos(boolean[] vet_garfos, boolean estaComGarfo, int numeroFilosofo) 
	{
		//Insere o valor desejado para o garfo direito
		vet_garfos[numeroFilosofo] = estaComGarfo;

		//Insere o valor desejado para o garfo esquerdo
		int aux = (numeroFilosofo + 1) % 5;
		vet_garfos[aux] = estaComGarfo;
	}
}