
package Controlador.TDA.Grafos;

import Controlador.TDA.Grafos.Excepcion.VerticeException;

/**
 *
 * @author Victor
 */
public class GrafoNoDirigido extends GrafoDirigido{
    
    public GrafoNoDirigido (Integer numV){
        super(numV);
    }
    
    public void insertarArista(Integer v1, Integer v2, Double peso) throws Exception {
        if (v1.intValue() <= num_vertice() && v2.intValue() <= num_vertice()) {
            if (!existe_arista(v1, v2)) {
                setNumeroVertices(num_aristas() + 1);
                getListaAdyacencia()[v1].Agregar(new Adyacencia(v2, peso));
                getListaAdyacencia()[v2].Agregar(new Adyacencia(v1, peso));
            }
        } 
        else {
            throw new VerticeException();
        }
    }
    
}

