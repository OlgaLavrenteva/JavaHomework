package notebook;

public class Notebook {
    private String notebookName;
    private int sizeOfNotebook;
    private int numberOfNotes;
    private Note[] notes;

    public Notebook()
    {
        this.notebookName = "A name is not assigned";
        this.sizeOfNotebook = 100;
        notes = new Note[this.sizeOfNotebook];
        System.out.println("Constructor without params for Notebook");
    }

    public Notebook(String notebookName)
    {
        this.notebookName = notebookName;
        this.sizeOfNotebook = 100;
        this.notes = new Note[this.sizeOfNotebook];
        System.out.println("Constructor for Notebook with notebookName = " + notebookName);
    }

    public Notebook(int initialSizeOfNotebook)
    {
        this.notebookName = "A name is not assigned";
        this.sizeOfNotebook = initialSizeOfNotebook;
        this.notes = new Note[this.sizeOfNotebook];
        System.out.println("Constructor for Notebook with initial size = " + initialSizeOfNotebook);
    }

    public Notebook(String notebookName, int initialSizeOfNotebook)
    {
        this.notebookName = notebookName;
        this.sizeOfNotebook = initialSizeOfNotebook;
        this.notes = new Note[this.sizeOfNotebook];
        System.out.println("Constructor for Notebook with notebookName = " + notebookName + " and initial size = " + initialSizeOfNotebook);
    }

    public void addNote(String newNote)
    {
        if (null == newNote)
        {
            System.out.println("Empty note cannot be added");
        }
        else
        {
            int indexForAdd = indexFreePlace();
            notes[indexForAdd] = new Note(newNote);
            numberOfNotes += 1;
            System.out.println("Added note: " + newNote + "; Number of Notes= " + numberOfNotes);
        }
    }

    public void updateNote(String existingNote, String updatedNote)
    {
        if (null == existingNote)
        {
            System.out.println("Note for an updated is not provided");
            return;
        }
        if (null == updatedNote)
        {
            System.out.println("Note cannot be added to empty one. There is separate method to remove note");
            return;
        }

        int indexOfExistingNote = indexOfExistingNote(existingNote);
        if (indexOfExistingNote != -1)
        {
            notes[indexOfExistingNote].set(updatedNote);
            System.out.println("Updated note to:" + updatedNote);
        }
        else
        {
            System.out.println("Given note doesn't exist, you can create a new one");
        }
    }

    public void removeNote(String existingNote)
    {
        if (null == existingNote)
        {
            System.out.println("Given note doesn't exist");
            return;
        }

        int indexOfExistingNote = indexOfExistingNote(existingNote);
        if (indexOfExistingNote != -1)
        {
            notes[indexOfExistingNote] = null;
            System.out.println("Removed note: " + existingNote);
            numberOfNotes -= 1;
            shrinkNotebook();
        }
        else
        {
            System.out.println("Given note doesn't exist");
        }
    }

    public void showAllNotes()
    {
        System.out.println(toString());
    }

    private int indexOfExistingNote(String existingNote)
    {
        for (int noteIndex = 0; noteIndex < sizeOfNotebook; noteIndex++)
        {
            if (notes[noteIndex]!= null && notes[noteIndex].get().equals(existingNote))
            {
                return noteIndex;
            }
        }
        return -1;
    }

    private int indexFreePlace()
    {
        for (int noteIndex = 0; noteIndex < sizeOfNotebook; noteIndex++)
        {
            if (null == notes[noteIndex])
            {
                return noteIndex;
            }
        }

        int indexOfExtendStart = sizeOfNotebook;
        extendNotebook();
        return indexOfExtendStart;
    }

    private void extendNotebook()
    {
        int extendedSizeOfNotebook = sizeOfNotebook*2;
        Note[] extendedNotes = new Note[extendedSizeOfNotebook];
        System.arraycopy(notes,0, extendedNotes,0,sizeOfNotebook);
        notes = extendedNotes;
        System.out.println("Notebook was extended from " + sizeOfNotebook + " to " + extendedSizeOfNotebook);
        sizeOfNotebook = extendedSizeOfNotebook;
    }

    private void shrinkNotebook()
    {
        if (numberOfNotes>=(int) (0.25*sizeOfNotebook) || sizeOfNotebook <= 100)
        {
            System.out.println("Notebook was not shrank. Size is " + sizeOfNotebook + ". Number of notes is " + numberOfNotes);
            return;
        }
        else
        {
            int reducedSizeOfNotebook = Math.abs(sizeOfNotebook/2);
            Note[] reducedNotes = new Note[reducedSizeOfNotebook];
            for (int indCur = 0, indRed = 0; indCur<sizeOfNotebook && indRed<reducedSizeOfNotebook; indCur++)
            {
                if (notes[indCur] != null)
                {
                    reducedNotes[indRed] = notes[indCur];
                    indRed++;
                }
            }
            notes = reducedNotes;
            System.out.println("Notebook was shrank from " + sizeOfNotebook + " to " + reducedSizeOfNotebook);
            sizeOfNotebook = reducedSizeOfNotebook;
        }
    }

    public String toString()
    {
        String notebook = notebookName;

        for (int noteIndex = 0; noteIndex < sizeOfNotebook; noteIndex++)
        {
            if (notes[noteIndex] != null)
            {
                notebook = notebook + '\n' + notes[noteIndex].get();
            }
        }

        return notebook;
    }
}
