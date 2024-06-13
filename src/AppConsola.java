import java.io.FileNotFoundException;
import java.util.Scanner;


public class AppConsola {
    private static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {


        Paraulogic paraulogic = new Paraulogic("paraulogicText1.txt");
        paraulogic.mostrarLletres();

        //paraulogic.mostrarDiccionari(); //veure paraules


        String paraula = entrada.nextLine();
        while(!paraula.isEmpty()){
            if (paraula.equals("*")){ // "*" per reordenar
                paraulogic.reordenaLletres();
            } else {
                System.out.println(paraulogic.jugarParaula(paraula));
                paraulogic.mostrarResultats();
                //paraulogic.mostrarEstatPartida(); //veure estatPartida
            }
            paraulogic.mostrarLletres();
            paraula = entrada.nextLine();
        }
    }
}
