package produce365.trainee;

import java.sql.Date;

public class Trainee {

	private int id;
	private String name;
	private Date birth;
	private String sex;
	private int height;
	private int weight;
	private String nationality;
	private Date hireDate;
	private String photo;

	public Trainee() {}

	public Trainee(int id) {
		this.id = id;
	}

	public Trainee(String name) {
		this.name = name;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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
		return "Trainee [id=" + id + ", name=" + name + ", birth=" + birth + ", sex=" + sex + ", height=" + height
				+ ", weight=" + weight + ", nationality=" + nationality + ", hireDate=" + hireDate + ", photo=" + photo
				+ "]";
	}

}
