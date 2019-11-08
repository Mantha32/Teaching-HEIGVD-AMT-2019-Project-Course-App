package ch.heigvd.amt.schedule.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String hashedPassword;
    private String email;
    private boolean isAdmin;

    public boolean isAdmin(){
        return isAdmin;
    }
}
