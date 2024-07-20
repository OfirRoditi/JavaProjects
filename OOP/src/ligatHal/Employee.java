package ligatHal;

public abstract class Employee extends Person
{
    //Abstract method means cannot create an object.
        private int seniority;
        private int employeeBaseSalary;

    /**
     * Basic constructor
     * @param name
     * @param lastName
     * @param id
     * @param seniority
     */
        public Employee(String name, String lastName, String id, int seniority)
        {
            super (name, lastName,id);
            this.seniority=seniority;
            employeeBaseSalary = 4500;//Employee basis salary is 4500
        }

    /**
     *
     * @return Abstract method that every son has to inheritance
     */
    public abstract double employeeSalary ();
        public String toString ()
        {
            return super.toString() + "\n" + "Seniority (years): " + seniority;
        }
        //Getters and setters:
        public int getSeniority() {
                return seniority;
            }
        public void setSeniority(int seniority) {
            this.seniority = seniority;
        }
        public  int getEmployeeBaseSalary() {
            return employeeBaseSalary;
        }
        public void setEmployeeBaseSalary(int employeeBaseSalary)
        {
            this.employeeBaseSalary = employeeBaseSalary;
        }
    }

