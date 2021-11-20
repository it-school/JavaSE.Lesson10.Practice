package com.itschool;

import com.itschool.task1.Collection;

import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
      Collection collection1 = new Collection();
      System.out.println(collection1);

      collection1.add(555);
      collection1.add(555);
      collection1.add(333);
      collection1.add(555);
      collection1.add(555);
      System.out.println(collection1);

      collection1.addAt(777, 20);
      System.out.println(collection1);

      collection1.removeAt(2);
      System.out.println(collection1);

      System.out.println(Arrays.toString(collection1.getCopy(2,2 )));

      System.out.println(collection1.getElementAt(4));

      collection1.addAt(333, 3);
      System.out.println(collection1);
      System.out.println(collection1.findFirst(555));
      System.out.println(collection1.findLast(555));
      System.out.println(collection1.findLast(444));

      Collection collection2 = new Collection();
      collection2.add(555);
      collection2.add(556);
      collection2.add(555);
      collection2.add(333);
      collection2.add(555);
      collection2.add(777);

      System.out.println(collection1);
      System.out.println(collection2);
      System.out.println(collection1.equals(collection1));
      System.out.println(collection1.equals(collection2));
   }
}
