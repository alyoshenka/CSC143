public class Animal {
    
    public Animal() {
    }
    
    public String move() {
        return "Move:  various movements\n";
    }

    public String makeSound() {
        return "Sounds:  various sounds\n";
    }

    public String eat() {
        return "Eat:  various diets\n";
    }
    
    public String showBodyCovering() {
        return "Body Covering:  various body coverings\n";
    }

    public String toString() {
        return move() + makeSound() + eat() + showBodyCovering();
    }
}
