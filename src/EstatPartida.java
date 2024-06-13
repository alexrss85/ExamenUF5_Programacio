import java.util.Iterator;
import java.util.TreeSet;

public class EstatPartida {

    private int nEncertades;
    private TreeSet<String> paraulesEncertades= new TreeSet<>();
    private int nTutis;
    private int nPunts;

    public void encertada(String paraula, Boolean esTuti, int punts){
        paraulesEncertades.add(paraula);
        if (esTuti){
            nTutis++;
        }
        nPunts+=punts;
        nEncertades++;
    }

    public boolean teParaula(String paraula){
        return paraulesEncertades.contains(paraula);
    }

    @Override
    public String toString() {
        return "EstatPartida{" +
                "paraulesEncertades=" + paraulesEncertades +
                '}';
    }



    public void mostrarResultats(Diccionari diccionari) {
        System.out.format("Has trobat %d paraules (%d tutis): ", nEncertades, nTutis);
        Iterator<String> it = paraulesEncertades.iterator();
        for (int i = 0; i < nEncertades - 1; i++) {
            System.out.print(diccionari.sortida(it.next()) + ", ");
        }
        if (nEncertades > 0) {
            System.out.println(diccionari.sortida(it.next()) + ".");
        }
        System.out.println("Puntuació: " + nPunts);
    }






}
