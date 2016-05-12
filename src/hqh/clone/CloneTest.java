package hqh.clone;

import java.util.ArrayList;

public class CloneTest {

	public static void main(String[] args) {
		ArrayList<K> list1=new ArrayList<K>();
		K t1=new K(10);
		list1.add(t1);
		ArrayList<K> list2=(ArrayList<K>) list1.clone();
		ArrayList<K> list3=new ArrayList<K>();
		list3.add(t1);
		
		System.out.println(list2==list1);//不是一个对象
		System.out.println(list1.getClass().toString());
		System.out.println(list1.clone().getClass().toString());

	}

}
