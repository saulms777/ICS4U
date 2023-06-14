/**
 * Projectile object for modelling the motion of projectiles in physics
 *
 * @author Samuel Zhang
 */
public class Projectile {

    // constants for referencing variables in updater

    /**
     * Constant referencing the <code>velocity</code> attribute
     */
    private static final int VELOCITY = 1;

    /**
     * Constant referencing the <code>angle</code> attribute
     */
    private static final int ANGLE = 2;

    /**
     * Constant referencing the <code>initY</code> attribute
     */
    private static final int INIT_Y = 3;

    /**
     * Constant referencing the <code>flightTime</code> attribute
     */
    private static final int FLIGHT_TIME = 4;

    /**
     * Constant referencing the <code>distanceTravelled</code> attribute
     */
    private static final int DISTANCE_TRAVELLED = 5;

    /**
     * Constant referencing the <code>maxHeight</code> attribute
     */
    private static final int MAX_HEIGHT = 6;

    /**
     * Constant in constructor denoting that a value is unknown
     */
    public static final double UNKNOWN_VALUE = -1;

    /**
     * The gravitational acceleration on Earth
     */
    private static final double GRAVITATIONAL_ACCELERATION = 9.80665;



    // helper methods for mathematical calculations

    /**
     * Calculates the square of a number
     *
     * @param num Some number
     * @return Squared number
     */
    private static double square(double num) {
        return Math.pow(num, 2);
    }

    /**
     * Calculates the square root of a number
     *
     * @param num Some number
     * @return Square root of the number
     */
    private static double sqrt(double num) {
        return Math.sqrt(num);
    }

    /**
     * Calculates the sine of an angle
     *
     * @param angleDeg Angle in degrees
     * @return Sine ratio of the angle
     */
    private static double sin(double angleDeg) {
        return Math.sin(Math.toRadians(angleDeg));
    }

    /**
     * Calculates the cosine of an angle
     *
     * @param angleDeg Angle in degrees
     * @return Cosine ratio of the angle
     */
    private static double cos(double angleDeg) {
        return Math.cos(Math.toRadians(angleDeg));
    }

    /**
     * Calculates the tangent of an angle
     *
     * @param angleDeg Angle in degrees
     * @return Tangent ratio of the angle
     */
    private static double tan(double angleDeg) {
        return Math.tan(Math.toRadians(angleDeg));
    }

    /**
     * Rounds a number to the nearest integer
     *
     * @param num Some number
     * @return Rounded number
     */
    private static int round(double num) {
        return (int) Math.round(num);
    }

    /**
     * Finds the number of digits in a number using log10
     *
     * @param num Some number
     * @return Number of digits
     */
    private static int digits(double num) {
        if (num > 0) return (int) Math.log10(round(num)) + 1;
        else if (num < 0) return (int) Math.log10(round(Math.abs(num))) + 2;
        else return 1;
    }

    /**
     * Returns a <code>String</code> equivalent of a truncated double
     *
     * @param num Number to truncate
     * @param decimals Decimal places to truncate to, must be positive
     * @return Truncated number as a <code>String</code>
     */
    private static String truncateDouble(double num, int decimals) {
        return "" + (int) (num * Math.pow(10, decimals)) / Math.pow(10, decimals);
    }



    // Main class variables and methods

    // Projectile object attributes

    /**
     * Initial velocity of the projectile
     */
    private double velocity;

    /**
     * Initial x-velocity of the projectile
     */
    private double xVelocity;

    /**
     * Initial y-velocity of the projectile
     */
    private double yVelocity;

    /**
     * Initial angle that the projectile is launched at
     */
    private double angle;

    /**
     * Initial x-coordinate of the projectile
     */
    private double initX;

    /**
     * Initial y-coordinate (height) of the projectile
     */
    private double initY;

    /**
     * Time in seconds for the projectile to hit the ground
     */
    private double flightTime;

    /**
     * X-displacement of the projectile
     */
    private double distanceTravelled;

    /**
     * Maximum height of the projectile
     */
    private double maxHeight;


    /**
     * Constructor for object Projectile. Initial velocity, angle, and x coordinate are required parameters, and only
     * one of the other four are required for auto-calculation of the rest of the values. {@value #UNKNOWN_VALUE} is
     * used when the parameter is unknown and should be calculated internally.
     *
     * @param velocity Required
     * @param angle Required
     * @param initX Required
     * @param initY Optional
     * @param flightTime Optional
     * @param distanceTravelled Optional
     * @param maxHeight Optional
     */
    public Projectile(
            double velocity,
            double angle,
            double initX,
            double initY,
            double flightTime,
            double distanceTravelled,
            double maxHeight
    ) {
        this.velocity = velocity;
        xVelocity = velocity * cos(angle);
        yVelocity = velocity * sin(angle);
        this.angle = angle;
        this.initX = initX;

        if (initY != UNKNOWN_VALUE) {
            this.initY = initY;
            updateValues(INIT_Y);
        } else if (flightTime != UNKNOWN_VALUE) {
            this.flightTime = flightTime;
            updateValues(FLIGHT_TIME);
        } else if (distanceTravelled != UNKNOWN_VALUE) {
            this.distanceTravelled = distanceTravelled;
            updateValues(DISTANCE_TRAVELLED);
        } else if (maxHeight != UNKNOWN_VALUE) {
            this.maxHeight = maxHeight;
            updateValues(MAX_HEIGHT);
        }
    }

    /**
     * Re-calculates attribute values based on the user-updated attribute
     *
     * @param updatingVar Updated attribute
     */
    private void updateValues(int updatingVar) {
        switch (updatingVar) {
            case VELOCITY, ANGLE -> {
                xVelocity = velocity * cos(angle);
                yVelocity = velocity * sin(angle);
                updateValues(INIT_Y);
            }
            case INIT_Y -> {
                flightTime = (yVelocity + sqrt(square(yVelocity)
                        + 2 * initY * GRAVITATIONAL_ACCELERATION)) / GRAVITATIONAL_ACCELERATION;
                distanceTravelled = xVelocity * flightTime;
                maxHeight = square(yVelocity) / (2 * GRAVITATIONAL_ACCELERATION) + initY;
            }
            case FLIGHT_TIME -> {
                initY = -yVelocity * flightTime + GRAVITATIONAL_ACCELERATION * square(flightTime) / 2;
                distanceTravelled = xVelocity * flightTime;
                maxHeight = square(yVelocity) / (2 * GRAVITATIONAL_ACCELERATION) + initY;
            }
            case DISTANCE_TRAVELLED -> {
                flightTime = distanceTravelled / xVelocity;
                initY = -yVelocity * flightTime + GRAVITATIONAL_ACCELERATION * square(flightTime) / 2;
                maxHeight = square(yVelocity) / (2 * GRAVITATIONAL_ACCELERATION) + initY;
            }
            case MAX_HEIGHT -> {
                initY = maxHeight - square(yVelocity) / (2 * GRAVITATIONAL_ACCELERATION);
                flightTime = (yVelocity + sqrt(square(yVelocity)
                        + 2 * initY * GRAVITATIONAL_ACCELERATION)) / GRAVITATIONAL_ACCELERATION;
                distanceTravelled = xVelocity * flightTime;
            }
        }
    }

    /**
     * Graphs the projectile's path from launch to landing and returns it as a <code>String</code>
     * {@inheritDoc}
     *
     * @return Visual representation of the projectile's path
     */
    @Override
    public String toString() {
        // constants for the resolution of the graph
        final int STEPS_X = 50;
        final int STEPS_Y = 10;

        // creates 2d boolean array to store the parabola's points
        boolean[][] graph = new boolean[STEPS_Y + 1][STEPS_X];
        for (int i = 1; i < STEPS_X; i++)
            graph[STEPS_Y - round(getParabolaY(
                    i * distanceTravelled / STEPS_X + initX) / (maxHeight / STEPS_Y))][i - 1] = true;

        // creates the String for the graph
        String str = "";
        for (int y = 0; y < STEPS_Y; y++) {
            // adds the y-axis and the numbers
            String n = truncateDouble(maxHeight - y * maxHeight / STEPS_Y, 2);
            for (int i = n.length(); i < digits(maxHeight) + 3; i++) str += " ";
            str += n + " | ";

            // graphs the line; if an element is true in the boolean array then the parabola passes through that point
            for (int x = 0; x < STEPS_X; x++) {
                if (graph[y][x]) str += "*";
                else str += " ";
            }
            str += "\n";
        }

        // adds the x-axis
        for (int i = 0; i < digits(maxHeight) + 2; i++) str += " ";
        str += "0 |_";
        for (int i = 0; i < STEPS_X + 1; i++) str += "_";
        str += "\n";

        // adds the numbers for the x-axis
        for (int i = 0; i < digits(maxHeight) + 5; i++) str += " ";
        str += truncateDouble(initX, 1);
        for (int i = truncateDouble(initX, 1).length();
             i < STEPS_X - truncateDouble(initX + distanceTravelled, 1).length() + 2; i++) str += " ";
        str += truncateDouble(initX + distanceTravelled, 1);

        return str;
    }

    /**
     * Calculates the y-value of the projectile at some specified x
     *
     * @param x Value to find y-value
     * @return The y-value on the parabola
     */
    private double getParabolaY(double x) {
        return initY + (x - initX) * tan(angle)
                - (GRAVITATIONAL_ACCELERATION * square(x - initX) / (2 * square(xVelocity)));
    }

    /**
     * Calculates the x-value of the projectile at some specified y
     *
     * @param y Value to find x-value
     * @return The x-value on the parabola
     */
    private double[] getParabolaX(double y) {
        double a = -GRAVITATIONAL_ACCELERATION / (2 * square(xVelocity));
        double b = tan(angle);
        double c = initY - y;
        double det = square(b) - 4 * a * c;
        return new double[]{initX + (-b + sqrt(det)) / (2 * a), initX + (-b - sqrt(det)) / (2 * a)};
    }

    /**
     * Finds where the projectile is at a specified time
     *
     * @param time Seconds after launch
     * @return Coordinates of projectile
     */
    public double[] findCoordinates(double time) {
        double x = initX + xVelocity * time;
        return new double[]{x, getParabolaY(x)};
    }

    /**
     * Calculates the time when the projectile reaches a specified x-value
     *
     * @param x Value to find time
     * @return Time in seconds
     */
    public double findTimeX(double x) {
        return (x - initX) / xVelocity;
    }

    /**
     * Calculates the time(s) when the projectile reaches a specified y-value
     *
     * @param y Value to find time
     * @return TIme in seconds
     */
    public double[] findTimeY(double y) {
        double[] xCoords = getParabolaX(y);
        if (findTimeX(xCoords[0]) < 0) return new double[]{findTimeX(xCoords[1])};
        else return new double[]{findTimeX(xCoords[0]), findTimeX(xCoords[1])};
    }

    /**
     * Checks if another projectile is equal to current projectile. If the projectiles land within 1 m of each other,
     * they are considered equal
     *
     * @param projectile Another projectile
     * @return If they are equal
     */
    public boolean equals(Projectile projectile) {
        return Math.abs(projectile.getParabolaX(0)[0] - getParabolaX(0)[0]) <= 1;
    }



    // Getters and setters

    /**
     * Gets the initial velocity
     *
     * @return Velocity in m/s
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Sets the initial velocity and recalculates appropriate attributes
     *
     * @param velocity Must be positive
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
        updateValues(VELOCITY);
    }

    /**
     * Gets the initial angle
     *
     * @return Angle in degrees
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the initial angle and recalculates appropriate attributes
     *
     * @param angle Must be between 0 and 90 degrees
     */
    public void setAngle(double angle) {
        this.angle = angle;
        updateValues(ANGLE);
    }

    /**
     * Gets the initial x-value
     *
     * @return Initial x-value in metres
     */
    public double getInitX() {
        return initX;
    }

    /**
     * Sets the initial x-value
     *
     * @param initX New x-value
     */
    public void setInitX(double initX) {
        this.initX = initX;
    }

    /**
     * Gets the initial height
     *
     * @return Initial height in metres
     */
    public double getInitY() {
        return initY;
    }

    /**
     * Sets the initial height and updates appropriate attributes
     *
     * @param initY Must be positive
     */
    public void setInitY(double initY) {
        this.initY = initY;
        updateValues(INIT_Y);
    }

    /**
     * Gets the duration of flight
     *
     * @return Flight duration in seconds
     */
    public double getFlightTime() {
        return flightTime;
    }

    /**
     * Sets the flight duration and updates appropriate attributes
     *
     * @param flightTime Must be positive
     */
    public void setFlightTime(double flightTime) {
        this.flightTime = flightTime;
        updateValues(FLIGHT_TIME);
    }

    /**
     * Gets the distance travelled
     *
     * @return Distance travelled in metres
     */
    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    /**
     * Sets the distance travelled and updates appropriate attributes
     *
     * @param distanceTravelled Must be positive
     */
    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
        updateValues(DISTANCE_TRAVELLED);
    }

    /**
     * Gets the maximum height
     *
     * @return Max height in metres
     */
    public double getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the maximum height and updates appropriate attributes
     *
     * @param maxHeight Must be positive
     */
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
        updateValues(MAX_HEIGHT);
    }

}
