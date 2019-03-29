package test.java.finder;

import notebook.Note;

public class FileForAnalyzingUseCase {
    private static final String DEFAULT_NOTEBOOK_NAME = "A name is not assigned";
    private static final int DEFAULT_SIZE_OF_NOTEBOOK = 100;
    private String notebookName;
    private int sizeOfNotebook;
    private int numberOfNotes;
    private Note[] notes;

    /**
     * Default notebook.Notebook class constructor
     */

    public FileForAnalyzingUseCase() {
        this(DEFAULT_NOTEBOOK_NAME, DEFAULT_SIZE_OF_NOTEBOOK);
    }

    /**
     * notebook.Notebook class constructor with specified notebook name
     */

    public FileForAnalyzingUseCase(String notebookName) {
        this(notebookName, DEFAULT_SIZE_OF_NOTEBOOK);
    }

    /**
     * notebook.Notebook class constructor with specified notebook size
     */

    public FileForAnalyzingUseCase(int initialSizeOfNotebook) {
        this(DEFAULT_NOTEBOOK_NAME, initialSizeOfNotebook);
    }

    /**
     * notebook.Notebook class constructor with specified notebook name and size
     */

    public FileForAnalyzingUseCase(String notebookName, int initialSizeOfNotebook) {
        this.notebookName = null != notebookName ? notebookName : DEFAULT_NOTEBOOK_NAME;
        sizeOfNotebook = initialSizeOfNotebook > 0 ? initialSizeOfNotebook : DEFAULT_SIZE_OF_NOTEBOOK;
        notes = new Note[sizeOfNotebook];
    }

    /**
     * Setter of notebook name
     * @param newNotebookName new notebook name
     */

    public void setNotebookName(String newNotebookName) {
        notebookName = null != newNotebookName ? newNotebookName : DEFAULT_NOTEBOOK_NAME;
        System.out.println("New notebook name is " + notebookName);
    }

    /**
     * Adding of new note to the notebook
     * @param newNote new note to be added to the notebook
     */

    public void addNote(String newNote) {
        if (null == newNote) {
            System.out.println("Empty note cannot be added");
        } else {
            if (numberOfNotes == sizeOfNotebook) {
                extendNotebook();
            }
            notes[numberOfNotes] = new Note(newNote);
            numberOfNotes++;
            System.out.println("Added note: " + newNote + "; Number of Notes= " + numberOfNotes);
        }
    }

    /**
     * Upfating of existing note in the notebook
     * @param existingNote existing note that have to be updated
     * @param updatedNote new note that have to be placed instead of existing one
     */

    public void updateNote(String existingNote, String updatedNote) {
        if (null == existingNote) {
            System.out.println("notebook.Note for update is not provided");
            return;
        }
        if (null == updatedNote) {
            System.out.println("notebook.Note cannot be updated to empty one. There is separate method to remove note");
            return;
        }

        int indexOfExistingNote = indexOfExistingNote(existingNote);
        if (indexOfExistingNote != -1) {
            notes[indexOfExistingNote].setRecord(updatedNote);
            //System.out.println("Updated note to:" + updatedNote);
        } else {
            System.out.println("Given note doesn't exist, you can create a new one");
        }
    }

    /**
     * Removing of existing note from the notebook
     * @param existingNote existing note that have to be removed
     */

    public void removeNote(String existingNote) {
        if (null == existingNote) {
            System.out.println("Given note doesn't exist");
            return;
        }

        int indexOfExistingNote = indexOfExistingNote(existingNote);
        if (indexOfExistingNote != -1) {
            Note[] updatedNotes = new Note[sizeOfNotebook];
            //check that not first note is going to be removed
            if (indexOfExistingNote > 0) {
                System.arraycopy(notes,0, updatedNotes,0,indexOfExistingNote);
            }
            //check that not last note is going to be removed
            if (indexOfExistingNote+1 < numberOfNotes) {
                System.arraycopy(notes,indexOfExistingNote+1, updatedNotes,indexOfExistingNote,numberOfNotes-indexOfExistingNote-1);
            }
            notes = updatedNotes;
            System.out.println("Removed note: " + existingNote);
            numberOfNotes--;
            shrinkNotebook();
        } else {
            System.out.println("Given note doesn't exist");
        }
    }

    /**
     * Printing all notebook data
     */

    public void showAllNotes() {
        System.out.println(this);
    }

    /**
     * Override of toString() method
     * @return notebook data - name, size, free places and all notes
     */
    @Override public String toString() {
        StringBuilder notebookString = new StringBuilder(notebookName);
        notebookString.append('\n');
        notebookString.append("notebook.Notebook size: ");
        notebookString.append(sizeOfNotebook);
        notebookString.append('\n');
        notebookString.append("Free places: ");
        notebookString.append(sizeOfNotebook-numberOfNotes);

        for (int noteIndex = 0; noteIndex < sizeOfNotebook; noteIndex++) {
            if (notes[noteIndex] != null) {
                notebookString.append('\n');
                notebookString.append(notes[noteIndex].getRecord());
            }
        }

        return notebookString.toString();
    }

    /**
     * Searching of note in the notebook
     * @param existingNote note index of that have to be found
     * @return returns index of existingNote or -1 if the note is note in the notebook
     */

    private int indexOfExistingNote(String existingNote) {
        for (int noteIndex = 0; noteIndex < sizeOfNotebook; noteIndex++) {
            if (notes[noteIndex]!= null && notes[noteIndex].getRecord().equals(existingNote)) {
                return noteIndex;
            }
        }
        return -1;
    }

    /**
     * Extends notebook twice
     */

    private void extendNotebook() {
        int extendedSizeOfNotebook = sizeOfNotebook*2;
        Note[] extendedNotes = new Note[extendedSizeOfNotebook];
        System.arraycopy(notes,0, extendedNotes,0,sizeOfNotebook);
        notes = extendedNotes;
        System.out.println("notebook.Notebook was extended from " + sizeOfNotebook + " to " + extendedSizeOfNotebook);
        sizeOfNotebook = extendedSizeOfNotebook;
    }

    /**
     * Reduces notebook twice if less than 25% of places are allocated and if size of notebook more than 100
     */

    private void shrinkNotebook() {
        if (numberOfNotes>=(int) (0.25*sizeOfNotebook) || sizeOfNotebook <= 100) {
            return;
        } else {
            int reducedSizeOfNotebook = Math.abs(sizeOfNotebook/2);
            Note[] reducedNotes = new Note[reducedSizeOfNotebook];
            for (int indCur = 0, indRed = 0; indCur<sizeOfNotebook && indRed<reducedSizeOfNotebook; indCur++) {
                if (notes[indCur] != null) {
                    reducedNotes[indRed] = notes[indCur];
                    indRed++;
                }
            }
            notes = reducedNotes;
            System.out.println("notebook.Notebook was shrank from " + sizeOfNotebook + " to " + reducedSizeOfNotebook);
            sizeOfNotebook = reducedSizeOfNotebook;
        }
    }
}