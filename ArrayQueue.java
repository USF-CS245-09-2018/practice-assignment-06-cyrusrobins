public class ArrayQueue implements Queue {

    private Object[] arr = new Object[10]; //the array of items
    private int head = -1; //keeps track of the oldest item in the array
    private int tail = -1; //keeps track of the newest item in the array
    private int numItems = 0; //keeps track of the number of items in the array

    public void grow_array(){
        Object[] newArr = new Object[arr.length*2]; //create an array twice as large as the previous one
        for(int i=0;i<arr.length;i++){
            newArr[i] = arr[(head+i)%arr.length]; //copy objects from the previous array to this one
        }
        head = 0; //reset the head
        tail = arr.length; //set the tail to be at the end of the existing data
        arr = newArr; //set the instance variable array to be the new array
    }

    public boolean empty(){
        if(numItems==0) //if there are no items in the array return true
            return true;
        return false; //otherwise return false
    }

    public void enqueue(Object obj){
        if(empty()){ //if there's nothing in the array
            head++; //move both the head and tail up
            arr[++tail] = obj; //set the array at the position of the head and tail to the object
            numItems++; //increment the number of items
        }
        else {
            tail = (tail+1)%arr.length; //move the tail by one acknowledging that it might have to loop to the other side of the array
            if (tail == head) //if there is no more free real estate in the array
                grow_array(); //grow the size of the array
            arr[tail] = obj; //set the new tail of the array to be the object
            numItems++; //increment the number of items
        }
    }

    public Object dequeue(){
        if(empty()) //if there's nothing there, return null
            return null;
        Object obj = arr[head]; //store the item at head
        head = (head+1)%arr.length; //move the head up acknowledging that it might loop to the other side of the arrayu
        if(--numItems==0){ //if the array would be empty after removing this item
            head = -1; //reset these values to their default
            tail = -1;
        }
        return obj; //return the object
    }
}
