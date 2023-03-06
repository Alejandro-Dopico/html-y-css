package institutmvm.app;

import institutmvm.utils.methods;
import java.io.IOException;
import java.util.Scanner;

/*  
    Alejandro
    Garcia Dopico
    INS Manuel Vázquez Montalbán
    27/10/22S
    Disseny d'Aplicació Web (DAW)
    Programació  
 */
public class main {

    private static final String MSG_INTRO = "****** [GESTIÓ D’ARTICLES] ******";
    private static final String MSG_INTRO_2 = "*********************************";
    private static final String MSG_FINAL = "******************************";
    private static final String MSG_1 = "\nEscull una de les opcions: \n" + "\nA. Veure articles" + "\nB. Enregistrar un nou article" + "\nC. Mostrar total d'articles" + "\nD. Sortir";
    private static final String MSG_2 = "Error Torna-hi";
    private static final String MSG_3 = "\n[S'ha finalitzat el programa.]";
    private static final String MSG_4 = "\n(0).Crear document o utilitzar un existent\n(1).Utilitzar l'habitual\n";
    private static final String MSG_5 = "\nIntrodueix el nom del fitxer: ";
    private static final String MSG_6 = "\nQuina opció vols?: ";
    private static final String MSG_7 = "Error, introduiex valor 0 o 1";
    private static final String MSG_8 = "No hi ha text per mostrar.";
    private static final String MSG_9 = "\nLa llista d’articles és la següent:";
    private static final String MSG_FITXER = "articles.txt";
    private static final String COLOR = "\033[0;35m";

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        methods met = new methods();

        int eleccio = 0, registres = 0;
        char opcio;
        String fitxer = "";
        String codi, nombre, tipus, quantitat, preu;
        boolean exit = false, correcte = false, contingut = false;
        StringBuffer sb = new StringBuffer();

        System.out.println(COLOR + MSG_INTRO + COLOR);
        System.out.println(COLOR + MSG_INTRO_2 + COLOR + MSG_1);

        do {
            System.out.print(MSG_6);
            opcio = sc.next().charAt(0);
            opcio = (char) Character.toUpperCase(opcio); //Aquí passem el "char" a majúscules.
            switch (opcio) {
                case 'A':
                    System.out.print(MSG_5);
                    fitxer = sc.next();
                    fitxer = met.extensio(fitxer);
                    contingut = met.comprovarText(fitxer);
                    if (contingut) {
                        System.out.println(MSG_9);
                        met.llegirTabla(fitxer);
                    } else {
                        System.out.println(MSG_8);
                    }
                    break;
                case 'B':
                    System.out.println(MSG_4);

                    /*Aquí hi ha el sistema d'elecció, he afegit l'opció
                      número "2", aquesta et permet escriure en un fitxer existent. */
                    do {
                        eleccio = met.valorCorrecte(sc, MSG_7);
                        if (eleccio == 0) {
                            System.out.print(MSG_5);
                            fitxer = sc.next();
                            fitxer = met.extensio(fitxer);
                            met.crearFitxer(fitxer);
                            met.capcalera(fitxer);
                            correcte = true;
                        } else if (eleccio == 1) {
                            fitxer = MSG_FITXER;
                            met.capcalera(fitxer);
                            correcte = true;
                        } else {
                            System.out.println(MSG_7);
                        }
                    } while (!correcte);

                    /*Aqui registrem els valors amb string buffer nombrat a clase és un mètode
                    que s'utilitza per escriure cadenes de caràcters a una cadena ja existent.*/
                    System.out.print("\nIntrodueix el codi: ");
                    codi = sc.next();
                    sb.append(codi + ",");
                    System.out.print("Introdueix el nombre: ");
                    nombre = sc.next();
                    sb.append(nombre + ",");
                    System.out.print("Introdueix el tipus: ");
                    tipus = sc.next();
                    sb.append(tipus + ",");
                    System.out.print("Introdueix la quantitat: ");
                    quantitat = sc.next();
                    sb.append(quantitat + ",");
                    System.out.print("Introdueix el preu: ");
                    preu = sc.next();
                    sb.append(preu);
                    met.escriure(sb.toString(), fitxer);
                    sb.setLength(0);  //Aquí netegem el buffer del sb.
                    break;
                case 'C':
                    System.out.print(MSG_5);
                    fitxer = sc.next();
                    fitxer = met.extensio(fitxer);
                    registres = met.totalArticles(fitxer);
                    if (registres > 0) {         //Si el contador de registres es inferior a 0 no hi ha registres.
                        System.out.println("Total de registres: " + registres);
                    } else {
                        System.out.println("No hi a registres per mostrar.");
                    }
                    break;
                case 'D':
                    System.out.println(COLOR + MSG_3 + COLOR);
                    System.out.println(COLOR + MSG_FINAL + COLOR);
                    exit = true;
                    break;
                default:
                    System.out.println(MSG_2);
                    break;
            }
        } while (!exit);
    }
}
