package produce365.trainee;

import java.sql.Date;

public class Trainee {

	private int id;
	private String name;
	private String sex;
	private Date birth;
	private String nationality;
	private int height;
	private int weight;
	private Date hireDate;
	private String photo;

	public Trainee() {}

	public Trainee(int id) {
		this.id = id;
	}

	public Trainee(String name) {
		this.name = name;
	}
	
	public Trainee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Trainee(int id, String name, String nationality, int height, int weight) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.height = height;
		this.weight = weight;
	}

	public Trainee(int id, String name, String sex, Date birth, String nationality, int height, int weight, Date hireDate, String photo) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.nationality = nationality;
		this.height = height;
		this.weight = weight;
		this.hireDate = hireDate;
		this.photo = photo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", sex=" + sex + ", birth=" + birth + ", nationality="
				+ nationality + ", height=" + height + ", weight=" + weight + ", hireDate=" + hireDate + ", photo="
				+ photo + "]";
	}

}