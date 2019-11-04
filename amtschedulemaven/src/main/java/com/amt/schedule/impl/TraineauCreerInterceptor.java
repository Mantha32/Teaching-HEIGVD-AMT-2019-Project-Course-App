/**
 * 
 */
package com.amt.schedule.impl;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.amt.schedule.inter.CoursEJB;
import com.amt.schedule.inter.PlageEJB;
import com.amt.schedule.entities.Dispenser;
import com.amt.schedule.entities.Plage;
import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.inter.DispenserEJB;

/**
 * @author doriane kaffo
 * 
 */
public class TraineauCreerInterceptor {
	@EJB
	private CoursEJB cours;

	@EJB
	private DispenserEJB dispenser;

	@EJB
	private PlageEJB plage;

	@AroundInvoke
	public Object creer(InvocationContext context) throws Exception {
		Utilisateur user = (Utilisateur) context.getParameters()[3];
		java.util.List<Dispenser> disps = dispenser.select(user);
		if (disps.size() > 0) {
			Dispenser disp = disps.get(0);
			dispenser.occuper(disp.getUtilisateur(), disp.getMatiere());
			java.util.List<Plage> libres = plage.libre();
			if (libres.size() > 0) {
				cours.creer(user, disp.getMatiere(), plage.libre().get(0),
						disp.getType());
				return context.proceed();
			} else
				return "Aucune plage libre trouve!!!";
		} else {
			return context.proceed();
		}
	}
}
