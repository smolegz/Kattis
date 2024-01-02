import java.util.*;

public class tennis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String names = input.nextLine();
        String playerA;
        String playerB;
        String[] players = names.split(" ");
        playerA = players[0];
        playerB = players[1];

        int n = Integer.parseInt(input.nextLine());

        String[][] table = new String[n][];

        for (int i = 0; i < n; i++) {
            String sets = input.nextLine();
            String[] arr = sets.split(" ");
            table[i] = arr;
        }

        for (int j = 0; j < table.length; j++) {
            boolean isTrue = false;
            int winsA = 0;
            int winsB = 0;
            for (int k = 0; k < table[j].length; k++) {
                if (table[j].length == 1 || table[j].length == 4 || table[j].length == 5) {
                    isTrue = true;
                    break;
                }
                String[] s = table[j][k].split(":");
                int scoreA = Integer.parseInt(s[0]);
                int scoreB = Integer.parseInt(s[1]);

                if (k == 2  && (winsA ==  2 || winsB == 2)) {
                    isTrue = true;
                    break;
                }


                if (scoreA == scoreB && scoreA >= 7) {
                    isTrue = true;
                    break;
                }

                if (scoreA == scoreB && scoreA <=6) {
                    isTrue = true;
                    break;
                }

                if (scoreA < 6 && scoreB < 6) {
                    isTrue = true;
                    break;
                }

                if (k == 0 || k == 1) {
                    int total = scoreA + scoreB;
                    if (total > 13) {
                        isTrue = true;
                        break;
                    }
                    if (total == 13) {
                        if (playerA.equals("federer") && scoreA < scoreB) {
                            isTrue = true;
                            break;
                        } else if (playerB.equals("federer") && scoreB < scoreA) {
                            isTrue = true;
                            break;
                        } else {
                            winsA = scoreA > scoreB ? winsA + 1 : winsA;
                            winsB = scoreB > scoreA ? winsB + 1 : winsB;
                        }
                    }
                }

                if (Math.abs(scoreA - scoreB) >=2) {
                    if (playerA.equals("federer") && scoreA < scoreB) {
                        isTrue = true;
                        break;
                    } else if (playerB.equals("federer") && scoreB < scoreA) {
                        isTrue = true;
                        break;
                    } else {
                        winsA = scoreA > scoreB ? winsA + 1 : winsA;
                        winsB = scoreB > scoreA ? winsB + 1 : winsB;
                    }
                }

                if (k == 3 && Math.max(scoreA, scoreB) >= 6 && Math.abs(scoreA - scoreB) < 2) {
                    isTrue = true;
                    break;
                }

            }
            if (isTrue) {
                System.out.println("ne");
                continue;
            }

            if (winsA >= 2 || winsB >= 2) {
                System.out.println("da");
            } else {
                if (!playerA.equals("federer") && !playerB.equals("federer")) {
                    System.out.println("ne");
                }
            }
        }

    }
}