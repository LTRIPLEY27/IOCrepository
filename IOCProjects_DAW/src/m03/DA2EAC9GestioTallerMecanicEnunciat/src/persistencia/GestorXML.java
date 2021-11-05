package persistencia;

import areesTaller.Recanvi;
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
import principal.Reparacio;
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
        try {
            construeixModel(taller);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void construeixModel(Taller taller) throws GestorTallerMecanicException, ParserConfigurationException {
        
        
        // CIERRE DEL BLOQUE EN UNA EXCEPCION *** LO DEMANDABA JAVA???
   
            DocumentBuilderFactory constructor = DocumentBuilderFactory.newInstance(); // CREACION DE LA INSTANCIA
            
            DocumentBuilder construyeDOM;
            
            //DOMImplementation implementaDOM = construyeDOM.getDOMImplementation();// SE CREA EL DOM SOBRE EL QUE CONSTRUIRA XML
            
            //doc = implementaDOM.createDocument(null, "Talleres", null);// OBJETO "DOC" EN XML, RAIZ
            
            
            
            
            Element son, grandson, greatgrandson;  // ELEMENTOS QUE CREARAN LOS NODOS
            
            try {
                construyeDOM = constructor.newDocumentBuilder();
            } catch(ParserConfigurationException ex) {
                throw new GestorTallerMecanicException("GestorXML.model"); // VERIFICA LA EXCEPCION DEL GESTOR
            }
            
            doc = (Document) construyeDOM.newDocument();// ES NECESARIO CASTEAR EL DOCUMENTO
            
            
            // VERIFICAR SI NO SE DEBE DE REALIZAR SOBRE EL ARRAYLIST O SOLO 1 OBJETO
            Element root = doc.createElement("taller");
            root.setAttribute("cif", taller.getCif());
            root.setAttribute("nom", taller.getNom());
            root.setAttribute("adresa", taller.getAdreca());
            
            doc.appendChild(root); // SE ADJUNTA EL ELEMENTO COMPLETO AL DOCUMENTO COMO 1 HIJO
            
            
            
            // RECORRE EL ARRAYLIST Y CREA UN HIJO POR CADA COMPONENT
            for(int i = 0; i < taller.getComponents().size(); i++) {
                
                if(taller.getComponents().get(i) instanceof Recanvi) {
                    
                    son = doc.createElement("recanvi");
                    son.setAttribute("codi", ((Recanvi)taller.getComponents().get(i)).getCodi()); // SE ACCEDE AL ATRIBUTO DEL OBJETO "RECANVI" HACIENDO USO DE COMPONENTS Y LOS MÉTODOS PROPIOS DE LA CLASE, ADEMÁS DE REFERENCIAR EN EL CAST AL OBJETO, DENTRO DEL ARRAYLIST, PARA QUE SE PUEDA UBICAR ESE ATRIBUTO
                    son.setAttribute("nom", ((Recanvi) taller.getComponents().get(i)).getNom());  // !!!!      IMPERATIVO PRESTAR ATENCION A LOS PARÉTESIS PUES PUEDE DAR ERROR O NO LLEGAR A LOS ATRIBUTOS QUE DESEEMOS POR ESTAR MAL UBICADOS
                    son.setAttribute("fabricant", ((Recanvi) taller.getComponents().get(i)).getFabricant());
                    
                 
                    son.setAttribute("preu", String.valueOf(((Recanvi) taller.getComponents().get(i)).getPreu()));
                    
                    
                    // VERIFICA SI ESTÁ O NO ASIGNADO
                    if(((Recanvi) taller.getComponents().get(i)).isAssignat()) {
                   son.setAttribute("assignat", "Si");
                        
                    } else {
                        son.setAttribute("assignat", "No");
                    }
                    
                   /////////////////////  VERIFICAR MÉTODO
                    
                   root.appendChild(son);
                }else if(taller.getComponents().get(i) instanceof Reparacio){
                    
                    son = doc.createElement("reparacio"); // SE DEBE DE INICIALIZAR SIEMPRE LA VARIABLE PARA IR INCORPORANDO LOS ATRIBUTOS Y ELELEMENTOS
                    son.setAttribute("codi", ((Reparacio) taller.getComponents().get(i)).getCodi());
                    son.setAttribute("dataInici", ((Reparacio) taller.getComponents().get(i)).getDataInici());
                    son.setAttribute("dataFi", ((Reparacio) taller.getComponents().get(i)).getDataFi());
         
                    son.setAttribute("preu", String.valueOf(((Reparacio) taller.getComponents().get(i)).getPreu()));
                    
                    
                    // VERIFICAR SI SE DEBE DE CASTEAR EL OBJETO 
                    son.setAttribute("client", String.valueOf(((Reparacio) taller.getComponents().get(i)).getClient())); 
                    
                    
                    // VERIFICAR SI EL MAP DEBE DE ESPECIFICAR EL KEY DE CADA LISTA
                    son.setAttribute("mecanic", String.valueOf(((Reparacio) taller.getComponents().get(i)).getMaps()));
                    
                    son.setAttribute("recanvi", String.valueOf(((Reparacio) taller.getComponents().get(i)).getMaps()));
                    
                    root.appendChild(son);
                    
                }
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
