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
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String criarConta(@FormParam("nome") String nome, @FormParam("cpf") String cpf) {

        try {
             //return contaCorrenteService.criarConta(nome, cpf);
          ContaCorrente conta = contaCorrenteService.criarConta(nome, cpf);
           return "ok" + conta.toString();

        } catch (ContaInvalidaException e) {
            return "Erro, não foi possivel criar a conta!";
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    @POST
    @Path("/depositar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String depositar(@FormParam("numeroConta") String numeroConta, @FormParam("ValorDeposito") double valor) {
        try {
            contaCorrenteService.depositar(numeroConta, valor);
            return "Deposito no valor de R$ " + valor;
        } catch (ContaInvalidaException e) {
            return "Erro, deposito não realizado";
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    @POST
    @Path("/sacar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String sacar(@FormParam("numeroConta") String numeroConta, @FormParam("ValorSaque") double valorSaque) {
        try {
            contaCorrenteService.sacar(numeroConta, valorSaque);
            return "Saque no valor de R$ " + valorSaque;
        } catch (ContaInvalidaException e) {
            return "Erro, saldo insuficiente";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}




