package exceptions;

import javax.swing.JOptionPane;

public class TerminalTimeOutException {
	
	public void mostrarErrorTimeOut(){
		JOptionPane.showMessageDialog(null, "Hubo un problema con la operacion, intente mas tarde.","Time Out", JOptionPane.ERROR_MESSAGE);	
	}
	
}
