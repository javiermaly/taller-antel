package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;


import com.terminal.Manager;
import com.terminal.Ticket;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Calendar;

public class AltaTicket extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTxtMatricula = null;
	private JLabel jLblMatricula = null;
	private JLabel jLblDuracion = null;
	private JButton jBtnAceptar = null;
	Manager m= new Manager();  //  @jve:decl-index=0:
	private JTextField jTxtDuracion = null;
	Ticket t = new Ticket();  //  @jve:decl-index=0:
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	String calend="";  //  @jve:decl-index=0:
	int dura=0;
	
	
	public AltaTicket() {
		super();
		initialize();
	}
		
	

	public AltaTicket(GraphicsConfiguration arg0) {
		super(arg0);
		initialize();
	}

	public AltaTicket(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	public AltaTicket(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		initialize();
	}

	/**
	 * This method initializes jTxtUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTxtUsuario() {
		if (jTxtMatricula == null) {
			jTxtMatricula = new JTextField();
			jTxtMatricula.setBounds(new Rectangle(104, 29, 184, 20));
		}
		return jTxtMatricula;
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
					if (jTxtMatricula.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Deba ingresar la matricula","Matricula", JOptionPane.ERROR_MESSAGE);
					}

					else if (jTxtDuracion.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Ingrese los minutos a contratar","Login", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Calendar cal=Calendar.getInstance();
						//calend=Funciones.calendar2String(cal, true);
						dura=Integer.parseInt(jTxtDuracion.getText().toString());
						t=m.altaTicket(jTxtMatricula.getText().toString(), cal,dura);
						if (t.getFechaVenta()!=null){
							
							jLabel1.setText(t.getIdVenta());
							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Hubo un problema con la venta. Intente mas tarde.","Venta", JOptionPane.ERROR_MESSAGE);
							jTxtMatricula.setText("");
							jTxtDuracion.setText("");
							
							
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
		this.setTitle("Venta de Ticket Estacionamiento");
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
			jLabel.setText("Id Venta: ");
			jLblDuracion = new JLabel();
			jLblDuracion.setText("Minutos:");
			jLblDuracion.setLocation(new Point(15, 62));
			jLblDuracion.setSize(new Dimension(63, 20));
			jLblMatricula = new JLabel();
			jLblMatricula.setText("Matricula: ");
			jLblMatricula.setSize(new Dimension(78, 20));
			jLblMatricula.setLocation(new Point(14, 30));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTxtUsuario(), null);
			jContentPane.add(jLblMatricula, null);
			jContentPane.add(jLblDuracion, null);
			jContentPane.add(getJBtnAceptar(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
		}
		return jContentPane;
	}



	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTxtDuracion == null) {
			jTxtDuracion = new JTextField();
			jTxtDuracion.setBounds(new Rectangle(104, 62, 39, 20));
		}
		return jTxtDuracion;
	}
	
//	public static void main(String args[]){
//		AltaTicket t= new AltaTicket();
//		t.show();
//	}
}  
