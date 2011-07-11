package com.imm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionAltaAgencia extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		ActionForward retValue = null;
		FormAltaAgencia formulario = (FormAltaAgencia) form;
		
		ManagerAgencia ma= new ManagerAgencia();
		
		ma.altaAgencia(formulario.getUsuario(),formulario.getPassword(), formulario.getNombre());
				
		retValue = mapping.findForward("correcto");
		
		return retValue;
	}

}
