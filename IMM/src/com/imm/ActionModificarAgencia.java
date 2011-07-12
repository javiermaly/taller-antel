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
			
			
			System.out.println(formulario.getId());
			
			if(ma.modificarAgencia(5, formulario.getDescripcion(), formulario.getUsuario(),formulario.getPassword(),formulario.isHabilitada()))
				retValue = mapping.findForward("agenciaModificada");
			
			return retValue;
		} 

}
