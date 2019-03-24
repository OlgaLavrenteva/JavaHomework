package main.java.films_collection;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class Film implements Serializable {
    private String title;
    private HashSet<Actor> actors;

    public Film(String title) throws Exception{
        setTitle(title);
        actors = new HashSet<Actor>();
    }

    public Film(String title, Actor actor) throws Exception{
        setTitle(title);
        actors = new HashSet<Actor>();
        setActors(actor);
    }

    public Film(String title, HashSet<Actor> actors) throws Exception{
        setTitle(title);
        actors = new HashSet<Actor>();
        setActors(actors);
    }

    public void setTitle(String title) throws Exception{
        if(title==null){
            throw new Exception("Film title is null.");
        }
        this.title=title;
    }

    public void setActors(Actor actor) throws Exception{
        if(actor==null){
            throw new Exception("Actor is null.");
        }
        HashSet<Actor> changedActors = new HashSet<Actor>();
        changedActors.add(actor);
        actors=changedActors;
    }

    public void setActors(HashSet<Actor> actors) throws Exception{
        if(actors==null){
            throw new Exception("Actors are null.");
        }
        this.actors=actors;
    }

    public String getTitle(){
        return title;
    }

    public HashSet<Actor> getActors(){
        return actors;
    }

    public void addActor(Actor actor){
        if(actor!=null){
            actors.add(actor);
        }
    }

    public void removeActor(Actor actor){
        actors.remove(actor);
    }

    @Override
    public String toString(){
        StringBuilder film = new StringBuilder("Film title: ");
        film.append(title);
        film.append("\nActors:");
        if(actors!=null){
            for (Actor actor: actors){
                film.append("\n");
                film.append(actor.toString());
            }
        } else{
            film.append("No actors available");
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
