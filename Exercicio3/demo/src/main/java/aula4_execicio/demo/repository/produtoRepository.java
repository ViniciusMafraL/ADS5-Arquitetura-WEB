package aula4_execicio.demo.repository;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;

import aula4_execicio.demo.entity.Produto;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

public interface produtoRepository extends JpaRepository<Produto,Integer>{
    //Crie um método no ProdutoRepository  que busque todos os produtos por nome que contenham o parâmetro informado.
    List<Produto> findByNomeLike(String nome);
    //Crie um método no ProdutoRepository  que busque todos os produtos com quantidade inferior ou igual a 10.    
    List<Produto> findByQtdeLessThanEqual(Integer qtde);
    //Crie um método em ProdutoRepository que liste todos os produtos ordenados pelo nome de forma ascendente.
    List<Produto> findAllByNomeOrderByNomeAsc(String nome);
    //Crie um método em ProdutoRepository que retorne o top 10 dos produtos com maior quantidade em estoque.
    List<Produto> findTop10ByQtde(Integer qtde);

}
