
/**
 * @param {string} word
 * @param {number} maxFrequencyDifference
 * @return {number}
 */
var minimumDeletions = function (word, maxFrequencyDifference) {
    const ALPHABET_SIZE = 26;
    const ASCII_SMALL_CASE_A = 97;
    const frequency = new Array(ALPHABET_SIZE).fill(0);
    for (let i = 0; i < word.length; ++i) {
        ++frequency[word.codePointAt(i) - ASCII_SMALL_CASE_A];
    }

    let minDeletions = word.length;
    for (let i = 0; i < frequency.length; ++i) {
        if (frequency[i] === 0) {
            continue;
        }

        let currentDeletions = 0;
        for (let j = 0; j < frequency.length; ++j) {
            if (frequency[j] < frequency[i]) {
                currentDeletions += frequency[j];
            } else if (frequency[j] > frequency[i] + maxFrequencyDifference) {
                currentDeletions += frequency[j] - frequency[i] - maxFrequencyDifference;
            }
        }

        minDeletions = Math.min(minDeletions, currentDeletions);
    }

    return minDeletions;
};
