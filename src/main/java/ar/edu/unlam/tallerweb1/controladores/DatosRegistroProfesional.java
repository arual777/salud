package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class DatosRegistroProfesional {
    private long id;
    private String nombreCompleto;
    private String email;
    private String experiencia;
    private String numeroTelefono;
    private String fechaNacimiento;
    private long idUsuario;
    private String foto;

    public DatosRegistroProfesional(){}

    public DatosRegistroProfesional(String nombreCompleto,String email, String experiencia, String numeroTelefono, String fechaNacimiento,
                                    long idUsuario, String foto) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.experiencia = experiencia;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
        this.idUsuario = idUsuario;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getIdUsuario() { return idUsuario;}

    public void setIdUsuario(long idUsuario) {this.idUsuario = idUsuario;}

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
