L1 = "Enigma"
L2 = "Bienvenue sur le site aux 1001 énigmes"
L3 = 'Après avoir clique sur le bouton "Commencer", cela vous lancera un énigme.'
L4 = "L'objectif est de résoudre les 7 énigmes."
L5 = "Commencer"

A = "⌰⍜⏃⎅⟟⋏☌⟒⏁⋔¢ß¥£™©®ª×±¼½¾µ¿¶·¸º°¯§¤¦≠‰"


T1 = L1.split("")
T2 = L2.split("")
T3 = L3.split('')
T4 = L4.split("")
T5 = L5.split("")

TA = A.split("")

T = [T1,T2,T3,T4,T5]

function delay(milliseconds){
    return new Promise(resolve => {
        setTimeout(resolve, milliseconds);
    });
}

function magic() {
    console.log("magic")
    r1 = Math.floor(Math.random() * 5)
    r2 = Math.floor(Math.random() * T[r1].length)
    r3 = Math.floor(Math.random()* TA.length)

    c = T[r1][r2]
    T[r1][r2] = TA[r3]
    document.getElementById(r1.toString()).innerHTML=T[r1].join('')
    delay(1500)
    T[r1][r2] = c
    documennt.getElementById(r1.toString()).innerHTML=T[r1].join('')
}

function change() {
    var changer = document.getElementById("rules")

    if (changer.style.visibility == 'hidden') {
        changer.style.visibility = 'visible'
    } else {
        changer.style.visibility = 'hidden'
    }
}

function changeC() {
    var changer = document.getElementById("account")
    

    if (changer.style.display == 'none') {
        changer.style.display = 'block'
    } else {
        changer.style.display = 'none'
    }
}

function changeA() {
    var account = document.getElementById("account")
    var creation = document.getElementById("creation")

    if (creation.style.display == 'none') {
        creation.style.display = 'block'
        account.style.display = 'none'
    } else {
        creation.style.display = 'none'
    }
}

