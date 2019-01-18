package com.cjdpearce.blackjack

fun main(args: Array<String>) {
    var playersHand = CardHand()
    var cardDeck = CardDeck()
    cardDeck
    playersHand.addCard(cardDeck.getCard())
    playersHand.addCard(cardDeck.getCard())
    println(playersHand.returnTotal())
}

