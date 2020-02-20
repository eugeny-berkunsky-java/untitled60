package demo2002.main;

import demo2002.logic.Student;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        List<Student> students = createList();
        printCollection(students);
        System.out.println("--------------------------------");
        List<Student> firstKurs = select1k(students);
        printCollection(firstKurs);
        System.out.println("--------------------------------");
        List<Student> byGroup = selectByGroup(students, "3151");
        printCollection(byGroup);
        System.out.println("--------------------------------");
        List<Student> list2 = filter(students, s -> "3151".equals(s.getGroup()));
        printCollection(list2);

        Set<String> names = fillNames(students);
        printCollection(names);
        System.out.println("---------------------------------");
        Map<String, Integer> map = countStudentsByGroupV2(students);
//        System.out.println(map);
        printCollection(map.entrySet());
        System.out.println("----------------------------------");
        students.sort(
                Comparator
                        .comparing(Student::getGroup).reversed()
                        .thenComparing(Student::getName)
                        .thenComparingInt(Student::getId));
        printCollection(students);

        students.sort(Comparator.naturalOrder());
    }

    private Map<String, Integer> countStudentsByGroup(List<Student> students) {
        Map<String, Integer> res = new HashMap<>();
        for (Student student : students) {
            String group = student.getGroup();
            Integer k = res.get(group);
            if (k == null) k = 0;
            res.put(group, k + 1);
        }
        return res;
    }

    private Map<String, Integer> countStudentsByGroupV2(List<Student> students) {
        Map<String, Integer> res = new HashMap<>();
        for (Student student : students) {
            String group = student.getGroup();
            res.merge(group, 1, Integer::sum);
        }
        return res;
    }

    private Set<String> fillNames(List<Student> students) {
        Set<String> res = new HashSet<>();
        for (Student student : students) {
            res.add(student.getName());
        }
        return res;
    }

    private List<Student> filter(List<Student> students, Predicate<Student> p) {
        List<Student> res = new ArrayList<>();
        for (Student s : students) {
            if (p.test(s)) {
                res.add(s);
            }
        }
        return res;
    }

    private List<Student> selectByGroup(List<Student> students, String group) {
        List<Student> res = new ArrayList<>();
        for (Student s : students) {
            if (Objects.equals(group, s.getGroup())) {
                res.add(s);
            }
        }
        return res;
    }

    private List<Student> select1k(List<Student> students) {
        List<Student> res = new ArrayList<>();
        for (Student s : students) {
            if (s.getKurs() == 1) {
                res.add(s);
            }
        }
        return res;
    }

    private void printCollection(Collection<?> objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    private List<Student> createList() {
        return new ArrayList<>(
                Arrays.asList(
                        new Student(1, "Ivanova", 1, "1111"),
                        new Student(2, "Petrov", 1, "1144"),
                        new Student(3, "Ivanov", 2, "2141"),
                        new Student(4, "Kotov", 3, "3151"),
                        new Student(5, "Kotovsky", 2, "2151"),
                        new Student(8, "Kotovs", 2, "2151"),
                        new Student(9, "Kotovsky", 2, "2151"),
                        new Student(10, "Kotovsky", 2, "2151"),
                        new Student(6, "Semenov", 3, "3151"),
                        new Student(7, "Ivanov", 2, "2141")
                )
        );
    }
}
