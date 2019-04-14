public class Fish extends Animal {
    
    public Fish() {
        super();
    }
    
    @Override
    public String move() {
        return "Move:  swim\n";
    }

    @Override
    public String makeSound() {
        return "Sounds:  clicks\n";
    }

    @Override
    public String showBodyCovering() {
        return "Body Covering:  scales\n";
    }
        
}
