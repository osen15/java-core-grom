package lesson8.course;




public class Demo {
   Student createHighestParent() {
       Course[] coursesTaken = new Course[3];
       Student student = new Student("Oleg", "Sen", 3, coursesTaken);
       return  student;
    }
    SpecialStudent createLowestChild() {
        Course[] coursesTaken = new Course[3];
       SpecialStudent specialStudent = new SpecialStudent("Oleg", "Sen", 2, coursesTaken,1213312313, "GM");
       return  specialStudent;
    }


}
