package com.produtos.apirest.services;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public ResponseEntity deletarPor(long id){
        return produtoRepository.findById(id).map(prod -> {
                    produtoRepository.delete(prod);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Produto> atualizar (Produto produto){
        return ResponseEntity.ok(produtoRepository.save(produto));
    }

    public ResponseEntity<Produto> inserir(Produto produto){
        return ResponseEntity.ok(produtoRepository.save(produto));
    }
}
