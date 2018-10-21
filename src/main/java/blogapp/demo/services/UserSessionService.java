package blogapp.demo.services;
import blogapp.demo.model.dto.UserDTO;
import blogapp.demo.model.entities.User;
import blogapp.demo.repositories.UserRepository;
import lombok.Getter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionService {

    @Getter
    private boolean logged;
    @Getter
    private UserDTO userDto;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public boolean loginUser(String userName, String password){
        Optional<User> optionalUser = userRepository.findByUserName(userName);

        if (!optionalUser.isPresent()){
            return false;
        }

        User user = optionalUser.get();

        if(!user.getPassword().equals(password)){
            return false;
        }

        userDto = modelMapper.map(user, UserDTO.class);
        logged = true;
        return logged;

    }

    public boolean logout(){
        logged = false;
        userDto = null;

        return true;
    }
}
