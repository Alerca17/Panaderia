package panaderia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GestionDatos {

    public GestionDatos() {
    }

    public void filtrarPension(String pension) {

        ArrayList<Trabajador> busqueda;
        StringBuilder fPension = new StringBuilder();

        busqueda = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt");

        for (Trabajador trabajador : busqueda) {

            Mensajero mensajero = (Mensajero) trabajador;

            if (mensajero.getPension().equalsIgnoreCase(pension)) {

                fPension.append("Cargo: Mensajero ").append(" | ").append("Nombre: ").append(mensajero.getNombre()).append(" | ").append("Apellido: ").append(mensajero.getApellido()).append(" | ").append("Cedula: ").append(mensajero.getCedula()).append(" | ").append("Edad: ").append(mensajero.getEdad()).append(" | ").append("EPS: ").append(mensajero.getEps()).append(" | ").append("ARL: ").append(mensajero.getArl()).append(" | ").append("Pension: ").append(mensajero.getPension()).append("\n");

            }
        }

        if (fPension.isEmpty()) {

            JOptionPane.showMessageDialog(null, "NO HAY TRABAJADORES CON REGISTRADOS CON " + pension, "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, fPension.toString(), "Filtrados Por Pension", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void porcentajeEps(String EPS) {

        ArrayList<Trabajador> busqueda;
        int personas = 0;

        busqueda = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt");

        for (Trabajador trabajador : busqueda) {

            Mensajero mensajero = (Mensajero) trabajador;

            if (mensajero.getEps().equalsIgnoreCase(EPS)) {

                personas = personas + 1;
            }

        }

        busqueda = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt");

        for (Trabajador trabajador : busqueda) {

            Vendedor vendedor = (Vendedor) trabajador;

            if (vendedor.getEps().equalsIgnoreCase(EPS)) {

                personas = personas + 1;
            }
        }

        if (personas == 0) {

            JOptionPane.showMessageDialog(null, "NO HAY TRABAJADORES CON ESA EPS", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            float porcentaje = ((float) personas / totalTrabajadores()) * 100;
            JOptionPane.showMessageDialog(null, "Porcentaje: " + String.format("%.1f", porcentaje) + "% De Las Personas", "Años De Experiencia", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public int totalTrabajadores() {

        ArrayList<Trabajador> totalTrabajadores = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt");

        return totalTrabajadores.size();

    }

    public void promedioExperiencia(int A, int B) {

        ArrayList<Trabajador> busqueda;
        int personas = 0;

        busqueda = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Panaderos.txt");

        for (Trabajador trabajador : busqueda) {

            Panadero panadero = (Panadero) trabajador;

            if (panadero.getAñosExperiencia() >= A && panadero.getAñosExperiencia() <= B) {

                personas = personas + 1;
            }

        }

        busqueda = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt");

        for (Trabajador trabajador : busqueda) {

            Vendedor vendedor = (Vendedor) trabajador;

            if (vendedor.getAñosExperiencia() >= A && vendedor.getAñosExperiencia() <= B) {

                personas = personas + 1;
            }
        }

        if (personas == 0) {

            JOptionPane.showMessageDialog(null, "NO HAY TRABAJADORES CON ESE RANGO DE EXPERIENCIA", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            float promedio = ((float) personas / totalTrabajadores()) * 100;
            JOptionPane.showMessageDialog(null, "Promedio: " + String.format("%.1f", promedio) + "% De Las Personas", "Años De Experiencia", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public void buscarTrabajador(String cedula) {

        StringBuilder encontrado = new StringBuilder();
        ArrayList<Trabajador> buscar;

        if (validarTrabajador(cedula)) {

            buscar = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Panaderos.txt");

            for (Trabajador trabajador : buscar) {

                Panadero panadero = (Panadero) trabajador;

                if (panadero.getCedula().equals(cedula)) {

                    encontrado.append("Cargo: Panadero ").append(" | ").append("Nombre: ").append(panadero.getNombre()).append(" | ").append("Apellido: ").append(panadero.getApellido()).append(" | ").append("Cedula: ").append(panadero.getCedula()).append(" | ").append("Edad: ").append(panadero.getEdad()).append(" | ").append("Años De Experiencia: ").append(panadero.getAñosExperiencia()).append("\n");
                    break;
                }
            }

            buscar = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt");

            for (Trabajador trabajador : buscar) {

                Vendedor vendedor = (Vendedor) trabajador;

                if (vendedor.getCedula().equals(cedula)) {

                    encontrado.append("Cargo: Vendedor ").append(" | ").append("Nombre: ").append(vendedor.getNombre()).append(" | ").append("Apellido: ").append(vendedor.getApellido()).append(" | ").append("Cedula: ").append(vendedor.getCedula()).append(" | ").append("Edad: ").append(vendedor.getEdad()).append(" | ").append("Años De Experiencia: ").append(vendedor.getAñosExperiencia()).append(" | ").append("EPS: ").append(vendedor.getEps()).append("\n");
                    break;
                }
            }

            buscar = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt");

            for (Trabajador trabajador : buscar) {

                Mensajero mensajero = (Mensajero) trabajador;

                if (mensajero.getCedula().equals(cedula)) {

                    encontrado.append("Cargo: Mensajero ").append(" | ").append("Nombre: ").append(mensajero.getNombre()).append(" | ").append("Apellido: ").append(mensajero.getApellido()).append(" | ").append("Cedula: ").append(mensajero.getCedula()).append(" | ").append("Edad: ").append(mensajero.getEdad()).append(" | ").append("EPS: ").append(mensajero.getEps()).append(" | ").append("ARL: ").append(mensajero.getArl()).append(" | ").append("Pension: ").append(mensajero.getPension()).append("\n");
                    break;
                }
            }

            JOptionPane.showMessageDialog(null, encontrado.toString(), "Trabajadores", JOptionPane.INFORMATION_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "EL TRABAJADOR CON LA CEDULA " + cedula + " NO SE ENCUENTRA REGISTRADO", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mostrarTrabajadores(String nombreArchivo) {

        StringBuilder personal = new StringBuilder();
        int personas = 1;

        if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt".equals(nombreArchivo)) {

            ArrayList<Trabajador> arrayTrabajador = leerTrabajadores(nombreArchivo);

            for (Trabajador t : arrayTrabajador) {

                personal.append(personas).append(").").append(" Nombre: ").append(t.getNombre()).append(" | ").append("Apellido: ").append(t.getApellido()).append(" | ").append("Cedula: ").append(t.getCedula()).append(" | ").append("Edad: ").append(t.getEdad()).append("\n");
                personas++;
            }

        }

        if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Panaderos.txt".equals(nombreArchivo)) {

            ArrayList<Trabajador> arrayPanadero = leerTrabajadores(nombreArchivo);

            for (Trabajador p : arrayPanadero) {

                if (personas == 11) {

                    break;
                }
                Panadero panadero = (Panadero) p;
                personal.append(personas).append(").").append(" Nombre: ").append(panadero.getNombre()).append(" | ").append("Apellido: ").append(panadero.getApellido()).append(" | ").append("Cedula: ").append(panadero.getCedula()).append(" | ").append("Edad: ").append(panadero.getEdad()).append(" | ").append("Años De Experiencia: ").append(panadero.getAñosExperiencia()).append("\n");
                personas++;
            }

        }

        if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt".equals(nombreArchivo)) {

            ArrayList<Trabajador> arrayVendedor = leerTrabajadores(nombreArchivo);

            for (Trabajador p : arrayVendedor) {

                if (personas == 11) {

                    break;
                }

                Vendedor vendedor = (Vendedor) p;
                personal.append(personas).append(").").append(" Nombre: ").append(vendedor.getNombre()).append(" | ").append("Apellido: ").append(vendedor.getApellido()).append(" | ").append("Cedula: ").append(vendedor.getCedula()).append(" | ").append("Edad: ").append(vendedor.getEdad()).append(" | ").append("Años De Experiencia: ").append(vendedor.getAñosExperiencia()).append(" | ").append("EPS: ").append(vendedor.getEps()).append("\n");
                personas++;
            }
        }

        if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt".equals(nombreArchivo)) {

            ArrayList<Trabajador> arrayMensajero = leerTrabajadores(nombreArchivo);

            for (Trabajador p : arrayMensajero) {

                if (personas == 11) {

                    break;
                }

                Mensajero mensajero = (Mensajero) p;
                personal.append(personas).append(").").append(" Nombre: ").append(mensajero.getNombre()).append(" | ").append("Apellido: ").append(mensajero.getApellido()).append(" | ").append("Cedula: ").append(mensajero.getCedula()).append(" | ").append("Edad: ").append(mensajero.getEdad()).append(" | ").append("EPS: ").append(mensajero.getEps()).append(" | ").append("ARL: ").append(mensajero.getArl()).append(" | ").append("Pension: ").append(mensajero.getPension()).append("\n");
                personas++;
            }

        }

        JOptionPane.showMessageDialog(null, personal.toString(), "Trabajadores", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean validarTrabajador(String cedula) {

        ArrayList<Trabajador> validar = leerTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt");

        boolean swt = false;

        for (Trabajador trabajador : validar) {

            if (trabajador.getCedula().equals(cedula)) {

                swt = true;
                break;
            }
        }
        return swt;
    }

    public ArrayList<Trabajador> leerTrabajadores(String nombreArchivo) {

        File fichero = new File(nombreArchivo);
        Scanner s = null;
        ArrayList<Trabajador> datos = new ArrayList();

        try {

            s = new Scanner(fichero);

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] cortarString = linea.split("/");

                if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt".equals(nombreArchivo)) {

                    Trabajador trabajador = new Trabajador(cortarString[2], cortarString[0], cortarString[1], Integer.parseInt(cortarString[3]));
                    datos.add(trabajador);
                }

                if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Panaderos.txt".equals(nombreArchivo)) {

                    Panadero panadero = new Panadero(cortarString[2], cortarString[0], cortarString[1], Integer.parseInt(cortarString[3]));
                    panadero.setAñosExperiencia(Integer.parseInt(cortarString[4]));
                    datos.add(panadero);
                }

                if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt".equals(nombreArchivo)) {

                    Vendedor vendedor = new Vendedor(cortarString[2], cortarString[0], cortarString[1], Integer.parseInt(cortarString[3]));
                    vendedor.setAñosExperiencia(Integer.parseInt(cortarString[4]));
                    vendedor.setEps(cortarString[5]);
                    datos.add(vendedor);
                }

                if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt".equals(nombreArchivo)) {

                    Mensajero mensajero = new Mensajero(cortarString[2], cortarString[0], cortarString[1], Integer.parseInt(cortarString[3]));
                    mensajero.setEps(cortarString[4]);
                    mensajero.setArl(cortarString[5]);
                    mensajero.setPension(cortarString[6]);
                    datos.add(mensajero);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return datos;
    }

    public void ingresarTrabajadores(ArrayList<Trabajador> personas, String nombreArchivo) {

        File fichero = new File(nombreArchivo);
        FileWriter writer = null;

        try {

            writer = new FileWriter(fichero, true);

            if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt".equals(nombreArchivo)) {

                for (Trabajador p : personas) {

                    String linea = p.getNombre() + "/" + p.getApellido() + "/" + p.getCedula() + "/" + p.getEdad() + "\n";
                    writer.write(linea);

                }
            }

            if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Panaderos.txt".equals(nombreArchivo)) {

                for (Trabajador p : personas) {

                    if (p instanceof Panadero) {

                        Panadero panadero = (Panadero) p;
                        String linea = panadero.getNombre() + "/" + panadero.getApellido() + "/" + panadero.getCedula() + "/" + panadero.getEdad() + "/" + panadero.getAñosExperiencia() + "\n";
                        writer.write(linea);
                    }
                }
            }

            if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt".equals(nombreArchivo)) {

                for (Trabajador p : personas) {

                    if (p instanceof Vendedor) {

                        Vendedor vendedor = (Vendedor) p;
                        String linea = vendedor.getNombre() + "/" + vendedor.getApellido() + "/" + vendedor.getCedula() + "/" + vendedor.getEdad() + "/" + vendedor.getAñosExperiencia() + "/" + vendedor.getEps() + "\n";
                        writer.write(linea);
                    }
                }
            }

            if ("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt".equals(nombreArchivo)) {

                for (Trabajador p : personas) {

                    if (p instanceof Mensajero) {

                        Mensajero mensajero = (Mensajero) p;
                        String linea = "\n" + mensajero.getNombre() + "/" + mensajero.getApellido() + "/" + mensajero.getCedula() + "/" + mensajero.getEdad() + "/" + mensajero.getEps() + "/" + mensajero.getArl() + "/" + mensajero.getPension();
                        writer.write(linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
