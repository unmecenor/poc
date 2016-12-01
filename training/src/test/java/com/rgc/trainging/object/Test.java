package com.rgc.trainging.object;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class Test {

	@org.junit.Test
	public void testHashcode() {
		Person richard = new Person("Guilloux", "Richard");
		Person freddy = new Person("Guilloux", "Freddy");
		Map<Person, String> nicknames = new HashMap<>();
		nicknames.put(richard, "polo");
		nicknames.put(freddy, "raph");
		assertThat(nicknames).hasSize(2);
		assertThat(nicknames.remove(freddy)).isEqualTo("raph");
		assertThat(nicknames).hasSize(1);
		System.out.println(nicknames);
	}
}
