/*CS 211(B)
Spring 2020
4/20/2020
Majd Chalak, Abdalrahman Shaath, Joey Helf, Richard Le
This file is used to create a class that constructs a family tree with father, mother, and children.
*/
import java.util.*;

public class Person {

   private ArrayList<String> person;


//This constructor will take a family tree constructed array list.
   public Person (ArrayList<String> p) {

      this.person = p;

   }

//This list will contain all mothers' names with recurrences. The index of that list will be the same index of the getChildren() function created list.
//Hence that will allow us to pair the child with their mother accordingly.
   public ArrayList<String> getMothers() {
   
      ArrayList<String> mothers = new ArrayList<String>();
      for (int i=1 ; i<person.size() ; i=i+3) {
         
         mothers.add(person.get(i));     
         
      }
      return mothers;
  }


//This list will contain all fathers' names with recurrences. The index of that list will be the same index of the getChildren() function created list.
//Hence that will allow us to pair the child with their father accordingly.
   public ArrayList<String> getFathers() {
   
      ArrayList<String> fathers = new ArrayList<String>();
      for (int i=2 ; i<person.size() ; i=i+3) {
         
         fathers.add(person.get(i));

      }
      return fathers;
  }

//The following function will filter names. It will create an array list of only the names that have parents.
//The user will then be asked to pick a name from that list.
   public ArrayList<String> getChildren() {
   
      ArrayList<String> children = new ArrayList<String>();
      for (int i=0 ; i<person.size() ; i=i+3) {
         
         children.add(person.get(i));

      }
      return children;
  }

}



