public class Person {
   private String name;
   private Person mother;
   private Person father;
   private ArrayList<Person> children;
   
   public Person(String name) {//initialize the person (with the first list)
      this.name = name;
      this.children = new ArrayList<Person>();
   }
      
   public void setMother(Person mother) {//mutator method for mother
      this.mother = mother;
   }
   
   public void setFather(Person father) {//mutator method for father
      this.father = father;
   }
   
   public void addChild(Person child) {//mutator method to add child into ArrayList
      children.add(child);//adds child to ArrayList children
      
   public ArrayList<Person> getChildren() {//accessor method for children
   return this.children;
   
   public Person getMother() {//accessor method for mother
      return this.mother;

   public Person getFather() {//accessor method for father
      return this.father;
      
   public String getName() {// accessor method for name
      return name;
   }
}