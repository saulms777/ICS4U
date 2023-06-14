package People;

/**
 * The WorkShift class is used for easy access of work shifts throughout the day.
 * Each work shift has a start time and an end time.
 *
 * @author Samuel Zhang
 */
public final class WorkShift {

    /**
     * Start time in military time for the work shift.
     */
    private final int startTime;

    /**
     * End time in military time for the work shift.
     */
    private final int stopTime;

    /**
     * Constructor for WorkShift. The constructor is made private as instances should be
     * made with the static factory methods provided.
     *
     * @param startTime Start time
     * @param stopTime Stop time
     */
    private WorkShift(int startTime, int stopTime) {
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    /**
     * Returns a String of the start time in 24-hour time.
     *
     * @return 24-hour time equivalent
     */
    public String seeStartTime() {
        String s = "" + startTime % 100;
        if (s.length() == 1) s = "0" + s;
        return startTime / 100 + ":" + s;
    }

    /**
     * Returns a String of the end time in 24-hour time.
     *
     * @return 24-hour time equivalent
     */
    public String seeStopTime() {
        String s = "" + stopTime % 100;
        if (s.length() == 1) s = "0" + s;
        return stopTime / 100 + ":" + s;
    }

    /**
     * Factory method for morning shift instance, which lasts from 6:00 to noon.
     *
     * @return WorkShift instance for morning shift
     */
    public static WorkShift getMorningShift() {
        return new WorkShift(600, 1200);
    }

    /**
     * Factory method for afternoon shift instance, which lasts from noon to 18:00.
     *
     * @return WorkShift instance for afternoon shift
     */
    public static WorkShift getAfternoonShift() {
        return new WorkShift(1200, 1800);
    }

    /**
     * Factory method for evening shift instance, which lasts from 18:00 to midnight.
     *
     * @return WorkShift instance for evening shift
     */
    public static WorkShift getEveningShift() {
        return new WorkShift(1800, 0);
    }

    /**
     * Factory method for night shift instance, which lasts from midnight to 6:00.
     *
     * @return WorkShift instance for night shift
     */
    public static WorkShift getNightShift() {
        return new WorkShift(0, 600);
    }

}
