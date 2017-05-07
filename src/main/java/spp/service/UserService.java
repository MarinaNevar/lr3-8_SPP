package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.dto.UserDto;
import spp.entity.User;
import spp.entity.Vacancy;
import spp.repository.UserRepository;
import spp.repository.VacancyRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class UserService {

    private final HttpSessionService httpSessionService;

    private final UserRepository userRepository;

    @Autowired
    public UserService(HttpSessionService httpSessionService, UserRepository userRepository) {
        this.httpSessionService = httpSessionService;
        this.userRepository = userRepository;
    }

    public UserDto getCurrentUser(HttpSession httpSession){
        return httpSessionService.getUserFromSession(httpSession);
    }

    public User getOne(Long id) {
        return userRepository.findOne(id);
    }
}
