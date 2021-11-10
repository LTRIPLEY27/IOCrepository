package persistencia;

import areesTaller.Client;
import areesTaller.Mecanic;
import areesTaller.Persona;
import areesTaller.Recanvi;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import principal.GestorTallerMecanicException;
import principal.Reparacio;
import principal.Taller;

/**
 *
 * @I Calzadilla
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

            
            Element son, grandson;  // ELEMENTOS QUE CREARAN LOS NODOS
            
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
                
                if(taller.getComponents().get(i) instanceof Client) {
                    
                    Client client = (Client) taller.getComponents().get(i);// CASTEO LA POSICION DIRECTAMENTE PARA MAXIMIZAR EL CÓDIGO
                    son = doc.createElement("client");
                    son.setAttribute("nif", (client.getNif()));
                    son.setAttribute("nom", (client.getNom()));
                    son.setAttribute("telefono", (client.getTelefon()));
                    son.setAttribute("correo", (client.getCorreu()));
                    
                    root.appendChild(son);
                }
                
                else if(taller.getComponents().get(i) instanceof Mecanic) {
                    
                    Mecanic mecanic = (Mecanic) taller.getComponents().get(i);// CASTEO LA POSICION DEL MECANIC EN TALLERS
                    son = doc.createElement("mecanic");
                    son.setAttribute("nif", (mecanic.getNif()));
                    son.setAttribute("nom", (mecanic.getNom()));
                    son.setAttribute("telefono", (mecanic.getTelefon()));
                    son.setAttribute("correo", (mecanic.getCorreu()));
                    
                    root.appendChild(son);
                    
                }
                
                else if(taller.getComponents().get(i) instanceof Recanvi) {
                    
                    Recanvi recanvi = (Recanvi) taller.getComponents().get(i);
                    son = doc.createElement("recanvi");
                    son.setAttribute("codi", (recanvi.getCodi())); // SE ACCEDE AL ATRIBUTO DEL OBJETO "RECANVI" HACIENDO USO DE COMPONENTS Y LOS MÉTODOS PROPIOS DE LA CLASE, ADEMÁS DE REFERENCIAR EN EL CAST AL OBJETO, DENTRO DEL ARRAYLIST, PARA QUE SE PUEDA UBICAR ESE ATRIBUTO
                    son.setAttribute("nom", (recanvi.getNom()));  // !!!!      IMPERATIVO PRESTAR ATENCION A LOS PARÉTESIS PUES PUEDE DAR ERROR O NO LLEGAR A LOS ATRIBUTOS QUE DESEEMOS POR ESTAR MAL UBICADOS
                    son.setAttribute("fabricant", (recanvi.getFabricant()));
                    
                 
                    son.setAttribute("preu", String.valueOf(recanvi.getPreu()));
                    
                    
                    // VERInvi) taller.getComponents().get(i)).isAssignat()FICA SI ESTÁ O NO ASIGNADO
                    if(recanvi.isAssignat()) {
                   son.setAttribute("assignat", "Si");
                        
                    } else {
                        son.setAttribute("assignat", "No");
                    }
                    
                   /////////////////////  VERIFICAR MÉTODO
                    
                   root.appendChild(son);
                   
                }else if(taller.getComponents().get(i) instanceof Reparacio){
                    
                    Reparacio reparacio = (Reparacio) taller.getComponents().get(i);
                    
                    son = doc.createElement("reparacio"); // SE DEBE DE INICIALIZAR SIEMPRE LA VARIABLE PARA IR INCORPORANDO LOS ATRIBUTOS Y ELELEMENTOS
                    son.setAttribute("codi", (reparacio.getCodi()));
                    son.setAttribute("dataInici", (reparacio.getDataInici()));
                    son.setAttribute("dataFi", (reparacio.getDataFi()));
         
                    son.setAttribute("preu", String.valueOf(reparacio.getPreu()));
                    
                    // ES IMPERATIVO HACER UN FOR QUE RECORRA LAS LISTAS CONTENIDAS DENTRO DE REPARACION PARA IR ACCEDIENDO A CADA ATRIBUTO SEGUN EL CASO (CLIENTES, MECANICS Y DEMÁS) !!!! ERROR NO COLOCAR UN ITERADOR INTERNO 
                    
                    if(reparacio.getClient() != null) {
                        grandson = doc.createElement("client"); // HACEMOS USO DE LA VARIABLE "GRANDSON" QUE REPRESENTA AL CLIENTE CONTENIDO EN REPARACION DENTRO DEL XML
                   
                        grandson.setAttribute("nif", (reparacio.getClient().getNif()));  // ACCEDEMOS A LOS DATOS "CLIENTE" MEDIANTE EL ARRAY COMPONENTS Y LOS MÉTODOS DE LA CLASE ARRAYLIST, VERIFICAR LOS PARENTESIS
                        grandson.setAttribute("nom", (reparacio.getClient().getNom()));
                        grandson.setAttribute("telefono", (reparacio.getClient().getTelefon()));
                        grandson.setAttribute("correo", (reparacio.getClient().getCorreu()));
                   
                        son.appendChild(grandson);
                    }
                    
                    
                    Set <String> keys = ((Reparacio) taller.getComponents().get(i)).getMaps().keySet();// VERIFICAR
                    
                    for(String key : keys) { // RECORRE LOS VALORES DEL SET UNO A UNO Y VA RETORNANDO
                        if(key.equals("mecanics")) {
                            
                            List <Mecanic> mecanics = (ArrayList <Mecanic>) reparacio.getMaps().get(key);
                            
                            for(Mecanic mecanic : mecanics) {
                                grandson = doc.createElement("mecanic");
                   
                                grandson.setAttribute("nif", mecanic.getNif());  // SE DEBEN DE PASAR 2 CLASES COMO PARÁMETROS PARA ACCEDER A LA LIST ESPECÍFICA A LA QUE REFIERE EL ATRIBUTO, ESTAR MUYYYY ATENTO A LOS PARÉNTESIS
                        
                                grandson.setAttribute("nom", mecanic.getNom()); // LOS PARÉNTESIS REFIEREN A 2 TIPOS: INTERNO Y EXTERNO, INTERNO: ALBERGA A REPARACIO Y TALLER, Y CIERRA POR ENDE EN EL GET INDEX DE REPARARACIO, PARA LOGRAR ACCEDER A LA LIST, EL EXTERNO SE COMPONE DE MECANIC + EL INTERNO HASTA LA "LIST", ENVIANDO COMO PARÁMETRO DEL INDEX LA "KEY" QUE SE LE COLOCÓ A LA LIST PARA ACCEDER AL ATRIBUTO DE ESE TIPO DE OBJETO DENTRO DE ESA LISTA.
                                grandson.setAttribute("telefono", mecanic.getTelefon());
                                grandson.setAttribute("correo",mecanic.getCorreu());
                                son.appendChild(grandson);
                        }   
                            } else if(key.equals("recanvis")) {
                                
                                List <Recanvi> recanvis = (ArrayList <Recanvi>) reparacio.getMaps().get(key);

                                for(Recanvi recanvi : recanvis) {
                                    grandson = doc.createElement("Recanvi");
                        
                                    grandson.setAttribute("codi", recanvi.getCodi());
                                    grandson.setAttribute("nom", recanvi.getNom());
                                    grandson.setAttribute("fabricant", recanvi.getFabricant());
                                    grandson.setAttribute("preu", String.valueOf(recanvi.getPreu()));
                                    
                                    if((recanvi).isAssignat()) {
                                        grandson.setAttribute("assignat", "Si");
                                    } else {
                                        grandson.setAttribute("assignat", "No");
                                    }
                        
                                    son.appendChild(grandson);
                            }
                            }            
                  
                        
                   
                    
                   root.appendChild(son);
                        
                    }
                   
                   
                    
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
       
        String cadenaAUX; // cadena que recibir+a los valores
        
        Element root = doc.getDocumentElement(); // UBICA AL DOCUMENTO
        
        taller = new Taller(root.getAttribute("cif"), root.getAttribute("nom"), root.getAttribute("adresa"));  // HACEMOS USO DE LOS MÉTODOS GET DE LA CLASE XML PARA IR TOMANDO Y LEYENDO CADA ELEMENTO DE LA CLASE TALLER (EN CONTRAPOSICION A CONSTRUIXXML)
        
        NodeList sonList = root.getChildNodes(); // MÉTODO PARA OBTENER LOS HIJOS DE ROOT
        
        for(int i = 0; i < sonList.getLength(); i++) {
            
            Node son = sonList.item(i); // RETORNA LOS ITEMS QUE COMPONEN LA LISTA DE HIJOS
            
            if(son.getNodeType() == Node.ELEMENT_NODE) { // UBICA LOS ELELEMENTOS INDIVIDUALES DE CADA NODO PARA EMPEZAR A RETORNAR CADA UNO D EELLOS
                
                cadenaAUX = son.getNodeName(); // ALMACENA EL VALOR DEL NOMBRE DEL NODO PARA EMPEZAR A COMPARAR Y LEER
                
                if(cadenaAUX.equals("client")) {
                    
                    String nif = ((Element) son).getAttribute("nif");  // ubica con los métodos de "Element" cada atributo y comienza a devolver
                    
                    String nom = ((Element) son).getAttribute("nom");
                    String telefono = ((Element) son).getAttribute("telefono");
                    String correo = ((Element) son).getAttribute("correo");
                    taller.addClient(new Client(nif, nom, telefono, correo));  // se adjunta a taller un nuevo cliente con parámetro new Client y los valores del constructor a inicializar.
                    
                    
                    
                    
                    
                } else if(cadenaAUX.equals("mecanic")) {
                    
                       String nif = ((Element) son).getAttribute("nif");  // ubica con los métodos de "Element" cada atributo y comienza a devolver
                    
                    String nom = ((Element) son).getAttribute("nom");
                    String telefono = ((Element) son).getAttribute("telefono");
                    String correo = ((Element) son).getAttribute("correo");
                    taller.addMecanic(new Mecanic(nif, nom, telefono, correo));
                    
                } else if(cadenaAUX.equals("recanvis")) {
                    
                    String codi = ((Element) son).getAttribute("codi");
                    String nom = ((Element) son).getAttribute("nom");
                    String fabricant = ((Element) son).getAttribute("fabricant");
                    
                    double preu = Double.parseDouble(((Element) son).getAttribute("preu"));
                    
                    boolean assignat = false;
                    
                    if(((Element) son).getAttribute("assignat").equals("si")) {
                        assignat = true;
                        
                    }
                    
                    taller.addRecanvi(new Recanvi(codi, nom, fabricant, preu, assignat));
                    
                }
                
                else if(cadenaAUX.equals("reparacio")) {
                    String codi = ((Element) son).getAttribute("codi");
                    String dataInici = ((Element) son).getAttribute("dataInici");
                    String dataFi = ((Element) son).getAttribute("dataFi");
                    double preu = Double.parseDouble(((Element) son).getAttribute("preu"));
                    
                    Reparacio repa = new Reparacio(codi, dataInici, dataFi); //ALMACENAMOS EN UN OBJETO REPARACION LOS VALORES YA QUE DEBEMOS ITERARLOS
                    
                    taller.addReparacio(repa);
                    
                    NodeList childson = son.getChildNodes();//NODELIST QUE CONTENDRÁ TODOS LOS ELEMENTOS DE RECANVIS Y SUS LISTAS
                    
                    for(int x = 0; x < childson.getLength(); x++) {
                        Node child = childson.item(x);  // OBTIENE LOS HIJOS DE REPARACIO
                        
                        if(child != null && child.getNodeType() == Node.ELEMENT_NODE) {
                      
                            int tipus = 0;
                            
                            String cadenaAux = child.getNodeName();
                            
                            switch(cadenaAUX) {
                                case "client":
                                    repa.setClient((Client) taller.getComponents().get(taller.selectComponent(1,((Element) son).getAttribute("client"))));
                                    break;
                                case "mecanic":
                                    repa.addMecanic((Mecanic) taller.getComponents().get(taller.selectComponent(2,((Element) son).getAttribute("mecanic"))));
                                    break;
                                case "recanvis":
                                    repa.addRecanvi((Recanvi) taller.getComponents().get(taller.selectComponent(3, ((Element) son).getAttribute("recanvis"))));
                                    break;
                                default:
                                    repa.setPreu(taller.selectComponent(4, ((Element) son).getAttribute("preu")));
                                   
                            }
                            
                            
                            
                            
                        }
                        
                    }
                    
                    
                }
                
            }
        }
        
        
    }
}
