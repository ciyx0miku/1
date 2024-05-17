import java.util.Scanner;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 用于菜单界面的选择。该方法如果用户键入'1'-'5'中的任意字符，则方法返回。 返回值为用户所键入的数字，否则提示错误信息
     */
    public static char readMeanuSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' &&c != '2'&&c != '3'&&c != '4'&&c != '5') {
                System.out.print("选择错误，请重新输入");

            } else {
                return c;
            }
        }
    }

    /**
     * 从键盘中读取一个字符，并将其作为方法的返回值
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 从键盘中读取一个字符，并将其直接作为方法的返回值
     * 如果用户输入的不是字符而是回车，方法将以defaultValue做为返回值
     */
    public static char readChar(char defaultValue) {
        String str=readKeyBoard(1, true);
        return (str.length()==0)?defaultValue:str.charAt(0);
    }

    /**
     * 从键盘中读取一个长度不超过2的整数，并将其作为方法的返回值
     */
    public static int readInt() {
        int n;
        for(;;) {
            String str=readKeyBoard(2, false);
            try {
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("数字入错误，请重新输入");
            }
        }
        return n;
    }


    /**
     * 从键盘中读取一个长度不超过2的整数，并将其作为方法的返回值
     * 如果用户输入的不是字符而是回车，方法将以defaultValue做为返回值
     */
    public static int readInt(int defaultValue) {
        int n;
        for(;;) {
            String str=readKeyBoard(2, true);
            if(str.equals("")) {
                return defaultValue;
            }
            try {
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("数字入错误，请重新输入");
            }
        }
        return n;
    }
    /**
     * 从键盘中读取一个长度不超过limit的字符串，并将其作为方法的返回值
     *
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 从键盘中读取一个长度不超过limit的字符串，并将其作为方法的返回值
     * 如果用户输入的不是字符而是回车，方法将以defaultValue做为返回值
     */
    public static String readString(int limit,String defaultValue) {
        String str= readKeyBoard(limit, true);
        return str.equals("")?defaultValue:str;
    }
    /**
     * 用于确认用户选择的输入，该方法从键盘键入一个‘Y’或‘N’，并将其作为返回值
     */
    public static char readConfrimSelection() {
        char c;
        for(;;) {
            String str=readKeyBoard(1, false).toUpperCase();
            c=str.charAt(0);
            if(c=='Y'||c=='N') {
                break;
            }else {
                System.out.println("选择错误，请重新选择");
            }

        }
        return c;
    }



    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn)
                    return line;
                else
                    continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度（不大于" + limit + "）错误，请重新输入“");
                continue;
            }
            break;
        }
        return line;

    }

}
