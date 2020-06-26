import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.awmd.challenge.dto.FundTransfer;
import com.db.awmd.challenge.dto.ResponseFundTransfer;
import com.db.awmd.challenge.exception.BankTransactionException;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FundTransferRepositoryInMemoryTest {
	
	@Autowired
	private FundTransferRepositoryInMemory fundTransferRepositoryInMemory;

	@Test
	public void testtransaction()throws BankTransactionException  {
		FundTransfer fundTransfer=new FundTransfer(11103456,34671786,1000.00);
	
		fundTransferRepositoryInMemory.transaction(fundTransfer);
		assertNotNull(fundTransfer);
	}
}
