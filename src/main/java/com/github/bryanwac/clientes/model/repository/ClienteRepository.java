package com.github.bryanwac.clientes.model.repository;


import com.github.bryanwac.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
