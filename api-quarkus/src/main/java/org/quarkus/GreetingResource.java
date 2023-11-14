package org.quarkus;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import models.Cliente;
import models.ContaBancaria;
import models.ContaCorrente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/banco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    private Map<String, ContaBancaria> contas = new HashMap<>();

    @POST
    @Path("/cadastrarnovaconta")
    public ContaBancaria cadastrarnovaconta(Cliente cliente) {
        ContaBancaria conta = new ContaBancaria();
        conta.put(conta.getNumeroConta());
        return conta;
    }

//    @POST
//    @Path("/depositar")
//    public ContaBancaria depositar (DepositoRequest request) {
//        ContaBancaria conta = contas.get(request.)
//    }
}




