package Models;

/**
 *
 * @author David Huynh
 */
public class Mood {

    private String name;

    /**
     * Constructor that initializes attributes
     *
     * @param name is the name of the food item as a String
     */
    public Mood(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName();
    }
}
