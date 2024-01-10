package com.sabbado.loja.testes;

import com.sabbado.loja.dao.CategoriaDao;
import com.sabbado.loja.dao.ClienteDao;
import com.sabbado.loja.dao.PedidoDao;
import com.sabbado.loja.dao.ProdutoDao;
import com.sabbado.loja.modelo.*;
import com.sabbado.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        Produto produto = produtoDao.buscarPorId(1L);
        Produto produto1 = produtoDao.buscarPorId(2L);
        Cliente cliente = clienteDao.buscarPorId(1L);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));
        pedido.adicionarItem(new ItemPedido(5, pedido, produto1));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();
        em.close();
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria lixo = new Categoria("LIXO");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto celular2 = new Produto("Apple Iphone", "ruim", new BigDecimal("1600"), celulares);

        Cliente cliente = new Cliente("Rodrigo", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(lixo);
        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(celular2);
        clienteDao.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
