package aula4_execicio.demo.repository;
//import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import aula4_execicio.demo.entity.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class categoriaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria inserir(Categoria categoria){
        entityManager.persist(categoria);
        return categoria;
    }

    @Transactional
    public Categoria atualizar(Categoria categoria){
        entityManager.merge(categoria);
        return categoria;
    }

    @Transactional
    public void excluir(Categoria categoria){
        entityManager.remove(categoria);
    }

    @Transactional
    public void excluir(int id){
        excluir(entityManager.find(Categoria.class, id));
    }

    /*@Transactional(readOnly = true)
    public List<Categoria> obterPorNome(String nome){
        String jpql = "select u from u where u.nome like :nome";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
        query.setParameter("nome", "%" + nome  + "%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Categoria> obterTodos(){
          return entityManager.createQuery(" from Categoria", Categoria.class).getResultList();        
    }*/
}