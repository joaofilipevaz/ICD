import java.util.Scanner;

public class consoleManager  {

    /**
     * MAIN
     **/

    public static void main(String[] args) {

        soneto son = new soneto();
        poemFactory pf = new poemFactory();

        pf.parseXML(son);

        // keyboard reader
        Scanner keyboard = new Scanner(System.in);

        // flags que controla o ciclo de execução
        boolean cicloGestor = true;

        // ciclo de leitura e execução de operações
        while (cicloGestor) {

            // mostrar o menu das opções
            System.out.println("-------: Poema Manager : -------");
            System.out.println("Opções:");
            System.out.println(" X - Sair");
            System.out.println(" P - Imprimir Poema");
            System.out.println(" C - Classifique as estrofes quanto ao número de versos");
            System.out.println(" A - Acrescentar um verso a uma estrofe");
            System.out.println(" R - Remover uma Estrofe");
            System.out
                    .println(" V - Pesquisar os versos que contêm determinada palavra");

            System.out.println("Insira uma opção ->");

            // ler a opção
            String line = keyboard.next();
            // eliminar espaços no início e no fim da string
            line = line.trim();

            // validar o tamanho
            if (line.length() > 1) {
                System.out
                        .println("Só deveria ter introduzido um caractere: "
                                + line);
            } else {

                // obter o caractere em maiusculas
                char option = Character.toUpperCase(line.charAt(0));

                // agulhar para a acção correcta
                switch (option) {
                    case 'X':
                        // terminar o gestor
                        System.out.println("\nBye...");
                        cicloGestor = false;
                        break;
                    case 'P':
                        System.out.println("Imprimir Poema:");
                        System.out.println();
                        son.falaPoema();
                        System.out.println("Prima Enter para continuar");
                        keyboard.nextLine();
                        break;
                    case 'C':
                        System.out
                                .println("Classificação das estrofes quanto ao número de versos:" + "\n");
                        son.getClassEstrofe();
                        System.out.println("Prima Enter para continuar");
                        keyboard.nextLine();
                        break;
                    case 'A':
                        System.out.println("Acrescentar um verso a uma estrofe");
                        System.out.println();
                        System.out.println("Indique o Numero da Estrofe onde inserir o verso --> ");
                        int estrof = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.print("Escreva o Verso a Inserir --> ");
                        // ler a opção
                        String verso = keyboard.nextLine();
                        // eliminar espaços no início e no fim da string
                        verso = verso.trim();
                        son.addVerso(estrof, verso);
                        System.out.println();
                        son.falaPoema();
                        System.out.println();
                        System.out.println("Prima Enter para continuar");
                        break;
                    case 'R':
                        System.out.println("Remover uma Estrofe:");
                        System.out.println();
                        System.out.println("Escolha a Estrofe a remover:");
                        int estrf = keyboard.nextInt();
                        keyboard.nextLine();
                        son.removeEstrofes(estrf);
                        System.out.println("Prima Enter para continuar");
                        //keyboard.nextLine();
                        break;
                    case 'V':
                        System.out.println("Pesquisa de versos que contêm determinada palavra:\n");
                        System.out.println("Escreva a palavra a pesquisar --> ");
                        // ler a opção
                        String word = keyboard.next();
                        // eliminar espaços no início e no fim da string
                        word = word.trim();
                        System.out.println(son.search(word));
                        System.out.println("Prima Enter para continuar");
                        keyboard.nextLine();
                        break;
                    default:
                        // opção inválida
                        System.out.println("A opção escolhida é inválida: "
                                + option + "\n");
                }
            }

            if (cicloGestor) {
                keyboard.nextLine();
            }

        }
        // fechar o keyboard
        keyboard.close();
        System.exit(0);
    }
}
