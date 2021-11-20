package com.itschool.task2;

import java.util.Arrays;

public class DataBase implements IDataBase {
   User[] users;
   int lastId;

   public DataBase() {
      lastId = 0;
      users = new User[lastId];
   }

   public int getLastId() {
      return lastId;
   }

   @Override
   public boolean add(String name, String login, String password) {
      if (users.length != 0) {
         for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login.toLowerCase()))
               return false;
         }
      }
      users = Arrays.copyOf(users, users.length + 1);
      users[users.length - 1] = new User(++lastId, login, password, name);

      return true;
   }

   @Override
   public void delete(int id) {
      for (int i = 0; i < users.length; i++) {
         if (users[i].getId() == id) {
            users[i].setDeleted(true);
            return;
         }
      }
   }

   @Override
   public void delete(String login) {
      for (int i = 0; i < users.length; i++) {
         if (users[i].getLogin().equalsIgnoreCase(login.toLowerCase())) {
            users[i].setDeleted(true);
            return;
         }
      }
   }

   private void deleteUser(int index) {
      if (index >= users.length)
         return;
      else {
         for (int i = index; i < users.length - 1; i++) {
            users[i] = users[i + 1];
         }
         users = Arrays.copyOf(users, users.length - 1);
      }
   }

   @Override
   public void pack() {
      for (int i = 0; i < users.length; i++) {
         if (users[i].isDeleted())
            deleteUser(i--);
      }
   }

   @Override
   public IDataBase search(String searchText) {
      DataBase tempDB = new DataBase();

      for (User user : users) {
         if (user.getLogin().equalsIgnoreCase(searchText.toLowerCase()) || user.getName().toLowerCase().contains(searchText.toLowerCase()))
            tempDB.add(user.getName(), user.getLogin(), user.getPassword());
      }

      return tempDB;
   }

   @Override
   public String toString() {
      String result = "DataBase:" + System.lineSeparator();

      if (users.length == 0) {
         result += " is empty" + System.lineSeparator();
      } else {
         for (User user : users) {
            result += "\t" + user + System.lineSeparator();
         }
      }
      return result + "lastId: " + lastId + System.lineSeparator();
   }
}