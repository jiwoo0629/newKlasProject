package jiwoo.newKlasProject.Controller;

import jiwoo.newKlasProject.Entity.User;
import jiwoo.newKlasProject.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/resetPW")
    public ResponseEntity<HttpStatus> resetPW (@RequestParam("id") String id) {
        User user = userService.getUser(id);
        user.resetPW();
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
