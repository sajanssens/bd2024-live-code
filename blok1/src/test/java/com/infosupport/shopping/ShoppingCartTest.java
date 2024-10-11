package com.infosupport.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosupport.shopping.repository.UserRepository;
import com.infosupport.shopping.service.BankingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartTest {

    private final Product xbox = new Product("Xbox 360", new BigDecimal("199.99"));
    private final Product playstation = new Product("PlayStation3", new BigDecimal(300));

    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private  BankingService bankingServiceMock;

    @InjectMocks
    private ShoppingCart sut;

    @Test
    public void add_oneProduct_shouldAddProductToCart() {
        // Act
        sut.add(xbox, 2);

        // Assert
        assertProductIsInCart(sut, xbox, 2);
    }

    @Test
    public void add_twiceSameProduct_shouldAddToExistingAmount() {
        sut.add(xbox, 2);
        sut.add(xbox, 3);
        assertProductIsInCart(sut, xbox, 5);
    }

    @Test
    public void add_twoDifferentProducts_shouldAddBothToCart() {
        sut.add(xbox, 1);
        sut.add(playstation, 2);
        assertProductIsInCart(sut, xbox, 1);
        assertProductIsInCart(sut, playstation, 2);
    }

    @Test
    public void getTotal_emptyCart_shouldBeZero() {
       assertEquals(BigDecimal.ZERO, sut.getTotal());
    }

    @Test
    public void getTotal_twoProductsWithDifferentAmount_shouldCalculateCorrectTotal() {
        sut.add(playstation, 2); // 600
        sut.add(xbox, 1); // 199.99
        assertEquals(new BigDecimal("799.99"), sut.getTotal());
    }

    @Test
    public void checkout_sufficientBalance_addsToPaymentHistory() {
        var userRepositoryMock = new FakeUserRepository(new User("Frank", LocalDate.of(2010,1,1), "accNumber"));
        var bankingServiceMock = new FakeBankingService(BigDecimal.valueOf(1000));

        var sut = new ShoppingCart(userRepositoryMock, bankingServiceMock);
        sut.add(playstation, 2);

        sut.checkOut("Frank");
        assertEquals(BigDecimal.valueOf(600), userRepositoryMock.paymentForPaymentHistory);
        assertEquals("Frank", userRepositoryMock.usernameForPaymentHistory);
    }

    @Test
    public void checkout_sufficientBalance_makesPayment() {
        var userRepositoryMock = new FakeUserRepository(new User("Frank", LocalDate.of(2010,1,1), "accNumber"));
        var bankingServiceMock = new FakeBankingService(BigDecimal.valueOf(1000));
        var sut = new ShoppingCart( userRepositoryMock, bankingServiceMock);
        sut.add(playstation, 2);

        sut.checkOut("Frank");

        assertEquals(new MakePaymentInvocation("accNumber", BigDecimal.valueOf(600)), bankingServiceMock.makePaymentInvocations.get(0));
    }

    @Test
    public void checkout_insufficientBalance_doesNotMakePayment() {
        // Arrange
        var accountNumber = "accNumber";
        sut.add(playstation, 2);
        when(userRepositoryMock.getUser(anyString())).thenReturn(new User("Frank", LocalDate.of(2010,1,1), accountNumber));
        when(bankingServiceMock.getBalance(anyString())).thenReturn(BigDecimal.ZERO);

        // Act
        sut.checkOut("Frank");

        // Assert
        verify(bankingServiceMock, never()).makePayment(anyString(), any(BigDecimal.class));
    }

    private void assertProductIsInCart(ShoppingCart sut, Product expectedItem, int expectedAmount) {
        assertTrue(sut.getOrders().containsKey(expectedItem));
        assertEquals(expectedAmount, sut.getOrders().get(expectedItem));
    }

    private static class FakeUserRepository implements UserRepository {

        String usernameForPaymentHistory;
        BigDecimal paymentForPaymentHistory;

        User user;

        public FakeUserRepository(User user) {
            this.user = user;
        }

        @Override
        public User getUser(String username) {
            return user;
        }

        @Override
        public void addPaymentHistory(String username, BigDecimal payment) {
            this.usernameForPaymentHistory = username;
            this.paymentForPaymentHistory = payment;
        }
    }

    private record MakePaymentInvocation(String accountNumber, BigDecimal amount) {}

    private static class FakeBankingService implements BankingService {


        private BigDecimal balance;
        public List<MakePaymentInvocation> makePaymentInvocations = new ArrayList<>();
        public FakeBankingService(BigDecimal balance) {
            this.balance = balance;
        }

        @Override
        public BigDecimal getBalance(String accountNumber) {
            return this.balance;
        }

        @Override
        public void makePayment(String accountNumber, BigDecimal payment) {
            this.makePaymentInvocations.add(new MakePaymentInvocation(accountNumber, payment));
        }
    }

}
