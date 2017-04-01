import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
class soneto {

    private String autor;
    private String titulo;
    private String search;
    private List<List<String>> estrofes;

    soneto() {
        this.autor = "";
        this.titulo = "";
        this.search = "";
        this.estrofes = new ArrayList<>();
    }

    @XmlElement
    private String getAutor() {
        return this.autor;}

    void setAutor(String str) {
        this.autor = str;}

    @XmlElement
    private String getTitulo() {
        return this.titulo;}

    void setTitulo(String str) {
        this.titulo = str;}

    void getClassEstrofe() {

        int numversos;
        Map<Integer, String> classNumVersos = new HashMap<>();

        classNumVersos.put(1, "Monóstico");
        classNumVersos.put(2, "Dístico");
        classNumVersos.put(3, "Terceto");
        classNumVersos.put(4, "Quadra");
        classNumVersos.put(5, "Quintilha");
        classNumVersos.put(6, "Sextilha");
        classNumVersos.put(7, "Septilha");
        classNumVersos.put(8, "Oitava");
        classNumVersos.put(9, "Nona");
        classNumVersos.put(10, "Décima");

        for (int i = 0; i < estrofes.size(); i++) {
            numversos = estrofes.get(i).size();
            if ( classNumVersos.containsKey( numversos ) ) {
                System.out.println(String.format("%d Estrofe --> ", i + 1)+ numversos +
                        " versos = "+ classNumVersos.get(numversos));
            }else{
                System.err.println("Erro --> Numero de versos suportados entre 1 e 10");
            }
        }
    }

    void addVerso(int numestrf, String verso) {
        if (numestrf < estrofes.size() && numestrf > 0) {
            if (verso != null) {
                if (!verso.isEmpty()) {
                    estrofes.get(numestrf - 1).add(verso + "\n");
                }
            }
        }
    }

    private String getVersos() {
        String result = "";
        for (List<String> estrofe : estrofes) {
            for (String versos : estrofe) {
                result += versos;
            }
            result += "\n";
        }
        return result;
    }

    void setVersos(int numestrf, int numverso, String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                estrofes.get(numestrf).add(numverso, str);
            }
        }
    }

    void setEstrofes(int numestrf) {
        for (int i = 0; i < numestrf; i++) {
            estrofes.add(new ArrayList<>());
        }
    }

    void removeEstrofes(int numestrf) {
        if (numestrf <= estrofes.size() && numestrf > 0) {
            estrofes.remove(numestrf-1);
        } else {
            System.err.println("Erro --> Numero de Estrofe inexistente");
        }

    }

    String search(String word) {
        for (List<String> estrofe : estrofes) {
            for (String anEstrofe : estrofe) {
                if (anEstrofe.contains(word)) {
                    search += anEstrofe;
                }
            }
        }
        return search;
    }

    void falaPoema(){
        System.out.println("Autor --> " + getAutor());
        System.out.println("Titulo --> " + getTitulo() + "\n");
        System.out.println(getVersos());
    }
}