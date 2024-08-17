package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        GameMaster gameMaster = new GameMaster();
        do {
            gameMaster.startGame();
        } while (gameMaster.endGame());
    }
}
