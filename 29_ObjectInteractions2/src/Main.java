public class Main {

    public static void main(String[] args) {
        BicycleOwner profile =
                Input.nextChar("Create custom profile: (y/n) ") == 'y'
                ? new BicycleOwner(
                        Input.nextLine("Name of owner: "),
                        Input.nextDouble("Cost of bike: "),
                        Input.nextDouble("Owner's biking speed: "))
                : new BicycleOwner();

        boolean loop = true;
        while (loop) {
            switch (Input.nextInt("""
                    Menu of options:
                    (1) Get profile info
                    (2) Set profile name
                    (3) Set bicycle cost
                    (4) Set profile speed
                    (5) Travel some distance
                    (0) Exit
                                    
                    Choice:\s"""
            )) {
                case 0 -> loop = false;
                case 1 -> System.out.println(profile);
                case 2 -> profile.setName(Input.nextLine("New name: "));
                case 3 -> profile.setBicycleCost(Input.nextDouble("New cost: "));
                case 4 -> profile.setSpeed(Input.nextDouble("New speed: "));
                case 5 -> profile.travel(Input.nextInt("Hours to travel: "));
            }
        }
    }

}
