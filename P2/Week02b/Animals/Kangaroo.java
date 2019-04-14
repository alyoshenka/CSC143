public class Kangaroo extends Mammal {
    
    public static final String KANGAROO_DIET   = "plants";
    public static final String KANGAROO_SOUNDS = "tut-tut/grunt/hiss";

    public Kangaroo() {
        super(KANGAROO_DIET, KANGAROO_SOUNDS);
    }
    
    public String move() {
        return Animal.formatAttribute("Move:", "hop on two limbs");
    }
}
