package application.U5D8.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nome;
        private String cognome;
        private String email;
        private LocalDate dataDiNascita;
        private String userPicture;
        @OneToMany(mappedBy = "utente")
        @ToString.Exclude
        private List<Blog> blogs;



}
