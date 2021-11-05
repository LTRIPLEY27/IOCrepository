package persistencia;

import principal.GestorTallerMecanicException;
import principal.Taller;

/**
 *
 * @author fta
 */
public class GestorPersistencia {

    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML pGestor) {
        gestor = pGestor;
    }

    public void desarTaller(String tipusPersistencia, String nomFitxer, Taller taller) throws GestorTallerMecanicException {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarTaller(nomFitxer, taller);
        }
    }

    public void carregarTaller(String tipusPersistencia, String nomFitxer) throws GestorTallerMecanicException {

        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.carregarTaller(nomFitxer);
        }
    }
}
