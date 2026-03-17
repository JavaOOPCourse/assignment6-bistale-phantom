import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        students.put("0001", new Student("Kasym", 3.6, 20));
        students.put("0002", new Student("Eldiyar", 3.1, 17));
        students.put("0003", new Student("Kutman", 3.0, 19));
        students.put("0004", new Student("Nazik", 4.0, 18));
        students.put("0005", new Student("Akyl", 4.0, 21));


        // TODO: Напечатай всех студентов (ID + объект)
        for(HashMap.Entry<String, Student> student : students.entrySet()) {
            System.out.println("ID: " + student.getKey() + " " + student.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        System.out.println("Enter ID: ");
        String id = sc.nextLine();
        for (HashMap.Entry<String, Student> student : students.entrySet()) {
            if (student.getKey().equals(id)) {
                System.out.println("ID: " + student.getKey() + " " + student.getValue());
            }
        }

        // TODO: Удали одного студента по ID
        System.out.println("Enter ID: ");
        String id2 = sc.nextLine();
        for (HashMap.Entry<String, Student> student : students.entrySet()) {
            if (student.getKey().equals(id2)) {
                students.remove(id2);
                System.out.println(students.size());
                break;
            }
        }


        // TODO: Обнови GPA у одного студента
        System.out.println("Enter ID: ");
        String id3 = sc.nextLine();
        System.out.println("Enetr new GPA: ");
        double g = sc.nextDouble();
        sc.nextLine();
        for (HashMap.Entry<String, Student> student : students.entrySet()) {
            if (student.getKey().equals(id3)) {
                student.getValue().setGpa(g);
                System.out.println(student);
                break;
            }
        }

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> students2 = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(students2);
        System.out.println("Sorted by GPA:");
        for(Student s : students2) {
            System.out.println(s);
        }

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        students2.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted by name:");
        for(Student s : students2) {
            System.out.println(s);
        }

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        ArrayList<Student> students3 = new ArrayList<>();
        students3.add(new Student("John", 3.5, 21));
        students3.add(new Student("Sam", 3.4, 22));
        students3.add(new Student("Sarah", 3.7, 20));
        students3.add(new Student("Jessica", 3.5, 20));
        students3.add(new Student("Nathan", 4.0, 19));
        students3.sort(Comparator.comparing(Student::getGpa).reversed());
        for(int i = 0; i < 3; i++) {
            System.out.println(students3.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaMap = new HashMap<>();

        for(Student s : students3) {
            double gpa = s.getGpa();
            if (!gpaMap.containsKey(gpa)) {
                gpaMap.put(gpa, new ArrayList<>());
            }
            gpaMap.get(gpa).add(s.getName());
        }

        for(Map.Entry<Double, List<String>> stat : gpaMap.entrySet()) {
            System.out.println("GPA " + stat.getKey() + " -> " + stat.getValue());
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course calculus = new Course("Calculus");
        Course softwareEngineering = new Course("Software Engineering");

        courseMap.put(calculus, new ArrayList<>());
        courseMap.put(softwareEngineering, new ArrayList<>());
        courseMap.get(calculus).add(new Student("John", 3.5, 21));
        courseMap.get(calculus).add(new Student("Sam", 3.4, 22));
        courseMap.get(softwareEngineering).add(new Student("Sarah", 3.7, 20));
        courseMap.get(softwareEngineering).add(new Student("Jessica", 3.5, 20));
        courseMap.get(softwareEngineering).add(new Student("Nathan", 4.0, 19));

        for(Map.Entry<Course, List<Student>> info : courseMap.entrySet()) {
            System.out.println(info.getKey());

            for(Student s : info.getValue()) {
                System.out.println(s);
            }
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        ArrayList<Student> students4 = new ArrayList<>();
        students4.add(new Student("John", 3.5, 21));
        students4.add(new Student("Sam", 3.4, 22));
        students4.add(new Student("Sarah", 3.7, 20));
        students4.add(new Student("Jessica", 3.5, 20));
        students4.add(new Student("Nathan", 4.0, 19));

        students4.sort(Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName));

        for(Student s : students4) {
            System.out.println(s);
        }
    }
}




