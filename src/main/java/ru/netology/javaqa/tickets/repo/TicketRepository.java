package ru.netology.javaqa.tickets.repo;

import ru.netology.javaqa.tickets.ticket.Ticket;

public class TicketRepository {

    private Ticket[] cards = new Ticket[0];

    public void save(Ticket card) {
        Ticket[] tmp = new Ticket[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            tmp[i] = cards[i];
        }
        tmp[tmp.length - 1] = card;
        cards = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[cards.length - 1];
        int copyToIndex = 0;
        for (Ticket card : cards) {
            if (card.getId() != id) {
                tmp[copyToIndex] = card;
                copyToIndex++;
            }
        }
        cards = tmp;
    }

    public Ticket[] findAll() {
        return cards;
    }

}
