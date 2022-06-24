package com.company;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("List status : " + (liste.isEmpty() ? "Empty" : "Full"));
        System.out.println("Number of Elements in Array : " + liste.size());
        System.out.println("Array Capacity : " + liste.getCapacity() + "\n");

        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        liste.add(20);
        liste.add(50);
        liste.add(60);
        liste.add(70);

        System.out.println("List status : " + (liste.isEmpty() ? "Empty" : "Full"));
        System.out.println("Number of Elements in Array : " + liste.size());
        System.out.println("Array Capacity : " + liste.getCapacity());

        // Returns the first index of the value found
        System.out.println("Index : " + liste.indexOf(20));

        // Returns -1 if not found
        System.out.println("Index :" + liste.indexOf(100));

        // Returns the last index of the value found
        System.out.println("Index : " + liste.lastIndexOf(20));

        // Returns the list as an Object[] array.
        Object[] dizi = liste.toArray();
        System.out.println("First element of Object array : " + dizi[0]);

        //Returns the value in the given index
        System.out.println("Value at index 0 : " + liste.get(0));

        //Delete data in given index
        liste.remove(4);

        //Replaces the value in the given index with the new one
        liste.set(3, 35);
        System.out.println(liste.toString());

        // Create a sublist of list data type
        MyList<Integer> altListem = liste.subList(0, 3);
        System.out.println(altListem.toString());

        // Queries my value is in the list
        System.out.println("Value 20 in my list: " + liste.contains(20));
        System.out.println("Value 120 in my list : " + liste.contains(120));

        // Clears the list completely and reverts it to its default size
        liste.clear();
        System.out.println(liste.toString());

    }
}
