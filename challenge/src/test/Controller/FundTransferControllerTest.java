import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.db.awmd.challenge.dto.FundTransfer;
import com.db.awmd.challenge.exception.BankTransactionException;




@RunWith(MockitoJUnitRunner.Silent.class)
public class FundTransferControllerTest {
	
	@InjectMocks
	FundTransferController fundTransferController;

	@Mock
	FundTransferService fundTransferService;
	@Test
	public void testtransaction()throws BankTransactionException  {
		Mockito.when(fundTransferService.transaction(Mockito.any())).thenReturn(new ResponseFundTransfer());
		Integer actual = fundTransferController.transaction(fundTransfer).getStatusCode();
		Integer expected = 200;
		assertEquals(expected, actual);
		
	}
	
	
	@Test(expected = BankTransactionException.class)
	public void testBankTransactionException() throws BankTransactionException {
		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.setAmount("");
		fundTransferController.transaction(fundTransfer);
	}
	

}
