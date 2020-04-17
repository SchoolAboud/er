import java.util.*;
import java.io.*;

public class FamilyTree {

public static void main(String[] args) throws FileNotFoundException {
   //Initially we will create our two lists.
   //First lists will be the list of names of different people having a family tree
   //Second list will contain each of these people's names followed by their mother's and their father's name respectively
   //That is the list that will be then used to solve the project
   
   ArrayList<String> Names = new ArrayList<String>();
   ArrayList<String> FamTree = new ArrayList<String>();
   
   //First we will introduce the source of the file we will scan from
   File source = new File("C:\\Users\\Majd\\Desktop\\Bellevue College\\5th Spring Quarter 2020\\CS 211\\Project#1\\tudor.dat");
   
   //Now we will create the scanner that will scan from that specific file.
   Scanner fileReader = new Scanner(source);
   fileReader.useDelimiter(",");
   int c = 0;
   String s = "";
   
   while (fileReader.hasNextLine()) {
          s = fileReader.nextLine();
          
          if (c!=1) 
          {
            Names.add(s);
                if (s.equalsIgnoreCase("end")) 
                {
                c=1;
                Names.remove(s);
                }
           }
            else {
            
            FamTree.add(s);
            if (s.equalsIgnoreCase("end")) {
               FamTree.remove(s);
               }  
            }
          }
          
         Person p = new Person(FamTree); //This class will create three array lists in which each element corresponding to any list will have the same index of another related element in other lists, whether
                                         //it is Mother or Father.

         System.out.println("The following list provides you with different names to choose from in order to give you a short family tree:\n"
         + p.getChildren() + "\nWrite 0 when done\nPlease pick a name:\n");
         
         Scanner con = new Scanner(System.in);
  
         while (con.hasNextLine()) {
            String n = con.nextLine();
            while (!p.getChildren().contains(n) && !n.equals("0")) {
               System.out.println("The entry provided does not have any records. Please make sure it is present in the list provided and is written properly or enter 0 to end the program");
               n = con.nextLine();
               }  
        if (n.equals("0")) {
        System.out.println("Thank you!");
        break;
         } 
         int z = p.getChildren().indexOf(n); //Denoting the index corresponding to the name n.
         int x1,x2 = 0;
         int y1,y2 = 0;
         ArrayList<String> ChildAllocation = new ArrayList<String>();
         
            if (p.getMothers().contains(n)) {
                x1 = p.getMothers().indexOf(n); //Index of the first occurence of the provided name in the mother list
                x2 = p.getMothers().lastIndexOf(n); //Index of the last occurence of the provided name in the mother list
                System.out.println("Person's name? "+n+"\nMaternal line:\n\t"+ n + "\n\t\t" + p.getMothers().get(z) +"\nPaternal line:\n\t"+n+ "\n\t\t" + p.getFathers().get(z)+"\n"
                  +"Children:");
                      for (int i=x1 ; i<=x2 ; i++) {
                              System.out.println("\t"+p.getChildren().get(i));
                                         }

                 System.out.println("\nHere is the list to keep track of available names: \n"+p.getChildren()); 
               }
                   else
         
                     if (p.getFathers().contains(n)) {
                        y1 = p.getFathers().indexOf(n); //Index of the first occurence of the provided name in the Father list
                        y2 = p.getFathers().lastIndexOf(n); //Index of the last occurence of the provided name in the Father list
                        System.out.println("Person's name? "+n+"\nMaternal line:\n\t"+ n + "\n\t\t" + p.getMothers().get(z) +"\nPaternal line:\n\t"+n+ "\n\t\t" + p.getFathers().get(z)+"\n"
                        +"Children:");
                           for (int i=y1 ; i<=y2 ; i++) {
                              System.out.println("\t"+p.getChildren().get(i));
                                       }
                       System.out.println("\nHere is the list to keep track of available names: \n"+p.getChildren()); 
                      }
                           else
                              System.out.println("Person's name? "+n+"\nMaternal line:\n\t"+ n + "\n\t\t" + p.getMothers().get(z) +"\nPaternal line:\n\t"+n+ "\n\t\t" + p.getFathers().get(z)+
                              "\n"+"Children:\n\tNo Children."+"\nHere is the list to keep track of available names: \n"+p.getChildren());
         }

      } 
}

