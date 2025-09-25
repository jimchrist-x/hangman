import java.util.ArrayList;

public class Score {
    private ArrayList<Double> scores = new ArrayList<Double>();
    public final void setScore(int wordNum, int errors) {
        if (errors<1) {
            scores.add(((double) (wordNum + 1) / (errors + 1) - 1) * 100);
        } else {
            scores.add(((double) (wordNum + 1) / (errors + 1)) * 100);
        }

    }
    public double getCurrentScore() {
        return scores.getLast();
    }
    public ArrayList<Double> getScores() {
        return scores;
    }
}
