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
public interface MatiereEJB {
	public Matiere chercher(String key) throws SQLException;
}
