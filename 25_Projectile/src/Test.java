public class Test {

    public static void main(String[] args) {
        Projectile p = new Projectile(
                100,
                45,
                -100,
                100,
                Projectile.UNKNOWN_VALUE,
                Projectile.UNKNOWN_VALUE,
                Projectile.UNKNOWN_VALUE
        );

        // test case 1
        System.out.println("Velocity: " + p.getVelocity());
        System.out.println("Angle: " + p.getAngle());
        System.out.println("Initial X: " + p.getInitX());
        System.out.println("Initial Y: " + p.getInitY());
        System.out.println("Flight time: " + p.getFlightTime());
        System.out.println("Distance travelled: " + p.getDistanceTravelled());
        System.out.println("Max height: " + p.getMaxHeight());

        // test case 2
        System.out.println(p);

        // test case 3
        System.out.println("Coordinates at 10 sec: " + p.findCoordinates(10)[0] + ", " + p.findCoordinates(10)[1]);
        System.out.println("Time at x = 400: " + p.findTimeX(400));
        System.out.println("Time at y = 200: " + p.findTimeY(200)[0] + ", " + p.findTimeY(200)[1]);
        System.out.println("Equals same projectile with velocity changed to 95: " + p.equals(
                new Projectile(
                        95,
                        45,
                        -100,
                        100,
                        Projectile.UNKNOWN_VALUE,
                        Projectile.UNKNOWN_VALUE,
                        Projectile.UNKNOWN_VALUE
                )
        ));

        // test case 4
        p.setAngle(30);
        System.out.println("Changed angle to 30:");
        System.out.println("Velocity: " + p.getVelocity());
        System.out.println("Angle: " + p.getAngle());
        System.out.println("Initial X: " + p.getInitX());
        System.out.println("Initial Y: " + p.getInitY());
        System.out.println("Flight time: " + p.getFlightTime());
        System.out.println("Distance travelled: " + p.getDistanceTravelled());
        System.out.println("Max height: " + p.getMaxHeight());
        System.out.println(p);

        // test case 5
        p.setFlightTime(20);
        System.out.println("Changed flight time to 20 sec:");
        System.out.println("Velocity: " + p.getVelocity());
        System.out.println("Angle: " + p.getAngle());
        System.out.println("Initial X: " + p.getInitX());
        System.out.println("Initial Y: " + p.getInitY());
        System.out.println("Flight time: " + p.getFlightTime());
        System.out.println("Distance travelled: " + p.getDistanceTravelled());
        System.out.println("Max height: " + p.getMaxHeight());
        System.out.println(p);
    }

}
