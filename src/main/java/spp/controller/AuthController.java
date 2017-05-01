package spp.controller;

import spp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spp.dto.UserDto;
import spp.service.AuthService;
import spp.service.UserService;

import javax.servlet.http.HttpSession;


/**
 * Created by Артем on 29.01.2017.
 */
@Controller
@RequestMapping("/")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody int createUser(HttpSession httpSession, @RequestBody User user) {
        return authService.createUser(httpSession, user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody int loginUser(HttpSession httpSession, @RequestBody User user) {
        return authService.validateUser(httpSession, user);
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public @ResponseBody UserDto getCurrentUser(HttpSession httpSession) {
        return userService.getCurrentUser(httpSession);
    }

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public @ResponseBody int logout(HttpSession httpSession) {
        httpSession.removeAttribute("currentUserName");
        httpSession.removeAttribute("currentUserAuthorityID");
        return 200;
    }
}
