package hackerrank.codewhiz2016;


import java.util.*;

class Student implements Comparable {
    private int token;
    private String fname;
    private double cgpa;

    @Override
    public String toString() {
        return "Student{" +
                "token=" + token +
                ", fname='" + fname + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (token != student.token) return false;
        if (Double.compare(student.cgpa, cgpa) != 0) return false;
        return fname.equals(student.fname);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = token;
        result = 31 * result + fname.hashCode();
        temp = Double.doubleToLongBits(cgpa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Object o) {
        Student that = (Student) o;
        if (this.cgpa > that.cgpa) {
            return -1;
        } else if (this.cgpa < that.cgpa)
            return 1;
        else {
            if (this.fname.compareTo(that.fname) < 0) {
                return -1;
            } else if (this.fname.compareTo(that.fname) > 0) {
                return 1;
            } else {
                if (this.token < that.token)
                    return -1;
                else if (this.token > that.token)
                    return 1;
                else
                    return 0;
            }
        }
    }
}

public class CgpaQueue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SortedSet<Student> queue = new TreeSet<Student>();
        int totalEvents = Integer.parseInt(in.nextLine());
        while (totalEvents > 0) {
            String event = in.nextLine();
            String[] events = event.split(" ");
            if (events[0].equals("ENTER")) {
                Student st = new Student(Integer.parseInt(events[3]), events[1], Double.parseDouble(events[2]));
                queue.add(st);
            } else {
                if(queue.size() > 0)
                    queue.remove(queue.first());
            }
            totalEvents--;
        }
        for (Student st : queue) {
            System.out.println(st.getFname());
        }
        if(queue.size() == 0)
            System.out.println("EMPTY");
    }
}
