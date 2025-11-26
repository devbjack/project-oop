package RAYYAN;
public class Main {
    public static void main(String[] args) {
        SchoolManagement sm = new SchoolManagement("abc", "address", 057, "English");

        // Auditorium
        // Playground
        // Classroom
        Classroom[] classes = {
            new Classroom(101, "Intro", 501, 0, 101),
            new Classroom(102, "Intermediate", 502,0,  102)
        };
        
        // Labs
        // Staffs
        Employee[] staffs = {
            new Teacher(501, "Dudung", 100, 801),
            new Teacher(502, "Diding", 150, 802),
            new SupportStaff(601, "Dadang", 10, 801),
            new Teacher(504, "Bahlil", 100, 803)
        };
        // Notice Boards
        NoticeBoard nb = new NoticeBoard();
        nb.setNewsList("Welcome to the School");

        // init
        sm.initialize(nb, staffs, classes);
        
        System.out.println(sm.schoolDetails());
        sm.runSchool();

        

        

    }
}
