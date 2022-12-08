public class Main {
    static long runningTotal;
    public static void main(String[] args) {
        String text = TextHolder.getText();
        text.lines().forEach(s -> runningTotal += resolveInput(s.charAt(0), s.charAt(2)));
        System.out.println(runningTotal);
    }

    private static int resolveInput(char opponentMoveChar, char yourMoveChar) {
        Move opponentMove = Move.getMove(opponentMoveChar);
        Move yourMove = Move.getMove(yourMoveChar);
        if (opponentMove.equals(yourMove)) {
            return yourMove.pointWorth + 3;
        } else if (opponentMove.beatsMove.equals(yourMove)) {
            return yourMove.pointWorth;
        } else {
            return yourMove.pointWorth + 6;
        }
    }
}
enum Move {
    ROCK(),
    PAPER(),
    SCISSOR();
    int pointWorth;
    Move beatsMove;

    static {
        ROCK.pointWorth = 1;
        ROCK.beatsMove = SCISSOR;
        PAPER.pointWorth = 2;
        PAPER.beatsMove = ROCK;
        SCISSOR.pointWorth = 3;
        SCISSOR.beatsMove = PAPER;
    }
    public static Move getMove(char inputMove) {
        return switch (inputMove) {
            case 'A', 'X' -> ROCK;
            case 'B', 'Y' -> PAPER;
            case 'C', 'Z' -> SCISSOR;
            default -> throw new IllegalStateException();
        };
    }
}