package paquetProjet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EcranProjection extends Constructeur {
	private JFrame f;
	private JPanel pDisplay,p;
	private Canvas c;
	
	private JLabel l;
	private JTextArea lPdf;
	private JTextArea a;
	private String pathPC;
	
	private String enMarche;
	
	public EcranProjection() {
		
		
		setEnMarche("_none");
		
		// all mesures
		Rectangle panelRect = new Rectangle(45,130,340,250);
		final int x = 390, y = 500;
		
		f = new JFrame();
		f.setUndecorated(true);
		f.setLocation(940,40);
		f.setSize(400,670);
		f.setVisible(false);
		f.setTitle("Ecran de projection");
		f.setAlwaysOnTop(true);
		
		pDisplay = new JPanel();
		pDisplay.setBounds(panelRect);
		pDisplay.setLayout(null);
		
		JLabel ecran = new JLabel(redimensionner(new ImageIcon("images/interfaces/EcranProjection.jpg"), x, y));
		ecran.setBounds(20,90,x,y);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(117,75,60));
		
		p.add(pDisplay);
		p.add(ecran);
		
		
		f.add(p);
		
		Rectangle allConfig = panelRect;
		allConfig.setLocation(0,0);
		
		c = new Canvas();
		c.setBounds(allConfig);
		
		l = new JLabel(redimensionner(new ImageIcon("images/supplements/NoSignal.jpg"), allConfig.width, allConfig.height));
		l.setBounds(allConfig);
		
		lPdf = new JTextArea();
		lPdf.setBounds(allConfig);
		
		a = new JTextArea();
		a.setBounds(allConfig);
		
		pDisplay.setBackground(Color.white);
		
		
		
		pDisplay.add(a);
		pDisplay.add(c);
		pDisplay.add(l);
		pDisplay.add(lPdf);

		pDisplay.setVisible(false);
	}
	public void principal() throws IOException {
		try (ServerSocket ss = new ServerSocket(1271)) {
			while (true) {
			Socket s = ss.accept();	
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			String path = "All Files";
			out.writeChars(path);
			}
		}
}
	
	public void off() {
		getF().setVisible(false);
	}
	public void on() {
		getF().setVisible(true);
	}
	
	public JFrame getF() {
		return f;
	}
	public void setF(JFrame f) {
		this.f = f;
	}
	public Canvas getC() {
		return c;
	}
	public void setC(Canvas C) {
		this.c = C;
	}
	public String getPathPC() {
		return pathPC;
	}
	public void setPathPC(String pathPC) {
		this.pathPC = pathPC;
	}
	public void setP(JPanel p) {
		this.pDisplay = p;
	}

	public JLabel getL() {
		return l;
	}

	public void setL(JLabel l) {
		this.l = l;
	}

	public JTextArea getA() {
		return a;
	}

	public void setA(JTextArea a) {
		this.a = a;
	}

	public String getEnMarche() {
		return enMarche;
	}
	
	public JPanel getPDisplay() {
		return pDisplay;
	}

	public void setEnMarche(String enMarche) {
		this.enMarche = enMarche;
		if (enMarche == "_texte") a.setVisible(true);
		else if (enMarche == "_document") lPdf.setVisible(true);
		else if (enMarche == "_image") l.setVisible(true);
		else if (enMarche == "_video") c.setVisible(true);
		else; // _none
	}
	public void visibility(String str,boolean ProjecteurEnMarche) {
		l.setVisible(false);
		lPdf.setVisible(false);
		a.setVisible(false);
		c.setVisible(false);
		if (ProjecteurEnMarche) setEnMarche(str);
		else setEnMarche("_none");
	}
	
	public JTextArea getlPdf() {
		return lPdf;
	}
	
	public JPanel getP() {
		return p;
	}
}
