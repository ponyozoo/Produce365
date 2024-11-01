package produce365.debut;

import java.sql.Date;

public class Debut {

	private int id;
	private String name;
	private int memberCount;
	private String concept;
	private String grade;
	private Date debutDate;
	private String photo;
	
	
	public Debut() {
	}
	
	public Debut(int id) {
		this.id = id;
	}

	public Debut(int id, String name, int memberCount, String concept, String grade, Date debutDate, String photo) {
		this.id = id;
		this.name = name;
		this.memberCount = memberCount;
		this.concept = concept;
		this.grade = grade;
		this.debutDate = debutDate;
		this.photo = photo;
	}
	
	
	
	public Debut(String name, int memberCount, String concept, String grade, Date debutDate, int id) {
		this.name = name;
		this.memberCount = memberCount;
		this.concept = concept;
		this.grade = grade;
		this.debutDate = debutDate;
		this.id = id;
	}

	public Debut(String photo) {
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

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDebutDate() {
		return debutDate;
	}

	public void setDebutDate(Date debutDate) {
		this.debutDate = debutDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	@Override
	public String toString() {
		return "Debut [id=" + id + ", name=" + name + ", memberCount=" + memberCount + ", concept=" + concept
				+ ", grade=" + grade + ", debutDate=" + debutDate + ", photo=" + photo + "]";
	}

	
	
	
	
	
	
}
