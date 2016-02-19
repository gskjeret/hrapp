package hrapp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("hrapp")
@WebService
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

    @GET
    @Path("/employees")
    @WebMethod
    public List<Employee> getEmployees(){
        return this.employees;
    }

    @POST
    @Path("/employee")
    @WebMethod
    @Oneway
    public void addEmployee(@WebParam(name = "arg0") Employee employee) {
        System.out.println("add employee " + employee);

        if(employee != null){
            new DataHandler().addEmployee(employee.getFirstName()
                                        , employee.getLastName()
                                        , employee.getEmail()
                                        , employee.getPhoneNumber()
                                        , employee.getJobId()
                                        , (int) Math.floor(employee.getSalary()));
        }
    }

    @GET
    @Path("/employee")
    @WebMethod
    public Employee getEmployee(){
        return employee;
    }
}