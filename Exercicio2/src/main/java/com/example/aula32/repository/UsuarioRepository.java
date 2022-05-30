package com.example.aula32.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import com.example.aula32.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {
    private static String INSERT = "insert into usuario(nome,email,senha) values(?,?,?)";
    private static String SELECT_ALL = "select * from usuario";
    private static String DELETE = "delete from usuario where id =?";
    private static String EDITAR = "update usuario set nome = ?, email = ?, senha = ? where id = ?";
    private static String AUTENTICAR = "select * from usuario where email = ? and senha = ? limit 1";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public record Autenticacao(String email, String senha) {}
//metodo remover
public void delete(int id){
    jdbcTemplate.update(DELETE, id);
}
//metodo remover 
public void delete(Usuario usuario){
    delete(obterPorId(usuario.getId()));
}
//metodo editar
public Usuario edit(Usuario usuario){
    this.jdbcTemplate.update(EDITAR, new Object[]
        {usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getId()});
    return usuario;
}
//metodo inserir
    public Usuario inserir(Usuario usuario) {
        jdbcTemplate.update(INSERT, new Object[] {
                usuario.getNome(), usuario.getEmail(), usuario.getSenha() });
        return usuario;
    }
    //autenticar

    public Usuario obterPorId(int id){
        return jdbcTemplate.queryForObject(SELECT_ALL + " where id = "+ id, new RowMapper<Usuario>() {

            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                    );
            }            
        });
    }
    public Optional<Usuario> autenticar(Autenticacao autenticacao) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    AUTENTICAR,
                    new Object[]{autenticacao.email(), autenticacao.senha()},
                    new int[]{Types.VARCHAR, Types.VARCHAR},
                    (rs, rowNum) -> new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("senha"))));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    public List<Usuario> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Usuario>() {

            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                
                return new Usuario(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha")
                );
            }

        });
    }
}
