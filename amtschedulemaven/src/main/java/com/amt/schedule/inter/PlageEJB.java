/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.entities.Plage;
import com.amt.schedule.entities.Salle;

import java.sql.SQLException;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface PlageEJB {
	public String creer(String jour, String debut, String fin, Salle salle) throws SQLException;

	public java.util.List<Plage> lister(Salle salle);

	public String modifier(Plage plage, String jour, String debut, String fin) throws SQLException;

	public String supprimer(Plage plage);

	public java.util.List<Plage> libre() throws SQLException;

	public java.util.List<Plage> libre(String jour, String debut, String fin) throws SQLException;

	public java.util.List<Plage> libreEv(String jour, String debut, String fin,
			int contenance) throws SQLException;

	public Plage chercher(int key) throws SQLException;
}
