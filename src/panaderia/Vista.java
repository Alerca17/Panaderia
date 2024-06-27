package panaderia;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Vista {

    public Vista() {
    }

    ArrayList<Trabajador> arrayPanadero = new ArrayList();
    ArrayList<Trabajador> arrayVendedor = new ArrayList();
    ArrayList<Trabajador> arrayMensajero = new ArrayList();
    ArrayList<Trabajador> arrayTrabajador = new ArrayList();
    GestionDatos gestion = new GestionDatos();

    String[] eps = {"Sura", "Sanitas", "Salud Total", "Nueva EPS"}; //Vector Eps
    String[] arl = {"ARL Sura", "ARL Colmena", "ARL Bolívar", "ARL Liberty"}; //Vector arl
    String[] pension = {"Porvenir", "Colfondos", "Colpensiones", "Skandia"}; //Vector pension

    JComboBox<String> epsLista = new JComboBox<>(eps); // Lista Desplegable
    JComboBox<String> arlLista = new JComboBox<>(arl); // Lista Desplegable
    JComboBox<String> pensionLista = new JComboBox<>(pension); // Lista Desplegable

    String cedula;
    String nombre;
    String apellido;
    String Eps;
    String Pension;
    int edad, A, B, opc = 0;
    boolean valido = true;

    public void menuPrincipal() {

        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1).Ingresar Trabajadores\n2).Ver Trabajadores\n3).Buscar Trabajadores\n4).Opciones Avanzadas\n5).Salir", "Menu Principal", JOptionPane.QUESTION_MESSAGE));

        switch (opc) {

            case 1:
                menuIngresar();
                break;

            case 2:
                menuMostrar();
                break;
            case 3:

                cedula = JOptionPane.showInputDialog(null, "Ingrese La Cedula Del Trabajador A Buscar: ", "Menu Buscar", JOptionPane.QUESTION_MESSAGE);
                gestion.buscarTrabajador(cedula);
                menuPrincipal();
                break;

            case 4:
                menuAvanzadas();
                break;

            case 5:
                System.exit(0);

            default:
                JOptionPane.showMessageDialog(null, "OPCION INVALIDA!!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public void menuAvanzadas() {

        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1).Promedio Por Años De Experiencia\n2).Porcentaje De Trabajadores Por EPS\n3).Filtrar Por Pension\n4).Volver", "Menu Principal", JOptionPane.QUESTION_MESSAGE));

        do {
            switch (opc) {

                case 1:

                    JOptionPane.showMessageDialog(null, "Ingrese El Rango De Años De Experiencia", "Años Experiencia", JOptionPane.INFORMATION_MESSAGE);
                    A = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor Inicial", "Rangos", JOptionPane.QUESTION_MESSAGE));
                    B = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor Final", "Rangos", JOptionPane.QUESTION_MESSAGE));
                    gestion.promedioExperiencia(A, B);
                    menuAvanzadas();
                    break;

                case 2:

                    Eps = JOptionPane.showInputDialog(null, "Ingrese La Eps", "Porcentaje De Eps", JOptionPane.QUESTION_MESSAGE);
                    gestion.porcentajeEps(Eps);
                    menuAvanzadas();
                    break;

                case 3:
                    Pension = JOptionPane.showInputDialog(null, "Ingrese La Pension", "Porcentaje De Eps", JOptionPane.QUESTION_MESSAGE);
                    gestion.filtrarPension(Pension);
                    menuAvanzadas();
                    break;

                case 4:
                    menuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPCION INVALIDA!!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opc != 4);
    }

    public void menuMostrar() {

        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione El Tipo De Trabajadores Que Desea Ver:\n\n1).Panaderos\n2).Vendedores\n3).Mensajeros\n4).Informacion Trabajadores\n5).Volver", "Menu Ingresar", JOptionPane.QUESTION_MESSAGE));

        switch (opc) {

            case 1:
                gestion.mostrarTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Panaderos.txt");
                menuMostrar();
                break;

            case 2:
                gestion.mostrarTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt");
                menuMostrar();
                break;

            case 3:
                gestion.mostrarTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt");
                menuMostrar();
                break;

            case 4:
                gestion.mostrarTrabajadores("C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt");
                menuMostrar();
                break;

            case 5:
                menuPrincipal();
                break;

            default:
                JOptionPane.showMessageDialog(null, "OPCION INVALIDA!!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public void menuIngresar() {

        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione El Tipo De Trabajador Que Desea Ingresar:\n\n1).Panadero\n2).Vendedor\n3).Mensajero\n4).Volver", "Menu Ingresar", JOptionPane.QUESTION_MESSAGE));

        arrayTrabajador.clear();
        arrayPanadero.clear();
        arrayVendedor.clear();
        arrayMensajero.clear();

        switch (opc) {

            case 1:

                Panadero panadero;

                do {

                    nombre = JOptionPane.showInputDialog(null, "Ingrese El Nombre: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);
                    apellido = JOptionPane.showInputDialog(null, "Ingrese El Apellido: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);

                    do {

                        cedula = JOptionPane.showInputDialog(null, "Ingrese La Cedula: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);

                        if (cedula.length() >= 6 && cedula.length() <= 10) {

                            valido = true;

                        } else {

                            valido = false;
                            JOptionPane.showMessageDialog(null, "CEDULA INCORRECTA!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (!valido);

                    do {
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese La Edad: ", "Ingresar", JOptionPane.QUESTION_MESSAGE));

                        if (edad >= 18 && edad < 100) {

                            valido = true;

                        } else {

                            valido = false;
                            JOptionPane.showMessageDialog(null, "EDAD INCORRECTA!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (!valido);

                    panadero = new Panadero(cedula, nombre, apellido, edad);
                    panadero.setAñosExperiencia(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Los Años De Experiencia: ", "Ingresar", JOptionPane.QUESTION_MESSAGE)));

                    if (gestion.validarTrabajador(cedula) == false) {

                        arrayPanadero.add(panadero);
                        arrayTrabajador.add(panadero);
                        JOptionPane.showMessageDialog(null, "INGRESADO CORRECTAMENTE!!", "COnfirmacion", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(null, "EL TRABAJADOR CON LA CEDULA " + cedula + " YA SE ENCUENTRA REGISTRADO", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    opc = (JOptionPane.showConfirmDialog(null, "¿Que Quieres Agregar Otro Panadero?", "Menu Panadero", JOptionPane.YES_NO_OPTION));

                } while (opc != JOptionPane.NO_OPTION);

                gestion.ingresarTrabajadores(arrayPanadero, "C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Panaderos.txt");
                gestion.ingresarTrabajadores(arrayTrabajador, "C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt");
                arrayTrabajador.clear();
                arrayPanadero.clear();
                menuIngresar();
                break;

            case 2:

                Vendedor vendedor;

                do {

                    nombre = JOptionPane.showInputDialog(null, "Ingrese El Nombre: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);
                    apellido = JOptionPane.showInputDialog(null, "Ingrese El Apellido: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);

                    do {

                        cedula = JOptionPane.showInputDialog(null, "Ingrese La Cedula: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);

                        if (cedula.length() >= 6 && cedula.length() <= 10) {

                            valido = true;

                        } else {

                            valido = false;
                            JOptionPane.showMessageDialog(null, "CEDULA INCORRECTA!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (!valido);

                    do {
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese La Edad: ", "Ingresar", JOptionPane.QUESTION_MESSAGE));

                        if (edad >= 18 && edad < 100) {

                            valido = true;

                        } else {

                            valido = false;
                            JOptionPane.showMessageDialog(null, "EDAD INCORRECTA!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (!valido);

                    vendedor = new Vendedor(cedula, nombre, apellido, edad);
                    vendedor.setAñosExperiencia(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Los Años De Experiencia: ", "Ingresar", JOptionPane.QUESTION_MESSAGE)));

                    int option = JOptionPane.showOptionDialog(null, epsLista, "Seleccione su EPS", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (option == JOptionPane.OK_OPTION) {
                        String epsSeleccionada = (String) epsLista.getSelectedItem();
                        vendedor.setEps(epsSeleccionada);
                    }

                    if (gestion.validarTrabajador(cedula) == false) {

                        arrayVendedor.add(vendedor);
                        arrayTrabajador.add(vendedor);
                        JOptionPane.showMessageDialog(null, "INGRESADO CORRECTAMENTE!!", "COnfirmacion", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(null, "EL TRABAJADOR CON LA CEDULA " + cedula + " YA SE ENCUENTRA REGISTRADO", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    opc = (JOptionPane.showConfirmDialog(null, "¿Que Quieres Agregar Otro Vendedor?", "Menu Vendedor", JOptionPane.YES_NO_OPTION));

                } while (opc != JOptionPane.NO_OPTION);

                gestion.ingresarTrabajadores(arrayVendedor, "C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Vendedores.txt");
                gestion.ingresarTrabajadores(arrayTrabajador, "C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt");
                arrayTrabajador.clear();
                arrayVendedor.clear();
                menuIngresar();
                break;

            case 3:

                Mensajero mensajero;

                do {

                    nombre = JOptionPane.showInputDialog(null, "Ingrese El Nombre: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);
                    apellido = JOptionPane.showInputDialog(null, "Ingrese El Apellido: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);

                    do {

                        cedula = JOptionPane.showInputDialog(null, "Ingrese La Cedula: ", "Ingresar", JOptionPane.QUESTION_MESSAGE);

                        if (cedula.length() >= 6 && cedula.length() <= 10) {

                            valido = true;

                        } else {

                            valido = false;
                            JOptionPane.showMessageDialog(null, "CEDULA INCORRECTA!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (!valido);

                    do {
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese La Edad: ", "Ingresar", JOptionPane.QUESTION_MESSAGE));

                        if (edad >= 18 && edad < 100) {

                            valido = true;

                        } else {

                            valido = false;
                            JOptionPane.showMessageDialog(null, "EDAD INCORRECTA!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (!valido);

                    mensajero = new Mensajero(cedula, nombre, apellido, edad);

                    int opcion = JOptionPane.showOptionDialog(null, epsLista, "Seleccione su EPS", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (opcion == JOptionPane.OK_OPTION) {
                        String epsSeleccionada = (String) epsLista.getSelectedItem();
                        mensajero.setEps(epsSeleccionada);
                    }

                    opcion = JOptionPane.showOptionDialog(null, arlLista, "Seleccione su ARL", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (opcion == JOptionPane.OK_OPTION) {
                        String arlseleccionada = (String) arlLista.getSelectedItem();
                        mensajero.setArl(arlseleccionada);
                    }

                    opcion = JOptionPane.showOptionDialog(null, pensionLista, "Seleccione su Pension", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (opcion == JOptionPane.OK_OPTION) {
                        String pensionSeleccionada = (String) pensionLista.getSelectedItem();
                        mensajero.setPension(pensionSeleccionada);
                    }

                    if (gestion.validarTrabajador(cedula) == false) {

                        arrayMensajero.add(mensajero);
                        arrayTrabajador.add(mensajero);
                        JOptionPane.showMessageDialog(null, "INGRESADO CORRECTAMENTE!!", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(null, "EL TRABAJADOR CON LA CEDULA " + cedula + " YA SE ENCUENTRA REGISTRADO", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    opc = (JOptionPane.showConfirmDialog(null, "¿Que Quieres Agregar Otro Mensajero?", "Menu Mensajero", JOptionPane.YES_NO_OPTION));

                } while (opc != JOptionPane.NO_OPTION);

                gestion.ingresarTrabajadores(arrayMensajero, "C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Mensajeros.txt");
                gestion.ingresarTrabajadores(arrayTrabajador, "C:\\Users\\alejo\\OneDrive\\Documentos\\NetBeansProjects\\Panaderia\\Datos/Trabajadores.txt");
                arrayTrabajador.clear();
                arrayMensajero.clear();
                menuIngresar();
                break; 

            case 4:
                menuPrincipal();
                break;

            default:
                JOptionPane.showMessageDialog(null, "OPCION INVALIDA!!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}
