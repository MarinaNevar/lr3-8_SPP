package spp.controller;

import spp.dao.UserRepository;
import spp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spp.service.AuthService;

import javax.servlet.http.HttpSession;
import java.util.Objects;


/**
 * Created by Артем on 29.01.2017.
 */
@Controller
@RequestMapping("/")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody int createUser(HttpSession httpSession, @RequestBody User user) {
        return authService.createUser(httpSession, user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody int loginUser(HttpSession httpSession, @RequestBody User user) {
        return authService.validateUser(httpSession, user);
    }
}
