package com.imm;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionLoggin extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		boolean e = false;
		ActionForward retValue = null;
		FormLoggin formulario = (FormLoggin) form;
		
		ManagerUsuario mu = new ManagerUsuario();
		e = mu.login(formulario.getUsu(), formulario.getPass());
		
		
		if (e == true) {
			retValue = mapping.findForward("correcto");
		} else {
			retValue = mapping.findForward("incorrecto");
		}

		return retValue;
	}

}
