package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerChecker {
    private String answer;
    private int strike;
    private int ball;

    private int createAnswer() {
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            ret *= 10;
            ret += Randoms.pickNumberInRange(1, 9);
        }
        return ret;
    }

    private void validation(String input) throws IllegalArgumentException {
        if (input == null || !input.matches("[+-]?[1-9]{3}")) {
            throw new IllegalArgumentException();
        }
    }

    public void initAnswer() {
        this.answer = Integer.toString(createAnswer());
        strike = ball = -1;
    }

    public void checkAnswer(String input) throws IllegalArgumentException {
        validation(input);
        boolean[] inp_checked = {false, false, false};
        boolean[] ans_checked = {false, false, false};

        // Strike Check
        this.strike = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) != this.answer.charAt(i)) {  continue;  }
            inp_checked[i] = ans_checked[i] = true;
            this.strike++;
        }

        // Ball Check
        this.ball = 0;
        for (int i = 0; i < 3; i++) {
            if (inp_checked[i]) {  continue;  }

            // Find Ball
            for (int j = 0; j < 3; j++) {
                if (ans_checked[j]) {  continue;  }
                if (input.charAt(i) != this.answer.charAt(j)) {  continue;  }
                ans_checked[j] = true;
                this.ball++;
                break;
            }
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }
}
