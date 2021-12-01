package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Table(name = "Contacto", indexes = {
        @Index(name = "idx_contacto_name", columnList = "name")
})
@Transactional
@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;

    public String getName() { return name; }
    public void setName(String name){ this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email){ this.email = email; }

    public String getSubject() { return subject; }
    public void setSubject(String subject){ this.subject = subject; }

}
