package blogapp.demo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


//id, comment
//gettery i settery
//powiązać audit entity

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public Long id;
    public String comment;

    @Embedded
    private AuditEntity audit = new AuditEntity();

    @ManyToOne //relacja wielu komentarzy do jednego posta.
    @JoinColumn(name = "postId") //żeby nie powiażał całej kolumny to wskazujemy którą kolumnę ma powiązać.
    private Post post;


}
