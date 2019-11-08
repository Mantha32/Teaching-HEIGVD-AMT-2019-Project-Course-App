package ch.heigvd.amt.schedule.service.DAO;

import ch.heigvd.amt.schedule.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class LoginManager implements LoginManagerLocal {

    @EJB
    private UserManagerLocal userManager;

    @Override
    public User infoUserLogged(String username, String password) {
        User myUser = null;
        try {
                myUser = userManager.findUser(username,password);

        } catch (Exception e) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return myUser;
    }

    @Override
    public boolean isRightCredentials(String username, String password) {
        User myUser = null;
        boolean loginSuccess = false;

        try {

            myUser = userManager.findUser(username);
            loginSuccess = password.equals(myUser.getHashedPassword());

        } catch (Exception e) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }

        return loginSuccess;
    }
}
