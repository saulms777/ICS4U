import People.WorkShift;

/**
 * The main class for Restaurant Manager program. All user interface is located in this class.
 *
 * @author Samuel Zhang
 */
public class Main {

    /**
     * Restaurant object being managed in the program
     */
    public static Restaurant restaurant;

    /**
     * Entry point for program execution.
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        // setup functions
        startScreen();
        initializeRestaurant();

        // main body of program
        int input;
        while ((input = mainMenu()) != 0) {
            if (input == 1) viewRestaurant();
            else if (input == 2) viewEmployeeList();
            else if (input == 3) hireEmployee();
            else if (input == 4) selectEmployee();
            else if (input == 5) payEmployee();
            else if (input == 6) changeEmployeeInfo();
            else if (input == 7) fireEmployee();
            else if (input == 8) findEmployee();
            else if (input == 9) viewPayroll();
        }

        // ending message
        System.out.print("""
                ------------------------------------------------------------------------------------------------------
                
                
                                     Thank you for using the Restaurant Manager. Have a nice day.
                
                """);
    }

    /**
     * Starting screen of program. It will print a prompt for the user to resize their command window.
     */
    public static void startScreen() {
        Input.nextLine("""
                .---------------------------------------------------------------------------------------------------.
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                |                                 Welcome to the Restaurant Manager                                 |
                |                                                                                                   |
                |                                                                                                   |
                |                                 Please resize window to outlined                                  |
                |                                 dimensions for optimal experience                                 |
                |                                                                                                   |
                |                                                                                                   |
                |                                      PRESS ENTER TO CONTINUE                                      |
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                |                                                                                                   |
                '---------------------------------------------------------------------------------------------------'
                """);
    }

    /**
     * Initialization of the Restaurant object. The user can either
     * choose to use a preset restaurant or start with a blank one.
     */
    public static void initializeRestaurant() {
        System.out.println("""
                ------------------------------------------------------------------------------------------------------
                
                                            .^^^^^^^^^^^^^^^^^^^^^^^^^^^:^:^^^^:^:^^::^^^^^
                                            ^?                                            J:
                             :!:^^^^^^^^^^^:77                                            ?~:^^^^^^^^^^^!
                             ~7             ^?                                            ?:            J
                             ^?:!^::::::::::^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!^!^:::::::~^::^J
                             ^?7~                                                          .!^?^       J:  .J
                             !Y.                                                             ~5:       J.   J
                            !!                                                                :7^.:::..J.  .J
                           ?7^^^^^^^^^^^^^^^~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~Y?~~~!:J.  .?
                          .J^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^!? . 7^?.  .?
                           ..!?.?!J::::::::::::::::::::::::::::Y:::::::::::::::::::::::::::.!7?7?    !^?.  .?
                             ^7 7~?.                           J                            ^!7!7    !^?.  .?
                             ^7 7~?.  [1] Default Restaurant   J    [2] Blank Restaurant    ^!7!7    !^?.  .?
                             ^7 7~?                            Y                            ^!7!7    !^?.  .?
                             ^? ?!~^~~~~~~~~~~~~~~~~~~~~~~~~~~~7~~~~~~~~~~~~~~~~~~~~~~~~~~~^~^?~7~~~~7:?.  .?
                             ^?.::......................................................::::..J~7^^^^7:?.  .?
                             ^7                                                               ?!7    7^?.   J
                        ~^^^^!?~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~J7?7777?!J!~~~J^^^
                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """);
        int input = Input.nextInt("Enter a choice: ");
        while (input != 1 && input != 2) input = Input.nextInt("Enter a valid choice: ");

        System.out.println("Creating restaurant...");
        restaurant = new Restaurant(
                Input.nextLine("Enter Name of Restaurant: "),
                Input.nextInt("Enter Star Rating of Restaurant: ")
        );
        if (input == 1) fillDefaultRestaurant();
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Preset restaurant. Will create three placeholder employees.
     */
    public static void fillDefaultRestaurant() {
        // create placeholder employees
        restaurant.hireChef("Alice", "A generic person", 24, 5000, WorkShift.getAfternoonShift(), "steak");
        restaurant.hireWaiter("Bob", "Another generic person", 18, 3000, WorkShift.getEveningShift());
        restaurant.hireJanitor("Carlos", "A third generic person", 30, 4000, WorkShift.getMorningShift(), "washrooms");

        // set selected employee to prevent errors
        restaurant.setSelectedEmployee("Alice");
    }

    /**
     * Main menu for the program. There is a menu of options for the user to
     * choose from, as well as displaying the currently selected employee
     *
     * @return Menu option the user chose
     */
    public static int mainMenu() {
        System.out.println("""
                ------------------------------------------------------------------------------------------------------
                
                        ?5YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY5J:
                       ~@~.::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::#J
                       !&: ^J!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?!  BY
                       !&: ~J                                                                            !?  BY
                       !&: ~J    <1> View Restaurant    <2> List of Employees   <3> Hire Employee        !? .BY
                       !&^ ~J                                                                            !? .BY
                       !&^ ~J    <4> Select Employee    <5> Pay Employee        <6> Change Employee Info !? .BY
                       !&: ~J                                                                            !? .BY
                       !&: ~J    <7> Fire Employee      <8> Find Employee       <9> Total Payroll        !? .BY
                       !&: ~J                                                                            !? .BY
                       !&: ~J                           <0> Exit                                         !? .BY
                       !&: ~Y                                                                            7? .BY
                       !&: :!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!^ .BY""");
        System.out.println("       ~&?~" + centerString(80,
                "Current Selected Employee: " + restaurant.getCurrentEmployeeNameAndType()) + "!!#?");
        System.out.println("""
                        ^??????????????????7BB7???77???77????77???77???77????77???77???7P&???????????????????~
                                     .::::::PB::::.::::.::::..::::.::::.::::..::::.::::.Y&::::::.
                                 5BJYYYJYYJYYYJJYYYJJYYYJJYYYJJYYYJJYYYJJYYYJJYYYJJYYYJJYYYJY5YYYYJPB
                                 GG                                                                J&
                                 JGYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYP5
                """);
        int input = Input.nextInt("Enter a choice: ");
        while (input < 0 || input > 9) input = Input.nextInt("Enter a valid choice: ");
        return input;
    }

    /**
     * Prints the restaurant details.
     */
    public static void viewRestaurant() {
        System.out.println("Restaurant Details:");
        System.out.println(restaurant);
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Prints the list of employees, both active and terminated.
     */
    public static void viewEmployeeList() {
        System.out.println("List of Employees:");
        System.out.println(restaurant.getEmployeeList());
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Hires an employee and selects them. Each parameter of the employee has a user prompt.
     */
    public static void hireEmployee() {
        // Get basic job information
        String employeeType = getEmployeeType();
        String specialty = null, job = null; {
            if (employeeType.equalsIgnoreCase("chef"))
                specialty = Input.nextLine("Enter Chef Specialty: ");
            else if (employeeType.equalsIgnoreCase("janitor"))
                job = Input.nextLine("Enter Janitor Job: ");
        }

        // Gets the rest of the data and hires the employee
        Object[] data = getEmployeeInfo();
        if (employeeType.equalsIgnoreCase("chef"))
            System.out.println(restaurant.hireChef((String) data[0], (String) data[1], (int) data[2], (int) data[3], (WorkShift) data[4], specialty));
        else if (employeeType.equalsIgnoreCase("waiter"))
            System.out.println(restaurant.hireWaiter((String) data[0], (String) data[1], (int) data[2], (int) data[3], (WorkShift) data[4]));
        else if (employeeType.equalsIgnoreCase("janitor"))
            System.out.println(restaurant.hireJanitor((String) data[0], (String) data[1], (int) data[2], (int) data[3], (WorkShift) data[4], job));

        // sets the currently selected employee to the one just hired
        restaurant.setSelectedEmployee((String) data[0]);
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Prints the list of employees and selects a user-chosen employee.
     * Prints the information of the employee afterward.
     */
    public static void selectEmployee() {
        System.out.println("List of Employees:");
        System.out.println(restaurant.getEmployeeList());
        String name = Input.nextLine("Name of Selected Employee: ");
        while (!restaurant.hasEmployee(name))
            name = Input.nextLine("Employee Not Found. Please Provide a Valid Name." +
                "\nName of Selected Employee: ");
        restaurant.setSelectedEmployee(name);
        System.out.println("-------------------------\n" + restaurant.getCurrentEmployeeInfo() + "\n-------------------------");
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Pays an employee, displaying a feedback message.
     */
    public static void payEmployee() {
        System.out.println("Paying " + restaurant.getCurrentEmployeeName() + "...");
        System.out.println(restaurant.payEmployee());
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Changes the data of the currently selected employee.
     */
    public static void changeEmployeeInfo() {
        Object[] data = getEmployeeInfo();
        restaurant.setData((String) data[0], (String) data[1], (int) data[2], (int) data[3], (WorkShift) data[4]);
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Fires the currently selected employee.
     */
    public static void fireEmployee() {
        System.out.println("Firing " + restaurant.getCurrentEmployeeName() + "...");
        System.out.println(restaurant.fireEmployee());
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Prompts the user for an employee attribute and filters all employees using the specified attribute.
     */
    public static void findEmployee() {
        String input = Input.nextLine("""
                Options:
                Name, Background Info, Age, Work Shift,
                Job, Status, Chef Specialty, Janitor Job
                < Salary, = Salary, > Salary
                
                Enter choice:\s""");
        if (input.equalsIgnoreCase("name"))
            System.out.println(restaurant.searchName(Input.nextLine("Enter name to search: ")));
        else if (input.equalsIgnoreCase("background info"))
            System.out.println(restaurant.searchBgInfo(Input.nextLine("Enter background info to search: ")));
        else if (input.equalsIgnoreCase("age"))
            System.out.println(restaurant.searchAge(Input.nextInt("Enter age to search: ")));
        else if (input.equalsIgnoreCase("< salary"))
             System.out.println(restaurant.searchSalary(Input.nextInt("Enter salary to search: "), '<'));
        else if (input.equalsIgnoreCase("= salary"))
            System.out.println(restaurant.searchSalary(Input.nextInt("Enter salary to search: "), '='));
        else if (input.equalsIgnoreCase("> salary"))
            System.out.println(restaurant.searchSalary(Input.nextInt("Enter salary to search: "), '>'));
        else if (input.equalsIgnoreCase("work shift"))
            System.out.println(restaurant.searchWorkShift(getWorkShiftInput()));
        else if (input.equalsIgnoreCase("job"))
            System.out.println(restaurant.searchJob(getEmployeeType()));
        else if (input.equalsIgnoreCase("status"))
            System.out.println(restaurant.searchStatus(Input.nextBoolean("Enter status to search (true, false): ")));
        else if (input.equalsIgnoreCase("chef specialty"))
            System.out.println(restaurant.searchChefSpecialty(Input.nextLine("Enter chef specialty to search: ")));
        else if (input.equalsIgnoreCase("janitor job"))
            System.out.println(restaurant.searchJanitorJob(Input.nextLine("Enter janitor job to search: ")));
        else {
            System.out.println("Invalid parameter. Please try again.");
            findEmployee();
        }
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Prints the total restaurant payroll.
     */
    public static void viewPayroll() {
        System.out.println("Calculating Total Payroll...");
        System.out.println("Restaurant Payroll is $" + restaurant.getPayroll());
        Input.nextLine("PRESS ENTER TO CONTINUE\n");
    }

    /**
     * Helper method to center a String with a given width.
     *
     * @param width Width of total String
     * @param text String to center
     * @return Centered String with spaces on both sides
     */
    public static String centerString(int width, String text) {
        String repeat = " ".repeat((width - text.length()) / 2);
        return repeat + text + repeat;
    }

    /**
     * Prompts the user to enter basic employee information.
     *
     * @return Object array of basic employee data
     */
    public static Object[] getEmployeeInfo() {
        return new Object[]{
                Input.nextLine("Enter Name of Employee: "),
                Input.nextLine("Enter Employee Background Info: "),
                Input.nextInt("Enter Employee Age: "),
                Input.nextInt("Enter Employee Monthly Salary: "),
                getWorkShiftInput()
        };
    }

    /**
     * Prompts the user to input an employee type.
     *
     * @return Employee type
     */
    public static String getEmployeeType() {
        String employeeType = Input.nextWord("Enter Employee Type (Chef, Waiter, Janitor): ");
        while (excludes(employeeType, new String[]{"chef", "waiter", "janitor"}))
            employeeType = Input.nextWord("Invalid Employee Type. " +
                    "Enter Employee Type (Chef, Waiter, Janitor): ");
        return employeeType;
    }

    /**
     * Prompts the user to input a work shift. The user input will be converted into a WorkShift instance.
     *
     * @return WorkShift instance of user-specified work shift
     */
    public static WorkShift getWorkShiftInput() {
        String workShiftInput = Input.nextWord(
                "Enter Employee Work Shift (Morning, Afternoon, Evening, Night): ");
        while (excludes(workShiftInput, new String[]{"morning", "afternoon", "evening", "night"}))
            workShiftInput = Input.nextWord("Invalid Work Shift. " +
                    "Enter Employee Work Shift (Morning, Afternoon, Evening, Night): ");
        if (workShiftInput.equalsIgnoreCase("morning"))
            return WorkShift.getMorningShift();
        else if (workShiftInput.equalsIgnoreCase("afternoon"))
            return WorkShift.getAfternoonShift();
        else if (workShiftInput.equalsIgnoreCase("evening"))
            return WorkShift.getEveningShift();
        else if (workShiftInput.equalsIgnoreCase("night"))
            return WorkShift.getNightShift();
        else return null;
    }

    /**
     * Checks if a String is in an array.
     *
     * @param str String to find
     * @param options String array to check
     * @return Whether the String is in the array
     */
    public static boolean excludes(String str, String[] options) {
        for (String option : options) if (str.equalsIgnoreCase(option)) return false;
        return true;
    }

}
