package test.java.films_collection;

import main.java.films_collection.Actor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ActorTests {
    @Test
    public void createActorWithNameSurname() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        assertEquals(name,actor.getName());
        assertEquals(surname,actor.getSurname());
        assertNull(actor.getDateOfBirth());
    }

    @Test
    public void createActorWithNameSurnameDateOfBirth() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor = new Actor(name,surname,dateOfBirth);
        assertEquals(name,actor.getName());
        assertEquals(surname,actor.getSurname());
        assertEquals(dateOfBirth,actor.getDateOfBirth());
    }

    @Test
    public void createActorWithNullDateOfBirth() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String nullDateOfBirth = null;
        Actor actor = new Actor(name,surname,nullDateOfBirth);
        assertEquals(name,actor.getName());
        assertEquals(surname,actor.getSurname());
        assertNull(actor.getDateOfBirth());
    }

    @Test
    public void setValidActorName() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        String newName = "ChangedName1";
        actor.setName(newName);
        assertEquals(newName,actor.getName());
    }

    @Test
    public void setValidActorSurname() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        String newSurname = "ChangedSurname1";
        actor.setSurname(newSurname);
        assertEquals(newSurname,actor.getSurname());
    }

    @Test
    public void setNotNullActorDateOfBirth() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        String dateOfBirth = "End of 1970";
        actor.setDateOfBirth(dateOfBirth);
        assertEquals(dateOfBirth,actor.getDateOfBirth());
    }

    @Test
    public void setNullActorDateOfBirth() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        String nullDateOfBirth = null;
        actor.setDateOfBirth(nullDateOfBirth);
        assertNull(actor.getDateOfBirth());
    }

    @Test
    public void toStringActorWithNameSurname() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        String expectedActorString = "Actor name: " + name + " Actor surname: " + surname + " Actor`s date of birth: null";
        assertEquals(expectedActorString,actor.toString());
    }

    @Test
    public void toStringActorWithNameSurnameDateOfBirth() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor = new Actor(name,surname,dateOfBirth);
        String expectedActorString = "Actor name: " + name + " Actor surname: " + surname + " Actor`s date of birth: " +
                dateOfBirth;
        assertEquals(expectedActorString,actor.toString());
    }

    @Test
    public void equalsActorsSameObject() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor = new Actor(name,surname,dateOfBirth);
        assertTrue(actor.equals(actor));
    }

    @Test
    public void equalsActorsEqualObject() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor1 = new Actor(name,surname,dateOfBirth);
        Actor actor2 = new Actor(name,surname,dateOfBirth);
        assertTrue(actor1.equals(actor2));
        assertTrue(actor2.equals(actor1));
    }

    @Test
    public void equalsActorsNotEqualObject() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor1 = new Actor(name,surname,dateOfBirth);
        Actor actor2 = new Actor(name,surname);
        assertTrue(!actor1.equals(actor2));
        assertTrue(!actor2.equals(actor1));
    }

    @Test
    public void equalsActorsOtherObjectClass() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor = new Actor(name,surname,dateOfBirth);
        assertTrue(!actor.equals(name));
    }

    @Test
    public void hashCodeEqualActors() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor1 = new Actor(name,surname,dateOfBirth);
        Actor actor2 = new Actor(name,surname,dateOfBirth);
        assertTrue(actor1.hashCode()==actor2.hashCode());
    }

    @Test
    public void hashCodeNotEqualActors() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth1 = "End of 1970";
        String dateOfBirth2 = "12/30/1968";
        Actor actor1 = new Actor(name,surname,dateOfBirth1);
        Actor actor2 = new Actor(name,surname,dateOfBirth2);
        assertTrue(!(actor1.hashCode()==actor2.hashCode()));
    }

    @Test
    public void createActorWithInvalidName(){
        try {
            String invalidName = null;
            String surname = "Surname1";
            Actor actor = new Actor(invalidName,surname);
        } catch (Exception e){
            String expectedExceptionMessage = "Name is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void createActorWithInvalidSurname(){
        try {
            String name = "Name1";
            String invalidSurname = null;
            Actor actor = new Actor(name,invalidSurname);
        } catch (Exception e){
            String expectedExceptionMessage = "Surname is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @Test
    public void setInvalidActorName(){
        try{
            String name = "Name1";
            String surname = "Surname1";
            Actor actor = new Actor(name,surname);
            String invalidName = null;
            actor.setName(invalidName);
        } catch (Exception e){
            String expectedExceptionMessage = "Name is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }

    }

    @Test
    public void setInvalidActorSurname(){
        try{
            String name = "Name1";
            String surname = "Surname1";
            Actor actor = new Actor(name,surname);
            String invalidSurname = null;
            actor.setSurname(invalidSurname);
        } catch (Exception e){
            String expectedExceptionMessage = "Surname is null.";
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }
}
