public class BinaryGap {

    public BinaryGap() {
    }

    public static void main(String[] args) {
	int N = 9;
	System.out.println("[" + solution(N) + "]");
    }

    public static int solution(int N) {
	//https://codility.com/programmers/task/binary_gap/
	//100%
	int reminder = 0, zeroCounter = 0, biggest = 0;
	boolean firstOne = false;
	while (N != 0) {
	    reminder = N % 2;
	    N = (N - reminder) / 2;
	    if (reminder == 1) {
		firstOne = true;
		if (biggest < zeroCounter) {
		    biggest = zeroCounter;
		}
		zeroCounter = 0;
	    } else {
		if (firstOne) {
		    zeroCounter++;
		}
	    }
	}
	return biggest;
    }
}
