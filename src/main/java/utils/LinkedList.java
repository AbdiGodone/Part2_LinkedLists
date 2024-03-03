package utils;

import business.Song;

/**
 * @author michelle
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int num_elements;

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
     *
     * @param song takes a parameter song and adds it to the end of the linkedList
     */
    public void add(Song song) {
        Node node = new Node(song);
        if (num_elements == 0) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;

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


    protected static class Node {
        private Song data;
        private Node next;

        /**
         * @param data passed in the param gets the data and sets the data to field data and sets the next to null
         */
        public Node(Song data) {
            this.data = data;
            this.next = null;
        }

        /**
         * @param data it takes string data and sets the value passed to the field data
         */
        public void setData(Song data) {
            this.data = data;
        }

        /**
         * @param next gets the next and sets it from null to the next one passed
         */
        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public Song getData() {
            return this.data;
        }
    }


}
