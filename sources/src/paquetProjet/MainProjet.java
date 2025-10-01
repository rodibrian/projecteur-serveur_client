package paquetProjet;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JPanel;


public class MainProjet {
	public static void powerWindowEvent(Ordinateur pWin,VideoProjecteur pro,EcranProjection sortie) {
		pWin.getPower().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
					if (pWin.isRun) {
						pWin.isRun = false;
						pWin.getPower().setIcon(new ImageIcon("images/icones/pOff.png"));
						pWin.getPMenu().setVisible(false);
						pWin.getPDispaly().setVisible(false);
						if (pro.isRun) {
							pWin.statutVideo(false);
							sortie.visibility("_image", pro.isRun);
							sortie.traitementImage("images/supplements/NoSignal.jpg",sortie.getL(),sortie.getPDisplay());
						}
						
					}
					else {
						pWin.isRun = true;
						pWin.getPower().setIcon(new ImageIcon("images/icones/pOn.png"));
						pWin.getPMenu().setVisible(true);
						pWin.getPDispaly().setVisible(true);
						pWin.visibility("_image");
						pWin.setPath("images/supplements/Acceuil.jpg");
						pWin.traitementImage(pWin.getPath(),pWin.get_L(),pWin.getPDispaly());
						pro.traitementImage(pWin.getPath(), sortie.getL(), sortie.getPDisplay());
						if (pro.isRun) {
							sortie.visibility("_image",pro.isRun);
							sortie.traitementImage(pWin.getPath(),sortie.getL(),sortie.getPDisplay());
						}	
					}
			}
		});
		
		
		
	}
	public static void PowerProjecteurEvent(Ordinateur pWin,VideoProjecteur pro,EcranProjection sortie) {
			pro.getPower().addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (pro.isOn) {
					if (pro.isRun) {
						pro.stop();
						sortie.visibility("_none", false);
						sortie.getPDisplay().setVisible(false);
					}
					else {
						pro.running();
						sortie.getPDisplay().setVisible(true);
						if (pWin.isRun) sortie.visibility(pWin.getEnMarche(), true);
						else {
							sortie.traitementImage("images/supplements/NoSignal.jpg",sortie.getL(),sortie.getPDisplay());
							sortie.visibility("_image", true);
						}
					}
				}
			}
		});
	}
	public static void Alimentation(Ordinateur pWin,VideoProjecteur pro,EcranProjection sortie) {
	pro.getBtnOnOff().addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (pro.isOn) {
				pro.isOn = false;
				pro.stop();
				pro.getBtnOnOff().setIcon(new ImageIcon("images/icones/Off.ico"));
				sortie.visibility("_none", false);
				sortie.getPDisplay().setVisible(false);
			}
			else {
				pro.isOn = true;
				pro.getBtnOnOff().setIcon(new ImageIcon("images/icones/On.ico"));
			}
		}
	});
}
	public static void labelWindowEvent(Ordinateur pWin,VideoProjecteur pro,EcranProjection sortie) {
		pWin.getbtnVideo().addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					pWin.openExplorer("format :: Vidéos", "mp4","avi","3gp","mov");
					String pathFile = pWin.getPath();
					pathFile = pathFile.replace("/", "\\\\");
					if (pWin.pathChange) {
					pWin.visibility("_video");
					pWin.openVideo(pWin.getF(),pWin.getPDispaly(),pWin.get_C(),pathFile);
					sortie.visibility("_video",pro.isRun);
					sortie.openVideo(sortie.getF(),sortie.getPDisplay(),sortie.getC(), pathFile);
					}
				}
			});
		pWin.getbtnImage().addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					pWin.openExplorer("format :: Images", "jpg","jpeg","png","gif");
					if (pWin.pathChange) {
						pWin.visibility("_image");
						pWin.traitementImage(pWin.getPath(),pWin.get_L(),pWin.getPDispaly());
						sortie.visibility("_image",pro.isRun);
						sortie.traitementImage(pWin.getPath(),sortie.getL(),sortie.getPDisplay());
					}
					
				}
			});
		pWin.getBtnText().addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			pWin.openExplorer("format :: Textes", "html", "txt", "java", "c", "xml");
			String txtSlashe = pWin.readtext(pWin.getPath());
			if (pWin.pathChange) {
				pWin.visibility("_texte");
			pWin.traitementTexte(txtSlashe,pWin.get_A());
			sortie.visibility("_texte",pro.isRun);
			sortie.traitementTexte(txtSlashe,sortie.getA());
			}
			
		}
	});
		pWin.getBtnPdf().addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			pWin.openExplorer("formats :: Documents ","pdf");
			
			if (pWin.pathChange) {
			pWin.visibility("_document");
			pWin.traitementPdf(pWin.getLPdf(), pWin.getPath());
			sortie.visibility("_document",pro.isRun);
			sortie.traitementPdf(sortie.getlPdf(), pWin.getPath());
			}
			
		}
		});
		pWin.getBtnHome().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pWin.setPath("images/supplements/Acceuil.jpg");
				pWin.visibility("_image");
				pWin.traitementImage(pWin.getPath(),pWin.get_L(),pWin.getPDispaly());
				sortie.visibility("_image",pro.isRun);
				sortie.traitementImage(pWin.getPath(),sortie.getL(),sortie.getPDisplay());
				
			}
		});
	}
	public static void main(String[] args) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		// big window
		
		JFrame mainWindow = new JFrame();
		mainWindow.setSize(1350,710);
		mainWindow.setLocation(10,10);
		mainWindow.setTitle("Projet Projecteur JAVA");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Ordinateur pWin = new Ordinateur();
		VideoProjecteur pro = new VideoProjecteur();
		EcranProjection sortie = new EcranProjection();
		
		JPanel mainPan = new JPanel();
		mainPan.setLayout(null);
		mainPan.setBackground(new Color(117,75,60));
		
		mainWindow.add(mainPan);
		mainWindow.setResizable(false);
		mainWindow.setVisible(true);
		
		pWin.visibility("_none");
		sortie.visibility("_none",pro.isRun);

		powerWindowEvent(pWin, pro, sortie);
		PowerProjecteurEvent(pWin, pro, sortie);
		labelWindowEvent(pWin, pro, sortie);
		Alimentation(pWin, pro, sortie);
		
		pWin.on();
		pro.on();
		sortie.on();
		
		while(true) {
			pWin.getF().setLocation(20 + mainWindow.getX(), 30 + mainWindow.getY());
			pro.getF().setLocation(480 + mainWindow.getX(), 30 + mainWindow.getY());
			sortie.getF().setLocation(940 + mainWindow.getX(), 30 +mainWindow.getY());
		}
		
	}

}
