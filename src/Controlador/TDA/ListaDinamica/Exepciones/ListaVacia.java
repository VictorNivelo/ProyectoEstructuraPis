
package Controlador.TDA.ListaDinamica.Exepciones;

/**
 *
 * @author Victor
 */
public class ListaVacia extends Exception{
    
    public ListaVacia(){
        
    }
    
    public ListaVacia(String msg) {
        super(msg);
    }
}
