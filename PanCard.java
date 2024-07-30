import java.util.*;

class PanCard {
    private String firstName;
    private String lastName;
    private String panCardNumber;

    // Constructor
    public PanCard(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.panCardNumber = generatePan(lastName);
    }

    // Getter for PAN card number
    public String getPanCardNumber() {
        return panCardNumber;
    }

    // Method to generate PAN card number
    private String generatePan(String lastName) {
        Random rand = new Random();
        StringBuilder pan = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char randLetter = (char) (rand.nextInt(26) + 'A');
            pan.append(randLetter);
        }
        char charOp;
        if (rand.nextBoolean()) {
            charOp = 'P';
        } else {
            charOp = 'O';
        }
        pan.append(charOp);

        char lastFl = Character.toUpperCase(lastName.charAt(0));
        pan.append(lastFl);

        int num = rand.nextInt(10000);
        String randNum = String.format("%04d", num);
        pan.append(randNum);

        char letter = (char) (rand.nextInt(26) + 'A');
        pan.append(letter);

        return pan.toString();
    }
}

public class PanCardApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name:");
        String lastName = sc.nextLine();

        PanCard panCard = new PanCard(firstName, lastName);
        System.out.println("PAN NUMBER: " + panCard.getPanCardNumber());

        sc.close();
    }
}