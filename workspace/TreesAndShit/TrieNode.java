import java.util.HashMap;

public class TrieNode {
//   public static final int NUM_SUPPORTED_CHARS = 26;
  public boolean isWord;
  public char letter;
//   public Node[] children;
  public HashMap<Character, TrieNode> children;
  
  public TrieNode() {
    this.isWord = false;
//     this.children = new Node[NUM_SUPPORTED_CHARS]; //Can use ArrayList here for dynamic
    this.children = new HashMap<Character, TrieNode>();
  }
  
  public TrieNode(char letter) {
    this.letter = letter;
    this.isWord = false;
//     this.children = new Node[NUM_SUPPORTED_CHARS]; //Can use ArrayList here for dynamic
    this.children = new HashMap<Character, TrieNode>();
  }
  
  public boolean isWord() {
    return this.isWord;
  }
  
  public char getLetter() {
    return this.letter;
  }
  
  public void setLetter(char letter) {
    this.letter = letter;
  }
  
  public void deleteChildren() {
    // useful for a function where you want to define a prefix
    // and delete all words with that prefix
//     this.children = new Node[NUM_SUPPORTED_CHARS];
    this.children = new HashMap<Character, TrieNode>();
  }
}