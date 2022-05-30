package aula4_execicio.demo.repository;
import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;

import aula4_execicio.demo.entity.Categoria;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface categoriaRepository extends JpaRepository<Categoria,Integer> {
    //.Crie um método na CategoriaRepository que busque todos as categorias por nome que contenham o parâmetro passado.
    List<Categoria> findByNome(String nome);
    //Crie um método na CategoriaRepository que traga a categoria filtrada pelo ID que será informado, além dos dados da categoria traga também a lista dos produtos que pertencem aquela categoria.
    @Query("select c from Categoria c left join c.produto where c.id = :id")
    List<Categoria> findCategoriaByIdProdutos(@Param("id") int id);
     //Crie um método em CategoriaRepository que retorne a quantidade de produtos de um categoria. Será passado o ID como parâmetro.
     @Query("SELECT COUNT(u) FROM Produto u WHERE u.categoria=:categoria")
    long CountProdutos(@Param("categoria") Categoria categoria);
}
