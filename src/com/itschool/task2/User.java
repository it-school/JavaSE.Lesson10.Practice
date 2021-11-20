package com.itschool.task2;

import java.util.Objects;

public class User {
   private final int id;
   private String login;
   private String password;
   private String name;
   private boolean isDeleted;

   public User(int id, String login, String password, String name) {
      this.id = id;
      this.setLogin(login);
      this.setPassword(password);
      this.setName(name);
      this.isDeleted = false;
   }

   public int getId() {
      return id;
   }

   public String getLogin() {
      return login;
   }

   private void setLogin(String login) {
      this.login = login.strip();
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name.strip();
   }

   public boolean isDeleted() {
      return isDeleted;
   }

   public void setDeleted(boolean deleted) {
      isDeleted = deleted;
   }

   @Override
   public String toString() {
      return "{" + "id: " + id +
              ", login: '" + login + '\'' +
              ", password: '" + password + '\'' +
              ", name: '" + name + '\''
              + (isDeleted ? ", marked for delete" : "") +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass())
         return false;
      User user = (User) o;
      return Objects.equals(getLogin().toLowerCase(), user.getLogin().toLowerCase());
   }
}