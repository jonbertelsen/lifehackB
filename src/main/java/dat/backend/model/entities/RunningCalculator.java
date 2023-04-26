package dat.backend.model.entities;

/*
This class will take care of all calculations needed for runningcalculator.jsp.
Every method in this class is going to be static, since the class itself does not contain any data.
 */

/**
 * This class does all the calculations required for the forms in runningcalculator.jsp to work.
 * @author NR
 */

public class RunningCalculator {

    //This method calculates how long you can run (in km) - given a certain time (in minutes) and a given speed (in km. pr. hour).

    /**
     * The method calculates how long you have run (in kilometers) if you input how long you've run (in minutes) and how fast (in km. pr. hour).
     * @param time measured in minutes.
     * @param speed measured in km. pr. hour.
     * @return double
     * @throws IllegalArgumentException This exception is thrown if one of the arguments is 0 or negative.
     * @author NR
     */
    public static double calculateDistance(int time, double speed) throws IllegalArgumentException{
        if(time <= 0) {
            throw new IllegalArgumentException("Time is not allowed to be zero or negative.");
        } else if(speed <= 0){
            throw new IllegalArgumentException("Speed is not allowed to be zero or negative.");
        }
        return (speed * time) / 60;
    }

    //This method calculates how long time (in minutes) it will take to run a certain distance (in km) at a given speed (in km. pr. hour).

    /**
     * This method calculates how long time (in minutes) it will take to run a certain distance (in km) at a given speed (in km. pr. hour).
     * @param distance measured in kilometers.
     * @param speed measured in km. pr. hour.
     * @return double
     * @throws IllegalArgumentException This exception is thrown if one of the arguments is 0 or negative.
     * @author NR
     */
    public static double calculateTime(double distance, double speed) throws IllegalArgumentException{
        if(distance <= 0) {
            throw new IllegalArgumentException("Distance is not allowed to be zero or negative.");
        } else if(speed <= 0){
            throw new IllegalArgumentException("Speed is not allowed to be zero or negative.");
        }
        return (distance * 60) / speed;
    }

    /**
     * This method calculates how fast you are running (in km. pr. hour) given a distance (in km) and a timeframe (in minutes).
     * @param distance measured in kilometers.
     * @param time measured in minutes.
     * @return double
     * @throws IllegalArgumentException This exception is thrown if one of the arguments is 0 or negative.
     * @author NR
     */
    //This method calculates how fast you are running (in km. pr. hour) given a distance (in km) and a timeframe (in minutes).
    public static double calculateSpeed(double distance, int time) throws IllegalArgumentException{
        if(time <= 0) {
            throw new IllegalArgumentException("Time is not allowed to be zero or negative.");
        } else if(distance <= 0){
            throw new IllegalArgumentException("Distance is not allowed to be zero or negative.");
        }
        return (distance * 60) / time;
    }


}