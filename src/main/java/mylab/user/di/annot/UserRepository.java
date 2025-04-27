package mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Value("${dbType:mysql}")
    private String dbType;

    public String getDbType() {
        return dbType;
    }

    public boolean saveUser(String userId, String name) {
        System.out.println("Saving user: " + userId + ", " + name);
        return true;
    }
}
