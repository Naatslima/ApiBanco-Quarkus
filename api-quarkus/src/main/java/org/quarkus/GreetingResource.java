package org.quarkus;

import GlobalExceptionHandler.ContaInvalidaException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import models.ContaCorrente;
import service.ContaCorrenteService;
import service.ContaCorrenteServiceImpl;

import java.util.ArrayList;

import java.util.List;


@Path("/contacorrente")
public class GreetingResource {
    List<ContaCorrente> contaCorrenteList = new ArrayList<>();
    ContaCorrenteService contaCorrenteService = new ContaCorrenteServiceImpl(contaCorrenteList);

    @POST
    @Path("/cadastrarconta")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String cadastrarconta(@FormParam("nome") String nome, @FormParam("cpf") String cpf) throws ContaInvalidaException {

        try {
            ContaCorrenteService contaService = new ContaCorrenteServiceImpl(contaCorrenteList);
            ContaCorrente contaCorrente = contaService.criarConta(nome, cpf);
            contaCorrenteList.add(contaCorrente);
            cpf.startsWith("contaCorrente");

        } catch (ContaInvalidaException e) {
            return "Erro";
        }
        return nome;
    }

//    @POST
//    @Path("/depositar")
//    public ContaBancaria depositar (DepositoRequest request) {
//        ContaBancaria conta = contas.get(request.)
//    }

}



