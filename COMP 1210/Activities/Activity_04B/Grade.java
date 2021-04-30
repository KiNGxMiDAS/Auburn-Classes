/*****************************************************************************
 * Program defines the name of the student, a student's grade which consists *
 * activities, quizzes, projects and exams.                                  *
 *                                                                           *
 * Activity 4B                                                               *
 * @author Midas Oden                                                        *
 * @version September 19, 2019                                               *
 *****************************************************************************/
 
public class Grade {

// Instance Variables

   private String studentName;
   private double exam1, exam2, finalExam;
   private double activityAvg, quizAvg, projectAvg;
   
  /**
   * exam1, exam2, and final defined as well as grade weight.
   */
   public static final int EXAM_1 = 1, EXAM_2 = 2, FINAL = 3;
   private static final double EXAM_WEIGHT = 0.15,
                FINAL_WEIGHT = 0.30, ACT_WEIGHT = 0.05,
                QUIZ_WEIGHT = 0.10, PROJ_WEIGHT = 0.25;

// Constructor

  /**
   * @param studentNameIn takes input for the student's name.
   */

   public Grade(String studentNameIn) {
   
      studentName = studentNameIn;
   
   }
   
// Methods

  /**
   * Sets the lab averages for the student's overall grade.
   *
   * @param activityAvgIn takes input for the activity average
   * @param quizAvgIn takes input for the quiz average
   */

   public void setLabAverages(double activityAvgIn, double quizAvgIn) {
   
      activityAvg = activityAvgIn;
      quizAvg = quizAvgIn;
   
   }
   
  /**
   * Sets the project averages for the student's overall grade.
   *
   * @param projectAvgIn takes input for the project average
   */
   
   public void setProjectAvg(double projectAvgIn) {
   
      projectAvg = projectAvgIn;
   
   }
   
  /**
   * Sets the exam scores for the student's overall grade.
   *
   * @param examType takes input of type integer designating 
   * the first, second, and final exam
   *
   * @param examScoreIn takes input of type double of the 
   * overall score of the combined exams
   */

   public void setExamScore(int examType, double examScoreIn) {
   
      if (examType == EXAM_1) {
         exam1 = examScoreIn;
      }
      else if (examType == EXAM_2) {
         exam2 = examScoreIn;
      }
      else if (examType == FINAL) {
         finalExam = examScoreIn;
      }
   
   }
   
  /**
   * Calculates the student's overall grade.
   *
   * @return Returns the student's grade as a double value.
   */
   
   public double calculateGrade() {
   
      double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
         + finalExam * FINAL_WEIGHT
         + activityAvg * ACT_WEIGHT
         + quizAvg * QUIZ_WEIGHT
         + projectAvg * PROJ_WEIGHT;
   
      return grade;
   }
   
  /**
   * This method prints the student's grade information.
   *
   * @return Returns a string to be printed for the main method
   */
   
   public String toString() {
   
      return "Name: " + studentName + "\n"
         + "Course Grade: " + calculateGrade();
   
   }
   
}