public class SmallestSumDifference {

    public SmallestSumDifference() {
    }

    public static void main(String[] args) {
	System.out.println(new SmallestSumDifference().solution(new int[] { 3, 1, 2, 4, 3 }));
    }

    public int solution(int[] A) {
	// https://codility.com/programmers/task/tape_equilibrium/
	// 66% (desired O(N) result O(N*N))
	// possible solution is to sum all and if we are getting closer to half
	// total, there is no point summing anymore ?
	// hashmaps? but would not keep the "tapeness"
	// recursive?
	int smallest = Integer.MAX_VALUE;
	int len = A.length;
	for (int i = 1; i < len; i++) {
	    int sumA = 0, sumB = 0;
	    // instead of Arrays.copyRangeOf
	    for (int j = 0; j < len - i; j++) {
		sumA += A[j];
	    }
	    for (int j = len - i; j < len; j++) {
		sumB += A[j];
	    }
	    // instead of Arrays.sort
	    int diff = sumA - sumB;
	    if (diff < 0) {
		diff *= -1;
	    }
	    if (diff < smallest) {
		smallest = diff;
	    }
	}
	return smallest;
    }
}
