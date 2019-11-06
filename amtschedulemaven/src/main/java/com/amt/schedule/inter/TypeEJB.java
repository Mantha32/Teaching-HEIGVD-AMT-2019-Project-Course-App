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
public interface TypeEJB {
	public String creer(String statut);

	public java.util.List<Type> lister() throws SQLException;

	public Type chercher(String statut) throws SQLException;
}
