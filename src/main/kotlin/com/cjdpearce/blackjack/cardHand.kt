package com.cjdpearce.blackjack

class CardHand {
    var cardHand: MutableMap<String, String> = mutableMapOf()
    var cardDeck = CardDeck()

    fun addCard(card: String) {
        cardHand[card] = cardDeck.getCardValue(card)
    }

    fun returnTotal(): Int {
        var values = cardHand.values
        var total = 0
        for (value in values) {
            total += value.toInt()
        }
        return total
    }

    fun returnPretty(): ArrayList<String> {
        var prettyCards: ArrayList<String> = arrayListOf()
        for (card in cardHand) {
            when {
                card.key.contains("H") -> prettyCards.add(card.value + " of Hearts")
                card.key.contains("C") -> prettyCards.add(card.value + " of Clubs")
                card.key.contains("D") -> prettyCards.add(card.value + " of Diamonds")
                card.key.contains("S") -> prettyCards.add(card.value + " of Spades")
            }
        }
        return prettyCards
    }

}