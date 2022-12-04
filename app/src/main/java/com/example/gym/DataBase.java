package com.example.gym;

import java.util.ArrayList;

public class DataBase {
    private static ArrayList<Exercise> allActivity;
    public static ArrayList<Exercise> myMondayActivity;
    public static ArrayList<Exercise> myTuesdayActivity;
    public static ArrayList<Exercise> myWednesdayActivity;
    public static ArrayList<Exercise> myThursdayActivity;
    public static ArrayList<Exercise> myFridayActivity;
    public static ArrayList<Exercise> mySaturdayActivity;
    public static ArrayList<Exercise> mySundayActivity;
    private static ArrayList<Exercise> activityDone;

    int id = 0;

    public DataBase() {
        if (allActivity == null) {
            allActivity = new ArrayList<>();
            initDataBase();
        }
        if (null == myMondayActivity) {
            myMondayActivity = new ArrayList<>();
        }
        if (null == myTuesdayActivity) {
            myTuesdayActivity = new ArrayList<>();
        }
        if (null == myWednesdayActivity) {
            myWednesdayActivity = new ArrayList<>();
        }
        if (null == myThursdayActivity) {
            myThursdayActivity = new ArrayList<>();
        }
        if (null == myFridayActivity) {
            myFridayActivity = new ArrayList<>();
        }
        if (null == mySaturdayActivity) {
            mySaturdayActivity = new ArrayList<>();
        }
        if (null == mySundayActivity) {
            mySundayActivity = new ArrayList<>();
        }
        if (activityDone == null) {
            activityDone = new ArrayList<>();
        }

    }

    public static ArrayList<Exercise> getAllActivity() {
        return allActivity;
    }

    public static ArrayList<Exercise> getActivityDone() {
        return activityDone;
    }

    public static boolean removeFromDoneActivity(Exercise e){
        return activityDone.remove(e);
    }

    public void initDataBase(){
        id++;
        allActivity.add(new Exercise(id,"Push up",
                "https://image.shutterstock.com/image-photo/group-adults-performing-push-exercise-260nw-493699177.jpg",
                "Push-ups are a basic exercise used in civilian athletic training" +
                        " or physical education and commonly in military physical training.",false));

        id++;
        allActivity.add(new Exercise(id,"Squat",
                "https://image.shutterstock.com/image-photo/muscular-athletes-doing-workout-gym-600w-1480312115.jpg",
                "A squat is a strength exercise in which the trainee lowers their" +
                        " hips from a standing position and then stands back up",false));

        id++;
        allActivity.add(new Exercise(id,"Chest fly",
                "https://image.shutterstock.com/image-photo/young-sporty-woman-using-pectoral-260nw-1123584305.jpg",
                "A chest fly is a weightlifting exercise that primarily targets the pectoral muscles." +
                        " It is a variation of the standard bench press and is performed" +
                        " by lying on a flat bench with a weight in each hand." +
                        " You can do this exercise with dumbbells, barbells, or cables",false));

        id++;
        allActivity.add(new Exercise(id,"leg press",
                "https://image.shutterstock.com/image-photo/woman-doing-fitness-training-on-260nw-714083116.jpg",
                "The leg press is a great multiple joint exercise for those looking" +
                        " for increased lower body strength. Muscles involved: gluteus," +
                        " hamstrings, quadriceps",false));
    }
}
