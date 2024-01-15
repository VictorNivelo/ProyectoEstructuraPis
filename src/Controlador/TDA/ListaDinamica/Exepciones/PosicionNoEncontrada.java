
package Controlador.TDA.ListaDinamica.Exepciones;

/**
 *
 * @author Victor
 */
public class PosicionNoEncontrada extends Exception{
    
    public PosicionNoEncontrada(String msg){
        super(msg);
        
    }
    
    public PosicionNoEncontrada(){
        super("La posición dada está fuera de los límites");
    }
    
}
