package ar.edu.unlam.tallerweb1.controladores;

public class DatosServicio {

    private String name;
    private String descripcion;
    private String tarifa;

    public DatosServicio() {
    }

    public DatosServicio(String name, String descripcion, String tarifa) {
        this.name = name;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //public Double getTarifa() {
    //  return tarifa;
    //}

    //public void setTarifa(String tarifa) {
    //  this.tarifa = tarifa;
//}
}
