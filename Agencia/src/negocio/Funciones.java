package negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Funciones {
	public static String calendar2String (Calendar c, boolean blnConHora){
		// Devuelve una fecha en texto con formato yyyy-mm-dd.
		SimpleDateFormat sdf = null;
		if (blnConHora){
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
		else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		return sdf.format(c.getTime());
	}

	public static Calendar string2Calendar (String s, boolean blnConHora){
		SimpleDateFormat sdf = null;
		if (blnConHora){
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
		else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date d = null;
		try {
			d = sdf.parse(s);
		} catch (ParseException e1) {
			d = new Date();
			e1.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		System.out.println(d.toString());
		return cal;
	}
	
	public static void main(String[] args) {
		Calendar c;
		c = string2Calendar("2011-05-31 11:22:33",true);
		System.out.println(c);
	}
}
