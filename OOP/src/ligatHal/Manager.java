package ligatHal;

public class Manager extends Employee
{
    public Manager(String name, String lastName, String id, int seniority)
    {
        super(name, lastName, id, seniority);
    }
    public Manager(Manager object)//Creating object of manager
    {
        super(object.getName(), object.getLastName(), object.getIdOfPerson(), object.getSeniority());
    }
    @Override
    public double employeeSalary()
    {
        int y = this.getEmployeeBaseSalary();
        return (y * 3) + (getSeniority() * 500);
    }
    @Override
    public boolean exceptional()
    {
        if(this.getSeniority() > 4)
            return true;
        else
            return false;
    }
    @Override
    public String toString()
    {
        return super.toString()+"\n"+"Manager details : " +  "\n" + "Salary of Manger: " + employeeSalary();
    }

}
