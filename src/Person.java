public abstract class Person {
    private String name;

    //default constructor
    public Person() {
        this.name = "";
    }

    //overloaded constructor
    public Person(String name) {
        this.name = name;
    }

    //returns name
    public String getName() {
        return name;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    //forces all subclasses to provide their own toString()
    public abstract String toString();
}