package blogapp.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String userName;
    private String emial;

}
