/**
 * Created by Mónica on 31/03/2017.
 */

import java.io.File;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

// Exemplo de XPATH
public class JaxpExample03MainXSLT {

    public static void main(String[] args) {
        System.out.println("Exemplo de JAXP a utilizar XSLT");

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File("ap2/src/Poema2.xsl"));
            Transformer transformer = factory.newTransformer(xslt);

            Source text = new StreamSource(new File("ap2/src/poema.xml"));
            transformer.transform(text, new StreamResult(new File("ap2/src/output-xslt.xml")));

            System.out.println("XSLT executada...");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.print("Erro ao executar a transformação XSLT.");
        }
    }
}