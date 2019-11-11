package com.amt.schedule.inter;

import com.amt.schedule.entities.Role;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RoleEJB {
    public Role chercher(String role);
    public List<Role> list();
    public String creer(String role);
    public String delete(Role role);
}
