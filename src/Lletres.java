import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lletres {

    private ArrayList<Character> lletres;
    private int nLletres;
    private char lletraMig;


    public Lletres(Scanner sc) {
        lletres= new ArrayList<>();
        nLletres= sc.nextInt();
        sc.nextLine();
        for (int i=0;i<nLletres-1;i++){
            lletres.add(sc.nextLine().charAt(0));
        }
        lletraMig= sc.nextLine().charAt(0);
    }

    public void reordena(){ Collections.shuffle(lletres); }

    public ArrayList<Character> getLletres() {
        return lletres;
    }

    public int getnLletres() {
        return nLletres;
    }

    public char getLletraMig() {
        return lletraMig;
    }

    @Override
    public String toString() {
        return "Lletres{" +
                "lletres=" + lletres +
                '}';
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("paraulogicText1.txt"));
        Lletres lletres= new Lletres(sc);
        //LLETRES
        System.out.println("LLETRES: ");
        System.out.println(lletres);
        //LLETRA MIG
        System.out.println("LLETRA DEL MIG: ");
        System.out.println(lletres.getLletraMig());
        //N LLETRES
        System.out.println("Numero de LLETRES: ");
        System.out.println(lletres.getnLletres());

        //REORDENA
        System.out.println("REORDENAT");
        lletres.reordena();
        System.out.println(lletres);
    }
}
