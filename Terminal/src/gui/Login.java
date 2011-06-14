package gui;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import com.terminal.Conexion;
import com.terminal.Manager;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Login extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel jContentPane = null;
		private JTextField jTxtUsuario = null;
		private JPasswordField jPwdClave = null;
		private JLabel jLblUsuario = null;
		private JLabel jLblClave = null;
		private JButton jBtnAceptar = null;
		Manager m= new Manager();
		AltaTicket at=new AltaTicket();
		
		
		public Login() throws HeadlessException {
			super();
			initialize();
		}

		public Login(GraphicsConfiguration arg0) {
			super(arg0);
			initialize();
		}

		public Login(String arg0) throws HeadlessException {
			super(arg0);
			initialize();
		}

		public Login(String arg0, GraphicsConfiguration arg1) {
			super(arg0, arg1);
			initialize();
		}

		/**
		 * This method initializes jTxtUsuario	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getJTxtUsuario() {
			if (jTxtUsuario == null) {
				jTxtUsuario = new JTextField();
				jTxtUsuario.setBounds(new Rectangle(104, 29, 184, 20));
			}
			return jTxtUsuario;
		}

		/**
		 * This method initializes jPwdClave	
		 * 	
		 * @return javax.swing.JPasswordField	
		 */
		private JPasswordField getJPwdClave() {
			if (jPwdClave == null) {
				jPwdClave = new JPasswordField();
				jPwdClave.setSize(new Dimension(184, 20));
				jPwdClave.setLocation(new Point(103, 66));
			}
			return jPwdClave;
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
						if (jTxtUsuario.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Ingrese su usuario","Login", JOptionPane.ERROR_MESSAGE);
						}
	
						else if (jPwdClave.getPassword().length == 0) {
							JOptionPane.showMessageDialog(null, "Ingrese su clave","Login", JOptionPane.ERROR_MESSAGE);
						}
						else {
							// Verifico usuario y clave en archivo.
							if (m.login(jTxtUsuario.getText().toString(), jPwdClave.getPassword().toString())){
								ocultar();
								at.setVisible(true);
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Usuario y/o clave incorrectos","Login", JOptionPane.ERROR_MESSAGE);
								jTxtUsuario.setText("");
								jPwdClave.setText("");
								
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
			this.setTitle("Login");
		}

		/**
		 * This method initializes jContentPane
		 * 
		 * @return javax.swing.JPanel
		 */
		private JPanel getJContentPane() {
			if (jContentPane == null) {
				jLblClave = new JLabel();
				jLblClave.setText("Clave:");
				jLblClave.setLocation(new Point(14, 67));
				jLblClave.setSize(new Dimension(57, 20));
				jLblUsuario = new JLabel();
				jLblUsuario.setText("Usuario:");
				jLblUsuario.setSize(new Dimension(78, 20));
				jLblUsuario.setLocation(new Point(14, 30));
				jContentPane = new JPanel();
				jContentPane.setLayout(null);
				jContentPane.add(getJTxtUsuario(), null);
				jContentPane.add(getJPwdClave(), null);
				jContentPane.add(jLblUsuario, null);
				jContentPane.add(jLblClave, null);
				jContentPane.add(getJBtnAceptar(), null);
			}
			return jContentPane;
		}
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Login thisClass = new Login();
					thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					thisClass.setVisible(true);
				}
			});
		}

	

	
}
