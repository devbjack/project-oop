package RAYYAN;
public class Main {
    public static void main(String[] args) {
        SchoolManagement sm = new SchoolManagement("abc", "address", 057, "English");

        sm.addClassroom(new Classroom(101, "Introduction", 501, 0, 101));
        sm.addEmployee(new Teacher(501, "Dudung", 50, 801));
        sm.addEmployee(new SupportStaff(601, "Dadang", 10, 802));

        
    }
}
