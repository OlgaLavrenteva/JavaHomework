package main.java.films_collection;

import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable, Comparable<Actor> {
    private String name;
    private String surname;
    private String dateOfBirth;

    /**
     * Constructor of Actor with two mandatory parameters.
     * @param name
     * @param surname
     * @throws Exception if name or surname is null
     */
    public Actor(String name, String surname) throws Exception{
        setName(name);
        setSurname(surname);
    }

    /**
     * Constructor of Actor with two mandatory parameters(name and surname) and dateOfBirth.
     * @param name
     * @param surname
     * @param dateOfBirth
     * @throws Exception if name or surname is null
     */
    public Actor(String name, String surname, String dateOfBirth) throws Exception{
        this(name,surname);
        setDateOfBirth(dateOfBirth);
    }

    /**
     * Setter method for mandatory field name.
     * @param name
     * @throws Exception if name is null
     */
    public void setName(String name) throws Exception{
        if(name==null){
            throw new Exception("Name is null.");
        }
        this.name=name;
    }

    /**
     * Setter method for mandatory field surname.
     * @param surname
     * @throws Exception if surname is null
     */
    public void setSurname(String surname) throws Exception{
        if(surname==null){
            throw new Exception("Surname is null.");
        }
        this.surname=surname;
    }

    /**
     * Setter method for dateOfBirth field.
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    /**
     * Getter method for name field.
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Getter method for surname field.
     * @return
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Getter method for dateOfBirth field.
     * @return
     */
    public String getDateOfBirth(){
        return dateOfBirth;
    }

    @Override
    public String toString(){
        StringBuilder actor = new StringBuilder("Actor name: ");
        actor.append(name);
        actor.append(" Actor surname: ");
        actor.append(surname);
        actor.append(" Actor`s date of birth: ");
        actor.append(dateOfBirth);
        return actor.toString();
    }

    /**
     * equals method returns true only when values of all fields of one actor are equal to values of appropriate fields
     * of another actor.
     * @param someObject
     * @return
     */
    @Override
    public boolean equals(Object someObject){
        if(this==someObject){
            return true;
        }
        if(!(someObject instanceof Actor)){
            return false;
        }
        Actor otherActor=(Actor)someObject;
        return Objects.equals(name,otherActor.name) && Objects.equals(surname,otherActor.surname) &&
                Objects.equals(dateOfBirth,otherActor.dateOfBirth);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,surname,dateOfBirth);
    }

    @Override
    public int compareTo(Actor otherActor) throws NullPointerException{
        if (otherActor==null){
            throw new NullPointerException();
        }
        if (this==otherActor){
            return 0;
        }

        if (surname.compareToIgnoreCase(otherActor.surname)!=0){
            return surname.compareToIgnoreCase(otherActor.surname);
        } else if (name.compareToIgnoreCase(otherActor.name)!=0){
            return name.compareToIgnoreCase(otherActor.name);
        } else if (dateOfBirth!=null && otherActor.dateOfBirth!=null && dateOfBirth.compareToIgnoreCase(otherActor.dateOfBirth)!=0){
            return dateOfBirth.compareToIgnoreCase(otherActor.dateOfBirth);
        } else if (dateOfBirth==null && otherActor.dateOfBirth==null){
            return 0;
        } else if (dateOfBirth==null || otherActor.dateOfBirth==null){
            return (dateOfBirth==null) ? 1 : -1;
        }
        return 0;
    }
}
