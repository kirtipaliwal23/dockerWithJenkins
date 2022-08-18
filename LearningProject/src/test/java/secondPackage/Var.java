package secondPackage;

public class Var {
	// instance variables
	String name;
	String address;

	// static/class variables
	static String city;
	static int j;

	// static block: used to define static variables together
	static {
		city = "Delhi";
		j = 0;
	}

	// constructor
	Var(String N, String A) {
		this.name = N;
		this.address = A;
	}

	// static/class method : Will only accept static variables

	public static void getCity() {
		System.out.println(city);
	}

	// non static method

	public void getDetails() {
		System.out.println(name + "" + address + "" + city);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Var obj = new Var("Raman", "Rohini");
		Var obj2 = new Var("Rohan", "VasantKunj");
		obj.getDetails();
		obj2.getDetails();

		getCity();
		j = 1;
		System.out.println("value of j " + j);
	}

}
