package baseball;

public class GameMaster {
    private final CmdController cmdController;
    private final AnswerChecker answerChecker;

    GameMaster() {
        cmdController = new CmdController();
        answerChecker = new AnswerChecker();
    }

    public void startGame() throws IllegalArgumentException {
        // Init Process
        answerChecker.initAnswer();

        // Main Test
        do {
            cmdController.print("숫자를 입력해주세요 : ");
            answerChecker.checkAnswer(cmdController.read());

            if (answerChecker.getBall() != 0) {
                cmdController.printf("%d볼 ", answerChecker.getBall());
            }
            if (answerChecker.getStrike() != 0) {
                cmdController.printf("%d스트라이크", answerChecker.getStrike());
            }
            if (answerChecker.isNothing()) {
                cmdController.printf("낫싱");
            }
            System.out.print("\n");

        } while(answerChecker.getStrike() != 3);
    }

    public boolean endGame() throws IllegalArgumentException {
        cmdController.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        cmdController.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        String choice = cmdController.read();

        if (choice.equals("1")) {
            return true;
        } else if (choice.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
