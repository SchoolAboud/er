/*CS 211(B)
Spring 2020
4/20/2020
Majd Chalak, Abdalrahman Shaath, Joey Helf, Richard Le
This file was made to create a program that takes a file of names, prompts for user input, and outputs a family tree.
*/
import java.util.*;
import java.io.*;

public class FamilyTree {

   public static void main(String[] args) throws FileNotFoundException {
   //Initially we will create our two lists.
   //First lists will be the list of names of different people having a family tree
   //Second list will contain each of these people's names followed by their mother's and their father's name respectively
   //That is the list that will be then used to solve the project
   
      ArrayList<String> names = new ArrayList<String>();
      ArrayList<String> famTree = new ArrayList<String>();
   
   //First we will introduce the source of the file we will scan from
      File source = new File("tudor.dat");
   
   //Now we will create the scanner that will scan from that specific file.
      Scanner fileReader = new Scanner(source);
      fileReader.useDelimiter(",");
      int c = 0; //This integer will be used later as "END" word checker.
      String s = "";
   
   //The following while loop will store the two lists provided in two separate lists, each list ending at the word "END" while excluding it
      while (fileReader.hasNextLine()) {
         s = fileReader.nextLine();
          
         if (c!=1) {
            names.add(s);
            if (s.equalsIgnoreCase("end")) {//When the scanner spots "END", c will be equal to 1
               c=1;
               names.remove(s); //We will remove the "End" word from the list
            }
            
         } else {
            famTree.add(s);//We will start scanning the second list
            if (s.equalsIgnoreCase("end")) {
               famTree.remove(s);
            }  
         }
      }
          
      Person p = new Person(famTree); /*This class will create three array lists in which each element corresponding to 
                                         any list will have the same index of another related element in other lists, 
                                         whether it is Mother or Father. For example, a mother's name in the mother's list will have index i,
                                         that index i will be the same for her child. If she has more than one child, 
                                         her name will re-occur in the mother's list and each occurence will correspond to her child. Same goes to the fathers' names.*/ 

      System.out.println("The following list provides you with different names to choose from in order to give you a short family tree:\n"
         + p.getChildren() + "\nWrite 0 when done\nPlease pick a name:\n");
         
      Scanner con = new Scanner(System.in);
  
      while (con.hasNextLine()) {
         String n = con.nextLine();
         while (!p.getChildren().contains(n) && !n.equals("0")) { //While the entry provided by the user is not a name which paternal and maternal lines are available
                                                                     //And while the entry is not 0, a prompt will ask the user to re-enter another name or exit the program
            System.out.println("The entry provided does not have any records. Please make sure it is present in the list provided and is written properly or enter 0 to end the program");
            n = con.nextLine();
         }  
         
         if (n.equals("0")) { //If the user enters 0, the code will end
         System.out.println("Thank you!");
         break;
         } 
         
         int z = p.getChildren().indexOf(n); //Denoting the index corresponding to the name n.

         ArrayList<String> childAllocation = new ArrayList<String>();
         
            //We will conduct two if statements, in which we will check if the provided name got listed as mother or father in the "Person" class created
            
         
         if (p.getMothers().contains(n)) { //In case the name provided is a mother
            System.out.println("Person's name? "+n+"\nMaternal line:\n\t"+ n + "\n\t\t" + p.getMothers().get(z) +"\nPaternal line:\n\t"+n+ "\n\t\t" + p.getFathers().get(z)+"\n"
               +"Children:");
            for(int i=0 ; i<p.getMothers().size() ; i++) //A for loop checking each index of the mother's name then printing the corresponding child name bearing that index
               if(p.getMothers().get(i).equals(n)) {     
                  System.out.println("\t"+p.getChildren().get(i));
               }
            System.out.println("\nHere is the list to keep track of available names: \n"+p.getChildren()); //Providing the user with the list of available names to check family tree
            
            
         } else if (p.getFathers().contains(n)) { //In case the provided name is a father
            System.out.println("Person's name? "+n+"\nMaternal line:\n\t"+ n + "\n\t\t" + p.getMothers().get(z) +"\nPaternal line:\n\t"+n+ "\n\t\t" + p.getFathers().get(z)+"\n"
               +"Children:");
            for(int i=0 ; i<p.getFathers().size() ; i++) //A for loop checking each index of the father's name then printing the corresponding child name bearing that index
                if(p.getFathers().get(i).equals(n)) {
                    System.out.println("\t"+p.getChildren().get(i));
                }
            System.out.println("\nHere is the list to keep track of available names: \n"+p.getChildren());//Providing the user with the list of available names to check family tree
        
            
         } else  //If the name provided by the user is not a mother nor a father
            System.out.println("Person's name? "+n+"\nMaternal line:\n\t"+ n + "\n\t\t" + p.getMothers().get(z) +"\nPaternal line:\n\t"+n+ "\n\t\t" + p.getFathers().get(z)+
               "\n"+"Children:\n\tNo Children."+"\nHere is the list to keep track of available names: \n"+p.getChildren()); 
      }
   } 
}

