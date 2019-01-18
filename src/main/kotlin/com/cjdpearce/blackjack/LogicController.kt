package com.cjdpearce.blackjack

fun main(args: Array<String>) {
    var playersHand = CardHand()

    var cards:MutableMap<String,String> = mutableMapOf()
    cards.put("KH","10")
    cards.put("7S","def")
    var cardKeys:Collection<String> = cards.keys
    var cardsShuffled:Collection<String> = cardKeys.shuffled()

}

