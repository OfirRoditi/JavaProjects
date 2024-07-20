package ligatHal;

public class Coach extends Employee
{
        private String teamName;//Name of club of the Coach
        private boolean isFormerPlayer;
        private int numOfChamp;//Num of champion coach's team.
        public Coach(String name, String familyName, String id, int seniority, String teamName,
                     boolean isFormerPlayer, int numOfChemp )
        {
            super(name, familyName, id, seniority);
            this.teamName = teamName;
            this.isFormerPlayer=isFormerPlayer;
            this.numOfChamp=numOfChemp;
        }
    public Coach(Coach other)
    {
        super(other.getName(), other.getLastName(), other.getIdOfPerson(), other.getSeniority());
        this.teamName = other.teamName;
        this.isFormerPlayer = other.isFormerPlayer;
        this.numOfChamp = other.numOfChamp;
    }
    //Methods:
        @Override
        public double employeeSalary()
        {
            double coachSalary = (double)getEmployeeBaseSalary()
                    + 200*(double)getSeniority()
                    + 500*(double)numOfChamp;
            return coachSalary;
        }
        @Override
        public boolean exceptional()
        {
            if (numOfChamp >= 2)
                return true;
            else
                return false;
        }
        public void addOneChampionship()
        {
            setNumOfChemp(getNumOfChemp()+1);
        }
        public String toString()
        {
            return super.toString()+"\n"+"Coach details :" +  "\n" + "Team name : " + teamName + "\n" + "Number of championships : "
                    + numOfChamp + "\n" +"Former player ? : "  + isFormerPlayer + "\n" + "Coach salary is : " +
                    this.employeeSalary();
        }
        //Getters and setters:
        public String getTeamName() {
            return teamName;
        }
        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }
        public boolean isFormerPlayer() {
            return isFormerPlayer;
        }
        public void setFormerPlayer(boolean isFormerPlayer) {
            this.isFormerPlayer = isFormerPlayer;
        }
        public int getNumOfChemp() {
            return numOfChamp;
        }
        public void setNumOfChemp(int numOfChemp) {
            this.numOfChamp = numOfChemp;
        }







    }
