package com.produtos.apirest.controller;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.services.ProdutoService;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> listarProdutos(){
        return produtoService.listarTodos();
    }

    @PostMapping("/inserir")
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletarPor(Long id){
        return produtoService.deletarPor(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Produto> atualizar (Produto produto){
        return produtoService.atualizar(produto);
    }






}
