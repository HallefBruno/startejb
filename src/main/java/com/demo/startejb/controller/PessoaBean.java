package com.demo.startejb.controller;

import com.demo.startejb.model.Pessoa;
import com.demo.startejb.model.Telefone;
import com.demo.startejb.repository.PessoaRepository;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

    @Inject
    private PessoaRepository repository;

    private Pessoa pessoa = new Pessoa();
    private Telefone novoTelefone = new Telefone();

    public void adicionarTelefone() {
        if (pessoa.getTelefones() == null) {
            pessoa.setTelefones(new ArrayList<>());
        }
        pessoa.getTelefones().add(novoTelefone);
        novoTelefone = new Telefone();
    }

    public void salvar() {
        try {
            repository.salvar(pessoa);
            pessoa = new Pessoa();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso", "Pessoa salva com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar"));
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Telefone getNovoTelefone() {
        return novoTelefone;
    }

    public void setNovoTelefone(Telefone novoTelefone) {
        this.novoTelefone = novoTelefone;
    }
}
