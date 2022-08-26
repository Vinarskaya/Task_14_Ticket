package ru.netology.javaqa.tickets.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.tickets.repo.TicketRepository;
import ru.netology.javaqa.tickets.ticket.Ticket;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketByTimeOnBoardComporator comparator = new TicketByTimeOnBoardComporator();

    Ticket card1 = new Ticket (1, 10_000, "AER", "VKO", 230);
    Ticket card2 = new Ticket (2, 6_000, "VKO", "LED", 110);
    Ticket card3 = new Ticket (3, 12_000, "LED", "AER", 300);
    Ticket card4 = new Ticket (4, 15_000, "AER", "VKO", 240);
    Ticket card5 = new Ticket (5, 13_000, "AER", "VKO", 250);


    @BeforeEach
    public void setup() {
        manager.add(card1);
        manager.add(card2);
        manager.add(card3);
        manager.add(card4);
        manager.add(card5);
    }

    @Test
    public void shouldFindByAirportsIfFewMatches() {

        Ticket[] expected = {card1, card4, card5};
        Ticket[] actual = manager.findAll("AER", "VKO", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirportsIfOneMatch() {

        Ticket[] expected = {card3};
        Ticket[] actual = manager.findAll("LED", "AER", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirportsIfNoMatch() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "VKO", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
