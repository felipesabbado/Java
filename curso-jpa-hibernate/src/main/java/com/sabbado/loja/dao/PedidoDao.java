package com.sabbado.loja.dao;

import com.sabbado.loja.modelo.Pedido;

import javax.persistence.EntityManager;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }
}
