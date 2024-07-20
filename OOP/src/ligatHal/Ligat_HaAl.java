package ligatHal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Ligat_HaAl {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Team> teamArrayList = new ArrayList<>();
    public static ArrayList<Referee> refereeArrayList = new ArrayList<>();
    private static ArrayList<Employee> employeeArrayList = new ArrayList<>();
    private static ArrayList<Game> gameArrayList = new ArrayList<>();
    public Ligat_HaAl()//Basic constructor
    {
        this.teamArrayList = addTeamMethod();
        this.refereeArrayList = addRefreeMethod();
        this.gameArrayList = creatingGames();
        this.employeeArrayList = addAllEmployees();
    }
    /**
     * After creating the team, I added it to array list
     * @return array team list with 4 teams
     */
    private ArrayList<Team> addTeamMethod() {
        teamArrayList.add(createLiverpool());
        teamArrayList.add(createRoma());
        teamArrayList.add(createParis());
        teamArrayList.add(createMilan());
        return teamArrayList;
    }
    private ArrayList<Referee> addRefreeMethod() {
        refereeArrayList.add(new Referee("yigal", "gueta", "555", 2, 10, 3));
        refereeArrayList.add(new Referee("Emma", "Johnson", "888", 3, 20, 1));
        refereeArrayList.add(new Referee("Mohamed", "Ali", "666", 2, 3, 15));
        refereeArrayList.add(new Referee("Maria", "Garcia", "999", 2, 2, 10));
        return refereeArrayList;
    }
    private ArrayList<Game> creatingGames() {
        LocalDate localDate = LocalDate.now(); // change to actual date
        int variableX = 0;
        for (int i = 0; i < getTeamArrayList().size() - 1; i++)
        {

            for (int j = i + 1; j < getTeamArrayList().size(); j++)
            {
                variableX++;
                // Play home and away matches
                Game homeGame = new Game(localDate.plusDays(variableX), getTeamArrayList().get(i), getTeamArrayList().get(j), selectReferees());
                Game awayGame = new Game(localDate.plusDays(++variableX), getTeamArrayList().get(j), getTeamArrayList().get(i), selectReferees());
                gameArrayList.add(homeGame);
                gameArrayList.add(awayGame);
            }
        }
        return gameArrayList;
    }
    private ArrayList<Employee> addAllEmployees() {

        for (Team t1 : getTeamArrayList()) {
            employeeArrayList.addAll(t1.getPlayerArrayList());
        }
        for (Team t1 : getTeamArrayList())
            employeeArrayList.add(t1.getManagerOther());

        for (Team t1 : getTeamArrayList()) {
            employeeArrayList.add(t1.getCoachOther());
        }
        employeeArrayList.addAll(getRefereeArrayList());

        return employeeArrayList;
    }

    /**
     * Method to select each time 3 referees
     * @return 3 referees
     */
    private ArrayList<Referee> selectReferees() {
        ArrayList<Referee> threeRandomReferees = new ArrayList<>(3);
        Collections.shuffle(getRefereeArrayList()); // //Shuffle the referees.
        int counterReferees = 0;
        for (Referee referee : getRefereeArrayList()) {
            if (counterReferees == 3) {
                break; //
            }
            threeRandomReferees.add(referee);
            counterReferees++;
        }
        return threeRandomReferees;
    }

    /**
     * Creating the teams (Liverpool,Roma,Paris and Milan)
     * @return
     */
    private Team createLiverpool() {
        ArrayList<Player> liverpoolPlayers = new ArrayList<Player>();

        // Add each player to the ArrayList
        liverpoolPlayers.add(new Player("Alisson", "Becker", "30", 1, "Liverpool", 60, 0, "Goal Keeper"));
        liverpoolPlayers.add(new Player("Trent", "Alexander-Arnold", "31", 66, "Liverpool", 173, 30, "Defender"));
        liverpoolPlayers.add(new Player("Virgil", "van Dijk", "32", 4, "Liverpool", 130, 14, "Defender"));
        liverpoolPlayers.add(new Player("Joel", "Matip", "33", 32, "Liverpool", 94, 5, "Defender"));
        liverpoolPlayers.add(new Player("Andrew", "Robertson", randomizeID(), 26, "Liverpool", 144, 7, "Defender"));
        liverpoolPlayers.add(new Player("Fabinho", "Tavares", randomizeID(), 3, "Liverpool", 82, 3, "Mid Fielder"));
        liverpoolPlayers.add(new Player("Jordan", "Henderson", randomizeID(), 14, "Liverpool", 322, 35, "Mid Fielder"));
        liverpoolPlayers.add(new Player("Georginio", "Wijnaldum", randomizeID(), 5, "Liverpool", 237, 22, "Mid Fielder"));
        liverpoolPlayers.add(new Player("Mohamed", "Salah", randomizeID(), 11, "Liverpool", 149, 104, "Forward"));
        liverpoolPlayers.add(new Player("Sadio", "Mane", randomizeID(), 10, "Liverpool", 167, 89, "Forward"));
        liverpoolPlayers.add(new Player("Roberto", "Firmino", randomizeID(), 9, "Liverpool", 238, 86, "Forward"));

        Coach liverpoolCoach = new Coach("Jurgen", "Klopp", randomizeID(), 10, "Liverpool", true, 5);
        Manager liverpoolManager = new Manager("Michael", "Edwards", randomizeID(), 2);

        Team liverpool = new Team("Liverpool", "Anfield", liverpoolPlayers, 11, liverpoolCoach, liverpoolManager);
        return liverpool;
    }

    // Creating Roma team
    private Team createRoma() {
        ArrayList<Player> romaPlayers = new ArrayList<Player>();

        // Add each player to the ArrayList
        romaPlayers.add(new Player("Pau", "Lopez", "1", 1, "AS Roma", 60, 60, "Goal Keeper"));
        romaPlayers.add(new Player("Antonio", "Mirante", "2", 2, "AS Roma", 10, 10, "Goal Keeper"));
        romaPlayers.add(new Player("Rick", "Karsdorp", "3", 3, "AS Roma", 46, 4, "Defender"));
        romaPlayers.add(new Player("Gianluca", "Mancini", "4", 4, "AS Roma", 65, 4, "Defender"));
        romaPlayers.add(new Player("Chris", "Smallin", randomizeID(), 5, "AS Roma", 34, 1, "Defender"));
        romaPlayers.add(new Player("Roger", "Ibanez", randomizeID(), 6, "AS Roma", 52, 1, "Defender"));
        romaPlayers.add(new Player("Leonardo", "Spinazzola", randomizeID(), 7, "AS Roma", 21, 3, "Defender"));
        romaPlayers.add(new Player("Jordan", "Veretout", randomizeID(), 8, "AS Roma", 49, 8, "Mid Fielder"));
        romaPlayers.add(new Player("Bryan", "Cristante", randomizeID(), 9, "AS Roma", 41, 4, "Mid Fielder"));
        romaPlayers.add(new Player("Lorenzo", "Pellegrini", randomizeID(), 10, "AS Roma", 36, 6, "Mid Fielder"));
        romaPlayers.add(new Player("Henrikh", "Mkhitaryan", randomizeID(), 11, "AS Roma", 49, 12, "Forward"));

        Coach romaCoach = new Coach("Jose", "Mourinho", "1", 20, "AS Roma", true, 2);
        Manager romaManager = new Manager("Tiago", "Pinto", "2", 3);
        Team roma = new Team("AS Roma", "Stadio Olimpico", romaPlayers, 11, romaCoach, romaManager);
        return roma;
    }

    // Creating Paris team
    private Team createParis() {
        ArrayList<Player> parisPlayers = new ArrayList<Player>();

        // Add each player to the ArrayList
        parisPlayers.add(new Player("Keylor", "Navas", "20", 1, "Paris Saint-Germain", 50, 45, "Goal Keeper"));
        parisPlayers.add(new Player("Achraf", "Hakimi", "21", 2, "Paris Saint-Germain", 25, 25, "Defender"));
        parisPlayers.add(new Player("Presnel", "Kimpembe", "22", 3, "Paris Saint-Germain", 70, 3, "Defender"));
        parisPlayers.add(new Player("Marquinhos", "de Oliveira", randomizeID(), 4, "Paris Saint-Germain", 80, 5, "Defender"));
        parisPlayers.add(new Player("Juan", "Bernat", randomizeID(), 5, "Paris Saint-Germain", 15, 1, "Defender"));
        parisPlayers.add(new Player("Marco", "Verratti", randomizeID(), 6, "Paris Saint-Germain", 30, 7, "Mid Fielder"));
        parisPlayers.add(new Player("Leandro", "Paredes", randomizeID(), 7, "Paris Saint-Germain", 20, 3, "Mid Fielder"));
        parisPlayers.add(new Player("Angel", "Di Maria", randomizeID(), 8, "Paris Saint-Germain", 50, 12, "Mid Fielder"));
        parisPlayers.add(new Player("Kylian", "Mbappe", randomizeID(), 9, "Paris Saint-Germain", 90, 35, "Forward"));
        parisPlayers.add(new Player("Neymar", "da Silva", randomizeID(), 10, "Paris Saint-Germain", 80, 25, "Forward"));
        parisPlayers.add(new Player("Mauro", "Icardi", randomizeID(), 11, "Paris Saint-Germain", 15, 7, "Forward"));

        Coach parisCoach = new Coach("Mauricio", "Pochettino", "1", 10, "Paris Saint-Germain", true, 3);
        Manager parisManager = new Manager("Leonardo", "Nascimento de Araujo", "2", 1);
        Team paris = new Team("Paris Saint-Germain", "Parc des Princes", parisPlayers, 11, parisCoach, parisManager);

        return paris;
    }

    // Creating Milan team
    private Team createMilan() {
        ArrayList<Player> milanPlayers = new ArrayList<Player>();

        // Add each player to the ArrayList
        milanPlayers.add(new Player("Gianluigi", "Donnarumma", "10", 1, "Milan", 85, 0, "Goal Keeper"));
        milanPlayers.add(new Player("Theo", "Hernandez", "11", 19, "Milan", 78, 19, "Defender"));
        milanPlayers.add(new Player("Simon", "Kjaer", "12", 4, "Milan", 80, 7, "Defender"));
        milanPlayers.add(new Player("Fikayo", "Tomori", randomizeID(), 23, "Milan", 74, 1, "Defender"));
        milanPlayers.add(new Player("Davide", "Calabria", randomizeID(), 2, "Milan", 77, 3, "Defender"));
        milanPlayers.add(new Player("Franck", "Kessie", randomizeID(), 79, "Milan", 85, 11, "Midfielder"));
        milanPlayers.add(new Player("Sandro", "Tonali", randomizeID(), 8, "Milan", 72, 1, "Midfielder"));
        milanPlayers.add(new Player("Hakan", "Calhanoglu", randomizeID(), 10, "Milan", 81, 4, "Midfielder"));
        milanPlayers.add(new Player("Ante", "Rebic", randomizeID(), 12, "Milan", 76, 9, "Forward"));
        milanPlayers.add(new Player("Zlatan", "Ibrahimovic", randomizeID(), 11, "Milan", 84, 13, "Forward"));
        milanPlayers.add(new Player("Alexis", "Saelemaekers", randomizeID(), 56, "Milan", 73, 3, "Forward"));

        Coach milanCoach = new Coach("Stefano", "Pioli", randomizeID(), 15, "Milan", true, 4);
        Manager milanManager = new Manager("Paolo", "Maldini", randomizeID(), 3);

        Team milan = new Team("AC Milan", "San Siro", milanPlayers, 11, milanCoach, milanManager);

        return milan;
    }

    /**
     * randomizeID method for player's ID
     * @return
     */
    private String randomizeID() {
        int min = 1;
        int max = 1000;
        int randomNumber = (int) (Math.random() * (max - min));
        //Math.random() to generate a random number between 1 and 10
        return Integer.toString(randomNumber);
        //is a method that converts an int value, randomNumber, to a String.
    }

    /**
     * the menu for use follwing by the methods.
     */
    public void main() {
        int choiseOfUser;
        do {
            System.out.println();
            System.out.println("Choose your option: ");
            System.out.println("1 - Add Player");
            System.out.println("2 - Add Referee");
            System.out.println("3 - Print team details");
            System.out.println("4 - Print referee details");
            System.out.println("5 - Print future games details");
            System.out.println("6 - Print employee salary");
            System.out.println("7 - Add goal");
            System.out.println("8 - Add judgment error");
            System.out.println("9 - Print outstanding people");
            System.out.println("10 - Print table");
            System.out.println("11 - Print player details with lowest salary");
            System.out.println("12 - Exit");
            choiseOfUser = sc.nextInt();

            switch (choiseOfUser) {
                case 1:
                    addPlayer();
                    break;

                case 2:
                    addReferee();
                    break;

                case 3:
                    printTeamDetails();
                    break;

                case 4:
                    printRefereeDetails();
                    break;

                case 5:
                    printFutureGamesDetails();
                    break;

                case 6:
                    printEmployeeSalary();
                    break;

                case 7:
                    addGoal();
                    break;

                case 8:
                    addJudgmentError();
                    break;

                case 9:
                    printOutstandingPeople();
                    break;
                case 10:
                    printTable();
                    break;
                case 11:
                    printPlayerDetailsWithLowestSalary();
                    break;
                case 12:
                    System.out.println("Exit");
                default:
                    System.out.println("Invalid choise");
            }
        } while (choiseOfUser != 12);
    }

    /**
     * method that print the lowest salary that has in a team.
     *
     */
    private void printPlayerDetailsWithLowestSalary() {
        //ArrayList<Player> lowestSalaryList = new ArrayList<>();
        Player lowestSalaryPlayerDetails = null;
        //System.out.println("Lowest salary player for each team : ");
        for (Team t1 : getTeamArrayList())//Loop for all the teams
        {
            int lowestSalaryCoins = (int) t1.getPlayerArrayList().get(0).employeeSalary();//Put the first player for the first team for lowestSalary
            lowestSalaryPlayerDetails = t1.getPlayerArrayList().get(0);

            for (Player p1 : t1.getPlayerArrayList())//Loop for all the players for each team.
            {
                if (p1.employeeSalary() <= lowestSalaryCoins)
                {
                    lowestSalaryCoins = (int) p1.employeeSalary();
                    lowestSalaryPlayerDetails = p1;
                }
            }
        }
        System.out.println(lowestSalaryPlayerDetails.toString());

    }
    private void printTable() {
        int pointsOfLiverpool = 0;
        int pointsOfParis = 0;
        int pointsOfRoma = 0;
        int pointsOfMilan = 0;

        for (Game g1 : getGameArrayList()) {
            String winnerTeam = g1.theNameOfWinnerTeam();//Has the name of winner team

            String hostTeamName = g1.getHostTeam().getTeamName();
            String guestTeamName = g1.getGuestTeam().getTeamName();
            // Add 1 point to both home and guest team for a tie
            if (winnerTeam.equals("Tie")) {
                if (hostTeamName.equals("Liverpool") || guestTeamName.equals("Liverpool")) {
                    pointsOfLiverpool += 1;
                }
                if (hostTeamName.equals("AS Roma") || guestTeamName.equals("AS Roma")) {
                    pointsOfRoma += 1;
                }
                if (hostTeamName.equals("Paris Saint-Germain") || guestTeamName.equals("Paris Saint-Germain")) {
                    pointsOfParis += 1;
                }
                if (hostTeamName.equals("AC Milan") || guestTeamName.equals("AC Milan")) {
                    pointsOfMilan += 1;
                }
            } else {
                switch (winnerTeam) {
                    case "Liverpool":
                        pointsOfLiverpool += 3;
                        break;
                    case "Paris Saint-Germain":
                        pointsOfParis += 3;
                        break;
                    case "AS Roma":
                        pointsOfRoma += 3;
                        break;
                    case "AC Milan":
                        pointsOfMilan += 3;
                        break;
                }
            }
        }
        System.out.println("Status table : " + "\n" +
                "Paris points : " + pointsOfParis + "\n" +
                "Milan points : " + pointsOfMilan + "\n" +
                "Liverpool points : " + pointsOfLiverpool + "\n" +
                "Roma points : " + pointsOfRoma);
    }
    private void addJudgmentError() {
        String referessString = "";
        int numOfGame = 1;
        for (Game g1 : getGameArrayList()) {
            referessString = g1.getRefereeArrayList().get(0).getName() + " , " +
                    g1.getRefereeArrayList().get(1).getName() + " , " + g1.getRefereeArrayList().get(2).getName() + "\n";

            System.out.println("Number of game : " + numOfGame + " \n " + g1.getLocalDate() + "\n" + g1.toString()
                    + "The referees are :" + referessString);
            numOfGame++;
        }

        System.out.println("Plese choose the game's number: ");
        int choiseOfUser = sc.nextInt();
        //Getting the specific game
        Game gameChoosen = getGameArrayList().get(choiseOfUser - 1);//The specific game the user choose.

        System.out.println("The choosen game is :" + gameChoosen.toString() + "The referees are :" + referessString);

        System.out.println("Plese enter the name of the referee: ");
        String nameChoosen = sc.next();
        //Rferee num 1
        if (nameChoosen.equals(gameChoosen.getRefereeArrayList().get(0).getName())) {
            gameChoosen.getRefereeArrayList().get(0).addRefereeErrors(1);
            System.out.println("Error added");
            System.out.println("The updated errors of referee is : ");
            System.out.println(gameChoosen.getRefereeArrayList().get(0).getRefereeErrors());
        }
        //Rferee num 2
        else if (nameChoosen.equals(gameChoosen.getRefereeArrayList().get(1).getName())) {
            gameChoosen.getRefereeArrayList().get(1).addRefereeErrors(1);
            System.out.println("Error added");
            System.out.println("The updated errors of referee is : ");
            System.out.println(gameChoosen.getRefereeArrayList().get(1).getRefereeErrors());
        }
        //Rferee num 3
        else if (nameChoosen.equals(gameChoosen.getRefereeArrayList().get(2).getName())) {
            gameChoosen.getRefereeArrayList().get(2).addRefereeErrors(1);
            System.out.println("Error added");
            System.out.println("The updated errors of referee is : ");
            System.out.println(gameChoosen.getRefereeArrayList().get(2).getRefereeErrors());
        } else System.out.println("Invalid ID");

    }
    private void addPlayer()
    {
        System.out.println("please enter the team's name : ");
        System.out.println("These are the teams : " + "\n" + getTeamArrayList().get(0).getTeamName() + " - " +
                getTeamArrayList().get(1).getTeamName() + " - " + getTeamArrayList().get(2).getTeamName() + " - "
                + getTeamArrayList().get(3).getTeamName());
        sc.nextLine();
        String teamName = sc.nextLine();

        if ((teamName.equals(getTeamArrayList().get(0).getTeamName()) ||
                (teamName.equals(getTeamArrayList().get(1).getTeamName()) ||
                        (teamName.equals(getTeamArrayList().get(2).getTeamName()) ||
                                (teamName.equals(getTeamArrayList().get(3).getTeamName())
                                )))))
        {
            System.out.println("Plese enter the following details : " + "\n" +
                    "name,  lastName,  id,  seniority, position");
            String name = sc.next();
            String laseName = sc.next();
            String playerId = sc.next();
            int seniority = sc.nextInt();
            String position = sc.next();
            Player p1 = new Player(name, laseName, playerId, seniority, teamName, 0, 0, position);
            boolean flag = true;
            /**
             * Check weather the new ID is existed in employee array list.
             */
            for (Employee employee : getEmployeeArrayList())
            {
                    if (employee.getIdOfPerson().equals(p1.getIdOfPerson()) == true)
                    {
                       System.out.println("The ID is already exist");
                        flag = false;
                        break;
                    }
            }
                    if (flag == true)//Meaning there is no ID identified in employees
                    {
                        for(Team team : getTeamArrayList())
                        {
                            if (teamName.equals(team.getTeamName()))
                            {
                                team.addPlayer(p1);
                                System.out.println("Player added");
                                employeeArrayList.add(p1);
                            }
                        }
                    }
        } else System.out.println("Invalid input (team's name).");
    }
    /**
     * Run all over EmployeeArrayList and check for the outstanding people in each category
     */
    private void printOutstandingPeople() {
        for (Employee e1 : getEmployeeArrayList())
        {
            if (e1.exceptional() == true)
            {

                if (e1 instanceof Player)
                {
                    Player p1 = (Player) e1;
                    System.out.println("Player : "+ "\n" + p1.toString() + "\n");

                }
                else if (e1 instanceof Coach) {
                    Coach c1 = (Coach) e1;
                    System.out.println("Coach : " + "\n" + c1.toString() + "\n");

                } else if (e1 instanceof Referee) {
                    Referee r1 = (Referee) e1;
                    System.out.println("\n"+"Referee : " + "\n" + r1.toString() );
                    if (r1.mostErrors().equals(r1) == true)
                    {
                        System.out.println("This referee has the most errors.");
                    }else
                        System.out.println("This referee has not have the maximum number of errors");
                }
            }
        }
    }
    private void printTeamDetails() {
        System.out.println("These are the teams : " + "\n" + getTeamArrayList().get(0).getTeamName() + " - " +
                getTeamArrayList().get(1).getTeamName() + " - " + getTeamArrayList().get(2).getTeamName() + " - "
                + getTeamArrayList().get(3).getTeamName());
        System.out.println("Please enter the name of the team:");
        sc.nextLine();
        String teamName = sc.nextLine();
        boolean flag = true;

        for (Team team : getTeamArrayList()) {
            if (teamName.equals(team.getTeamName()))
                System.out.println(team.toString());
            flag = false;
        }
        if (flag == true)
            System.out.println("There is no match");
    }
    private void addGoal()
    {
        char answer;
        int numOfGame = 1;
        for (Game g1 : gameArrayList)
        {
            System.out.println("Number of game : " + numOfGame + " \n " + g1.getLocalDate() + "\n" + g1.toString() + "\n");
            numOfGame++;
        }

        System.out.println("Plese choose the game's number: ");
        int choiseOfUser = sc.nextInt();
        //Getting the specific game
        int X = choiseOfUser - 1;
        Game gameChoosen = gameArrayList.get(X);
        System.out.println("The choosen game is :" + "\n" + gameChoosen.toString());

        do {
            System.out.println("Plese enter the id of the player: ");
            String idOfUser = sc.next();
            boolean flag = true;
            //Getting the specific teams
            Team hostTeam = gameChoosen.getHostTeam();
            Team guestTeam = gameChoosen.getGuestTeam();

            //Home team:
            for (Player p1 : hostTeam.getPlayerArrayList())
            {
                if (p1.getIdOfPerson().equals(idOfUser))
                {
                    gameChoosen.updateGoals(idOfUser);
                    flag = false;
                    System.out.println("The updated result is : " + "\n" + gameChoosen.gameResult());

                    break;
                }
            }
            if (flag == true) {
                boolean flag2 = true;
                for (Player p2 : guestTeam.getPlayerArrayList()) {
                    if (p2.getIdOfPerson().equals(idOfUser))
                    {
                        gameChoosen.updateGoals(idOfUser);
                        flag2 = false;
                        System.out.println("The updated result is : " + gameChoosen.gameResult());
                        break;
                    }
                }
                if (flag2 == true) {
                    System.out.println("Invalid ID");
                }
            }
            System.out.println("Do you want to add another goal ?(y/n) ");
            answer = sc.next().charAt(0);
        } while (answer == 'y');
    }
    public void printEmployeeSalary() {
        System.out.println("Plese enter the ID : ");
        String idOfEmployee = sc.next();
        boolean flag = true;

        for (Employee e1 : getEmployeeArrayList()) {
            if (e1.getIdOfPerson().equals(idOfEmployee)) {
                System.out.println("The employee salary is : " + e1.employeeSalary());
                flag = false;
            }
        }
        if (flag == true)
            System.out.println("Invalid ID");

    }
    private void printFutureGamesDetails() {
        System.out.println("Please enter the date by following details :(yyyy-mm-dd): ");
        String input = sc.next();
        LocalDate l1 = LocalDate.parse(input);//casting to localDate
        for (Game game : getGameArrayList())
        {
            LocalDate gameDate = game.getLocalDate();
            if (gameDate.isAfter(l1))
            {
                System.out.println(game.toString());
            }
        }
    }
    private void printRefereeDetails() {
        boolean flag = true;
        for (Referee referee : getRefereeArrayList())
        {
            System.out.println("----------------------------------------");
            System.out.println(referee.toString()+"\n");
            System.out.println(" -- These are the games are planning for him : " );
            flag = true;
            for (Game game : getGameArrayList())
            {
                if ((referee.getName().equals(game.getRefereeArrayList().get(0).getName())
                        ||
                        (referee.getName().equals(game.getRefereeArrayList().get(1).getName())
                                ||
                                (referee.getName().equals(game.getRefereeArrayList().get(2).getName())
                                )))) {
                    System.out.println(game.toString());
                    flag = false;
                }

            }
//            System.out.print();
            if (flag == true)
                System.out.print(" This referee did not refereed before" + "\n");
        }
    }
    private void addReferee() {
        System.out.println("Plese enter the following details(name,lastName,id,seniority)");
        String name = sc.next();
        String lastName = sc.next();
        String idOfReferee = sc.next();
        int seniorityOfReferry = sc.nextInt();
        boolean flag = true;

        for (Employee employee : getEmployeeArrayList()) {
            if (idOfReferee.equals(employee.getIdOfPerson())) {
                flag = false;//Meaning there is the same id in employee list
                System.out.println("The ID is already exist");
            }
        }
        if (flag == true) {
            Referee newR = new Referee(name, lastName, idOfReferee, seniorityOfReferry, 0, 0);
            getRefereeArrayList().add(newR);
            getEmployeeArrayList().add(newR);
            System.out.println("Referee added");
        }

    }
    //Getters and Setters:
    public static ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public ArrayList<Team> getTeamArrayList() {
        return teamArrayList;
    }

    public ArrayList<Referee> getRefereeArrayList() {
        return refereeArrayList;
    }

    public ArrayList<Game> getGameArrayList() {
        return gameArrayList;
    }
}