package aula4_execicio.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aula4_execicio.demo.entity.Categoria;
import aula4_execicio.demo.entity.Produto;
import aula4_execicio.demo.repository.categoriaRepository;
import aula4_execicio.demo.repository.produtoRepository;

@SpringBootApplication
public class DemoApplication {
	@Bean
	public CommandLineRunner init (@Autowired produtoRepository ProdutoRepository,
									@Autowired categoriaRepository CategoriaRepository){
		return args -> {
			Categoria pAdmin = new Categoria(0, "categoriateste","descricaoteste");
			CategoriaRepository.inserir(pAdmin);



			Produto produto1 = new Produto(0, "produto1", "3");
			Produto produto2 = new Produto(0, "produto2", "1");			
			produto1.setCategoria(pAdmin);
			produto2.setCategoria(pAdmin);
			ProdutoRepository.inserir(produto1);
			ProdutoRepository.inserir(produto2);
			List<Produto> listaProdutos = ProdutoRepository.obterTodos();
			listaProdutos.forEach(System.out::println);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
