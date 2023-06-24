import java.util.*;

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        int sum = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));

        while (!queue.isEmpty()) {
            Employee em = queue.poll();
            sum += em.importance;
            for (int sub : em.subordinates) {
                queue.offer(map.get(sub));
            }
        }
        return sum;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
