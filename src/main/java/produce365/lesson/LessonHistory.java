package produce365.lesson;

import java.sql.Date;

import produce365.trainee.Trainee;

public class LessonHistory {
	
	private int idx;
	private Date lessonDate;
	private Lesson lesson;
	private Trainee trainee;
	
	public LessonHistory(Date lessonDate, Lesson lesson, Trainee trainee) {
		this.lessonDate = lessonDate;
		this.lesson = lesson;
		this.trainee = trainee;
	}

	public LessonHistory(Date lessonDate) {
		this.lessonDate = lessonDate;
	}

	public LessonHistory(int idx, Date lessonDate, Lesson lesson, Trainee trainee) {
		this.idx = idx;
		this.lessonDate = lessonDate;
		this.lesson = lesson;
		this.trainee = trainee;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getLessonDate() {
		return lessonDate;
	}

	public void setLessonDate(Date lessonDate) {
		this.lessonDate = lessonDate;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "LessonHistory [idx=" + idx + ", lessonDate=" + lessonDate + ", lesson=" + lesson + ", trainee="
				+ trainee + "]";
	}
}
