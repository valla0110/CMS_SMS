package com.example.cms_project;



import java.util.List;
import java.util.ListIterator;

import android.content.Context;
import android.widget.Toast;

public class SearchTrie
{
  
	public List searchTrie(String word)
	{
		
		Trie trie = new Trie();
		trie.addWord("Bank");
		trie.addWord("Ball");
		trie.addWord("Balloon");
		trie.addWord("Basket");
		trie.addWord("JavaFour");
		trie.addWord("JavaFive");
		
		
		List matches = trie.search(word);
		return matches;
		

	}

}
