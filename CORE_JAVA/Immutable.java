//************* How to Create an Immutable Class *************
/*
declare the class as final so it cannot be extended
all class members should be private so they cannot be accessed outside of class
shouldn't contain any setter methods to change the value of class members
the getter method should return the copy of class members
class members are only initialized using constructor

*/

// class is declared final
final class Immutable {

  // private class members
  private String name;
  private int date;

  Immutable(String name, int date) {

    // class members are initialized using constructor
    this.name = name;
    this.date = date;
  }

  // getter method returns the copy of class members
  public String getName() {
    return name;
  }

  public int getDate() {
    return date;
  }

}

class Main {
  public static void main(String[] args) {

    // create object of Immutable
    Immutable obj = new Immutable("Programiz", 2011);

    System.out.println("Name: " + obj.getName());
    System.out.println("Date: " + obj.getDate());
  }
}