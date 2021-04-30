package kodlamaIo;

public class InstructorManager {
	public void add3(Instructor instructor) {
		String mesaj1 = instructor.id + " " + instructor.courseNumber + " Kaydedildi.";
		System.out.println(mesaj1);
	}

	public void add3Multiple(Instructor[] instructors) {
		for (Instructor instructor : instructors) {
			add3(instructor);
		}
	}

}
