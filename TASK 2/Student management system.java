import java.util.*;
class Student {
    private String id,name;
    private int marks;
    Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public String getId() {
        return id;
    }
    public int getMarks() {
        return marks;
    }
    public String getName() {
        return name;
    }
    public String getRole(){
        return "undergrad";
    }
    @Override // is good for specification
    public String toString(){
        return id+" "+name+"("+marks+")" +getRole();
    }
    public String report(){
        return id+" "+marks;
    }
}
class GraduteStudnet extends Student{
    private String area;
    GraduteStudnet(String id, String name, int marks, String area){
        super(id, name, marks);
        this.area = area;
    }
    @Override
    public String getRole(){
        return "Grad"+"("+area+")";
    }

}
class Repository<T>{
    private Map<String, T> map=new HashMap<>();
    public void save(String id,T obj){
        map.put(id,obj);
    }
    public T find(String id){
        return map.get(id);
    }
    public void delete(String id){
        map.remove(id);
    }
}
class Teacher {
    private String id;
    private String name;
    private String subject;
    private String dept;
    Teacher(String id, String name, String subject, String dept) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.dept = dept;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSubject() {
        return subject;
    }
    public String getDept() {
        return dept;
    }
    @Override
    public String toString() {
        return id+"("+name+")"+"("+subject+")"+"("+dept+")";
    }
}
public class Main {
    public static void main(String[] args) {
            List<Student> list=new ArrayList<>();
            list.add(new Student("1","Bruce",88));
            list.add(new Student("2","Peter",99));
            list.add(new Student("3","Pamela",90));
            list.add(new Student("4","Jin",70));
            list.add(new GraduteStudnet("5","Patricia",90,"AIML"));

            Repository<Student> repo=new Repository<>();
            for (Student s:list){
                repo.save(s.getId(),s);
        }
            list.forEach(System.out::println);
//          getting report
        System.out.println("Report for student");
        for(Student s:list){
            System.out.println(s.report());
        }
        System.out.println("Retriving Studnet id 1");
        System.out.println(repo.find("1"));
        System.out.println("Deleting Studnet id 2");
        list.remove(repo.find("2"));
        repo.delete("2");
        System.out.println("After deletion");
        list.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------");
        List<Teacher> list1=new ArrayList<>();
        list1.add(new Teacher("1","Snape","DSA","CSE"));
        list1.add(new Teacher("2","Patricia","OS","CSE"));
        list1.add(new Teacher("3","Pamela","Bussiness Analysis","BBA"));
        list1.add(new Teacher("4","Harry","Human Behaviour","Psychology"));
        Repository<Teacher> repo1=new Repository<>();
        for(Teacher s:list1){
            repo1.save(s.getId(),s);
        }
        System.out.println("Teachers");
        list1.forEach(System.out::println);

        System.out.println("Retriving Teacher id 1");
        System.out.println(repo1.find("1"));
        System.out.println("Deleting Teacher id 2");
        list1.remove(repo1.find("2"));
        repo1.delete("2");
        System.out.println("After deletion");

        list1.forEach(System.out::println);
    }
}