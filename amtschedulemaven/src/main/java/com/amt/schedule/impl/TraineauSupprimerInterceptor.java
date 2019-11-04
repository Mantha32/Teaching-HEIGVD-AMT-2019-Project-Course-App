/**
 * 
 */
package com.amt.schedule.impl;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.amt.schedule.inter.CoursEJB;
import com.amt.schedule.entities.Cours;
import com.amt.schedule.inter.DispenserEJB;
import com.amt.schedule.inter.TraineauEJB;

/**
 * @author doriane kaffo
 * 
 */
public class TraineauSupprimerInterceptor {
	@EJB
	private CoursEJB cours;

	@EJB
	private DispenserEJB dispenser;

	@EJB
	private TraineauEJB traineau;

	@AroundInvoke
	public Object supprimer(InvocationContext context) throws Exception {
		int num = (Integer) context.getParameters()[0];
		Cours coursD = cours.supprimer(traineau.chercher(num));
		if (coursD != null)
			dispenser.liberer(coursD.getUtilisateur(), coursD.getMatiere());
		return context.proceed();
	}
}
