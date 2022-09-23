package com.github.bryanwac.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data // Cria métodos necessarios pra classe
@NoArgsConstructor //Construtor padrão
@AllArgsConstructor //Construtor completo
@Builder // Permite builder do lombok pra instanciar de forma mais facil
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column (name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    //Pre persist executa antes de perssistir dados no BD
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}