import java.util.*;

public class parents {

private ArrayList<String> parents;


//This constructor will take a family tree constructed array list.
public parents (ArrayList<String> p) {

this.parents = p;

}

//This list will contain all mothers' names with recurrences. The index of that list will be the same index of the getChildren() function created list.
//Hence that will allow us to pair the child with their mother accordingly.
public ArrayList<String> getMothers() {
   
   ArrayList<String> Mothers = new ArrayList<String>();
   for (int i=1 ; i<parents.size() ; i=i+3) {
         
         Mothers.add(parents.get(i));
     
         
   }
    return Mothers;
}


//This list will contain all fathers' names with recurrences. The index of that list will be the same index of the getChildren() function created list.
//Hence that will allow us to pair the child with their father accordingly.
public ArrayList<String> getFathers() {
   
   ArrayList<String> Fathers = new ArrayList<String>();
   for (int i=2 ; i<parents.size() ; i=i+3) {
         
         Fathers.add(parents.get(i));

   }
    return Fathers;
}

//The following function will filter names. It will create an array list of only the names that have parents.
//The user will then be asked to pick a name from that list.
public ArrayList<String> getChildren() {
   
   ArrayList<String> Children = new ArrayList<String>();
   for (int i=0 ; i<parents.size() ; i=i+3) {
         
         Children.add(parents.get(i));

   }
    return Children;
}


}








