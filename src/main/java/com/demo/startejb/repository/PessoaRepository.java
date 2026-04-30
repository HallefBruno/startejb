package com.demo.startejb.repository;

import com.demo.startejb.model.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaRepository {

    @PersistenceContext(unitName = "startejbPU")
    private EntityManager em;

    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return em.find(Pessoa.class, id);
    }

    public List<Pessoa> listarTodos() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public void atualizar(Pessoa pessoa) {
        em.merge(pessoa);
    }

    public void remover(Long id) {
        Pessoa p = buscarPorId(id);
        if (p != null) {
            em.remove(p);
        }
    }
}
