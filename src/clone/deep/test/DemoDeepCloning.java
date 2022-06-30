package clone.deep.test;

class Address implements Cloneable{
	private String houseNo;
	private String city;
	private String state;

	public Address(String houseNo, String city, String state) {
		this.houseNo = houseNo;
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return "\nHouse NO ="+houseNo+"\nCity ="+city+"\nState="+state;
	}
	@Override
	protected Address clone() throws CloneNotSupportedException {
		return (Address) super.clone();
	}
}

class Employee implements Cloneable{
	private Integer id;
	private String empName;
	Address add;

	public Employee(Integer id, String empName, Address add) {
		this.id = id;
		this.empName = empName;
		this.add = add;
	}

	@Override
	public String toString() {

		return "id=" + id + "\nname=" + empName + "\naddress=" + add;
	}
	
	@Override
	protected Employee clone() throws CloneNotSupportedException {
		Employee emp = (Employee) super.clone();
		emp.add = this.add.clone();
		return emp;
	}
}

public class DemoDeepCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("---------------Deep Clonning-----------------------");
		
		Employee emp = new Employee(1, "Ram", new Address("AS12","BBSR","ODISHA"));
		System.out.println(emp);
		System.out.println(emp.hashCode());
		
		System.out.println("---------------After Cloning-----------------------");
		Employee emp1 = (Employee) emp.clone();
		System.out.println(emp1);
		System.out.println(emp1.hashCode());

		
		if(emp.add == emp1.add){
			System.out.println("----------Shallow Clonning Process------------------");
		}else{
			System.out.println("----------Deep Clonning Process------------------");
		}
		
		// Hashcode of ref variable of Address is different of Deep Cloning
		System.out.println("Hashcode Of Address for Original Employee Object = "+ emp.add.hashCode());
		System.out.println("Hashcode Of Address for Clone Employee Object = "+ emp1.add.hashCode());

		
		
	}

}
