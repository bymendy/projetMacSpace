package com.macsecurite.macsecurite.manager;

/**
 * *
 *  Cette classe permet de vérifier les champs
 */
public class TextChampManager {

    /**
     * Methode qui êrmet de vérifier si la chaine contient  que des lettres
     * @param value votre chaine à vérifier
     * @return true si la chaine contient que des letrtres
     */

    public static boolean isNameValide(String value){
        if (value== null || value.length() <= 2){
            return false;
        }

        for (int i = 0; i < value.length(); i++){
            char caractere = value.charAt(i); // récupérer un cararctere
            if(!('a' <= caractere && caractere <= 'z')){
                return  false;
            }

        }
        return true;
    }
}
