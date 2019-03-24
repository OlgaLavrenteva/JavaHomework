package main.java.films_collection;

import java.util.HashSet;
import java.util.Objects;

public class Film {
    private String title;
    private HashSet<Actor> actors;

    public Film(String title) throws Exception{
        setTitle(title);
    }

    public Film(HashSet<Actor> actors) throws Exception{
        setActors(actors);
    }

    public Film(Actor actor) throws Exception{
        setActors(actor);
    }

    public void setTitle(String title) throws Exception{
        if(title==null){
            throw new Exception("Film title is null.");
        }
        this.title=title;
    }

    public void setActors(HashSet<Actor> actors) throws Exception{
        if(actors==null){
            throw new Exception("Actors are null.");
        }
        this.actors=actors;
    }

    public void setActors(Actor actor) throws Exception{
        if(actor==null){
            throw new Exception("Actor is null.");
        }
        this.actors.add(actor);
    }

    public String getTitle(){
        return title;
    }

    public HashSet<Actor> getActors(){
        return actors;
    }

    @Override
    public String toString(){
        StringBuilder film = new StringBuilder("Film title: ");
        film.append(title);
        film.append(" Actors:");
        for (Actor actor: actors){
            film.append(" ");
            film.append(actor.toString());
        }
        return film.toString();
    }

    @Override
    public boolean equals(Object someObject){
        if(this==someObject){
            return true;
        }
        if(!(someObject instanceof Film)){
            return false;
        }
        Film otherFilm=(Film)someObject;
        if(Objects.equals(title,otherFilm.title) && actors.size()==otherFilm.actors.size()){
            for(Actor actor: actors){
                if(!otherFilm.actors.contains(actor)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        int filmHashCode = Objects.hashCode(title);
        for(Actor actor: actors){
            filmHashCode = filmHashCode + Objects.hashCode(actor);
        }
        return filmHashCode;
    }
}
