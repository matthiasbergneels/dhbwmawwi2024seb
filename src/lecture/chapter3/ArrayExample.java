package lecture.chapter3;

public class ArrayExample {

  public static void main(String[] args) {
    /*
    byte lottoNumberA;
    byte lottoNumberB;
    byte lottoNumberC;
    byte lottoNumberD;
     */

    System.out.println("args.length " + args.length);

    byte[] lottoNumbers;

    lottoNumbers = new byte[6];

    lottoNumbers[0] = 6;
    lottoNumbers[1] = 14;
    lottoNumbers[2] = 36;

    System.out.println("lottoNumbers.length " + lottoNumbers.length);

    System.out.println(lottoNumbers[1]);
    System.out.println(lottoNumbers[5]);

    int[] tomorrowLottoNumbers = {43, 12, 41, 18, 8, 23};
    System.out.println(tomorrowLottoNumbers[2]);

    char[][] tictactoe = new char[3][3];

    tictactoe[1][1] = 'X';
    tictactoe[2][2] = 'O';

    char[][][] chess3D = new char[8][8][8];

    // Speichern eines Buches
    String[][][] myBook = new String[2][][];

    System.out.println("Anzahl Kapitel: myBook.length " + myBook.length);

    // 1. Dimension --> Kapitel 1 (Index 0)
    myBook[0] = new String[2][];

    // 2. Dimension Kapitel 1 - Satz 1
    myBook[0][0] = new String[5];
    System.out.println("Anzahl Sätze im ersten Kapitel: myBook[0].length " + myBook[0].length);

    // 3. Dimension - Kapitel 1 - Satz 1 - Wörter
    System.out.println("Anzahl Wörter erste Satz, erstes Kapitel: myBook[0][0].length " + myBook[0][0].length);
    myBook[0][0][0] = "Hallo";
    myBook[0][0][1] = "meine";
    myBook[0][0][2] = "Freunde";
    myBook[0][0][3] = "am";
    myBook[0][0][4] = "See";

    // 2. Dimension Kapitel 1 - Satz 2
    myBook[0][1] = new String[3];

    // 3. Dimension - Kapitel 1 - Satz 2 - Wörter
    System.out.println("Anzahl Wörter zweiten Satz, erstes Kapitel: myBook[0][1].length " + myBook[0][1].length);
    myBook[0][1][0] = "Ihr";
    myBook[0][1][1] = "seid";
    myBook[0][1][2] = "doof";

    // ... Satz 3, 4, 5

    String[][][] mySecondBook = {{{"Hallo", "meine", "Freunde", "am", "See"}, {"Schlaft", "mir", "nicht", "ein"}, {}}, {{}, {}}};

  }
}
