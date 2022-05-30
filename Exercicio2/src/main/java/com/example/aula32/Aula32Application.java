package com.example.aula32;

import java.util.List;

import com.example.aula32.entity.Usuario;
import com.example.aula32.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula32Application {
@Bean
public CommandLineRunner init (@Autowired UsuarioRepository usuarioRepository){
	return args ->{
		usuarioRepository.inserir(new Usuario(0,"teste","teste@teste","123"));
		usuarioRepository.inserir(new Usuario(0,"teste2","teste@teste2","123456"));
		usuarioRepository.delete(3);
		List<Usuario> listaUsuarios = usuarioRepository.obterTodos();
		listaUsuarios.forEach(System.out::println);
	};
}
	public static void main(String[] args) {
		SpringApplication.run(Aula32Application.class, args);
	}

}
