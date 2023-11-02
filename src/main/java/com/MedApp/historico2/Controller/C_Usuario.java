package com.MedApp.historico2.Controller;

import com.MedApp.historico2.Service.S_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Usuario {

    @GetMapping("/")
    public String getLogin(HttpSession session){
        if(session.getAttribute("usuario") != null) {
            return "redirect:/Home";
        }else{
            return "Usuario/index";
        }
    }
    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestParam("CPF") String CPF,
                             @RequestParam("senha") String senha,
                             HttpSession session){
        session.setAttribute("usuario", S_Usuario.verificaLogin(CPF, senha));
        if(session.getAttribute("usuario") == null){
            return false;
        }else{
            return true;
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuario", null);
        return "redirect:/";
    }

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "Usuario/cadastro";
    }
    @PostMapping("/cadastro")
    @ResponseBody
    public String cadastrarUsuario(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("CPF") String CPF,
                                   @RequestParam("senha") String senha,
                                   @RequestParam("relacao")String relacao) {
        return S_Usuario.cadastrarUsuario(nome, email, CPF, senha, relacao);
    }
}
