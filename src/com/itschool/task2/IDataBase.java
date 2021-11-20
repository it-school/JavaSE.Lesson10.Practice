package com.itschool.task2;

public interface IDataBase {
   boolean add(String name, String login, String password);

   void delete(int id);

   void delete(String login);

   void pack();

   String toString();

   IDataBase search(String searchText);
}
