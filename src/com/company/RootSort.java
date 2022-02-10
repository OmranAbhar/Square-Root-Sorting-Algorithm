package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Mir Omranudin Abhar
 */
public class RootSort {

    /**
     * @param args the command line arguments
     */
    public static final String RED = "\u001B[41m";
    public static final String BLACK = "\u001B[47m";
    public static final String BGREEN = "\u001B[42m";
    static int com = 0;
    static int swapp = 0;

    public static void root() {
        // TODO code application logic here
        int size = 20;
        int array[] = new int[size];
        RootSort obj = new RootSort();

//      base,worst, average
        obj.setArray(array, size, "averge");

//  Getting the size of list and getting the Sqaure root
        int i = array.length;
        int item = (int) Math.ceil(Math.sqrt(i));
        int part = (int) Math.ceil((i / item)) + 1;

//  Create the object of class for accessing the method of the class
// Show the list before sorted.
        System.out.print("\nList before sort: ");
        obj.printList(array, item);
//  This method used for sorting every part of list
        obj.sortAllRow(array, part, item);
//  This method used for comparing.
        obj.compaireTwoPart(array, part, item);
//  This loop used for showing the sorted list.

        System.out.print("\nList after sort: ");
        obj.printList(array, item);

        System.out.println("Total Comparing : " + com);
        System.out.println("Total Swapping : " + swapp);
    }

    //  This methtod used for comparing.
    public void compaireTwoPart(int array2D[], int part, int item) {
        int max = 0, min = 0, vc = 0, vr = 0, i = 1, last = 0;
        for (int row = 0; row < array2D.length; row += item) {
            last = row;
            for (int col = row; col < ((col >= array2D.length) ? array2D.length - 1 : row + item); col++) {
                for (int rowV = row + item; rowV < array2D.length; rowV += item) {
                    for (int colV = rowV; colV < ((colV >= array2D.length) ? array2D.length - 1 : rowV + item); colV++) {
                        vc = colV;
                        vr = colV;
                        com++;
                        if (array2D[col] > array2D[colV]) {
                            swapp++;
                            for (int rowVJ = row + item + item; rowVJ < array2D.length; rowVJ += item) {
                                for (int colVJ = rowVJ; colVJ < ((colVJ >= array2D.length) ? array2D.length - 1 : rowVJ + item); colVJ++) {
                                    com++;
                                    if (array2D[vc] > array2D[colVJ]) {
                                        vc = colVJ;
                                        vr = colVJ;
                                    }
                                    break;
                                }
                            }
                            max = array2D[col];
                            min = array2D[vc];
                            i++;
                            int ll = 1;
                            System.out.println("");
                            System.out.println("");
                            for (int j = 0; j < array2D.length; j++) {
                                if (j == item * i) {
                                    i++;
                                }
                                if (j == col) {
                                    System.out.print(RED + " " + array2D[j] + " " + BLACK);
                                } else if (j == vc) {
                                    System.out.print(BGREEN + " " + array2D[j] + " " + BLACK);
                                } else {
                                    System.out.print(" " + array2D[j] + " ");
                                }
                                if (ll * item == j + 1) {
                                    System.out.print("\u001B[43m" + "|" + BLACK);
                                    ll++;
                                }
                            }
                            array2D[vc] = max;
                            array2D[col] = min;
                            Arrays.sort(array2D, vr, ((vr + item > array2D.length) ? array2D.length : vr + item));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void printList(int array[], int item) {
        int i = 1;
        System.out.println("\n");
        for (int j = 0; j < array.length; j++) {
            if (j == item * i) {
                i++;

                System.out.print("\u001B[43m" + "|" + BLACK);
            }
            System.out.print(BLACK + " " + array[j] + " ");
        }
        System.out.println("");
    }

    //  This method used for sorting every part of list
    public void sortAllRow(int array2D[], int part, int item) {
        int i = 1;
        int cc = 0;
        for (int row = 0; row <= part; row++) {
            if (item * i >= array2D.length) {
                if ((item * i) - item < array2D.length) {
                    cc = array2D.length;
                } else {
                    break;
                }
            } else {
                cc = item * i;
            }
            Arrays.sort(array2D, item * row, (cc));
            i++;
        }
    }
//  This method used for sorting every part of list

    public void setArray(int array[], int size, String Case) {

        Random rand = new Random();
        if (Case.equals("best")) {
//        Base Case
            for (int set = 0; set < size; set++) {
                array[set] = set;
            }
        } else if (Case.equals("worst")) {
//        Worst Case
            for (int set = 0; set < size; set++) {
                array[set] = size - set;
            }
        } else {
//        Random Case
            for (int set = size - 1; set >= 0; set--) {
                array[set] = rand.nextInt(10);
            }
        }
    }
}
