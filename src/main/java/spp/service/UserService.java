package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.dto.UserDto;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class UserService {

    private final HttpSessionService httpSessionService;

    @Autowired
    public UserService(HttpSessionService httpSessionService) {
        this.httpSessionService = httpSessionService;
    }

    public UserDto getCurrentUser(HttpSession httpSession){
        return httpSessionService.getUserFromSession(httpSession);
    }
}
