import java.util.*;

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int sum = 0;
        while (!queue.isEmpty()) {
            Employee cur = queue.poll();
            sum += cur.importance;
            for (int sub : cur.subordinates) {
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
