import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @author   Midas Oden   (mto0006@auburn.edu)
 * @author   2020/10/19
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

   //////////////////////////////////////////////////////////
   // Do not change the following three fields in any way. //
   //////////////////////////////////////////////////////////

   /** References to the first and last node of the list. */
   Node front;
   Node rear;

   /** The number of nodes in the list. */
   int size;

   /////////////////////////////////////////////////////////
   // Do not change the following constructor in any way. //
   /////////////////////////////////////////////////////////

   /**
    * Instantiates an empty LinkedSet.
    */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }

   /**
    * Creates a Linked Set.
    */
   private LinkedSet(Node f, Node r, int s) {
      front = f;
      rear = r;
      size = s;
   }

   //////////////////////////////////////////////////
   // Public interface and class-specific methods. //
   //////////////////////////////////////////////////

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this LinkedSet.
    *
    * @return a string representation of this LinkedSet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }

   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return (size == 0);
   }

   /**
    * Ensures the collection contains the specified element. Neither duplicate
    * nor null values are allowed. This method ensures that the elements in the
    * linked list are maintained in ascending natural order.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */
   public boolean add(T element) {
      Node n = new Node(element);
      Node current = front;

      if(element == null) {
         throw new NullPointerException();
      }

      if(this.contains(element)) {
         return false;
      }

      if(isEmpty()) {
         front = n;
         rear = n;
      }
      else if (front.element.compareTo(element) > 0) {
         n.next = front;
         front.prev = n;
         front = n;
      }
      else if (front.element.compareTo(element) < 0) {
         rear.next = n;
         n.prev = rear;
         rear = n;
      }
      else {
         Node before = previousNode(element);
         before.next.prev = n;
         n.next = before.next;
         before.next = n;
         n.prev = before;
      }

      size++;
      return true;
   }
   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. This method, consistent with add, ensures
    * that the elements in the linked lists are maintained in ascending
    * natural order.
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   public boolean remove(T element) {
      if (isEmpty()) {
         return false;
      }
      if (front == null || !this.contains(element)) {
         throw new NullPointerException();
      }

      Node n = front;

      while(n != null) {
         if(n.element.equals(element)) {
            if(n == front) {
               front.prev = null;
               front = front.next;
            }
            else if(n == rear) {
               rear.next = null;
               rear = rear.prev;
            }
            else {
               n.prev.next = n.next;
            }
            size--;
            return true;
         }
         n = n.next;
      }
      return false;
   }

   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection is to be tested.
    * @return  true if this collection contains the specified element, false otherwise.
    */
   public boolean contains(T element) {
      if (isEmpty()) {
         return false;
      }
      if (front == null) {
         return false;
      }

      Node n = front;

      while (n != null) {
         if (n.element.equals(element)) {
            return true;
         }
         n = n.next;
      }
      return false;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(Set<T> s) {
      if(size == s.size() && complement(s).size() == 0) {
         return true;
      }
      return false;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(LinkedSet<T> s) {
      if(size == s.size() && complement(s).size() == 0) {
         return true;
      }
      return false;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(Set<T> s) {
      if(s == null) {
         throw new NullPointerException();
      }

      LinkedSet<T> returnSet = new LinkedSet<T>();

      Node n = front;

      while(n != null) {
         returnSet.add(n.element);
         n = n.next;
      }

      Iterator<T> i = s.iterator();

      while(i.hasNext()) {
         returnSet.add(i.next());
      }
      return returnSet;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(LinkedSet<T> s) {
      if(s == null) {
         throw new NullPointerException();
      }

      LinkedSet<T> returnSet = new LinkedSet<T>();

      Node n = front;

      while(n != null) {
         returnSet.add(n.element);
         n = n.next;
      }

      Iterator<T> i = s.iterator();

      while(i.hasNext()) {
         returnSet.add(i.next());
      }
      return returnSet;
   }

   /**
    * Returns a set that is the intersection of this set and the parameter set.
    *
    * @return  a set that contains elements that are in both this set and the parameter set
    */
   public Set<T> intersection(Set<T> s) {
      if(s == null) {
         throw new NullPointerException();
      }

      LinkedSet<T> returnSet = new LinkedSet<T>();

      Node n = front;

      while(n != null) {
         if(s.contains((T)n.element)) {
            returnSet.add((T)n.element);
         }

         n = n.next;
      }
      return returnSet;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(LinkedSet<T> s) {
      if(s == null) {
         throw new NullPointerException();
      }

      LinkedSet<T> returnSet=new LinkedSet<T>();

      Node n = front;
      while(n != null) {
         if(s.contains((T)n.element)) {
            returnSet.add((T)n.element);
         }

         n = n.next;
      }
      return returnSet;
   }

   /**
    * Returns a set that is the complement of this set and the parameter set.
    *
    * @return  a set that contains elements that are in this set but not the parameter set
    */
   public Set<T> complement(Set<T> s) {
      if(s == null) {
         throw new NullPointerException();
      }
      LinkedSet<T> returnSet = new LinkedSet<T>();

      Node t=front;

      while(t != null) {
         if(!s.contains((T)t.element)) {
            returnSet.add((T)t.element);
         }

         t = t.next;
      }
      return returnSet;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(LinkedSet<T> s) {
      if(s == null) {
         throw new NullPointerException();
      }

      LinkedSet<T> returnSet=new LinkedSet<T>();

      Node n = front;

      while(n != null) {
         if(!s.contains((T)n.element)) {
            returnSet.add((T)n.element);
         }

         n = n.next;
      }

      return returnSet;
   }

   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in ascending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> iterator() {
      return new LinkedIterator();
   }

   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in descending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> descendingIterator() {
      return new LinkedDescendingIterator();
   }

   /**
    * Returns an iterator over the members of the power set
    * of this LinkedSet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      return new PowerSetIterator(front, size);
   }

   //////////////////////////////
   // Private utility methods. //
   //////////////////////////////

   // Feel free to add as many private methods as you need.

   private Node previousNode(T element) {
      Node n = front;
      while (n != null) {
         if (n.element.compareTo(element) > 0) {
            return n.prev;
         }
         n = n.next;
      }
      return n;
   }

   /**
    * LinkedIterator class intended to provide an interator over the nodes in the LinkedSet.
    */
   private class LinkedIterator implements Iterator<T> {
      private Node head = front;

      public boolean hasNext() {
         return head != null;
      }
      public T next() {
         if (!hasNext())
            throw new NoSuchElementException();

         T result = head.element;
         head = head.next;
         return result;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   /**
    * LinkedIterator class intended to provide an interator over the nodes in the LinkedSet.
    */
   private class LinkedDescendingIterator implements Iterator<T> {
      private Node tail = rear;

      public LinkedDescendingIterator() {
      }


      public boolean hasNext() {
         if (isEmpty()) {
            return false;
         }
         return tail != null;
      }

      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }

         T temp = tail.element;
         tail = tail.prev;
         return temp;
      }

      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   private class PowerSetIterator implements Iterator<Set<T>> {
      Node n;
      int s;
      int counter;
      int p = 0;

      public PowerSetIterator(Node front,int size) {
         n = front;
         s = size;
         counter = 0;
         p = 0;
      }

      public boolean hasNext() {
         return (counter<(int)Math.pow(2,s));
      }

      public Set<T> next() {
         Set<T> r=new LinkedSet<T>();
         int t = 1;
         for (int k = 0; k < s; k++) {
            if((p & t) != 0) {
               r.add(n.element);
               n = n.next;
            }
            else
               n = n.next;
         }
         counter++;
         p = 0;
         n = front;
         return r;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   ////////////////////
   // Nested classes //
   ////////////////////

   //////////////////////////////////////////////
   // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
   //////////////////////////////////////////////

   /**
    * Defines a node class for a doubly-linked list.
    */
   class Node {
      /** the value stored in this node. */
      T element;
      /** a reference to the node after this node. */
      Node next;
      /** a reference to the node before this node. */
      Node prev;

      /**
       * Instantiate an empty node.
       */
      public Node() {
         element = null;
         next = null;
         prev = null;
      }

      /**
       * Instantiate a node that contains element
       * and with no node before or after it.
       */
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
   }
}
