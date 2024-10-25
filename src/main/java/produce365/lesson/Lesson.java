package produce365.lesson;

public class Lesson {
	private int id;
	private String trainer;
	private String subject;
	private int time;

	public Lesson() {
	}
	public Lesson(int id) {
		super();
		this.id = id;
	}
	public Lesson(String subject) {
		super();
		this.subject = subject;
	}
	public Lesson(int id, String trainer, String subject, int time) {
		super();
		this.id = id;
		this.trainer = trainer;
		this.subject = subject;
		this.time = time;
	}
	public Lesson(String trainer, String subject, int time) {
		super();
		this.trainer = trainer;
		this.subject = subject;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", trainer=" + trainer + ", subject=" + subject + ", time=" + time + "]";
	}

}
