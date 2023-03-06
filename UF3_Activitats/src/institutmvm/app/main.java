/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package institutmvm.app;

import institutmvm.utils.Methods;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*  
    Alejandro
    Garcia Dopico
    INS Manuel Vázquez Montalbán
    27/10/22
    Disseny d'Aplicació Web (DAW)
    Programació  
 */
public class main {

    private static final String MSG_1 = "Que vols fer: \n" + "\nLlegir fitcher(0)" + "\nGuardar text(1)" + "\nAfegir text(2)" + "\nComptar longitud(3)\n";
    private static final String MSG_2 = "Error Torna-hi";
    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods met = new Methods();

        /*WARNING!! Alguns dels exercicis comparteixen variables perque es ordenat per nomenclatura,
        Per aquest motiu, silenciarem individualment per executar cada activitat, Gracies!*/
        
        /*
        
        //Exercici_1:
        int i;
        try (FileReader fr = new FileReader(
                "files/document.txt")) {
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException fe) {
            System.out.println("An error occurred");
            fe.printStackTrace();
        } catch (IOException ioex) {
            System.out.println("An error occurred");
            ioex.printStackTrace();
        }

        
        //Exercici_2:    

        System.out.print("Introduce el nombre del documento: ");
        String fileName = sc.nextLine();

        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }

        File file = new File(fileName);
        try (Scanner fileInput = new Scanner(file)) {
            while (fileInput.hasNextLine()) {
                System.out.println(fileInput.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró.");
        }

        /*
        
        //Exercici_3:
        File file2 = new File("files/document2.txt");
        System.out.println(file.length() + " caracters.");

        
        //Exercici_4 --> Document PDF
        try {
            File file3 = new File("file.txt");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

        //Exercici_5 + Exercici_6 (add true on FileWriter)
        System.out.print("Entra el text: ");
        String text = sc.nextLine();

        File file3 = new File("files/text.txt");
        try {
            BufferedWriter bw = 
                    new BufferedWriter(new FileWriter("files/text.txt", true));
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        finally{
            System.out.println("Text guardat amb èxit");
        }
                         

        
        //Exercici_7:
                
        System.out.println("Introdueix el nomb del fitxer: ");
        int opcio = 0;
        String fitxer ="";
        boolean exit = false;
        
        fitxer = sc.nextLine();
        System.out.println(MSG_1);
        File file7 = new File("files/" + fitxer);
        do {
            opcio = met.valorCorrecte(sc);
            switch (opcio) {
                case 0:       
                    exit = met.llegir(fitxer);
                    break;
                case 1:
                    System.out.print("Entra el text: ");
                    exit = met.guardar(fitxer);
                    break;
                case 2:
                    System.out.print("Afageix text: ");
                    exit = met.afegir(fitxer);
                    break;
                case 3:   
                    System.out.println(file7.length() + " caracters.");
                    exit = true;
                    break;
                default:
                    System.out.println(MSG_2);
                    break;
            }
        } while (!exit);
               
        
        //Exercici_8 --> Document PDF
        
        
        //Exercici_9:
        int opcio = 1;
        boolean exit = false;
        while (opcio == 1) {
            System.out.print("Introdueix l'ID: ");
            int id = met.valorCorrecte(sc);
            System.out.print("Introdueix el nom: ");
            String nom = sc.next();
            System.out.print("Introdueix el cognom: ");
            String cognom = sc.next();
            System.out.print("Introdueix l'edat: ");
            int edat = met.valorCorrecte(sc);
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("files/sorteig.txt", exit))) {
                bw.write("L'ID: " + id + "\nNom: " + nom + "\nCognom: " + cognom + "\nL'Edat: " + edat + "\n");
                bw.close();
                System.out.println("Registre guardat correctament");
            } catch (IOException e) {
                System.out.println("Error a l'hora de guardar el registre");
            }

            System.out.print("Vols introduir un altre registre? (1 = si, 0 = no): ");
            opcio = sc.nextInt();
            if(opcio == 1){
                exit = true;
            }
        }
        

         
        //Exercici_10:
        BufferedReader br = null;
        int arrays[];
        
        try {

            br = new BufferedReader(new FileReader("files/dades.csv"));
            String line = br.readLine();
            while (null != line) {
                String[] fields = line.split(SEPARATOR);
                System.out.println(Arrays.toString(fields));

                met.removeTrailingQuotes(fields);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error a l'hora de guardar el registre");
        }

        
        
        //Exercici 11
        System.out.println("A continuacio introdueix les dades" + "\n");

        System.out.print("Codi: ");
        String codi = sc.nextLine();

        System.out.print("Nom projecte: ");
        String nomProjecte = sc.nextLine();

        System.out.print("Descripció: ");
        String descripcio = sc.nextLine();

        System.out.print("Codi client: ");
        String codiClient = sc.nextLine();

        System.out.print("Import: ");
        String importe = sc.nextLine();

        System.out.print("Data inici (dd/mm/yyyy): ");
        String dataInici = sc.nextLine();

        System.out.print("Data fi (dd/mm/yyyy): ");
        String dataFi = sc.nextLine();     

        try {
            FileWriter fw = new FileWriter("files/projectes11.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("Codi,Nom projecte,Descripció,Codi client,Import,Data inici,Data fi");
            pw.println(codi + "," + nomProjecte + "," + descripcio + "," + codiClient + "," + importe + "," + dataInici + "," + dataFi);

            pw.close();
            bw.close();
            fw.close();

            System.out.println("Dades afegides correctament!");
        } catch (Exception e) {
            System.out.println("Error al escriure les dades: " + e.getMessage());
        }        
        
        
        
        //Exercici_12
        
        boolean exit = false, capçalera = false;       
        String[] dades = new String[7];
        System.out.println("Escull una de les seguents opcions: ");
        
        while (!exit) {
            System.out.println("\n" + "Afegir dades (1)" + "\nLlegir dades (2)" + "\nFinalitzar el programa (3)" + "\n");
            System.out.print("Opció: ");
            int opcio = sc.nextInt();
            sc.nextLine();
            if (opcio == 1) {
                System.out.print("Codi: ");
                dades[0] = sc.nextLine();

                System.out.print("Nom projecte: ");
                dades[1] = sc.nextLine();

                System.out.print("Descripció: ");
                dades[2] = sc.nextLine();

                System.out.print("Codi client: ");
                dades[3] = sc.nextLine();

                System.out.print("Import: ");
                dades[4] = sc.nextLine();

                System.out.print("Data inici (dd/mm/yyyy): ");
                dades[5] = sc.nextLine();

                System.out.print("Data fi (dd/mm/yyyy): ");
                dades[6] = sc.nextLine();               

                try {
                    FileWriter fw = new FileWriter("files/projectes12.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    
                    if(!capçalera){
                        pw.println("Codi,Nom projecte,Descripció,Codi client,Import,Data inici,Data fi");
                    }
                    pw.println(dades[0] + "," + dades[1] + "," + dades[2] + "," + dades[3] + "," + dades[4] + "," + dades[5] + "," + dades[6]);

                    pw.close();
                    bw.close();
                    fw.close();

                    System.out.println("Dades afegides correctament!");
                } catch (Exception e) {
                    System.out.println("Error al escriure les dades: " + e.getMessage());
                }
            } else if (opcio == 2) {
                try {
                    FileReader fr = new FileReader("files/projectes.txt");
                    BufferedReader br = new BufferedReader(fr);

                    String linea = br.readLine();
                    System.out.println("Codi  |  Nom projecte  |  Descripció  |  Codi client  |  Import  |  Data inici  |  Data fi  |");

                    while ((linea = br.readLine()) != null) {
                        dades = linea.split(",");
                        System.out.println(dades[0] + "   |       " + dades[1] + "    |     " + dades[2] + "  |   " + dades[3] + "    |    " + dades[4] + "    |    " + dades[5] + "    |   " + dades[6] + "   |");
                    }
                } catch (Exception e) {
                    System.out.println("Error al escriure les dades: " + e.getMessage());
                }
            } else if (opcio == 3) {
                System.out.println("Programa finalitzat" + "\n");
                exit = true;
            }
            capçalera = true;
        }
        sc.close(); 
                
        //Exercici_13 --> Document PDF

         
        
        
        //Exercici_14
        
        /*
            Sí, existeixen diverses classes a la API de Java per a crear fitxers. 
            Una d'elles és la classe "File" que proporciona diverses funcions per a manipular fitxers i directoris.
            A continuació, us mostro un exemple senzill de com crear un fitxer utilitzant la classe "File":
                                                                                                                */
        
        try {           
            String fitxer ="";
            System.out.println("Introdueix el nom del fitxer: ");
            fitxer = sc.next();    
            File file = new File("files/" + fitxer);                  // Especificar la ruta completa del fitxer que es vol crear                                                             
            if (file.createNewFile()) {                               // Si el fitxer no existeix, es crea
                System.out.println("Fitxer creat: " + file.getName());
            } else {
                System.out.println("El fitxer ja existeix.");
            }
        } catch (IOException e) {
            System.out.println("Error en la creació del fitxer.");
            e.printStackTrace();
        }
        
        
        /*
            En aquest exemple, es crea un fitxer anomenat "fitxer.txt" a la ruta "/NetBeans-Java/UF3_Activitats/files". 
            Si el fitxer ja existeix, el programa ho indicarà per pantalla. 
            Si el fitxer no existeix, es crearà i el programa ho indicarà per pantalla.
                                                                                                               */
        
        
        
        //Exercici_15
        
        System.out.println("Introdueix la ruta del directori:");    // Demanar al usuari el nom del directori
        Scanner scanner = new Scanner(System.in);
        String directori = scanner.nextLine();

        File directory = new File(directori);                 // Crear un objecte File amb la ruta del directori

        if (directory.exists() && directory.isDirectory()) {         // Comprovar si el directori existeix i és un directori      
            File[] arrayfiles = directory.listFiles();                    // Llistar els fitxers del directori
            if (arrayfiles != null) {
                for (int i = 0; i < arrayfiles.length; i++) {
                    File cadena = arrayfiles[i];
                    System.out.println(cadena.getName());
                }
            } else {
                System.out.println("El directori no existeix o no és un directori.");
            }
        }
        
        //Exercici_16 --> PDF
        
    }
}
