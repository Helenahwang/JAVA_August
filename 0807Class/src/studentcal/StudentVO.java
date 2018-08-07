package studentcal;

public class StudentVO {

	//테이블의 각 컬럼의 값들을 저장하기 위해서 생성
	private int num;
	private String name;
	private String major;
	private int score;
	private int age;
	private String gender;
	
	//인스턴스 생성을 할 때 데이터를 바로 대입해서 생성하면 메소드 호출횟수를 줄일 수 있기 때문에 생성
	public StudentVO() {
		super();
	}

	public StudentVO(int num, String name, String major, int score, int age, String gender) {
		super();
		this.num = num;
		this.name = name;
		this.major = major;
		this.score = score;
		this.age = age;
		this.gender = gender;
	}

	//인스턴스 변수를 private으로 생성했기 때문에, 인스턴스가 바로 사용할 수 없어서 인스턴스 변수를 사용하기 위한 메소드
	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getScore() {
		return score;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//데이터를 빠르게 확인하기 위해서  - 디버깅을 위해서
	@Override
	public String toString() {
		return "StudentVO [num=" + num + ", name=" + name + ", major=" + major + ", score=" + score + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
	
	
	
	
}
