package algorithms.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class HotelReviews {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        String[] goodWords = A.split("_");
        Trie trie = new Trie();
        for (String goodWord : goodWords) {
            trie.insert(goodWord);
        }
        int lenReviews = B.size();
        IndexScore[] scores = new IndexScore[lenReviews];
        for (int idxReview = 0; idxReview < lenReviews; ++idxReview) {
            scores[idxReview] = createIndexScore(
                trie,
                idxReview,
                B.get(idxReview)
            );
        }
        Arrays.sort(scores);
        ArrayList<Integer> result = new ArrayList<>(lenReviews);
        for (int i = 0; i < lenReviews; ++i) {
            result.add(scores[i].index);
        }
        return result;
    }

    private IndexScore createIndexScore(Trie trie, int i, String line) {
        String[] words = line.split("_");
        int score = 0;
        for (String word : words) {
            if (trie.contains(word)) {
                ++score;
            }
        }
        return new IndexScore(i, score);
    }

    private static class Trie {
        Node root = new Node(' ');

        boolean contains(String str) {
            int len = str.length();
            Node current = root;
            for (int i = 0; i < len; ++i) {
                char c = str.charAt(i);
                Node child = current.children[c - 'a'];
                if (child == null) {
                    return false;
                }
                current = child;
            }
            return current.isEnd;
        }

        void insert(String str) {
            int len = str.length();
            Node current = root;
            for (int i = 0; i < len; ++i) {
                char c = str.charAt(i);
                int idx = c - 'a';
                Node child = current.children[idx];
                if (child == null) {
                    child = new Node(c);
                    current.children[idx] = child;
                }
                current = child;
            }
            current.isEnd = true;
        }

    }

    private static class Node {
        char val;
        boolean isEnd;
        Node[] children = new Node[26];

        Node(char val) {
            this.val = val;
        }
    }

    private static class IndexScore implements Comparable<IndexScore> {
        private final int index;
        private final int score;

        IndexScore(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(IndexScore other) {
            int res = Integer.compare(other.score, score);
            return res == 0 ? Integer.compare(index, other.index) : res;
        }
    }

}
