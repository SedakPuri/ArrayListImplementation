
public class Driver 
{
	public static void main(String[] args)
	{
		List<Integer> l = new ExpandableArrayList<>();
		System.out.println(l);
		
		l.add(0, 9);
		System.out.println(l);
		
		l.add(0, 2);
		System.out.println(l);
		
		l.add(l.size(), 4);
		System.out.println(l);
		
		l.remove(2);
		
		System.out.println(l);
		l.set(1, 5);
		
		System.out.println(l);
		for(int i=0; i < 10000; i++)
		{
			l.add(i);
		}
		System.out.println(l);

		
		
	}

}
