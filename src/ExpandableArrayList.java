
public class ExpandableArrayList<E> implements List<E>
{
	private E[] array;
	private int size;

	public ExpandableArrayList()
	{
		array = (E[]) new Object[16];
		size = 0;
	}


	private void verifyIndex(int i)
	{
		if(i >= size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public E get(int index) 
	{
		verifyIndex(index);

		return array[index];
	}

	public E remove(int index) 
	{
		verifyIndex(index);

		E value = array[index];

		for(int i=index; i < size-1; i++)
		{
			array[i] = array[i+1];
		}
		array[size-1] = null;
		size--;

		return value;
	}


	private void expandArray()
	{
		//Create a temporary array to copy into (this way we do not lose array)
		E[] temp = (E[] ) new Object[array.length * 2];

		//Copy from array to temp
		for(int i=0; i < size; i++)
		{
			temp[i] = array[i];
		}

		//Change the array reference to point to the new array
		array = temp;
	}


	public void add(E v) 
	{
		if(size == array.length)
		{
			expandArray();
		}

		array[size] = v;
		size++;
	}


	public void add(int index, E v) 
	{
		if(index > size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		if(size == array.length)
		{
			expandArray();
		}
		
		if(size == 0)
		{
			add(v);
		}
		else
		{
			for(int i=size-1; i >= index; i--)
			{
				array[i+1] = array[i];
			}
			
			//Insert 
			array[index] = v;
			size++;
		}

	}

	public E set(int index, E v) 
	{
		verifyIndex(index);
		E oldValue = array[index];
		array[index] = v;
		return oldValue;
	}
	

	public int size() 
	{
		return size;
	}
	
	public String toString()
	{
		String r = "[";
		for(int i=0; i < size; i++)
		{
			r += array[i] + " ";
		}
		return r+"]";
	}
}
