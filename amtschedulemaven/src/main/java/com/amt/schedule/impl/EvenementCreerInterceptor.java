/**
 * 
 */
package com.amt.schedule.impl;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.amt.schedule.inter.DateEJB;
import com.amt.schedule.inter.PlageEJB;
import com.amt.schedule.entities.Date;
import com.amt.schedule.entities.Niveau;
import com.amt.schedule.entities.Plage;
import com.amt.schedule.entities.Utilisateur;

/**
 * @author doriane kaffo
 * 
 */
public class EvenementCreerInterceptor {
	@EJB
	private PlageEJB plage;

	@EJB
	private DateEJB dateI;

	@AroundInvoke
	public Object creer(InvocationContext context) throws Exception {
		Utilisateur user = (Utilisateur) context.getParameters()[0];
		Niveau niveau = (Niveau) context.getParameters()[2];
		Date date = (Date) context.getParameters()[3];
		String titre = (String) context.getParameters()[4];
		int contenance = (Integer) context.getParameters()[5];

		String jour = date.getJour();
		String debut = date.getDebut();
		String fin = date.getFin();
		java.util.List<Plage> plages = plage.libreEv(jour, debut, fin,
				contenance);
		Plage pl = null;

		if (plages.size() > 0) {
			pl = plages.get(0);
			dateI.creer(jour, debut, fin);
			date = dateI.lastDate();

			context.setParameters(new Object[] { user, pl, niveau, date, titre,
					contenance });
			return context.proceed();
		}
		return "Aucune plage libre trouve";
	}
}
