public class Main {
    
    public static void main(String[] args) {
        // Can't do these any longer
        //      Animal myAnimal = new Animal();
        //      System.out.println("myAnimal:\n" + myAnimal);
        //      Mammal myMammal = new Mammal();
        //      System.out.println("myMammal:\n" + myMammal);
        //      Fish myFish = new Fish();
        //      System.out.println("myFish:\n" + myFish);

        Bear myBear = new Bear();
        Kangaroo myKangaroo = new Kangaroo();
        Grouper myGrouper = new Grouper();
        
        Animal[] myAnimals = new Animal[3];
        myAnimals[0] = myBear;
        myAnimals[1] = myKangaroo;
        myAnimals[2] = myGrouper;
        
        for (Animal animal : myAnimals) {
            printBannerClass(animal);
        }
        compileAndRun();
    }

    private static void compileAndRun() {
        //Mammal a = new Bear(); //y, runs
        //Panda b = new Bear(); //n
        //Kangaroo c = new Grouper(); //n 
        //Animal d = new Bear();  d.feedYoung(); //n
        //Animal e = new Kangaroo(); ((Mammal)e).feedYoung(); //y, runs
        //Animal f = new Grouper(); ((Bear)f).feedYoung(); //y, blow up
        Animal g = new Panda(); ((Bear)g).feedYoung();
    }
    
    private static void printBannerClass(Object object) {
        printBannerLine();
        System.out.println(object.getClass().getName());
        printBannerLine();
        System.out.println(object);
    }
    
    private static void printBannerLine() {
        for (int pos = 0; pos < 60; pos++) {
            System.out.print("-");
        }
        System.out.println();
    }    
}
