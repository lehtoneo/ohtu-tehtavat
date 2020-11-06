package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }
        
        if (!password.equals(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
        
        char[] chars = username.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                status.addError("username has to contain only letters a-z");
            }
        }
        
        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }
        
        chars = password.toCharArray();
        boolean h = true;
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                h = false;
                break;
            }
        }
        if (h) {
            status.addError("password needs to have atleast one non-letter symbol");
        }

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
    
   private boolean invalid(String username, String password) {
        // validity check of username and password
        if (username.length() < 3 ) {
            return true;
        }
        
        char[] chars = username.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return true;
            }
        }
        
        if (password.length() < 8) {
            return true;
        }
        
        chars = password.toCharArray();
        boolean h = true;
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                h = false;
                break;
            }
        }
        
        return h;
    }

}
