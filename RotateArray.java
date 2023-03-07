import java.util.Arrays;

public class RotateArray {
    public RotateArray() {
    }

    public static void main(String[] args) {
	System.out.println(Arrays.toString(new RotateArray().rotate(new int[] { 1, 2, 3, 4, 5, 6 }, 9)));
    }

    public int[] rotate(int[] A, int K) {
	// https://codility.com/demo/results/trainingPV3PK8-XER/
	// 25%
	// tried to fix it still not good
	int aLength = A.length;
	int rotationAmount = K % aLength;
	if (A.length == 0 || K <= 1 || rotationAmount <= 1) {
	    return A;
	}

	// REVERSES if 0 or > A.length INSTEAD OF ROTATE zero...counts as
	// if (rotationAmount == 0) {
	// int[] reversed = new int[aLength];
	// for (int i = 0; i < reversed.length; i++) {
	// reversed[i] = A[aLength - 1 - i];
	// }
	// return reversed;
	// }
	// if (rotationAmount == 1) {
	// return A;
	// }

	int frontSize = aLength - (rotationAmount - 1);
	int endSize = aLength - frontSize;
	int[] front = new int[frontSize];
	int[] end = new int[endSize];

	rotationAmount--;
	// fill front
	for (int i = 0; i < frontSize; i++) {
	    front[i] = A[i + rotationAmount];
	}
	// fill end
	for (int i = 0; i < endSize; i++) {
	    end[i] = A[i];
	}
	// copy front and end to the new array
	int[] newArr = new int[frontSize + endSize];
	for (int i = 0; i < newArr.length - endSize; i++) {
	    newArr[i] = front[i];
	}
	for (int i = 0; i < newArr.length - frontSize; i++) {
	    newArr[i + frontSize] = end[i];
	}
	return newArr;
    }

}
