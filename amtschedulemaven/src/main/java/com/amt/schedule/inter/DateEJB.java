/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.entities.Date;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface DateEJB {
	public String creer(String jour, String debut, String fin);

	public Date lastDate();
}
