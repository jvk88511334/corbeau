package papillon.colibri.corbeau.basetest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sauterelle", schema = "cn0qkvnh1b2cktjx")
public class SauterelleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Byte id;

    @Column(name = "COULEUR", nullable = false, length = 50)
    private String couleur;

    @Column(name = "NAISSANCE")
    private LocalDate naissance;
}

