package ufrn.br.projetoaulaweb.dtos;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.projetoaulaweb.controller.*;
import ufrn.br.projetoaulaweb.model.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
public class ServidorDtoResponse extends RepresentationModel<ServidorDtoResponse> {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private Endereco endereco;
    private List<Vinculo> vinculos;
    private List<Dependente> dependentes;

    public  ServidorDtoResponse(Servidor servidor){
        this.nome = servidor.getNome();
        this.email = servidor.getEmail();
        this.telefone = servidor.getTelefone();
        this.cpf = servidor.getCpf();
        this.rg = servidor.getRg();
        this.endereco = servidor.getEndereco();
        this.vinculos = servidor.getVinculos();
        this.dependentes = servidor.getDependentes();

        add(linkTo(ServidorController.class).slash(servidor.getId()).withSelfRel());
        add(linkTo(ServidorController.class).withRel("allServidor"));

        this.endereco.add(linkTo(ServidorController.class).slash(endereco.getId()).withSelfRel());
        this.endereco.add(linkTo(ServidorController.class).withRel("allEnderecos"));

       // this.vinculos.add(linkTo(VinculoController.class).slash(vinculos.getId()).withSelfRel());
        //this.vinculos.add(linkTo(VinculoController.class).withRel("allVinculos"));

 
        if(!servidor.getDependentes().isEmpty()) {
            int cont = 0;
            for (Vinculo vinculo : servidor.getVinculos()) {
                this.vinculos.get(cont).add(linkTo(DeficienciaController.class).slash(vinculo.getId()).withSelfRel());
                this.vinculos.get(cont).add(linkTo(DeficienciaController.class).withRel("allVinculos"));
                cont++;
            }
        }
    }
}
