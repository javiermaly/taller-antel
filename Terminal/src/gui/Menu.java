package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menu extends JFrame {

	private JFrame jFrmMenuTer = null;  //  @jve:decl-index=0:visual-constraint="174,56"
	private JPanel jMenuTer = null;
	private JMenuBar jJMenuBarTer = null;
	private JMenu jMenuVenta = null;
	private JMenu jMenuAnulacion = null;
	private JMenuItem jMenuItemVenta = null;
	private JMenuItem jMenuItemAnulacion = null;
	
	//ventanas que llama
	private AltaTicket at=new AltaTicket();
	private AnulacionTicket ant= new AnulacionTicket();

	/**
	 * This method initializes jFrmMenuTer	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	public Menu(){
		this.getJFrmMenuTer();
		
	}
	
	public void setVisible(boolean visible){
		super.setVisible(visible);
		jFrmMenuTer.setVisible(visible);
		/*
		jMenuTer.setVisible(visible);
		jJMenuBarTer.setVisible(visible);
		jMenuVenta.setVisible(visible); 
		jMenuAnulacion.setVisible(visible); 
		jMenuItemVenta.setVisible(visible);
		jMenuItemAnulacion.setVisible(visible); 
		*/
	}
	private JFrame getJFrmMenuTer() {
		if (jFrmMenuTer == null) {
			jFrmMenuTer = new JFrame();
			jFrmMenuTer.setSize(new Dimension(409, 209));
			jFrmMenuTer.setTitle("Menu Terminal");
			jFrmMenuTer.setJMenuBar(getJJMenuBarTer());
			jFrmMenuTer.setContentPane(getJMenuTer());
		}
		return jFrmMenuTer;
	}

	/**
	 * This method initializes jMenuTer	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJMenuTer() {
		if (jMenuTer == null) {
			jMenuTer = new JPanel();
			jMenuTer.setLayout(null);
		}
		return jMenuTer;
	}

	/**
	 * This method initializes jJMenuBarTer	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBarTer() {
		if (jJMenuBarTer == null) {
			jJMenuBarTer = new JMenuBar();
			jJMenuBarTer.add(getJMenuVenta());
			jJMenuBarTer.add(getJMenuAnulacion());
		}
		return jJMenuBarTer;
	}

	/**
	 * This method initializes jMenuVenta	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuVenta() {
		if (jMenuVenta == null) {
			jMenuVenta = new JMenu();
			jMenuVenta.setText("Venta de tickets");
			jMenuVenta.add(getJMenuItemVenta());
		}
		return jMenuVenta;
	}

	/**
	 * This method initializes jMenuAnulacion	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuAnulacion() {
		if (jMenuAnulacion == null) {
			jMenuAnulacion = new JMenu();
			jMenuAnulacion.setText("Anulacion tickets");
			jMenuAnulacion.add(getJMenuItemAnulacion());
		}
		return jMenuAnulacion;
	}

	/**
	 * This method initializes jMenuItemVenta	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemVenta() {
		if (jMenuItemVenta == null) {
			jMenuItemVenta = new JMenuItem();
			jMenuItemVenta.setText("Venta");
			jMenuItemVenta.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
					at.setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemVenta;
	}

	/**
	 * This method initializes jMenuItemAnulacion	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAnulacion() {
		if (jMenuItemAnulacion == null) {
			jMenuItemAnulacion = new JMenuItem();
			jMenuItemAnulacion.setText("Anulacion");
			jMenuItemAnulacion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
					ant.setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemAnulacion;
	}

}
