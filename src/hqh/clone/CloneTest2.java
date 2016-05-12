package hqh.clone;

public class CloneTest2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1=new Person("John",22);
		K k1=new K(new int[]{5,5,5},"Hello",p1);
		K kTemp=new K(new int[]{5,5,5},"Hello");
		K temp=kTemp.clone();
		System.out.println(k1);
		System.out.println(k1.clone());		
		System.out.println(k1.getClass());

		System.out.println(k1==k1.clone());
		System.out.println(k1.equals(k1.clone()));
		System.out.println(k1.getClass()==k1.clone().getClass());
	}

}
