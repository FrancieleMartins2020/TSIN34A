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
	private Image fundo,arist,descar,pitagor,socrat,plat,mes;
	
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
					//Cria a interface e os filósofos
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
		
		graficos.drawImage(fundo,0,0,null);
		graficos.drawImage(mes, 90, 230, null);	
		graficos.drawImage(arist, 210, 125, null);
		graficos.drawImage(plat, 15, 295, null);			
		graficos.drawImage(socrat, 340, 495, null);
		graficos.drawImage(pitagor, 405, 295, null);
		graficos.drawImage(descar, 90, 490, null);			
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
				arist = referencia.getImage();
				
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo1_frente_garfos.png");		
				arist = referencia.getImage();
				
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo1_frente_garfo.png");		
				arist = referencia.getImage();				
			}
		} else if (numeroFilosofo == 1)
		{
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_esquerda_pensando.png");		
				plat = referencia.getImage();
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_esquerda_garfos.png");		
				plat = referencia.getImage();
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo_esquerda_garfo.png");		
				plat = referencia.getImage();			
			}
		} else if (numeroFilosofo == 2)
		{			
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo2_frente_pensando.png");		
				descar = referencia.getImage();				
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo2_frente_garfos.png");		
				descar = referencia.getImage();				
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\filosofo2_frente_garfo.png");		
				descar = referencia.getImage();
			}
		} else if (numeroFilosofo == 3)
		{
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\socrates.png");		
				socrat = referencia.getImage();
			} else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\socrates2.png");		
				socrat = referencia.getImage();			
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\socrates1.png");		
				socrat = referencia.getImage();
			}			
		} else if (numeroFilosofo == 4)
		{
			if (status == 0)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\pitagoras.png");		
				pitagor = referencia.getImage();
			}else if (status == 1)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\pitagoras2.png");		
				pitagor = referencia.getImage();			
			} else if (status == 2)
			{
				ImageIcon referencia = new ImageIcon("src\\Imagens\\pitagoras1.png");		
				pitagor = referencia.getImage();
			}
		}
		
		repaint();
	}	
	
	public Jantar() 
	{
		setTitle("Jantar dos Filósofos -> Trabalho de Programação Concorrênte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jantar.class.getResource("/Imagens/Icon.png")));
			
		ImageIcon referencia = new ImageIcon("src\\Imagens\\fundo.png");		
		fundo = referencia.getImage();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 597);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);
		
		referencia = new ImageIcon("src\\Imagens\\mesa.png");
		
		//Criação do garfo compartilhado
		garfos = new Garfos();
		
		 //Criação dos filósofos
		filosofo0 = new Filosofo(0, this); 
		filosofo1 = new Filosofo(1, this);
		filosofo2 = new Filosofo(2, this);
		filosofo3 = new Filosofo(3, this);
		filosofo4 = new Filosofo(4, this);
		
		//Início das threads (os filósofos começam a pensar e comer)
		filosofo0.start();
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
	}
}