package com.example.cms_project;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Trie {

	private TrieNode root;

	/**
	 *  Add the give word into the Trie
	 * @param word
	 */
	public void addWord(String word)
	{
		if(root == null)
		{
			root = new TrieNode(' ');
		}
		TrieNode start = root;
		char[] charecters = word.toCharArray();
		for(char c : charecters)
		{
			if( start.getChilds().size() == 0)
			{
				TrieNode newNode = new TrieNode(c);
				start.getChilds().add(newNode);
				start = newNode;
			}
			else
			{
				ListIterator iterator = start.getChilds().listIterator();
				TrieNode node=null;
				while(iterator.hasNext())
				{
					node = (TrieNode) iterator.next();
					if(node.getCharacter() >= c)
						break;
				}
				if(node.getCharacter() == c)
				{
					start = node;
				}
				else
				{
					TrieNode newNode = new TrieNode(c);
					iterator.add(newNode);	
					start = newNode;
					
				}
			}
		}
		
	}
	
	/**
	 *  This method takes and prefix string and returns all possible string that can be formed from the given prefix
	 * @param prefix
	 * @return
	 */
	public List search(String prefix)
	{
		if(prefix == null || prefix.isEmpty())
			return null;
		
		char[] chars = prefix.toCharArray();
		TrieNode start = root;
		boolean flag = false;
		for(char c : chars)
		{
			if(start.getChilds().size() > 0)
			{
                            for (Iterator it = start.getChilds().iterator(); it.hasNext();) {
                                TrieNode node = (TrieNode) it.next();
                                if(node.getCharacter() == c)
                                {
                                    start = node;
                                    flag=true;
                                    break;
                                }
                            }
			}
			else
			{
				flag = false;
				break;
			}
		}
		if(flag)
		{
			List matches = getAllWords(start,prefix);
			return matches;
		}
		
		return null;
	}
	
	/**
	 *  This method returns list string that can be formed from the given node
	 * @param start : Node from to start
	 * @param prefix : String prefix that was formed till start node
	 * @return
	 */
	private List getAllWords(TrieNode start,final String prefix)
	{
		if(start.getChilds().size() == 0)
		{
			List list = new LinkedList();
			list.add(prefix);
			return list;
		}
		else
		{
			List list = new LinkedList();
                         
			 for (Iterator it = start.getChilds().iterator(); it.hasNext();)
			{
                            TrieNode n = (TrieNode) it.next();
				list.addAll(getAllWords(n, prefix+n.getCharacter()));
			}
			return list;
		}
		
	}
	
}
