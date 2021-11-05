package persistencia;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import principal.GestorTallerMecanicException;
import principal.Taller;

/**
 *
 * @Isabel Calzadilla
 */
public class GestorXML implements ProveedorPersistencia {

    private Document doc;
    private Taller taller;

    public Document getDoc() {
        return doc;
    }

    public Taller getTaller() {
        return taller;
    }

    public void desarTaller(String nomFitxer, Taller taller) throws GestorTallerMecanicException {
        construeixModel(taller);
        desarModel(nomFitxer);
    }

    public void carregarTaller(String nomFitxer) throws GestorTallerMecanicException {
        carregarFitxer(nomFitxer);
        llegirFitxerTaller();
    }

    /*Paràmetres: Taller a partir de la qual volem construir el model
     *
     *Acció: 
     * - Llegir els atributs de l'objecte taller passat per paràmetre 
     *   per construir un model (document XML) sobre el Document doc (atribut de GestorXML).
     *
     * - L'arrel del document XML és "taller". Aquesta arrel, l'heu d'afegir 
     *   a doc. Un cop fet això, heu de recórrer l'ArrayList components de Taller
     *   i per a cada component, afegir un fill a doc. Cada fill tindrà com atributs
     *   els atributs de l'objecte (codi, nom, nif, etc.)
     *
     * - Si es tracta d'un recanvi, quan està assignat hem d'assignar a l'atribut que representa
     *   dins el document XML si està assignat o no, el valor "Si", i en cas contrari el valor "No"
     *   
     * - Si es tracta d'una reparació, a més, heu d'afegir fills addicionals amb el client, els
     *   mecànics i mecàniques i els recanvis.
     *
     * - Si heu de gestionar alguna excepció relacionada amb la construcció del model,
     *   heu de llençar una excepció de tipus GestorTallerMecanicException amb codi 
     *   "GestorXML.model".
     *
     *Retorn: cap
     */
    public void construeixModel(Taller taller) throws GestorTallerMecanicException {
        
        
        // CIERRE DEL BLOQUE EN UNA EXCEPCION *** LO DEMANDABA JAVA???
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // CREACION DE LA INSTANCIA
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            DOMImplementation implementation = builder.getDOMImplementation();// SE CREA EL DOM SOBRE EL QUE CONSTRUIRA XML
            
            doc = implementation.createDocument(null, "Talleres", null);// OBJETO "DOC" EN XML, RAIZ
            
            doc.setXmlVersion("1.0");
            
            
            Element tallers = doc.createElement("taller");
            
            //Element tallerHijo = doc.createTextNode(taller.); ?????
            
            Element cif = doc.createElement("cif"); // ELEMENTO HIJO : CIF
            
            Text textCif = doc.createTextNode(taller.getCif()); // TEXTO DEL ELEMENTO
            
            cif.appendChild(textCif); // ADJUNCION DEL TEXTO EN EL ELEMENTO, SE REPITE POR CADA ESCENARIO
            
            tallers.appendChild(cif); // ADJUNCION DEL ELEMENTO HIJO AL OBJETO CENTRAL "ELEMENTO PADRE" DE TALLER
            
            // SEGUNDO ATRIBUTO
            
            Element nom = doc.createElement("nombre");
            
            Text textNom = doc.createTextNode(taller.getNom());
            
            nom.appendChild(textNom);
            
            tallers.appendChild(nom);
            
            // TERCER ATRIBUTO
            
            Element adresa = doc.createElement("Direccion");
            
            Text textAdresa = doc.createTextNode(taller.getAdreca());
            
            adresa.appendChild(textAdresa);
            
            tallers.appendChild(adresa);
            
            
            // CUARTO ATRIBUTO (UBICACION)


            //Element pTallers = doc.createElement("Numero");
            
            //Text textpTaller = doc.createTextNode(taller.getpComponents());
            //pTallers.appendChild(textpTallers);
            
            //tallers.appendChild(pTallers);
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void desarModel(String nomFitxer) throws GestorTallerMecanicException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            File f = new File(nomFitxer + ".xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (Exception ex) {
            throw new GestorTallerMecanicException("GestorXML.desar");
        }
    }

    public void carregarFitxer(String nomFitxer) throws GestorTallerMecanicException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            File f = new File(nomFitxer + ".xml");
            doc = builder.parse(f);
        } catch (Exception ex) {
            throw new GestorTallerMecanicException("GestorXML.carrega");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     * - Llegir el fitxer del vostre sistema i carregar-lo sobre l'atribut doc, 
     *   per assignar valors als atributs de Taller i la resta d'objectes que formen 
     *   els components de Taller.
     *    
     * - Primer heu de crear l'objecte de la classe Taller a partir de l'arrel del document XML
     *   per després recórrer el doc i per cada fill, afegir un objecte a l'atribut 
     *   components de Taller mitjançant el mètode escaient de la classe Taller. Recordeu
     *   que com l'arrel conté els atributs CIF, nom i adreça del taller, al fer 
     *   Element arrel = doc.getDocumentElement(); ja podeu crear l'objecte de la classe.
     *
     * - Si l'element que s'ha llegit és un recanvi, penseu que els valors "Si" i "No", s'han de guardar
     *   com boleans quan l'afegiu a components del taller o a una reparació.
     *
     * - Si l'element del document XML que s'ha llegit és una reparació, recordeu que a 
     *   més d'afegir-lo a components, també haureu d'assignar-li el client, mecànic i mecàniques
     *   i els recanvis.
     *
     *Retorn: cap
     */
    private void llegirFitxerTaller() throws GestorTallerMecanicException {
       
    }
}
