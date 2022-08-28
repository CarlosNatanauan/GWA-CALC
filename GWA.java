import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

class GWA {//lagyan mo ng exception tanga

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        double sum = 0;
        ArrayList<String> subj = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();
        ArrayList<String> comb = new ArrayList<>();
        ArrayList<Double> ave = new ArrayList<>();
        System.out.println("--------GWA CALCUATOR--------");
        callMe c = new callMe();
        DecimalFormat df2 = new DecimalFormat("#.##");
        df2.setRoundingMode(RoundingMode.DOWN);
        try {
            System.out.print("Enter number of subjects: ");
            num = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name of Subjects  ");

            for (int i = 0; i < num; i++) {//ask's the user to input subj names
                int x = i + 1;
                System.out.print("Subject " + x + ": ");
                subj.add(sc.nextLine());//add to ArrayList of subjs
            }

            System.out.println("Enter Grades separeted by spaces ");
            System.out.println("    PRELIMS ->  MID TERMS ->  PRE FINALS ->  FINALS" + "\n");
            for (int i = 0; i < subj.size(); i += 1) {//accepts 4 grading quarter
                System.out.print(subj.get(i) + ": ");
                c.setAve(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                grades.add(c.getAve());//add to ArrayList of grades
                System.out.println("");
            }

            for (int xx = 0; xx < subj.size(); xx++) {//combine name of subj and grades
                comb.add(subj.get(xx) + " - " + df2.format(grades.get(xx)));

                if (grades.get(xx) <= 100 && grades.get(xx) >= 97.50) //add average == remarks
                {
                    ave.add(1.0);
                } else if (grades.get(xx) <= 97.49 && grades.get(xx) >= 94.50) {
                    ave.add(1.25);
                } else if (grades.get(xx) <= 94.49 && grades.get(xx) >= 91.50) {
                    ave.add(1.50);
                } else if (grades.get(xx) <= 91.49 && grades.get(xx) >= 88.50) {
                    ave.add(1.75);
                } else if (grades.get(xx) <= 88.49 && grades.get(xx) >= 85.50) {
                    ave.add(2.00);
                } else if (grades.get(xx) <= 85.49 && grades.get(xx) >= 82.50) {
                    ave.add(2.25);
                } else if (grades.get(xx) <= 82.49 && grades.get(xx) >= 79.50) {
                    ave.add(2.50);
                } else if (grades.get(xx) <= 79.49 && grades.get(xx) >= 76.50) {
                    ave.add(2.75);
                } else if (grades.get(xx) <= 76.49 && grades.get(xx) >= 74.50) {
                    ave.add(3.00);
                } else if (grades.get(xx) < 74.49) {
                    ave.add(5.00);
                } else {
                    ave.add(0.0);
                }

            }
            System.out.println("----------------------------------------------------");
            System.out.println("   SUBJECTS   -> AVERAGE  ->  REMARKS" + "\n");
            for (int z = 0; z < comb.size(); z++) {//displays subj, average and == remarks
                if (ave.get(z) == 1.0) {
                    System.out.println(comb.get(z) + " == " + "(" + ave.get(z) + ") Excelent" + "\n");
                } else if (ave.get(z) == 1.25 || ave.get(z) == 1.50 || ave.get(z) == 1.75) {
                    System.out.println(comb.get(z) + " == " + "(" + ave.get(z) + ") Very Good" + "\n");
                } else if (ave.get(z) == 2.00 || ave.get(z) == 2.25 || ave.get(z) == 2.50) {
                    System.out.println(comb.get(z) + " == " + "(" + ave.get(z) + ") Satisfactory" + "\n");
                } else if (ave.get(z) == 2.75 || ave.get(z) == 3.00) {
                    System.out.println(comb.get(z) + " == " + "(" + ave.get(z) + ") Fair" + "\n");
                } else if (ave.get(z) == 5.00) {
                    System.out.println(comb.get(z) + " == " + "(" + ave.get(z) + ") Failed" + "\n");
                } else {
                    System.out.println(comb.get(z) + " == " + "(" + ave.get(z) + ") N/A" + "\n");
                }
            }

            for (double i : ave) {
                sum += i;
            }
            double average = sum / num;//will devide converted average to number of subjects
            System.out.println("-----------------------------------");
            System.out.println("GWA     : " + df2.format(average));
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}

class callMe {
    private double ave;

    double getAve() {
        return ave;
    }

    void setAve(double prelim, double mid, double preFi, double fi) {
        ave = (prelim * .20) + (mid * .20) + (preFi * .20) + (fi * .40);
    }