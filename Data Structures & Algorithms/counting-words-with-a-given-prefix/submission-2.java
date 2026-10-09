class TrieNode {
    Map<Character, TrieNode> children;
    int count;

    public TrieNode() {
        this.children = new HashMap<>();
        this.count = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word, int length) {
        // if (word.length() < length) return;
        TrieNode cur = root;
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
            cur.count++;
        }
    }

    public int count(String pref) {
        TrieNode cur = root;
        for (char ch: pref.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                return 0;
            }
            cur = cur.children.get(ch);
        }
        return cur.count;
    }
}
class Solution {
    Trie prefixTree = new Trie();

    public int prefixCount(String[] words, String pref) {
        for (String word: words) {
            if (word.length() >= pref.length()) {
                prefixTree.add(word, pref.length());
            }
        }
        return prefixTree.count(pref);
    }
}