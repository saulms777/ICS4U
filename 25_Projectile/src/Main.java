import java.io.*;
import java.util.*;

//Name: Allen Deng
//Date: 2023-04-03
//Course: ICS4U
//Description: Client Code(MAIN) For Projectile Motion
public class Main {
    //Declaring Scanner and Projectile Array
    private static final Scanner sc = new Scanner(System.in);
    static Projectile[] projectiles = new Projectile[10];
   
    //Description: A Method for Getting A User Word Input
    //In: A Prompt That Asks the Question
    //Out: User's Word Input
    public static String inputWord(String prompt) {
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();
        return s;
    }


    //Description: A Method for Getting A User Integer Input
    //In: A Prompt That Asks the Question
    //Out: User's Integer Input
    public static int inputInt(String prompt) {
        System.out.print(prompt);
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }


    //Description: A Method for Getting A User Double Input
    //In: A Prompt That Asks the Question
    //Out: User's Double Input
    public static double inputDouble(String prompt) {
        System.out.print(prompt);
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }
   
    //Description: A Method for Accessing the Menu on Repeat
    //In: The Index of the Array of the Projectile that the User is Accessing
    //Out: User's Choice From the Menu
    public static int menu (int access) {
        //Printing a User-Friendly Menu To See Options
        System.out.println("     __   __   __        ___  __  ___         ___     __             __  ");
        System.out.println("    |__) |__) /  \\    | |__  /  `  |  | |    |__     /  `  /\\  |    /  `");
        System.out.println("    |    |  \\ \\__/ \\__/ |___ \\__,  |  | |___ |___    \\__, /~~\\ |___ \\__, ");
        System.out.println("\n                    Currently Accessing Projectile: " + access);
        System.out.println("     _____________________________        _____________________________");
        System.out.println("    |  <1> Create New Projectile  |      |     <2> View Projectile     |");
        System.out.println("    '-----------------------------'      '-----------------------------'");
        System.out.println("     _____________________________        _____________________________");
        System.out.println("    |  <3> Compare Projectiles    |      |  <4> Find Locations/Times   |");
        System.out.println("    '-----------------------------'      '-----------------------------'");
        System.out.println("     _____________________________        _____________________________");
        System.out.println("    |   <5> Badminton Scenario    |      |  <6> Access New Projectile  |");
        System.out.println("    '-----------------------------'      '-----------------------------'");
        System.out.println("     _____________________________        _____________________________ ");
        System.out.println("    |    <7> Save Projectiles     |      |     <8> Load Projectiles    |");
        System.out.println("    '-----------------------------'      '-----------------------------'");
        System.out.println("                       _____________________________ ");
        System.out.println("                      |          <0> Exit           |");
        System.out.println("                      '-----------------------------'");
        int usrChoice = inputInt("\nEnter a Choice: ");
        //Making Sure the Input is Within 1 to 7
        while (usrChoice > 8 || usrChoice < 0) {
            usrChoice = inputInt("Enter a Valid Option: ");
        }
        return usrChoice;
    }


    //Description: A Method To Create The Projectile
    //In: An Array of booleans that keeps track if each projectile is created yet or not
    //Out: It'll return the projectile that is created, and then become the accessed projectile
    public static int createProjectile (boolean[] created) {
        //Prints a List of the Projectiles, Stating if it's created yet or not
        for (int i = 0; i < created.length;i++) {
            if (created[i]) {
                System.out.println("Projectile " + (i+1) + ": <CREATED>");
            } else {
                System.out.println("Projectile " + (i+1) + ": <UNCREATED>");
            }
        }
        boolean valid = false;
        int access = 0;
        //Ensuring the projectile chosen is within the projectile index's, and that it's not created so far.
        while (valid == false) {
            access = inputInt("Enter a Projectile to Create: ") - 1;
            if (access >= 0 && access <= 9) {
                if (created[access] == false) {
                    valid = true;
                } else {
                    System.out.println("This is an Invalid Projectile.");
                }
            } else {
                System.out.println("This is an Invalid Projectile. ");
            }
        }
        //Getting User Values For Their Projectile. Velocity, Angle, X Y Coords, (Flight Time, DistTravelled, and MaxHeight Will be Calculated, No need for Input)
        System.out.println("\nYou Are Going to be Creating Projectile " + (access+1) + "! Please Enter -1 for Any Unkown Values");
        double initVelocity = inputDouble("\nEnter Initial Velocity(M/S): ");
        //Making Sure Velocity is Positive
        while (initVelocity <= 0 && initVelocity != -1) {
            initVelocity = inputDouble("Velocity Must be Positive: ");
        }
        double initAngle = inputDouble("Enter Initial Angle Above the Horizontal(Degrees): ");
        //Making Sure Angle is Between 0 - 90
        if (initAngle != -1) {
            while (initAngle < 0 || initAngle > 90) {
                initAngle = inputDouble("Angle Must be Between 0 - 90: ");
            }
        }
        double initX = inputDouble("Enter Initial X Coordinate: ");
        double initY = inputDouble("Enter Initial Y Coordinate: ");
        double flightTime = inputDouble("Enter Flight Time(Seconds): ");
        //Flight Time Must be Positive
        while (flightTime <= 0 && flightTime != -1) {
            flightTime = inputDouble("Flight Time Must be Positive: ");
        }
        double distanceTravelled = inputDouble("Enter the Distance Travelled(Metres): ");
        //Distance Travelled Must be Positive
        while (distanceTravelled <= 0 && distanceTravelled != -1) {
            distanceTravelled = inputDouble("Enter A Positive Distance: ");
        }
        double maxHeight = inputDouble("Enter the Max Height at the Peak of the Projectile(Metres): ");
        //Max Height Must be Positive
        while (maxHeight <= 0 && maxHeight != -1) {
            maxHeight = inputDouble("Enter a Positive Height: ");
        }
        //Initializing Projectile Using Values Collected
        projectiles[access] = new Projectile(initVelocity,initAngle,initX,initY,flightTime,distanceTravelled,maxHeight);
        created[access] = true;
        return access;
    }


    //Description: A Method To View The Projectile
    //In: The Index of Accessed Projectile and An Array of booleans that keeps track if each projectile is created yet or not
    //Out: Nothing Returned
    public static void viewProjectile (int access, boolean[] created) {
        //If the Projectile Accessed Is Not Created, It Won't Work
        if (created[access]) {
            //Printing The Projectile Path, and the Values(Velocity, Distance, Etc)
            System.out.println("<YOU ARE CURRENTLY VIEWING PROJECTILE " + (access+1) + "'s PATH>");
            System.out.println(projectiles[access]);
            System.out.println("PROJECTILE INITIAL VELOCITY: " + projectiles[access].getVelocity() + " M/S");
            System.out.println("PROJECTILE INITIAL ANGLE: " + projectiles[access].getAngle() + " DEGREES");
            System.out.println("PROJECTILE FLIGHT TIME: " + projectiles[access].getFlightTime() + " SECONDS");
            System.out.println("PROJECTILE DISTANCE TRAVELLED: " + projectiles[access].getDistanceTravelled() + " METERS");
            System.out.println("PROJECTILE PEAK HEIGHT: " + projectiles[access].getMaxHeight()  + " METERS");
            System.out.println("<PRESS ENTER TO CONTINUE>");
            sc.nextLine();
        } else {
            System.out.println("YOU CAN'T VIEW AN UNCREATED PROJECTILE, CREATE ONE FIRST");
            System.out.println("<PRESS ENTER TO CONTINUE>");
            sc.nextLine();
        }
    }


    //Description: A Method To Change The Projectile Accessed
    //In: An Array of booleans that keeps track if each projectile is created yet or not
    //Out: It'll return new index of the projectile the user wishes to access.
    public static int changeProjectile (boolean[] created) {
        //Prints the Current Status of Projectiles (CREATED/UNCREATED)
        for (int i = 0; i < created.length;i++) {
            if (created[i]) {
                System.out.println("Projectile " + (i+1) + ": <CREATED>");
            } else {
                System.out.println("Projectile " + (i+1) + ": <UNCREATED>");
            }
        }
        //User Selects Which Projectile to Access
        int access = inputInt("Enter a Projectile to Access: ");
        while (access > created.length || access < 1) {
            access = inputInt("Pick a Valid Projectile: ");
        }
        return access-1;
    }
    
    //Description: A Method For the Badminton Mini Game
    //In: No Input
    //Out: No Output
    public static void badminton () {
        //Creating Random
        Random r = new Random();
        //Initializing Player and Opponent Points
        int playerPoints = 0;
        int opponentPoints = 0;
        //Quick Explanation for Game
        System.out.println("Welcome to a Fun Badminton Mini Game! In this game, you will have to answer\na series of projectile questions in a badminton match, and gain points if you answer correctly!\nBEWARE: If you get the wrong answer, the opponent will gain the point instead.");
        int gameNum = inputInt("\nWhat Should the Game be Up To? ");
        //Player Must Pick a Positive Number for the Game
        while (gameNum < 1) {
            gameNum = inputInt("Pick a Positive Number: ");
        }
        System.out.println("LOADING....\n<Press Enter To Finish Loading>");
        sc.nextLine();
        Projectile[] badProj = new Projectile[gameNum*2-1];
        //Runs the Maximum Possible Number of Games
        for (int i = 0; i < badProj.length;i++) {
            int question = r.nextInt(5);
            double initVelocity = 0, initAngle = 0, height = 0, distance = 0;
            //Depending on the Random Question, values will be different and adjusted
            if (question == 0) {
                initVelocity = (r.nextInt(51)+80)/10.0;
                initAngle = r.nextInt(21)+35;
                height = (r.nextInt(26)+25)/10.0;
                distance = (r.nextInt(21)+110)/10.0;
            } else if (question == 1) {
                initVelocity = (r.nextInt(71)+80)/10.0;
                initAngle = r.nextInt(36)+25;
                height = (r.nextInt(26)+25)/10.0;
            } else if (question == 2) {
                initVelocity = (r.nextInt(41)+40)/10.0;
                initAngle = r.nextInt(18)+8;
                height = (r.nextInt(6) + 3)/10.0;
                distance = (r.nextInt(21)+20)/10.0;
            } else if (question == 3) {
                initVelocity = (r.nextInt(51)+100)/10.0;
                initAngle = r.nextInt(21)+50;
                height = (r.nextInt(26)+25)/10.0;
            } else {
                initVelocity = (r.nextInt(51)+75)/10.0;
                initAngle = r.nextInt(31)+40;
                height = (r.nextInt(7)+1)/10.0;
                distance = (r.nextInt(21) + 5)/10.0;
            }
            //Creates projectile depending on the values of the random question
            badProj[i] = new Projectile(initVelocity, initAngle,0,height,-1,-1,-1);
            System.out.println("QUESTION " + (i+1) + ": " + problemGen(question, initVelocity, initAngle, height, distance));
            //Gets Correct Answer and UserAnswer
            String answer = answerGen(question, initVelocity, initAngle, height, distance, badProj[i]);
            String usrAnswer = inputWord("Enter Your Answer: ");
            System.out.println("Calculating Answer....\n<Press Enter to Continue>");
            sc.nextLine();
            if (usrAnswer.equalsIgnoreCase(answer)) {
                playerPoints++;
                System.out.println("Congratulations! You got the Correct Answer! \nThe Score is Now " + playerPoints + "(YOU) : " + opponentPoints + "(OPPONENT)");
            } else {
                opponentPoints++;
                System.out.println("Unfortunately, You Got it Wrong... The Correct Answer Was " + answer + ". Better Luck Next Time :( \nThe Score is Now " + playerPoints + "(YOU) : " + opponentPoints + "(OPPONENT)");
            }
            System.out.println("<PRESS ENTER TO CONTINUE>");
            sc.nextLine();
            System.out.println("<VIEIWNG PROJECTILE FOR QUESTION " + (i+1) +  ">");
            System.out.println(badProj[i]);
            System.out.println("<PRESS ENTER TO CONTINUE>");
            sc.nextLine();
            if (playerPoints == gameNum) {
                System.out.println("Hooray! You Won the Badminton Match With a Score of " + playerPoints + "(YOU) : " + opponentPoints + "(OPPONENT). You're a Projectile Motion Pro!!");
                i = badProj.length;
            }
            if (opponentPoints == gameNum) {
                System.out.println("Do Better... You Lost the Badminton Match With a Score of " + playerPoints + "(YOU) : " + opponentPoints + "(OPPONENT). Keep Practicing Lil Bro.");
                i = badProj.length;
            }
        }
        System.out.println("RETURNING TO MENU....\n<PRESS ENTER>");
        sc.nextLine();
    }

    //Description: A Method To Calculate the Correct Answer for The Badminton Questions
    //In: The Values that the question contains so the answer can be calculated
    //Out: The Answer to the question in a String
    public static String answerGen (int question, double initVelocity, double initAngle, double height, double distance, Projectile badminton) {
        if (question == 0 || question == 2) {
            if (badminton.getDistanceTravelled() > distance) {
                return "Yes";
            } else {
                return "No";
            }
        } else if(question == 1) {
            long answer = Math.round(badminton.getFlightTime()*10);
            double newAnswer = answer/10.0;
            return newAnswer + "";
        } else if (question == 3) {
            if (badminton.getMaxHeight() > 10.0) {
                return "Yes";
            } else {
                return "No";
            }
        } else {
            long answer = Math.round(badminton.getDistanceTravelled()*10);
            double newAnswer = (answer/10.0) - distance;
            return newAnswer + "";
        }
    }

    //Description: A Method To Print the Random Question that is decided prior.
    //In: The Random Values decided prior in Badmintion() to put in the question
    //Out: Returns the String of the full problem with values.
    public static String problemGen (int question, double initVelocity, double initAngle, double height, double distance) {
        if (question == 0) {
            return "You are clearing the birdie from " + height + " meters above the ground. The birdie is hit and has\nan initial velocity of " + initVelocity + " M/S, at an angle of " + initAngle + " degrees above the horizontal.\nThe boundary of the court is " + distance + " meters away. Will your shot be out?";
        } else if(question == 1) {
            return "If the birdie is hit from " + height + " meters in the air and travels at an initial velocity of " + initVelocity + " M/S,\nat an angle of " + initAngle + " degrees above the horizontal, how long would it take for the birdie\nto reach the ground on the other side?(Nearest Tenth of a Second)";
        } else if(question == 2) {
            return "The opponent serves from " + distance + " meters away from the serving line on your side.\nThe birdie is hit from " + height + " meters above the ground and travels at an initial velocity of " + initVelocity + " M/S,\nat an angle of " + initAngle + " degrees above the horizontal, is their serve going to be in?";
        } else if (question == 3) {
            return "The opponent jumps and clears the birdie from a height of " + height + " meters above the ground(Mad Hops).\nThe initial velocity of said birdie is " + initVelocity + " M/S, at an angle of " + initAngle + " degrees above the horizontal.\nThere is a ceiling at the court you are playing at, wich is 10 meters above the ground. Is the birdie gonna hit the ceiling?";
        } else {
            return "Your opponent smashes and you managed to defend against it. You barely managed to get to the birdie\nbefore it hit the ground, hitting it " + height + " meters above the ground. The birdie bounuces off your racket with an\ninitial velocity of " + initVelocity + " M/S at an angle of " + initAngle + " degrees above the horizontal.\nYou were " + distance + " meters away from the net, how far from the net did the birdie land?(To the Closest Tenth of a Metre)";
        }
    }

    //Description: A Method To Compare 2 Projectiles
    //In: An Array of booleans that keeps track if each projectile is created yet or not
    //Out: It'll a boolean depending on if the projectiles land within a 1 meter range of eachother or not
    public static boolean compareProjectile (boolean[] created) {
        System.out.println("<PROJECTILE LIST>");
        //Prints the List and Status of Projectiles
        for (int i = 0; i < created.length;i++) {
            if (created[i]) {
                System.out.println("Projectile " + (i+1) + ": <CREATED>");
            } else {
                System.out.println("Projectile " + (i+1) + ": <UNCREATED>");
            }
        }
        boolean valid = false;
        int proj1 = 0;
        //Making Sure the Selected Projectile is Created
        while (valid == false) {
            proj1 = inputInt("ENTER FIRST PROJECTILE: ")-1;;
            if (proj1 >= 0 && proj1 <= 9) {
                if (created[proj1] == true) {
                    valid = true;
                } else {
                    System.out.println("INVALID PROJECTILE.");
                }
            } else {
                System.out.println("INVALID PROJECTILE.");
            }
        }
        valid = false;
        int proj2 = 0;
        //Making Sure the Selected Projectile is Created
        while (valid == false) {
            proj2 = inputInt("ENTER SECOND PROJECTILE: ")-1;;
            if (proj2 >= 0 && proj2 <= 9) {
                if (created[proj2] == true) {
                    valid = true;
                } else {
                    System.out.println("INVALID PROJECTILE.");
                }
            } else {
                System.out.println("INVALID PROJECTILE.");
            }
        }
        return projectiles[proj1].equals(projectiles[proj2]);
    }

    //Description: A Method To Find the Location or Time of the Projectile
    //In: The Index of the Array of Projectiles being accessed, and a boolean array of whether or not the projectile has been created
    //Out: No output
    public static void findLocTime (int access, boolean[] created) {
        if (created[access]) {
            //Small Menu for the 3 options
            System.out.println("     _____________________________        _____________________________");
            System.out.println("    |   <1> Find Time Given X     |      |    <2> Find Time Given Y    |");
            System.out.println("    '-----------------------------'      '-----------------------------'");
            System.out.println("                      ________________________________ ");
            System.out.println("                     |  <3> Find Location Given Time  |");
            System.out.println("                     '--------------------------------'");
            int usrChoice = inputInt("Enter a Choice: ");
            //Making Sure the user choice is valid
            while (usrChoice > 3 || usrChoice < 1) {
                usrChoice = inputInt("Enter a Valid Option: ");
            }
            //Depending on User Choice, the following will be calculated
            if (usrChoice == 1) {
                timeGivenX(access);
            } else if (usrChoice == 2) {
                timeGivenY(access);
            } else {
                locGivenTime(access);
            }
            System.out.println("<PRESS ENTER TO CONTINUE>");
            sc.nextLine();
        } else {
            System.out.println("You're Accessing an Uncreated Projectile, Create it First.");
            System.out.println("Press Enter to Continue");
            sc.nextLine();
        }
    }

    //Description: A Method To Calculate the Time Given the X Location
    //In: The Index of the Array of Projectiles being Accessed
    //Out: No Output
    public static void timeGivenX (int access) {
        double x = inputDouble("Enter The X Value You Want to Find Time For: ");
        System.out.println("The Projectile Reaches " + x + " Meters Forward After "+ projectiles[access].findTimeX(x) + " Seconds");
    }

    //Description: A Method To Calculate the Time Given the Y Location
    //In: The Index of the Array of Projectiles being Accessed
    //Out: No Output
    public static void timeGivenY (int access) {
        double y = inputDouble("Enter The Y Value You Want to Find Time For: ");
        double[] times = projectiles[access].findTimeY(y);
        System.out.println("The Projectile Reaches " + y + " Meters Tall After " + times[0] + " and " + times[1] + " Seconds" );
    }

    //Description: A Method To Calculate Location Given Time
    //In: The Index of the Array of Projectiles being Accessed
    //Out: No Output
    public static void locGivenTime (int access) {
        double time = inputDouble("Enter The Time You Want to Find Location For: ");
        double[] loc = projectiles[access].findCoordinates(time);
        System.out.println("The Projectile is " + loc[0] + " Meters Forward and " + loc[1] + " Meters High at " + time + " Seconds.");
    }
   
    //Description: A Method To Count the Number of Created Projectiles
    //In: No Input
    //Out: The Number of Created Projectiles
    public static int createCount (boolean[] created) {
        int creatCount = 0;
        for (int i = 0; i < created.length;i++) {
            if (created[i]) {
                creatCount++;
            }
        }
        return creatCount;
    }
    
    //Main
    public static void main (String[] args) {
        //Setting Projectiles[0] to be accessed first
        int access = 0;
        //Creating the boolean array that keeps track which projectiles are created so far
        boolean[] created = new boolean[projectiles.length];
        int usrChoice = menu(access + 1);
        //The Menu Will Run Until The user Chooses 7, which is Exit
        while (usrChoice != 0) {
            if (usrChoice == 1) {
                //Creating a Projectile, Number of Created Projectiles Must be Less than 10
                if (createCount(created) < projectiles.length) {
                    access = createProjectile(created);
                } else {
                    System.out.println("YOU HAVE REACHED THE MAX NUMBER OF CREATED PROJECTILES(" + projectiles.length + ")\n<PRESS ENTER TO CONTINUE>");
                    sc.nextLine();
                }
            } else if (usrChoice == 2) {
                //Viewing a Projectile
                viewProjectile(access, created);
            } else if (usrChoice == 3) {
                //Counts the Number of Created Projectiles
                int createNum = createCount(created);
                //Number of projectiles must be at least 2 for there to be a comparison.
                if (createNum >= 2) {
                    //Compares 2 Projectiles
                    if (compareProjectile(created)) {
                        System.out.println("These 2 Projectiles Land Within a 1 Meter Range of Eachother.");
                    } else {
                        System.out.println("These 2 Projectiles Do Not Land Within a 1 Meter Range of Eachother.");
                    }
                } else {
                    System.out.println("YOU NEED 2 PROJECTILES CREATED TO COMPARE...");
                }
                System.out.println("<PRESS ENTER TO CONTINUE>");
                sc.nextLine();
            } else if (usrChoice == 4) {
                //Leads to the Mini Menu for finding location or time
                findLocTime(access, created);
            } else if (usrChoice == 5) {
                //Runs Badminton Game
                badminton();
            } else if (usrChoice == 6) {
                //Changes The Accessed Projectile
                access = changeProjectile(created);
            }
            else if (usrChoice == 7) saveToFile(); // saves projectiles to file
            else if (usrChoice == 8) loadFromFile(created); // loads projectiles from file
            //Runs Menu Again
            usrChoice = menu(access + 1);
        }
        System.out.println("Thank You for Using Projectile Calc. Have a Good Day!");
    }

    /**
     * Saves projectiles data into a file. The file is named <code>data.txt</code> and is
     * located in the root directory of the project.
     */
    public static void saveToFile() {
        // create file and writer object
        File f = new File("data.txt");
        PrintWriter writer;
        try {
            f.createNewFile();
            writer = new PrintWriter(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Write projectiles data to the file
        int i = 1;
        for (Projectile p : projectiles) {
            writer.println("Projectile " + i++ + ":");
            if (p == null) writer.println("Not created\n");
            else {
                writer.println("Velocity: " + p.getVelocity());
                writer.println("Angle: " + p.getAngle());
                writer.println("Initial X: " + p.getInitX());
                writer.println("Initial Y: " + p.getInitY());
                writer.println();
            }
        }

        // close writer
        writer.close();

        // print feedback message
        System.out.println("Projectiles successfully saved to file.");
        System.out.println("<PRESS ENTER TO CONTINUE>");
        sc.nextLine();
    }

    /**
     * Loads the data saved in the <code>data.txt</code> file into the projectiles array and updates
     * created array to match. If the loading file does not exist, print an error message and continue.
     *
     * @param created Array storing whether a projectile in the projectile array is created or not
     */
    public static void loadFromFile(boolean[] created) {
        // create file reader
        Scanner reader;
        try {
            reader = new Scanner(new File("data.txt"));
        } catch (FileNotFoundException e) {
            // error message for if the file does not exist
            System.out.println("File does not exist. Please save a file first.");
            System.out.println("<PRESS ENTER TO CONTINUE>");
            sc.nextLine();
            return;
        }

        // reads the data from the file and saves it to projectile array
        System.out.println("Loading file...");
        for (int i = 0; i < 10; i++) {
            reader.nextLine();
            String line = reader.nextLine();

            // if the projectile was not created
            if (line.equals("Not created")) {
                projectiles[i] = null;
                created[i] = false;
                reader.nextLine();

            // parse the values from the file and update projectiles array
            } else {
                projectiles[i] = new Projectile(
                        Double.parseDouble(line.substring(line.lastIndexOf(' ') + 1)),
                        Double.parseDouble((line = reader.nextLine()).substring(line.lastIndexOf(' ') + 1)),
                        Double.parseDouble((line = reader.nextLine()).substring(line.lastIndexOf(' ') + 1)),
                        Double.parseDouble((line = reader.nextLine()).substring(line.lastIndexOf(' ') + 1)),
                        -1, -1, -1);
                created[i] = true;
                reader.nextLine();
            }
        }

        // print feedback message
        System.out.println("File successfully loaded.");
        System.out.println("<PRESS ENTER TO CONTINUE>");
        sc.nextLine();

        // close reader
        reader.close();
    }

}
