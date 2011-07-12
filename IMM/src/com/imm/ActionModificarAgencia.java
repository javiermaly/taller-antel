package com.imm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionModificarAgencia extends Action {
	
		public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
			
			ActionForward retValue = null;
			FormModificarAgencia formulario = (FormModificarAgencia) form;
			
			
			ManagerAgencia ma= new ManagerAgencia();
			boolean hab;
			
			System.out.println("ID: "+formulario.getId());
			System.out.println("habilitada????: "+formulario.isHabilitada());
			
			
			
			if(ma.modificarAgencia(formulario.getId(), formulario.getDescripcion(), formulario.getUsuario(),formulario.getPassword(),formulario.isHabilitada()))
				retValue = mapping.findForward("agenciaModificada");
			else
				retValue = mapping.findForward("agenciaNoModificada");
			
			return retValue;
		} 

}
