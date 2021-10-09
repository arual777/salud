package ar.edu.unlam.tallerweb1.controladores;

public class DatosRegistroProfesional {
    private String nombreCompleto;
    private String email;
    private String experiencia;
    private String numeroTelefono;

    public DatosRegistroProfesional(){}

    public DatosRegistroProfesional(String nombreCompleto,String email, String experiencia, String numeroTelefono) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.experiencia = experiencia;
        this.numeroTelefono = numeroTelefono;
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
}
