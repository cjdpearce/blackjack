package com.cjdpearce.blackjack
private var playersHand = CardHand()
private var dealersHand = CardHand()
private var cardDeck = CardDeck()
private var playerStick = false

fun main(args: Array<String>) {
    initGame()
    while (playersHand.returnTotal() < 21 && !playerStick){
        stickOrTwist()
    }
    if (playerStick){
        println("You have chosen to stick! lets see how you did")
        println("The dealer has ")
        for (card in dealersHand.cardHand) println(card)
        println("Their grand total is " + dealersHand.returnTotal() +"\n")

        println("Your score is "+ playersHand.returnTotal())
        if (playersHand.returnTotal()> dealersHand.returnTotal()){
            println("congratulations you win!")
        }else if(playersHand.returnTotal()==dealersHand.returnTotal()){
           println("its a tie! Unbelievable Jeff")
        }else{
            println("Better luck next time")
        }
    }

}

private fun initDeal(){
    for (i in 1..2 ) {
        playersHand.addCard(cardDeck.getCard())
        dealersHand.addCard(cardDeck.getCard())
    }
}

private fun initGame(){
    cardDeck
    initDeal()
    println("To start off Sir/Madam, could you please tell me your first name?")
    val name = readLine()?.toLowerCase()?.capitalize()
    println("Hello " +name+ ", and Welcome to the greatest implementation of blackjack thes worlds ever seen! \n The cards have been dealt, the players are ready. Lets Go!")
    println(name + ", your initial hand is the "+     playersHand.returnPretty().get(0) +" & "+    playersHand.returnPretty().get(1) + "\n This leaves you with a grand total of " + playersHand.returnTotal() )
            println("\n The dealers top card is the " + dealersHand.returnPretty().get(1))
}

 fun stickOrTwist(){
 println("So, would you like to stick or twist?")
    val playersChoice = readLine()?.toLowerCase()
    if (playersChoice=="stick"){
        playerStick=true
    }else if(playersChoice=="twist"){
        playersHand.addCard(cardDeck.getCard())
        for (card in playersHand.cardHand){
            if(card.key.contains("A")){
                card.setValue("1")
                if (playersHand.returnTotal()<21){
                    break
                }
            }
        }
        println("Your updated deck is ")
        for (card in playersHand.returnPretty()) println(card)
        println("With a grand score of " + playersHand.returnTotal())

    }
}

