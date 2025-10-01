package paquetProjet;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VideoProjecteur extends Constructeur{

	JFrame f;
	JPanel p;
	
	
	JLabel power;
	JLabel statut;
	JLabel sari;
	JLabel lumiere;
	JLabel Alimentation;
	JLabel btnOnOff;
	
	boolean isRun = false;
	boolean isOn = false;
	
	final String statutOFF = "images/icones/StatutOff.ico";
	final String statutON = "images/icones/clignotant.gif";
	
	final String on = "images/icones/On.ico";
	final String off = "images/icones/Off.ico";
	
	public VideoProjecteur() {
		final int x = -10,y = 30;
		f = new JFrame();
		f.setSize(480,670);
		f.setLocation(480,40);
		f.setVisible(false);
		f.setTitle("Vidéo Projecteur BENQ");
		f.setUndecorated(true);
		f.setAlwaysOnTop(true);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(117,75,60));
		
		power = new JLabel("_____");
		power.setForeground(Color.WHITE);
		power.setBackground(Color.white);
		power.setBounds(220-x,241-y,100,20);
		
		statut  = new JLabel(new ImageIcon(statutOFF));
		statut.setBounds(205-x,244-y,10,10);
		
		Alimentation = new JLabel(new ImageIcon("images/supplements_/Alim.jpg"));
		Alimentation.setBounds(162-x,320-y,240,250);
		
		btnOnOff = new JLabel(new ImageIcon(off));
		btnOnOff.setBounds(322-x,500-y,100,100);
		
		lumiere = new JLabel(new ImageIcon("images/supplements_/Lumiere.jpg"));
		lumiere.setBounds(241,100,250,300);
		lumiere.setVisible(false);
		
		sari = new JLabel(new ImageIcon("images/interfaces/VideoProjecteur.jpg"));
		sari.setBounds(-50-x,-75,f.getWidth(),f.getHeight());
		
		JLabel fil = new JLabel(new ImageIcon("images/supplements_/fil.jpg"));
		fil.setBounds(-80,270,300,300);
		
		JButton btnQuitter = new JButton("QUITTER L'APPLICATION");
		btnQuitter.setBackground(new Color(117,75,60));
		btnQuitter.setForeground(Color.black);
		
		btnQuitter.setBounds(120,640,200,20);
		btnQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});
		p.add(btnQuitter);
		
		p.add(fil);
		p.add(btnOnOff);
		p.add(power);
		p.add(statut);
		p.add(lumiere);
		p.add(sari);
		p.add(Alimentation);	
		p.add(fil);
		
		f.add(p);
		
	}
	public JLabel getBtnOnOff() {
		return btnOnOff;
	}
	public JLabel getLumiere() {
		return lumiere;
	}
	
	public JFrame getF() {
		return f;
	}
	public void off() {
		getF().setVisible(false);
	}
	public void on() {
		getF().setVisible(true);
	}
	public JLabel getPower() {
		return power;
	}
	public void running() {
		isRun = true;
		statut.setIcon(new ImageIcon(statutON));
		getLumiere().setVisible(true);
	}
	public void stop() {
		isRun = false;
		statut.setIcon(new ImageIcon(statutOFF));
		getLumiere().setVisible(false);
	}
	
	public void setPanel(JPanel x) {
		f.add(x);
	}

}
