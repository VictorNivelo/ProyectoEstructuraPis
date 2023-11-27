/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private ListaDinamica<Persona> personasTabla;

    public ListaDinamica<Persona> getPersonasTabla() {
        return personasTabla;
    }

    public void setPersonasTabla(ListaDinamica<Persona> personasTabla) {
        this.personasTabla = personasTabla;
    }
    
    @Override
    public int getRowCount() {
        return personasTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }
    
    private String EstadoCuenta(int i) throws ListaVacia {
        
        Persona p = personasTabla.getInfo(i);
        
        if (p.getCuentaPersona().getEstadoCuenta()) {
            return "Activa";
        } 
        else {
            return "Inactiva";
        }
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Persona p = personasTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdPersona(): "";
                case 1:
                    return (p != null) ? p.getRolPersona().getNombreRol() : "";
                case 2:
                    return (p != null) ? p.getNombre() : "";
                case 3:
                    return (p != null) ? p.getApellido() : "";
                case 4:
                    return (p != null) ? p.getGenero(): "";
                case 5:
                    return (p != null) ? p.getFechaNacimineto(): "";
                case 6:
                    return (p != null) ? p.getDireccion(): "";
                case 7:
                    return (p != null) ? p.getTelefono(): "";
                case 8:
                    return (p != null) ? p.getCuentaPersona().getCorreo(): "";
                case 9:
                    return (p != null) ? EstadoCuenta(Fila): "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return personasTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id persona";
            case 1:
                return "Numero cedula";
            case 2:
                return "Nombre";
            case 3:
                return "Apellido";
            case 4:
                return "Genero";
            case 5:
                return "Fecha nacimiento";
            case 6:
                return "Direccion";
            case 7:
                return "Telefono";
            case 8:
                return "Correo";
            case 9:
                return "Estado cuenta";

            
            default:
                return null;
        }
    }
    
    public double sumarColumna(int columna) {
        double suma = 0.0;

        for (int fila = 0; fila < getRowCount(); fila++) {
            try {
                Object valor = getValueAt(fila, columna);

                if (valor instanceof Number) {
                    suma += ((Number) valor).doubleValue();
                }
            } 
            catch (Exception e) {
            }
        }

        return suma;
    }
}
