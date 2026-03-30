public class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfWord = false;
    }
}
class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int level, TrieNode node) {
        TrieNode cur = node;

        for (int i = level; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child: cur.children) {
                    if (child != null && dfsSearch(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = ch - 'a';
                if (cur.children[idx] == null) {
                    return false;
                }
                cur = cur.children[idx];
            }
        }

        return cur.endOfWord;
    }
}
