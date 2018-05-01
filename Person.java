package Bt3_Oop;

public class Person {
	private String identityCardNo;
	private String fullName;
	private int age;
	private String DOB;
	private String job;

	public Person() {
		super();
	}

	public Person(String identityCardNo, String fullName, int age, String dOB, String job) {
		super();
		this.identityCardNo = identityCardNo;
		this.fullName = fullName;
		this.age = age;
		this.DOB = dOB;
		this.job = job;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
