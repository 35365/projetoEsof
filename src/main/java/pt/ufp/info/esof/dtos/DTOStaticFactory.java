package pt.ufp.info.esof.dtos;

import pt.ufp.info.esof.modelos.Empregado;
import pt.ufp.info.esof.modelos.Projeto;
import pt.ufp.info.esof.modelos.Tarefa;

/**
 * Fábrica estática para criação de DTO's
 * É implementada em conjunto com o padrão Singleton
 */
public class DTOStaticFactory {

    /**
     *
     * Implementa a lógica necessária para garantir uma única instância da fábrica estática
     */
    private static DTOStaticFactory dtoAbstractFactory;

    public static DTOStaticFactory getInstance(){
        if(dtoAbstractFactory==null){
            dtoAbstractFactory=new DTOStaticFactory();
        }
        return dtoAbstractFactory;
    }

    public EmpregadoDTO empregadoDTO(Empregado empregado){
        return EmpregadoDTO.builder()
                .username(empregado.getUsername())
                .build();
    }

    public TarefaDTO tarefaDTO(Tarefa tarefa){
        return TarefaDTO.builder()
                .nome(tarefa.getNome())
                .build();
    }

    public ProjetoDTO projetoDTO(Projeto projeto){
        return ProjetoDTO.builder()
                .nome(projeto.getNome())
                .build();
    }

    public ProjetoValorDTO projetoValorDTO(Projeto projeto){
        return ProjetoValorDTO.builder()
                .valor(projeto.valorEstimado())
                .build();
    }
    public ProjetoTempoDTO projetoTempoDTO(Projeto projeto){
        return ProjetoTempoDTO.builder()
                .tempo(projeto.tempoEstimado())
                .build();
    }


}
