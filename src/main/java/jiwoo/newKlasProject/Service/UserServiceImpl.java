package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.Entity.User;
import jiwoo.newKlasProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User getUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return user;
    }
}
