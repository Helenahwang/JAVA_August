package streamtest;

public class Student {
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	private String name;
	private String gender;
	private int score;
	private int age;
	private String subject;
	
	
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getScore() {
		return score;
	}
	public int getAge() {
		return age;
	}
	public String getSubject() {
		return subject;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", score=" + score + ", age=" + age + ", subject="
				+ subject + "]";
	}
	public Student(String name, String gender, int score, int age, String subject) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.age = age;
		this.subject = subject;
	}
	

}
