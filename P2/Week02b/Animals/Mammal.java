public abstract class Mammal extends Animal {

    public static final String MAMMAL_MOVEMENT   = "walk on four limbs";
    public static final String MAMMAL_COVERING   = "hair";
    
    public Mammal(String diet, String sound) {
        super(MAMMAL_MOVEMENT, MAMMAL_COVERING, diet, sound);
    }

    public String feedYoung() {
        return Animal.formatAttribute("Feeding young:", "nursing");
    }
    
    public String toString() {
        return super.toString() + feedYoung();
    }
}
