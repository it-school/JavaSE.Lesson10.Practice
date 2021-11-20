package com.itschool;

import com.itschool.task1.Collection;
import com.itschool.task2.DataBase;

import java.util.Arrays;

public class Main {
   public static void main(String[] args) {
      task1();
      task2();
   }

   /**
    * Задание1: написать класс (реализовать аналог коллекции), который будет содержать в себе массив целочисленных значений и набор методов для работы с этим массивом
    */
   private static void task1() {
      System.out.println("\n--------------------------------------------\n");
      Collection collection1 = new Collection();
      System.out.println("Initial state of collection: " + collection1);

      collection1.add(555);
      collection1.add(555);
      collection1.add(333);
      collection1.add(555);
      collection1.add(555);
      System.out.println("Collection after adding elements: " + collection1);

      collection1.addAt(777, 20);
      System.out.println("After inserting the value at specific position (by index): " + collection1);

      collection1.removeAt(2);
      System.out.println("After deleting an element: " + collection1);

      System.out.println("Getting copy of part of collection: " + Arrays.toString(collection1.getCopy(1, 2)));

      System.out.println("Getting collection element at specific position (by index): " + collection1.getElementAt(4));

      collection1.addAt(333, 3);
      System.out.println("Collection after adding value at specific position (by index): " + collection1);

      System.out.println("Find of the first position in collection of the value '555': " + collection1.findFirst(555));
      System.out.println("Find of the last position in collection of the value '555': " + collection1.findLast(555));
      System.out.println("Find of the last position in collection of the value '444': " + collection1.findLast(444));

      Collection collection2 = new Collection();
      collection2.add(555);
      collection2.add(556);
      collection2.add(555);
      collection2.add(333);
      collection2.add(555);
      collection2.add(777);

      System.out.println("First collection: " + collection1);
      System.out.println("Second collection (dfferent object, the same values): " + collection2);
      System.out.println("Self compare: " + collection1.equals(collection1));
      System.out.println("Compare of two collections: " + collection1.equals(collection2));
   }

   /**
    * Задание 2: Реализовать класс, представляющий собой объектно-ориентированную базу данных пользователей.
    * Все элементы БД будут проиндексированы (первый индекс: ID = 1).
    * Количество элементов БД должно быть гибким (допускается уменьшение и увеличение), при этом индекс уменьшаться не должен
    */
   private static void task2() {
      System.out.println("\n--------------------------------------------\n");
      DataBase dataBase = new DataBase();
      System.out.println("New database:\n" + dataBase);

      dataBase.add("User 1", "user1", "Password123");
      dataBase.add("User 2", "user2", "Password123");
      dataBase.add("User 3", "user3", "Password123");
      System.out.println("Database after adding 3 users:\n" + dataBase);

      dataBase.delete(2);
      dataBase.delete("user3");
      System.out.println("Database after marking 2 users for deletion:\n" + dataBase);

      dataBase.pack();
      System.out.println("Database after packing (real deletion of marked users):\n" + dataBase);

      dataBase.add("Admin", "admin", "Password123456");
      dataBase.add("Admin", "admin2", "Password123456");
      System.out.println("Database after adding 2 new users:\n" + dataBase);

      System.out.println("Search result (all containing 'admin' in login or name):\n" + dataBase.search("admin"));

      System.out.println("Search result (all containing 'super' in login or name):\n" + dataBase.search("SUPER"));
   }
}