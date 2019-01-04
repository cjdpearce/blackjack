package com.cjdpearce.blackjack

fun main(args: Array<String>) {
    var playersHand: CardHand = CardHand()

    var cards:MutableMap<String,String> = mutableMapOf()
    cards.put("123","abc")
    cards.put("456","def")
    cards.put("789","ghi")
    var cardKeys:Collection<String> = cards.keys
    var cardsShuffled:Collection<String> = cardKeys.shuffled()

    playersHand.addCard(cards[cardsShuffled.first()]!!)
}

