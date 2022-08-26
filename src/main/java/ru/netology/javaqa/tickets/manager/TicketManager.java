package ru.netology.javaqa.tickets.manager;

import ru.netology.javaqa.tickets.repo.TicketRepository;
import ru.netology.javaqa.tickets.ticket.Ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repo) {
        this.repository = repo;
    }

    public void add(Ticket card) {
        repository.save(card);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket card: repository.findAll()) {
            if (matches(card, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = card;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matches(Ticket card, String from, String to) {
        if (card.getDepartureAirport().contains(from) && card.getArrivalAirport().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
