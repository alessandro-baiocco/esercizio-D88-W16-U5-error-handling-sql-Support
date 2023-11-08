package application.U5D8.entities;

import application.U5D8.enums.BlogCategory;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private BlogCategory blogCategory;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User utente;


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", blogCategory=" + blogCategory +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoDiLettura=" + tempoDiLettura;
    }
}
