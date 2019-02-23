public class Notebook {
    private String notebookName;
    private int sizeOfNotebook;
    //private int numberOfNotes;
    private Note[] notes;

    public Notebook()
    {
        this.notebookName = "A name is not assigned";
        this.sizeOfNotebook = 100;
        this.notes = new Note[this.sizeOfNotebook];
    }

    public Notebook(String notebookName)
    {
        this.notebookName = notebookName;
        this.sizeOfNotebook = 100;
        this.notes = new Note[this.sizeOfNotebook];
    }

    public Notebook(int initialSizeOfNotebook)
    {
        this.notebookName = "A name is not assigned";
        this.sizeOfNotebook = initialSizeOfNotebook;
        this.notes = new Note[this.sizeOfNotebook];
    }

    public Notebook(String notebookName, int initialSizeOfNotebook)
    {
        this.notebookName = notebookName;
        this.sizeOfNotebook = initialSizeOfNotebook;
        this.notes = new Note[this.sizeOfNotebook];
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
        }
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
        int extendedSizeOfNotebook = (int) (sizeOfNotebook*0.5);
        Note[] extendedNotes = new Note[extendedSizeOfNotebook];
        System.arraycopy(notes,0, extendedNotes,0,sizeOfNotebook);
        notes = extendedNotes;
    }
}
