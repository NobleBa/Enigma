<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="app.css" />
        <!-- <script src="index.js"/> -->
        <title>Enigma</title>
    </head>
    <script>
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
    </script>
    <body>
        <main>
            <div class="card">
                <h1 id="0" >Enigma</h1>
                <h3 id="1">Bienvenue sur le site aux 1001 énigmes</h3>
                <p id="2">Après avoir clique sur le bouton "Commencer", cela vous lancera un énigme.</p>
                <p id="3">L'objectif est de résoudre les 7 énigmes.</p>
                <button id="4">Commencer</button>  
                <div class="card-footer" style="display: flex; justify-content: space-between;">
                    <p>Crée par Rémi D., Ugo L. et Raphaël J.</p>
                    <p onclick="change()">Règles</p>
                </div>        
            </div>
            <div class="card1 box" id="rules" style="visibility: hidden;">
                <div>
                    <button class="menu__icon" onclick="change()"></button>
                    <h2 style="margin-top: 6%;">Règles</h2>
                </div>
                <p>Lorem ipsum dolor sit amet. Sit architecto dolores vel magni numquam est ullam soluta est nesciunt repudiandae sed natus tempore est architecto quisquam sit quas nesciunt. Ea officiis quia sed temporibus sapiente At dicta officiis a repellendus nemo. Id expedita provident non quos rerum At tenetur tenetur et obcaecati repellendus eum exercitationem magnam non iusto quidem ut Quis porro.</p>
            </div>
        </main>
    </body>
    <script>
        document.querySelector(".card").addEventListener("mouseover",(e)=>{
            magic()
        })
        document.querySelector("#rules").addEventListener("click",(e)=>{
            regles()
        })
    </script>
</html>