package com.sabbado.loja.testes;

import com.sabbado.loja.dao.CategoriaDao;
import com.sabbado.loja.dao.ProdutoDao;
import com.sabbado.loja.modelo.Categoria;
import com.sabbado.loja.modelo.Produto;
import com.sabbado.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        /*Produto p = produtoDao.buscarPorId(1L);
        System.out.println(p);*/

        /*List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todos.forEach(System.out::println);*/

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println("Preço: " + precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria lixo = new Categoria("LIXO");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto celular2 = new Produto("Apple Iphone", "ruim", new BigDecimal("1600"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(lixo);
        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(celular2);

        em.getTransaction().commit();
        em.close();
    }
}
