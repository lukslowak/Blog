package blogapp.demo.configure;

import blogapp.demo.model.dto.PostDTO;
import blogapp.demo.model.entities.Post;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

@Configuration
public class BasicConfiguration {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDTO.class)
                .addMapping(pst-> pst.getUser().getId(), PostDTO::setIdOfUser)
                .addMapping(p -> p.getAudit().getAdded(), PostDTO::setCreated);
        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}