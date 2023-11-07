package papillon.colibri.corbeau.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("COURS")
public class CoursEntity {
    @Id
    @Column("ID")
    private Integer id;
    @Column("LIBELLE")
    private String libelle;
    @Column("DESCRIPTION")
    private String description;
    @Column("MISEAJOUR")
    private Date miseajour;
    @Column("ID_1")
    private Integer id_1;
    @Column("ID_2")
    private Integer id_2;
}
