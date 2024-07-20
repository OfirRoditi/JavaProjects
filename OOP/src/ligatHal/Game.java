package ligatHal;

import java.time.LocalDate;
import java.util.ArrayList;
public class Game
{
   private LocalDate localDate;
   private Team hostTeam;
   private Team guestTeam;
   private String winnerTeam;//The winner team
   private int hostTeamGoals;;
   private int guestTeamGoals;
   private  ArrayList<Referee> refereeArrayList = new ArrayList<>();

    public Game(LocalDate localDate, Team hostTeam, Team guestTeam, ArrayList<Referee> refereeArrayList)
   {
       this.localDate = localDate;
       this.hostTeam = hostTeam;
       this.guestTeam = guestTeam;
       this.refereeArrayList = refereeArrayList;

   }
   //Methods:
    public String gameResult()
    {
        String gameDetails = hostTeam.getTeamName() + " VS " + guestTeam.getTeamName() + " : " + hostTeamGoals + " - " + guestTeamGoals;
        return (gameDetails + "\n" + "The winner is: " + theNameOfWinnerTeam());
    }
    @Override
    public String toString()
    {
        String coachDetails;
        coachDetails = "Host team's coach is :" + hostTeam.getCoachOther().getName()+"\n"+
                "Guest team's coach is : " + guestTeam.getCoachOther().getName()+"\n";

        return gameResult() +"\n"+ coachDetails  ;
    }

    /**
     * Checking the winner team by goals
     * @return the name of the winner team
     */
    public String theNameOfWinnerTeam()
    {
        if (hostTeamGoals > guestTeamGoals)
        {
            return hostTeam.getTeamName();
        }
        else if (hostTeamGoals < guestTeamGoals)
        {
            return guestTeam.getTeamName();
        }
        else if (hostTeamGoals == 0 && guestTeamGoals == 0)
        {
            return " ";//Meaning the game is not started yet.
        }
        else
        {
            return "Tie";//Tie between the teams.
        }
    }
    /**
     * Updates the goals and attempts for the player with the given ID.
     *
     * @param playersId the ID of the player to update.
     */
    public void updateGoals(String playersId)
    {
        String nameOfPlayer="No Id Identified";
        for(Player playerOfHostTeam: hostTeam.getPlayerArrayList())//Loop for homeTeam list.
        {
            if(playersId.equals(playerOfHostTeam.getIdOfPerson()))//Searching for homeTeam ID==playerID
            {
                playerOfHostTeam.addSucceedAttempt(1);
                nameOfPlayer = playerOfHostTeam.getName();
                setHostTeamGoals(getHostTeamGoals()+1);
                break;
            }
        }//Looking for this player at the other team.
        for(Player playerOfGuestTeam : guestTeam.getPlayerArrayList())
            if(playersId.equals(playerOfGuestTeam.getIdOfPerson()))
            {
                playerOfGuestTeam.addSucceedAttempt(1);
                setGuestTeamGoals(getGuestTeamGoals() + 1);
                nameOfPlayer= playerOfGuestTeam.getName();
                break;
            }
        //Return the name of the player or default String return ;
    }

    /**
     * Update the errores of referre by id (+1)
     * @param idOfReferee
     */
    public void updateRefereeErorrs(String idOfReferee)
    {
        for (Referee referee : refereeArrayList)
        {
            if (referee.getIdOfPerson().equals(idOfReferee)){
                referee.setRefereeErrors(referee.getRefereeErrors() + 1);}
        }
    }
    //Getters and Setters:

    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public Team getHostTeam() {
        return hostTeam;
    }
    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }
    public Team getGuestTeam() {
        return guestTeam;
    }
    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }
    public String getWinnerTeam() {
        return winnerTeam;
    }
    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }
    public int getHostTeamGoals() {
        return hostTeamGoals;
    }
    public void setHostTeamGoals(int hostTeamGoals) {
        this.hostTeamGoals = hostTeamGoals;
    }
    public int getGuestTeamGoals() {
        return guestTeamGoals;
    }
    public void setGuestTeamGoals(int guestTeamGoals) {
        this.guestTeamGoals = guestTeamGoals;
    }
    public ArrayList<Referee> getRefereeArrayList() {
        return refereeArrayList;
    }
}
