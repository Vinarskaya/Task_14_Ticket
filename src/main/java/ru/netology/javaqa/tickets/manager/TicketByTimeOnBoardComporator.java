package ru.netology.javaqa.tickets.manager;

import ru.netology.javaqa.tickets.ticket.Ticket;

import java.util.Comparator;

public class TicketByTimeOnBoardComporator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTimeOnBoard() - o2.getTimeOnBoard();
    }
}