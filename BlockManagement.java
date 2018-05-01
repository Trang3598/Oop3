package Bt3_Oop;

import java.util.Scanner;

public class BlockManagement {

	public static void main(String[] args) {

		int option, size;
		String confirm;
		String identityCardNo;
		Person person = null;
		Household[] households = null;
		Household[] householdsLatest = null;
		Scanner scannerInt = new Scanner(System.in);
		Scanner scannerStr = new Scanner(System.in);

		BlockManagement blockManagement = new BlockManagement();
		do {
			blockManagement.showMenu();
			System.out.println("Please select an option above");
			option = scannerInt.nextInt();
			switch (option) {
			case 1: {
				System.out.println("How many households are there in your block?");
				do {
					size = scannerInt.nextInt();
					if (size <= 0) {
						System.out.println("The value of size bigger zero! Please enter again size: ");
					}
				} while (size <= 0);
				householdsLatest = blockManagement.enterHouseholds(households, size);

				break;
			}
			case 2: {
				if (householdsLatest != null) {
					blockManagement.displayHouseholds(householdsLatest);
				} else {
					System.out.println("You have to add households previous this function!");
				}
				break;
			}
			case 3: {
				do {
					System.out.println("You enter identity your expect: ");
					identityCardNo = scannerStr.nextLine();
					if (householdsLatest != null) {
						person = blockManagement.searchPersonByIdentify(householdsLatest, identityCardNo);
						if (person != null) {
							blockManagement.displayPerson(person);
						} else {
							System.out.println("The" + identityCardNo + " is not in the system!");
						}
					} else {
						System.out.println("You have to add households previous this function!");
						break;
					}
					System.out.println("Do you want to search other person in households? Y or N: ");
					confirm = scannerStr.nextLine();
				} while (!confirm.equalsIgnoreCase("N"));
				break;
			}
			case 0: {
				break;
			}

			default: {
				System.out.println("The value " + option + "is not function of application. Please try again!");
				break;
			}

			}
		} while (option != 0);
	}

	// This is method to display menu
	private void showMenu() {
		System.out.println("Enter 1: To enter Household: ");
		System.out.println("Enter 2: To display Household: ");
		System.out.println("Enter 3: To search member by Identity Card No: ");
		System.out.println("Enter 0: To exit: ");
	}

	// This is method to search person by identify care no
	private Person searchPersonByIdentify(Household[] households, String identifyCardNo) {
		Person[] persons;
		for (Household household : households) {
			persons = household.getPersonList();
			if (persons != null) {
				for (Person person : persons) {
					if (identifyCardNo.equalsIgnoreCase(person.getIdentityCardNo())) {
						return person;
					}
				}
			}
		}
		return null;
	}

	// This is method to display households
	private void displayHouseholds(Household[] households) {
		int element = 0;
		for (Household household : households) {
			System.out.println("This is information of households element " + (++element));
			System.out.println("Number house: " + household.getNumberHouse());
			System.out.println("Number member: " + household.getNumberMember());
			this.displayPersons(household.getPersonList());
			System.out.println("===============================================");
		}
	}

	// This is method to display persons
	private void displayPersons(Person[] persons) {
		int element = 0;
		for (Person person : persons) {
			System.out.println("This is information of person element " + (++element) + " in family");
			this.displayPerson(person);
		}
	}

	// This is method to display only one person
	private void displayPerson(Person person) {
		System.out.println("\tIdentify care no: " + person.getIdentityCardNo());
		System.out.println("\tFull name: " + person.getFullName());
		System.out.println("\tAge: " + person.getAge());
		System.out.println("\tDOB: " + person.getDOB());
		System.out.println("\tJob: " + person.getJob());
	}

	// This is method to enter household list
	private Household[] enterHouseholds(Household[] households, int size) {
		households = new Household[size];
		for (int i = 0; i < households.length; i++) {
			households[i] = this.enterHousehold(i + 1);
		}

		return households;
	}

	// This is method to enter only one household
	private Household enterHousehold(int element) {
		int houseNumber, memberNumber;
		Person[] persons = null;
		Person[] personsTemp = null;
		Scanner scannerStr = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
		Household household = new Household();

		System.out.println("Enter house number of element[" + element + "]: ");
		houseNumber = scannerInt.nextInt();
		household.setNumberHouse(houseNumber);
		System.out.println("Enter member number in family: ");
		memberNumber = scannerInt.nextInt();
		household.setNumberMember(memberNumber);
		personsTemp = this.enterPersons(persons, memberNumber);
		household.setPersonList(personsTemp);

		return household;
	}

	// This is method to enter only one person
	private Person enterPerson() {
		Scanner scannerStr = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
		Person person = new Person();

		System.out.println("Enter identity card no: ");
		person.setIdentityCardNo(scannerStr.nextLine());
		System.out.println("Enter full name: ");
		person.setFullName(scannerStr.nextLine());
		System.out.println("Enter age: ");
		person.setAge(scannerInt.nextInt());
		System.out.println("Enter date of birth: ");
		person.setDOB(scannerStr.nextLine());
		System.out.println("Enter job: ");
		person.setJob(scannerStr.nextLine());

		return person;
	}

	// This is method to enter person list
	private Person[] enterPersons(Person[] persons, int size) {
		persons = new Person[size];
		int element = 0;
		for (int i = 0; i < persons.length; i++) {
			System.out.println("\nPlease enter value of element " + ++element);
			persons[i] = this.enterPerson();
		}

		return persons;
	}

}
