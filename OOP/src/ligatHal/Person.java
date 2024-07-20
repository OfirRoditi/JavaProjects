package ligatHal;

public abstract class Person//Father class
{
    private String name;
    private String lastName;
    private String idOfPerson;
    public Person (String name, String lastName, String idOfPerson)
    {
        this.lastName = lastName;
        this.name=name;
        this.idOfPerson = idOfPerson;
    }
    public String toString ()
    {
        return "Person name and last name : " + name + " "  + lastName + "\n"
                + "id : " + idOfPerson;
    }
    /**
    Abstract method that every son has to inheritance
     */
    public abstract boolean exceptional();
    //Getters and setters:
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getIdOfPerson() {
        return idOfPerson;
    }

}

