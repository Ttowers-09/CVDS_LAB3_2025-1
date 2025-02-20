package edu.eci.cvds.tdd.library.user;

/**
 * Represents a user in the library system.
 * The user has a name and an ID, which are used to identify and manage the user's interactions 
 * with the library, including borrowing and returning books.
 */
public class User {
    private String name; // The name of the user
    private String id;   // The unique ID of the user

    /**
     * Constructs a new User with the specified name and ID.
     * 
     * @param name The name of the user.
     * @param id The unique identifier of the user.
     */
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Retrieves the name of the user.
     * 
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * 
     * @param name The name to set for the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the ID of the user.
     * 
     * @return The unique ID of the user.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     * 
     * @param id The ID to set for the user.
     */
    public void setId(String id) {
        this.id = id;
    }
}
