package ws;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.xml.rpc.ServiceException;

public class PruebaWsIMM {
	public static void main(String arg[]){
		WsServiceLocator WSL = new WsServiceLocator();

			
		Calendar dia = Calendar.getInstance();
		
		Ws wst;
		try {
			wst = WSL.getWsPort();
			System.out.println(wst.venta("us", "ps", "matricula2", dia, 24));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
}