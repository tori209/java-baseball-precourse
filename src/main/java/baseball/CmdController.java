package baseball;

import camp.nextstep.edu.missionutils.Console;

public class CmdController {
    public String read() {
        return Console.readLine();
    }

    public void print(String out) {
        System.out.print(out);
    }

    public void printf(String out, Object... args) {
        System.out.printf(out, args);
    }
}
