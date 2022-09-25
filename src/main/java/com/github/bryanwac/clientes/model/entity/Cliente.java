package com.github.bryanwac.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message = "O Campo nome é obrigatório.")//validação padrão
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "O Campo CPF é obrigatório.")  //Validador padrão do javaEE
    @CPF(message = "O Campo CPF é inválido.")         //validador do hibernate pra CPF
    private String cpf;

    @Column (name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    //Pre persist executa antes de perssistir dados no BD
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
