package Bt3_Oop;

public class Household {
	private int numberHouse;
	private int numberMember;
	private Person[] personList;
	
	public Household() {
		super();
	}

	public Household(int numberMember, int numberHouse, Person[] personList) {
		super();
		this.numberMember = numberMember;
		this.numberHouse = numberHouse;
		this.personList = personList;
	}

	public int getNumberMember() {
		return numberMember;
	}

	public void setNumberMember(int numberMember) {
		this.numberMember = numberMember;
	}

	public int getNumberHouse() {
		return numberHouse;
	}

	public void setNumberHouse(int numberHouse) {
		this.numberHouse = numberHouse;
	}

	public Person[] getPersonList() {
		return personList;
	}

	public void setPersonList(Person[] personList) {
		this.personList = personList;
	}
	
}
