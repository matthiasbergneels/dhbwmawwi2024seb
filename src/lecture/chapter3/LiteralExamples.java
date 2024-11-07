package lecture.chapter3;

public class LiteralExamples {

  public static void main(String[] args) {

    // Ganzzahlen-Literalen

    int numberA;

    numberA = 177;                 // --> Dezimalsystem (Basis 10)
    System.out.println(numberA);

    numberA = 010;                // --> Oktablsystem (Basis 8)
    System.out.println(numberA);

    numberA = 0x22;               // --> Hexadezimalsystem (Basis 16)
    System.out.println(numberA);

    numberA = -0b10;               // --> Binärsystem (Basis 2)
    System.out.println(numberA);


    int rgbColor = 0xFF0000;
    System.out.println(rgbColor);

    // Long-Literal (Suffix l bzw L)
    long numberB = 314000000000L;

    // _ zur Segmentierung für die bessere Lesbarkeit
    numberA = 2_147_000_000;

    // Gleitkommaliterale
    double numberC;

    numberC = 5.0;
    System.out.println(numberC);

    numberC = .452;
    System.out.println(numberC);

    numberC = 1.;
    System.out.println(numberC);

    numberC = 1.1e5;
    System.out.println(numberC);

    numberC = 1.1e-3d;
    System.out.println(numberC);

    float numberE;

    numberE = 5.0f;
    System.out.println(numberE);


    // Char-Literal
    char firstSign;

    firstSign = 'a';
    firstSign = '!';
    firstSign = '-';
    firstSign = '\'';
    System.out.println(firstSign);


    // Zeichenkettenliteral (String-Literal)
    String myText;

    myText = "Hello \nmeine \"lieben\" \tStudierenden! \u2764";
    System.out.println(myText);


    String html = "<html>\n" +
      "\t<body>\n" +
      "\t\t<p>Hello, world</p>\n" +
      "\t</body>\n" +
      "</html>";

    System.out.println(html);

    html = """
      <html>
        <head>
        </head>
        <body>
          <p>Hello, world</p>
        </body>
      </html>
      """;

    System.out.println(html);


    int numberK;

    String myMessage;

    myMessage = "Hier steht jetzt ganz viel Text!!";


  }
}
