package com.cjdpearce.blackjack

class CardHand {
    var cardHand:MutableMap<String,String> = mutableMapOf()

    fun addCard(card: String){
        cardHand.put(card,getCardValue(card))
    }

    fun returnTotal(){
        var values = cardHand.values
        var total = 0
        for (value in values){
            total += value.toInt()
        }
    }

    private fun  getCardValue(card: String): String {
        return card
    }
}