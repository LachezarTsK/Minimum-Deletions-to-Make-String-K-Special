
public class Solution {

    private static final int ALPHABET_SIZE = 26;

    public int minimumDeletions(String word, int maxFrequencyDifference) {
        int[] frequency = new int[ALPHABET_SIZE];
        for (char letter : word.toCharArray()) {
            ++frequency[letter - 'a'];
        }

        int minDeletions = word.length();
        for (int i = 0; i < frequency.length; ++i) {
            if (frequency[i] == 0) {
                continue;
            }

            int currentDeletions = 0;
            for (int j = 0; j < frequency.length; ++j) {
                if (frequency[j] < frequency[i]) {
                    currentDeletions += frequency[j];
                } else if (frequency[j] > frequency[i] + maxFrequencyDifference) {
                    currentDeletions += frequency[j] - frequency[i] - maxFrequencyDifference;
                }
            }

            minDeletions = Math.min(minDeletions, currentDeletions);
        }

        return minDeletions;
    }
}
