package com.sabbado.loja.testes;

import com.sabbado.loja.dao.CategoriaDao;
import com.sabbado.loja.dao.ProdutoDao;
import com.sabbado.loja.modelo.Categoria;
import com.sabbado.loja.modelo.Produto;
import com.sabbado.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TesteCriteria {

    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        List<Produto> produtos = produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());
        produtos.forEach(System.out::println);
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto celular2 = new Produto("Apple Iphone", "ruim", new BigDecimal("1200"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("500"), videogames);
        Produto macbook = new Produto("Macbook", "Macbook Pro", new BigDecimal("200"), informatica);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(celular2);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);

        em.getTransaction().commit();
        em.close();
    }
}
