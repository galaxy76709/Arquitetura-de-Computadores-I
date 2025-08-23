/**
    Arquitetura de Computadores I - Guia_03.java
    999999 - Xxx Yyy Zzz
*/
public class Guia_03
{
  private static int errors = 0;

  public static void test_equals ( Object x, Object y )
  {
     if ( (""+x).compareTo(""+y) != 0 )
       errors = errors + 1;
  }

  public static String test_report  ( )
  {
     String result = ""+errors;
    errors = 0; // Reinicia o contador para a proxima bateria de testes
    return ( result );
  }

  // ---------------------- COMPLEMENTO DE 1 ----------------------

  public static String C1 ( int length, String value )
  {
    // garantir comprimento
    while (value.length() < length)
        value = "0" + value;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++)
    {
        char c = value.charAt(i);
        sb.append( (c=='0') ? '1' : '0' );
    }
    return sb.toString();
  }

// ---------------------- COMPLEMENTO DE 2 ----------------------

  public static String C2 ( int length, String value )
  {
    // Garante que o valor tenha o comprimento correto antes de calcular C1
    while (value.length() < length) {
        value = "0" + value;
    }
    
    String c1 = C1(length, value);
    char[] bits = c1.toCharArray();
    boolean carry = true;

    for (int i = length-1; i >= 0; i--)
    {
        if (carry)
        {
            if (bits[i]=='0')
            {
                bits[i] = '1';
                carry = false;
            }
            else
            {
                bits[i] = '0';
                carry = true;
            }
        }
    }
    return new String(bits);
  }


 // ---------------------- C1 / C2 em outras bases ----------------------

  private static String toBinary ( int length, String value, int base )
  {
    int decimal = Integer.parseInt(value, base);
    String bin = Integer.toBinaryString(decimal);

    while (bin.length() < length)
        bin = "0" + bin;

    if (bin.length() > length)
        bin = bin.substring(bin.length()-length);

    return bin;
  }

  public static String C1 ( int length, String value, int base )
  {
    return C1(length, toBinary(length, value, base));
  }

  public static String C2 ( int length, String value, int base )
  {
    return C2(length, toBinary(length, value, base));
  }
 

  // ---------------------- BINÁRIO COM SINAL → DECIMAL ----------------------

  public static String sbin2dec ( String value )
  {
    int length = value.length();
    boolean negative = (value.charAt(0)=='1');

    if (!negative)
    {
        return ""+Integer.parseInt(value, 2);
    }
    else
    {
        // CORREÇÃO: Para encontrar a magnitude de um número negativo em C2,
        // devemos calcular o C2 dele novamente. A lógica original subtraía 1,
        // o que é incorreto. A lógica correta é somar 1.
        
        // Inverter os bits (Complemento de 1)
        String c1 = C1(length, value);

        // Somar 1 (lógica do "carry", igual à usada no método C2)
        char[] arr = c1.toCharArray();
        boolean carry = true;
        for (int i = length-1; i>=0; i--)
        {
            if (carry)
            {
                if (arr[i]=='0')
                {
                    arr[i] = '1';
                    carry = false;
                }
                else
                {
                    arr[i] = '0';
                    carry = true;
                }
            }
        }

        int magnitude = Integer.parseInt(new String(arr), 2);
        return ""+(-magnitude);
    }
  }


  // ---------------------- AVALIAÇÃO DE EXPRESSÕES ----------------------

  public static String eval ( String value1, String op, String value2, int base )
  {
    int dec1 = Integer.parseInt(value1.replace(".",""), base);
    int dec2 = Integer.parseInt(value2.replace(".",""), base);

    int result = 0;
    if (op.equals("-"))
        result = dec1 - dec2;

    return Integer.toString(result, base).toUpperCase();
  }

  public static String evalB1B2 ( String value1, int base1, String op, String value2, int base2 )
  {
    int dec1 = Integer.parseInt(value1.replace(",","").replace(".",""), base1);
    int dec2 = Integer.parseInt(value2.replace(",","").replace(".",""), base2);

    int result = 0;
    if (op.equals("-"))
        result = dec1 - dec2;

    return Integer.toString(result, Math.max(base1, base2)).toUpperCase();
  }// end eval ( ) 
 
  // ---------------------- MAIN ----------------------

  public static void main ( String [ ] args )
  {
    System.out.println ( "Guia_03 - Java Tests   " );
    System.out.println ( "  999999 - Xxx Yyy Zzz" );
    System.out.println ( );

    // Testes corrigidos para refletir os resultados corretos das funcoes
    test_equals  ( C1         ( 6,        "1001"  ),  "110110" );
    test_equals  ( C1         ( 8,        "1101"  ),  "11110010" );
    test_equals  ( C2         ( 6,    "101011"  ),  "010101" );
    test_equals  ( C2         ( 7,     "101101" ),  "1010011" );
    test_equals  ( C2         ( 8,     "110010" ),  "11001110" );
    System.out.println        ( "1. errorTotalReportMsg  = "+test_report ( ) );

    test_equals  ( C1          ( 6, "231",    4 ),  "010010" );
    test_equals  ( C1          ( 8,   "E7", 16 ),  "00011000" );
    test_equals  ( C2          ( 6,  "132",   4 ),  "100010" );
    test_equals  ( C2          ( 7,  "173",   8 ),  "0000101" );
    test_equals  ( C2          ( 8,   "9F",  16 ),  "01100001" );
    System.out.println         ( "2. errorTotalReportMsg  = "+test_report ( ) );

    test_equals  ( sbin2dec (        "10011" ), "-13" );
    test_equals  ( sbin2dec (      "110111" ), "-9" );
    test_equals  ( sbin2dec (      "100101" ), "-27" );
    test_equals  ( sbin2dec (    "1010011" ), "-45" );
    test_equals  ( sbin2dec (    "1111011" ), "-5" );
    System.out.println         ( "3. errorTotalReportMsg  = "+test_report ( ) );

    test_equals  ( eval         (      "11001", "-",  "1111",  2 ), "1010" );
    test_equals  ( eval         ( "1011000", "-", "1011",  2 ), "1001101" );
    test_equals  ( eval         (          "231", "-",    "132",  4 ), "33" );
    test_equals  ( eval         (          "654", "-",    "375",  8 ), "257" );
    test_equals  ( eval         (         "8B7", "-",    "B13", 16 ), "-25C" );
    System.out.println          ( "4. errorTotalReportMsg  = "+test_report ( ) );

    test_equals  ( evalB1B2 (    "110101",   2, "-",        "1011",   2 ), "101010" );
    test_equals  ( evalB1B2 ( "1011001",   2, "-",           "57",   8 ), "52" );
    test_equals  ( evalB1B2 (         "312" ,   4, "-",            "5C", 16 ), "-26" );
    test_equals  ( evalB1B2 (          "B2" ,  16, "-",  "1101101",   2 ), "45" );
    test_equals  ( evalB1B2 (          "4F" ,  16, "-",            "6E", 16 ), "-1F" );
    System.out.println          ( "5. errorTotalReportMsg  = "+test_report ( ) );

    System.out.print ( "\n\nApertar ENTER para terminar." );
    System.console ( ).readLine ( );
  }
}