import java.util.Scanner;
import java.util.*;

public class Gradebook {
    public static void main(String[] args) {
        
        // initialize scanner and array lists
        Scanner in = new Scanner(System.in);
        ArrayList<String> classes = new ArrayList<>();
        ArrayList<String> grades = new ArrayList<>();
        ArrayList<Integer> credits = new ArrayList<>();
        ArrayList<Double> GPAs = new ArrayList<>();
        
        // get input from user: how many classes
        System.out.print("Please enter the number of classes you have: ");
        int numClasses = in.nextInt();
        in.nextLine();
        
        //for each class, ask user for name, grade, and credits and add values to array list
        for (int i = 1; i <= numClasses; i++){
           System.out.print("Please enter class " + i + " name: ");
           classes.add(in.nextLine());
           System.out.print("Please enter class " + i + " grade: ");
           grades.add(in.nextLine());
           System.out.println("Please enter class " + i + " credit hours: ");
           credits.add(Integer.parseInt(in.nextLine()));
        }

        // for each class, convert the letter grade to GPA
        for (int j = 1; j <= numClasses; j++){
           double gpa = GradeToGPA(grades.get(j-1));
           GPAs.add(gpa);
        }
        
        // print table:
        System.out.println();
        System.out.println("Class\tGPA\tCredit"); //header first
        for (int k = 1; k <= numClasses; k++){ // for each class, print the class, gpa, credits, then start new line
           System.out.print("\n" + classes.get(k-1) + "\t" + GPAs.get(k-1) + "\t" + credits.get(k-1) + "\n");
        }
        
        double[] gpaPlusCredits = getGPA(numClasses, GPAs, credits);
        System.out.printf("Total\t%.2f\t%d\n\n", gpaPlusCredits[0], (int) gpaPlusCredits[1]);
        
    }
    
    public static double GradeToGPA(String grade) { // receive letter grade, calculate gpa, add to GPAs list. return... ?
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B": return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C": return 2.0;
            case "C-": return 1.7;
            case "D+": return 1.3;
            case "D": return 1.0;
            case "D-": return 0.7;
            case "F": return 0.0;
            default: return 0.0;
      }
    }
     public static double[] getGPA(int numClasses, ArrayList<Double> GPAs, ArrayList<Integer> credits) {
        double totalPoints = 0; // numerator in fraction (gpa*credithrs)/(totalcredits)
        int totalCredits = 0; //calculate total credits
        
        for (int q = 0; q < numClasses; q++) {
           totalPoints += GPAs.get(q) * credits.get(q);
           totalCredits += credits.get(q);
         }
         
        double finalGPA = (totalCredits == 0) ? 0 : (totalPoints/totalCredits);
        return new double[]{finalGPA, totalCredits};
    }
}