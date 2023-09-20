
public class CocheJuego extends Coche{
	private JLabelCoche coche;
	
	public CocheJuego() {
		coche = new JLabelCoche("src/coche.png");
	}

	public JLabelCoche getCoche() {
		return coche;
	}

	public void setCoche(JLabelCoche coche) {
		this.coche = coche;
	}

	@Override
	public void setPosX(double posX) {
		this.posX = posX;
		coche.setBounds((int) posX, coche.getY(), coche.getWidth(), coche.getHeight());
	}
	
	@Override
	public void setPosY(double posY) {
		this.posY = posY;
		coche.setBounds(coche.getX(), (int) posY , coche.getWidth(), coche.getHeight());
	}
	
	@Override
	public void mueve( double tiempoDeMovimiento ) {
		super.mueve(tiempoDeMovimiento);
		coche.setBounds((int) posX, coche.getY(), coche.getWidth(), coche.getHeight());
		coche.setBounds(coche.getX(), (int) posY , coche.getWidth(), coche.getHeight());
	}
}
