public class Sprint {

    private int numberOfSprints;
    private int sprintDuration;

    public Sprint(int numberOfSprints, int sprintDuration) {
        this.numberOfSprints = numberOfSprints;
        this.sprintDuration = sprintDuration;
    }

    public int getNumberOfSprints() {
        return numberOfSprints;
    }

    public void setNumberOfSprints(int numberOfSprints) {
        this.numberOfSprints = numberOfSprints;
    }

    public int getSprintDuration() {
        return sprintDuration;
    }

    public void setSprintDuration(int sprintDuration) {
        this.sprintDuration = sprintDuration;
    }
}
