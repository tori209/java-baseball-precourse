package baseball;

import camp.nextstep.edu.missionutils.Console;

public class CmdReader {
    private String val;

    public void refreshVal() {
        this.val = Console.readLine();
    }

    public String getVal() {
        return this.val;
    }
}
