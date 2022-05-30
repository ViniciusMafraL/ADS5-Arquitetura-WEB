package aula4_execicio.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(length = 100)
    private String nome;
    private String qtde;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    public Produto(int id, String nome, String qtde) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
    }
    public Produto() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getQtde() {
        return qtde;
    }
    public void setQtde(String qtde) {
        this.qtde = qtde;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

