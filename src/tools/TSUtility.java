package tools;

/*
 * public static char readMenuSelection() 
	��;���÷�����ȡ���̣�����û����롯1��-��4���е������ַ����򷽷����ء�����ֵΪ�û������ַ���
public static void readReturn() 
	��;���÷�����ʾ���ȴ���ֱ���û����س����󷵻ء�
public static int readInt() 
	��;���÷����Ӽ��̶�ȡһ�����Ȳ�����2λ����������������Ϊ�����ķ���ֵ��
public static char readConfirmSelection() ��
	��;���Ӽ��̶�ȡ��Y����N������������Ϊ�����ķ���ֵ��

 */

import java.util.*;

public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                c != '3' && c != '4') {
                System.out.print("ѡ��������������룺");
            } else break;
        }
        return c;
    }

    public static void readReturn() {
        System.out.print("���س�������...");
        readKeyBoard(100, true);
    }

    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("��������������������룺");
            }
        }
        return n;
    }

    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("ѡ��������������룺");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("���볤�ȣ�������" + limit + "���������������룺");
                continue;
            }
            break;
        }

        return line;
    }
}

