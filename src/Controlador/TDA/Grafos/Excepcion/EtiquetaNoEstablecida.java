
package Controlador.TDA.Grafos.Excepcion;

/**
 *
 * @author Victor
 */
public class EtiquetaNoEstablecida extends Exception {

    public EtiquetaNoEstablecida(String msg) {
        super(msg);
    }

    public EtiquetaNoEstablecida() {
        super("No esta etiquetado totalmente el grafo");
    }
    
}
