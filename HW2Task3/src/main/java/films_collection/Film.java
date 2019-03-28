package main.java.films_collection;

import java.io.Serializable;
import java.util.*;

public class Film implements Serializable, Comparable<Film> {
    private String title;
    private Set<Actor> actors;

    /**
     * Constructor of Film with mandatory title parameter.
     * @param title
     * @throws IllegalArgumentException if title is null
     */
    public Film(String title) throws IllegalArgumentException{
        setTitle(title);
        actors = new HashSet<>();
    }

    /**
     * Constructor of Film with mandatory title parameter and actor.
     * @param title
     * @param actor - object of Actor
     * @throws IllegalArgumentException if title is null
     */
    public Film(String title, Actor actor) throws IllegalArgumentException{
        setTitle(title);
        actors = new HashSet<>();
        setActors(actor);
    }

    /**
     * Constructor of Film with mandatory title parameter and actors.
     * @param title
     * @param actors - HashSet of Actor
     * @throws IllegalArgumentException if title is null
     */
    public Film(String title, Set<Actor> actors) throws IllegalArgumentException{
        setTitle(title);
        this.actors = new HashSet<>();
        setActors(actors);
    }

    /**
     * Setter method for mandatory field title.
     * @param title
     * @throws IllegalArgumentException if title is null
     */
    public void setTitle(String title) throws IllegalArgumentException{
        if(title==null){
            throw new IllegalArgumentException("Film title is null.");
        }
        this.title=title;
    }

    /**
     * Setter method for actor.
     * @param actor - object of Actor
     */
    public void setActors(Actor actor){
        Set<Actor> updatedActors=new HashSet<>();
        if(actor!=null){
            updatedActors.add(actor);
        }
        actors=updatedActors;
    }

    /**
     * Setter method for actors.
     * @param actors - HashSet of Actor
     */
    public void setActors(Set<Actor> actors){
        Set<Actor> updatedActors=new HashSet<>();
        if(actors!=null){
            updatedActors=actors;
        }
        this.actors=updatedActors;
    }

    /**
     * Getter method for mandatory field title.
     * @return
     */
    public String getTitle(){
        return title;
    }

    /**
     * Getter method for actors.
     * @return HashSet of Actor
     */
    public Set<Actor> getActors(){
        return actors;
    }

    /**
     * The method allows to add a new actor to existing HashSet
     * @param actor
     */
    public void addActor(Actor actor){
        if(actor!=null){
            actors.add(actor);
        }
    }

    /**
     * The method allows to remove the actor from existing HashSet
     * @param actor
     */
    public void removeActor(Actor actor){
        actors.remove(actor);
    }

    @Override
    public String toString(){
        StringBuilder film = new StringBuilder("Film title: ");
        film.append(title);
        film.append("\nActors:");
        if(actors.size()!=0){
            Set<Actor> actorsSorted = new TreeSet<>(actors);
            for (Actor actor: actorsSorted){
                film.append("\n");
                film.append(actor.toString());
            }
        } else{
            film.append(" No actors available");
        }

        return film.toString();
    }

    /**
     * equals method returns true only when values of title and actors of one film are equal to title and actors
     * of another actor.
     * @param someObject
     * @return
     */
    @Override
    public boolean equals(Object someObject){
        if(someObject==null){
            return false;
        }
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

    @Override
    public int compareTo(Film otherFilm) throws NullPointerException{
        if (otherFilm==null){
            throw new NullPointerException();
        }
        if (this==otherFilm){
            return 0;
        }

        if (title.compareToIgnoreCase(otherFilm.title)!=0){
            return title.compareToIgnoreCase(otherFilm.title);
        } else if (actors!=null && otherFilm.actors!=null && actors.size()!=otherFilm.actors.size()){
            return (actors.size()<otherFilm.actors.size()) ? 1 : -1;
        } else if (actors!=null && otherFilm.actors!=null && actors.size()==otherFilm.actors.size()){
            Set<Actor> actorsSorted = new TreeSet<>(actors);
            Iterator<Actor> itrActor = actorsSorted.iterator();
            Set<Actor> otherActorsSorted = new TreeSet<>(otherFilm.actors);
            Iterator<Actor> itrOtherActor = otherActorsSorted.iterator();
            while(itrActor.hasNext()){
                int compare = itrActor.next().compareTo(itrOtherActor.next());
                if(compare!=0){
                    return compare;
                }
            }
            return 0;
        } else if (actors==null && otherFilm.actors==null){
            return 0;
        } else if (actors==null || otherFilm.actors==null){
            return (actors==null) ? 1 : -1;
        }
        return 0;
    }
}
