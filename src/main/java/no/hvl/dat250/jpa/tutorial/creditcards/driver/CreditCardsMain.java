package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Customer customer1 = new Customer();
    customer1.setName("Max Mustermann");

    Address address1 = new Address();
    address1.setStreet("Inndalsveien");
    address1.setNumber(28);

    customer1.setAddresses(Set.of(address1));
    address1.setOwners(Set.of(customer1));

    Pincode pin = new Pincode();
    pin.setPincode("123");
    pin.setCount(1);

    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);
    card1.setPincode(pin);

    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);
    card2.setPincode(pin);

    Bank bank = new Bank();
    bank.setName("Pengebank");
    bank.setOwnedCards(Set.of(card1, card2));

    customer1.setCreditCards(Set.of(card1, card2));
    card1.setBank(bank);
    card2.setBank(bank);

    // PERSIST
    em.persist(customer1);
    em.persist(card1);
    em.persist(card2);
    em.persist(bank);
    em.persist(pin);
    em.persist(address1);
  }


}
