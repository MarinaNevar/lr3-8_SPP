package course.controller;

import course.dao.UserRepository;
import course.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;


/**
 * Created by Артем on 29.01.2017.
 */
@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody int createUser(HttpSession httpSession, @RequestBody User user) {
        if (userRepository.findByName(user.getName()) == null) {
            userRepository.save(user);
            httpSession.setAttribute("currentUserName", user.getName());
            return 200;
        } else {
            return 422;
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody int loginUser(HttpSession httpSession, @RequestBody User user) {
        User dbUser = userRepository.findByName(user.getName());
        if (dbUser != null && Objects.equals(user.getPassword(), dbUser.getPassword())) {
            httpSession.setAttribute("currentUserName", user.getName());
            return 200;
        } else {
            return 404;
        }
    }
}
