package panaderia;

public class Mensajero extends Trabajador {

    private String arl;
    private String eps;
    private String pension;

    public Mensajero(String arl, String eps, String pension, String cedula, String nombre, String apellido, int edad) {
        
        super(cedula, nombre, apellido, edad);
        this.arl = arl;
        this.eps = eps;
        this.pension = pension;
    }

    public Mensajero(String cedula, String nombre, String apellido, int edad) {

        super(cedula, nombre, apellido, edad);
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }
}
