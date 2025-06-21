
using System;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;

    public int MinimumDeletions(string word, int maxFrequencyDifference)
    {
        int[] frequency = new int[ALPHABET_SIZE];
        foreach (char letter in word)
        {
            ++frequency[letter - 'a'];
        }

        int minDeletions = word.Length;
        for (int i = 0; i < frequency.Length; ++i)
        {
            if (frequency[i] == 0)
            {
                continue;
            }

            int currentDeletions = 0;
            for (int j = 0; j < frequency.Length; ++j)
            {
                if (frequency[j] < frequency[i])
                {
                    currentDeletions += frequency[j];
                }
                else if (frequency[j] > frequency[i] + maxFrequencyDifference)
                {
                    currentDeletions += frequency[j] - frequency[i] - maxFrequencyDifference;
                }
            }

            minDeletions = Math.Min(minDeletions, currentDeletions);
        }

        return minDeletions;
    }
}
