package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.Entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User getUser(String id);
}
