public class Trie {
  public TrieNode root;
  
  public Trie() {
    this.root = new TrieNode();
  }
  
  public void insert(String word) {
    if (word == null || word.trim().isEmpty() || this.root == null) {
      return;
    }
    TrieNode currentNode = this.root;
    word = word.toLowerCase();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      // System.out.println(c + " - 'a' = " + (c - 'a'));
      // if (currentNode.children[c - 'a'] == null) 
      if (currentNode.children.get(c) == null) {
        currentNode.children.put(c, new TrieNode(c));
      } 
      currentNode = currentNode.children.get(c);
    }
    currentNode.isWord = true;
  }
  
  public boolean isWord(String word) {
    if (word == null || word.trim().isEmpty() || this.root == null) {
      return false;
    }
    TrieNode currentNode = this.root;
    word = word.toLowerCase();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (currentNode.children.get(c) == null) {
        return false;
      } 
      currentNode = currentNode.children.get(c);
    }
    return currentNode.isWord;
  }
  
  public static void main(String[] args) {
    Trie dict = new Trie();
    System.out.println("Adding Hello...");
    dict.insert("Hello");
    System.out.println("Adding This...");
    dict.insert("This");
    System.out.println("Adding is...");
    dict.insert("is");
    System.out.println("Adding a...");
    dict.insert("a");
    
    System.out.println("Hello in dict: " + dict.isWord("Hello"));
    System.out.println("Hell in dict: " + dict.isWord("Hell"));
    System.out.println("\"\" in dict: " + dict.isWord(""));
    System.out.println("null in dict: " + dict.isWord(null));
    
  }
}