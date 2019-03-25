package main.java.films_collection;

import java.io.Serializable;
import java.util.HashSet;
import java.util.TreeSet;

public class FilmsCollection implements Serializable {
    private String title;
    private HashSet<Film> films;

    /**
     * Constructor of FilmsCollection with mandatory title parameter.
     * @param title
     * @throws Exception if title is null
     */
    public FilmsCollection(String title) throws Exception{
        setTitle(title);
        films = new HashSet<>();
    }

    /**
     * Constructor of FilmsCollection with mandatory title parameter and film.
     * @param title
     * @param film - object of Film
     * @throws Exception if title is null
     */
    public FilmsCollection(String title, Film film) throws Exception{
        setTitle(title);
        films = new HashSet<>();
        setFilms(film);
    }

    /**
     * onstructor of FilmsCollection with mandatory title parameter and films.
     * @param title
     * @param films - HashSet of Film
     * @throws Exception if title is null
     */
    public FilmsCollection(String title, HashSet<Film> films) throws Exception{
        setTitle(title);
        this.films = new HashSet<>();
        setFilms(films);
    }

    /**
     * Setter method for mandatory field title.
     * @param title
     * @throws Exception if title is null
     */
    public void setTitle(String title) throws Exception{
        if(title==null){
            throw new Exception("Collection title is null.");
        }
        this.title=title;
    }

    /**
     * Setter method for film.
     * @param film - object of Film
     */
    public void setFilms(Film film){
        HashSet<Film> changedFilms = new HashSet<>();
        if(film!=null){
            changedFilms.add(film);
        }
        this.films=changedFilms;
    }

    /**
     * Setter method for films.
     * @param films - HashSet of Film
     */
    public void setFilms(HashSet<Film> films){
        HashSet<Film> changedFilms = new HashSet<>();
        if(films!=null){
            changedFilms=films;
        }
        this.films=changedFilms;
    }

    /**
     * Getter method for mandatory field title.
     * @return
     */
    public String getTitle(){
        return title;
    }

    /**
     * Getter method for films.
     * @return HashSet of Film
     */
    public HashSet<Film> getFilms(){
        return films;
    }

    /**
     * The method allows to add a new film to existing HashSet
     * @param film
     */
    public void addFilm(Film film){
        if(film!=null){
            films.add(film);
        }
    }

    /**
     * The method allows to remove the film from existing HashSet
     * @param film
     */
    public void removeFilm(Film film){
        films.remove(film);
    }

    @Override
    public String toString(){
        StringBuilder collection = new StringBuilder("Films collection: ");
        collection.append(title);
        collection.append("\nFilms:");
        if(films.size()!=0){
            TreeSet<Film> filmsSorted = new TreeSet<>(films);
            for (Film film: filmsSorted){
                collection.append("\n");
                collection.append(film.toString());
            }
        } else {
            collection.append(" No films are available");
        }

        return collection.toString();
    }
}
