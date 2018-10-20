package blogapp.demo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Embeddable // trzeba dać, że hibernate wiedział to to trzeba powiążacać
public class AuditEntity {
    private Date added = new Date();
    private String addedBy;
    private Date modified;
    private String modifiedBy;

}
