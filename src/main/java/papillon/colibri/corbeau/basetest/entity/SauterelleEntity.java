package papillon.colibri.corbeau.basetest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@NoArgsConstructor
@Table("sauterelle")
public class SauterelleEntity {
    @Id
    @Column("ID")
    private Integer Id;
    @Column("COULEUR")
    private String couleur;
    @Column("NAISSANCE")
    private Date naissance;
}
