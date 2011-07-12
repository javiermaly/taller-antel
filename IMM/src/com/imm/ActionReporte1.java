package com.imm;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionReporte1 extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){

		ActionForward retValue = null;
		FormReporte1 formulario = (FormReporte1) form;
		
		String [] f_ini;
		String [] f_fin;
		//String consulta;
		
		f_ini = formulario.getF_ini().split("/");
		f_fin = formulario.getF_fin().split("/");
		
		ManagerReporte mr = new ManagerReporte();
		Vector<Ticket> vec = mr.reporte1(f_ini, f_fin);
		
		System.out.println(vec.get(2).getMatricula());
		//consulta = "select * from tickets where fecha between '" + f_ini[2] + "-" + f_ini[1] + "-" + f_ini[0] + " 00:00:00' and '" + f_fin[2] + "-" + f_fin[1] + "-" + f_fin[0] + " 23:59:59'";

		//System.out.println(consulta);
		
		retValue = mapping.findForward("correcto");

		return retValue;
	}

}
