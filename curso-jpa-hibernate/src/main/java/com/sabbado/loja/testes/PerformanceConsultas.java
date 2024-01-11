package com.sabbado.loja.testes;

import com.sabbado.loja.dao.CategoriaDao;
import com.sabbado.loja.dao.ClienteDao;
import com.sabbado.loja.dao.PedidoDao;
import com.sabbado.loja.dao.ProdutoDao;
import com.sabbado.loja.modelo.*;
import com.sabbado.loja.util.JPAUtil;
import com.sabbado.loja.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PerformanceConsultas {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido = pedidoDao.buscarPedidoComCliente(1L);

        em.close();
        System.out.println(pedido.getCliente().getNome());
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto celular2 = new Produto("Apple Iphone", "ruim", new BigDecimal("1200"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("500"), videogames);
        Produto macbook = new Produto("Macbook", "Macbook Pro", new BigDecimal("200"), informatica);

        Cliente cliente = new Cliente("Rodrigo", "123456");

        Pedido pedido1 = new Pedido(cliente);
        pedido1.adicionarItem(new ItemPedido(10, pedido1, celular));
        pedido1.adicionarItem(new ItemPedido(40, pedido1, celular2));

        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarItem(new ItemPedido(2, pedido2, videogame));
        pedido2.adicionarItem(new ItemPedido(6, pedido2, macbook));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(celular2);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);

        clienteDao.cadastrar(cliente);

        pedidoDao.cadastrar(pedido1);
        pedidoDao.cadastrar(pedido2);

        em.getTransaction().commit();
        em.close();
    }
}
