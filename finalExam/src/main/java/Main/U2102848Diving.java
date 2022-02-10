package Main;

import java.util.Arrays;

/**
 *
 * @author Hassanal
 */
public class U2102848Diving {
    private String name;
    private String country;
    private double [] score; // 7 judges and 3 tries
    private double difficulty; // 1 score and 3 tries
    private double finalScore;
    
    
    public U2102848Diving(String name, String country, double [] score, double difficulty){
        this.name = name;
        this.country = country;
        this.score = new double[7];
        this.score = score;
        this.difficulty = difficulty;
        this.finalScore = 0.0;
    }
    
    public U2102848Diving(double [] score, double difficulty){
        this.score = score;
        this.difficulty = difficulty;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public double calculateScore (){
        double result;
        //sort
        for ( int pass  = 1 ; pass<score.length ; pass++){
            for ( int i = 0; i < score.length - 1; i++){
                if ( score [i] > score [i+1]){
                    double temp = score [i];
                    score [i] = score [i+1];
                    score[i+1] = temp;
                }
            }
        }
        
        finalScore += (score[2] + score [3] + score [4]) * difficulty;
        result = finalScore;
        return result;
    }

    @Override
    public String toString() {
        return "name =" + name + ", country=" + country +
                ", score=" + Arrays.toString(score) + ", difficulty=" + difficulty
                + ", finalScore=" + finalScore;
    }
}
