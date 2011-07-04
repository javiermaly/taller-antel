package gui;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.terminal.Manager;
import com.terminal.Ticket;

public class AnulacionTicket extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private JTextField jTxtIdIMM = null;
	private JLabel jLblIdIMM = null;

	private JButton jBtnAceptar = null;
	Manager m= new Manager();  //  @jve:decl-index=0:

	Ticket t = new Ticket();  //  @jve:decl-index=0:
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	String calend="";  //  @jve:decl-index=0:
	//int dura=0;
	
	
	public AnulacionTicket() {
		super();
		initialize();
	}
		
	

	public AnulacionTicket(GraphicsConfiguration arg0) {
		super(arg0);
		initialize();
	}

	public AnulacionTicket(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	public AnulacionTicket(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		initialize();
	}

	/**
	 * This method initializes jTxtUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTxtUsuario() {
		if (jTxtIdIMM == null) {
			jTxtIdIMM = new JTextField();
			jTxtIdIMM.setBounds(new Rectangle(104, 29, 184, 20));
		}
		return jTxtIdIMM;
	}

	/**
	 * This method initializes jBtnAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtnAceptar() {
		if (jBtnAceptar == null) {
			jBtnAceptar = new JButton();
			jBtnAceptar.setBounds(new Rectangle(147, 118, 107, 17));
			jBtnAceptar.setText("Aceptar");
			jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jTxtIdIMM.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Deba ingresar el id del ticket a anular","IdIMM", JOptionPane.ERROR_MESSAGE);
					}

					
					else {
						
						//ACA VA LA ANULACION DEL TICKET
						//t=m.altaTicket(jTxtMatricula.getText().toString(), cal,dura);
						if (m.anulaTicket(Long.parseLong(jTxtIdIMM.getText()))==null){
							
							
													
						}
						else {
							JOptionPane.showMessageDialog(null, "Hubo un problema con la anulación","Anulación", JOptionPane.ERROR_MESSAGE);
							jTxtIdIMM.setText("");
							
							
						}
					}
				}
			});	
		}
		return jBtnAceptar;
	}

	private void ocultar (){
		this.setVisible(false);
	}
	
	
	/**
	 * @param args
	 */
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Anulación de Ticket Estacionamiento");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(111, 97, 100, 17));
			jLabel1.setText("");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(16, 90, 76, 26));
			jLabel.setText("");

			jLblIdIMM = new JLabel();
			jLblIdIMM.setText("Ingrese ID: ");
			jLblIdIMM.setSize(new Dimension(78, 20));
			jLblIdIMM.setLocation(new Point(14, 30));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTxtUsuario(), null);
			jContentPane.add(jLblIdIMM, null);
			
			jContentPane.add(getJBtnAceptar(), null);

			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
		}
		return jContentPane;
	}




}
