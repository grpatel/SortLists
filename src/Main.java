import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void BubbleSort(ArrayList<Iris> a, int size) {
        for (int x = 0; x < size-1; x++) // bubble sort outer loop
        {
            for (int i = 0; i < size -x-1; i++) {
                if (a.get(i + 1).isLessThan(a.get(i))) {
                    Iris temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                }
            }
        }
    }


    public static void mergeSort(ArrayList<Iris> a, ArrayList<Iris> tmp, int left, int right) {
        int middle = (left + right) / 2;
        if (left < right) {
            mergeSort(a, tmp, left, middle); //sort left half
            mergeSort(a, tmp, middle + 1, right); //sort right half
            mergeSortedLists(a, tmp, left, middle, right);
        } // merge
    }

    public static void mergeSortedLists(ArrayList<Iris> a, ArrayList<Iris> tmp, int left, int middle, int right) {
        tmp = new ArrayList<Iris>();
        int tempLeft = left;
        int tempRight = middle + 1;
        while (tempLeft <= middle && tempRight <= right)
            if (a.get(tempLeft).isLessThan(a.get(tempRight))) {
                {
                    tmp.add(a.get(tempLeft));
                }
                tempLeft++;
            } else {
                {
                    tmp.add(a.get(tempRight));
                }
                tempRight++;
            }

        while (tempLeft <= middle) {
            {
                tmp.add(a.get(tempLeft));
            }
            tempLeft++;
        }

        while (tempRight <= right) {
            {
                tmp.add(a.get(tempRight));
            }
            tempRight++;
        }
        int i = left;
        {
            for (Iris value : tmp) {
                a.set(i, value);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream("src/fish-iris.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Sorry file doesn't exist. Please enter the correct name: ");
            System.exit(1);
        }

        ArrayList<Iris> tmp = new ArrayList<Iris>();   // temporary workspace
        ArrayList<Iris> list = new ArrayList<Iris>();// list to be sorted
        Scanner sc = new Scanner(myFile);
        sc.nextLine();
        sc.useDelimiter(",");
        while (sc.hasNextLine()) {
            Iris k = new Iris();
            k.setSepal_Length(sc.nextDouble());
            //reading the second info up to the third comma
            k.setSepal_width(sc.nextDouble());
            //reading the third info up to the third comma
            k.setPetal_Length(sc.nextDouble());
            //reading the fourth info up to the fourth comma
            k.setPetal_width(sc.nextDouble());
            //reading the fifth info up to the fifth comma
            k.setSpecies(sc.nextLine());
            list.add(k);
//            for(int i = 0; i<list.size();i++){
//                System.out.println(list.get(i));
//            }
        }
        sc.close();

//        sort list using mergesort
        mergeSort(list, tmp, 0, list.size()-1);
        for(int i = 0; i<list.size();i++) {
            System.out.println(list.get(i));
        }

//        Create a copy from list for Bubble sort
        ArrayList<Iris> list2 = new ArrayList<Iris>();
        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(i));
        }

//        sort list2 using Bubble sort
        BubbleSort(list2, list2.size());
        for(int i = 0; i<list2.size(); i++){
            System.out.println(list2.get(i));
        }

        PrintWriter writer;
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("Output.txt", true);
        } catch (FileNotFoundException e) {
            System.out.println("Output file not found");
        }
        writer = new PrintWriter(file);
        ArrayList <Iris> t = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            t.add(list.get(i));
        }
        Random rand = new Random();
        for (int i = 0; i < 100000; i++){
            t.add(t.get(rand.nextInt(t.size())));
        }

        for (int k = 1000; k < t.size(); k+=10000) {
            ArrayList<Iris> list3 = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                list3.add(t.get(j));
            }
            long startTime = System.currentTimeMillis();
            mergeSort(list3, tmp, 0, list3.size() - 1);
            long endTime = System.currentTimeMillis();
            //print runtime in milliseconds
            writer.write("Execution time for mergeSort of size " + k + " is: " + (endTime - startTime) + "\n");

            long startTime2 = System.currentTimeMillis();
            BubbleSort(list3, list3.size() - 1);
            long endTime2 = System.currentTimeMillis();
            writer.write("Execution time for bubbleSort of size " + k + " is: " + (endTime2 - startTime2) + "\n");
        }
        writer.close();



    }}
