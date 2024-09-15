import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to a set for faster lookup.
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // All words have the same length.
        int L = beginWord.length();

        // Dictionary to hold all combinations of words that can be formed
        // by changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        // Preprocessing: For each word, create all possible generic states.
        for (String word : wordSet) {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                allComboDict.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
            }
        }

        // Queues for bidirectional BFS
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        // Visited dictionary to prevent cycles.
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set to optimize the search.
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < L; i++) {
                    String intermediateWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                    List<String> adjacentWords = allComboDict.getOrDefault(intermediateWord, new ArrayList<>());
                    for (String adjacentWord : adjacentWords) {
                        // If the word is in the opposite set, we've found the shortest path.
                        if (endSet.contains(adjacentWord)) {
                            return level + 1;
                        }
                        if (!visited.contains(adjacentWord)) {
                            visited.add(adjacentWord);
                            nextLevelSet.add(adjacentWord);
                        }
                    }
                }
            }
            beginSet = nextLevelSet;
            level++;
        }
        return 0;
    }
}