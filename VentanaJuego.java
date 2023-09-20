import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	private JPanel panelPrincipal, panelBotonera;
	private JButton btnAcelerar, btnFrenar, btnGirarIzd, btnGirarDcha;
	//private JLabelCoche coche;
	private CocheJuego coche;
	private JFrame ventana;
	public VentanaJuego() {
		super();
		ventana = this;
		setBounds(100, 100, 1000, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		panelPrincipal = new JPanel(null);
		panelPrincipal.setBackground(Color.WHITE);
		panelBotonera = new JPanel();
		btnAcelerar = new JButton("Acelerar");
		btnFrenar = new JButton("Frenar");
		btnGirarIzd = new JButton("Girar Izd.");
		btnGirarDcha = new JButton("Girar Dcha");
		panelBotonera.add(btnAcelerar);
		panelBotonera.add(btnFrenar);
		panelBotonera.add(btnGirarIzd);
		panelBotonera.add(btnGirarDcha);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		getContentPane().add(panelBotonera, BorderLayout.SOUTH);
		
		//coche = new JLabelCoche("src/coche.png");
		coche = new CocheJuego();
		panelPrincipal.add(coche.getCoche());
		
		btnAcelerar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
				System.out.println(coche.getMiVelocidad());
			}
		});
		
		btnFrenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);
				System.out.println(coche.getMiVelocidad());
			}
		});
		
		btnGirarIzd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10);
				System.out.println(coche.getMiDireccionActual());
			}
		});
		
		btnGirarDcha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10);
				System.out.println(coche.getMiDireccionActual());
			}
		});
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int iniciox = ventana.getX();
				int finx = iniciox + ventana.getWidth();
				int inicioy = ventana.getY();
				int finy = inicioy + ventana.getHeight();
				
				while(true) {
					coche.mueve(40);
					ventana.repaint();
					if(coche.getPosX()>=finx) {
						coche.setPosX(iniciox);
					}
					if(coche.getPosY()>=finx) {
						coche.setPosY(inicioy);
					}
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						
					}
				}
			}
		}); t.start();
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				t.interrupt();
				
			}
			
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		VentanaJuego ventana = new VentanaJuego();
		
		/*Coche coche = new Coche();
		coche.setPosX(150);
		coche.setPosY(100);
		System.out.println(coche);
		coche.acelera(20);
		coche.gira(45);
		coche.mueve(3);
		System.out.println(coche);*/
	}
	
	
	
}
