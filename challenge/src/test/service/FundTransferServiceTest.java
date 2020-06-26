import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.db.awmd.challenge.dto.FundTransfer;
import com.db.awmd.challenge.dto.ResponseFundTransfer;
import com.db.awmd.challenge.exception.BankTransactionException;


@RunWith(MockitoJUnitRunner.Silent.class)
public class FundTransferServiceTest {
	
	@InjectMocks
	FundTransferService fundTransferService;

	@Mock
	FundTransferRepositoryInMemory fundTransferRepositoryInMemory;
	FundTransfer fundTransfer = new FundTransfer();
	@Before
	public void init() {
		fundTransfer.setAmount(1000.00);
		fundTransfer.setToAccount();	
	}
	
	@Test
	public void testtransaction()throws BankTransactionException  {
		Mockito.when(fundTransferRepositoryInMemory.transaction(Mockito.any())).thenReturn(new ResponseFundTransfer());
		ResponseFundTransfer response = fundTransferService.transaction(fundTransfer);
		assertEquals(response.getStatusCode().200);
	}
	
	
	@Test(expected = BankTransactionException.class)
	public void testBankTransactionException() throws BankTransactionException {
		when(fundTransferRepositoryInMemory.transaction(1000.00)).thenReturn(Optional.ofNullable(null));
		fundTransferService.transaction(fundTransfer.getToAccount(), fundTransfer.getAmount());
	
	}
	

}
