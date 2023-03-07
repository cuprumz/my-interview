package huawei.od;

/**
 * 标题：最长方连续方波信号 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 输入一串方波信号，求取最长的完全连续交替方波信号，并将其输出，如果有相同长度的交替方波信号，输出任一即可，方波信号高位用1标识，低位用0标识，如图：
 * 说明：
 * 1） 一个完整的信号一定以0开始然后以0结尾，即010是一个完整信号，但101，1010，0101不是
 * 2）输入的一串方波信号是由一个或多个完整信号组成
 * 3） 两个相邻信号之间可能有0个或多个低位，如0110010，011000010
 * 4） 同一个信号中可以有连续的高位，如01110101011110001010，前14位是一个具有连续高位的信号
 * 5） 完全连续交替方波是指10交替，如01010是完全连续交替方波，0110不是
 * 输入描述: 输入信号字符串（长度>=3且<=1024）： 0010101010110000101000010 注：输入总是合法的，不用考虑异常情况
 * 输出描述: 输出最长的完全连续交替方波信号串： 01010 若不存在完全连续交替方波信号串，输出 -1
 * 示例1
 * 输入
 * 00101010101100001010010
 * 输出
 * 01010
 * 备注:
 * 输入信号串中有三个信号：0 010101010110(第一个信号段) 00 01010(第二个信号段) 010(第三个信号段)
 * <p>
 * 第一个信号虽然有交替的方波信号段，但出现了11部分的连续高位，不算完全连续交替方波，在剩下的连续方波信号串中01010最长
 */
public class M_N_T_24 {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String input = s.nextLine();
        String input = "001010101011000010100001101010100";
        
        System.out.println("input:" + input);

        String output = findContinuousSignal(input);
        
        System.out.println("output:" + output);
    }

    private static String findContinuousSignal(String input) {
        String res ="";

        String[] signals = input.split("0(0)*0");

        for (String signal : signals) {
            if (signal.matches("(10)*1?") && signal.length()+2 > res.length()) {
                res = "0"+signal+"0";
            }
        }
        
        return res;
    }
}
