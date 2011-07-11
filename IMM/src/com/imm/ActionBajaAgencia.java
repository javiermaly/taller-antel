package com.imm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionBajaAgencia extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		ActionForward retValue = null;
		FormBajaAgencia formulario = (FormBajaAgencia) form;
		
		ManagerAgencia ma= new ManagerAgencia();
		
		if(ma.eliminarAgencia(formulario.getId()))
			retValue = mapping.findForward("eliminada");
		
		return retValue;
	}

}
