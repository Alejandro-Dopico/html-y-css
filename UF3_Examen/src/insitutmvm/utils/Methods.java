package insitutmvm.utils;

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
public class Methods {
    
    public int valorCorrecte(Scanner sc) {

        boolean valorCorrecte;
        int num = 0;
        do {
            valorCorrecte = sc.hasNextInt();
            if (valorCorrecte) {
                num = sc.nextInt();
            } else {
                sc.next();
                System.out.println("Error.");
            }
        } while (!valorCorrecte);
        return num;
    }
}








































    /*
    public void llistaFitxers(String directori) {

        File directory = new File(directori);                 // Crear un objecte File amb la ruta del directori
        if (directory.exists() && directory.isDirectory()) {         // Comprovar si el directori existeix i és un directori      
            File[] arrayfiles = directory.listFiles();                    // Llistar els fitxers del directori
            if (arrayfiles != null) {
                for (int i = 0; i < arrayfiles.length; i++) {
                    File cadena = arrayfiles[i];
                    System.out.println(cadena.getName());
                }
            } else {
                System.out.println("No hi ha fitxers en el directory.");
            }
        } else {
            System.out.println("El directori no existeix.");
        }
    }

    public void escriureBuffer(String text, String fitxer) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("files/" + fitxer, true)); 
            bw.write(text);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        } finally {
            System.out.println("\nText guardat amb èxit");
        }
    }

    public void escriureFile(String text, String fitxer) {

        try {
            FileWriter fw = new FileWriter("files/" + fitxer, true);
            fw.write("\n" + text);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        } finally {
            System.out.println("\nText guardat amb èxit");
        }
    }

    public String extensio(String fitxer) {

        if (!fitxer.endsWith(".txt")) {
            fitxer = fitxer + ".txt";
        }
        return fitxer;
    }

    public int totalLineas(String fitxer) {

        int totalLineas = -1; //El -1 és per no contar la capçalera
        try {
            File file = new File("files/" + fitxer);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                sc.nextLine();
                totalLineas++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha pogut trobar el fitxer " + fitxer);
        }
        return totalLineas;
    }

    public String printarTabular(String fitxer) {
        int contadorColumnas = 0;
        String line = "";
        String separador = ",";
        System.out.print("");
        try (BufferedReader br = new BufferedReader(new FileReader("files/" + fitxer))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(separador);
                if (contadorColumnas == 0) {
                    // Imprime la cabecera de la tabla
                    System.out.format("%-15s%-15s\n", data[0], data[1]);
                    // Cambia los números (4) por la cantidad de columnas que tenga tu archivo CSV
                } else {
                    // Imprime los datos de cada fila
                    System.out.format("%-15s%-15s\n", data[0], data[1]);
                }
                contadorColumnas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fitxer;
    }

    public void llegirFile(String fitxer) {
        int i = 0;
        try (FileReader fr = new FileReader("files/" + fitxer)) {
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void llegirBuffer(String fitxer) {
        try {
            File file = new File("files/document.txt");
            BufferedReader reader = new BufferedReader(new FileReader("files/" + fitxer));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    public boolean comprovarText(String fitxer) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("files/" + fitxer));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
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

        try ( BufferedReader br = new BufferedReader(
                new FileReader("files/" + fitxer));  BufferedWriter bw = new BufferedWriter(
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
}
*/
