package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.dao.UserRepository;
import spp.domain.User;
import spp.dto.SessionDTO;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final HttpSessionService httpSessionService;

    @Autowired
    public AuthService(UserRepository userRepository, HttpSessionService httpSessionService) {
        this.userRepository = userRepository;
        this.httpSessionService = httpSessionService;
    }


    public int createUser(HttpSession httpSession, User user) {
        if (userRepository.findByName(user.getName()) == null) {
            user.setAuthorityId(1);
            User savedUser = userRepository.save(user);
            httpSessionService.setDataToSession(httpSession, new SessionDTO("currentUserName", savedUser.getName()));
            httpSessionService.setDataToSession(httpSession, new SessionDTO("currentUserAuthorityID", savedUser.getAuthorityId()));
            return 200;
        } else {
            return 422;
        }
    }

    public int validateUser(HttpSession httpSession, User user) {
        User dbUser = userRepository.findByName(user.getName());
        if (dbUser != null && Objects.equals(user.getPassword(), dbUser.getPassword())) {
            httpSessionService.setDataToSession(httpSession, new SessionDTO("currentUserName", dbUser.getName()));
            httpSessionService.setDataToSession(httpSession, new SessionDTO("currentUserAuthorityID", dbUser.getAuthorityId()));
            return 200;
        } else {
            return 404;
        }
    }
}
