package com.cjdpearce.blackjack

private var playersHand = CardHand()
private var dealersHand = CardHand()
private var cardDeck = CardDeck()
private var playerStick = false

fun main(args: Array<String>) {
    initGame()
    if(playersHand.returnTotal()==21){
        endGame()
    }
    while (playersHand.returnTotal() < 21 && !playerStick) {
        stickOrTwist()
    }
    if (playerStick) {
        endGame()
    } else if (playersHand.returnTotal() > 21) {
        println("Unfortunately you have exceeded 21 and gone bust. Better luck next time")
    }
}

private fun initGame() {
    cardDeck
    initDeal()
    println("To start off Sir/Madam, could you please tell me your first name?")
    val name = readLine()?.toLowerCase()?.capitalize()
    println("Hello $name, and Welcome to the greatest implementation of blackjack thes worlds ever seen! \n The cards have been dealt, the players are ready. Lets Go!")
    println(name + ", your initial hand is the " + playersHand.returnPretty()[0] + " & " + playersHand.returnPretty()[1] + "\n This leaves you with a grand total of " + playersHand.returnTotal())
    println("\n The dealers top card is the " + dealersHand.returnPretty()[1])
}

private fun initDeal() {
    for (i in 1..2) {
        playersHand.addCard(cardDeck.getCard())
        dealersHand.addCard(cardDeck.getCard())
    }
}

fun stickOrTwist() {
    println("So, would you like to stick or twist?")
    val playersChoice = readLine()?.toLowerCase()
    if (playersChoice == "stick") {
        playerStick = true
    } else if (playersChoice == "twist") {
        playersHand.addCard(cardDeck.getCard())
        for (card in playersHand.cardHand) {
            if (card.key.contains("A")) {
                card.setValue("1")
                if (playersHand.returnTotal() < 21) {
                    break
                }
            }
        }
        println("Your updated deck is ")
        for (card in playersHand.returnPretty()) println(card)
        println("With a grand score of " + playersHand.returnTotal())
    }
}

fun endGame() {
    println("You have chosen to stick! lets see how you did")
    println("The dealer has ")
    for (card in dealersHand.returnPretty()) println(card)
    println("Their grand total is " + dealersHand.returnTotal() + "\n")

    if (dealersHand.returnTotal() < 17) {
        println("The dealers hand is less than 17, the dealer has to pick up")
        while (dealersHand.returnTotal() < 17) {
            dealersHand.addCard(cardDeck.getCard())
        }
        println("The dealer has ")
        for (card in dealersHand.returnPretty()) println(card)
        println("Their grand total is " + dealersHand.returnTotal() + "\n")
    }

    println("Your score is " + playersHand.returnTotal())
    when {
        playersHand.returnTotal() > dealersHand.returnTotal() -> println("congratulations you win!")
        playersHand.returnTotal() == dealersHand.returnTotal() -> println("its a tie! Unbelievable Jeff")
        else -> println("Better luck next time")
    }
    System.exit(0)
}

