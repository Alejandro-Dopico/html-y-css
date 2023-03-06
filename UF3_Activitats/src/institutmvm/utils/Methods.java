/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvm.utils;

import java.io.BufferedWriter;
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

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    Scanner sc = new Scanner(System.in);

    public int valorCorrecte(Scanner sc) { //Validem el número si es númeric.

        boolean valorCorrecte;
        int num = 0;
        do {
            valorCorrecte = sc.hasNextInt();
            if (valorCorrecte) {
                num = sc.nextInt();
            } else {
                sc.next();
                System.out.println("Error, torna-hi");
            }
        } while (!valorCorrecte);
        return num;
    }

    public boolean llegir(String fitxer) {
        int i;
        try (FileReader fr = new FileReader(
                "files/" + fitxer)) {
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
        return true;
    }

    public boolean guardar(String ruta) {
        String text;
        text = sc.nextLine();
        try {
            BufferedWriter bw
                    = new BufferedWriter(new FileWriter("files/" + ruta));
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        } finally {
            System.out.println("Text guardat amb èxit");
        }
        return true;
    }

    public boolean afegir(String ruta) {
        String text = "";
        text = sc.nextLine();
        try {
            BufferedWriter bw
                    = new BufferedWriter(new FileWriter("files/" + ruta, true));
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        } finally {
            System.out.println("Text guardat amb èxit");
        }
        return true;
    }

    public boolean longitud(String ruta) {
        String text = "";
        text = sc.nextLine();
        try {
            BufferedWriter bw
                    = new BufferedWriter(new FileWriter("files/" + ruta, true));
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        } finally {
            System.out.println("Text guardat amb èxit");
        }
        return true;
    }

    public static String[] removeTrailingQuotes(String[] fields) {

        String result[] = new String[fields.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }
}
