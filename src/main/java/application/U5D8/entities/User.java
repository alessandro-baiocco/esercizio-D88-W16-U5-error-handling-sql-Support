package application.U5D8.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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
        @OneToMany
        private List<Blog> blogs;

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", nome='" + nome + '\'' +
                        ", cognome='" + cognome + '\'' +
                        ", email='" + email + '\'' +
                        ", dataDiNascita=" + dataDiNascita +
                        ", userPicture='" + userPicture + '\'' +
                        '}';
        }
}
