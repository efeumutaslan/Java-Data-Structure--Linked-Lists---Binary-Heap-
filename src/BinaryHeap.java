
import java.util.Arrays;
import java.util.NoSuchElementException;
 

class BinaryHeap    
{
   
    private static final int d = 2;
    private int heapSize;
    private int[] heap;
 
    public BinaryHeap(int capacity)
    {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }
 
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }
 

    public boolean isFull( )
    {
        return heapSize == heap.length;
    }
 
   
    public void makeEmpty( )
    {
        heapSize = 0;
    }
 
  
    private int parent(int i) 
    {
        return (i - 1)/d;
    }
 
   
    private int kthChild(int i, int k) 
    {
        return d * i + k;
    }
 
    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = x;
        heapUp(heapSize - 1);
    }
 
    public int foneMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");           
        return heap[0];
    }
 
   
    public int deleteMin()
    {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }
 

    public int delete(int one)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[one];
        heap[one] = heap[heapSize - 1];
        heapSize--;
        heapDown(one);        
        return keyItem;
    }
 

    private void heapUp(int childOne)
    {
        int temp = heap[childOne];    
        while (childOne > 0 && temp < heap[parent(childOne)])
        {
            heap[childOne] = heap[ parent(childOne) ];
            childOne = parent(childOne);
        }                   
        heap[childOne] = temp;
    }
 

    private void heapDown(int one)
    {
        int child;
        int temp = heap[ one ];
        while (kthChild(one, 1) < heapSize)
        {
            child = minChild(one);
            if (heap[child] < temp)
                heap[one] = heap[child];
            else
                break;
            one = child;
        }
        heap[one] = temp;
    }
 
 
    private int minChild(int one) 
    {
        int bestChild = kthChild(one, 1);
        int k = 2;
        int pos = kthChild(one, k);
        while ((k <= d) && (pos < heapSize)) 
        {
            if (heap[pos] < heap[bestChild]) 
                bestChild = pos;
            pos = kthChild(one, k++);
        }    
        return bestChild;
    }
 

    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }     
}