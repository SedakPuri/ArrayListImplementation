
public class ExpandableArrayList<E> implements List<E>{
	private E[] array;
	private int size;

	public ExpandableArrayList() {
		array = (E[]) new Object[16];			//You can not make a generic array
		size = 0;
	}

	@Override
	public void add(E v, int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException();			//If you try to add after the last index!!! 
		}

		if (size == array.length) {
			expandArray();									//If you try to add at array.length
		}

		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];					//Copying left
		}
		array[index] = v;
		size++;
	}

	private void expandArray() {
		E[] temp = (E[]) new Object[2*array.length];
		for(int i = 0; i < size; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}


	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		return array[index];
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E value = array[index];
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i+1];							//Copying right
		}
		
		array[size - 1] = null;
		size--;
		return value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E set(E v, int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E value = array[index];
		array[index] = v;
		return value;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result += array[i] + " ";
		}
		return result;
	}
}
