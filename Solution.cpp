
#include <array>
#include <string>
#include <algorithm>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;

public:
    int minimumDeletions(const string& word, int maxFrequencyDifference) const {
        array<int, ALPHABET_SIZE> frequency{};
        for (const auto& letter : word) {
            ++frequency[letter - 'a'];
        }

        int minDeletions = word.length();
        for (int i = 0; i < frequency.size(); ++i) {
            if (frequency[i] == 0) {
                continue;
            }

            int currentDeletions = 0;
            for (int j = 0; j < frequency.size(); ++j) {
                if (frequency[j] < frequency[i]) {
                    currentDeletions += frequency[j];
                }
                else if (frequency[j] > frequency[i] + maxFrequencyDifference) {
                    currentDeletions += frequency[j] - frequency[i] - maxFrequencyDifference;
                }
            }

            minDeletions = min(minDeletions, currentDeletions);
        }

        return minDeletions;
    }
};
