package kodlamaIo;

public class StudentManager {
	public void add2(Student student) {
		System.out.println(student.studentNumber + " Kaydedildi.");
	}

	public void add2Multiple(Student[] students) {
		for (Student student : students) {

			add2(student);
		}
	}

}
