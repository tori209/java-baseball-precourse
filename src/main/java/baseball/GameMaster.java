package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class GameMaster {
    private final CmdReader cmdReader;
    private final AnswerValidator answerValidator;
    private int answer;

    GameMaster() {
        cmdReader = new CmdReader();
        answerValidator = new AnswerValidator();
    }

    private void createAnswer() {
        answer = 0;
        for (int i = 0; i < 3; i++) {
            answer *= 10;
            answer += Randoms.pickNumberInRange(1, 9);
        }
    }

    public void startGame() throws IllegalArgumentException {
        // Init Process
        createAnswer();
        answerValidator.setAnswer(Integer.toString(this.answer));

        // Main Test
        do {
            System.out.print("숫자를 입력해주세요 : ");
            cmdReader.refreshVal();
            answerValidator.checkAnswer(cmdReader.getVal());

            if (answerValidator.getBall() != 0) {
                System.out.printf("%d볼 ", answerValidator.getBall());
            }
            if (answerValidator.getStrike() != 0) {
                System.out.printf("%d스트라이크", answerValidator.getStrike());
            }
            if (answerValidator.isNothing()) {
                System.out.print("낫싱");
            }
            System.out.print("\n");

        } while(answerValidator.getStrike() != 3);
    }

    public boolean endGame() throws IllegalArgumentException {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        cmdReader.refreshVal();
        String choice = cmdReader.getVal();

        if (choice.equals("1")) {
            return true;
        } else if (choice.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }


}
