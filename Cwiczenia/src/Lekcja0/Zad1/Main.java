package Lekcja0.Zad1;

public class Main {
    public static void main(String args[]) throws TooManyStudentsException{

        Person p1 = new Person("Jan", 50);
        Student s1 = new Student("Jasiek", 20);
        Person p3 = (Person)s1;

        p1.sayHelloTo(p3); //Hi Jasiek!
        p3.sayHelloTo(p1); //Hi Jan!

        Subject s = new Subject("GUI");
        s.setTeacher(p1);

        try {
            s.addStudent(s1);
        } catch(TooManyStudentsException e) {
            e.printStackTrace();

        }

        System.out.println(s); //GUI, teacher: Jan, students: Jasiek

    }
}
class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name=name;
        this.age=age;
    }
    void sayHelloTo(Person person){
        System.out.println("Hello "+person.name);
    }
}
class Student
    extends Person{
        Student(String name, int age){
            super(name,age);
        }
}
class Subject{
    String subject;
    Person teacher;
    Student[] listOfStudents=new Student[10];
    int numberOfStudents=10;
    Subject(String subject){
        this.subject=subject;
    }
    void setTeacher(Person person){
        teacher=person;

    }
    void addStudent(Student student) throws TooManyStudentsException{
        System.out.println(numberOfStudents);
        if (numberOfStudents>=listOfStudents.length) throw new TooManyStudentsException("Too many students");
        else {
            listOfStudents[numberOfStudents]=student;
            numberOfStudents++;

        }

    }
    public String toString(){
        return "Subject: "+this.subject+" ";
    }

}
class TooManyStudentsException extends Exception{
    TooManyStudentsException(String exception){
        super(exception);
    }
}