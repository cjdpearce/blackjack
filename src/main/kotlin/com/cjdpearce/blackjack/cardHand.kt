package com.cjdpearce.blackjack

class CardHand {
    var cardHand:MutableMap<String,String> = mutableMapOf()

    fun addCard(card: String){
        cardHand.put(card.toString(),"bdfjdfjfb")
        println(cardHand)
    }
}