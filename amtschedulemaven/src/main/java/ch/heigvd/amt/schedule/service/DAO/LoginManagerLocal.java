package ch.heigvd.amt.schedule.service.DAO;
import ch.heigvd.amt.schedule.model.User;

import javax.ejb.Local;

@Local
public interface LoginManagerLocal {
    public User infoUserLogged(String username, String password);
    public boolean isRightCredentials(String username, String password);
}
