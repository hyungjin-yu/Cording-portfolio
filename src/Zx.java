

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class xZx extends JFrame implements ActionListener {
	 ImagePanel panel = new ImagePanel(
			        new ImageIcon("BackGround/LogInBg.png").getImage());
	
	Container con = getContentPane();

	JLabel l = new JLabel("  ");
	
	public xZx() {
		setTitle("ALBA Heaven");
		setSize(500, 500);
		setResizable(false);
		setLocation(1030, 480);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		con.add(panel);

	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

public class Zx {
	public static void main(String[] args) {
		xZx z = new xZx();
	}
}