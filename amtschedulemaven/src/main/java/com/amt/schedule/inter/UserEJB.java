package com.amt.schedule.inter;

import com.amt.schedule.entities.Role;
import com.amt.schedule.entities.User;
import com.amt.schedule.utility.InvalidCredentialsException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserEJB {
    public String creer(String matricule, String nom, Role role);
    public User chercher(int userid);
    public User chercher(String username);
    public List<User> list(Role role);
    public String delete(User user);
    public String edit(User user, String username, String firstname, Role role);
    public User login(String username, String pass, String status) throws InvalidCredentialsException;
}
