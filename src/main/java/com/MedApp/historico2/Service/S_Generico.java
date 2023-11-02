package com.MedApp.historico2.Service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class S_Generico {
    public static boolean validarEmail(String email) {
        // Defina a expressão regular para validar o e-mail
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        // Crie o objeto de padrão
        Pattern pattern = Pattern.compile(regex);
        // Crie o objeto de correspondência
        Matcher matcher = pattern.matcher(email);
        // Realize a correspondência e retorne true se o e-mail for válido
        return matcher.matches();
    }

    public static boolean textoEstaVazio(String texto){
        return texto == null || texto.trim().equals("");
    }

    public static String limparNumero(String numero) {
        // Remove caracteres, apenas os dígitos serão mantidos
        return numero.replaceAll("[^0-9]", "");
    }
}
