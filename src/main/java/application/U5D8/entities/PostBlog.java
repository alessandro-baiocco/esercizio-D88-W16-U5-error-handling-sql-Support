package application.U5D8.entities;

import application.U5D8.enums.BlogCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostBlog {
        private BlogCategory blogCategory;
        private String titolo;
        private String cover;
        private String contenuto;
        private int tempoDiLettura;
        private int utente_id;
    }

