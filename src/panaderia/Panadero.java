package panaderia;

public class Panadero extends Trabajador{

    private int añosExperiencia;

    public Panadero(int añosExperiencia, String cedula, String nombre, String apellido, int edad) {
        
        super(cedula, nombre, apellido, edad);
        this.añosExperiencia = añosExperiencia;
    }

    public Panadero(String cedula, String nombre, String apellido, int edad) {
        
        super(cedula, nombre, apellido, edad);
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

}
