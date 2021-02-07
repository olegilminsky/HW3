import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class HW3_Ilminsky {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        selectGame();
    }

    private static void selectGame() {
        System.out.println(ANSI_BLUE + "Добро пожаловать в игровой портал!" + ANSI_RESET);
        int numberGame = 0;
        Scanner scSelectGame = new Scanner(System.in);

        do {
            try {
                System.out.println("На выбор предлагается две игры:");
                System.out.println(ANSI_GREEN + "    1 - угадай число," + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "    2 - угадай слово." + ANSI_RESET);
                System.out.println("Для выбора игры нажмите соответствующую цифру на клавиатуре.");
                System.out.println("Для выхода нажмите 0");

                numberGame = scSelectGame.nextInt();

                if (numberGame == 0) {
                    break;
                } else if (numberGame == 1) {
                    startGuessNumber();
                } else if (numberGame == 2) {
                    startGuessWord();
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println(ANSI_RED + "Введите цифру, соответствующую номеру игры (1 или 2) или 0 для выхода" + ANSI_RESET);
                scSelectGame = new Scanner(System.in);
            }
        } while (!isValidNumGame(numberGame));
        scSelectGame.close();
    }

    private static boolean isValidNumGame(int numberGame) {
        return numberGame >= 0 && numberGame <= 2;
    }

    private static void startGuessNumber() {
        System.out.println("Начинаем игру " + ANSI_GREEN + "\"Угадай число!\"" + ANSI_RESET);
        System.out.println("Загадано число от 0 до 9. У Вас есть три попытки.");

        Random random = new Random();
        int hiddenNumber = random.nextInt(10);
//        System.out.println(hiddenNumber);
        int numberPlayers = -1;
        Scanner scNumber = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            do {
                try {
                    numberPlayers = scNumber.nextInt();
                    scNumber = new Scanner(System.in);
                } catch (NoSuchElementException | IllegalStateException e) {
                    System.out.println(ANSI_RED + "Введите число от 0 до 9!" + ANSI_RESET);
                    scNumber = new Scanner(System.in);
                }
            } while (!isValidNumber(numberPlayers));
//           scNumber.close();
            if (numberPlayers == hiddenNumber) {
                System.out.println(ANSI_GREEN + "Вы угадали!!!" + ANSI_RESET);
                break;
            } else if (i == 2) {
                System.out.println("Вам не удалось угадать число.");
                break;
            }
            if (i != 2) {
                if (numberPlayers < hiddenNumber) {
                    System.out.println(ANSI_YELLOW + "Загаданное число больше." + ANSI_RESET);
                } else {
                    System.out.println(ANSI_YELLOW + "Загаданное число меньше." + ANSI_RESET);
                }
            }
            numberPlayers = -1;
        }

        selectGame();

    }

    private static boolean isValidNumber(int number) {
        return number >= 0 && number <= 9;
    }

    private static void startGuessWord() {
//        System.out.println("Начинаем игру " + ANSI_YELLOW + "\"Угадай слово!\"" + ANSI_RESET);
        System.out.println("На текущий момент игра находится на этапе разработки.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectGame();
    }
}
