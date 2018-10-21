package blogapp.demo.security;

import blogapp.demo.model.entities.User;
import blogapp.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(username);
        if(!userOptional.isPresent()){
            throw new UsernameNotFoundException("Nie znaleziono użytkownika " + username);
        }

        User user = userOptional.get();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if("admin".equals(user.getUserName())){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

//        CustomUserDetails userDetails =
//                new CustomUserDetails(
//                username, user.getPassword()
//                , true, true, true, true
//                , grantedAuthorities);
//        userDetails.setEmail(user.getEmail());

        UserDetails userDetails =
                new CustomUserDetails(
                        username, user.getPassword()
                        , true, true, true, true
                        , grantedAuthorities
                        , user.getEmail());

        return userDetails;
    }
}