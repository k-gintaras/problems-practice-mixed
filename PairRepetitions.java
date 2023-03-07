import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class PairRepetitions {
    public PairRepetitions() {
    }

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
	// https://codility.com/demo/results/trainingHV7UBW-YJH/
	// 66% problem at big random test n=999,999, multiple repetitions (no
	// idea why, possibly the pair count should be even ?)
	try {
	    int len = A.length;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	    for (int i = 0; i < len; i++) {
		int k = A[i];
		if (map.get(k) == null) {
		    map.put(k, 1);
		} else {
		    int count = map.get(A[i]) + 1;
		    map.replace(A[i], count);
		}

	    }
	    Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
	    while (it.hasNext()) {
		Entry<Integer, Integer> pair = (Entry<Integer, Integer>) it.next();
		countMap.put((int) pair.getValue(), (int) pair.getKey());
		it.remove();
	    }
	    return countMap.get(1);
	} catch (Exception e) {
	    return 0;
	}
    }
}