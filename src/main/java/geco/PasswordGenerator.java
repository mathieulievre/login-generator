package geco;

import java.util.Random;

/**
 * Classe representant un generateur de mots de passe
 */
public class PasswordGenerator {

    /**
     * Methode permettant de generer un mot de passe aleatoire
     *
     * @param nbCarMin nombre minimum de caracteres souhaite
     * @param nbCarMax nombre maximum de caracteres souhaite
     * @return le mot de passe aleatoire genere
     */
    public String getRandomPassword(int nbCarMin, int nbCarMax) {
        assert nbCarMax >= nbCarMin;
        assert nbCarMax > 0 && nbCarMin > 0;

        Random r = new Random();

        int nbCar;
        if (nbCarMin == nbCarMax) {
            nbCar = nbCarMin;
        } else {
            nbCar = r.nextInt(nbCarMax - nbCarMin) + nbCarMin;
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < nbCar; i++) {
            password.append(getRandomChar(r));
        }

        return password.toString();
    }

    /**
     * Methode permettant de retourner un caractere aleatoire parmi un alphabet
     *
     * @param r generateur pseudo-aleatoire
     * @return un caractere aleatoire
     */
    private char getRandomChar(Random r) {
        String alphabet =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789^$_/?!()=+";
        return alphabet.charAt(r.nextInt(alphabet.length()));
    }

}
