package chb06.lx.mytest.q2;

public class Dog extends Pet {
	private String stratin;
	public Dog(String stratin,String name){
		
	}
	public String getStratin() {
		return stratin;
	}

	public void setStratin(String stratin) {
		this.stratin = stratin;
	}
public String toString(){
		return this.getName()+"\t"+this.getStratin();
}
}
