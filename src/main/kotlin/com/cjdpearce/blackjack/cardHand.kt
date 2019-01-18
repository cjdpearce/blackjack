package com.cjdpearce.blackjack

class CardHand {
    var cardHand:MutableMap<String,String> = mutableMapOf()
    var cardDeck = CardDeck()

    fun addCard(card: String){
        cardHand[card] = cardDeck.getCardValue(card)
    }

    fun returnTotal(): Int {
        var values = cardHand.values
        var total = 0
        for (value in values){
            total += value.toInt()
        }
        return total
    }


}