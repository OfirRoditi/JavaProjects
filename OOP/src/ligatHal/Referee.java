package ligatHal;

import java.util.ArrayList;

public class Referee extends Employee
{

        static ArrayList<Referee> refereeArrayList = new ArrayList<Referee>();
        private int refereeErrors;
        private int allRefereeGames;
    /**
     * max judgment errorless from all the referees
     */
    private static int maxJudgmentErrors;

        public Referee(String name, String lastName, String id, int seniority,
                       int refereeErrors, int allRefereeGames)
        {
            super(name, lastName, id, seniority);
            this.refereeErrors = refereeErrors;
            this.allRefereeGames = allRefereeGames;
            //When finished to create Referee it added to the refereeArrayList by this
            refereeArrayList.add(this);
        }
        //Methods:
        @Override
            public double employeeSalary()
            {
                double refereeSalary = (double)getEmployeeBaseSalary()+(double)(30 * allRefereeGames);

                String id = mostErrors();
                //Checking if the referred has the most errors
                if(this.getIdOfPerson().equals(id) == true)
                {
                    refereeSalary -= 500;
                }
                return refereeSalary;
            }

    /**
     *
     * @return Return the id by  most errors from every referees
     */
    public String mostErrors()
            {
                String id = "";
                int maximumErrors = 0;
                for (Referee object : getRefereeArrayList())
                {
                    if (object.getRefereeErrors() > maximumErrors)
                    {
                        maximumErrors = object.getRefereeErrors();
                        id = object.getIdOfPerson();
                    }
                }
                return id;
            }


    /**
     * Determines whether the person is exceptional based on their own referee errors and the maximum referee errors in the referee list.
     *
     * @return true if the person is exceptional, false otherwise.
     */
            @Override
        public boolean exceptional()
        {
            int maximumErrors = 0;
            for (Referee object : refereeArrayList)//Checking for the maxErrors in referee list.
            {
                if (object.getRefereeErrors() > maximumErrors)
                {
                    maximumErrors = object.getRefereeErrors();
                }
            }
            int result = (maximumErrors / 2);
            if (this.getRefereeErrors() > result)
                return false;
            else
                return true;
        }
        public void addRefereeErrors(int addErrors)
        {
            setRefereeErrors( this.getRefereeErrors() + addErrors);
        }
        public void AddAllRefereeGames(int addGamesRefereed)
        {
            setAllRefereeGames(addGamesRefereed + this.getAllRefereeGames());
        }
        public String toString ()
        {
            return super.toString() + "\n" + "Referee number of errors: " + refereeErrors + "\n" +
                    "Total games refereed:"+ allRefereeGames + "\n" + "Referee salary is:" +employeeSalary();
        }
        //Getters and setters:
        public int getRefereeErrors() {
            return refereeErrors;
        }
        public void setRefereeErrors(int refereeErrors) {
            this.refereeErrors = refereeErrors;
        }
        public int getAllRefereeGames() {
            return allRefereeGames;
        }
        public void setAllRefereeGames(int allRefereeGames) {
            this.allRefereeGames = allRefereeGames;
        }
        public static int getMaxJudgmentErrors() {
            return maxJudgmentErrors;
        }
        public static void setMaxJudgmentErrors(int maxJudgmentErrors) {
            Referee.maxJudgmentErrors = maxJudgmentErrors;
        }
    public  ArrayList<Referee> getRefereeArrayList() {
        return refereeArrayList;
    }



    }
