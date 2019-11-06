/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface SalleEJB {
	public String creer(String code, int contenance);

	public java.util.List<Salle> lister();

	public Salle chercher(String key);

	public String modifier(Salle salle, int contenance);

	public String supprimer(Salle salle);
}
