package main.java.films_collection;

import java.util.Date;

public class Actor{
    private String name;
    private String surname;
    private Date dateOfBirth;

    public Actor(String name, String surname) throws Exception{
        setName(name);
        setSurname(surname);
    }

    public Actor(String name, String surname, Date dateOfBirth) throws Exception{
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

    public void setDateOfBirth(Date dateOfBirth) throws Exception{
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

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    @Override
    public String toString(){
        StringBuilder actor = new StringBuilder("Actor name:");
        actor.append(name);
        actor.append(" Actor surname:");
        actor.append(" Actor`s date of birth:");
        actor.append(dateOfBirth);
        return actor.toString();
    }
}
