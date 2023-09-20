import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	public JLabelCoche(String imagen) {
		super();
		setSize(100,100);
		ImageIcon im = new ImageIcon(imagen);
		ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
		setIcon(imagenConDimensiones);
		setBounds(100, 100, 100	, 100); 
	}
}
