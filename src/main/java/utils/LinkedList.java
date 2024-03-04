package utils;

import business.Song;

/**
 * @author michelle
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int num_elements;

    /*
    this method returns the size of the linkedList
     */
    public int size() {
        return num_elements;
    }

    /**
     * this method takes a position as a parameter
     * validate the position to check that it's inside the boundaries of the linkedList
     * looping  through linkedList reaching the pos each time current moves to the next element
     * getting the element
     *
     * @param pos the position in which the data is
     * @return the data which is inside the position given
     */
    public Song get(int pos) {
        if (pos < 0 || pos >= num_elements) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();

        }
        return current.getData();

    }

    /**
     * this method takes a song parameter, sets current as the head and loops through until it finds one that equals
     * to the one passed as a parameter, returns the position that it was in
     * else returns -1 as it does not find a match to the one entered as a parameter
     *
     * @param song takes a song as a parameter a
     * @return returns the position that the song was found in
     */
    public int indexOf(Song song) {
        Node current = head;

        for (int i = 0; i < num_elements; i++) {
            if (current.getData().equals(song)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }


    /**
     * this method adds a song passed in the parameter to the end of the LinkedList if the linkedList is null then we just add to it as first
     * if there is more in the linkedList we check that its the same artist if it is we add it to the end of the linkedList else we throw IllegalArgumentException
     * then we encerement the number of elements in the LinkedList
     * @param song takes a parameter song and adds it to the end of the linkedList
     */
    public void add(Song song) {
        Node current = head;

        Node node = new Node(song);

        if (num_elements == 0) {
           head = node;
            tail = node;
        } else {

            if (song.getArtist().equals(current.getData().getArtist())){

                tail.setNext(node);
                tail = node;
            }
            else {
               throw new  IllegalArgumentException("they have to have same artist");
            }
        }

        num_elements++;
    }

    /**
     * this method checks whether the linkedList is empty by checking if the head is null if so the linkedList is empty
     *
     * @return boolean whether the linkedList is empty or not
     */
    public boolean isEmpty() {
        Node current = head;
        boolean isEmpty = false;
        if (current == null) {
            isEmpty = true;
        }
        return isEmpty;

    }

    /**
     * this method gets the tail of the linkedList it checks if there is elements in the linkedList
     * if there is no element linkedList then we return null
     * if head is not null then we loop until the getNext element is null it means we reached the tail
     * then we return the elem
     *
     * @return the last element in the linkedList e.g. the tail
     */
    public Node tail() {
        Node current = head;
        if (current == null) {
            return null;
        }

        while (current.getNext() != null) {
            current.getNext();
        }
        return current;

    }

    /**
     * this method takes a song and removes all instances of the song we loop till we reach the tail
     * everytime we loop and find instance of that we remove it from the linkedList
     * @param song takes the song to be deleted
     * @return returns true if deleted else returns false
     */
    public boolean removeAll(Song song){
        boolean removed = false;
        Node current = head;
        while (current.getNext()!=null){
            if (current.getData().equals(song)){
                current.setNext(current.getNext().getNext());
                removed = true;
            }
        }
return  removed;
    }


    protected static class Node {
        private Song data;
        private Node next;

        /**
         * this constructor takes a song type data, and it assigns the data passed to the data and sets the next instant variable to null
         * @param data passed in the param gets the data and sets the data to field data and sets the next to null
         */
        public Node(Song data) {
            this.data = data;
            this.next = null;
        }

        /**
         * this method sets the instant variable data to the data passed in the param
         * @param data it takes string data and sets the value passed to the field data
         */
        public void setData(Song data) {
            this.data = data;
        }

        /**
         * this method sets the next instant variable to the next passed in the param
         * @param next gets the next and sets it from null to the next one passed
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /*
        this method returns the next instant variable
         */
        public Node getNext() {
            return this.next;
        }

        /*
        this method returns the data
         */
        public Song getData() {
            return this.data;
        }
    }


}
