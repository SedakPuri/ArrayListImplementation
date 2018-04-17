
public interface List<E>
{
	public E get(int index);
	public E remove(int index);
	public void add(E v);
	public void add(int index, E v);
	public E set(int index, E v);
	public int size();
}
