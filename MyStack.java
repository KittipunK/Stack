import java.util.NoSuchElementException;

public class MyStack implements IStack {
	// add any necessary variables here
    private Object[] data = new Object[10];
    private int size=0;


	@Override
	public void push(Object item) {
        if(this.size==this.data.length){
            Object[] newData = new Object[this.size+1];
            for(int i = 0; i < this.data.length; i++){
                newData[i] = this.data[i];
            }
            this.data = newData;
        }

        for(int j = 0; j < this.size; j++){
            this.data[this.size-j] = this.data[this.size-j-1];
        }
        this.data[0] = item;
        this.size++;
	}

	@Override
	public Object pop() {
        if(this.size <= 0){ throw new NoSuchElementException(); }
        Object item = this.data[0];

        for(int i = 1; i < this.size; i++){
            this.data[i-1] = this.data[i];
        }
        this.size--;

        return item;
	}

	@Override
	public Object peek() {
        if(this.size<=0){ throw new NoSuchElementException(); }
        return this.data[0];
	}

	@Override
	public int indexOf(Object item) {
        int index = -1;
        for(int i = 0; i < this.size; i++){
            if(this.data[i]==item){
                index = i;
            }
        }
        return index;
	}

	@Override
	public int size() {
        return this.size;
	}

	@Override
	public boolean isEmpty() {
        return this.size<=0;
	}

	// add any necessary methods or classes below
}
