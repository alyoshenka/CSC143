public class Mammal extends Animal {

    public Mammal() {
        super();
    }

    @Override
    public String move() {
        return "Move:  walk on four limbs\n";
    }

    @Override
    public String showBodyCovering() {
        return "Body Covering:  hair\n";
    }
    
    public String feedYoung() {
        return "Feeding young:  nursing\n";
    }
    
    @Override
    public String toString() {
        return super.toString() + feedYoung();
    }
}
