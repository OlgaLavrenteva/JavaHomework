import notebook.*;

public class HW1Solution {
    public static void main(String[] args) {
        // Main is used to do some tests

        //Positive cases:
        //add notebook with default fields
        Notebook notebook1 = new Notebook();

        //add notes
        notebook1.addNote("First note");
        notebook1.addNote("Second note");
        notebook1.addNote("Third note");

        //exceed notebook size
        for (int i=4; i<202; i++)
        {
            notebook1.addNote(i + " note");
        }

        //remove notes without shrink of notebook
        for (int i=4; i<155; i++)
        {
            notebook1.removeNote(i + " note");
        }

        //remove note and shrink notebook
        notebook1.removeNote("155 note");

        //update note
        notebook1.updateNote("Second note", "Changed second note");

        //show all notes
        notebook1.showAllNotes();

        //add notebook with name
        Notebook notebook2 = new Notebook("My notebook 2");

        //add notebook with size
        Notebook notebook3 = new Notebook(10);

        //add notebook with name & size
        Notebook notebook4 = new Notebook("My notebook 4", 5);


    }
}
