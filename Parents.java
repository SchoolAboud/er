/*CS 211(B)
Spring 2020
4/20/2020
Majd Chalak, Abdalrahman Shaath, Joey Helf, Richard Le
This file is used to create a family tree with father, mother, and children.
*/

import java.util.*;

public class Parents {

private ArrayList<String> parents;


//This constructor will take a family tree constructed array list.
public Parents (ArrayList<String> p) {

this.parents = p;

}

//This list will contain all mothers' names with recurrences. The index of that list will be the same index of the getChildren() function created list.
//Hence that will allow us to pair the child with their mother accordingly.
public ArrayList<String> getMothers() {
   
   ArrayList<String> mothers = new ArrayList<String>();
   for (int i=1 ; i<parents.size() ; i=i+3) {
         
         mothers.add(parents.get(i));
     
         
   }
    return mothers;
}


//This list will contain all fathers' names with recurrences. The index of that list will be the same index of the getChildren() function created list.
//Hence that will allow us to pair the child with their father accordingly.
public ArrayList<String> getFathers() {
   
   ArrayList<String> fathers = new ArrayList<String>();
   for (int i=2 ; i<parents.size() ; i=i+3) {
         
         fathers.add(parents.get(i));

   }
    return fathers;
}

//The following function will filter names. It will create an array list of only the names that have parents.
//The user will then be asked to pick a name from that list.
public ArrayList<String> getChildren() {
   
   ArrayList<String> children = new ArrayList<String>();
   for (int i=0 ; i<parents.size() ; i=i+3) {
         
         children.add(parents.get(i));

   }
    return children;
}


}








