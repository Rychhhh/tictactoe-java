import java.util.*;

public class Main {
        static ArrayList<Integer> playerOption = new ArrayList<Integer>();
        static ArrayList<Integer> cpuOption = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] papanBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        tampilBoard(papanBoard);



        while(true) {
            // input user
            Scanner inputUser = new Scanner(System.in);

            System.out.printf("Masukkan Pilihan Anda : ");
            int option = inputUser.nextInt();

            while(playerOption.contains(option) || cpuOption.contains(option)) {
                System.out.printf("Maaf anda salah memilih option, Pastikan anda memasukan option dengan benar");
                option = inputUser.nextInt();
            }

            // LOGIC jika user memilih nomor
            logicPlace(papanBoard, option, "player");

            // bot or computer option
            Random rand = new Random();
            int randOptCpu = rand.nextInt(9) + 1;
            while(playerOption.contains(randOptCpu) || cpuOption.contains(randOptCpu)) {
                randOptCpu = rand.nextInt(9) + 1;
            }

            logicPlace(papanBoard, randOptCpu, "cpu");

            tampilBoard(papanBoard);

            String result = checkKemenangan();
            System.out.println(result);
        }

    }

    // check the winner

    public static String checkKemenangan() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,5,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> kondisiMenang = new ArrayList<>();

        kondisiMenang.add(topRow);
        kondisiMenang.add(midRow);
        kondisiMenang.add(botRow);
        kondisiMenang.add(leftCol);
        kondisiMenang.add(midCol);
        kondisiMenang.add(rightCol);
        kondisiMenang.add(cross1);
        kondisiMenang.add(cross2);


        for( List l : kondisiMenang) {
            if(playerOption.containsAll(l)) {
                return "Selamat Anda Menang";
            } else if (cpuOption.contains(l)) {
                return "Anda kalah, Komputer menang!";
            } else if (cpuOption.size() + playerOption.size() == 9 ) {
                return  "Hasil Seri";
            }
        }

        return "";
    }

    public static void tampilBoard(char[][] papanBoard) { // pemisah tampilan papan
        for(char[] barisrow : papanBoard) {
            for(char c : barisrow) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void  logicPlace(char[][] papanBoard, int option, String user) {

        char symbol =  'x';
        if(user.equals("player")) {
            symbol = 'x';
            playerOption.add(option);
        } else if(user.equals("cpu")) {
            symbol = 'O';
            cpuOption.add(option);
        }

        switch(option) {
            case 1 :
                papanBoard[0][0] = symbol;
                break;
            case 2 :
                papanBoard[0][2] = symbol;
                break;
            case 3 :
                papanBoard[0][4] = symbol;
                break;
            case 4 :
                papanBoard[2][0] = symbol;
                break;
            case 5:
                papanBoard[2][2] = symbol;
                break;
            case 6 :
                papanBoard[2][4] = symbol;
                break;
            case 7:
                papanBoard[4][0] = symbol;
                break;
            case 8 :
                papanBoard[4][2] = symbol;
                break;
            case 9 :
                papanBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }
}
