/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import java.sql.SQLException;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface NiveauEJB {
	public Niveau chercher(int key) throws SQLException;

	public java.util.List<Niveau> lister() throws SQLException;
}
