package blogapp.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor  //daje nam konstruktor który zaiwera wszystkie pola
public class PostDTO {

//DTO MA TYLKO POLA GETERY STERY I POLA

    private Long id;
    private String title;
    private String content;
    private Long idOfUser;
    private Date created;



}
