package Day48;
import java.util.*;;

class Solution {

    // Initialize the maximum no of characters
    int MAX_CHARS = 26;

    // Function to create a frequency hashmap
    public String getHash(String word) {
        
        // Convert the word to a character array
        char[] word_chars = word.toCharArray();
        
        // Initialize the freqency array to 0
        int[] freq = new int[MAX_CHARS];
        
        // Increment the frequency by 1 for each character
        for(char c: word_chars) {
            freq[c - 'a']++;
        }
        
        // Initialize hash string of frequencies
        StringBuilder hash = new StringBuilder("");
        
        // Append the frequencies to the hash string
        for(int i = 0; i < MAX_CHARS; i++) {
            hash.append(freq[i] + "");
        }
        
        // Return the hash string
        return hash.toString();
    }
    
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Initialize the frequency hashmap
        HashMap<String, Integer> map = new HashMap<>();
        
        // Initialize the resultant array of grouped anagrams
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        // Interate each word in the list
        for(String word : arr) {
            
            // Create the frequency hash string for the word
            String hash = getHash(word);
            
            // Initialize the size of the hashmap
            int n = map.size();
            
            // Check if the hash string exists in the hashmap
            if(!map.containsKey(hash)) {

                // Update the last index at the hash
                map.put(hash, n);
                
                // Create a array list of the string
                ArrayList<String> words = new ArrayList<>();
                words.add(word);
                
                // Add the singleton list to the result
                res.add(words);
            } else {
                
                // Get the index of the frequency hash string 
                int idx = map.get(hash);
                
                // Add the current word to the
                // list of words at the index
                ArrayList<String> words = res.get(idx);
                words.add(word);
                
                // Update the list of words to the result
                res.set(idx, words);
            }
            
        }
        
        // Return the result
        return res;
    }
}



