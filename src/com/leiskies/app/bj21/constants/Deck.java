package com.leiskies.app.bj21.constants;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.leiskies.app.bj21.enums.Card;

public interface Deck {
	public static final Integer[] RANGE = new Integer[] {1,Card.values().length};
	public static final Integer BLACK_JACK = 21;
	public static final BigDecimal INIT_CHIPS = new BigDecimal(2000);
	public static final Map<Integer, Card> VALUES = Stream.of(
			  new AbstractMap.SimpleEntry<>(1, Card.CARD_01),
			  new AbstractMap.SimpleEntry<>(2, Card.CARD_02),
			  new AbstractMap.SimpleEntry<>(3, Card.CARD_03),
			  new AbstractMap.SimpleEntry<>(4, Card.CARD_04),
			  new AbstractMap.SimpleEntry<>(5, Card.CARD_05),
			  new AbstractMap.SimpleEntry<>(6, Card.CARD_06),
			  new AbstractMap.SimpleEntry<>(7, Card.CARD_07),
			  new AbstractMap.SimpleEntry<>(8, Card.CARD_08),
			  new AbstractMap.SimpleEntry<>(9, Card.CARD_09),
			  new AbstractMap.SimpleEntry<>(10, Card.CARD_10),
			  new AbstractMap.SimpleEntry<>(11, Card.CARD_11),
			  new AbstractMap.SimpleEntry<>(12, Card.CARD_12),
			  new AbstractMap.SimpleEntry<>(13, Card.CARD_13))
			  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
} 
