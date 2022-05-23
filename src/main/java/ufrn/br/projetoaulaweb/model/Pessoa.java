package ufrn.br.projetoaulaweb.model;

import lombok.*;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import org.hibernate.envers.Audited;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited
//@DiscriminatorColumn(name = "TYPE")
//@Inheritance(strategy = InheritanceType.JOINED)  //por classe
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //tabela unica
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  //por classe contreta

public abstract class Pessoa extends AbstractEntity {
    //@Size(min = 3, max = 40)
    @NotBlank(message = "Nome é obrigatório")
    String nome;
    @Email(message = "Email inválido")
    String email;
    String telefone;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "pessoa")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    Endereco endereco;
}
