
/**
 * Defines characteristics and behaviors that apply to all people
 * 
 * @author Bill Barry
 * @version 2016-01-08
 */
public class Person {

    private String id;
    private String name;
    private String email;
    
    public Person(String id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }
    
    public boolean isValidId(String id) {
        // We know we'll need to validate the id, per rules,
        //      but we really don't know what to write here, yet
        return true;
    }
    
    public void setId(String id) {
        if (!isValidId(id)) {
            throw new IllegalArgumentException("Invalid ID; check ID specifications");
        }
        this.id = id;
    }
    
    public String getId()     {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        String info = "";
        info += "Id    = " + id + "\n";
        info += "Name  = " + name + "\n";
        info += "Email = " + email + "\n";
        return info;
    }
}
