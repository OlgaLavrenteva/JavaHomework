package main.java.films_collection;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Actor implements Serializable {
    private String name;
    private String surname;
    private String dateOfBirth;

    public Actor(String name, String surname) throws Exception{
        setName(name);
        setSurname(surname);
    }

    public Actor(String name, String surname, String dateOfBirth) throws Exception{
        this(name,surname);
        setDateOfBirth(dateOfBirth);
    }

    public void setName(String name) throws Exception{
        if(name==null){
            throw new Exception("Name is null.");
        }
        this.name=name;
    }

    public void setSurname(String surname) throws Exception{
        if(surname==null){
            throw new Exception("Surname is null.");
        }
        this.surname=surname;
    }

    public void setDateOfBirth(String dateOfBirth) throws Exception{
        if(dateOfBirth==null){
            throw new Exception("Date of birth is null.");
        }
        this.dateOfBirth=dateOfBirth;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

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
}
