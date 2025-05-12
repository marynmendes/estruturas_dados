package Prova2024;

import java.time.LocalDate;

public interface ListaReservas {
    void adicionarReserva (LocalDate dataEntrada, LocalDate dataSaida, String nomeCliente, String[] servicosAdicionais);
    Object procurarReserva (String nomeCliente);
    Object[] procurarPorData (LocalDate data);
    void atualizarReserva (Object reserva, LocalDate novaDataEntrada, LocalDate novaDataSaida);
    Object cancelarReserva (Object reserva);
    boolean vagaPorData (LocalDate data);

    String imprimirReservas();
}

