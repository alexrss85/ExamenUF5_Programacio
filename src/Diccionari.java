import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Diccionari {

    private HashMap<String, String> diccionari;
    private int nParaules;

    public Diccionari(Scanner sc) throws FileNotFoundException {
        diccionari= new HashMap<>();
        nParaules=sc.nextInt();
        sc.nextLine();
        for (int i=0;i<nParaules;i++) {
            diccionari.put(sc.nextLine(), sc.nextLine());
        }

    }

    public boolean teParaula(String paraula){ return diccionari.containsKey(paraula);}

    public String sortida(String paraula){ return diccionari.get(paraula);}

    public int getnParaules() {
        return nParaules;
    }

    public HashMap<String, String> getDiccionari() {
        return diccionari;
    }

    @Override
    public String toString() {
        return "Diccionari{" +
                "diccionari=" + diccionari +
                '}';
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc= new Scanner(new File("paraulogicText1.txt"));
        Lletres lletres = new Lletres(sc);
        Diccionari d= new Diccionari(sc);
        //TE PARAULA?
        System.out.println("Té la paraula aloina? : "+d.teParaula("aloina"));
        //SORTIDA PARAULA
        System.out.println("La sortida de aloina és: "+d.sortida("aloina"));



    }
}
