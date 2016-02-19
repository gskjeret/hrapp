package hrapp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facade {

    private List<Employee> employees;
    private Employee employee;

    public Facade() {
        super();
        this.employees = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++) {
            Employee p = new Employee();
            p.setEmployeeId(i);
            p.setFirstName("Firstname " + i);
            p.setLastName("Last " + i);
            //p.setHiredate(new Date());
            this.employees.add(p);
        }
        this.employee = this.employees.get(0);
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public void addEmployee(Employee emp) {
        System.out.println("add employee " + employee);

        if(employee != null){
            new DataHandler().addEmployee(emp.getFirstName()
                                        , emp.getLastName()
                                        , emp.getEmail()
                                        , emp.getPhoneNumber()
                                        , emp.getJobId()
                                        , (int) Math.floor(emp.getSalary()));
                ;
        }
    }    public Employee getEmployee(){
        return employee;
    }
}