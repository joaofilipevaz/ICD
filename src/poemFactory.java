import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

class poemFactory {

    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    private XPathFactory xpathFactory;
    private XPath xpath;

    private Document doc;

    void parseXML(soneto son) {

        try {

            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse("soneto.xml");

            xpathFactory = XPathFactory.newInstance();
            xpath = xpathFactory.newXPath();

            doc = (Document) xpath.evaluate("/", document, XPathConstants.NODE);

            son.setAutor(xpath.evaluate("/poema/autor", doc));
            son.setTitulo(xpath.evaluate("/poema/título", doc));

            NodeList est = (NodeList) xpath.evaluate("//estrofe", doc, XPathConstants.NODESET);

            //inicializa o numero de estrofes
            son.setEstrofes(est.getLength());
            for (int i = 0; i < est.getLength(); i++) {
                NodeList listaversos = (NodeList) xpath.evaluate("verso", est.item(i), XPathConstants.NODESET);
                for (int z = 0; z < listaversos.getLength(); z++) {
                    son.setVersos(i, z, listaversos.item(z).getTextContent() + "\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.print("Erro ao analisar o documento XML.");
        }
    }
}