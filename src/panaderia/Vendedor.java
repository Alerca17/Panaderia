package panaderia;

public class Vendedor extends Trabajador {

    private int añosExperiencia;
    private String eps;

    public Vendedor(int añosExperiencia, String eps, String cedula, String nombre, String apellido, int edad) {
        
        super(cedula, nombre, apellido, edad);
        this.añosExperiencia = añosExperiencia;
        this.eps = eps;
    }

    public Vendedor(String cedula, String nombre, String apellido, int edad) {
        
        super(cedula, nombre, apellido, edad);
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}
