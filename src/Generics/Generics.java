package Generics;

// Generic class
  class GetStudent<T> {
    public String getStudent(T registrationNumber) {
        return "done: " + registrationNumber;
    }
}

// Main class (non-public, since only one public class is allowed per file)
class Generics {
    public static void main(String[] args) {
        // Integer type
        GetStudent<Integer> g = new GetStudent<Integer>();
        System.out.println(g.getStudent(101));

        // String type
        GetStudent<String> gs = new GetStudent<String>();
        System.out.println(gs.getStudent("REG123"));
    }
}
