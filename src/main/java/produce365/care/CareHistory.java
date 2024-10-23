package produce365.care;

import java.sql.Date;
import produce365.trainee.Trainee;

public class CareHistory {
	
	private int idx;
	private Date careDate;
	private Care care;
	private Trainee trainee;
	
	public CareHistory() {}

	public CareHistory(int idx, Date careDate, Care care, Trainee trainee) {
		super();
		this.idx = idx;
		this.careDate = careDate;
		this.care = care;
		this.trainee = trainee;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getCareDate() {
		return careDate;
	}

	public void setCareDate(Date careDate) {
		this.careDate = careDate;
	}

	public Care getCare() {
		return care;
	}

	public void setCare(Care care) {
		this.care = care;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "➤ 날짜: " + this.careDate + " ➤ 종류: " + this.care.getCategory() + " ➤ 연습생: " + this.trainee.getName();

	}
}