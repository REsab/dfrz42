package Schol_CLI_V1_full.school.ui.cli;

import java.util.Scanner;

public class PubMenu {


    public static String choose() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择,输入数字: ");
        String string = scanner.next();
        return string;
    }

    public static String input() {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        return string;
    }

    public static String Back() {
        System.out.println("按任意键返回");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        return string;
    }


}
