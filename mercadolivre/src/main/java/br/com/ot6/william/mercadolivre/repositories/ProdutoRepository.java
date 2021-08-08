package br.com.ot6.william.mercadolivre.repositories;

import br.com.ot6.william.mercadolivre.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
