package mylab.user.di.annot;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean authenticate(String userId, String password) {
        System.out.println("Authenticating user: " + userId);
        return true;
    }

    public boolean authorize(String userId, String resource) {
        System.out.println("Authorizing user: " + userId + " for resource: " + resource);
        return true;
    }
}
