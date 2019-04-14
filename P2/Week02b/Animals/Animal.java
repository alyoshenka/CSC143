public abstract class Animal {

    private static final String ATTRIBUTE_FMT = "%-20s%s\n";
    
    private String movement;
    private String bodyCovering;
    private String diet;
    private String sound;
    
    public Animal(String movement, String bodyCovering, String diet, String sound) {
        this.movement = movement;
        this.bodyCovering = bodyCovering;
        this.diet = diet;
        this.sound = sound;
    }
    
    public String move() {
        return formatAttribute("Move:", movement);
    }

    public String showBodyCovering() {
        return formatAttribute("Body Covering:", bodyCovering);
    }

    public String eat() {
        return formatAttribute("Eat:", diet);
    }

    public String makeSound() {
        return formatAttribute("Sounds:",sound);
    }

    public String toString() {
        return move() + makeSound() + eat() + showBodyCovering();
    }

    // Static methods
    public static String formatAttribute(String attribute, String content) {
        return String.format(ATTRIBUTE_FMT, attribute, content);
    }

}
