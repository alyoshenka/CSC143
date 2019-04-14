public class Main {
    
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Mammal myMammal = new Mammal();
        Bear myBear = new Bear();
        Kangaroo myKangaroo = new Kangaroo();
        Fish myFish = new Fish();
        Grouper myGrouper = new Grouper();
        
        // Create superclass array, add animals
        Animal[] myAnimals = new Animal[6];
        myAnimals[0] = myAnimal;
        myAnimals[1] = myMammal;
        myAnimals[2] = myBear;
        myAnimals[3] = myKangaroo;
        myAnimals[4] = myFish;
        myAnimals[5] = myGrouper;
       
        // Display everything in the array
        for (Animal oneAnimal : myAnimals) {
            System.out.println(oneAnimal.getClass().getName());
            System.out.println(oneAnimal);
        }
    }
    
}
