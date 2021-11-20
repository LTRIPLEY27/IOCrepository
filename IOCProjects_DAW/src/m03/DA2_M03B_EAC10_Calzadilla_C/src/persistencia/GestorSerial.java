package persistencia;

import model.Taller;
import principal.GestorTallerMecanicException;

//Com s'indica a l'enunciat, la implementació dels mètodes d'aquesta classe és OPCIONAL

/**
 *
 * @author fta
 */
public class GestorSerial implements ProveedorPersistencia{
    
    private Taller taller;

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }    

    @Override
    public void desarTaller(String nomFitxer, Taller taller) throws GestorTallerMecanicException {
        /*
         *TODO (Implementació OPCIONAL)
         *
         *Paràmetres: nom del fitxer i taller
         *
         *Acció:
         * - Ha de desar l'objecte Taller serialitzat sobre un fitxer del sistema 
         *   operatiu amb nom nomFitxer i extensió ".ser".
         * - Heu de controlar excepcions d'entrada/sortida i en cas de produïrse alguna, 
         *   llavors llançar GestorTallerMecanicException amb codi GestorSerial.desar 
         *
         *Nota: podeu comprovar que la classe Taller implementa Serializable  
         *
         *Retorn: cap
         */

    }

    @Override
    public void carregarTaller(String nomFitxer) throws GestorTallerMecanicException {
        /*
         *TODO (Implementació OPCIONAL)
         *
         *Paràmetres: nom del fitxer
         *
         *Acció:
         * - Ha de carregar el fitxer del sistema operatiu amb nom nomFitxer i extensió 
         *   ".ser" sobre un nou objecte Taller que es retornarà com a resultat.               
         * - Heu de controlar excepcions d'entrada/sortida i en cas de produïrse alguna, 
         *   llavors llançar GestorTallerMecanicException amb codi GestorSerial.carrega 
         *
         *Retorn: cap
         */

    }
}