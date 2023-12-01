package com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnagramTest{
	@Test
	public void reverseOneString_when_000a00b_then_000b00a() {
		//given
		String expectedString = "000b00a";
		//when
		String actual = Anagram.reverseOneString("000a00b");
		//then
		assertEquals(expectedString, actual);
	}
	@Test
	public void reverseOneString_when_abcd_then_dcba() {
		//given
		String expectedString = "dcba";
		//when
		String actual = Anagram.reverseOneString("abcd");
		//then
		assertEquals(expectedString, actual);
	}
	
	@Test
	public void reverseOneString_when_efgh_then_hgfe() {
		//given
		String expectedString = "efgh";
		//when
		String actual = Anagram.reverseOneString("hgfe");
		//then
		assertEquals(expectedString, actual);
	}
	
	@Test
	public void anagram_when_abcd_efgh_then_hgfe() {
		//given
		String expectedString = "dcba hgfe";
		//when
		String actual = Anagram.anagram("abcd efgh");
		//then
		assertEquals(expectedString, actual);
	}
	
	@Test
	public void anagram_when_a1bcd_efgh_then_hgfe() {
		//given
		String expectedString = "d1cba hgf!e";
		//when
		String actual = Anagram.anagram("a1bcd efg!h");
		//then
		assertEquals(expectedString, actual);
	}
	
	
}