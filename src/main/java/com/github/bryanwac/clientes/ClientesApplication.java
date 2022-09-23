package com.github.bryanwac.clientes;

import com.github.bryanwac.clientes.model.entity.Cliente;
import com.github.bryanwac.clientes.model.repository.ClienteRepository;
import org.h2.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class ClientesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}
