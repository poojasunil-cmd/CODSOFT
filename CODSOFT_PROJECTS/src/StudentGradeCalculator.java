import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter total number of subjects: ");
        int numSubjects = scan.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("Enter marks for subject " + i + "(out of 100): ");
            int marks = scan.nextInt();

           
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Enter marks between 0 and 100.");
                System.out.println("Enter marks for subject " + i + "out of 100): ");
                marks = scan.nextInt();
            }
            
            totalMarks += marks;
        }
        System.out.println("Student Result: ");
        System.out.println("Total marks obtained in all subjects: " + totalMarks);

       
        int AveragePercentage = totalMarks / numSubjects;
        System.out.println("Average Percentage: " + AveragePercentage + " %");

        if (AveragePercentage >= 90) {
            System.out.println("Your grade: A+");
        }

        else if (AveragePercentage >= 80) {
            System.out.println("Your grade: A");
        }

        else if (AveragePercentage >= 70) {
            System.out.println("Your grade: B");
        }

        else if (AveragePercentage >= 60) {
            System.out.println("Your grade: B+");
        }

        else if (AveragePercentage >= 50) {
            System.out.println("Your grade: C");
        }

        else if (AveragePercentage >= 35) {
            System.out.println("Your grade: C+");
        }

        else {
            System.out.println("Your grade is: F");
        }

        scan.close();
    }
}

