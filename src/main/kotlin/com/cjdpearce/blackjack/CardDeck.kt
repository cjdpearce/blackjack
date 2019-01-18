package com.cjdpearce.blackjack

class CardDeck {
    private var cardDeck: MutableMap<String, String> = mutableMapOf()
    var cards: MutableList<String> = mutableListOf()

    init {
        buildDeck()
        shuffleDeck()
    }

    private fun buildDeck() {
        var suits: ArrayList<String> = arrayListOf("H", "C", "D", "S")
        for (suit in suits) {
            for (i in 1..10) {
                cardDeck[suit + i] = i.toString()
            }
            cardDeck[suit + "J"] = "10"
            cardDeck[suit + "Q"] = "10"
            cardDeck[suit + "K"] = "10"
            cardDeck[suit + "A"] = "11"
        }
    }

    private fun shuffleDeck(): List<String> {
        cards = cardDeck.keys.shuffled().toMutableList()
        return cards
    }

    fun getCard(): String {
        val card = cards.first()
        cards.removeAt(0)
        return card
    }

    fun getCardValue(card: String): String {
        return cardDeck[card].toString()
    }
}