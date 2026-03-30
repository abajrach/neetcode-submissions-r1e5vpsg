public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}

// Using Hashmap
class PrefixTree {

    private TrieNode root;
    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }

        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch: prefix.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return true;
    }
}
