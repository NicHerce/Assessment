import java.util.ArrayList;

public class Agile {
    private final String productOwner;
    private final String userStory;
    private final int numberOfSprints;
    private final int sprintDuration;
    private final String sprintDOD;

    private final ArrayList<String> tasks = new ArrayList<>();
    private final ArrayList<Integer> durations = new ArrayList<>();

    public Agile(String productOwner, String userStory, int numberOfSprints, int sprintDuration, String sprintDOD) {
        this.productOwner = productOwner;
        this.userStory = userStory;
        this.numberOfSprints = numberOfSprints;
        this.sprintDuration = sprintDuration;
        this.sprintDOD = sprintDOD;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public String getUserStory() {
        return userStory;
    }

    public int getNumberOfSprints() {
        return numberOfSprints;
    }

    public int getSprintDuration() {
        return sprintDuration;
    }

    public String getSprintDOD() {
        return sprintDOD;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public ArrayList<Integer> getDuration() {
        return durations;
    }
}
