public abstract class Fish extends Animal {

    public static final String FISH_MOVEMENT   = "swim";
    public static final String FISH_COVERING   = "scales";
    public static final String FISH_SOUNDS     = "click";
    
    public Fish(String diet) {
        super(FISH_MOVEMENT, FISH_COVERING, diet, FISH_SOUNDS);
    }
    
}
