
package paquetProjet;

import java.awt.Canvas;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


public class Constructeur{
	public EmbeddedMediaPlayer emp;
	
	private BufferedReader buff;
	public Constructeur(){
		
	}
	public void traitementImage(String path,JLabel label,JPanel p) { // traitement lecture image
	    		ImageIcon img = new ImageIcon(path);
	    		ImageIcon imgResize = redimensionner(img,p.getWidth(),p.getHeight());
	    		label.setIcon(imgResize);
	    }
	public ImageIcon redimensionner(ImageIcon icon,int width,int height) { // redimensionner image à afficher
	       	Image img = icon.getImage();
	       	Image imgResize = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	       	ImageIcon imgIconResize = new ImageIcon(imgResize);
	       	return imgIconResize;
	       	
	}
	public String readtext(String chemin) {
	 	   String sauvegarde = "";
	 	   try {
	 		   InputStream flux = new FileInputStream(chemin);
	 		   InputStreamReader lecture = new InputStreamReader(flux);
	 		   buff = new BufferedReader(lecture);
	 		   String ligne;
	 		   while((ligne = buff.readLine())!= null) sauvegarde += ligne + "\n";
	 	   }
	 	   catch (IOException e) {
	 		   System.out.println(e.toString());
	 	   }
	 	   return sauvegarde;
	    } 
	public void traitementTexte(String x,JTextArea _area) { // TRAITEMENT LECTURE
 	   _area.setText(x); 
    }
	public void openVideo(JFrame win,JPanel pan,Canvas c,String pathFile) {
		c.setBounds(new Rectangle(new Point(0,0),pan.getSize()));
		
		pan.add(c);
		
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		
		MediaPlayerFactory mpf = new MediaPlayerFactory();
		
		emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(win));
		emp.setVideoSurface(mpf.newVideoSurface(c));
		
		emp.setEnableMouseInputHandling(true);
		
		emp.setEnableKeyInputHandling(false);
		
		emp.prepareMedia(pathFile);
		
		emp.play();
		
		emp.setVolume(0);

		}
		public void hide(JLabel l) {
			l.setVisible(false);
		}
		
		public String lecturePDF(String path) {
			String str = "";
			try {
				PdfReader reader = new PdfReader(path);
				int n = reader.getNumberOfPages();
				for (int iCount = 0;iCount<n ; iCount++) {
					str += PdfTextExtractor.getTextFromPage(reader, iCount, null);
				}
	
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
			
		}
		public void traitementPdf(JTextArea label,String path) {
			String texte = lirePDF(path);
			label.setText(texte);
		}
		public String lirePDF(String path) {
			String content = "";
			try 
			    {
			        //Créer une instance PdfReader.
			        PdfReader pdf = new PdfReader(path);  
			   
			        //Récupérer le nombre de pages en pdf.
			        int nbrPages = pdf.getNumberOfPages(); 
			        
			        //Itérer le pdf à travers les pages.
			        for(int i=1; i <= nbrPages; i++) 
			        { 
			            //Extraire le contenu de la page à l'aide de PdfTextExtractor.
			            content += PdfTextExtractor.getTextFromPage(pdf, i) + "\n";
			        }
			   
			        //Fermez le PdfReader.
			        pdf.close();
			    
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			return content;
		}
		public void statutVideo(boolean bool) {
			if (bool) emp.play();
			else emp.stop();
		}
}
