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
        L4 = "L'objectif est de résoudre les X énigmes."
        L5 = "Commencer"

        A = "¢ß¥£™©®ª×±¼½¾µ¿¶·¸º°¯§¤¦≠‰"


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
    </script>
    <body>
        <main>
            <div class="card">
                <h1 id="0" >Enigma</h1>
                <h3 id="1">Bienvenue sur le site aux 1001 énigmes</h3>
                <p id="2">Après avoir clique sur le bouton "Commencer", cela vous lancera un énigme.</p>
                <p id="3">L'objectif est de résoudre les X énigmes.</p>
                <button id="4">Commencer</button>  
                <p class="card-footer">Crée par Rémi D., Ugo L. et Raphaël J.</p>        
            </div>
        </main>
    </body>
    <script>
        document.querySelector(".card").addEventListener("mouseover",(e)=>{
            console.log("add event...")
            magic()
        })
    </script>
</html>