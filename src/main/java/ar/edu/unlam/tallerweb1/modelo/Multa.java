package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_infractor", nullable = false)
    private Usuario infractor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getInfractor() {
        return infractor;
    }

    public void setInfractor(Usuario infractor) {
        this.infractor = infractor;
    }

}
