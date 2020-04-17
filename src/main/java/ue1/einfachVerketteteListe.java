package ue1;

public class einfachVerketteteListe {

    private Element head;

    public Element getHead() {
        return head;
    }

    public einfachVerketteteListe() {
        head = null;
    }

    /**
     * Element am Anfang einfügen
     * @param value - Element, welches eingefügt wird
     */
    public void prepend(int value) {
        Element newHead = new Element(value);
        int size = this.size();
        if(size==0) {
            head = newHead;
        }
        else {
            Element oldHead = head;
            head = newHead;
            head.setNext(oldHead);
        }
    }

    /**
     * Element am Ende einfügen
     * @param value - Element, welches eingefügt wird
     */
    public void append(int value) {
        Element newElement = new Element(value);
        int size = this.size();
        if(size==0) {
            this.prepend(value);
        }
        else {
            Element pointer = head;
            for(int i=1; i<size; i++) {
                pointer = pointer.getNext(); // letztes element
            }
            pointer.setNext(newElement);
        }
    }

    /**
     * Element an einer angegebenen Position einfügen
     * @param value - Element, welches eingefügt wird
     * @param index - angegebene Position
     * @throws IndexOutOfBoundsException if the index is out of range (<0 or >size())
     */
    public void insert(int index, int value) throws IndexOutOfBoundsException {
        Element newElement = new Element(value);
        int size = this.size();
        if(index>size || index<0) {
            throw new IndexOutOfBoundsException("Die Liste enthält kein Element an Index " + index + ".");
        }
        else {
            if(size==0) {
                head = newElement;
            }
            else {
                if(index==0) {
                    this.prepend(value); // einfügen an index 0 entspricht am anfang einfügen
                }
                else {
                    Element pointer = head;
                    for(int i=0; i<index-1; i++) {
                        pointer = pointer.getNext(); // element, das gerade vor dem index gespeichert ist
                    }
                    Element oldIndex = pointer.getNext(); // element, das gerade am index gespeichert ist
                    pointer.setNext(newElement);
                    newElement.setNext(oldIndex);
                }
            }
        }
    }

    /**
     * Element an einer angegebenen Position abrufen
     * @param index - angegebene Position
     * @return value - abgerufenes Element
     * @throws IndexOutOfBoundsException if the index is out of range (<0 or >=size())
     */
    public int get(int index) throws IndexOutOfBoundsException {
        int size = this.size();
        int value;
        if(index>=size || index<0) {
            throw new IndexOutOfBoundsException("Die Liste enthält kein Element an Index " + index + ".");
        }
        else if(index==0) {
            value = head.getData();
        }
        else {
            Element indexElement = head;
            for(int i=0; i<index; i++) {
                indexElement = indexElement.getNext();
            }
            value = indexElement.getData();
        }
        return value;
    }

    /**
     * Element an einer angegebenen Position löschen
     * @param index - angegebene Position
     * @throws IndexOutOfBoundsException if the index is out of range (<0 or >=size())
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        int size = this.size();
        if(index>=size || index<0) {
            throw new IndexOutOfBoundsException("Die Liste enthält kein Element an Index " + index + ".");
        }
        else {
            Element pointer = head;
            for(int i=0; i<index-1; i++) {
                pointer = pointer.getNext(); // element, das gerade vor dem index gespeichert ist
            }

            if(index==0) { // erstes element
                head = head.getNext();
            }
            else if(index==(size-1)) { // letztes element
                pointer.setNext(null);
            }
            else { // dazwischen
                Element toDelete = pointer.getNext(); // element, das gerade am index gespeichert ist/ gelöscht werden soll
                Element afterIndex = toDelete.getNext(); // element, das gerade nach dem index gespeichert ist
                pointer.setNext(afterIndex);
                toDelete = null;
            }
        }
    }

    /**
     * prüft, ob das übergebene Element in der Liste enthalten ist
     * @param value - Element, welches übergeben wird
     * @return contains - true, wenn Element in Liste vorhanden ist, false wenn nicht
     */
    public boolean contains(int value){
        int size = this.size();
        boolean contains = false;
        if(size>0) {
            Element pointer = head;
            for(int i=0; i<size; i++) {
                if(pointer.getData()==value) {
                    contains = true;
                    break;
                }
                pointer = pointer.getNext();
            }
        }
        return contains;
    }

    /**
     * ruft die Länge der Liste ab (Hilfsmethode)
     * @return - Länge der Liste
     */
    public int size() {
        if(head==null) {
            return 0;
        }
        else {
            Element pointer = head;
            int counter = 1;
            while(pointer.getNext()!=null) {
                pointer = pointer.getNext();
                counter++;
            }
            return counter;
        }
    }
}