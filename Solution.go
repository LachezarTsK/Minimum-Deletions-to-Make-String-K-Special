
package main

func minimumDeletions(word string, maxFrequencyDifference int) int {
    const ALPHABET_SIZE = 26
    frequency := [ALPHABET_SIZE]int{}
    for i := range word {
        frequency[word[i] - 'a']++
    }

    minDeletions := len(word)
    for i := range frequency {
        if frequency[i] == 0 {
            continue
        }

        currentDeletions := 0
        for j := range frequency {
            if frequency[j] < frequency[i] {
                currentDeletions += frequency[j]
            } else if frequency[j] > frequency[i]+maxFrequencyDifference {
                currentDeletions += frequency[j] - frequency[i] - maxFrequencyDifference
            }
        }

        minDeletions = min(minDeletions, currentDeletions)
    }

    return minDeletions
}
