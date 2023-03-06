package institutmvm.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*  
    Alejandro
    Garcia Dopico
    INS Manuel Vázquez Montalbán
    27/10/22
    Disseny d'Aplicació Web (DAW)
    Programació  
 */
public class methods {

    public int valorCorrecte(Scanner sc, String msg) {
        /*Aquest mètode valida si el valor és numèric,
                    l'utilitzem al programa quan escollim una opció*/
        boolean valorCorrecte;
        int num = 0;
        do {
            valorCorrecte = sc.hasNextInt();
            if (valorCorrecte) {
                num = sc.nextInt();
            } else {
                sc.next();
                System.out.println(msg);
            }
        } while (!valorCorrecte);
        return num;
    }

    public boolean comprovarText(String fitxer) {
        /*Aquest mètode comprova si el fitxer té contingut o està buit,
                                en el cas d'estar buit retorna un boolea al main*/
        try {
            BufferedReader br = new BufferedReader(new FileReader("files/" + fitxer));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) { // Si la línia no està buida
                    br.close();
                    return true;
                }
            }
            br.close();
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public void capcalera(String fitxer) {
        /*En aquest mètode comprovarem si existeix capçalera en el fitxer,
                                            en el cas de no hi averi l'afegeix*/
        try (BufferedReader br = new BufferedReader(
                new FileReader("files/" + fitxer)); BufferedWriter bw = new BufferedWriter(
                new FileWriter("files/" + fitxer, true))) {

            String firstLine = br.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                bw.write("Codi Article,Nom article,Tipus,Quantitat,Preu");
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }

    public void crearFitxer(String fitxer) {
        /*Aquest mètode s'encarrega de crear un fitxer 
                            per a posteriori treballar amb ell*/
        try {
            FileWriter fw = new FileWriter("files/" + fitxer, true);
            fw.write("");
            fw.close();
            System.out.println("L'arxiu s'ha creat correctament o existeix.");
        } catch (IOException e) {
            System.out.println("Ha ocorregut un error en crear l'arxiu.\n");
            e.printStackTrace();
        }
    }

    public void escriure(String sb, String fitxer) {
        /*Aquest mètode afegeix les dades anteriors al fitxer,
                            sense suprimir el contingut anterior*/
        String text = "";
        try {
            BufferedWriter bw
                    = new BufferedWriter(new FileWriter("files/" + fitxer, true));
            bw.write("\n" + sb); //Aquí fa un salt de linea per enregistrar-la correctament.
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        } finally {
            System.out.println("\nText guardat amb èxit");
        }
    }

    public String extensio(String fitxer) {
        /*Amb aquest mètode comprovarà si conte l'extensió .txt,
                                    en el cas contrari l'afegirà al fitxer*/
        if (!fitxer.endsWith(".txt")) {
            fitxer = fitxer + ".txt";
        }
        return fitxer;
    }

    public void llegirTabla(String fitxer) {
        /*Aquest mètode "llegirTabla" llegeix un fitxer de text i mostra el seu contingut de forma tabular. 
                    També utilitzara el mètode "split" per dividir la línia en columnes.
                    Així donçs printarem per consola de el contingut de forma tabular.*/
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("files/" + fitxer));
            String encabezados = br.readLine(); // Llegim la primera línia i separem les columnes per coma.
            String[] columnas = encabezados.split(",");

            // Aquí imprimim la taula de manera semblant al sql.
            System.out.println("+--------------+--------------+--------------+--------------+--------------+");

            /*Aquí utilitzem el for-each, permet recórrer una col·lecció d'elements i 
               executar una acció per a cada element.
              "printf" per printar en format taula i el "%-12s" especificarà l'amplada de la columna. */
            for (String columna : columnas) {
                System.out.printf("| %-13s", columna);
            }
            System.out.println("|");
            System.out.println("+--------------+--------------+--------------+--------------+--------------+");

            String linea;
            while ((linea = br.readLine()) != null) {  //Mentre hi hagi contingut per línia.
                String[] valores = linea.split(","); //Dividim els valors en array.
                for (String valor : valores) {
                    System.out.printf("| %-13s", valor);
                }
                System.out.println("|");
            }
            System.out.println("+--------------+--------------+--------------+--------------+--------------+");
            br.close();
        } catch (IOException e) {
            System.out.println("No hi ha text per mostrar.");
        }
    }

    public int totalArticles(String fitxer) {
        /*Aquest mètode contarà les línies que té en el fitxer exceptuant la primera,
                                    així doncs ens donarà la quantitat de registres que té.*/
        int totalRegistres = -1; //El -1 és per no contar la capçalera
        try {
            File file = new File("files/" + fitxer);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                sc.nextLine();
                totalRegistres++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha pogut trobar el fitxer " + fitxer);
        }
        return totalRegistres;
    }
}
