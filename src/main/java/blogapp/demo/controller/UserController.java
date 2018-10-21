package blogapp.demo.controller;

import blogapp.demo.model.entities.User;
import blogapp.demo.repositories.UserRepository;
import blogapp.demo.services.UserSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.jws.soap.SOAPBinding;

@Controller
public class UserController {

//    @Autowired
    public UserRepository userRepository;
//    @Autowired
    private UserSessionService userSessionService;
//    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserRepository userRepository,
                          UserSessionService userSessionService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userSessionService = userSessionService;
        this.modelMapper = modelMapper;
    }
}