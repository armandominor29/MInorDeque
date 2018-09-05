/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 * @author (Armando Minor), Acuna
 * @version (version)
 */
import java.util.NoSuchElementException;

public class BaseDeque<Item> implements Deque<Item>
{

    int count, rear, front; //initialize integer variables
    Item element,tmp;       //initialize element and tmp(temperary)
    int SIZE=50;           //Create list size,
    private  Item[] deque;  //Create doubly linked list

    //BaseDeque constructor
    public BaseDeque()
    {
        rear = front =count=25; //set count to 0.
        deque = (Item[]) (new Object[SIZE]);

    }
    //method enqueueFront, adds element to front of list
    public void enqueueFront(Item element)
    {
        count++;
        front--;
        deque[front]= element;
    }
    //method enqueueBack, adds element to back of list
    public void enqueueBack(Item element)
    {

        deque[rear] = element;
        rear = (rear +1) % deque.length;
        count++;
    }
    //method dequeueFront, returns front reference, and removes from list
    public Item dequeueFront() throws NoSuchElementException
    {
        if (isEmpty())
             throw new NoSuchElementException("deque");
        tmp=deque[front];
        deque[front]=null;
        front = (front +1) % deque.length;
        count--;
        return tmp;

    }
    //method dequeueBack, returns rear reference, and removes from list
    public Item dequeueBack() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException("deque");
        tmp=deque[rear -1];
        deque[front]=null;
        count--;
        rear--;
        return tmp;
    }
    //method first, returns front reference
    public Item first() throws NoSuchElementException
    {
        if (isEmpty())
            throw new   NoSuchElementException("deque");
        return deque[front];
    }
    //method last, returns last reference
    public Item last() throws NoSuchElementException
    {
        return deque[rear];
    }
    //method isEmpty returns boolean status
    public boolean isEmpty()
    {
        if (count==0)
            return true;
        else
            return false;
    }
    //methos size, returns list size
    public int size()
    {
        return count%50;
    }
    //method toString, prints list values
    public String toString()
    {
        int scanner= front;
        String p ="";
        for (int i=0;scanner< rear; i++ )
        {
            p += deque[scanner].toString() + " ";
            scanner++;
        }
        return p;

    }

    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        BaseDeque<Integer> deque = new BaseDeque<Integer>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
    }
} 