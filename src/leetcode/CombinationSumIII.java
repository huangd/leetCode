package leetcode;

public class CombinationSumIII {
    int k;
    int n;
    List<List<Integer>> results = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        backtrack(new LinkedList<>());
        return results;
    }

    void backtrack(LinkedList<Integer> solutionCandidate) {
        if (solutionCandidate.size() == k) {
            if (solutionCandidate.stream().mapToInt(Integer::intValue).sum() == n) {
                results.add((LinkedList<Integer>)solutionCandidate.clone());
            }
            return;
        }
        int i;
        if (solutionCandidate.isEmpty()) {
            i = 1;
        } else {
            i = solutionCandidate.getLast() + 1;
        }
        for (; i <= 9; i++) {
            solutionCandidate.add(i);
            backtrack(solutionCandidate);
            solutionCandidate.removeLast();
        }
    }
}
