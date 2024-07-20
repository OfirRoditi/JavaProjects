package ligatHal;

public class Player extends Employee
{
    /**
     * Team name of the player
     */
    private String teamName;
    /**
     * Basic salary for player
     */
    private static final int playerSalary = 6500; ;
    /**
     * Num of attempts the player did
     */
    private int totalAttempts;
    /**
     * Num of attempts that succeeded
     */
    private int succeedAttempt;
    /**
     * Position of player
     */
    private String position;

    /**
     * Basic constractur for Player: Creating plyaer with his fields.

     */
    public Player(String name, String lastName, String id, int seniority, String teamName,
                  int totalAttempts, int succeedAttempt, String position)
    {
        super(name, lastName, id, seniority);
        this.teamName = teamName;
        this.totalAttempts = totalAttempts;
        this.succeedAttempt = succeedAttempt;
        this.position = position;

    }

    /**
     *
     * @return Return the percentage of successfully on succeedAttempts.
     */
    private double successPercentage()
    {
            double precentageResult = ((double) succeedAttempt / (double) totalAttempts) * 100;
        return precentageResult;
    }

    /**
     * //From the father(Person)
     * @return If the successPercentage is better than 75 then return true.
     */
    @Override
    public boolean exceptional()
    {
        if (successPercentage() > 75)
            return true;
        else
            return false;
    }

    /**
     * //From the father(Employee)
     * @return Return the salary with bonus for player.
     */
    @Override
    public double employeeSalary() {
        if (successPercentage() >= 0) {
            double salaryOfEmployee = ((double) 6500 + (successPercentage() / 100) * 2000);
            int salaryX100 = (int) (salaryOfEmployee * 100);
            return (double) salaryX100 / 100;
        } else {
            return 6500.0;
        }
    }
    public String toString() {
        return super.toString()+"\n"+"Player details : "+ "\n" +"Player base salary is: "+"6500" + "\n" + "Total attempts : " + getTotalAttempts() + "\n" + "Succeed attempts : "
                + getSucceedAttempt() + "\n" + "Success percentage:" + String.format("%.2f", successPercentage())+"\n"
                + "Position of the player is : " + position +
                 "\n" +
                "Total player salary: " + employeeSalary();
    }
    public void addAttempts(int newAttempts) {
        this.setTotalAttempts(newAttempts + this.getTotalAttempts());
    }
    public void addSucceedAttempt(int newSucceededAttempts) {
        this.setSucceedAttempt(newSucceededAttempts + this.getSucceedAttempt());
        //add 1 succeeded attempt to the overall attempts
        addAttempts(1);
    }

    //Getters and setters:
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public int getPlayerSalary() {
        return playerSalary;
    }
//    public  void setPlayerSalary(int playerSalary)
//    {
//        this.playerSalary = playerSalary;
//    }
    public int getTotalAttempts() {
        return totalAttempts;
    }
    public void setTotalAttempts(int totalAttempts) {
        this.totalAttempts = totalAttempts;
    }
    public int getSucceedAttempt() {
        return succeedAttempt;
    }
    public void setSucceedAttempt(int succeedAttempt) {
        this.succeedAttempt = succeedAttempt;
    }
    public String getPosition() {
        return position;
    }
//    public void setPosition(String position) {
//        this.position = position;
//    }
}
