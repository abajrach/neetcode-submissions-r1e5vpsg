public class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfWord = false;
    }
}

// Using arrays holding TrieNode which represents characters a-z.
class PrefixTree {

    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }

        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch: prefix.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
}
