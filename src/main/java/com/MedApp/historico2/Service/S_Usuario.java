package com.MedApp.historico2.Service;

import com.MedApp.historico2.Model.M_Usuario;
import com.MedApp.historico2.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {

    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario =  r_usuario;
    }

    public static M_Usuario verificaLogin(String CPF, String senha){
        CPF = S_Generico.limparNumero(CPF);

        if(S_Generico.textoEstaVazio(CPF)){
            return null;
        }else if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
        return r_usuario.buscarPorCpfSenha(Long.parseLong(CPF),
                senha);
    }

    public static String cadastrarUsuario(String nome, String email, String CPF, String senha, String relacao) {
        boolean podeSalvar = true;
        String mensagem = "";
        if(S_Generico.textoEstaVazio(nome)){
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido!";
        }
        if(!S_Generico.validarEmail(email)){
            podeSalvar = false;
            mensagem += "E_Mail invalido, tente novamente";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(CPF))){
            podeSalvar = false;
            mensagem += "O CPF precisa ser informada!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(relacao))){
            podeSalvar = false;
            mensagem += "A relação precisa ser informada!";
        }
        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setNome(nome);
            m_usuario.setEmail(email);
            m_usuario.setCPF(Long.parseLong(CPF));
            m_usuario.setId_relacao(Long.parseLong(relacao));
            m_usuario.setSenha(senha);

            try{
                r_usuario.save(m_usuario);
                mensagem += "Cadastro realizado com sucesso";
            }catch (DataIntegrityViolationException e){
                mensagem += "Algo deu errado, tente novamente";
            }
        }
        return mensagem;
    }
}
