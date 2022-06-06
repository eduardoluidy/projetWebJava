package ufrn.br.projetoaulaweb.model;

import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "pessoa_fisica_aud")
public class PessoaFisica extends Pessoa {
    //@Column(nullable = false, unique = true)
    String cpf;
    @Column(nullable = false)
    String rg;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pessoafisica_deficiencia",
            joinColumns = @JoinColumn(name = "pessoafisica_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "deficiencia_id")
    )
    List<Deficiencia> deficiencias;

    //public PessoaFisica(String nome, String email, String telefone, String cpf, String rg, Endereco endereco, List<Deficiencia> deficiencias) {
   //     this();
   // }
}

