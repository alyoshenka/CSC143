public class Kangaroo extends Mammal {
    
    public Kangaroo() {
        super();
    }
    
    @Override
    public String move() {
        return "Move:  hop on two limbs\n";
    }

    @Override
    public String makeSound() {
        return "Sounds:  tut-tut/grunt/hiss\n";
    }

    @Override
    public String eat() {
        return "Eat:  plants\n";
    }

}
