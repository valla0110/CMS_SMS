package com.example.cms_project;


import java.util.LinkedList;
import java.util.List;

public class TrieNode {
	
	
	public TrieNode(char charecter) {
		this.character = charecter;
		this.childs = new LinkedList();
	}
	private char character;
	private List childs;
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public List getChilds() {
		return childs;
	}
	public void setChilds(List childs) {
		this.childs = childs;
	}
	
}
