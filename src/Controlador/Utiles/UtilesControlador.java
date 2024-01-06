/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Utiles;

import Controlador.TDA.ListaDinamica.Exepciones.ListaVacia;
import Controlador.TDA.ListaDinamica.Exepciones.PosicionNoEncontrada;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTextField;

/**
 *
 * @author Victor
 */
public class UtilesControlador {
    
    public static boolean validarFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH);
        sdf.setLenient(false);

        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            return false;
        }
    }
    
    public static Date setDateFormat(JTextField texto) throws ParseException{
        return new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).parse(texto.getText());
    }
    
    public static String obtenerFechaHoraActualFormateada() {
        // Obtén la fecha y hora actual
        Date fechaHoraActual = new Date();

        // Crea un formateador de fecha con el formato deseado y el idioma especificado
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH);

        // Formatea la fecha y hora actual
        return formateador.format(fechaHoraActual);
    }
    
    private static Field getField(Class<?> clazz, String fieldName) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } 
            catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }
    
    private static <T> boolean comparar(T elemento1, T elemento2, String campo, Integer orden) {
        try {
            Field field = getField(elemento1.getClass(), campo);
            field.setAccessible(true);

            if (Comparable.class.isAssignableFrom(field.getType())) {
                Comparable<Object> valor1 = (Comparable<Object>) field.get(elemento1);
                Comparable<Object> valor2 = (Comparable<Object>) field.get(elemento2);
                int resultadoComparacion = valor1.compareTo(valor2);
                return orden == 1 ? resultadoComparacion > 0 : resultadoComparacion < 0;
            } 
            else {
                throw new IllegalArgumentException("El campo no es comparable");
            }
        } 
        catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static <T> ListaDinamica<T> SelectSort(ListaDinamica<T> lista, Integer Orden, String Campo) throws ListaVacia, Exception {
        Integer n = lista.getLongitud();
        T[] elementos = lista.toArray();
        Field atributo = getField(elementos[0].getClass(), Campo);

        if (atributo != null) {
            for (int i = 0; i < n - 1; i++) {
                int k = i;
                T elementoOrden = elementos[i];

                for (int j = i + 1; j < n; j++) {
                    if (comparar(elementos[j], elementoOrden, Campo, Orden)) {
                        elementoOrden = elementos[j];
                        k = j;
                    }
                }
                elementos[k] = elementos[i];
                elementos[i] = elementoOrden;
            }
        } 
        else {
            throw new Exception("No existe el criterio de búsqueda");
        }

        return lista.toList(elementos);
    }

    public static <T> ListaDinamica<T> ShellSort(ListaDinamica<T> lista, Integer Orden, String Campo) {
        int n = lista.getLongitud();
        T[] elementos = lista.toArray();

        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                T ayuda = elementos[i];
                int j;
                for (j = i; j >= intervalo && comparar(elementos[j - intervalo], ayuda, Campo, Orden); j -= intervalo) {
                    elementos[j] = elementos[j - intervalo];
                }
                elementos[j] = ayuda;
            }
        }
        return lista.toList(elementos);
    }

    public static <T> ListaDinamica<T> QuickSort(ListaDinamica<T> lista, Integer Orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
        if (lista == null || lista.getLongitud() <= 1) {
            return lista;
        }
        QuickSortRecursivo(lista, 0, lista.getLongitud() - 1, Orden, Campo);
        return lista;
    }

    private static <T> void QuickSortRecursivo(ListaDinamica<T> lista, int inicio, int fin, Integer orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
        if (inicio < fin) {
            int indiceParticion = Particionar(lista, inicio, fin, orden, Campo);
            QuickSortRecursivo(lista, inicio, indiceParticion - 1, orden, Campo);
            QuickSortRecursivo(lista, indiceParticion + 1, fin, orden, Campo);
        }
    }

    private static <T> int Particionar(ListaDinamica<T> lista, int inicio, int fin, Integer orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
        T pivote = lista.getInfo(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (comparar(pivote, lista.getInfo(j), Campo, orden)) {
                i++;
                Intercambiar(lista, i, j);
            }
        }
        Intercambiar(lista, i + 1, fin);
        return i + 1;
    }

    private static <T> void Intercambiar(ListaDinamica<T> lista, int i, int j) throws ListaVacia, PosicionNoEncontrada {
        T ayuda = lista.getInfo(i);
        lista.modificarPosicion(lista.getInfo(j), i);
        lista.modificarPosicion(ayuda, j);
    }

    public static <T> ListaDinamica<T> BusquedaBinaria(ListaDinamica<T> lista, String Busqueda, String Campo) throws ListaVacia, PosicionNoEncontrada {
        ListaDinamica<T> listaOrdenada = QuickSort(lista, 1, Campo);
        ListaDinamica<T> ListaElementos = new ListaDinamica<>();

        boolean encontrado = false;
        int inicio = 0;
        int fin = listaOrdenada.getLongitud() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            T Mitad = listaOrdenada.getInfo(medio);
            Field campo = getField(Mitad.getClass(), Campo);

            try {
                campo.setAccessible(true);
                Object ObjetoMitad = campo.get(Mitad);
                String valorMedio = (ObjetoMitad != null) ? ObjetoMitad.toString() : "";
                if (valorMedio.toLowerCase().contains(Busqueda.trim().toLowerCase())) {
                    encontrado = true;
                    ListaElementos.AgregarFinal(Mitad);
                    int j = medio - 1;
                    while (j >= 0) {
                        T elementoAnterior = listaOrdenada.getInfo(j);
                        Object valorAnteriorObj = campo.get(elementoAnterior);
                        String valorAnterior = (valorAnteriorObj != null) ? valorAnteriorObj.toString() : "";

                        if (valorAnterior.toLowerCase().contains(Busqueda.trim().toLowerCase())) {
                            ListaElementos.AgregarFinal(elementoAnterior);
                            j--;
                        } 
                        else {
                            break;
                        }
                    }
                    int i = medio + 1;
                    while (i < listaOrdenada.getLongitud()) {
                        T elementoSiguiente = listaOrdenada.getInfo(i);
                        Object valorSiguienteObj = campo.get(elementoSiguiente);
                        String valorSiguiente = (valorSiguienteObj != null) ? valorSiguienteObj.toString() : "";

                        if (valorSiguiente.toLowerCase().contains(Busqueda.trim().toLowerCase())) {
                            ListaElementos.AgregarFinal(elementoSiguiente);
                            i++;
                        } 
                        else {
                            break;
                        }
                    }
                    break;
                } 
                else {
                    String valorABuscar = Busqueda;
                    if (valorMedio.compareToIgnoreCase(valorABuscar) > 0) {
                        fin = medio - 1;
                    } 
                    else {
                        inicio = medio + 1;
                    }
                }
            } 
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ListaElementos;
    }
    
    public static <T> ListaDinamica<T> BusquedaLineal(ListaDinamica<T> lista, String busqueda, String campo) throws ListaVacia, PosicionNoEncontrada {
        ListaDinamica<T> resultado = new ListaDinamica<>();
        Integer ultimaPosicionOcupada = lista.getLongitud();

        for (int i = 0; i < ultimaPosicionOcupada; i++) {
            T elemento = lista.getInfo(i);
            try {
                Field campoObjeto = getField(elemento.getClass(), campo);

                if (campoObjeto != null) {
                    campoObjeto.setAccessible(true);
                    Object valorObj = campoObjeto.get(elemento);
                    String valorCampo = (valorObj != null) ? valorObj.toString() : "";
                    if (buscarTipoEspecifico(valorCampo, busqueda)) {
                        resultado.AgregarFinal(elemento);
                        continue;
                    }
                }

                String[] subcampos = campo.split("\\.");
                Object objetoActual = elemento;

                for (String subcampo : subcampos) {
                    Field subcampoObjeto = getField(objetoActual.getClass(), subcampo);

                    if (subcampoObjeto != null) {
                        subcampoObjeto.setAccessible(true);
                        objetoActual = subcampoObjeto.get(objetoActual);
                    } 
                    else {
                        objetoActual = null;
                        break;
                    }
                }
                if (objetoActual != null) {
                    String valorCampo = objetoActual.toString();

                    if (buscarTipoEspecifico(valorCampo, busqueda)) {
                        resultado.AgregarFinal(elemento);
                    }
                }
            } 
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
    
    private static boolean buscarTipoEspecifico(String texto, String busqueda) {
        String textoSinEspacios = texto.replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]", "");
        String busquedaSinEspacios = busqueda.replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]", "");
        return textoSinEspacios.toLowerCase().startsWith(busquedaSinEspacios.toLowerCase());
    }
    
    private static boolean ClaseCampoEspecifico(Object valorCampo) {
        return valorCampo.getClass().getDeclaredFields().length > 0;
    }
    
//    private static boolean buscarTipoEspecifico(String texto, String busqueda) {
//        String textoSinEspacios = texto.replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]", "");
//        String busquedaSinEspacios = busqueda.replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]", "");
//        return textoSinEspacios.toLowerCase().contains(busquedaSinEspacios.toLowerCase());
//    }
}
    
//    public static <T> ListaDinamica<T> BusquedaLineal(ListaDinamica<T> lista, String busqueda, String campo) throws ListaVacia, PosicionNoEncontrada {
//        ListaDinamica<T> result = new ListaDinamica<>();
//        Integer ultimaPosicionOcupada = lista.getLongitud();
//
//        for (int i = 0; i < ultimaPosicionOcupada; i++) {
//            T elemento = lista.getInfo(i);
//
//            Field campoObjeto = getField(elemento.getClass(), campo);
//
//            if (campoObjeto != null) {
//                try {
//                    campoObjeto.setAccessible(true);
//                    Object valorObj = campoObjeto.get(elemento);
//                    String valorCampo = (valorObj != null) ? valorObj.toString() : "";
//
//                    if (buscarTipoEspecifico(valorCampo, busqueda)) {
//                        result.AgregarFinal(elemento);
//                    }
//                } 
//                catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }

    

//    private static String eliminarEspaciosYCaracteres(String texto) {
//        return texto.replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]", "");
//    }
//
//    private static <T> String concatenarValores(T objeto) {
//        StringBuilder sb = new StringBuilder();
//        Field[] campos = objeto.getClass().getDeclaredFields();
//
//        for (Field campo : campos) {
//            try {
//                campo.setAccessible(true);
//                Object valorObj = campo.get(objeto);
//                String valor = (valorObj != null) ? valorObj.toString() : "";
//                sb.append(valor).append(" ");
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return sb.toString();
//    }

//    public static <T> ListaDinamica<T> BusquedaLineal(ListaDinamica<T> lista, String Busqueda, String Campo) throws ListaVacia, PosicionNoEncontrada {
//        ListaDinamica<T> result = new ListaDinamica<>();
//        Integer ultimaPosicionOcupada = lista.getLongitud();
//
//        for (int i = 0; i < ultimaPosicionOcupada; i++) {
//            T elemento = lista.getInfo(i);
//            Field campo = getField(elemento.getClass(), Campo);
//
//            try {
//                campo.setAccessible(true);
//                Object valorObj = campo.get(elemento);
//                String valor = (valorObj != null) ? valorObj.toString() : "";
//                if (valor.toLowerCase().startsWith(Busqueda.trim().toLowerCase())) {
//                    result.AgregarFinal(elemento);
//                }
//            } 
//            catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }

    
//    public static void main(String[] args) throws ListaVacia, Exception {
//        paraleloDao a = new paraleloDao();
//        ListaDinamica<Paralelo> lista = a.all();
//        
//        ListaDinamica<Paralelo> resultado = SelectSort(lista, 0, "NombreParalelo");
//        ListaDinamica<Paralelo> resuktadi = BusquedaBinaria(lista, "B", "NombreParalelo");
//        
//        System.out.println("Orden");
//        System.out.println(resultado);
//        System.out.println("-----------------------------");
//        System.out.println("Busqueda");
//        System.out.println(resuktadi);
//    }
    
    
    
    
    
    //No genericos
    
    
    
    
    
//    public static <T> Field getField(Class<T> clazz, String Atributo) {
//        Field Campo = null;
//        for (Field f : clazz.getSuperclass().getDeclaredFields()) {
//            if (f.getName().equalsIgnoreCase(Atributo)) {
//                Campo = f;
//                break;
//            }
//        }
//        for (Field f : clazz.getDeclaredFields()) {
//            if (f.getName().equalsIgnoreCase(Atributo)) {
//                Campo = f;
//                break;
//            }
//        }
//        return Campo;
//    }
//    
//    public static ListaDinamica<Persona> SelectSort(ListaDinamica<Persona> lista, Integer Orden, String Campo) throws ListaVacia, Exception {
//        Integer n = lista.getLongitud();
//        Persona[] personas = lista.toArray();
//        Field Atributo = getField(Persona.class, Campo);
//
//        if (Atributo != null) {
//            for (int i = 0; i < n - 1; i++) {
//                int k = i;
//                Persona personaOrden = personas[i];
//
//                for (int j = i + 1; j < n; j++) {
//                    if (personas[j].comparar(personaOrden, Campo, Orden)) {
//                        personaOrden = personas[j];
//                        k = j;
//                    }
//                }
//                personas[k] = personas[i];
//                personas[i] = personaOrden;
//            }
//        } 
//        else {
//            throw new Exception("No existe el criterio de búsqueda");
//        }
//
//        return lista.toList(personas);
//    }
//    
//    
//
////    public static ListaDinamica<Persona> Ordenar(ListaDinamica<Persona> lista, Integer tipo, String field) throws ListaVacia, Exception {
////        Integer n = lista.getLongitud();
////        Persona[] personas = lista.toArray();
////        Field atribute = UtilesControlador.getField(Persona.class, field);
////        if (atribute != null) {
////            for (int i = 1; i < n - 1; i++) {
////                int k = i;
////                Persona personaOrden = personas[i];
////                for (int j = i + 1; j < n; j++) {
////                    if (personas[j].comparar(personaOrden, field, tipo)) {
////                        personaOrden = personas[j];
////                        k = j;
////                    }
////                }
////                personas[k] = personas[i];
////                personas[i] = personaOrden;
////            }
////        } 
////        else {
////            throw new Exception("No existe el criterio de busqueda");
////        }
////        return lista.toList(personas);
////    }
//    
//
//    public static ListaDinamica<Persona> ShellSort(ListaDinamica<Persona> lista, Integer Orden, String Campo) {
//        int n = lista.getLongitud();
//        Persona[] personas = lista.toArray();
//
//        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
//            for (int i = intervalo; i < n; i++) {
//                Persona ayuda = personas[i];
//                int j;
//                for (j = i; j >= intervalo && ayuda.comparar(personas[j - intervalo], Campo, Orden); j -= intervalo) {
//                    personas[j] = personas[j - intervalo];
//                }
//                personas[j] = ayuda;
//            }
//        }
//        return lista.toList(personas);
//    }
//
//    public static ListaDinamica<Persona> QuickSort(ListaDinamica<Persona> listaPersonas, Integer Orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
//        if (listaPersonas == null || listaPersonas.getLongitud() <= 1) {
//            return listaPersonas;
//        }
//        QuickSortRecursivo(listaPersonas, 0, listaPersonas.getLongitud() - 1, Orden, Campo);
//        return listaPersonas;
//    }
//
//    private static void QuickSortRecursivo(ListaDinamica<Persona> listaPersonas, int inicio, int fin, Integer orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
//        if (inicio < fin) {
//            int indiceParticion = Particionar(listaPersonas, inicio, fin, orden, Campo);
//            QuickSortRecursivo(listaPersonas, inicio, indiceParticion - 1, orden, Campo);
//            QuickSortRecursivo(listaPersonas, indiceParticion + 1, fin, orden, Campo);
//        }
//    }
//
//    private static int Particionar(ListaDinamica<Persona> listaPersonas, int inicio, int fin, Integer orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
//        Persona pivote = listaPersonas.getInfo(fin);
//        int i = inicio - 1;
//
//        for (int j = inicio; j < fin; j++) {
//            if (pivote.comparar(listaPersonas.getInfo(j), Campo, orden)) {
//                i++;
//                Intercambiar(listaPersonas, i, j);
//            }
//        }
//        Intercambiar(listaPersonas, i + 1, fin);
//        return i + 1;
//    }
//
//    private static void Intercambiar(ListaDinamica<Persona> listaPersonas, int i, int j) throws ListaVacia, PosicionNoEncontrada {
//        Persona ayuda = listaPersonas.getInfo(i);
//        listaPersonas.modificarPosicion(listaPersonas.getInfo(j), i);
//        listaPersonas.modificarPosicion(ayuda, j);
//    }
//
//    public static ListaDinamica<Persona> BusquedaBinaria(ListaDinamica<Persona> lista, String Busqueda, String Campo) throws ListaVacia, PosicionNoEncontrada {
//        ListaDinamica<Persona> listaOrdenada = QuickSort(lista, 1, Campo);
//        ListaDinamica<Persona> ListaPersonas = new ListaDinamica<>();
//
//        boolean encontrado = false;
//        int inicio = 0;
//        int fin = listaOrdenada.getLongitud() - 1;
//
//        while (inicio <= fin) {
//            int medio = (inicio + fin) / 2;
//            Persona Mitad = listaOrdenada.getInfo(medio);
//            Field campo = getField(Persona.class, Campo);
//
//            try {
//                campo.setAccessible(true);
//                Object ObjetoMitad = campo.get(Mitad);
//                String valorMedio = (ObjetoMitad != null) ? ObjetoMitad.toString() : "";
//
//                if (valorMedio.toLowerCase().contains(Busqueda.trim().toLowerCase())) {
//                    encontrado = true;
//                    ListaPersonas.AgregarFinal(Mitad);
//                    int j = medio - 1;
//                    while (j >= 0) {
//                        Persona personaAnterior = listaOrdenada.getInfo(j);
//                        Object valorAnteriorObj = campo.get(personaAnterior);
//                        String valorAnterior = (valorAnteriorObj != null) ? valorAnteriorObj.toString() : "";
//
//                        if (valorAnterior.toLowerCase().contains(Busqueda.trim().toLowerCase())) {
//                            ListaPersonas.AgregarFinal(personaAnterior);
//                            j--;
//                        } 
//                        else {
//                            break;
//                        }
//                    }
//                    int i = medio + 1;
//                    while (i < listaOrdenada.getLongitud()) {
//                        Persona personaSiguiente = listaOrdenada.getInfo(i);
//                        Object valorSiguienteObj = campo.get(personaSiguiente);
//                        String valorSiguiente = (valorSiguienteObj != null) ? valorSiguienteObj.toString() : "";
//
//                        if (valorSiguiente.toLowerCase().contains(Busqueda.trim().toLowerCase())) {
//                            ListaPersonas.AgregarFinal(personaSiguiente);
//                            i++;
//                        } 
//                        else {
//                            break;
//                        }
//                    }
//                    break;
//                } 
//                else {
//                    String valorABuscar = Busqueda;
//                    if (valorMedio.compareToIgnoreCase(valorABuscar) > 0) {
//                        fin = medio - 1;
//                    } 
//                    else {
//                        inicio = medio + 1;
//                    }
//                }
//            } 
//            catch (IllegalAccessException e) {
//                
//            }
//        }
//        return ListaPersonas;
//    }
//
//    public static ListaDinamica<Persona> BusquedaLineal(ListaDinamica<Persona> lista, String Busqueda, String Campo) throws ListaVacia, PosicionNoEncontrada {
//        ListaDinamica<Persona> result = new ListaDinamica<>();
//        Integer ultimaPosicionOcupada = lista.getLongitud();
//
//        for (int i = 0; i < ultimaPosicionOcupada; i++) {
//            Persona persona = lista.getInfo(i);
//            Field campo = getField(Persona.class, Campo);
//
//            try {
//                campo.setAccessible(true);
//                Object valorObj = campo.get(persona);
//                String valor = (valorObj != null) ? valorObj.toString() : "";
//                if (valor.toLowerCase().startsWith(Busqueda.trim().toLowerCase())) {
//                    result.AgregarFinal(persona);
//                }
//            } 
//            catch (IllegalAccessException e) {
//
//            }
//        }
//        return result;
//    }       
    
//        public static void main(String[] args) {
//        try {
//            
//            personaDao pc = new personaDao();
//            ListaDinamica<Persona> a = pc.all();
//            
////            System.out.println(Ordenar(a, 0, "nombre"));
//
////            System.out.println(ShellSort(a, 0, "nombre"));
//            System.out.println(BusquedaBinaria(a, "d", "nombre"));
//            
////            personaDao pc = new personaDao();
////            ListaDinamica a = pc.all();
////            System.out.println(pc.all());
////            System.out.println(pc.ordenar(a, 0, "Nombre").toString());
////            System.out.println(ShellSort(a, 0, "nombre"));
////            System.out.println(BusquedaBinaria(a, "d", "nombre"));
////            System.out.println(quicksort(a, 1, "Nombre"));
////            System.out.println(pc.all());
////            System.out.println("---------------------------");
////            System.out.println(pc.ordenar(pc.all(), 0, "Nombre"));
//        } 
//        catch (Exception e) {
//        }
//    }
    
    
//}
