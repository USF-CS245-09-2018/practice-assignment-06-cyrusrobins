public class ArrayStack implements Stack{
    private Object[] arr = new Object[10]; //the array of items
    private int top = -1; //keeps track of the newest item in the array

    public void grow_array(){
        Object[] newArr = new Object[arr.length*2]; //double the size of the array
        for(int i=0;i<top+1;i++){
            newArr[i] = arr[i]; //copy all of the items from the old array to the new one
        }
        arr = newArr; //set the instance variable array to be our new array
    }

    public void push(Object obj){
        if(top+1>=arr.length) //if there's no more room to add to the array, grow its size
            grow_array();
        arr[++top] = obj; //set the array at the next point to the object while incrementing top
    }

    public Object pop(){
        if(empty()) //if there's nothing to return, return null
            return null;
        return arr[top--]; //return the object at the top and then decrement the top
    }

    public Object peek(){
        if(empty()) //if there's nothing to see, return null
            return null;
        return arr[top]; //return the object at the top but don't decrement top
    }
    public boolean empty(){
        if(top<0) //if there's nothing in the array return true
            return true;
        return false;
    }

}
