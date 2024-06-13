import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Paraulogic {
    private Lletres lletres; //TODO 1
    private Diccionari diccionari; //TODO 2
    private EstatPartida estatPartida; //TODO 3

    public Paraulogic(String nomFitxer) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(nomFitxer));




        lletres = new Lletres(sc);
        diccionari = new Diccionari(sc);
        estatPartida = new EstatPartida();




        sc.close();
    }

    public String jugarParaula(String paraula) {
        int punts = 0;
        boolean esTuti = false;
        String missatge;

        if (esMassaCurta(paraula)) {
            missatge = "Massa curt";
        } else if (faltaLletraDelMig(paraula)) {
            missatge = "Falta la lletra de mig";
        } else if (jaHiEs(paraula)) {
            missatge = "Ja hi és";
        } else if (!esDelDiccionari(paraula)) {
            missatge = "No existeix";
        } else {
            punts = puntuaParaula(paraula);
            if (punts <= 2) {
                missatge = "Bé! + " + punts;
            } else {
                esTuti = esTuti(paraula);
                if (esTuti) {
                    punts += 10;
                    missatge = "Tuti! + " + punts;
                } else {
                    missatge = "Molt bé! + " + punts;
                }
            }
            estatPartida.encertada(paraula, esTuti, punts);
        }
        return missatge;
    }

    private boolean esDelDiccionari(String paraula) {
        return diccionari.teParaula(paraula);
    }

    private boolean jaHiEs(String paraula) {
        return estatPartida.teParaula(paraula);
    }

    private boolean faltaLletraDelMig(String paraula) {
        return (paraula.indexOf(lletres.getLletraMig())==-1);
    }

    private boolean esMassaCurta(String paraula){
        return (paraula.length()<3);
    }

    public static int puntuaParaula(String paraula){
        int mida = paraula.length();
        if (mida <=4){
            return mida - 2;
        }
        return mida;
    }


    public boolean esTuti(String paraula){
        HashSet<Character> lletresDif= new HashSet<>();
        for (int i=0;i<paraula.length();i++){
            lletresDif.add(paraula.charAt(i));
        }
        return lletresDif.size()==lletres.getnLletres();
    }

    public void mostrarResultats() {
        estatPartida.mostrarResultats(diccionari);
    }

    public void mostrarLletres() {
        System.out.println(lletres);
    }
    public void mostrarDiccionari() {
        System.out.println(diccionari);
    }

    public void mostrarEstatPartida() {
        System.out.println(estatPartida);
    }

    public void reordenaLletres() {
        lletres.reordena();
    }
}

