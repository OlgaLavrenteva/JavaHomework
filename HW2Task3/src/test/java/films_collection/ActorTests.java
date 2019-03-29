package test.java.films_collection;

import main.java.films_collection.Actor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ActorTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        assertFalse(actor1.equals(actor2));
        assertFalse(actor2.equals(actor1));
    }

    @Test
    public void equalsActorsOtherObjectClass() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor = new Actor(name,surname,dateOfBirth);
        assertFalse(actor.equals(name));
    }

    @Test
    public void equalsActorsNullOtherObject() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        String dateOfBirth = "End of 1970";
        Actor actor1 = new Actor(name,surname,dateOfBirth);
        Actor actor2 = null;
        assertFalse(actor1.equals(actor2));
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
        assertFalse(actor1.hashCode()==actor2.hashCode());
    }

    @Test
    public void compareToDifSurnames() throws Exception{
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        String name2 = "Name1";
        String surname2 = "Surname2";
        Actor actor2 = new Actor(name2,surname2);
        assertTrue(actor1.compareTo(actor2)<0);
        assertTrue(actor2.compareTo(actor1)>0);
    }

    @Test
    public void compareToSameSurnamesDifNames() throws Exception{
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        String name2 = "Name2";
        String surname2 = "Surname1";
        Actor actor2 = new Actor(name2,surname2);
        assertTrue(actor1.compareTo(actor2)<0);
        assertTrue(actor2.compareTo(actor1)>0);
    }

    @Test
    public void compareToSameSurnamesNamesDifDates() throws Exception{
        String name1 = "Name1";
        String surname1 = "Surname1";
        String dateOfBirth1 = "1970";
        Actor actor1 = new Actor(name1,surname1,dateOfBirth1);
        String name2 = "Name1";
        String surname2 = "Surname1";
        String dateOfBirth2 = "1980";
        Actor actor2 = new Actor(name2,surname2,dateOfBirth2);
        assertTrue(actor1.compareTo(actor2)<0);
        assertTrue(actor2.compareTo(actor1)>0);
    }

    @Test
    public void compareToSameSurnamesNamesDates() throws Exception{
        String name1 = "Name1";
        String surname1 = "Surname1";
        String dateOfBirth1 = "1970";
        Actor actor1 = new Actor(name1,surname1,dateOfBirth1);
        String name2 = "Name1";
        String surname2 = "Surname1";
        String dateOfBirth2 = "1970";
        Actor actor2 = new Actor(name2,surname2,dateOfBirth2);
        assertTrue(actor1.compareTo(actor2)==0);
        assertTrue(actor2.compareTo(actor1)==0);
    }

    @Test
    public void compareToSameSurnamesNamesNullDates() throws Exception{
        String name1 = "Name1";
        String surname1 = "Surname1";
        Actor actor1 = new Actor(name1,surname1);
        String name2 = "Name1";
        String surname2 = "Surname1";
        Actor actor2 = new Actor(name2,surname2);
        assertTrue(actor1.compareTo(actor2)==0);
        assertTrue(actor2.compareTo(actor1)==0);
    }

    @Test
    public void compareToSameActor() throws Exception{
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        assertTrue(actor.compareTo(actor)==0);
        assertTrue(actor.compareTo(actor)==0);
    }

    @Test
    public void compareToSameSurnamesNamesNullOneDate() throws Exception{
        String name1 = "Name1";
        String surname1 = "Surname1";
        String dateOfBirth1 = "1970";
        Actor actor1 = new Actor(name1,surname1,dateOfBirth1);
        String name2 = "Name1";
        String surname2 = "Surname1";
        Actor actor2 = new Actor(name2,surname2);
        assertTrue(actor1.compareTo(actor2)<0);
        assertTrue(actor2.compareTo(actor1)>0);
    }

    @Test
    public void createActorWithInvalidName(){
        String invalidName = null;
        String surname = "Surname1";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Name is null.");
        Actor actor = new Actor(invalidName,surname);
    }

    @Test
    public void createActorWithInvalidSurname(){
        String name = "Name1";
        String invalidSurname = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Surname is null.");
        Actor actor = new Actor(name,invalidSurname);
    }

    @Test
    public void setInvalidActorName(){
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        String invalidName = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Name is null.");
        actor.setName(invalidName);
    }

    @Test
    public void setInvalidActorSurname(){
        String name = "Name1";
        String surname = "Surname1";
        Actor actor = new Actor(name,surname);
        String invalidSurname = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Surname is null.");
        actor.setSurname(invalidSurname);
    }

    @Test
    public void compareToNullActor(){
        String name1 = "Name1";
        String surname1 = "Surname1";
        String dateOfBirth1 = "1970";
        Actor actor1 = new Actor(name1,surname1,dateOfBirth1);
        Actor actor2 = null;
        thrown.expect(NullPointerException.class);
        actor1.compareTo(actor2);
    }
}
