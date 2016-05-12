package hqh.clone;

public class K implements Cloneable{
	private int[] i={0,1,2,3};
	private String s;
	private Person p;

	public K(int[] i,String s){		
		this.i=i;
		this.s=s;
		Person p0=new Person("Default",0);
		this.p=p0;
	}
	public K(int[] i,String s,Person p){		
		this.i=i;
		this.s=s;
		this.p=p;
	}
	public K clone() throws CloneNotSupportedException {
		return (K) super.clone();
		//return new K(80);
	}
}
