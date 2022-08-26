package ru.netology.javaqa.tickets.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.tickets.repo.TicketRepository;
import ru.netology.javaqa.tickets.ticket.Ticket;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

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
    public void shouldSearchByAirportsIfFewMatches() {

        Ticket[] expected = {card1, card5, card4};
        Ticket[] actual = manager.searchBy("AER", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAirportsIfOneMatch() {

        Ticket[] expected = {card3};
        Ticket[] actual = manager.searchBy("LED", "AER");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAirportsIfNoMatch() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("LED", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }
}
