package main.java.films_collection;

import java.io.Serializable;
import java.util.HashSet;

public class FilmsCollection implements Serializable {
    private String title;
    private HashSet<Film> films;

    public FilmsCollection(String title) throws Exception{
        setTitle(title);
        films = new HashSet<Film>();
    }

    public FilmsCollection(String title, Film film) throws Exception{
        setTitle(title);
        films = new HashSet<Film>();
        setFilms(film);
    }

    public FilmsCollection(String title, HashSet<Film> films) throws Exception{
        setTitle(title);
        this.films = new HashSet<Film>();
        setFilms(films);
    }

    public void setTitle(String title) throws Exception{
        if(title==null){
            throw new Exception("Collection title is null.");
        }
        this.title=title;
    }

    public void setFilms(Film film) throws Exception{
        if(film==null){
            throw new Exception("Film is null");
        }
        HashSet<Film> changedFilms = new HashSet<Film>();
        changedFilms.add(film);
        this.films=changedFilms;
    }

    public void setFilms(HashSet<Film> films) throws Exception{
        if(films==null){
            throw new Exception("Films are null.");
        }
        this.films=films;
    }

    public String getTitle(){
        return title;
    }

    public HashSet<Film> getFilms(){
        return films;
    }

    public void addFilm(Film film){
        if(film!=null){
            films.add(film);
        }
    }

    public void removeFilm(Film film){
        films.remove(film);
    }

    @Override
    public String toString(){
        StringBuilder collection = new StringBuilder("Films collection: ");
        collection.append(title);
        collection.append("\nFilms:");
        if(films!=null){
            for (Film film: films){
                collection.append("\n");
                collection.append(film.toString());
            }
        } else {
            collection.append("No films are available");
        }

        return collection.toString();
    }
}
