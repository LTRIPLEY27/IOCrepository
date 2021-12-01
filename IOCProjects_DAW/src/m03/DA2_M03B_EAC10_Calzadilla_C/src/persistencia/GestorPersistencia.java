package persistencia;

import principal.GestorTallerMecanicException;
import model.Taller;

/**
 *
 * @author Isabel Calzadilla
 */
public class GestorPersistencia {

    private ProveedorPersistencia gestor;

    public ProveedorPersistencia getGestor() {
        return gestor;
    }

    public void desarTaller(String tipusPersistencia, String nomFitxer, Taller taller) throws GestorTallerMecanicException {
        switch (tipusPersistencia) {

            case "XML":
                gestor = new GestorXML();
                break;
            default:
                gestor = new GestorSerial();
                break;

        }

        gestor.desarTaller(nomFitxer, taller);
    }

    public void carregarTaller(String tipusPersistencia, String nomFitxer) throws GestorTallerMecanicException {

        switch (tipusPersistencia) {

            case "XML":
                gestor = new GestorXML();
                break;
            default:
                gestor = new GestorSerial();
                break;

        }

        gestor.carregarTaller(nomFitxer);
    }
}
