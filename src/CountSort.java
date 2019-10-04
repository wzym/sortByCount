import java.io.*;

public class CountSort {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new CountSort().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private void run() throws IOException {
        var bf = new BufferedReader(new FileReader("test.txt"));
        //BufferedReader bf1 = new BufferedReader(new InputStreamReader(System.in));
        var size = Integer.parseInt(bf.readLine());
        var tokens = bf.readLine().split(" ");
        var countKeeper = new byte[10];
        for (int i = 0; i < size; i++) {
            var curNumber = Byte.parseByte(tokens[i]);
            countKeeper[curNumber]++;
        }
        printResult(fillResult(countKeeper, size));
    }

    private void printResult(byte[] fillResult) {
        var sb = new StringBuilder();
        for (var elem :
                fillResult) {
            sb.append(elem);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private byte[] fillResult(byte[] countKeeper, int size) {
        var result = new byte[size];
        var pointer = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < countKeeper[i]; j++) {
                result[pointer++] = (byte) i;
            }
        }
        return result;
    }
}