import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// interface gráfica baseada na classe JFrame, que representa a janela principal da aplicação.
public class Jantar extends JFrame 
{	
	private Filosofo[] filosofos;
	private static final int MAX_REFEICOES = 2;
    private volatile int qtdRefeicoes = 0;
	private Image mesa_fundo, filosofo_1, filosofo_2, filosofo_3, filosofo_4, filosofo_5;
	
	private Filosofo filosofo0, filosofo1, filosofo2, filosofo3, filosofo4;
	
	public Garfos garfos;
	
	private JPanel contentPanel;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					//Cria a interface
					Jantar frame = new Jantar();
					//Mostra a janela
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public void paint(Graphics g)
	{
		Graphics2D graficos = (Graphics2D) g;
		
		graficos.drawImage(mesa_fundo,0,0,null);
		graficos.drawImage(filosofo_1, 210, 100, null);
		graficos.drawImage(filosofo_2, 15, 295, null);			
		graficos.drawImage(filosofo_3, 90, 475, null);			
		graficos.drawImage(filosofo_4, 340, 475, null);
		graficos.drawImage(filosofo_5, 405, 295, null);		
	}	
	
	public void jantar_WindowDestroy(Object target) 
	{
		System.exit(0);
	}

	public void SetInfo(int numeroFilosofo, int status) 
	{		
		if (numeroFilosofo == 0)
		{			
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo1_frente_pensando.png");		
				filosofo_1 = referencia.getImage();
				
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo1_frente_garfos.png");		
				filosofo_1 = referencia.getImage();
				
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo1_frente_garfo.png");		
				filosofo_1 = referencia.getImage();				
			}
		} else if (numeroFilosofo == 1)
		{
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_esquerda_pensando.png");		
				filosofo_2 = referencia.getImage();
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_esquerda_garfos.png");		
				filosofo_2 = referencia.getImage();
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_esquerda_garfo.png");		
				filosofo_2 = referencia.getImage();			
			}
		} else if (numeroFilosofo == 2)
		{			
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo2_frente_pensando.png");		
				filosofo_3 = referencia.getImage();				
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo2_frente_garfos.png");		
				filosofo_3 = referencia.getImage();				
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo2_frente_garfo.png");		
				filosofo_3 = referencia.getImage();
			}
		} else if (numeroFilosofo == 3)
		{
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo3_frente_pensando.png");		
				filosofo_4 = referencia.getImage();
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo3_frente_garfos.png");		
				filosofo_4 = referencia.getImage();			
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo3_frente_garfo.png");		
				filosofo_4 = referencia.getImage();
			}			
		} else if (numeroFilosofo == 4)
		{
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_direita_pensando.png");		
				filosofo_5 = referencia.getImage();
			}else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_direita_garfos.png");		
				filosofo_5 = referencia.getImage();			
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_direita_garfo.png");		
				filosofo_5 = referencia.getImage();
			}
		}
		
		repaint();
	}
    
	public Jantar() 
	{
		setTitle("Jantar dos Filósofos -> Trabalho de Programação Concorrênte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jantar.class.getResource("/Imagens/Icon.png")));
			
		ImageIcon referencia = new ImageIcon("src\\Imagens\\mesa_fundo.png");		
		mesa_fundo = referencia.getImage();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 597);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);
        
		//Criação do garfo compartilhado
		garfos = new Garfos();
		
		//Criação dos filósofos
        filosofos = new Filosofo[5];
        filosofos[0] = filosofo0 = new Filosofo(0, this);
        filosofos[1] = filosofo1 = new Filosofo(1, this);
        filosofos[2] = filosofo2 = new Filosofo(2, this);
        filosofos[3] = filosofo3 = new Filosofo(3, this);
        filosofos[4] = filosofo4 = new Filosofo(4, this);

		//Início das threads (os filósofos começam a pensar e comer)
        for (Filosofo f : filosofos) {
            f.start();
        }

        new MonitorRefeicoes(filosofos).start();	
		
	}
}