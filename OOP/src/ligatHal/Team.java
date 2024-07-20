package ligatHal;

import java.util.ArrayList;
public class Team
{
    private String teamName;
    private String stadiumName;
    private Coach coachOther;
    private Manager managerOther;
    /**
     * Numbers of player in a team.
     */
    private int numberOfPlayersForEachTeam;
    /**
     * //Arrays of players in the team
     */
    private ArrayList<Player> playerArrayList = new ArrayList<Player>();

    public Team(String teamName, String stadiumName, ArrayList<Player> playerArrayList,
                int numberOfPlayersForEachTeam, Coach coachOther, Manager managerOther)//Constructor
    {
        this.teamName = teamName;
        this.stadiumName=stadiumName;
        this.playerArrayList = playerArrayList;
        this.numberOfPlayersForEachTeam = numberOfPlayersForEachTeam;

        //coachOther
        /**
         * Checking if the  coach is existed
         */
        if (coachOther == null)
        {
            this.coachOther = new Coach("Null", "Null", "Null",0
                    ,"Null",false,0);
        } else
        {
            this.coachOther = new Coach(coachOther);
        }

        //managerOther
        /**
         * Checking if the  manager is existed
         */
        if (managerOther == null)
        {
            this.managerOther = new Manager("Null", "Null", "Null", 0);
        } else {
            this.managerOther = new Manager(managerOther);
        }
    }



    //Methods:

    /**
     * Add new player to player array list
     * @param player
     */
    public void addPlayer(Player player)//Add player to array of Players.
    {
        this.playerArrayList.add(player);
    }
    public void addManager(Manager manager)
    {
        //if manager is empty.
        if(this.managerOther.getName().equals("Null"))
            this.managerOther = manager;
        else
            System.out.println("There is a manager already");
    }
    public void addCoach(Coach coach)
    {
        if(this.coachOther.getName().equals("Null") )//if coach is empty.
            this.coachOther = coach;
        else
            System.out.println("There is a manager already");
    }

    /**
     * Looking for the specif player by ID
     * @param idOfPlayer
     * @return his details.
     * else return "not existed
     */
    public String getPlayerId(String idOfPlayer)
    {
        for (Player player : playerArrayList)//Run for player list and looking for player ID
        {
            if (player.getIdOfPerson().equals(idOfPlayer))
            {
                return player.toString();
            }
        }
        String newStr = "Player is not identified";//If there is no id identified
        return newStr;
    }
    /**
     * Looking for the specif player by name and last name
     * @return his details.
     * else return "not existed
     */
    public String getNameAndLastName(String name,String lastName)
    {
        for (Player player : playerArrayList)//Run for player list and looking for player ID
        {
            if (player.getName().equals(name) && player.getLastName().equals(lastName))
            {
                return player.toString();
            }
        }
        String newStr = "Player is not exist";//If there is no id identified
        return newStr;
    }

    /**
     * Print all detials of the team including:
     * Team name , stadium name , player's details, manager and coach details.
     * @return
     */
    @Override
    public String toString()
    {
        String newStr = "Team's name: " + teamName +"\n"
                + "Stadium name: "+ stadiumName+"\n"+"\n";
        newStr += "Teams members : "+"\n";
        for (Player p1 : this.getPlayerArrayList())
        {
            newStr+=p1.toString()+"\n"+"\n";
        }
        newStr+="The manager details: " +"\n"+ managerOther.toString()+"\n"+"\n"+
        "The coach details : "+"\n"+ coachOther.toString();
        return newStr;
    }

    //Getters and Setters:
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getStadiumName() {
        return stadiumName;
    }
//    public void setStadiumName(String stadiumName) {
//        this.stadiumName = stadiumName;
//    }
    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }
    public void setPlayerArrayList(ArrayList<Player> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }
    public int getNumberOfPlayersForEachTeam() {
        return numberOfPlayersForEachTeam;
    }
    public void setNumberOfPlayersForEachTeam(int numberOfPlayersForEachTeam) {
        this.numberOfPlayersForEachTeam = numberOfPlayersForEachTeam;
    }
    public Coach getCoachOther() {
        return coachOther;
    }
    public void setCoachOther(Coach coachOther) {
        this.coachOther = coachOther;
    }
    public Manager getManagerOther() {
        return managerOther;
    }
    public void setManagerOther(Manager managerOther) {
        this.managerOther = managerOther;
    }
}
