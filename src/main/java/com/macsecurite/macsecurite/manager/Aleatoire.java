package com.macsecurite.macsecurite.manager;

import java.security.SecureRandom;
import java.util.Random;

public class Aleatoire {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new SecureRandom();

    /**
     * Génère une chaîne de caractères aléatoire de la longueur spécifiée.
     *
     * @param length la longueur de la chaîne de caractères à générer
     * @return une chaîne de caractères aléatoire de la longueur spécifiée
     */
    public static String getRandomStr(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return stringBuilder.toString();
    }
}
