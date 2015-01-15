package training.JSF.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import training.JSF.data.Employee;


@ManagedBean
@SessionScoped
public class ViewEmployeeManageBean {
	private List<Employee> listEmployee = new ArrayList<Employee>();
	
	public ViewEmployeeManageBean(){
		 
    }
 
    @PostConstruct
    public void populateEmployeeList(){
        for(int i = 1 ; i <= 10 ; i++){
            Employee emp = new Employee();
            emp.setId(String.valueOf(i));
            emp.setName("Employee#"+i);
            this.listEmployee.add(emp);
        }
    }

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
    
}
