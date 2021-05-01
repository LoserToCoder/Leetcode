package com.leetcode.map;

import java.util.*;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }



    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for(Employee employee:employees){
            employeeMap.put(employee.id, employee);
        }
        int ret =0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        while (!queue.isEmpty()){

            Integer employeeId = queue.poll();
            Employee employee = employeeMap.get(employeeId);
            if(employee!=null){
                ret += employee.importance;
                List<Integer> subordinates = employee.subordinates;
                if(subordinates!=null){
                    subordinates.forEach((item)->queue.add(item));
                }
            }

        }
        return ret;
    }

    private int importance =0;
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    public int getImportanceDfs(List<Employee> employees, int id) {
        for(Employee employee:employees){
            employeeMap.put(employee.id, employee);
        }
        dfs(id);
        return importance;
    }

    private void dfs(int id){
        Employee employee = employeeMap.get(id);
        if(employee == null){
            return;
        }
        importance +=employee.importance;
        List<Integer> subordinates = employee.subordinates;
        if(subordinates!=null){
            for(Integer employeeId:subordinates){
                dfs(employeeId);
            }
        }

    }
}
