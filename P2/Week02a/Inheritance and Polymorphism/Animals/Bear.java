public class Bear extends Mammal {
    
    public Bear() {
        super();
    }

    @Override
    public String makeSound() {
        return "Sounds:  growl/roar/snort\n";
    }

    @Override
    public String eat() {
        return "Eat:  animals and plants\n";
    }

}
