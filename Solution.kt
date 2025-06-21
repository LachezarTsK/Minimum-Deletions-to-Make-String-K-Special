
import kotlin.math.min

class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
    }

    fun minimumDeletions(word: String, maxFrequencyDifference: Int): Int {
        val frequency = IntArray(ALPHABET_SIZE)
        for (letter in word) {
            ++frequency[letter - 'a']
        }

        var minDeletions = word.length
        for (i in frequency.indices) {
            if (frequency[i] == 0) {
                continue
            }

            var currentDeletions = 0
            for (j in frequency.indices) {
                if (frequency[j] < frequency[i]) {
                    currentDeletions += frequency[j]
                } else if (frequency[j] > frequency[i] + maxFrequencyDifference) {
                    currentDeletions += frequency[j] - frequency[i] - maxFrequencyDifference
                }
            }

            minDeletions = min(minDeletions, currentDeletions)
        }

        return minDeletions
    }
}
