import java.util.Scanner;

public class OnlineExaminationSystem {

    // Define global variables
    static String username = "";
    static String password = "";
    static String firstName = "";
    static String lastName = "";
    static int totalQuestions = 5;
    static int correctAnswers = 0;
    static int timeLimit = 10; // In minutes

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLoggedIn = false;

        // Login or Register
        System.out.println("Welcome to the Online Examination System");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                isLoggedIn = login();
                break;
            case 2:
                register();
                isLoggedIn = true;
                break;
            case 3:
                System.out.println("Thank you for using the Online Examination System");
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        if (isLoggedIn) {
            // Update profile and password
            updateProfile();

            // Selecting answers for MCQs
            takeExam();

            // Closing session and logout
            System.out.println("Thank you for using the Online Examination System");
            System.exit(0);
        }
    }

    // Login function
    public static boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        username = sc.nextLine();

        System.out.print("Enter password: ");
        password = sc.nextLine();

        // Check username and password
        // Here you can add your own validation logic
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    // Register function
    public static void register() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first name: ");
        firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        lastName = sc.nextLine();

        System.out.print("Enter username: ");
        username = sc.nextLine();

        System.out.print("Enter password: ");
        password = sc.nextLine();

        System.out.println("Registration successful!");
    }

    // Update profile and password function
    public static void updateProfile() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to update your profile? (Y/N): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Enter new first name: ");
            firstName = sc.nextLine();

            System.out.print("Enter new last name: ");
            lastName = sc.nextLine();

            System.out.println("Profile updated!");
        }

        System.out.print("Do you want to update your password? (Y/N): ");
        choice = sc.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Enter new password: ");
            password = sc.nextLine();

            System.out.println("Password updated!");
        }
    }

    // Take exam function
    public static void takeExam() {
        Scanner sc = new Scanner(System.in);

        System.out.println("You have " + timeLimit + " minutes to complete the exam");
        long startTime = System.currentTimeMillis();

        System.out.println("Question 1: Who is the current CEO of Microsoft?");
        System.out.println("A. Bill Gates");
        System.out.println("B. Satya Nadella");
        System.out.println("C. Jeff Bezos");
        System.out.println("D. Mark Zuckerberg");
        System.out.print("Enter your answer (A/B/C/D): ");
        String answer1 = sc.nextLine();

        if (answer1.equalsIgnoreCase("B")) {
            correctAnswers++;
        }

        // Question 2
        System.out.println("Question 2: What is the largest organ in the human body?");
        System.out.println("A. Brain");
        System.out.println("B. Skin");
        System.out.println("C. Liver");
        System.out.println("D. Heart");
        System.out.print("Enter your answer (A/B/C/D): ");
        String answer2 = sc.nextLine();

        if (answer2.equalsIgnoreCase("B")) {
            correctAnswers++;
        }

        // Question 3
        System.out.println("Question 3: Who wrote the novel 'To Kill a Mockingbird'?");
        System.out.println("A. Harper Lee");
        System.out.println("B. J.K. Rowling");
        System.out.println("C. Stephen King");
        System.out.println("D. George Orwell");
        System.out.print("Enter your answer (A/B/C/D): ");
        String answer3 = sc.nextLine();

        if (answer3.equalsIgnoreCase("A")) {
            correctAnswers++;
        }

        // Question 4
        System.out.println("Question 4: Which planet in our solar system is known as the 'Red Planet'?");
        System.out.println("A. Jupiter");
        System.out.println("B. Mars");
        System.out.println("C. Venus");
        System.out.println("D. Saturn");
        System.out.print("Enter your answer (A/B/C/D): ");
        String answer4 = sc.nextLine();

        if (answer4.equalsIgnoreCase("B")) {
            correctAnswers++;
        }

        // Question 5
        System.out.println("Question 5: What is the currency of Japan?");
        System.out.println("A. Yen");
        System.out.println("B. Euro");
        System.out.println("C. Dollar");
        System.out.println("D. Pound");
        System.out.print("Enter your answer (A/B/C/D): ");
        String answer5 = sc.nextLine();

        if (answer5.equalsIgnoreCase("A")) {
            correctAnswers++;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime) / 1000; // In seconds

        // Check if time is up
        if (elapsedTime >= timeLimit * 60) {
            System.out.println("Time is up! Your answers have been submitted automatically.");
        } else {
            // Auto-submit function
            System.out.println("Do you want to submit your answers now? (Y/N): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Your answers have been submitted.");
            } else {
                System.out.println("Your answers will be submitted automatically when time is up.");
            }
        }

        // Calculate score
        int score = (int) Math.round((double) correctAnswers / totalQuestions * 100);
        System.out.println("Your score is " + score + "%");
    }
}
