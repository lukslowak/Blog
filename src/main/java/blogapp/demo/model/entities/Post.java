package blogapp.demo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    //id, title, content
    @Id //id w tabeli
    @GeneratedValue (strategy = GenerationType.AUTO) // dotyczy ID
    public Long id;
    public String title;
    public String content;

    @Embedded // trzeba dać, że hibernate wiedział to to trzeba powiążacać
    private AuditEntity audit = new AuditEntity();

    @OneToMany(mappedBy = "post") // nazywamy relację w bazie danych - jeden post ma wiele commentów
    private Set<PostComment> comments = new HashSet<>();




}