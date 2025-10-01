package paquetProjet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Ordinateur extends Constructeur{
	
	private JFrame f;
	private JPanel p;
	private JPanel pDisplay;
	private JPanel pMenu;
	
	
	private JLabel objL,objLHome; // pour image
	private JTextArea objA,objPdf; // pour texte
	private Canvas objC; // pour video
	
	private JLabel btnHome;
	private JLabel btnPower;
	private JLabel btnVideo;
	private JLabel btnImage;
	private JLabel btnTexte;
	private JLabel btnPdf;
	private String path;
	
	JScrollPane jsp;
	
	private String enMarche;
	
	public boolean isRun = false;
	public boolean pathChange = false;
	
	public Ordinateur() {
		
		
		enMarche = "_none";
		
		Dimension dim = new Dimension(450,631),
		pdDim = new Dimension(352,252),
		pmDim = new Dimension(352,28);
		
		Point pdPt = new Point(47,128),
		pmPt = new Point(47,381);
		
		Rectangle pdRect = new Rectangle(pdPt,pdDim),
				pmRect = new Rectangle(pmPt,pmDim);
		
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(dim);
		f.setLocation(20,40);
		f.setUndecorated(true);
		f.setTitle("Ordinateur Portable");
		f.setAlwaysOnTop(true);
		
		JLabel ordi = new JLabel(redimensionner(new ImageIcon("images/interfaces/Ordinateur.jpg"), f.getWidth(), f.getHeight()));
		ordi.setBounds(0,0,f.getWidth(),f.getHeight());
	
		btnPower = new JLabel(redimensionner(new ImageIcon("images/icones/pOff.png"),15,15));
		btnPower.setBounds(42,435,18,18);
		
		f.setSize(460, 670);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(117,75,60));
		
		pDisplay = new JPanel();
		pDisplay.setBounds(pdRect);
		pDisplay.setBackground(Color.black);
		
		pMenu = new JPanel();
		pMenu.setBounds(pmRect);
		pMenu.setLayout(new FlowLayout());
		pMenu.setBackground(new Color(149, 149, 149));
		
		p.add(btnPower);
		p.add(pMenu);
		p.add(pDisplay);
		p.add(ordi);
		
		
		
		f.add(p);
		
		
		/***
		 * LES ELEMENTS PRINCIPALES DU PANEL DISPLAY
		 */
		
		Rectangle allConfig = pdRect;
		
		objL = new JLabel();
		objLHome = new JLabel();
		objPdf = new JTextArea();
		objA = new JTextArea();
		objC = new Canvas();
		
		objL.setBounds(allConfig);
		objLHome.setBounds(allConfig);
		objC.setBounds(allConfig);
		
		objA.setBounds(allConfig);
		objA.setPreferredSize(pDisplay.getSize());
		
		objPdf.setBounds(allConfig);
		objPdf.setPreferredSize(pDisplay.getSize());
		
		pDisplay.add(objA);
		pDisplay.add(objL);
		pDisplay.add(objLHome);
		pDisplay.add(objPdf);
		pDisplay.add(objC);
		
		/***
		 * OBJETS ELEMENTAIRES
		 */
		
		int iconWidth = 25,iconHeigth = 18;
		ImageIcon iHome = redimensionner(new ImageIcon("images/icone/home.png"), iconWidth,iconHeigth);
		ImageIcon iVideo = redimensionner(new ImageIcon("images/icone/video.png"), iconWidth,iconHeigth);
		ImageIcon iImage = redimensionner(new ImageIcon("images/icone/image.png"), iconWidth,iconHeigth);
		ImageIcon iText = redimensionner(new ImageIcon("images/icone/texte.png"), iconWidth,iconHeigth);
		ImageIcon iPdf = redimensionner(new ImageIcon("images/icone/pdf.png"), iconWidth,iconHeigth);
		
		setBtnHome(new JLabel(iHome));
		btnVideo = new JLabel(iVideo);
		btnImage = new JLabel(iImage);
		btnTexte = new JLabel(iText);
		btnPdf = new JLabel(iPdf);
		
		pMenu.add(btnHome);
		pMenu.add(btnImage);
		pMenu.add(btnVideo);
		pMenu.add(btnTexte);
		pMenu.add(btnPdf);
		
		pMenu.setVisible(false);
		f.setVisible(false);
		
		
		
		
	}
	
	public void off() {
		getF().setVisible(false);
	}
	public void on() {
		getF().setVisible(true);
	}
	
	public void openExplorer(String description,String ... extensions) {
		JFileChooser chooser = new JFileChooser ();
		chooser.setPreferredSize(new Dimension(330,210));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(description,extensions);
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(pDisplay);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
         String oldPath = getPath();
         path = chooser.getSelectedFile().toURI().toString().replace("%20", " ");
         path = path.replace("file:/", "");
         
         if (oldPath == getPath()) pathChange = false;
         else pathChange = true;
        }
    }
	
	/***
	 * LES GETTER() DE WINDOWS
	 */
	
	public JFrame getF() {
		return f;
	}
	public JPanel getP() {
		return p;
	}
	public JPanel getPDispaly() {
		return pDisplay;
	}
	public JPanel getPMenu() {
		return pMenu;
	}
	public JLabel get_L( ) {
		return objL;
	}
	public JLabel get_LHome() {
		return objLHome;
	}
	public JTextArea getLPdf() {
		return objPdf;
	}
	public JTextArea get_A( ) {
		return objA;
	}
	public Canvas get_C() {
		return objC;
	}
	
	
	public JLabel getbtnVideo() {
		return btnVideo;
	}
	public JLabel getbtnImage() {
		return btnImage;
	}
	public JLabel getBtnText() {
		return btnTexte;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String newPath) {
		this.path = newPath;
	}
	public String getEnMarche() {
		return enMarche;
	}

	/***********************/
	
	public void setEnMarche(String enMarche) {
		this.enMarche = enMarche;
		if (enMarche == "_none") objLHome.setVisible(true);
		if (enMarche == "_texte") objA.setVisible(true);
		else if (enMarche == "_image") objL.setVisible(true);
		else if (enMarche == "_video") objC.setVisible(true);
		else if (enMarche == "_document") objPdf.setVisible(true);
	}
	public void visibility(String str) {
		objL.setVisible(false);
		objA.setVisible(false);
		objC.setVisible(false);
		objLHome.setVisible(false);
		objPdf.setVisible(false);
		setEnMarche(str);
	}

	public JLabel getBtnPdf() {
		return btnPdf;
	}

	public void setBtnPdf(JLabel btnPdf) {
		this.btnPdf = btnPdf;
	}

	public JLabel getPower() {
		return btnPower;
	}

	public void setPower(JLabel btnPower) {
		this.btnPower = btnPower;
	}

	public JLabel getBtnHome() {
		return btnHome;
	}

	public void setBtnHome(JLabel btnHome) {
		this.btnHome = btnHome;
	}
	
	
	/**
	 * Menu bar
	 * Quitter
	 * A propos
	 */
	
}
