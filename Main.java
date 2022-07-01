import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String data = new String();
        String resultat = calc(data);
        System.out.println(resultat);

    }

    public static String calc(String input) throws IOException {
        String result = new String();
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        String[] datas = data.split(" ");
        if (datas.length == 3) {
            String a = datas[0];
            String b = datas[2];
            String d = datas[1];

            String[] rom = new String[11];
            rom[0] = "" ;
            rom[1] = "I";
            rom[2] = "II";
            rom[3] = "III";
            rom[4] = "IV";
            rom[5] = "V";
            rom[6] = "VI";
            rom[7] = "VII";
            rom[8] = "VIII";
            rom[9] = "IX";
            rom[10] = "X";
            List<String> nameList = new ArrayList<>(Arrays.asList(rom));

            boolean bol1 = nameList.contains(a);
            boolean bol2 = nameList.contains(b);

            if  (bol2 && bol1) {
                Roman aa = Roman.valueOf(a);
                Roman bb = Roman.valueOf(b);
                int otvet = 0;
                int c1 = aa.getConvers();
                int c2 = bb.getConvers();

                switch (d) {
                    case "+":
                        otvet = c1 + c2;
                        break;
                    case "-":
                        otvet = c1 - c2;
                        break;
                    case "*":
                        otvet = c1 * c2;
                        break;
                    case "/":
                        otvet = c1 / c2;
                        break;
                    default:
                        throw new IOException();

                }

                if (otvet < 1) {
                    throw new IOException();
                } else if (otvet < 10) {
                    String rimotv = rom[otvet];
                    result = (rimotv);
                } else if (otvet < 20) {
                    String rimotv = rom[otvet- 10];
                    result = ("X" + rimotv);
                } else if (otvet < 30) {
                    String rimotv = rom[otvet- 20];
                    result = ("XX" + rimotv);
                } else if (otvet < 40) {
                    String rimotv = rom[otvet- 30];
                    result = ("XXX" + rimotv);
                } else if (otvet < 50) {
                    String rimotv = rom[otvet- 40];
                    result = ("XL" + rimotv);
                } else if (otvet < 60) {
                    String rimotv = rom[otvet- 50];
                    System.out.println("L" + rimotv);
                } else if (otvet < 70) {
                    String rimotv = rom[otvet- 60];
                    result = ("LX" + rimotv);
                } else if (otvet < 80) {
                    String rimotv = rom[otvet- 70];
                    result = ("LXX" + rimotv);
                } else if (otvet < 90) {
                    String rimotv = rom[otvet- 80];
                    result = ("LXXX" + rimotv);
                } else if (otvet < 100) {
                    String rimotv = rom[otvet- 90];
                    result = ("XC" + rimotv);
                } else if (otvet == 100) {
                    result = "C";
                }



                //System.out.println(otvet);
            }
            else {
                int c1 = Integer.parseInt(a);
                int c2 = Integer.parseInt(b);
                if (c1 <= 10 && c1 <= 10) {
                    switch (d) {
                        case "+" -> result = String.valueOf((c1 + c2));
                        case "-" -> result = String.valueOf((c1 - c2));
                        case "*" -> result = String.valueOf((c1 * c2));
                        case "/" -> result = String.valueOf((c1 / c2));
                        default -> throw new IOException();
                    }
                }
                else {
                    throw new IOException();

                }

            }
        }
        else {
            throw new IOException();

        }

        return result;
    }


}

