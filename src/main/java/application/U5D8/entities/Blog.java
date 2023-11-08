package application.U5D8.entities;

import application.U5D8.enums.BlogCategory;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
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
    @JoinColumn(name = "user_id",nullable = false)
    private User utente;

}
